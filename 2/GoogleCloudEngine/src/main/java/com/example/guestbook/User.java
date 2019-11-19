
package com.example.guestbook;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.lang.String;
import java.util.Date;

@Entity
public class User {
    @Id
    public Long id;

    public String login;
    public String password;
    public String email;

    @Index
    public Date date;

    public User() {
        date = new Date();
    }


    public User(String login, String password) {
        this();

        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String email) {
        this(login, password);

        this.email = email;
    }
}