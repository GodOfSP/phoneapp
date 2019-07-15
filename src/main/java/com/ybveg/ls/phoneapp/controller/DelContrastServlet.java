package com.ybveg.ls.phoneapp.controller;



import com.ybveg.ls.phoneapp.module.dao.impl.delContrastDaoImpl;
import com.ybveg.ls.phoneapp.module.pojo.BaseResult;
import com.ybveg.ls.phoneapp.module.service.delContastService;
import com.ybveg.ls.phoneapp.module.service.impl.delContrastServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 删除对比
 */
@RestController
public class DelContrastServlet {

    @Autowired
    private delContrastServiceImpl delContastService ;
    @Autowired
    BaseResult baseResult;


    @PostMapping("/delContrast")
    private BaseResult doAll(String cId) {

        baseResult.setCode("200");
        try {
           baseResult.setData(delContastService.delContrast(cId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseResult.setMsg("删除成功");
        return  baseResult;
    }
}