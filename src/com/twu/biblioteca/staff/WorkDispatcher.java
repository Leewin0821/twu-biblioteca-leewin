package com.twu.biblioteca.staff;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.twu.biblioteca.entity.Shelf;

public class WorkDispatcher
{
    public static final String LIST_BOOK = "list.book";
    public static final String QUIT = "quit";

    private Staff deliverer;
    private Staff quiter;

    private Map<String, Staff> taskMapper = Maps.newHashMap();

    @Inject
    public WorkDispatcher(@Named("Deliverer") Staff deliverer,
                          @Named("Quiter") Staff quiter)
    {
        this.deliverer = deliverer;
        this.quiter = quiter;
        initMapper();
    }

    private void initMapper()
    {
        taskMapper.put(LIST_BOOK, deliverer);
        taskMapper.put(QUIT, quiter);
    }

    public Staff dispatchTask(String input)
    {
        return taskMapper.get(input);
    }
}
