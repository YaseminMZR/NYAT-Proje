package AkýllýCihaz;

import java.util.Random;

public class FahrenheitSicaklikAlgilayici implements ISicaklikAlgilayici {
	
	public String tip = "Fahrenheit";
	public int maksimumDeger = 30*(9/5)+32;
	public int minimumDeger = 0*(9/5)+32;
	public double value;

	public FahrenheitSicaklikAlgilayici(String tip, int min , int max ) throws InterruptedException {
		
		this.minimumDeger = min;
		this.maksimumDeger = max;
		this.tip = tip;
		value = 20*(9/5)+32;
	}
	
	@Override
	public void algila() throws InterruptedException {
        System.out.println("Sicaklik olculuyor.");
        Arac.bekle(500);
        System.out.println("Sicaklik olculuyor..");
        Arac.bekle(500);
        System.out.println("Sicaklik olculuyor...");
        Arac.bekle(500);
		
	}

	@Override
	public double degerGetir() {
		return value;
	}

	@Override
	public void sicaklikOlc() throws InterruptedException {
		
    	algila();
        Random rnd = new Random();
        value = minimumDeger + (maksimumDeger - minimumDeger) * rnd.nextDouble();
	}

}
