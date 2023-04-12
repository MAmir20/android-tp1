package com.example.android_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText op1 = findViewById(R.id.op1);
        EditText op2 = findViewById(R.id.op2);
        Button btnCalc = findViewById(R.id.buttonCalc);
        Button btnHis = findViewById(R.id.buttonHist);
        Spinner sp=findViewById(R.id.spinner);
        String[] operations=getResources().getStringArray(R.array.operation);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.item,
                R.id.itemTextView2,
                operations
        );
        sp.setAdapter(adapter);
        btnHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoriqueActivity.class);
                startActivity(intent);
            }
        });
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valOp1 = Double.parseDouble(op1.getText().toString());
                double valOp2 = Double.parseDouble(op2.getText().toString());
                String operation = sp.getSelectedItem().toString();
                double resultat = 0.0;
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                boolean test = true;
                switch (operation) {
                    case "+":
                        resultat = valOp1 + valOp2;
                        break;
                    case "-":
                        resultat = valOp1 - valOp2;
                        break;
                    case "*":
                        resultat = valOp1 * valOp2;
                        break;
                    case "/":
                        if(valOp2 != 0)
                            resultat = valOp1 / valOp2;
                        else {
                            test = false;
                            Toast.makeText(getApplicationContext(), "DIVISION PAR 0 INTERDITE", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                if(test) {
                    DatabaseOpenHelper db = new DatabaseOpenHelper(MainActivity.this);
                    db.create(valOp1,valOp2,resultat,operation);
                    intent.putExtra("resultat", resultat+"");
                    startActivity(intent);
                }
            }
        });
    }
}