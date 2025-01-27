package com.example.recipeintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button buttonStartActivity = (Button) findViewById(R.id.buttonStartActivity) ;
        buttonStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class) ;

                // No 입력 값을 int 값으로 변환하여 전달.
                EditText editTextNo = (EditText) findViewById(R.id.editTextNo) ;
                String strNo = editTextNo.getText().toString() ;
                if (!strNo.isEmpty() && strNo.matches("^[0-9]*$")) { // check numbers by RegEx.
                    intent.putExtra("contact_no", Integer.parseInt(strNo)) ;
                } else {
                    intent.putExtra("contact_no", 0) ;
                }

                // Name 입력 값을 String 값으로 그대로 전달.
                EditText editTextName = (EditText) findViewById(R.id.editTextName) ;
                intent.putExtra("contact_name", editTextName.getText().toString()) ;

                // Phone 입력 값을 String 값으로 그대로 전달.
                EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone) ;
                intent.putExtra("contact_phone", editTextPhone.getText().toString()) ;

                // Over20 값을 boolean 값으로 전달.
                CheckBox checkBoxOver20 = (CheckBox) findViewById(R.id.checkBoxOver20) ;
                intent.putExtra("contact_over20", checkBoxOver20.isChecked()) ;

                startActivity(intent) ;
            }
        });
    }
}