package com.sayan.daos.impl;

import com.sayan.models.Address;
import com.sayan.models.Employee;
import com.sayan.models.Group;
import com.sayan.models.Story;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RelationshipDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;
    public void testOneToOne(){
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Employee emp = null;
        Address a1 = null;
        emp = new Employee();
        emp.setName("Sayan Mandal");
        a1=new Address();
        a1.setAddress("purulia");
        a1.setCountry("India");

        emp.setAddress(a1);
        a1.setEmployee(emp);

        session.save(emp);
        session.flush();
        Query<Employee> query = session.createQuery("from Employee");
        List<Employee> list = query.list();
        for (Employee e:list){
            System.out.println(e.getId()+" : "+e.getAddress().getAddress()+" : "+e.getAddress().getAddress());
        }
        tr.commit();
        session.close();
    }

    public void testOneToMany(){
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Group group = new Group();
        group.setName("SPORTS");
        ArrayList<Story> stories = new ArrayList<>();

        Story s1 = new Story();
        s1.setInfo("The Allegations");
        stories.add(s1);
        Story s2 = new Story();
        s2.setInfo("The Cancer of match fixing");
        stories.add(s2);
        Story s3 = new Story();
        s3.setInfo("The Master Blaster");
        stories.add(s3);

        group.setStories(stories);

        Serializable id = session.save(group);
        session.flush();
        Group g = (Group) session.load(Group.class,id);
        System.out.println("GROUP ID :: "+g.getId()+" GROUP NAME :: "+g.getName());
        List<Story> groupStories = g.getStories();
        System.out.println("STORIES :: ");
        for (Story story:groupStories){
            System.out.println(story.getId()+":"+story.getInfo());
        }
        tr.commit();
        session.close();
    }
    public void testManyToOne(){
        Session session = sessionFactory.openSession();
        Story story = (Story) session.load(Story.class,5);
        System.out.println(story.getId()+":"+story.getInfo());
        Group group=story.getGroup();
        System.out.println(group.getId()+":"+group.getName());
        session.close();
    }
}
