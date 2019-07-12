package com.ybveg.ls.phoneapp.controller;

import com.ybveg.ls.phoneapp.module.pojo.BaseResult;
import com.ybveg.ls.phoneapp.module.service.getContrastListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取对比列表
 */

@RestController
public class GetContrastListServlet {

    @Autowired
    private getContrastListService contrastListService;
    @Autowired
    private BaseResult baseResult;

    @PostMapping("/getContrastList")
    private void  doAll(String userId)  {

        baseResult.setMsg("查询成功");
        baseResult.setCode("200");
        try {
            baseResult.setData(contrastListService.getContrastList(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
