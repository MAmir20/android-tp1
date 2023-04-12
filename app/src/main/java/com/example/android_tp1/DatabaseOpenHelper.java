package com.example.android_tp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    //columns definition + table name
    public static final String ID = "ID";
    public static final String OP1 = "OP1";
    public static final String OP2 = "OP2";
    public static final String OPR = "OPR";
    public static final String RES = "RES";
    public static final String TABLE_NAME = "Calcul";
    //Création d'une table
    private static final String SQLCreateTableArticles =
            "CREATE TABLE " +TABLE_NAME+ " ( "+ ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " + OP1 + " REAL, " + OPR + " TEXT, " + OP2 + " REAL, " + RES + " REAL " + " )";
    public static final int databaseVersion = 4;
    public static final String databaseName = "calculDB";
    private static final String SQLDeleteTableArticles = "DROP TABLE IF EXISTS Calcul" ;
    private final Context context;
    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, databaseName, null, databaseVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLCreateTableArticles);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLDeleteTableArticles);
        onCreate(sqLiteDatabase);
    }

    public void create(double op1, double op2, double res, String opr){
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("OP1", op1);
        values.put("OPR", opr);
        values.put("OP2", op2);
        values.put("RES", res);
        long result = bd.insert(TABLE_NAME,null, values);
        if (result == -1){
            Toast.makeText(context, "Failed !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "succeeded !", Toast.LENGTH_SHORT).show();
        }
        bd.close() ;
    }
}
