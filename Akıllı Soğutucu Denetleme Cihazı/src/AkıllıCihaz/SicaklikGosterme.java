package AkýllýCihaz;

public class SicaklikGosterme implements IIslem {
	
	private IAgArayuzu agArayuzu;
	private ISicaklikAlgilayici sicaklikAlgilayici;
	
	public SicaklikGosterme(IAgArayuzu agArayuzu , ISicaklikAlgilayici sicaklikAlgilayici) {
		
		this.agArayuzu = agArayuzu;
		this.sicaklikAlgilayici = sicaklikAlgilayici;
	}

	
	public void IslemYap() throws InterruptedException {
		
		agArayuzu.MesajGoruntule("Sýcaklýk Gösterme iþlemini seçtiniz.");
		sicaklikAlgilayici.sicaklikOlc();
		agArayuzu.MesajGoruntule("Mevcut Sýcaklýk : " + sicaklikAlgilayici.degerGetir());
		
		
	}

}






