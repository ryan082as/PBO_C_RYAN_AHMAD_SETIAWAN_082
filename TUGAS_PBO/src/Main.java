import java.util.Scanner;
//try 1
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan pilihan login
        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        if (pilihan == 1) {
            // Login Admin
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            // Validasi username dan password
            String validUsername = "Admin082"; // Ganti dengan Admin + 3-digit NIM terakhir Anda
            String validPassword = "Password082"; // Ganti dengan Password + 3-digit NIM terakhir Anda

            if (username.equals(validUsername) && password.equals(validPassword)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            // Login Mahasiswa
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            // Validasi nama dan NIM
            String validNama = "Ryan Ahmad Setiawan"; // Ganti dengan nama Anda
            String validNIM = "202410370110082"; // Ganti dengan NIM Anda

            if (nama.equals(validNama) && nim.equals(validNIM)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + nama);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            // Pilihan tidak valid
            System.out.println("Pilihan tidak valid.");
        }
    }
}