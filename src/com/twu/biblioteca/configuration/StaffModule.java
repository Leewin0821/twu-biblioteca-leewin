package com.twu.biblioteca.configuration;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.twu.biblioteca.staff.Deliverer;
import com.twu.biblioteca.staff.EmptyStaff;
import com.twu.biblioteca.staff.Messenger;
import com.twu.biblioteca.staff.Quiter;
import com.twu.biblioteca.staff.Staff;

public class StaffModule implements Module
{
    public void configure(Binder binder)
    {
        binder.bind(Staff.class).annotatedWith(Names.named("Messenger")).to(Messenger.class);
        binder.bind(Staff.class).annotatedWith(Names.named("Deliverer")).to(Deliverer.class);
        binder.bind(Staff.class).annotatedWith(Names.named("Quiter")).to(Quiter.class);
        binder.bind(Staff.class).annotatedWith(Names.named("EmptyStaff")).to(EmptyStaff.class);
    }
}
