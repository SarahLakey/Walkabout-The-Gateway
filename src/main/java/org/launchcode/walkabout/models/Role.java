package org.launchcode.walkabout.models;

import jakarta.persistence.*;

//import javax.persistence.Entity;

import java.util.List;

@Entity
@Table(name = "role")
//public class Role {
public class Role extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

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
}
