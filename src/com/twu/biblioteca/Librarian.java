package com.twu.biblioteca;

import java.util.Scanner;

import com.twu.biblioteca.staff.Staff;

public class Librarian
{
    private Staff messenger;

    public Librarian(Staff messenger)
    {
        this.messenger = messenger;
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
