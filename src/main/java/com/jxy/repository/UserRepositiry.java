package com.jxy.repository;

import com.jxy.entity.JxyUser;
import org.hibernate.query.Query;

/**
 * @Auther: jxy
 * @Date: 2019/3/11 10:34
 * @Description:
 */
public class UserRepositiry extends MySuperRepository<JxyUser,Long> {
   /* public JxyUser login(String userName){
        Query<JxyUser> query=super.getSession().createQuery("select  {c.*} from huser c where  c.userName=:userName");
        return null;
    }*/
}
