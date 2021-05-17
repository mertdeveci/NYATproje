package Starter;

import Starter.Interfaces.IAlgilayici;

import java.util.Random;

public class Algilayici implements IAlgilayici {
    Random random = new Random();
    @Override
    public void sicaklik_oku() {
        System.out.println("Sıcaklık: "+ random.nextDouble()*30);
    }
}
