import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();
            // inisialisasi admin ke main
            admin admin = new admin("null","null",username, password);
            admin.login();
            admin.displayInfo();
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            // inisialisasi mahasiswa ke main
            mahasiswa mahasiswa = new mahasiswa(nama, nim);
            mahasiswa.displayInfo();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}

// kak RAFI GUSTIAR