package com.kelompok3.rplinformatika.informaticslibrary.BookActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.kelompok3.rplinformatika.informaticslibrary.Adapter.BukuAdapter;
import com.kelompok3.rplinformatika.informaticslibrary.Model.Book;
import com.kelompok3.rplinformatika.informaticslibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivityBook extends AppCompatActivity {

    private final String JSON_BOOK_URL = "https://gist.githubusercontent.com/rakaiqbalsy/58c67ff430685261ec50d1b1f437b209/raw/0cd3fafab4410b0708584b87c9822f97a3c8a340/ListBuku.json";
    private JsonArrayRequest bookRequest;
    private RequestQueue requestBookQueue;
    private List<Book> firstBook;
    private RecyclerView recyclerViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_book);

        firstBook = new ArrayList<>();

        recyclerViewBook = findViewById(R.id.recyclerViewBuku);
        jsonBookRequest();

    }

    private void jsonBookRequest() {

        bookRequest = new JsonArrayRequest(JSON_BOOK_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i=0; i<response.length(); i++) {
                    try{
                        jsonObject = response.getJSONObject(i);
                        Book book = new Book();
                        book.setJudul(jsonObject.getString("Judul"));
                        book.setKategori(jsonObject.getString("Kategori"));
                        book.setPenerbit(jsonObject.getString("Penerbit"));
                        book.setTahunTerbit(jsonObject.getString("TahunTerbit"));
                        book.setKeterangan(jsonObject.getString("Keterangan"));
                        book.setLinkBuku(jsonObject.getString("linkBuku"));

                        firstBook.add(book);
                    }


                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerviewBook(firstBook);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

        requestBookQueue = Volley.newRequestQueue(MainActivityBook.this);
        requestBookQueue.add(bookRequest);

    }

    private void setuprecyclerviewBook(List<Book> firstBook) {

        BukuAdapter myBookAdapter = new BukuAdapter(this, firstBook);
        recyclerViewBook.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewBook.setAdapter(myBookAdapter);

    }
}
