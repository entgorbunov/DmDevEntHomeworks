package com.DmDev.collectionsPart1.task2.utility;

import com.DmDev.collectionsPart1.task2.base.Chat;
import com.DmDev.collectionsPart1.task2.base.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Utility {
    public static List<User> filterUsersByAge(List<Chat> chats, int age) {
        List<User> filteredUsers = new ArrayList<>();
        for (Chat chat : chats) {
            for (User user : chat.getUsers()) {
                if (user.getAge() > age) {
                    filteredUsers.add(user);
                }
            }
        }
        return filteredUsers;
    }

    public static double calculateAverageAgeWithList(List<User> users) {
        if (users.isEmpty()) {
            return 0;
        }
        int totalAge = 0;
        for (User user : users) {
            totalAge += user.getAge();
        }
        return (double) totalAge / users.size();
    }

    public static TreeSet<User> addUserToTreeSet(List<Chat> chats) {
        TreeSet<User> usersTree = new TreeSet<>(new UserAgeComparator());
        for (Chat chat : chats) {
            usersTree.addAll(chat.getUsers());
        }
        return usersTree;
    }

    public static NavigableSet<User> filterUsersOlderThan(TreeSet<User> usersTree, int age) {
        User unrealUserForComparison = new User(-1, "", age);
        return usersTree.tailSet(unrealUserForComparison, false);
    }

    public static double calculateAverageAgeWithSet(NavigableSet<User> filteredUsers) {
        if (filteredUsers.isEmpty()) {
            return 0;
        }
        int totalAge = 0;
        for (User user : filteredUsers) {
            totalAge += user.getAge();
        }
        return (double) totalAge / filteredUsers.size();
    }

}
