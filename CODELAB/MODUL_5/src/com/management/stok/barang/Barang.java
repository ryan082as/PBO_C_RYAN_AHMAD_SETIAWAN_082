package com.management.stok.barang;

public class Barang {
    private String nama;
    private int stok;

    public Barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

}