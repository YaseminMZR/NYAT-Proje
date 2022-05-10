package Ak�ll�Cihaz;

public class Eyleyici extends CihazOtoKontrol implements IEyleyici {

	boolean sogutucuAcik ;
	boolean sogutucuKapali;
	
	public Eyleyici() {
		this.sogutucuAcik = false;
		this.sogutucuKapali = true;
	}
	
	@Override
	public void sogutucuAc() {
		
		if(sogutucuKapali) {
			System.out.println("L�tfen Bekleyiniz...");
			Arac.bekle(3000);
			System.out.println("So�utucu a��l�yor.");
			Arac.bekle(500);
			System.out.println("So�utucu a��l�yor..");
			Arac.bekle(500);
			System.out.println("So�utucu a��l�yor...");
			System.out.println("So�utucu ba�ar�yla a��ld�...");
			sogutucuAcik = true;
			sogutucuKapali = false;
		}
		else
			System.out.println("So�utucu zaten a��k durumdad�r.");
		
	}

	@Override
	public void sogutucuKapat() {
		if(sogutucuAcik) {
			System.out.println("L�tfen Bekleyiniz...");
			Arac.bekle(3000);
			System.out.println("So�utucu kapat�l�yor.");
			Arac.bekle(500);
			System.out.println("So�utucu kapat�l�yor..");
			Arac.bekle(500);
			System.out.println("So�utucu kapat�l�yor...");
			System.out.println("So�utucu ba�ar�yla kapat�ld�...");
			sogutucuAcik = false;
			sogutucuKapali= true;
		}
		else
			System.out.println("So�utucu zaten kapal� durumdad�r.");
	 	
	}
	
	public void CihazOtoKontrol(double sicaklik) {
		
		if(sicaklik>=25) {
			YuksekSicaklikBilgilendirme();
			sogutucuAc();
		}
		else if(sicaklik>8 && sicaklik<25) {
			DengeDurumuBilgilendirme();
		}	
		else {
			DusukSicaklikBilgilendirme();
			sogutucuKapat();
		}
		
		
	}



}
