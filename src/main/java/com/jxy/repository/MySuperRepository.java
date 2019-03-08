package com.jxy.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 10:28
 * @Description:
 */
@Transactional
@Repository
public class MySuperRepository<T, P extends Serializable> {
    private Class<T> entityClass;
    @Autowired
    private SessionFactory sessionFactory;

    public MySuperRepository() {
        this.entityClass = getTClass();
    }

    public void save(final T entity) {
        getSession().saveOrUpdate(entity);
    }

    public T getById(final Long id) {
        return (T) getSession().get(entityClass, id);
    }

    public List<T> getByHql(String queryString) throws SQLException {
        return getSession().createQuery(queryString).list();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getTClass() {
        //获取直接超类的 Type 实例
        Type superClassType = getClass().getGenericSuperclass();
        try {
            if (superClassType instanceof ParameterizedType) {
                //参数化类型
                ParameterizedType parameterType = (ParameterizedType) superClassType;

                //泛型参数的 Type 对象的数组
                Type[] parameters = parameterType.getActualTypeArguments();
                //返回实体类参数
                return (Class<T>) parameters[0];
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
