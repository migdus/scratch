package com.migueldussan.scratch.springbootdb.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "payee")
public class Payee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payee_id")
    private int id;

    @Column(name = "name")
    private String name;

    public Payee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
