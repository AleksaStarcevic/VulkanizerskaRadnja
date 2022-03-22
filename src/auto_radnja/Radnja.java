package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja interfejs koji ima osnovne operacije dodavanja,pretrage i
 * vracanja
 * 
 * @author aleks
 */

public interface Radnja {
	/**
	 * Metoda za dodavanje nove gume u radnju
	 * 
	 * @param a guma koju treba dodati u radnju
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException     ako uneta guma vec postoji u radnji
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Metoda pronalazi gumu na osnovu markaModel-a
	 * 
	 * @param markaModel markaModel na osnovu kog se vrsi pretraga
	 * @return
	 *         <ul>
	 *         <li>null- ako je markaModel null</li>
	 *         <li>Lista pronadjenih guma - ako je markaModel razlicit od null</li>
	 *         </ul>
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Metoda vraca listu svih guma iz radnje
	 * 
	 * @return Lista svih guma iz radnje
	 */
	List<AutoGuma> vratiSveGume();
}
