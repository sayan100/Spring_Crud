package com.sayan.controllers;

import com.sayan.services.impl.RelationshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relations")
public class RelationshipController {
    @Autowired
    private RelationshipServiceImpl relationshipService;

    @GetMapping(path = "/onetoone")
    public void testOneToOne(){
        relationshipService.testOneToOne();
    }
    @GetMapping(path = "/onetomany")
    public void testOneToMany(){
        relationshipService.testOneToMany();
    }
    @GetMapping(path = "/manytoone")
    public void testManyToOne(){
        relationshipService.testManyToOne();
    }

}
