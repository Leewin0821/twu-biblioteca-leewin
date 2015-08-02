package com.twu.biblioteca.staff;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.Shelf;

public class MovieLister implements Staff
{
    private Shelf shelf;

    @Inject
    public MovieLister(Shelf shelf)
    {
        this.shelf = shelf;
    }

    public boolean doService()
    {
        ImmutableList<Movie> movies = FluentIterable.from(shelf.getMovieList()).filter(new Predicate<Movie>()
        {
            public boolean apply(Movie movie)
            {
                if (movie.isAvailableForBorrow()) {
                    System.out.println(movie.toString());
                    return true;
                } else {
                    return false;
                }
            }
        }).toList();

        return true;
    }
}
