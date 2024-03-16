package com.DmDev.collectionsPart1.task2;

import com.DmDev.collectionsPart1.task2.base.Chat;
import com.DmDev.collectionsPart1.task2.base.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import static com.DmDev.collectionsPart1.task2.utility.Utility.*;

public class UserRunner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Java Developers", List.of(new User(1, "Sasha", 20), new User(2, "Vova", 17))));
        chats.add(new Chat("SQL Masters", List.of(new User(3, "Vasya", 22), new User(4, "Ivan", 16))));

        List<User> filteredUsers = filterUsersByAge(chats, 18);
        double averageAge = calculateAverageAgeWithList(filteredUsers);
        System.out.println("Средний возраст пользователей старше 18 лет: " + averageAge);

        TreeSet<User> usersTree = addUserToTreeSet(chats);
        NavigableSet<User> filteredUsers1 = filterUsersOlderThan(usersTree, 18);
        double averageAge1 = calculateAverageAgeWithSet(filteredUsers1);

        System.out.println("Средний возраст пользователей старше 18 лет: " + averageAge1);

    }



}

