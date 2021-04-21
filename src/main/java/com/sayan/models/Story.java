package com.sayan.models;

import javax.persistence.*;

@Entity
@Table(name = "sm_story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String info;
    @ManyToOne
    @JoinColumn(name = "gr_id")
    private Group group;
    public Story(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
