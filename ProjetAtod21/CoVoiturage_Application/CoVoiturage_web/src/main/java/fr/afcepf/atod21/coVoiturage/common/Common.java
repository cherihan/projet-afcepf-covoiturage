package fr.afcepf.atod21.coVoiturage.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {


    private static final String PATTERN_DATE = "yyyy/MM/dd hh:mm";
    private static final String PATTERN_DATE_WS = "yyyy-MM-dd hh:mm";

	public  static Date convertDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE);
		Date dateToConvert = new Date();

		try {
			dateToConvert = sdf.parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return dateToConvert;
	}

	   public  static Date convertDateWS(String date) {
	        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE_WS);
	        Date dateToConvert = new Date();

	        try {
	            dateToConvert = sdf.parse(date);
	        } catch (ParseException e) {

	            e.printStackTrace();
	        }

	        return dateToConvert;
	    }

}
