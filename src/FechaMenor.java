import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FechaMenor {

	public String getLowerDate(String date) {
		String result = "";
		String[] fechaSplitted = sortDate(date);
		result = addZeroToDate(fechaSplitted);
		// result = generateDate(fechaSplitted);
		checkDate(result);
		System.out.println("Fecha más cercana a 01/01/00: " + result);

		return result;
	}

	public String[] sortDate(String date) {
		String[] fechaSplitted = date.split("/");
		Integer[] fechaIntegers = { Integer.valueOf(fechaSplitted[0]),Integer.valueOf(fechaSplitted[1]),Integer.valueOf(fechaSplitted[2]) };
		
		Arrays.sort(fechaIntegers);
		String[] fechaSplitted2 = { fechaIntegers[0].toString(),fechaIntegers[1].toString(), fechaIntegers[2].toString() };

		return fechaSplitted2;
	}

	public String checkDate(String dateStr) {
		String error = new String();

//		if (dateStr.length() > 8) {
//			String[] fechaSplitted = dateStr.split("/");
//			fechaSplitted[2]=fechaSplitted[2].substring(0, 1);
//			dateStr = fechaSplitted[0] + "/" + fechaSplitted[1] + "/" + fechaSplitted[2];
//			
//		}
		
		SimpleDateFormat formatoDelTexto;
		formatoDelTexto = new SimpleDateFormat("dd/MM/yy");
		
		
		Date fecha = null;
		try {
			fecha = (Date) formatoDelTexto.parse(dateStr);

			if (!formatoDelTexto.format(fecha).equals(dateStr)) {
				error = "Fecha incorrecta";
			} else {
				error = "Fecha correcta";
			}

		} catch (ParseException ex) {

		}

		return error;
	}

	public String addZeroToDate(String[] dateVector) {
		String dia = dateVector[2];
		String mes = dateVector[1];
		String ano = dateVector[0];

		if (dia.length() == 1) {
			dia = "0" + dia;
		}
		if (mes.length() == 1) {
			mes = "0" + mes;
		}
		if (ano.length() == 1) {
			ano = "0" + ano;
		}

		return (dia + "/" + mes + "/" + ano);
	}

}
