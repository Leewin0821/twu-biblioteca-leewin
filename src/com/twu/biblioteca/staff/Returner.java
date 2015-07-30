package com.twu.biblioteca.staff;

import java.util.Scanner;

import com.google.inject.Inject;
import com.twu.biblioteca.entity.Shelf;

public class Returner implements Staff
{
    private Shelf shelf;

    @Inject
    public Returner(Shelf shelf)
    {
        this.shelf = shelf;
    }

    public boolean doService()
    {
        System.out.println("Please input the Book Name you want to Return:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        shelf.returnBook(bookName);
        return true;
    }
}
