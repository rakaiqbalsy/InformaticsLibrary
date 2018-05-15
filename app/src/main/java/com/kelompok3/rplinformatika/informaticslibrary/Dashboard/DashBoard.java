package com.kelompok3.rplinformatika.informaticslibrary.Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.kelompok3.rplinformatika.informaticslibrary.BookActivity.BookActivity;
import com.kelompok3.rplinformatika.informaticslibrary.BookActivity.MainActivityBook;
import com.kelompok3.rplinformatika.informaticslibrary.JurnalActivity.MainActivityJurnal;
import com.kelompok3.rplinformatika.informaticslibrary.LoginAndRegister.LoginActivity;
import com.kelompok3.rplinformatika.informaticslibrary.R;

public class DashBoard extends AppCompatActivity {

    private Button cariBuku;
    private Button cariJurnal;
    private Button Bantuan;
    private Button Keluar;

    private TextView textViewUser;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null ) {
            finish();
            Intent i = new Intent(DashBoard.this, LoginActivity.class);
            startActivity(i);
        }

        cariBuku=findViewById(R.id.buttoncaribuku);
        cariBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivityBook.class);
                startActivity(i);
            }
        });

        cariJurnal = findViewById(R.id.buttoncarijurnal);
        cariJurnal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivityJurnal.class);
                startActivity(i);
            }
        });

        Keluar = findViewById(R.id.buttonkeluar);
        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent(DashBoard.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Bantuan = findViewById(R.id.buttonbantuan);
    }
}
