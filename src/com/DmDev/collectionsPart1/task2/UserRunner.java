package com.DmDev.collectionsPart1.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UserRunner {

    public static void main(String[] args) {

        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Java Developers", List.of(new User(1, "Sasha", 20), new User(2, "Vova", 17))));
        chats.add(new Chat("SQL Masters", List.of(new User(3, "Vasya", 22), new User(4, "Ivan", 16))));

        List<User> filteredUsers = new ArrayList<>();
        for (Chat chat : chats) {
            for (User user : chat.users) {
                if (user.age > 18) {
                    filteredUsers.add(user);
                }
            }
        }

        Iterator<User> iterator = filteredUsers.iterator();
        int totalAge = 0;
        int count = 0;
        while (iterator.hasNext()) {
            User user = iterator.next();
            totalAge += user.age;
            count++;
        }
        double averageAge = count > 0 ? (double) totalAge / count : 0;

        System.out.println("Средний возраст пользователей старше 18 лет: " + averageAge);
    }
}
