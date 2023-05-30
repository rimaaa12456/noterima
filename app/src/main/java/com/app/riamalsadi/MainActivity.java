package com.app.riamalsadi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.app.riamalsadi.modle.Notes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText edNotesT, edNotesD;
    private Button btnAddNote, btnAllNotes, btnLogout;
    private String noteTitle, noteDescription;
    private int idNote ;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Random rand ;
    private Notes notes;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Notes");

        notes = new Notes();
        rand = new Random();

        edNotesT = findViewById(R.id.edNotesT);
        edNotesD = findViewById(R.id.edNotesD);
        btnAddNote = findViewById(R.id.btnAddNote);
        btnAllNotes = findViewById(R.id.btnAllNotes);
        btnLogout = findViewById(R.id.btnLogout);

        btnAddNote.setOnClickListener(v -> {

            noteTitle = edNotesT.getText().toString();
            noteDescription = edNotesD.getText().toString();

             if (noteTitle.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please Enter Note Title", Toast.LENGTH_SHORT).show();
            }  if (noteDescription.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please Enter Note Description", Toast.LENGTH_SHORT).show();
            }  else {
                addNotes(noteTitle, noteDescription);
            }
        });
        btnAllNotes.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, AllNoteActivity.class);
            startActivity(i);
        });

        btnLogout.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });
    }
    private void addNotes(String title, String description) {
        Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();
        notes.setNoteTitle(title);
        notes.setNoteDescription(description);
        idNote = rand.nextInt(999999999);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child(idNote + "").setValue(notes);
                Toast.makeText(MainActivity.this, "The Note Has Been Added Successfully", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error : " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}