package com.twu.biblioteca;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.twu.biblioteca.configuration.StaffModule;
import com.twu.biblioteca.staff.Messenger;
import com.twu.biblioteca.staff.Staff;
import com.twu.biblioteca.staff.WorkDispatcher;

public class BibliotecaApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new StaffModule());
        Staff messenger = injector.getInstance(Messenger.class);
        WorkDispatcher dispatcher = injector.getInstance(WorkDispatcher.class);
        Librarian librarian = new Librarian(messenger, dispatcher);
        librarian.work();
    }
}
