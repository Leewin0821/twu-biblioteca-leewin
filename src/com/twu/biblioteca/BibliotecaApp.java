package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Manager manager = new Manager(new Librarian());
        manager.manage();
    }
}
