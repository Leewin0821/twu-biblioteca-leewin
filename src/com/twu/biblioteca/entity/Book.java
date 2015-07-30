package com.twu.biblioteca.entity;

import java.util.Date;

public class Book
{
    private final String bookName;
    private final String author;
    private final Date publishedYear;
    private boolean isAvailableForBorrow = true;
    private boolean isAvailableForReturn = false;

    public Book(String bookName, String author, Date publishedYear)
    {
        this.bookName = bookName;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getBookName()
    {
        return bookName;
    }

    public String getAuthor()
    {
        return author;
    }

    public Date getPublishedYear()
    {
        return publishedYear;
    }

    public boolean isAvailableForBorrow()
    {
        return isAvailableForBorrow;
    }

    public void setIsAvailableForBorrow(boolean isAvailableForBorrow)
    {
        this.isAvailableForBorrow = isAvailableForBorrow;
    }

    public boolean isAvailableForReturn()
    {
        return isAvailableForReturn;
    }

    public void setIsAvailableForReturn(boolean isAvailableForReturn)
    {
        this.isAvailableForReturn = isAvailableForReturn;
    }

    @Override
    public String toString()
    {
        return bookName + " | " + author + " | " + publishedYear;
    }
}
