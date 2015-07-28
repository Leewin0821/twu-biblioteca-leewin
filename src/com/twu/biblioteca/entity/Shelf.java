package com.twu.biblioteca.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Shelf
{
    private final List<Book> bookList;

    public Shelf()
    {
        bookList = Lists.newArrayList();
    }

    public List<Book> getBookList()
    {
        return bookList;
    }
}
