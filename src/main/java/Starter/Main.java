package Starter;

import Starter.Interfaces.IAgArayuzu;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner input =new Scanner(System.in);
        Connection connection = null;

        try{
            Class.forName("org.postgresql.Driver");

            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/NYAT","postgres","453674521");
            System.out.println("Veritabanı bağlantı işlemi başarılı...");
        } catch (Exception e) {
            System.out.println("Veritabanı bağlantı işlemi başarısız...");
            System.exit(1);
        }


        Kisi kisi = new Kisi.KisiBuilder().name().password().builder();


            try{
                String sql = "SELECT * FROM users WHERE username='"+kisi.getUsername()+"'";
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                connection.close();
                resultSet.close();
                stmt.close();

                while(resultSet.next()){
                    if(resultSet.getString("password")== kisi.getPassword()){
                        break;
                    }else{
                        System.exit(1);
                    }
                }
            }
            catch (Exception e){
                System.out.print(e);
            }


        IAgArayuzu agArayuzu= new AgArayuzu(new Algilayici());
        char index;
        while(true){
            System.out.print(
                    "\n"+
                    "0-) KAPAT \n"+
                    "1-) Soğutucu Aç: "+ "\n"+
                    "2-) Soğutucu Kapat: "+"\n"+
                    "3-) Sıcaklık Algılayıcı:\n"+
                    ">> ");
            index= input.next().charAt(0);

            switch (index){
                case '0':
                    System.out.print("Sistemden çıkış yapıldı...");
                    System.exit(0);
                case '1':
                    agArayuzu.sogutucuAc();
                    break;

                case '2':
                    agArayuzu.sogutucuKapa();
                    break;

                case '3':
                    agArayuzu.sicaklik_gonder();
                    break;
            }
        }
    }
}
