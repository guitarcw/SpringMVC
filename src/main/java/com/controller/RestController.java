package com.controller;

import com.Entity.JasperAccount;
import com.Service.JasperAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/rest")
public class RestController {
    @Autowired
    JasperAccountServiceImpl jasperAccountService;
    @RequestMapping(value = "/get",method = RequestMethod.GET,produces = "applicaton/json")
    public @ResponseBody
    String getAccount(@RequestParam(value = "username") String user){
        return jasperAccountService.getAccountIDByUserName(user);

    }
}
