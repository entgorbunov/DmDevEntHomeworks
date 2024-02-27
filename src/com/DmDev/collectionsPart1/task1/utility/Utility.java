package com.DmDev.collectionsPart1.task1.utility;

import com.DmDev.collectionsPart1.task1.base.Chat;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Utility {
    public static void removeChatsWithFewUsers(List<Chat> chats, int userThreshold) {
        Iterator<Chat> iterator = chats.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUserCount() < 1000) {
                iterator.remove();
            }
        }
    }

    public static void sortChatsByUserCountAndName(List<Chat> chats) {
        chats.sort(new Comparator<Chat>() {
            @Override
            public int compare(Chat o1, Chat o2) {
                int result = Integer.compare(o2.getUserCount(), o1.getUserCount());
                if (result == 0) {
                    result = o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });
    }

    public static void sortChatsByName(List<Chat> chats) {
        chats.sort(new Comparator<Chat>() {
            @Override
            public int compare(Chat o1, Chat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void printChats(String message, List<Chat> chats) {
        System.out.println(message);
        for (Chat chat : chats) {
            System.out.println(chat);
        }
    }
}
