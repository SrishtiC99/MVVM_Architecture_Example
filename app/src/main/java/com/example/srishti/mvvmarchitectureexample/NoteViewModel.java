package com.example.srishti.mvvmarchitectureexample;

import android.app.Application;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;
    public NoteViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }
    public void insert(Note note){
        repository.insert(note);
    }
    public void update(Note note){
        repository.insert(note);
    }
    public void delete(Note note){
        repository.insert(note);
    }
    public void deleteAllNotes(Note note){
        repository.insert(note);
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
