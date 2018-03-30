package com.example.erhan.varukontroll;

/**
 * Created by Erhan on 2018-03-23.
 */

public class User {
    private String name;
    private String email;
    private String password;
    private String uid;

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(String id)
    {
        this.uid = id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
