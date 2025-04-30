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
        Anggota anggota3 = new Anggota("asep hidayat", "C089");
        // Menampilkan info anggota
        anggota1.DisplayInfo();
        anggota2.DisplayInfo();
        System.out.println();

        // Proses peminjaman
        anggota1.PinjamBuku("Requiem for Battleship Yamato");
        anggota2.PinjamBuku("Kage no Jitsuryokusha ni Naritakute!", 14);
        anggota1.PinjamBuku("bulan bintang");
        System.out.println();

        // Proses pengembalian
        anggota1.KembalikanBuku("Requiem for Battleship Yamato");
        anggota2.KembalikanBuku("Kage no Jitsuryokusha ni Naritakute!");
        anggota2.KembalikanBuku("bulan bintang");
    }
}


/*Pakage		seperti folder baru
		Contoh:		 import perpustakaan.*;		package perpustakaan;

Abstrak		 1 2 = new 3	 boleh ga harus 		1 2 = new 1

interface 	mirip abstrak tapi isinya hanya method yang bisa dipakai turunannya dan implement bisa lebih dari 1 sedangkan extend hanya bisa 1 saja

polymorphism		1 method bisa berbeda beda bentuk

overlo		bisa ada 2 method yang sama tapi parameter nya berbeda dalam 1 class

public NonFiksi(String judul, String penulis, String bidang) {  // bold + miring itu parameter
    super(judul, penulis);
    this.bidang = bidang;  // kiri parameter dan kanan objek

//
abstrak = Buku NonFiksi = new NonFiksi("Requiem for Battleship Yamato", "Mitsuru Yoshida", "Sejarah & Ilmu Pengetahuan");

polymorphism = Nonfiksi = new Buku();

normal  = NonFiksi NonFiksi = new NonFiksi();
//
*/