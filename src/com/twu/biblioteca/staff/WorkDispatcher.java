package com.twu.biblioteca.staff;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class WorkDispatcher
{
    public static final String LIST_BOOK_COMMAND = "list book";
    public static final String QUIT_COMMAND = "quit";
    public static final String BORROW_BOOK_COMMAND = "checkout book";
    public static final String RETURN_COMMAND = "return";
    public static final String LIST_MOVIE_COMMAND = "list movie";
    public static final String BORROW_MOVIE_COMMAND = "checkout movie";
    public static final String USER_INFORMATION_COMMAND = "user information";

    private Map<String, Staff> taskMapper = Maps.newHashMap();

    private Staff bookLister;
    private Staff quiter;
    private Staff emptyStaff;
    private Staff borrower;
    private Staff returner;
    private Staff movieLister;
    private Staff movieBorrower;
    private Staff userNotifier;

    @Inject
    public WorkDispatcher(@Named("BookLister") Staff bookLister,
                          @Named("Quiter") Staff quiter,
                          @Named("EmptyStaff") Staff emptyStaff,
                          @Named("Borrower") Staff borrower,
                          @Named("Returner") Staff returner,
                          @Named("MovieLister") Staff movieLister,
                          @Named("MovieBorrower") Staff movieBorrower,
                          @Named("UserNotifier") Staff userNotifier)
    {
        this.bookLister = bookLister;
        this.quiter = quiter;
        this.emptyStaff = emptyStaff;
        this.borrower = borrower;
        this.returner = returner;
        this.movieLister = movieLister;
        this.movieBorrower = movieBorrower;
        this.userNotifier = userNotifier;
        initMapper();
    }

    private void initMapper()
    {
        taskMapper.put(LIST_BOOK_COMMAND, bookLister);
        taskMapper.put(QUIT_COMMAND, quiter);
        taskMapper.put(BORROW_BOOK_COMMAND, borrower);
        taskMapper.put(RETURN_COMMAND, returner);
        taskMapper.put(LIST_MOVIE_COMMAND, movieLister);
        taskMapper.put(BORROW_MOVIE_COMMAND, movieBorrower);
        taskMapper.put(USER_INFORMATION_COMMAND, userNotifier);
    }

    public Staff dispatchTask(String input)
    {
        Staff staff = taskMapper.get(input);
        if (staff == null) {
            return emptyStaff;
        } else {
            return staff;
        }
    }
}
