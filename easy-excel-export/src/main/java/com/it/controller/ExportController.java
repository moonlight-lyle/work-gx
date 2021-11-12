package com.it.controller;

import com.it.service.ExportExcelService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/export")
public class ExportController {

    @Resource
    private ExportExcelService exportExcelService;

    @RequestMapping("/test")
    public void test(HttpServletResponse response) {
        try {
            System.out.println("============测试开始=============");
            exportExcelService.exportStudentInfoExcel(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
