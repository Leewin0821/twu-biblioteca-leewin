package com.twu.biblioteca;

import java.util.Scanner;

import com.google.inject.Inject;

public class Manager
{
    @Inject
    private Librarian librarian;

    public Manager(Librarian librarian)
    {
        this.librarian = librarian;
    }


    public void manage()
    {
        librarian.showWelcomeMessage();
        doSomething();

    }

    private void doSomething()
    {
        boolean condition = true;
        while (condition) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                System.out.println("This is 1");
            } else if ("2".equals(input)) {
                System.out.println("This is end");
                condition = false;
            } else {
                System.out.println("Nothing");
            }
        }
    }
}
