package com.twu.biblioteca.entity;

public enum Rating
{
    ONE("One", "1"),
    TWOO("Two", "2"),
    THREE("Three", "3"),
    FOUR("Four", "4"),
    FIVE("Five", "5"),
    SIX("Six", "6"),
    SEVEN("Seven", "7"),
    EIGHT("Eight", "8"),
    NINE("Nine", "9"),
    TWO("Ten", "10"),
    UNRATED("Unrated", "unrated");

    private final String name;
    private final String value;

    Rating(String name, String value)
    {
        this.name = name;
        this.value = value;
    }
}
