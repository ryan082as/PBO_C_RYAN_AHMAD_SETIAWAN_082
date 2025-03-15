class Animal {
    String nama, jenis, suara;

    public Animal(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
    }
}
public class Main {
    public static void main(String[] args) {

        Animal animal1 = new Animal("Kucing", "Mamalia", "Miau~~\n");
        Animal animal2 = new Animal("Anjing", "Mamalia", "Aug~~\n");

        animal1.displayInfo();
        animal2.displayInfo();
    }
}