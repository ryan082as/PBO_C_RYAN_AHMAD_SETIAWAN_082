import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input dari pengguna
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);
        scanner.nextLine(); // Membersihkan newline

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        // Menghitung umur
        int tahunSekarang = Year.now().getValue();
        int umur = tahunSekarang - tahunLahir;

        // Menentukan jenis kelamin
        String jenisKelaminLengkap;
        if (jenisKelamin == 'L' || jenisKelamin == 'l') {
            jenisKelaminLengkap = "Laki-laki";
        } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            jenisKelaminLengkap = "Perempuan";
        } else {
            jenisKelaminLengkap = "Tidak valid";
        }

        // Menampilkan data diri
        System.out.println("\nData Diri:");
        System.out.println("Nama : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminLengkap);
        System.out.println("Umur : " + umur + " tahun");

        scanner.close();
    }
}