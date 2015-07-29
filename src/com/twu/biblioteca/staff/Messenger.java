package com.twu.biblioteca.staff;

public class Messenger implements Staff
{
    public boolean doService()
    {
        System.out.println("Welcome to Bangalore Public Library!");
        return true;
    }
}
