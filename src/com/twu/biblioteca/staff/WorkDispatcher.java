package com.twu.biblioteca.staff;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class WorkDispatcher
{
    public static final String LIST_BOOK_COMMAND = "list";
    public static final String QUIT_COMMAND = "quit";

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
        taskMapper.put(LIST_BOOK_COMMAND, deliverer);
        taskMapper.put(QUIT_COMMAND, quiter);
    }

    public Staff dispatchTask(String input)
    {
        return taskMapper.get(input);
    }
}
