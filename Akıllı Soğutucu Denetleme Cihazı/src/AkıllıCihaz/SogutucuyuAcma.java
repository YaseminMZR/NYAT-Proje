package Ak�ll�Cihaz;

public class SogutucuyuAcma implements IIslem {
	
    private IAgArayuzu agArayuzu;
    private IEyleyici eyleyici;

    public SogutucuyuAcma(IAgArayuzu agArayuzu, IEyleyici eyleyici ) {

        this.agArayuzu = agArayuzu;
        this.eyleyici = eyleyici;

    }


	public void IslemYap() {
        agArayuzu.MesajGoruntule("So�utucuyu a�ma i�lemini se�tiniz");
        eyleyici.sogutucuAc();
		
	}
}
