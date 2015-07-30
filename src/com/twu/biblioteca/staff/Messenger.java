package com.twu.biblioteca.staff;

public class Messenger implements Staff
{
    public boolean doService()
    {
        System.out.println("*************************************");
        System.out.println("Welcome to Bangalore Public Library!");
        System.out.println("              Main Menu             ");
        System.out.println("Please input 'list' to List Books");
        System.out.println("Please input 'quit' to Quit App");
        System.out.println("*************************************");
        return true;
    }
}
