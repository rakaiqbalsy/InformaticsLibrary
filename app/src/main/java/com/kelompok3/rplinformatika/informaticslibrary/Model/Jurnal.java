package com.kelompok3.rplinformatika.informaticslibrary.Model;

/**
 * Created by kelompok_3 on 5/15/18.
 */

public class Jurnal {
    private String jurnal;
    private String kategoriJurnal;
    private String author;
    private String civitas;
    private String tahunJurnal;
    private String abstrak;
    private String sumberJurnal;
    private String urlJurnal;

    public Jurnal() {
    }


    //overloading construktor
    public Jurnal(String jurnal, String kategoriJurnal, String author, String civitas, String tahunJurnal, String abstrak, String sumberJurnal, String urlJurnal) {
        this.jurnal = jurnal;
        this.kategoriJurnal = kategoriJurnal;
        this.author = author;
        this.civitas = civitas;
        this.tahunJurnal = tahunJurnal;
        this.abstrak = abstrak;
        this.sumberJurnal = sumberJurnal;
        this.urlJurnal = urlJurnal;
    }

    //getter
    public String getJurnal() {
        return jurnal;
    }

    public String getKategoriJurnal() {
        return kategoriJurnal;
    }

    public String getAuthor() {
        return author;
    }

    public String getCivitas() {
        return civitas;
    }

    public String getTahunJurnal() {
        return tahunJurnal;
    }

    public String getAbstrak() {
        return abstrak;
    }

    public String getSumberJurnal() {
        return sumberJurnal;
    }

    public String getUrlJurnal() {
        return urlJurnal;
    }

    //setter

    public void setJurnal(String jurnal) {
        this.jurnal = jurnal;
    }

    public void setKategoriJurnal(String kategoriJurnal) {
        this.kategoriJurnal = kategoriJurnal;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCivitas(String civitas) {
        this.civitas = civitas;
    }

    public void setTahunJurnal(String tahunJurnal) {
        this.tahunJurnal = tahunJurnal;
    }

    public void setAbstrak(String abstrak) {
        this.abstrak = abstrak;
    }

    public void setSumberJurnal(String sumberJurnal) {
        this.sumberJurnal = sumberJurnal;
    }

    public void setUrlJurnal(String urlJurnal) {
        this.urlJurnal = urlJurnal;
    }
}
