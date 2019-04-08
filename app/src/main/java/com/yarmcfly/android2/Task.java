package com.yarmcfly.android2;

public class Task {
    private final String name;
    private final int priority;
    private final int color;

    public Task(String name, int priority, int color) {
        this.name = name;
        this.priority = priority;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getColor() {
        return color;
    }

}