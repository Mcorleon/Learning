package com.tqh.controller;

import com.tqh.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HelloController {

    @RequestMapping(value = "/showHello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "tqh");
        return "hello";//去找hello.jsp
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student() {
        return "student";
    }

    @RequestMapping(value="/addStudent",method = RequestMethod.POST)
    public String addStudent(ModelMap model, HttpServletRequest request){
        Student student=new Student();
        student.setName(request.getParameter("name"));
        student.setSex(request.getParameter("sex"));
        student.setNumber(Integer.parseInt(request.getParameter("number")));
        model.addAttribute("student",student);
//        model.addAttribute("name",request.getParameter("name"));
//        model.addAttribute("sex",request.getParameter("sex"));
//        model.addAttribute("number",request.getParameter("number"));

        return "result";
    }
}

