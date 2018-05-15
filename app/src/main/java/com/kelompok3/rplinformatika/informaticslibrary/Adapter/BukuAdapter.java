package com.kelompok3.rplinformatika.informaticslibrary.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kelompok3.rplinformatika.informaticslibrary.BookActivity.BookActivity;
import com.kelompok3.rplinformatika.informaticslibrary.Model.Book;
import com.kelompok3.rplinformatika.informaticslibrary.R;


import java.util.List;

/**
 * Created by rakaiqbalsy on 5/14/18.
 */

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.MyViewHolderBuku>{


    private Context mContext;
    private List<Book> mData;

    public BukuAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolderBuku onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.book_row_item, parent, false);
        final MyViewHolderBuku viewHolderBuku = new MyViewHolderBuku(view);
        viewHolderBuku.buku_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, BookActivity.class);
                i.putExtra("buku_judul", mData.get(viewHolderBuku.getAdapterPosition()).getJudul());
                i.putExtra("buku_kategori", mData.get(viewHolderBuku.getAdapterPosition()).getKategori());
                i.putExtra("buku_pengarang", mData.get(viewHolderBuku.getAdapterPosition()).getPengarang());
                i.putExtra("buku_penerbit", mData.get(viewHolderBuku.getAdapterPosition()).getPenerbit());
                i.putExtra("buku_TahunTerbit", mData.get(viewHolderBuku.getAdapterPosition()).getTahunTerbit());
                i.putExtra("buku_keterangan", mData.get(viewHolderBuku.getAdapterPosition()).getKeterangan());
                i.putExtra("buku_link", mData.get(viewHolderBuku.getAdapterPosition()).getLinkBuku());

                mContext.startActivity(i);
            }
        });


        return viewHolderBuku;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderBuku holder, int position) {

        holder.judul_buku.setText(mData.get(position).getJudul());
        holder.pengarang_buku.setText(mData.get(position).getPengarang());
        holder.kategori_buku.setText(mData.get(position).getKategori());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderBuku extends RecyclerView.ViewHolder {

        TextView judul_buku;
        TextView kategori_buku;
        TextView pengarang_buku;
        LinearLayout buku_container;

        public MyViewHolderBuku(View itemView) {
            super(itemView);

            buku_container = itemView.findViewById(R.id.kontenerBuku);
            judul_buku = itemView.findViewById(R.id.judulBuku);
            kategori_buku = itemView.findViewById(R.id.kategoriBuku);
            pengarang_buku = itemView.findViewById(R.id.pengarangBuku);
        }
    }
}