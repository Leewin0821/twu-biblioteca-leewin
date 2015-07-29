package com.twu.biblioteca;

import com.google.inject.Inject;
import com.twu.biblioteca.staff.Staff;
import com.twu.biblioteca.staff.WorkDispatcher;

import java.util.Scanner;

public class Librarian
{
    private Staff messenger;
    private WorkDispatcher dispatcher;

    @Inject
    public Librarian(Staff messenger, WorkDispatcher dispatcher)
    {
        this.messenger = messenger;
        this.dispatcher = dispatcher;
    }

    public void work()
    {
        messenger.doService();
        doSomething();
    }

    private void doSomething()
    {
        boolean condition = true;
        while (condition) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            Staff staff = dispatcher.dispatchTask(input);
            condition = staff.doService();
        }
    }
}
