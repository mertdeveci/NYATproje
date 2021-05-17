package Starter;

import java.util.Scanner;

public class Kisi {
    private String username;
    private String password;

    private Kisi(KisiBuilder kisiBuilder){
        this.username=kisiBuilder._username;
        this.password=kisiBuilder._password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class KisiBuilder{
        private Scanner scanner=new Scanner(System.in);
        private String _username;
        private String _password;

        public KisiBuilder() {
        }

        public KisiBuilder name(){
            System.out.print("Kullanıcı adını girin: ");
            this._username=scanner.next();
            return this;
        }

        public KisiBuilder password(){
            System.out.print("Şifreyi girin: ");
            this._password= scanner.next();
            return this;
        }
        public Kisi builder(){
            return new Kisi(this);
        }

    }
}
