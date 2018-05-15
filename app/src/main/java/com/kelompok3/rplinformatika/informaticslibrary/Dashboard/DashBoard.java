package com.kelompok3.rplinformatika.informaticslibrary.Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kelompok3.rplinformatika.informaticslibrary.BookActivity.BookActivity;
import com.kelompok3.rplinformatika.informaticslibrary.BookActivity.MainActivityBook;
import com.kelompok3.rplinformatika.informaticslibrary.JurnalActivity.MainActivityJurnal;
import com.kelompok3.rplinformatika.informaticslibrary.R;

public class DashBoard extends AppCompatActivity {

    private Button cariBuku;
    private Button cariJurnal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

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
    }
}
