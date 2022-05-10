package AkýllýCihaz;

public class SogutucuyuAcma implements IIslem {
	
    private IAgArayuzu agArayuzu;
    private IEyleyici eyleyici;

    public SogutucuyuAcma(IAgArayuzu agArayuzu, IEyleyici eyleyici ) {

        this.agArayuzu = agArayuzu;
        this.eyleyici = eyleyici;

    }


	public void IslemYap() {
        agArayuzu.MesajGoruntule("Soðutucuyu açma iþlemini seçtiniz");
        eyleyici.sogutucuAc();
		
	}
}
