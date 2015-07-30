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
    private Staff emptyStaff;

    private Map<String, Staff> taskMapper = Maps.newHashMap();

    @Inject
    public WorkDispatcher(@Named("Deliverer") Staff deliverer,
                          @Named("Quiter") Staff quiter,
                          @Named("EmptyStaff") Staff emptyStaff)
    {
        this.deliverer = deliverer;
        this.quiter = quiter;
        this.emptyStaff = emptyStaff;
        initMapper();
    }

    private void initMapper()
    {
        taskMapper.put(LIST_BOOK_COMMAND, deliverer);
        taskMapper.put(QUIT_COMMAND, quiter);
    }

    public Staff dispatchTask(String input)
    {
        Staff staff = taskMapper.get(input);
        if (staff == null) {
            return emptyStaff;
        } else {
            return staff;
        }
    }
}
