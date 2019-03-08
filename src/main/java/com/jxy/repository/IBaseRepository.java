package com.jxy.repository;

import org.hibernate.Session;

public interface IBaseRepository<E, Long> {
    void save(E e);

    /* void delete(Long id);
     E getOne(Long id);*/
    Session getCurrentSession();
}
