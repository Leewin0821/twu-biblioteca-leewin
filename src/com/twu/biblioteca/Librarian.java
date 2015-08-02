package com.twu.biblioteca;

import com.google.inject.Inject;
import com.twu.biblioteca.staff.Staff;
import com.twu.biblioteca.staff.WorkDispatcher;

import java.util.Scanner;

public class Librarian
{
    private Staff messenger;
    private Staff guard;
    private WorkDispatcher dispatcher;

    @Inject
    public Librarian(Staff messenger, Staff guard, WorkDispatcher dispatcher)
    {
        this.messenger = messenger;
        this.guard = guard;
        this.dispatcher = dispatcher;
    }

    public void work()
    {
        System.out.println("Please input your library number and password, separated by space: ");
        if (!guard.doService()) {
            System.out.println("Sorry, invalid user.");
            System.exit(0);
        }
        messenger.doService();
        assignTasks();
    }

    private void assignTasks()
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
