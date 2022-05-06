package ru.itmo.kotiki.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "username")
    private String username;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public User(){
    }

    public User(String username, Role role){
        this.username = username;
        this.role = role;
    }

    public int getId() { return id;}
    public String getUsername() { return username;}
    public Role getRole() { return role;}
}
