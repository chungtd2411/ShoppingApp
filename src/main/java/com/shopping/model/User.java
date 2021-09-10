package com.shopping.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Table(name = "user")
@Data
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "username")
    private String name;

    @NotNull
    @Column(name = "password")
    private String pw;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

}
