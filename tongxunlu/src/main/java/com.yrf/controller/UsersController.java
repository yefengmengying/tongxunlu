package com.yrf.controller;

import com.yrf.domain.mysql.Users;
import com.yrf.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;


    @RequestMapping(value = "/users/login",method = RequestMethod.POST)
    public String isLogin(@RequestParam("uname") String uname,@RequestParam("upwd") String upwd, HttpSession session){
        //System.out.println(uname+"   "+upwd );
        Users myUser = usersService.findByUName(uname);
        String pwd = usersService.getMD5(upwd);
       // System.out.println(pwd);
        if(myUser != null){
            if(myUser.getUpwd().equals(pwd)){
                if (myUser.getAuthority()==1) {
                    session.setAttribute("myUser", myUser);
                    return "redirect:/main.jsp";
                }
                if (myUser.getAuthority()==2) {
                    session.setAttribute("myUser", myUser);
                    return "redirect:/manger.jsp";
                }
            }
        }
        return "redirect:/fail.jsp";
    }

    @RequestMapping(value = "/users/res",method = RequestMethod.POST)
    public String Resgister(@RequestParam("uname") String uname,@RequestParam("upwd") String upwd, HttpSession session){
        Users myUser = new Users();
        myUser.setUname(uname);
        myUser.setUpwd(upwd);
        if(usersService.addUsers(myUser)){
            return "redirect:/login.jsp";
        }
        return "redirect:/fail.jsp";
    }



    @RequestMapping(value = "/users/findallunusers")
    public String findallunusers(HttpSession session){
        List<Users> usersList =  usersService.findByAll(0);
        session.setAttribute("usersList",usersList);
        return "redirect:/Unuser.jsp";
    }

    @RequestMapping(value = "/users/findall")
    public String findall(HttpSession session){
        List<Users> usersList =  usersService.findByAll(1);
        session.setAttribute("usersList",usersList);
        return "redirect:/passuser.jsp";
    }

    @RequestMapping(value = "/users/modify")
    public String modifyauthority(@RequestParam("uname") String uname,@RequestParam("select") String select){
        //System.out.println(uname);
       // System.out.println(select);
        int sel = Integer.parseInt(select);
        if (usersService.updateUsers(uname,sel)){
            return "redirect:/manger.jsp";
        }
        return "redirect:/fail.jsp";
    }

}
