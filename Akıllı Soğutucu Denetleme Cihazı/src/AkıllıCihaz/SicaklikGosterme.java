package Ak�ll�Cihaz;

public class SicaklikGosterme implements IIslem {
	
	private IAgArayuzu agArayuzu;
	private ISicaklikAlgilayici sicaklikAlgilayici;
	
	public SicaklikGosterme(IAgArayuzu agArayuzu , ISicaklikAlgilayici sicaklikAlgilayici) {
		
		this.agArayuzu = agArayuzu;
		this.sicaklikAlgilayici = sicaklikAlgilayici;
	}

	
	public void IslemYap() throws InterruptedException {
		
		agArayuzu.MesajGoruntule("S�cakl�k G�sterme i�lemini se�tiniz.");
		sicaklikAlgilayici.sicaklikOlc();
		agArayuzu.MesajGoruntule("Mevcut S�cakl�k : " + sicaklikAlgilayici.degerGetir());
		
		
	}

}






