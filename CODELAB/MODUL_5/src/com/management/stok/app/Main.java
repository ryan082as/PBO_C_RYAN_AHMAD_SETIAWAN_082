package com.management.stok.app;

import com.management.stok.barang.Barang;
import com.management.stok.barang.exception.StokTidakCukupException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Tambahkan beberapa data awal untuk pengujian
        daftarBarang.add(new Barang("Buku", 50));
        daftarBarang.add(new Barang("Pensil", 100));
        daftarBarang.add(new Barang("Penghapus", 30));

        boolean isRunning = true;
        while (isRunning) {
            tampilkanMenu();
            System.out.print("Pilih opsi: ");
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        tambahBarang();
                        break;
                    case 2:
                        tampilkanSemuaBarang();
                        break;
                    case 3:
                        kurangiStok();
                        break;
                    case 0:
                        isRunning = false;
                        System.out.println("Terima kasih! Program berakhir.");
                        break;
                    default:
                        System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // Membersihkan input yang salah
            }
        }
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n===== Menu Manajemen Stok =====");
        System.out.println("1. Tambah Barang Baru");
        System.out.println("2. Tampilkan Semua Barang");
        System.out.println("3. Kurangi Stok Barang");
        System.out.println("0. Keluar");
    }

    private static void tambahBarang() {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        try {
            System.out.print("Masukkan stok awal: ");
            int stok = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            Barang barangBaru = new Barang(nama, stok);
            daftarBarang.add(barangBaru);
            System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Input stok harus berupa angka!");
            scanner.nextLine(); // Membersihkan input yang salah
        }
    }

    private static void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }

        System.out.println("\n--- Daftar Barang ---");
        Iterator<Barang> iterator = daftarBarang.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Barang barang = iterator.next();
            System.out.println(index + ". Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
            index++;
        }
    }

    private static void kurangiStok() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong. Tidak ada yang bisa dikurangi.");
            return;
        }

        // Tampilkan daftar barang dengan indeks
        System.out.println("\n--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println(i + ". " + barang.getNama() + " (Stok: " + barang.getStok() + ")");
        }

        try {
            System.out.print("Masukkan nomor indeks barang: ");
            int indeks = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            System.out.print("Masukkan jumlah stok yang akan diambil: ");
            int jumlahDiambil = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            // Validasi indeks
            if (indeks < 0 || indeks >= daftarBarang.size()) {
                System.out.println("Indeks tidak valid!");
                return;
            }

            Barang barang = daftarBarang.get(indeks);

            // Validasi stok cukup
            if (jumlahDiambil > barang.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + barang.getNama() +
                        " hanya tersisa " + barang.getStok());
            }

            // Kurangi stok
            barang.setStok(barang.getStok() - jumlahDiambil);
            System.out.println("Stok barang '" + barang.getNama() +
                    "' berhasil dikurangi. Sisa stok: " + barang.getStok());

        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine(); // Membersihkan input yang salah
        } catch (StokTidakCukupException e) {
            System.out.println(e.getMessage());
        }
    }
}
