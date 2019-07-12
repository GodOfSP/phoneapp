package com.ybveg.ls.phoneapp.controller;


import com.ybveg.ls.phoneapp.module.pojo.BaseResult;
import com.ybveg.ls.phoneapp.module.pojo.User;
import com.ybveg.ls.phoneapp.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登陆注册
 */

@RestController

public class RegistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Autowired
    UserService service;
    @Autowired
    BaseResult baseResult;

    @PostMapping("regist")
    public BaseResult doPost(String userName, String password) {

        String userId = null;
        String msg = "";
        String code = "200";

        try {
            userId = service.getUserId(userName);
            if (StringUtils.isEmpty(userId)) { // 用户不存在 就注册
                User user = new User(userName, password);

                try {
                    boolean b = service.saveUser(user);
                    if (b) {
                        msg = "注册成功!";

                    } else {
                        msg = "注册失败!";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    msg = "注册失败!";
                }
                baseResult.setData(service.getUserId(userName));
            } else { //用户存在 就登陆

                if (service.getUserPassword(userName).equals(password)) {
                    msg = "登录成功!";
                } else {
                    msg = "密码错误!";
                    code = "500";
                }
                baseResult.setData(userId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        baseResult.setCode(code);
        baseResult.setMsg(msg);

        return baseResult;
    }

}
