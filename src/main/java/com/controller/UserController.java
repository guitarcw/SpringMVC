package com.controller;

import com.DAO.HibernateJasperAccountDao;
import com.Entity.JasperAccount;
import com.Entity.JasperKey;
//import com.Entity.User;
import com.Service.JasperAccountServiceImpl;
import com.Service.JasperKeyServiceImpl;
//import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    //@Autowired
    //private UserService userService;
    @Autowired
    JasperAccountServiceImpl jasperAccountService;
    @Autowired
    JasperKeyServiceImpl jasperKeyService;
    @RequestMapping("/")
    public ModelAndView index(ModelAndView model) {
        JasperAccount jasperAccount=new JasperAccount("3","cw","1101");
//        List<JasperAccount> list=new ArrayList();
//        list.add(jasperAccount);
//        list.add(new JasperAccount("2","wc","1140"));
//        List<JasperAccount> list1=new ArrayList<JasperAccount>(list);
//        hibernateJasperAccountDao.saveFirst(list);
//        hibernateJasperAccountDao.deleteAll(list1);
//        hibernateJasperAccountDao.getAll();
//        hibernateJasperAccountDao.update(jasperAccount);
//        JasperAccount jasperAccount1=hibernateJasperAccountDao.getByuUserName("cw");
//        jasperAccountService.updateByUserName("cw","115");

        //jasperAccountService.update(1,"cw","11011");

        jasperKeyService.saveKey("3334","123456");
        String jasperKey=jasperKeyService.getKey();

      //  List<User> result=userService.getUsers();
        //model.addObject( "users", result );
        model.setViewName("index");
        return model;
    }
}
