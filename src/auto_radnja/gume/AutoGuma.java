package auto_radnja.gume;

/**
 * Klasa AutoGuma sa atributima markaModel,precnik,sirina i visina
 * 
 * @author Aleksa
 * @version 1.0
 *
 */

public class AutoGuma {
	/**
	 * Marka i model gume
	 */
	private String markaModel = null;
	/**
	 * Precnik gume
	 */
	private int precnik = -1;
	/**
	 * Sirina gume
	 */
	private int sirina = -1;
	/**
	 * Visina gume
	 */
	private int visina = -1;

	/**
	 * Bezparametarski konstruktor
	 */
	public AutoGuma() {
	}

	/**
	 * Postavlja markaModel,precnik,sirinu, i visinu na unete vrednosti
	 * 
	 * @param markaModel nova marka i model gume
	 * @param precnik    nov precnik gume
	 * @param sirina     nova sirina gume
	 * @param visina     nova visina gume
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model gume
	 * 
	 * @return markaModel kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja novu vrednost za atribut markaModel
	 * 
	 * @param markaModel nova marka i model gume
	 * @throws java.lang.NullPointerException     ako je uneta markaModel null
	 * @throws java.lang.IllegalArgumentException ako markaModel ima manje od 3
	 *                                            znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume
	 * 
	 * @return precnik gume kao int
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja novu vrednost za atribut precnik
	 * 
	 * @param precnik novi precnik gume
	 * @throws java.lang.IllegalArgumentException ako je precnik van opsega
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume
	 * 
	 * @return sirina gume kao int
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja novu vrednost za atribut sirina
	 * 
	 * @param sirina nova sirina gume
	 * @throws java.lang.IllegalArgumentException ako je sirina van opsega
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume
	 * 
	 * @return visina gume kao int
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja novu vrednost za atribut visina
	 * 
	 * @param visina nova visina gume
	 * @throws java.lang.IllegalArgumentException ako je visina van opsega
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca sve podatke o gumi u jednom String-u.
	 * 
	 * @return String sa svim podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve gume na osnovu marke i modela,sirine,visine, i precnika
	 * 
	 * @return
	 *         <ul>
	 *         <li>true - ako su marka,model,sirina,visina, i precnik isti kod obe
	 *         gume</li>
	 *         <li>false - ako to nije slucaj</li>
	 *         </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
