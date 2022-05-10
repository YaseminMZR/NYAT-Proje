package Ak�ll�Cihaz;

public class SogutucuyuKapatma implements IIslem{
	
	private IAgArayuzu agArayuzu;
	private IEyleyici eyleyici;
	
	public SogutucuyuKapatma(IAgArayuzu agArayuzu , IEyleyici eyleyici) {
		
		this.agArayuzu = agArayuzu;
		this.eyleyici = eyleyici;
	}
	

	public void IslemYap() {
		agArayuzu.MesajGoruntule("So�utucuyu Kapatma i�lemini se�tiniz.");
		eyleyici.sogutucuKapat();
		
	}
	
  



    


	

}
