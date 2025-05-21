package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.model.Item;
import com.praktikum.main.Main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login() {
        // Login now handled by Main class authentication
        return true;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manageItems();
                        break;
                    case 2:
                        manageUsers();
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
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nKelola Laporan Barang:");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        viewAllItems();
                        break;
                    case 2:
                        markItemAsClaimed();
                        break;
                    case 0:
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

    private void viewAllItems() {
        if (Main.reportedItems.isEmpty()) {
            System.out.println("\nBelum ada laporan barang.");
            return;
        }

        System.out.println("\nDaftar Semua Laporan Barang:");
        int index = 1;
        for (Item item : Main.reportedItems) {
            System.out.println(index + ". " + item.getItemName() +
                    " - " + item.getDescription() +
                    " - " + item.getLocation() +
                    " - Status: " + item.getStatus());
            index++;
        }
    }

    private void markItemAsClaimed() {
        if (Main.reportedItems.isEmpty()) {
            System.out.println("\nBelum ada laporan barang.");
            return;
        }

        // Show only reported items
        System.out.println("\nDaftar Barang yang Belum Diambil:");
        int count = 0;
        for (int i = 0; i < Main.reportedItems.size(); i++) {
            Item item = Main.reportedItems.get(i);
            if (item.getStatus().equals("Reported")) {
                System.out.println((i + 1) + ". " + item.getItemName() +
                        " - " + item.getDescription() +
                        " - " + item.getLocation());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Tidak ada barang yang belum diambil.");
            return;
        }

        System.out.print("\nMasukkan nomor barang yang ingin ditandai sebagai diambil (0 untuk batal): ");
        try {
            int choice = new Scanner(System.in).nextInt();
            if (choice == 0) return;

            if (choice > 0 && choice <= Main.reportedItems.size()) {
                Item selectedItem = Main.reportedItems.get(choice - 1);
                if (selectedItem.getStatus().equals("Reported")) {
                    selectedItem.setStatus("Claimed");
                    System.out.println("Status barang '" + selectedItem.getItemName() + "' berhasil diubah menjadi 'Claimed'");
                } else {
                    System.out.println("Barang ini sudah ditandai sebagai diambil sebelumnya.");
                }
            } else {
                System.out.println("Nomor barang tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nomor barang tidak valid.");
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nKelola Data Mahasiswa:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addMahasiswa();
                        break;
                    case 2:
                        removeMahasiswa();
                        break;
                    case 0:
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

    private void addMahasiswa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nMasukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        // Check if NIM already exists
        for (User user : Main.userList) {
            if (user instanceof Mahasiswa && user.getNim().equals(nim)) {
                System.out.println("Mahasiswa dengan NIM " + nim + " sudah terdaftar.");
                return;
            }
        }

        Main.userList.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private void removeMahasiswa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nMasukkan NIM Mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < Main.userList.size(); i++) {
            User user = Main.userList.get(i);
            if (user instanceof Mahasiswa && user.getNim().equals(nim)) {
                Main.userList.remove(i);
                found = true;
                System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                break;
            }
        }

        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }
}