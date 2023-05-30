package com.app.riamalsadi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import com.app.riamalsadi.adapter.NotesAdapter;
import com.app.riamalsadi.modle.Notes;

import java.util.ArrayList;

public class AllNoteActivity extends AppCompatActivity {

    private RecyclerView notesRV ;
    private ImageView imgBack;
    private ArrayList<Notes> notesArrayList;
    private NotesAdapter notesAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_note);

        notesArrayList = new ArrayList<>();

        notesRV = findViewById(R.id.rvAllNote);
        imgBack = findViewById(R.id.imgBack);


        imgBack.setOnClickListener(view -> {
            finish();
        });

        notesArrayList.add(new Notes("Note Title 1","Note Description 1"));
        notesArrayList.add(new Notes("Note Title 2","Note Description 2"));
        notesArrayList.add(new Notes("Note Title 3","Note Description 3"));
        notesArrayList.add(new Notes("Note Title 4","Note Description 4"));
        notesArrayList.add(new Notes("Note Title 5","Note Description 5"));

        notesAdapter = new NotesAdapter(notesArrayList, this);
        notesRV.setLayoutManager(new LinearLayoutManager(this));
        notesRV.setAdapter(notesAdapter);


    }
}