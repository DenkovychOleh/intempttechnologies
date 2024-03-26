package com.intempttechnologies;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Group groupA = new Group(List.of(0, 1, 4), List.of(2, 5, 6));
        Group groupB = new Group(List.of(1, 3), List.of(4));
        Group groupC = new Group(List.of(0, 4, 6), List.of(2, 5));

        List<Integer> days = findDays(List.of(groupA, groupB, groupC));
        System.out.println(days);
    }

    public static List<Integer> findDays(List<Group> groups) {
        List<Integer> days = new ArrayList<>();

        // Loop for each day of the week
        for (int day = 0; day <= 6; day++) {
            boolean isInAllGroups = true;

            for (Group group : groups) {
                if (!belongsGroup(group, day)) {
                    isInAllGroups = false;
                    break;
                }
            }

            if (isInAllGroups) {
                days.add(day);
            }
        }

        return days;
    }

    public static boolean belongsGroup(Group group, int day) {
        List<Integer> enters = group.enters;
        List<Integer> exits = group.exits;

        for (int i = 0; i < enters.size(); i++) {
            // Check if exits.size > i and day >= entering and < exiting
            if (i < exits.size() && day >= enters.get(i) && day < exits.get(i)) {
                return true;
            }
        }

        return false;
    }

    static class Group {

        List<Integer> enters;

        List<Integer> exits;

        public Group(List<Integer> enters, List<Integer> exits) {
            this.enters = enters;
            this.exits = exits;
        }

    }

}