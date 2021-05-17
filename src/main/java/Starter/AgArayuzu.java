package Starter;

import Starter.Interfaces.IAgArayuzu;
import Starter.Interfaces.IAlgilayici;
import Starter.Interfaces.IEyleyici;

public class AgArayuzu implements IAgArayuzu {
    private IAlgilayici algilayici;
    private IEyleyici eyleyici=new Eyleyici();

    public AgArayuzu(IAlgilayici algilayici) {
        this.algilayici=algilayici;
    }

    @Override
    public void sogutucuAc() {
      eyleyici.sogutucAc();
      algilayici.sicaklik_oku();

    }

    @Override
    public void sogutucuKapa() {
        eyleyici.sogutucuKapat();
        algilayici.sicaklik_oku();
    }

    @Override
    public void sicaklik_gonder() {
        algilayici.sicaklik_oku();
    }
}
