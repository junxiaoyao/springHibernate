package com.jxy.hEntity;

import javax.persistence.*;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 10:07
 * @Description:
 */
@MappedSuperclass
public class AbstractEntity {
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
