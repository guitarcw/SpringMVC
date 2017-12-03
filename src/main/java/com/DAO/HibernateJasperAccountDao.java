package com.DAO;

import com.Entity.JasperAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Repository
@EnableTransactionManagement
public class HibernateJasperAccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
    //存储Developer以及其AccountId,针对第一次出现的用户,调用此函数实现插入新的数据
    /*
    list 首次创建的jasperAccount
     */
    @Transactional
    public void saveFirst(List<JasperAccount> list){
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        for (JasperAccount jasperAccount:list) {
            session.save(jasperAccount);
        }
        tx.commit();
        session.close();
    }
    //删除所有的已经不存在的用户数据,根据Kaa平台的kaa_user表格,对比Jasper_account表格,
    @Transactional
    public void deleteAll(List<JasperAccount> list){
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        for (JasperAccount jasperAccount: list
             ) {
            session.delete(jasperAccount);
        }
        tx.commit();
        session.close();
    }
    /*
    * 根据username获取数据库中的信息
    * #p username*/
    @Transactional
    public JasperAccount getByuUserName(String userName){
        String hql ="from JasperAccount as ja where  user_name=:userName";
        List<JasperAccount> result=getSession().createQuery(hql).setString("userName",userName).list();
        if (result== null) {
            result= Collections.emptyList();
        }
        if(result.isEmpty()) return null;
        return result.get(0);
    }

    //获得所有developer以及其AccountID
    /*允许事务性,很重要"@Transactional"
     */
    @Transactional
    public List<JasperAccount> getAll(){
        String hql="FROM JasperAccount";
        List<JasperAccount> result=getSession().createQuery(hql).list();
        if (result== null) {
            result= Collections.emptyList();
        }
        return result;
    }
    //删除表内特定Developer以及其AccountId
    @Transactional
    public void delete(JasperAccount jasperAccount){

        getSession().delete(jasperAccount);
    }

    //更新表格内容
    @Transactional
    public void update(JasperAccount jasperAccount){
        getSession().merge(jasperAccount);

    }
}

