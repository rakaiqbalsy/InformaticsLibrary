package com.kelompok3.rplinformatika.informaticslibrary.Model;

/**
 * Created by kelompok3 on 5/14/18.
 */

public class Book {
    private String judul;
    private String pengarang;
    private String penerbit;
    private String TahunTerbit;
    private String Keterangan;
    private String linkBuku;
    private String Kategori;

    public Book() {

    }

    public Book(String judul, String pengarang, String penerbit, String tahunTerbit, String keterangan, String linkBuku, String kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        TahunTerbit = tahunTerbit;
        Keterangan = keterangan;
        this.linkBuku = linkBuku;
        Kategori = kategori;
    }

    //getter

    public String getJudul() {
        return judul;
    }

    public String getKategori() {return Kategori;}

    public String getPengarang() {
        return pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getTahunTerbit() {
        return TahunTerbit;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public String getLinkBuku() {
        return linkBuku;
    }

    //setter


    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKategori(String kategori) { Kategori = kategori;}

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        TahunTerbit = tahunTerbit;
    }

    public void setKeterangan(String keterangan) {
        Keterangan = keterangan;
    }

    public void setLinkBuku(String linkBuku) {
        this.linkBuku = linkBuku;
    }
}
