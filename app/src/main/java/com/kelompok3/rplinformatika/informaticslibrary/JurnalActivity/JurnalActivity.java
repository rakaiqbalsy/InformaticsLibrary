package com.kelompok3.rplinformatika.informaticslibrary.JurnalActivity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kelompok3.rplinformatika.informaticslibrary.R;


public class JurnalActivity extends AppCompatActivity {

    private Button jdownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal);


        //receive data
        Intent intent = getIntent();
        String judulJurnal = intent.getStringExtra("jurnal_judul");
        String kategoriJurnal = intent.getStringExtra("jurnal_kategori");
        String authorJurnal = intent.getStringExtra("jurnal_author");
        String civitasJurnal = intent.getStringExtra("jurnal_civitas");
        String tahunJurnal = intent.getStringExtra("jurnal_tahunJurnal");
        String abstrakJurnal = intent.getStringExtra("jurnal_abstrak");
        String sumberJurnal = intent.getStringExtra("jurnal_sumberJurnal");
        final String linkJurnal = intent.getStringExtra("jurnal_linkJurnal");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarJurnal);
        collapsingToolbarLayout.setTitleEnabled(true);


        TextView juduljurnal = findViewById(R.id.aa_judulJurnal);
        TextView kategorijurnal = findViewById(R.id.aa_kategoriJurnal);
        TextView author = findViewById(R.id.aa_authorJurnal);
        TextView civitas = findViewById(R.id.aa_civitasJurnal);
        TextView tahunjurnal = findViewById(R.id.aa_tahunJurnal);
        TextView abstrak = findViewById(R.id.aa_abstrakJurnal);
        TextView sumber = findViewById(R.id.aa_sumberJurnal);


        //set data
        juduljurnal.setText(judulJurnal);
        kategorijurnal.setText(kategoriJurnal);
        author.setText(authorJurnal);
        civitas.setText(civitasJurnal);
        tahunjurnal.setText(tahunJurnal);
        abstrak.setText(abstrakJurnal);
        sumber.setText(sumberJurnal);

        jdownload =findViewById(R.id.aa_downloadJurnal);
        jdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(linkJurnal));
                startActivity(i);
            }
        });

    }
}