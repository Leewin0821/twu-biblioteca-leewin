package com.twu.biblioteca.staff;

import java.util.Map;

import com.google.common.collect.Maps;

public class WorkDispatcher
{
    private Staff deliverer;

    public final String LIST_BOOK = "list.book";

    private Map<String, Staff> workMapper = Maps.newHashMap();

}
