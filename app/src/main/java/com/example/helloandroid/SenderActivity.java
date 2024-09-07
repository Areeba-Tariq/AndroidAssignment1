package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_sender);
        View rootview = findViewById(R.id.main);

        emailF = findViewById(R.id.sender_email_f);
        fullnameF = findViewById(R.id.sender_full_name_f);
        contactInfoF = findViewById(R.id.sender_contact_f);
        countryF = findViewById(R.id.sender_country_f);
        addressF = findViewById(R.id.sender_address_f);
        next = findViewById(R.id.sender_nextbtn);

            Button nextbtn=findViewById(R.id.sender_nextbtn);
            nextbtn.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    email=emailF.getText().toString().trim();
                    fullname=fullnameF.getText().toString().trim();
                    contact=contactInfoF.getText().toString().trim();
                    country=countryF.getText().toString().trim();
                    address=addressF.getText().toString().trim();

                    if(email.isEmpty() || fullname.isEmpty() || contact.isEmpty() ||country.isEmpty() ||address.isEmpty())
                    {
                        Toast.makeText(SenderActivity.this,"All fields should be filled",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent i=new Intent(SenderActivity.this, ReceiverActivity.class);
                        i.putExtra("senderEmail", email);
                        i.putExtra("senderFullName", fullname);
                        i.putExtra("senderContact", contact);
                        i.putExtra("senderCountry", country);
                        i.putExtra("senderAddress", address);
                        startActivity(i);
                        finish();
                    }
                    }
            });
    }
}