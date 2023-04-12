package com.example.android_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp=findViewById(R.id.spinner);
        String[] pays = getResources().getStringArray(R.array.pays);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.item,
                R.id.itemTextView,
                pays
        );
        sp.setAdapter(adapter);
        Button btn=findViewById(R.id.button);
        EditText fname=findViewById(R.id.Fname);
        EditText lname=findViewById(R.id.Lname);
        EditText age=findViewById(R.id.age);
        RadioButton rb1=findViewById(R.id.Rb1);
        RadioButton rb2=findViewById(R.id.Rb2);
        CheckBox ck1=findViewById(R.id.ck1);
        CheckBox ck2=findViewById(R.id.ck2);
        LinearLayout layout=findViewById(R.id.layout);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean test=true;
                TextView fnerror=findViewById(R.id.fnerror);
                TextView lnerror=findViewById(R.id.lnerror);
                TextView ageerror=findViewById(R.id.ageerror);
                TextView ckerror=findViewById(R.id.ckerror);
                TextView payserror=findViewById(R.id.payserror);

                if(fname.getText().toString().length()<2){
                    if(fnerror==null) {
                        fnerror = new TextView(getApplicationContext());
                        fnerror.setId(R.id.fnerror);
                        fnerror.setText("Le nom doit avoir au min 2 caractères!!");
                        fnerror.setTextColor(getColor(R.color.red));
                        fnerror.setTextSize(18);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        fnerror.setLayoutParams(params);
                        layout.addView(fnerror, layout.indexOfChild(fname) + 1);
                    }
                    test = false;

                }
                else{
                    if(fnerror!=null){
                        //error.setText("");
                        layout.removeView(fnerror);
                    }
                }
                
                if(lname.getText().toString().length()<2){
                    if(lnerror==null) {
                        lnerror = new TextView(getApplicationContext());
                        lnerror.setId(R.id.lnerror);
                        lnerror.setText("Le prénom doit avoir au min 2 caractères!!");
                        lnerror.setTextColor(getColor(R.color.red));
                        lnerror.setTextSize(18);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        lnerror.setLayoutParams(params);
                        layout.addView(lnerror, layout.indexOfChild(lname) + 1);
                    }
                    test = false;

                }
                else{
                    if(lnerror!=null){
                        //error.setText("");
                        layout.removeView(lnerror);
                    }
                }

                if(Integer.parseInt(age.getText().toString())<18){
                    if(ageerror==null) {
                        ageerror = new TextView(getApplicationContext());
                        ageerror.setId(R.id.ageerror);
                        ageerror.setText("Cette application est accessible seulement pour ceux d'age +18!!");
                        ageerror.setTextColor(getColor(R.color.red));
                        ageerror.setTextSize(18);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        ageerror.setLayoutParams(params);
                        layout.addView(ageerror, layout.indexOfChild(age) + 1);
                    }
                    test = false;

                }
                else{
                    if(ageerror!=null){
                        //error.setText("");
                        layout.removeView(ageerror);
                    }
                }
                
                if(sp.getSelectedItem().toString().length()==0){
                    if(payserror==null) {
                        payserror = new TextView(getApplicationContext());
                        payserror.setId(R.id.payserror);
                        payserror.setText("Selectionner un pays!!");
                        payserror.setTextColor(getColor(R.color.red));
                        payserror.setTextSize(18);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        ckerror.setLayoutParams(params);
                        layout.addView(payserror, layout.indexOfChild(sp) + 1);
                    }
                    test = false;

                }
                else{
                    if(payserror!=null){
                        //error.setText("");
                        layout.removeView(payserror);
                    }
                }
                
                if((!ck1.isChecked())&&(!ck2.isChecked())){
                    if(ckerror==null) {
                        ckerror = new TextView(getApplicationContext());
                        ckerror.setId(R.id.ckerror);
                        ckerror.setText("Choisir un centre d'interet!!");
                        ckerror.setTextColor(getColor(R.color.red));
                        ckerror.setTextSize(18);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        ckerror.setLayoutParams(params);
                        layout.addView(ckerror, layout.indexOfChild(ck2) + 1);
                    }
                    test = false;

                }
                else{
                    if(ckerror!=null){
                        //error.setText("");
                        layout.removeView(ckerror);
                    }
                }
                if(test){
                    Toast.makeText(getApplicationContext(), "validation réussie", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}