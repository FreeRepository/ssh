package com.welljoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.welljoint.entity.User;
import com.welljoint.service.LoginService;
//import com.welljoint.service.LoginServiceImpl;

@Controller  //注解为控制器
@RequestMapping(value="/login")    //截获带有/login的请求
public class LoginController {

    @Autowired
    LoginService loginService;  //注入service层

    @RequestMapping(method=RequestMethod.GET)
    public String get(){  //用来返回一个页面
        return "login";  //返回指向login.jsp页面
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String post(User user){  //用来处理用户的登陆请求
//    	LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
//    	if (loginServiceImpl.login(user.getUserName(), user.getPassword()) == 1) {
//			return "login_success"; //登陆成功，跳转到login_success.jsp页面
//		}
    	/* 上面是不用注解自己写接口实现类的方法, 下面是用spring注解实现接口的方法 */
        if (loginService.login(user.getUserName(), user.getPassword())==1) {
            return "login_success";  //登陆成功，跳转到login_success.jsp页面
        }
        return "login";
    }
}
