package com.it;

import cn.hutool.core.date.DateTime;
import cn.hutool.extra.ftp.Ftp;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Struct;
import java.util.*;

@Slf4j
@Component
public class FTPUtil {

    private static String host = "192.168.211.1";
    private static Integer port = 21;
    private static String user = "Administrator";
    private static String pwd = "930828";

//    @Value("${ftp.host}")
//    public void setHost(String host) {
//        FTPUtil.host = host;
//    }
//
//    @Value("${ftp.port}")
//    public void setPort(Integer port) {
//        FTPUtil.port = port;
//    }
//
//    @Value("${ftp.user}")
//    public void setUser(String user) {
//        FTPUtil.user = user;
//    }
//
//    @Value("${ftp.pwd}")
//    public void setPwd(String pwd) {
//        FTPUtil.pwd = pwd;
//    }


    /**
     * 创建ftp连接
     **/
    public static Ftp create() {
        Ftp ftp = null;
        try {
            port = Objects.isNull(port) ? Ftp.DEFAULT_PORT : port;
            ftp = StringUtils.isEmpty(user) && StringUtils.isEmpty(pwd)
                    ? new Ftp(host, port)
                    : new Ftp(host, port, user, pwd);
        } catch (Exception e) {
            log.error("创建ftp链接失败：{}", e);
        }
        if (ftp == null) {
            throw new RuntimeException("连接FTP服务器失败,请检查配置是否正确");
        }
        //防止客户端读取文件为空
        ftp.getClient().enterLocalPassiveMode();
        return ftp;
    }


    /**
     * ftp文件批量下载
     **/
    public static List<File> download(Ftp ftp, String path) {
        try {
            List<File> files = new ArrayList<>();
            ftp.cd(path);
            List<String> ftpFiles = ftp.ls(ftp.pwd());
            log.info("文件列表为{}", JSON.toJSONString(ftpFiles));
            if (!CollectionUtils.isEmpty(ftpFiles)) {
                ftpFiles.stream().forEach(e -> {
                    //新建文件
                    File file = new File(e);
                    if (!file.exists()) {
                        if (!Objects.isNull(file.getParentFile()) &&
                                !file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        try {
                            file.createNewFile();
                        } catch (IOException ex) {
                            log.error("创建文件异常：{}", e);
                        }
                    }
                    ftp.download(path, e, file);
                    files.add(file);
                });
                return files;
            }
        } catch (Exception e) {
            log.error("批量下载文件异常：{}", e);
        }
        return null;
    }

    /**
     * ftp文件上传
     **/
    public static boolean upload(Ftp ftp, String fileName, String path, File file) {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
        if (!ftp.exist(path)) {
            ftp.mkdir(path);
        }
        ftp.upload(path, fileName, file);
        ftp.toParent();
        return true;
    }

    /**
     * 上传InputStream文件
     **/
    public static boolean uploadRecord(Ftp ftp, String fileName, String path, InputStream inputStream) {
        try {
            if (!ftp.exist(path)) {
                ftp.mkDirs(path);
            }
            // 目录存在开始上传
            if (ftp.exist(path)) {
                ftp.upload(path, fileName, inputStream);
            }
        } catch (Exception e) {
            log.error("文件上传失败: {}", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("关闭InputStream失败：{}", e);
                }
            }
            close(ftp);
        }
        return true;
    }


    /**
     * 关闭ftp连接
     **/
    public static void close(Ftp ftp) {
        try {
            if (!Objects.isNull(ftp)) {
                ftp.close();//断开连接
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 判断ftp服务器文件是否存在
    public static boolean existFile(String path) throws IOException {
        Ftp ftp = create();
        FTPClient ftpClient = ftp.getClient();
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 路径分隔符
     */
    private static final String SEPARATOR_STR = "/";

    /**
     * 点
     */
    private static final String DOT_STR = ".";


    public static void queryFTPAllChildrenDirectory(Map<String, String> storeDataMap,
                                                    List<String> alreadyQueriedDirList,
                                                    List<String> requiredQueryDirList) throws IOException {
        Ftp ftp = create();
        FTPClient ftpClient = ftp.getClient();
        List<String> newRequiredQueryDirList = new ArrayList<>(16);
        if (requiredQueryDirList.size() == 0) {
            return;
        }
        for (String str : requiredQueryDirList) {
            String rootLocalDir = storeDataMap.get(str);
            // 获取rootRemoteDir目录下所有 文件以及文件夹(或  获取指定的文件)
            FTPFile[] ftpFiles = ftpClient.listFiles(str);
            for (FTPFile file : ftpFiles) {
                if (file.isDirectory()) {
                    String tempName = file.getName();
                    String ftpChildrenDir = str.endsWith(SEPARATOR_STR) ?
                            str + tempName :
                            str + SEPARATOR_STR + tempName;
                    String localChildrenDir = rootLocalDir.endsWith(SEPARATOR_STR) ?
                            rootLocalDir + tempName :
                            rootLocalDir + SEPARATOR_STR + tempName;
                    alreadyQueriedDirList.add(ftpChildrenDir);
                    newRequiredQueryDirList.add(ftpChildrenDir);
                    storeDataMap.put(ftpChildrenDir, localChildrenDir);
                }
            }
        }
        queryFTPAllChildrenDirectory(storeDataMap, alreadyQueriedDirList, newRequiredQueryDirList);
    }

    /**
     * 根据给出的FTP目录,查询其所有子目录以及子文件(含其自身)
     *
     * @param alreadyQueriedDirList  所有已经查询出来了的目录
     * @param alreadyQueriedFileList 所有已经查询出来了的文件
     * @param requiredQueryDirList   还需要查询的FTP目录
     * @throws IOException IO异常
     * @date 2018年9月27日 上午12:12:53
     */
    private static void queryAllChildrenDirAndChildrenFile(List<String> alreadyQueriedDirList,
                                                           List<String> alreadyQueriedFileList,
                                                           List<String> requiredQueryDirList) throws IOException {
        List<String> newRequiredQueryDirList = new ArrayList<>(16);
        if (requiredQueryDirList.size() == 0) {
            return;
        }
        Ftp ftp = create();
        FTPClient ftpClient = ftp.getClient();
        for (String dirPath : requiredQueryDirList) {
            // 获取dirPath目录下所有 文件以及文件夹(或  获取指定的文件)
            FTPFile[] ftpFiles = ftpClient.listFiles(dirPath);
            for (FTPFile file : ftpFiles) {
                String tempName = file.getName();
                String ftpChildrenName = dirPath.endsWith(SEPARATOR_STR) ?
                        dirPath + tempName :
                        dirPath + SEPARATOR_STR + tempName;
                if (file.isDirectory()) {
                    alreadyQueriedDirList.add(ftpChildrenName);
                    newRequiredQueryDirList.add(ftpChildrenName);
                } else {
                    alreadyQueriedFileList.add(ftpChildrenName);
                }
            }

        }
        queryAllChildrenDirAndChildrenFile(alreadyQueriedDirList, alreadyQueriedFileList, newRequiredQueryDirList);
    }


    public static void main(String[] args) throws IOException {
        Ftp ftp = create();
        // 上传
//        upload(ftp,"a.jpg","/test",new File("D:\\b.jpg"));
        // 下载
        ftp.download("/test/a.jpg", new File("D:\\c.jpg"));
        // 判断文件是否存在
        boolean flag = existFile("/test/b.jpg");
        System.out.println(flag);
        // 递归遍历文件夹
        List<String> alreadyQueriedDirList = new ArrayList<>(); // 已经查询过的文件夹集合
        List<String> requiredQueryDirList = new ArrayList<>(); // 需要查询的文件夹集合
        List<String> alreadyQueriedFileList = new ArrayList<>(); // 已经查询到的文件名集合
        requiredQueryDirList.add("/test");
        queryAllChildrenDirAndChildrenFile(alreadyQueriedDirList, alreadyQueriedFileList, requiredQueryDirList);

    }

}
