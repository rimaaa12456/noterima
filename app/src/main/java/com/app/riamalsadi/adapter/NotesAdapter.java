package com.app.riamalsadi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.riamalsadi.R;
import com.app.riamalsadi.modle.Notes;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private ArrayList<Notes> notesList;
    private Context context;

    public NotesAdapter(ArrayList<Notes> notesArrayList, Context context) {
        this.notesList = notesArrayList;
        this.context = context;
    }

    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNls ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_all_notes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNls NotesAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Notes notes = notesList.get(position);
        holder.tvTNote.setText(notes.getNoteTitle());
        holder.tvNotesD.setText(notes.getNoteDescription());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTNote, tvNotesD;

        public ViewHolder(@NonNls View itemView) {
            super(itemView);
            tvTNote = itemView.findViewById(R.id.tvTNote);
            tvNotesD = itemView.findViewById(R.id.tvNotesD);
        }
    }
}
