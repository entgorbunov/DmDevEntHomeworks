package com.DmDev.collectionsPart1.task1.base;

import java.util.Objects;

// Определение класса чата
public class Chat {
    private String name;
    private Integer userCount;

    public Chat(String name, Integer userCount) {
        this.name = name;
        this.userCount = userCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return userCount == chat.userCount && Objects.equals(name, chat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userCount);
    }

    @Override
    public String toString() {
        return "Chat{" +
               "name='" + name + '\'' +
               ", userCount=" + userCount +
               '}';
    }
}



