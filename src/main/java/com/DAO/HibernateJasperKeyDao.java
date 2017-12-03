package com.DAO;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import com.Entity.JasperKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Repository
@EnableTransactionManagement
public class HibernateJasperKeyDao
{
    @Autowired
    private  SessionFactory sessionFactory;
    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
    //Criteria创建
    protected Criteria getCriteria() {
        return getSession().createCriteria(JasperKey.class);
    }

    //往数据库存储
    public void saveKey(JasperKey key){
        String hql = "FROM JasperKey";
        Session session=getSession();
        if(session.createQuery(hql).list().isEmpty()) session.save(key);
        else session.merge(key);

    }
//获得数据库数据
    public List<JasperKey> getKey(){
        String hql = "FROM JasperKey";
        List result=getSession().createQuery(hql).list();
        return result;
    }


}
