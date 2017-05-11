package com.leaf.school.dao;


import com.leaf.school.dto.BaseDTO;
import com.leaf.school.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAO {


    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected static <T extends BaseDTO, Y extends BaseEntity> void populateCommonDTO(T dto, Y entity) {
        dto.setAddedBy(entity.getAddedBy());
        dto.setAddedOn(entity.getAddedOn());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedOn(entity.getUpdatedOn());
    }


}
