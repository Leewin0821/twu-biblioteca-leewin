package com.twu.biblioteca.staff;

public class Messenger implements Staff
{
    public boolean doService()
    {
        System.out.println("*************************************");
        System.out.println("Welcome to Bangalore Public Library!");
        System.out.println("Please input following commands to navigate:");
        System.out.println("- list : List all books");
        System.out.println("- quit : Quit application");
        System.out.println("*************************************");
        return true;
    }
}
