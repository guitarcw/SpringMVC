package com.Service;


import com.DAO.HibernateJasperKeyDao;
import com.Entity.JasperKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JasperKeyServiceImpl {
    @Autowired
    private HibernateJasperKeyDao hibernateJasperKeyDao;
    //存贮秘钥
    public JasperKey saveKey(String userName,String key){
        JasperKey jasperKey=new JasperKey(userName,key);
        hibernateJasperKeyDao.saveKey(jasperKey);
        return jasperKey;
    }
    //获得秘钥
    public String getKey(){
        List<JasperKey> list= hibernateJasperKeyDao.getKey();
        if (list.isEmpty()) return "ERROR";
        else
            return list.get(0).getKey();
    }

}
