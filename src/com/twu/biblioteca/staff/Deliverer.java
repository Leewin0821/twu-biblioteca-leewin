package com.twu.biblioteca.staff;

import com.google.common.collect.FluentIterable;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
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
        ImmutableList<Book> books = FluentIterable.from(shelf.getBookList()).filter(new Predicate<Book>()
        {
            public boolean apply(Book book)
            {
                System.out.println(book.toString());
                return book.isAvailableForBorrow();
            }
        }).toList();
        return true;
    }
}
