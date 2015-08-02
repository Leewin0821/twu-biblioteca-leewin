package com.twu.biblioteca.staff;

import java.util.Scanner;

import com.google.inject.Inject;
import com.twu.biblioteca.entity.Shelf;

public class BookBorrower implements Staff
{
    private Shelf shelf;

    @Inject
    public BookBorrower(Shelf shelf)
    {
        this.shelf = shelf;
    }

    public boolean doService()
    {
        System.out.println("Please input the Book Name you want to Borrow:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        shelf.borrowOutBook(bookName);
        return true;
    }
}
