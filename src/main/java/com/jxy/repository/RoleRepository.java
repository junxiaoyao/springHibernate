package com.jxy.repository;

import com.jxy.hEntity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleRepository  {
    @Autowired
    private SessionFactory sessionFactory;

    public RoleRepository() {
    }

    @Transactional(readOnly = true)
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Role e) {
        System.out.println("session:" + getCurrentSession().toString());
        getCurrentSession().save(e);
    /*    Role role=getCurrentSession().get(Role.class,1l);
        getCurrentSession().flush();*/
      /*  getCurrentSession().saveOrUpdate(e);*/
      /*  getCurrentSession().getTransaction().commit();*/
    }

    public Role getOne() {
        return getCurrentSession().get(Role.class, 1l);
    }
}
