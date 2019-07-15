package com.ybveg.ls.phoneapp.controller;


import com.ybveg.ls.phoneapp.module.pojo.BaseResult;
import com.ybveg.ls.phoneapp.module.service.PhoneService;
import com.ybveg.ls.phoneapp.module.service.impl.PhoneServiceImpl;
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
 * 获取手机列表
 */


@RestController
public class GetPhoneListServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    @Autowired
    PhoneServiceImpl phoneService;
    @Autowired
    BaseResult baseResult;
    @PostMapping("/getPhoneList")
    private BaseResult doAll(){

        try {
            baseResult.setData(phoneService.getPhoneList());
            baseResult.setCode("200");
            baseResult.setMsg("查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResult;
    }
}
