package com.twu.biblioteca;

import java.util.Scanner;

import com.google.inject.Inject;
import com.twu.biblioteca.helper.Messenger;

public class Librarian
{
    @Inject
    private Messenger messenger;

    public Librarian(Messenger messenger)
    {
        this.messenger = messenger;
    }

    public void manage()
    {
        showWelcomeMessage();
        doSomething();
    }

    private void showWelcomeMessage()
    {
        messenger.displayWelcomeMessage();
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
