class user {
    private String nama;
    private String nim;

    // construktor admin
    public user(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    // setter dingge input data private
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    //getter dingge output data private
    public String getNama() {
        return nama;
    }
    public String getNim() {
        return nim;
    }
    // login & displayInfo pajangan
    public boolean login() {
        return false;
    }
    public void displayInfo(){
        if (login()){
            System.out.println("Login Mahasiswa berhasil!");
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }
}