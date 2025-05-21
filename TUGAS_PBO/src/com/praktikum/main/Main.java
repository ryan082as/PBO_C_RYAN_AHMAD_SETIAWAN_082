package com.praktikum.main;

import com.praktikum.model.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> userList = new ArrayList<>();
    public static List<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        initializeDefaultData();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Sistem Login");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Pilih role: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            User user = switch (choice) {
                case 1 -> handleAdminLogin(scanner);
                case 2 -> handleMahasiswaLogin(scanner);
                default -> {
                    System.out.println("Pilihan tidak valid");
                    System.exit(0);
                    yield null;
                }
            };

            if (user != null) {
                System.out.println("\nLogin berhasil!");
                user.displayAppMenu();
            } else {
                System.out.println("Login gagal! Credential salah.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static User handleAdminLogin(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        return authenticateAdmin(username, password);
    }

    private static User handleMahasiswaLogin(Scanner scanner) {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        return authenticateMahasiswa(nama, nim);
    }

    private static void initializeDefaultData() {
        userList.add(new Admin("null", "null", "admin082", "password082"));
        userList.add(new Mahasiswa("Ryan Ahmad Setiawan", "202410370110082"));
        userList.add(new Mahasiswa("Rofi Naufal Farid", "202410370110214"));
        userList.add(new Mahasiswa("Excl Radit Pratama", "202410370110070"));
    }

    private static User authenticateAdmin(String username, String password) {
        return userList.stream()
                .filter(Admin.class::isInstance)
                .map(Admin.class::cast)
                .filter(admin -> admin.getUsername().equals(username) && admin.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    private static User authenticateMahasiswa(String nama, String nim) {
        return userList.stream()
                .filter(Mahasiswa.class::isInstance)
                .filter(mahasiswa -> mahasiswa.getNama().equalsIgnoreCase(nama) && mahasiswa.getNim().equals(nim))
                .findFirst()
                .orElse(null); // findfrist mengambil objek pertama mahasiswa di line 67
    }

    public static List<Item> getReportedItems() {
        return reportedItems;
    }

    public static List<User> getUserList() {
        return userList;
    }
}