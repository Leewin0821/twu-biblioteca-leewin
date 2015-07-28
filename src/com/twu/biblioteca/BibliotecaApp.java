package com.twu.biblioteca;

import com.twu.biblioteca.helper.Messenger;

public class BibliotecaApp {

    public static void main(String[] args) {
        Librarian librarian = new Librarian(new Messenger());
        librarian.manage();
    }
}
