package com.kelompok3.rplinformatika.informaticslibrary.BookActivity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kelompok3.rplinformatika.informaticslibrary.Adapter.BukuAdapter;
import com.kelompok3.rplinformatika.informaticslibrary.R;

public class BookActivity extends AppCompatActivity {

    private Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //receive data
        Intent i =getIntent();
        String judulBuku = i.getStringExtra("buku_judul");
        String kategoriBuku = i.getStringExtra("buku_kategori");
        String pengarangBuku = i.getStringExtra("buku_pengarang");
        String penerbitBuku = i.getStringExtra("buku_penerbit");
        String TahunTerbitBuku = i.getStringExtra("buku_TahunTerbit");
        String keteranganBuku = i.getStringExtra("buku_keterangan");
        final String linkBuku = i.getStringExtra("buku_link");

        //view
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarBuku);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_judulBuku = findViewById(R.id.aa_judulBuku);
        TextView tv_kategoriBuku = findViewById(R.id.aa_kategoriBuku);
        TextView tv_pengarangBuku = findViewById(R.id.aa_pengarangBuku);
        TextView tv_penerbitBuku = findViewById(R.id.aa_penerbitBuku);
        TextView tv_tahunTerbitBuku = findViewById(R.id.aa_tahunTerbitBuku);
        TextView tv_keteranganBuku = findViewById(R.id.aa_keteranganBuku);


        //setting value
        tv_judulBuku.setText(judulBuku);
        tv_kategoriBuku.setText(kategoriBuku);
        tv_pengarangBuku.setText(pengarangBuku);
        tv_penerbitBuku.setText(penerbitBuku);
        tv_tahunTerbitBuku.setText(TahunTerbitBuku);
        tv_keteranganBuku.setText(keteranganBuku);

        download =findViewById(R.id.aa_downloadBuku);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(linkBuku));
                startActivity(intent);
            }
        });

    }
}
