package com.yrf.controller;

import com.yrf.domain.mysql.Users;
import com.yrf.domain.mongo.LxrDetail;
import com.yrf.domain.mongo.Lxrs;
import com.yrf.service.LxrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class LxrsController {

    @Autowired
    private LxrsService lxrsService;


    @RequestMapping(value = "/lxrs/addlxr",method = RequestMethod.POST)
    public String addlxr(@RequestParam("lxrname") String lxrname,@RequestParam("lxrtel") String lxrtel,@RequestParam("status") String status, HttpSession session){

        String uname = ((Users)session.getAttribute("myUser")).getUname();

        Lxrs lxrs = new Lxrs();
        lxrs.setUname(uname);
        lxrs.setNum(1);
        LxrDetail lxrDetail = new LxrDetail(lxrname,lxrtel,new Date(),Integer.parseInt(status));
        List<LxrDetail> lxrDetails = new ArrayList<>();
        lxrDetails.add(lxrDetail);
        lxrs.setLxrDetails(lxrDetails);
        boolean isSucc = lxrsService.addLxr(lxrs);

        if(isSucc){
            return "redirect:/succ.jsp";
        }else{
            return "redirect:/fail.jsp";
        }

    }

    @RequestMapping(value = "/lxrs/search")
    public String findall(HttpSession session){
        String uname = ((Users)session.getAttribute("myUser")).getUname();
       // System.out.println(uname);
        List<LxrDetail> lxrList = lxrsService.findByAll(uname);
        session.setAttribute("lxrList",lxrList);
       // System.out.println(lxrList.get(0).getLxrname());
        return "redirect:/searchlxr.jsp";
    }

    @RequestMapping(value = "/lxrs/modify")
    public String modifyauthority(@RequestParam("text") String text,@RequestParam("select") String select,@RequestParam("modify") String modify,HttpSession session){

        String uname = ((Users)session.getAttribute("myUser")).getUname();
        boolean isSucc = lxrsService.updateLxrs(text,select,modify,uname);
        if(isSucc){
            return "redirect:/main.jsp";
        }else{
            return "redirect:/fail.jsp";
        }
    }


    @RequestMapping(value = "/lxrs/del")
    public String del(@RequestParam("text") String text,@RequestParam("select") String select,HttpSession session){
        System.out.println(text);
        System.out.println(select);
        String uname = ((Users)session.getAttribute("myUser")).getUname();
        boolean isSucc = lxrsService.delLxrs(text,select,uname);
        if(isSucc){
            return "redirect:/main.jsp";
        }else{
            return "redirect:/fail.jsp";
        }
    }

}
