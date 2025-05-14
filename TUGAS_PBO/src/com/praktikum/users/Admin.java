package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    protected String username;
    protected String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(){
        final String validUsername = "admin082";
        String validPassword = "password082";

        return username.equals(validUsername) && password.equals(validPassword);
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
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageItem();
                    break;
                case 2:
                    manageUser();
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
    public void manageItem() {
        System.out.println("\n>> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUser() {
        System.out.println("\n>> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}
