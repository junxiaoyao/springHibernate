package com.jxy.service;

import com.jxy.repository.MySuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 15:52
 * @Description:
 */
public class BaseServiceImp<E> implements IBaseService<E>{
    @Autowired
    private MySuperRepository<E,Long> mySuperRepository;
    @Override
    public void save(E entity) {
        mySuperRepository.save(entity);
    }

    @Override
    public E getById(Long id) {
        return mySuperRepository.getById(id);
    }
}
