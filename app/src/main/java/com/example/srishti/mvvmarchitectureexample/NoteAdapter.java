package com.example.srishti.mvvmarchitectureexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    List<Note> notes = new ArrayList<>();
    @NonNull
    @NotNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.titleTextView.setText(currentNote.getName());
        holder.descriptionTextView.setText(currentNote.getDescription());
        holder.priorityTextView.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;
        private TextView descriptionTextView;
        private TextView priorityTextView;

        public NoteHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textview_title);
            descriptionTextView = itemView.findViewById(R.id.textview_description);
            priorityTextView = itemView.findViewById(R.id.textview_priority);
        }
    }
}
