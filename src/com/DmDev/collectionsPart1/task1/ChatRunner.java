package com.DmDev.collectionsPart1.task1;

import com.DmDev.collectionsPart1.task1.base.Chat;

import java.util.ArrayList;
import java.util.List;

import static com.DmDev.collectionsPart1.task1.utility.Utility.*;

public class ChatRunner {

    public static void main(String[] args) {
        final int userThreshold = 1000;

        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Java Developers", 10000));
        chats.add(new Chat("Spring Enthusiasts", 800));
        chats.add(new Chat("SQL Masters", 20000));
        chats.add(new Chat("Advanced Java Developers", 1500));

        removeChatsWithFewUsers(chats, userThreshold);

        sortChatsByUserCountAndName(chats);
        printChats("Сортировка по количеству пользователей и названию:", chats);

        sortChatsByName(chats);
        printChats("\nСортировка по названию:", chats);
    }
}
