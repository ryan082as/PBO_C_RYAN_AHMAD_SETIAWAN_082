package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistem Login");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih role: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        User user = null;

        switch (choice) {
            case 1:
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                user = new Admin("", "", username, password);
                break;
            case 2:
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("NIM: ");
                String nim = scanner.nextLine();
                user = new Mahasiswa(nama, nim);
                break;
            default:
                System.out.println("Pilihan tidak valid");
                System.exit(0);
        }

        if (user.login()) {
            System.out.println("\nLogin berhasil!");
            user.displayAppMenu(); //pho itu lah
        } else {
            System.out.println("Login gagal! Credential salah.");
        }
    }
}
