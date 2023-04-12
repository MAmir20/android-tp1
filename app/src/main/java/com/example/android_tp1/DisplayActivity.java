package com.example.android_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplayActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ListView lv =findViewById(R.id.lv);
        SQLiteDatabase db = new DatabaseOpenHelper(DisplayActivity.this).getReadableDatabase();
        String[] selectColumns = {
                DatabaseOpenHelper.ID + " As _id",
                DatabaseOpenHelper.FNAME,
                DatabaseOpenHelper.LNAME,
                DatabaseOpenHelper.AGE,
                DatabaseOpenHelper.GENDER,
                DatabaseOpenHelper.PAYS,
                DatabaseOpenHelper.CK1,
                DatabaseOpenHelper.CK2,
        };
        Cursor cursor = db.query(
                DatabaseOpenHelper.TABLE_NAME,
                selectColumns,
                null,
                null,
                null,
                null,
                DatabaseOpenHelper.ID + " DESC"
        );
        ArrayList<HashMap<String,String>> dataList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                HashMap<String,String> datamap = new HashMap<>();
                datamap.put("_id", String.valueOf(cursor.getInt(0)));
                datamap.put("fname", cursor.getString(1));
                datamap.put("lname",cursor.getString(2) );
                datamap.put("age", String.valueOf(cursor.getInt(3)));
                datamap.put("genre", cursor.getString(4));
                datamap.put("pays", cursor.getString(5));
                datamap.put("ck1",String.valueOf(cursor.getInt(6)));
                datamap.put("ck2", String.valueOf(cursor.getInt(7)));
                dataList.add(datamap);
            } while (cursor.moveToNext());
        }
        SimpleAdapter sadapter=new SimpleAdapter(
                this,
                dataList,
                R.layout.item,
                new String[] {"_id","lname","fname","age","genre","pays","ck1","ck2"},
                new int[]{R.id.dbid,R.id.dbln,R.id.dbfn,R.id.dbage,R.id.dbgenre,R.id.dbpays,R.id.dbck1,R.id.dbck2}
        );
        lv.setAdapter(sadapter);
    }
}