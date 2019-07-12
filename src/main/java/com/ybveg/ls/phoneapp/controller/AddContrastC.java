package com.ybveg.ls.phoneapp.controller;


import com.ybveg.ls.phoneapp.module.pojo.BaseResult;
import com.ybveg.ls.phoneapp.module.service.AddContrastService;
import com.ybveg.ls.phoneapp.module.service.impl.AddContrastServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 添加到对比列表
 */


@RestController()
public class AddContrastC {

    @Autowired
    private AddContrastService contrastService;

    @Autowired
    BaseResult baseResult;


    //获取当前用户的对比列表数量
    @GetMapping("/addContrast")
    protected BaseResult doGet(String userId) {
        String res = "";
        String msg = "";
        try {
            res = contrastService.getContrastNum(userId);
            if (res == "") {
                res = "0";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "操作失败!";
        }
        baseResult.setCode("200");
        baseResult.setData(res);
        baseResult.setMsg(msg);

        return baseResult;
    }


    //给当前用户添加对比
    @PostMapping("/addContrast")
    private BaseResult addAll(String userId,String phoneId){

        int res = 0;
        String msg = "";
        try {
            res = contrastService.addContrast(userId,phoneId);
            if (res == 1) {
                msg = "操作成功!";
            } else {
                msg = "操作1失败!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "操作失败,重复添加 !";
        }


        baseResult.setCode("200");
        baseResult.setData(res);
        baseResult.setMsg(msg);

        return baseResult;
    }
}
