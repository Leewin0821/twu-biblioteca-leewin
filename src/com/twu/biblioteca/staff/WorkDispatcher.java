package com.twu.biblioteca.staff;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class WorkDispatcher
{
    public static final String LIST_BOOK_COMMAND = "list";
    public static final String QUIT_COMMAND = "quit";
    public static final String BORROW_COMMAND = "checkout";
    public static final String RETURN_COMMAND = "return";

    private Map<String, Staff> taskMapper = Maps.newHashMap();

    private Staff deliverer;
    private Staff quiter;
    private Staff emptyStaff;
    private Staff borrower;
    private Staff returner;

    @Inject
    public WorkDispatcher(@Named("Deliverer") Staff deliverer,
                          @Named("Quiter") Staff quiter,
                          @Named("EmptyStaff") Staff emptyStaff,
                          @Named("Borrower") Staff borrower,
                          @Named("Returner") Staff returner)
    {
        this.deliverer = deliverer;
        this.quiter = quiter;
        this.emptyStaff = emptyStaff;
        this.borrower = borrower;
        this.returner = returner;
        initMapper();
    }

    private void initMapper()
    {
        taskMapper.put(LIST_BOOK_COMMAND, deliverer);
        taskMapper.put(QUIT_COMMAND, quiter);
        taskMapper.put(BORROW_COMMAND, borrower);
        taskMapper.put(RETURN_COMMAND, returner);
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
