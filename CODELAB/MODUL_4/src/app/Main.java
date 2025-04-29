package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        // Membuat objek buku
        Buku NonFiksi = new NonFiksi("Requiem for Battleship Yamato", "Mitsuru Yoshida", "Sejarah & Ilmu Pengetahuan");
        Buku Fiksi = new Fiksi("Kage no Jitsuryokusha ni Naritakute!", "Daisuke Aizawa", "Isekai & Fantasi");

        // Menampilkan info buku
        NonFiksi.DisplayInfo();
        Fiksi.DisplayInfo();
        System.out.println();

        // Membuat objek anggota
        Anggota anggota1 = new Anggota("Thouf Hazza Tedya Putera", "C066");
        Anggota anggota2 = new Anggota("Muhammad Faiz Hidayat", "C077");

        // Menampilkan info anggota
        anggota1.DisplayInfo();
        anggota2.DisplayInfo();
        System.out.println();

        // Proses peminjaman
        anggota1.PinjamBuku("Requiem for Battleship Yamato");
        anggota2.PinjamBuku("Kage no Jitsuryokusha ni Naritakute!", 14);
        System.out.println();

        // Proses pengembalian
        anggota1.KembalikanBuku("Requiem for Battleship Yamato");
        anggota2.KembalikanBuku("Kage no Jitsuryokusha ni Naritakute!");
    }
}