package com.tpe.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_developer7")
public class Developer07 {
    @Id
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    @ManyToMany(mappedBy = "developer")
    private Set<Project> project = new HashSet<>();



    public Developer07() {
    }

    public Developer07(Long id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
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



    @Override
    public String toString() {
        return "Developer04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
