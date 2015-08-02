package com.twu.biblioteca.entity;

public class User
{
    private final String libraryNum;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;

    public User(String libraryNum, String password, String name, String email, String phone)
    {
        this.libraryNum = libraryNum;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getLibraryNum()
    {
        return libraryNum;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    @Override
    public String toString()
    {
        return name + " | "
              + email + " | "
              + phone;
    }
}
