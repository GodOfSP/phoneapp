package com.ybveg.ls.phoneapp.controller;


import com.ybveg.ls.phoneapp.module.pojo.BaseResult;
import com.ybveg.ls.phoneapp.module.service.PhoneDetailService;
import com.ybveg.ls.phoneapp.module.service.impl.PhoneDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取手机详情
 */


@RestController
public class GetPhonedDetailServlet {


    private static final long serialVersionUID = 1L;
    @Autowired
    PhoneDetailServiceImpl phoneService;
    @Autowired
    BaseResult baseResult;

    @PostMapping("/getPhonedDetail")
    private BaseResult doAll(String phoneId) throws IOException {

        try {
            baseResult.setData(phoneService.getPhoneDetail(phoneId));
            baseResult.setMsg("查询成功");
            baseResult.setCode("200");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baseResult;
    }
}
