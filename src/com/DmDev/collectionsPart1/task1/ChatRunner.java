package com.DmDev.collectionsPart1.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Java Developers", 1500));
        chats.add(new Chat("Spring Enthusiasts", 800));
        chats.add(new Chat("SQL Masters", 1200));
        chats.add(new Chat("Java Developers Advanced", 1500));

        Iterator<Chat> iterator = chats.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().userCount < 1000) {
                iterator.remove();
            }
        }

        chats.sort(new Comparator<Chat>() {
            @Override
            public int compare(Chat o1, Chat o2) {
                int result = Integer.compare(o2.userCount, o1.userCount);
                if (result == 0) {
                    result = o1.name.compareTo(o2.name);
                }
                return result;
            }
        });

        System.out.println("Сортировка по количеству пользователей и названию:");
        for (Chat chat : chats) {
            System.out.println(chat);
        }


        chats.sort(new Comparator<Chat>() {
            @Override
            public int compare(Chat o1, Chat o2) {
                return o1.name.compareTo(o2.name);
            }
        });


        System.out.println("\nСортировка по названию:");
        for (Chat chat : chats) {
            System.out.println(chat);
        }
    }
}
