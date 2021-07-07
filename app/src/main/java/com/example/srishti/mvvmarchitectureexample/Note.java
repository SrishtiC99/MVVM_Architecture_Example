package com.example.srishti.mvvmarchitectureexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


// Room Annotation
@Entity(tableName = "note_table") //by default name of the table would be Note but we are
                                    // defining the table_name here so that sqlite uses "note_table" as table name
public class Note {
    // Room will automatically generate fields for these variables
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private int priority;

    public Note(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
