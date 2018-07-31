package com.tqh.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String id , String psw, HttpServletRequest request) {

        String loginName =id;
        String password=psw;
        logger.info("准备登陆用户 => {}", loginName);
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
        //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
        //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
        logger.info("对用户[" + loginName + "]进行登录验证..验证开始");
        currentUser.login(token);
        logger.info("对用户[" + loginName + "]进行登录验证..验证通过");

        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            logger.info("用户[" + loginName + "]登录认证通过"+" sessionID:"+currentUser.getSession().getId().toString());
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            // 获取保存的URL
            if (savedRequest == null || savedRequest.getRequestUrl() == null) {
                return "redirect:/index";
            }
            //跳转到登陆之前的页面
            return "redirect:" + savedRequest.getRequestUrl();

        } else {
            token.clear();
            return "redirect:/login";
        }
    }

    @RequestMapping("/index")
    public String loginSuccess(){
        return "index";
    }


    @RequestMapping("/403")
    public String accessFault(){
        return "403";
    }

    @RequiresRoles("user")
    @RequestMapping("/test")
    public String accessTest(){
        return "test";
    }
}
