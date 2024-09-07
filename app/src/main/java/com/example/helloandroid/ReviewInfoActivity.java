package com.example.helloandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReviewInfoActivity extends AppCompatActivity {

    private TextView s_nameTextView, s_countryTextView, s_addressTextView, s_contactInfoTextView;
    private TextView r_nameTextView, r_countryTextView, r_addressTextView, r_contactInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_info);

        Intent intent = getIntent();
        String senderEmail = intent.getStringExtra("senderEmail");
        String senderName = intent.getStringExtra("senderFullName");
        String senderContact = intent.getStringExtra("senderContact");
        String senderCountry = intent.getStringExtra("senderCountry");
        String senderAddress = intent.getStringExtra("senderAddress");
        String receiverEmail = intent.getStringExtra("receiverEmail");
        String receiverName = intent.getStringExtra("receiverFullName");
        String receiverContact = intent.getStringExtra("receiverContact");
        String receiverCountry = intent.getStringExtra("receiverCountry");
        String receiverAddress = intent.getStringExtra("receiverAddress");

        s_nameTextView = findViewById(R.id.Sendername);
        s_countryTextView = findViewById(R.id.sendercountry);
        s_addressTextView = findViewById(R.id.senderaddress);
        s_contactInfoTextView = findViewById(R.id.sendercontactinfo);
        r_nameTextView = findViewById(R.id.receivername);
        r_countryTextView = findViewById(R.id.receivercountry);
        r_addressTextView = findViewById(R.id.receiveraddress);
        r_contactInfoTextView = findViewById(R.id.receivercontactinfo);



        s_nameTextView.setText(senderName);
        s_countryTextView.setText(senderCountry);
        s_addressTextView.setText( senderAddress);
        s_contactInfoTextView.setText(senderContact);
        r_nameTextView.setText(receiverName);


        r_countryTextView.setText(receiverCountry);
        r_addressTextView.setText(receiverAddress);
        r_contactInfoTextView.setText(receiverContact);

        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ReviewInfoActivity.this, SenderActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}