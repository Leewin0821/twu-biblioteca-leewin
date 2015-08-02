package com.twu.biblioteca.entity;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class UserDB
{
    private List<User> userList;

    public UserDB()
    {
        initializeAccounts();
    }

    private void initializeAccounts()
    {
        userList = Lists.newArrayList(
                new User("123-4567", "password", "Alice", "alice@gmail.com", "012-8888"),
                new User("111-1111", "password", "Bob", "bob@gmail.com", "012-7777"),
                new User("111-111", "password", "Bob", "bob@gmail.com", "012-7777"),
                new User("222-2222", "password", "Cherry", "cherry@gmail.com", "012-6666")
        );
    }

    public boolean validateAccount(final String account, final String password)
    {
        ImmutableList<User> users = FluentIterable.from(userList).filter(new Predicate<User>()
        {
            public boolean apply(User user)
            {
                return user.getLibraryNum().equals(account) && user.getPassword().equals(password);
            }
        }).toList();

        return users.size() == 1;
    }
}
