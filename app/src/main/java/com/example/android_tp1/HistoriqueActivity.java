package com.example.android_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoriqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        ListView lv = findViewById(R.id.listview);
        SQLiteDatabase db = new DatabaseOpenHelper(HistoriqueActivity.this).getReadableDatabase();
        String[] selectColumns = {
                DatabaseOpenHelper.ID + " As _id",
                DatabaseOpenHelper.OP1,
                DatabaseOpenHelper.OPR,
                DatabaseOpenHelper.OP2,
                DatabaseOpenHelper.RES,
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
                int id = cursor.getInt(0);
                HashMap<String,String> datamap = new HashMap<>();
                datamap.put("_id", String.valueOf(id));
                String op = cursor.getDouble(1) + " " + cursor.getString(2) + " " + cursor.getDouble(3)+ " " + " = " + cursor.getDouble(4);
                datamap.put("operation",op);
                dataList.add(datamap);
            } while (cursor.moveToNext());
        }

       /* ArrayAdapter adapter = new ArrayAdapter(
                this,
                R.layout.item,
                R.id.itemTextView,
                dataList
        );*/

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dataList,
                R.layout.item,
                new String[] {"_id","operation"},
                new int[] {R.id.itemTextView2,R.id.itemTextView}
        );
        lv.setAdapter(adapter);
    }
}