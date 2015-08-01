package com.twu.biblioteca.entity;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

@Singleton
public class Shelf
{
    private List<Book> bookList;
    private List<Movie> movieList;

    public Shelf()
    {
        initializeBooks();
        initializeMovies();
    }

    private void initializeMovies()
    {
        movieList = Lists.newArrayList(
                new Movie("Movie One", new Date(1981), "One", Rating.EIGHT),
                new Movie("Movie Two", new Date(1982), "Two", Rating.NINE),
                new Movie("Movie Three", new Date(1983), "Three", Rating.FIVE),
                new Movie("Movie Four", new Date(1984), "Four", Rating.UNRATED)
        );
    }

    private void initializeBooks()
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
            System.out.println("Thank you! Enjoy the book.");
        }
    }

    public void returnBook(String bookName)
    {
        List<Book> filterBookList = Lists.newArrayList();
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName) && book.isAvailableForReturn()) {
                filterBookList.add(book);
            }
        }
        if (filterBookList.size() == 0) {
            System.out.println("That is not a valid book to return.");
        } else {
            Book filterBook = filterBookList.get(0);
            filterBook.setIsAvailableForBorrow(true);
            filterBook.setIsAvailableForReturn(false);
            System.out.println("Thank you for returning the book.");
        }
    }

    public List<Movie> getMovieList()
    {
        return movieList;
    }

    public void borrowOutMovie(String movieName)
    {
        List<Movie> filterMovieList = Lists.newArrayList();
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName) && movie.isAvailableForBorrow()) {
                filterMovieList.add(movie);
            }
        }
        if (filterMovieList.size() == 0) {
            System.out.println("That movie is not available.");
        } else {
            Movie filterMovie = filterMovieList.get(0);
            filterMovie.setIsAvailableForBorrow(false);
            filterMovie.setIsAvailableForReturn(true);
            System.out.println("Thank you! Enjoy the movie.");
        }
    }

    public void returnMovie(String movieName)
    {
        List<Movie> filterMovieList = Lists.newArrayList();
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName) && movie.isAvailableForReturn()) {
                filterMovieList.add(movie);
            }
        }
        if (filterMovieList.size() == 0) {
            System.out.println("That is not a valid movie to return.");
        } else {
            Movie filterMovie = filterMovieList.get(0);
            filterMovie.setIsAvailableForBorrow(true);
            filterMovie.setIsAvailableForReturn(false);
            System.out.println("Thank you for returning the movie.");
        }
    }
}
