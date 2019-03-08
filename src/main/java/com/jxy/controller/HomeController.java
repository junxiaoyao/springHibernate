package com.jxy.controller;

import com.jxy.hEntity.Role;
import com.jxy.service.RoleServiceRe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ybl
 * @Date: 2018/12/14 0014 11:07
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private RoleServiceRe roleServiceRe;
    @RequestMapping(method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
        Map<String, Object> user = new HashMap<>();
        user.put("userName", "jxy");
        model.addAttribute("user", user);
        return "homePage";
    }

    @RequestMapping("login")
    public String loginGet(HttpServletRequest request) {
        return "login";
    }

}
