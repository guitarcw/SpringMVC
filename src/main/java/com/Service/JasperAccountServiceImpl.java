package com.Service;

import com.DAO.HibernateJasperAccountDao;
import com.Entity.JasperAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JasperAccountServiceImpl {
    @Autowired
    HibernateJasperAccountDao jasperAccountDao;
    //更新内容
    public void update(String id,String userName,String newAccount){
        JasperAccount jasperAccount=new JasperAccount(id,userName,newAccount);
        jasperAccountDao.update(jasperAccount);
    }
    //根据userName更新表格
    public void updateByUserName(String userName,String newAccount){
        JasperAccount jasperAccount=jasperAccountDao.getByuUserName(userName);
        jasperAccount.setAccountId(newAccount);
        jasperAccountDao.update(jasperAccount);
    }
    //根据UserName获取AccountID
    public  String getAccountIDByUserName(String userName){
        JasperAccount jasperAccount=jasperAccountDao.getByuUserName(userName);
        return jasperAccount.getAccountId();
    }



}
