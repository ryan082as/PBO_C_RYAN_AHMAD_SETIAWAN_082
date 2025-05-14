package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(){
        String validNama = "ryan ahmad setiawan";
        String validNim = "202410370110082";

        return getNama().equals(validNama) && getNim().equals(validNim);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu Mahasiswa:");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItem();
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nLaporkan Barang:");
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();

        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        System.out.println("\nLaporan berhasil dibuat!");
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi: " + lokasi);
    }

    @Override
    public void viewReportedItem() {
        System.out.println("\n>> Fitur Lihat Laporan Belum Tersedia <<");
    }
}
