/**
 * 
 */
package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



/**
 * @author aleks
 *
 */
class AutoGumaTest {

	AutoGuma guma;

	@BeforeEach
	void setUp() throws Exception {
		guma = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		guma = null;
	}
	
	@Test
	void testAutoGuma() {
		guma = new AutoGuma();
		assertNotNull(guma);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		guma = new AutoGuma("Tigar", 17, 185, 80);
		assertEquals("Tigar", guma.getMarkaModel());
		assertEquals(17, guma.getPrecnik());
		assertEquals(185, guma.getSirina());
		assertEquals(80, guma.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		guma.setMarkaModel("Tigar");
		assertEquals("Tigar", guma.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelManjeOdTriZnaka() {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> guma.setMarkaModel("Ab"));
	}
	

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> guma.setMarkaModel(null));
	}

	@ParameterizedTest
	@CsvSource({
		"13", "15", "22"
	})
	void testSetPrecnik(int precnik) {
		guma.setPrecnik(precnik);
		assertEquals(precnik, guma.getPrecnik());
	}
	
	@Test
	void testSetPrecnikVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> guma.setPrecnik(66));
	}

	@ParameterizedTest
	@CsvSource({
		"135", "222", "355"
	})
	void testSetSirina(int sirina) {
		guma.setSirina(sirina);
		assertEquals(sirina, guma.getSirina());
	}
	
	@Test
	void testSetSirinaVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> guma.setSirina(120));
	}

	@ParameterizedTest
	@CsvSource({
		"25", "45", "95"
	})
	void testSetVisina(int visina) {
		guma.setVisina(visina);
		assertEquals(visina, guma.getVisina());
	}
	
	@Test
	void testSetVisinaVanOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, 
				() -> guma.setVisina(100));
	}

	
	@Test
	void testToString() {
		guma = new AutoGuma("Tigar", 17, 185, 80);
		String string = guma.toString();
		assertTrue(string.contains("Tigar"));
		assertTrue(string.contains("17"));
		assertTrue(string.contains("185"));
		assertTrue(string.contains("80"));
		
	}

	
	@ParameterizedTest
	@CsvSource({
			"Goodyear,Tigar,18,17,200,185,80,85,false",
			"Goodyear,Goodyear,18,17,200,185,80,85,false",
			"Goodyear,Tigar,18,18,200,185,80,80,false",
			"Tigar,Tigar,18,18,200,200,80,80,true",
			
	})
	void testEqualsObject(String markaModel1,String markaModel2,int precnik1,int precnik2,int sirina1,int sirina2,int visina1,int visina2,boolean equals) {
		guma.setMarkaModel(markaModel1);
		guma.setPrecnik(precnik1);
		guma.setSirina(sirina1);
		guma.setVisina(visina1);
		
		AutoGuma guma2 = new AutoGuma();
		guma2.setMarkaModel(markaModel2);
		guma2.setPrecnik(precnik2);
		guma2.setSirina(sirina2);
		guma2.setVisina(visina2);
		
		assertEquals(equals, guma.equals(guma2));
		
	}

}
