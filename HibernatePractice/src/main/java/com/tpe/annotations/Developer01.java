package com.tpe.annotations;


//Pojo class olusturuyorum
//percistence yapiyorum kalici hale getiriyorum onun icinde @Entity annotation kullaniyorum
//Hibernate id tanimlamayi zorunlu tutar

import javax.persistence.*;


public class Developer01 {

    @Id //Tablomdaki primary key alani oldugunu belirtir
    private int id;


    // Annotation u kullanmak zorunda degil opsiyonal, sutuna(coolumn) isim vermek ve kisitlamalar yapmak icin kullanirim
    @Column(name = "dev_name", length = 50, nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    //@Transient
    private String branch;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Developer01() {}

    public Developer01(int id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Developer01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
