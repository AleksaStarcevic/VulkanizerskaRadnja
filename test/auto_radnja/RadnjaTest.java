package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma guma = new AutoGuma("Tigar", 17, 185, 50);

		radnja.dodajGumu(guma);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(guma, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuViseGuma() {
		AutoGuma guma = new AutoGuma("Tigar", 17, 185, 50);
		AutoGuma guma2 = new AutoGuma("Miselin", 18, 190, 60);

		radnja.dodajGumu(guma);
		radnja.dodajGumu(guma2);

		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(guma));
		assertTrue(radnja.vratiSveGume().contains(guma2));
	}

	@Test
	void testDodajGumuDuplikat() {
		AutoGuma guma = new AutoGuma("Tigar", 17, 185, 50);
		AutoGuma guma2 = new AutoGuma("Tigar", 17, 185, 50);

		radnja.dodajGumu(guma);

		Exception exception = assertThrows(java.lang.RuntimeException.class, 
				() -> radnja.dodajGumu(guma2));

		assertEquals("Guma vec postoji",exception.getMessage());

	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> radnja.dodajGumu(null));
	}
	
	@Test
	void testPronadjiGumu() {
		AutoGuma guma = new AutoGuma("Tigar", 17, 185, 50);
		radnja.dodajGumu(guma);
		
		List<AutoGuma> gume = radnja.pronadjiGumu("Tigar");
		assertEquals(1, gume.size());
		assertTrue(gume.contains(guma));
	}
	
	

	@Test
	void testPronadjiGumuMarkaModelNull() {
		List<AutoGuma> gume = radnja.pronadjiGumu(null);
		assertEquals(gume, null);
	}
	
	@Test
	void testPronadjiGumuNePostojiMarkaModel() {
		AutoGuma guma = new AutoGuma("Tigar", 17, 185, 50);
		AutoGuma guma2 = new AutoGuma("Miselin", 18, 190, 60);
		radnja.dodajGumu(guma);
		radnja.dodajGumu(guma2);
		List<AutoGuma> gume = radnja.pronadjiGumu("Goodyear");
		
		assertEquals(0, gume.size());
		assertTrue(gume.isEmpty());
	}
	
	@Test
	void testPronadjiGumuIstaMarkaRazliciteDimenzije() {
		AutoGuma guma = new AutoGuma("Tigar", 17, 185, 50);
		AutoGuma guma2 = new AutoGuma("Tigar", 18, 190, 60);
		radnja.dodajGumu(guma);
		radnja.dodajGumu(guma2);
		
		List<AutoGuma> gume = radnja.pronadjiGumu("Tigar");
		
		assertEquals(2, gume.size());
		assertTrue(gume.contains(guma));
		assertTrue(gume.contains(guma2));
		
	}

	@Test
	void testVratiSveGume() {
		AutoGuma guma = new AutoGuma("Tigar", 17, 185, 50);
		radnja.dodajGumu(guma);
		assertEquals(1,radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(guma));
	}

}
