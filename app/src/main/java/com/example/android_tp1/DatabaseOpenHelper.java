package com.example.android_tp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    //columns definition + table name
    public static final String ID = "id";
    public static final String FNAME = "fname";
    public static final String LNAME = "lname";
    public static final String AGE = "age";
    public static final String GENDER = "genre";
    public static final String PAYS = "pays";
    public static final String CK1 = "ck1";
    public static final String CK2 = "ck2";


    public static final String TABLE_NAME = "Formulaire";
    //Création d'une table
    private static final String SQLCreateTableFormulaire =
            "CREATE TABLE " +TABLE_NAME+ " ( "
                    + ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FNAME + " TEXT, "
                    + LNAME + " TEXT, "
                    + AGE + " NUMBER, "
                    + GENDER + " TEXT, "
                    + PAYS + " TEXT, "
                    + CK1 + " NUMBER, "
                    + CK2 + " NUMBER "
                    + " )";
    public static final int databaseVersion = 4;
    public static final String databaseName = "formulaireDB";
    private static final String SQLDropTableFormulaire = "DROP TABLE IF EXISTS "+TABLE_NAME ;
    private final Context context;
    public DatabaseOpenHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQLCreateTableFormulaire);
    }
    @Override //mise à jour
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLDropTableFormulaire);
        onCreate(db);
    }
    public void ajouter(String fname, String lname, int age, String gender, String pays, int ck1, int ck2){
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fname", fname);
        values.put("lname", lname);
        values.put("age", age);
        values.put("genre", gender);
        values.put("pays", pays);
        values.put("ck1", ck1);
        values.put("ck2", ck2);
        long result = bd.insert(TABLE_NAME, null, values) ;
        if (result == -1){
            Toast.makeText(context, "Failed !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Succeeded !", Toast.LENGTH_SHORT).show();
        }
        bd.close() ;
    }

}
