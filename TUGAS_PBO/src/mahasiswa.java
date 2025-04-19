class mahasiswa extends user {

    public mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(){
        String validNama = "ryan ahmad setiawan";
        String validNim = "202410370110082";

        return getNama().equals(validNama) && getNim().equals(validNim);
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
    }
}