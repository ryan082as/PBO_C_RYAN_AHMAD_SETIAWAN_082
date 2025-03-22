import java.util.Scanner;
// class admin
class admin {
    String username;
    String password;
    // construktor admin
    public admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // method admin
    public void login() {
        String validUsername = "admin082";
        String validPassword = "password082";

        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}
// class mahasiswa
class mahasiswa {
    String nama;
    String nim;
    // construktor mahasiswa
    public mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    // method mahasiswa
    public boolean login() {
        String validNama = "ryan ahmad setiawan";
        String validNIM = "202410370110082";

        return (nama.equals(validNama) && nim.equals(validNIM));
    }
    // method displayInfo
    public void displayInfo(){
        if (login()) {
            System.out.println("Login Mahasiswa berhasil!");
            System.out.println("Nama: " + nama);
            System.out.println("NIM: " + nim);
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }
}

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
            admin admin = new admin(username, password);
            admin.login();
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