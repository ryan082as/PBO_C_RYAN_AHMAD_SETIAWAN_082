package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.model.Item;
import com.praktikum.main.Main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login() {
        // Login now handled by Main class authentication
        return true;
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

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 0:
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // Clear invalid input
                choice = -1;
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

        // Create new item and add to reportedItems
        Item newItem = new Item(namaBarang, deskripsi, lokasi);
        Main.reportedItems.add(newItem);

        System.out.println("\nLaporan berhasil dibuat!");
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi: " + lokasi);
    }

    @Override
    public void viewReportedItems() {
        if (Main.reportedItems.isEmpty()) {
            System.out.println("\nBelum ada laporan barang.");
            return;
        }

        System.out.println("\nDaftar Barang yang Dilaporkan:");
        int count = 0;
        for (Item item : Main.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println("- " + item.getItemName() +
                        " - " + item.getDescription() +
                        " - " + item.getLocation());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Tidak ada barang yang masih dalam status 'Reported'.");
        }
    }
}