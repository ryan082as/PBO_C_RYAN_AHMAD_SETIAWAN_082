import java.util.Scanner;

class rekeningBank {
    String nomerRekening, namaPemilik;
    double saldo;
    Scanner scanner;

    public rekeningBank(String nomerRekening, String namaPemilik, double saldo) {
        this.nomerRekening = nomerRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.scanner = new Scanner(System.in);
    }

    public void setorUang(double jumlah) {
        System.out.print("Masukkan uang yang akan disetor untuk " + namaPemilik + ": ");
        jumlah = scanner.nextDouble();

        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
            System.out.println();
        } else {
            System.out.println("Saldo tidak dapat dikurangi");
            System.out.println();
        }
    }

    public void tarikUang(double jumlah) {
        System.out.print("Masukkan uang yang akan ditarik untuk " + namaPemilik + ": ");
        jumlah = scanner.nextDouble();

        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo  + "\n");
        } else if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo + "\n");
        }
    }

    public void tampilkan() {
        System.out.println("Nomor Rekening: " + nomerRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
        System.out.println();
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rekeningBank rekening1 = new rekeningBank("202410370110082", "Ryan", 1000000);
        rekeningBank rekening2 = new rekeningBank("202410370110070", "Microsoft Excl", 2000000);

        rekening1.tampilkan();
        rekening2.tampilkan();

        rekening1.setorUang(0);
        rekening2.setorUang(0);

        rekening1.tarikUang(0);
        rekening2.tarikUang(0);

        rekening1.tampilkan();
        rekening2.tampilkan();

        scanner.close();
    }
}
