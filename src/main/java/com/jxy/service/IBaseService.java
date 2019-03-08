package com.jxy.service;

import org.springframework.security.access.method.P;

import java.sql.SQLException;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 15:49
 * @Description:
 */
public interface IBaseService<E> {
    public void save(E entity);

    public E getById(Long id);
}
