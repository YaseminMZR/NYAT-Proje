package AkýllýCihaz;

public class AgArayuzu implements IAgArayuzu{

	
	@Override
	public void GirisMesaji() {
		
        System.out.println("\n <<AKILLI SOÐUTUCU DENETLEME CÝHAZI>>");
        System.out.println("Hoþgeldiniz...");		
		
	}

	@Override
	public void Giris() {
	      System.out.println("Doðrulama baþarýlý. Giriþ yapýlana kadar lütfen bekleyiniz.");
	      System.out.println("Lütfen Bekleyiniz.");
	      Arac.bekle(500);
	      System.out.println("Lütfen Bekleyiniz..");
	      Arac.bekle(500);
	      System.out.println("Lütfen Bekleyiniz...");
	      System.out.println("Giriþ Baþarýlý.");
		
	}

	@Override
	public void CikisYap() {
		
        System.out.println("Cikis Yapiliyor.");
        Arac.bekle(500);
        System.out.println("Cikis Yapiliyor..");
        Arac.bekle(500);
        System.out.println("Cikis Yapiliyor...");
        System.out.println("Çýkýþ Yapýldý.");
	}

	@Override
	public void anaMenuyuGoster() {
		
		System.out.println("**********************************************");
		System.out.println("Ana Menu");
		System.out.println("1-Soðutucuyu Açma");
		System.out.println("2-Soðutucuyu Kapatma");
		System.out.println("3-Sýcaklýk Gösterme");
		System.out.println("4-Cihaz OtoKontrolü ");
		System.out.println("5-Çýkýþ");
		System.out.println("**********************************************");
	}

	@Override
	public void MesajGoruntule(String mesaj) {
		
		System.out.println(mesaj);
		
	}

	@Override
	public void hataliGirisMesaji() {
		System.out.println("Böyle Bir Kullanýcý Bulunmamaktadýr.");
		System.out.println("Lütfen Tekrar Deneyiniz");
		
		
	}
	

		
	
	
	

}
