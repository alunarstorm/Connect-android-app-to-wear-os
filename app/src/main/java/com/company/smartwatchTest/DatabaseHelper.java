package com.company.smartwatchTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "questionnaire.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the questionnaire table and define its columns
        String CREATE_QUESTIONNAIRE_TABLE = "CREATE TABLE questionnaire (" +
                "id INTEGER PRIMARY KEY, " +
                "question TEXT, " +
                "option1 TEXT, " +
                "option2 TEXT, " +
                "option3 TEXT, " +
                "option4 TEXT" + ")";

        db.execSQL(CREATE_QUESTIONNAIRE_TABLE);

        // Create the user_questions table
        String CREATE_USER_QUESTIONS_TABLE = "CREATE TABLE user_questions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "question TEXT, " +
                "option1 TEXT, " +
                "option2 TEXT, " +
                "option3 TEXT, " +
                "option4 TEXT" + ")";

        db.execSQL(CREATE_USER_QUESTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This method will be called when the database needs to be upgraded.
        db.execSQL("DROP TABLE IF EXISTS questionnaire");
        db.execSQL("DROP TABLE IF EXISTS user_questions");
        onCreate(db);
    }

    public void insertQuestion(int id, String question, String option1, String option2, String option3, String option4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", id);
        contentValues.put("question", question);
        contentValues.put("option1", option1);
        contentValues.put("option2", option2);
        contentValues.put("option3", option3);
        contentValues.put("option4", option4);

        db.insert("questionnaire", null, contentValues);
    }

    public void insertUserQuestion(String question, String option1, String option2, String option3, String option4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("question", question);
        contentValues.put("option1", option1);
        contentValues.put("option2", option2);
        contentValues.put("option3", option3);
        contentValues.put("option4", option4);

        db.insert("user_questions", null, contentValues);
    }

    public void deleteUserQuestion(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("user_questions", "id = ?", new String[] { String.valueOf(id) });
    }

}


