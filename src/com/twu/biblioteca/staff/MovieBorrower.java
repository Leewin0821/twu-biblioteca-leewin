package com.twu.biblioteca.staff;

import com.google.inject.Inject;
import com.twu.biblioteca.entity.Shelf;

import java.util.Scanner;

public class MovieBorrower implements Staff
{
    private Shelf shelf;

    @Inject
    public MovieBorrower(Shelf shelf)
    {
        this.shelf = shelf;
    }

    public boolean doService()
    {
        System.out.println("Please input the Movie Name you want to Borrow:");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();
        shelf.borrowOutMovie(movieName);
        return true;
    }
}
