package com.wyl.ssm.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wyl.com.maindom.Student;
import com.wyl.ssm.service.DemoService;

@Controller
public class DemoController {
	@Resource
    private DemoService demoService;    
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
		//int id=1;
        Student list = demoService.findAllDemo();
        List<Student> list2=new ArrayList<Student>();
        list2.add(list);
        model.addAttribute("list", list2);
        return "demo";
    }


}
