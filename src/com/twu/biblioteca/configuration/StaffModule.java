package com.twu.biblioteca.configuration;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.twu.biblioteca.staff.*;

public class StaffModule implements Module
{
    public void configure(Binder binder)
    {
        binder.bind(Staff.class).annotatedWith(Names.named("Messenger")).to(Messenger.class);
        binder.bind(Staff.class).annotatedWith(Names.named("BookLister")).to(BookLister.class);
        binder.bind(Staff.class).annotatedWith(Names.named("Quiter")).to(Quiter.class);
        binder.bind(Staff.class).annotatedWith(Names.named("EmptyStaff")).to(EmptyStaff.class);
        binder.bind(Staff.class).annotatedWith(Names.named("Borrower")).to(BookBorrower.class);
        binder.bind(Staff.class).annotatedWith(Names.named("Returner")).to(Returner.class);
        binder.bind(Staff.class).annotatedWith(Names.named("MovieLister")).to(MovieLister.class);
        binder.bind(Staff.class).annotatedWith(Names.named("MovieBorrower")).to(MovieBorrower.class);
    }
}
