package com.twu.biblioteca.staff;

import com.google.inject.Inject;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Shelf;

public class Deliverer implements Staff
{
    private Shelf shelf;

    @Inject
    public Deliverer(Shelf shelf)
    {
        this.shelf = shelf;
    }

    public boolean doService()
    {
        for (Book book : shelf.getBookList()) {
            System.out.println(book.toString());
        }
        return true;
    }
}
