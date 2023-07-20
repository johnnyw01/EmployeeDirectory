package com.EmployeeDirectory.EmployeeDirectory.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //Create a mapping for "/hello
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theData", new java.util.Date());
        return "helloWorld";
    }
}
