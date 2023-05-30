package com.app.riamalsadi.modle;

public class Notes {

    private String NoteTitle ;
    private String NoteDescription ;

    public Notes() {
    }

    public Notes( String noteTitle, String noteDescription) {
        NoteTitle = noteTitle;
        NoteDescription = noteDescription;
    }

    public String getNoteTitle() {
        return NoteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        NoteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return NoteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        NoteDescription = noteDescription;
    }
}
