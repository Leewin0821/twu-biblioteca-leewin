package com.twu.biblioteca.entity;

import java.util.Date;

public class Movie
{
    private final String name;
    private final Date year;
    private final String director;
    private final Rating rating;
    private boolean isAvailableForBorrow = true;
    private boolean isAvailableForReturn = false;

    public Movie(String name, Date year, String director, Rating rating)
    {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName()
    {
        return name;
    }

    public Date getYear()
    {
        return year;
    }

    public String getDirector()
    {
        return director;
    }

    public Rating getRating()
    {
        return rating;
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
        return name + " | "
             + year + " | "
             + director + " | "
             + rating;
    }
}
