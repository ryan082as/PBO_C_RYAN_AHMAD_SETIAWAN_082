class admin extends user {
    String username;
    String password;

    public admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(){
        final String validUsername = "admin082";
        String validPassword = "password082";

        return username.equals(validUsername) && password.equals(validPassword);
    }

    @Override
    public void displayInfo(){
        if (login()){
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}