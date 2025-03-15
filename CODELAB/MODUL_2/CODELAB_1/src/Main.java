class hewan {
    String nama, jenis, suara;

    public hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    public void tampilkan() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
    }
}
public class Main {
    public static void main(String[] args) {

        hewan hewan1 = new hewan("Kucing", "Mamalia", "Miau~~\n");
        hewan hewan2 = new hewan("Anjing", "Mamalia", "Aug~~\n");


        hewan1.tampilkan();
        hewan2.tampilkan();
    }
}