import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FechaMenorTest {

	@Test
	public void fechaCorrecta() {
		FechaMenor fecha = new FechaMenor();
		String result = fecha.getLowerDate("12/3/0");
		assertEquals("12/03/00", result);
	}

//	@Test
//	public void fechaCorrecta2() {
//		FechaMenor fecha = new FechaMenor();
//		String result = fecha.getLowerDate("12/3/2000");
//		assertEquals("12/03/2000", result);
//	}

	@Test
	public void ordenarFecha() {
		FechaMenor fecha = new FechaMenor();
		String[] result = fecha.sortDate("05/03/09");
		assertEquals("3", result[0]);
	}

	@Test
	public void comprobarFecha() {
		FechaMenor fecha = new FechaMenor();
		String dateStr = "03/05/12";
		String result = fecha.checkDate(dateStr);
		assertEquals("Fecha correcta", result);
	}

	@Test
	public void comprobarFechaIncorrecta() {
		FechaMenor fecha = new FechaMenor();
		String dateStr = "03/95/12";
		String result = fecha.checkDate(dateStr);
		assertEquals("Fecha incorrecta", result);
	}
	
	@Test
	public void comprobarComponentesFecha(){
		FechaMenor fecha = new FechaMenor();
		String[] dateVector = { "0", "05", "12" };
		String result = fecha.addZeroToDate(dateVector);
		assertEquals("12/05/00", result);
	}

}
