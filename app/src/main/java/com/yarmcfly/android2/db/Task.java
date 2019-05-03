package com.yarmcfly.android2.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;


@Entity
public class Task implements Serializable {
    private static final long serialVersionUID = -1251460818203490421L;


    @PrimaryKey(autoGenerate = true)
    public int id;
    public final String name;
    public final int priority;


    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}