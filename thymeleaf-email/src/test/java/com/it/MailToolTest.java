package com.it;

import com.it.util.MailTool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailToolTest {
    @Autowired
    private MailTool mailTool;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sendSimpleMail() {
//        String[] filePathList = new String[]{"文件地址1","文件地址2","文件地址3"};
//        Map<String, Object> valueMap = new HashMap<String, Object>();
//        valueMap.put("to", new String[]{"1245852818@qq.com.com"});
//        valueMap.put("title", "测试邮件标题");
//        valueMap.put("content","测试邮件内容");
//        valueMap.put("filePathList", filePathList);
//        mailTool.sendSimpleMail(valueMap);

        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("to", new String[]{"1245852818@qq.com.com"});
        valueMap.put("title", "测试邮件标题");
        valueMap.put("content", "测试邮件内容");
        // 调用发送邮件的方法
        mailTool.sendSimpleMail(valueMap);
    }
}
