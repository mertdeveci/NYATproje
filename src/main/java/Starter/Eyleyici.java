package Starter;

import Starter.Interfaces.IEyleyici;

public class Eyleyici implements IEyleyici {
    private static boolean state=false;
    @Override
    public void sogutucAc() {
        if(state==true){
            System.out.println("Soğutucu zaten açık...");
        }else{
            System.out.println("Soğutucu açılıyor...");
        }
        state=true;
    }

    @Override
    public void sogutucuKapat() {
        if(state==false){
            System.out.println("Soğutucu zaten kapalı...");
        }else{
            System.out.println("Soğutucu kapanıyor...");
        }
        state=false;
    }
}
