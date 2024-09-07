package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReceiverActivity extends AppCompatActivity {

    private EditText emailF;
    private EditText fullnameF;
    private EditText contactInfoF;
    private EditText countryF;
    private EditText addressF;
    private Button next;
    private String email;
    private String fullname;
    private String contact;
    private String country;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        Intent intent = getIntent();
        String senderEmail = intent.getStringExtra("senderEmail");
        String senderFullName = intent.getStringExtra("senderFullName");
        String senderContact = intent.getStringExtra("senderContact");
        String senderCountry = intent.getStringExtra("senderCountry");
        String senderAddress = intent.getStringExtra("senderAddress");

        emailF = findViewById(R.id.receiver_email_f);
        fullnameF = findViewById(R.id.receiver_full_name_f);
        contactInfoF = findViewById(R.id.receiver_contact_f);
        countryF = findViewById(R.id.receiver_country_f);
        addressF = findViewById(R.id.receiver_address_f);
        next = findViewById(R.id.receiver_nextbtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=emailF.getText().toString().trim();
                fullname=fullnameF.getText().toString().trim();
                contact=contactInfoF.getText().toString().trim();
                country=countryF.getText().toString().trim();
                address=addressF.getText().toString().trim();

                if(email.isEmpty() || fullname.isEmpty() || contact.isEmpty() ||country.isEmpty() ||address.isEmpty())
                {
                    Toast.makeText(ReceiverActivity.this,"All fields should be filled",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(ReceiverActivity.this, ReviewInfoActivity.class);
                    i.putExtra("senderEmail", senderEmail);
                    i.putExtra("senderFullName", senderFullName);
                    i.putExtra("senderContact", senderContact);
                    i.putExtra("senderCountry", senderCountry);
                    i.putExtra("senderAddress", senderAddress);
                    i.putExtra("receiverEmail", email);
                    i.putExtra("receiverFullName", fullname);
                    i.putExtra("receiverContact", contact);
                    i.putExtra("receiverCountry", country);
                    i.putExtra("receiverAddress", address);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}