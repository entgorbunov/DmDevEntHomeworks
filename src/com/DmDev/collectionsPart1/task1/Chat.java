package com.DmDev.collectionsPart1.task1;

// Определение класса чата
class Chat {
    String name;
    int userCount;

    public Chat(String name, int userCount) {
        this.name = name;
        this.userCount = userCount;
    }

    @Override
    public String toString() {
        return "Chat{" +
               "name='" + name + '\'' +
               ", userCount=" + userCount +
               '}';
    }
}



