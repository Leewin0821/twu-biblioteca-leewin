package com.twu.biblioteca.staff;

public class EmptyStaff implements Staff
{
    public boolean doService()
    {
        System.out.println("Select a valid option!");
        return true;
    }
}
