package com.DmDev.collectionsPart1.task2.utility;

import com.DmDev.collectionsPart1.task2.base.User;

import java.util.Comparator;

public class UserAgeComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        var ageCompare = Integer.compare(u1.getAge(), u2.getAge());
        if (ageCompare == 0) {
            return Integer.compare(u1.getId(), u2.getId());
        }
        return ageCompare;
    }
}
