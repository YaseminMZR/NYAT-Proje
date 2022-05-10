package AkýllýCihaz;

public class SogutucuyuKapatma implements IIslem{
	
	private IAgArayuzu agArayuzu;
	private IEyleyici eyleyici;
	
	public SogutucuyuKapatma(IAgArayuzu agArayuzu , IEyleyici eyleyici) {
		
		this.agArayuzu = agArayuzu;
		this.eyleyici = eyleyici;
	}
	

	public void IslemYap() {
		agArayuzu.MesajGoruntule("Soðutucuyu Kapatma iþlemini seçtiniz.");
		eyleyici.sogutucuKapat();
		
	}
	
  



    


	

}
