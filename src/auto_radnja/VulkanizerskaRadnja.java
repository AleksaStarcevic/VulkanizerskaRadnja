package auto_radnja;

import java.util.LinkedList;
import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja implementaciju radnje sa gumama.
 * Ima osnovne operacije dodavanja,pretrage i vracanja
 * @author aleks
 * @version 1.1
 */
public class VulkanizerskaRadnja implements Radnja {
	/**
	 * Lista koja sadrzi auto gume
	 */
	private List<AutoGuma> gume = new LinkedList<AutoGuma>();

	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		((LinkedList<AutoGuma>) gume).addFirst(a);
	}

	@Override
	public List<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		List<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).getMarkaModel().equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}

	@Override
	public List<AutoGuma> vratiSveGume() {
		return gume;
	}
}
