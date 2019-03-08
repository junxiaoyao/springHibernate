package com.jxy.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 9:40
 * @Description:
 */
@Transactional
@Repository
public class BaseRepositoryImp<E, Long> implements IBaseRepository<E, Long> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(E e) {
        this.getCurrentSession().save(e);
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
