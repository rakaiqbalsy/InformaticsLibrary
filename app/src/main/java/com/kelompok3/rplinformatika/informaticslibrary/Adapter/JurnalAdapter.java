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

import com.kelompok3.rplinformatika.informaticslibrary.JurnalActivity.JurnalActivity;
import com.kelompok3.rplinformatika.informaticslibrary.Model.Jurnal;
import com.kelompok3.rplinformatika.informaticslibrary.R;

import java.util.List;

import javax.xml.transform.Templates;

/**
 * Created by rakaiqbalsy on 5/15/18.
 */

public class JurnalAdapter extends RecyclerView.Adapter<JurnalAdapter.MyViewHolderJurnal> {

    private Context jContext;
    private List<Jurnal> jData;

    public JurnalAdapter(Context jContext, List<Jurnal> jData) {
        this.jContext = jContext;
        this.jData = jData;
    }

    @NonNull
    @Override
    public MyViewHolderJurnal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(jContext);
        view = inflater.inflate(R.layout.jurnal_row_item, parent, false);

        final MyViewHolderJurnal viewHolderJurnal = new MyViewHolderJurnal(view);
        viewHolderJurnal.jurnal_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jContext, JurnalActivity.class);
                intent.putExtra("jurnal_judul", jData.get(viewHolderJurnal.getAdapterPosition()).getJurnal());
                intent.putExtra("jurnal_kategori", jData.get(viewHolderJurnal.getAdapterPosition()).getKategoriJurnal());
                intent.putExtra("jurnal_author", jData.get(viewHolderJurnal.getAdapterPosition()).getAuthor());
                intent.putExtra("jurnal_civitas", jData.get(viewHolderJurnal.getAdapterPosition()).getCivitas());
                intent.putExtra("jurnal_tahunJurnal", jData.get(viewHolderJurnal.getAdapterPosition()).getTahunJurnal());
                intent.putExtra("jurnal_abstrak", jData.get(viewHolderJurnal.getAdapterPosition()).getAbstrak());
                intent.putExtra("jurnal_sumberJurnal", jData.get(viewHolderJurnal.getAdapterPosition()).getSumberJurnal());
                intent.putExtra("jurnal_linkJurnal", jData.get(viewHolderJurnal.getAdapterPosition()).getUrlJurnal());

                jContext.startActivity(intent);
            }
        });


        return viewHolderJurnal;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderJurnal holder, int position) {

        holder.judul_jurnal.setText(jData.get(position).getJurnal());
        holder.kategori_jurnal.setText(jData.get(position).getKategoriJurnal());
        holder.author_jurnal.setText(jData.get(position).getAuthor());
        holder.tahun_jurnal.setText(jData.get(position).getTahunJurnal());

    }

    @Override
    public int getItemCount() {
        return jData.size();
    }

    public static class MyViewHolderJurnal extends RecyclerView.ViewHolder {

        TextView judul_jurnal;
        TextView kategori_jurnal;
        TextView author_jurnal;
        TextView tahun_jurnal;
        LinearLayout jurnal_container;

        public MyViewHolderJurnal(View itemView) {
            super(itemView);

            jurnal_container = itemView.findViewById(R.id.kontenerJurnal);
            judul_jurnal = itemView.findViewById(R.id.judulJurnal);
            kategori_jurnal = itemView.findViewById(R.id.kategoriJurnal);
            author_jurnal = itemView.findViewById(R.id.authorJurnal);
            tahun_jurnal = itemView.findViewById(R.id.tahunJurnal);

        }
    }
}