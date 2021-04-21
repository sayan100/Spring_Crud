package com.sayan.services.impl;

import com.sayan.daos.impl.RelationshipDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipServiceImpl {
    @Autowired
    private RelationshipDAOImpl dao;

    public void testOneToOne(){
        dao.testOneToOne();
    }
    public void testOneToMany(){
        dao.testOneToMany();
    }
    public void testManyToOne(){
        dao.testManyToOne();
    }
}
