package com.twu.biblioteca.entity;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

@Singleton
public class Shelf
{
    private List<Book> bookList;

    public Shelf()
    {
        bookList = Lists.newArrayList(
                new Book("Book One", "AAA", new Date(19800808)),
                new Book("Book Two", "BBB", new Date(19810808)),
                new Book("Book Three", "CCC", new Date(19820808)),
                new Book("Book Four", "DDD", new Date(19830808)),
                new Book("Book Five", "EEE", new Date(19840808))
        );
    }

    public List<Book> getBookList()
    {
        return bookList;
    }

    public void borrowOutBook(String bookName)
    {
        List<Book> filterBookList = Lists.newArrayList();
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName) && book.isAvailableForBorrow()) {
                filterBookList.add(book);
            }
        }
        if (filterBookList.size() == 0) {
            System.out.println("That book is not available.");
        } else {
            Book filterBook = filterBookList.get(0);
            filterBook.setIsAvailableForBorrow(false);
            filterBook.setIsAvailableForReturn(true);
            System.out.println("Thank you! Enjoy the book");
        }
    }
}
