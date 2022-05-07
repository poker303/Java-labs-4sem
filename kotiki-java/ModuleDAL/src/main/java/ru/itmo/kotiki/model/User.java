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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private CatOwner owner;

    public User() {
    }

    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public CatOwner getOwner() {
        return owner;
    }

    public void setOwner(CatOwner owner) {
        this.owner = owner;
    }
}
