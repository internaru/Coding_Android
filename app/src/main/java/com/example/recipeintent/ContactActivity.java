package com.example.recipeintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact);

        // Intent 가져오기.
        Intent intent = getIntent() ;

        // No 값을 int 타입에서 String 타입으로 변환하여 표시.
        TextView textViewNo = (TextView) findViewById(R.id.textViewNo) ;
        int no = intent.getIntExtra("contact_no", 0) ;
        textViewNo.setText(Integer.toString(no)) ;

        // Name 값을 String 타입 그대로 표시.
        TextView textViewName = (TextView) findViewById(R.id.textViewName) ;
        String name = intent.getStringExtra("contact_name") ;
        if (name != null)
            textViewName.setText(name) ;

        // Phone 값을 String 타입 그대로 표시.
        TextView textViewPhone = (TextView) findViewById(R.id.textViewPhone) ;
        String phone = intent.getStringExtra("contact_phone") ;
        if (phone != null)
            textViewPhone.setText(phone) ;

        // Over 20 값을 boolean 타입 그대로 검사하여 표시.
        TextView textViewOver20 = (TextView) findViewById(R.id.textViewOver20) ;
        boolean over20 = intent.getBooleanExtra("contact_over20", false) ;
        if (over20)
            textViewOver20.setText("Over 20") ;
        else
            textViewOver20.setText("Not over 20") ;
    }
}