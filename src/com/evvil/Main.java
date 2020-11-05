package com.evvil;
import com.evvil.YrConnect;
import java.net.*;
import java.net.http.*;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Oto twoja prognoza:");
        String adres = "https://www.yr.no/place/Poland/Warmia-Masuria/Giżycko/hour_by_hour.html";
	    String yrnocontent = YrConnect.getBody(adres);


        int indexOfSpan = yrnocontent.indexOf("yr-table yr-table-hourly");
        int indexOfSpanClosed = yrnocontent.indexOf("</table>", indexOfSpan);
        String yrnolimitedcontent = yrnocontent.substring(indexOfSpan, indexOfSpanClosed);


        for (int i = 0; i<24; i++) {
        try {
            int indexOfSpan2 = yrnolimitedcontent.indexOf("°.  For the period: "+i+":00");
            int indexOfSpanClosed2 = yrnolimitedcontent.indexOf("°.  For the period: "+i+":00");
            String yrnoAlmostThere = yrnolimitedcontent.substring(indexOfSpan2, indexOfSpanClosed2 + 300);
            //System.out.println(yrnoAlmostThere);
            int indexOfSpan5 = yrnoAlmostThere.indexOf("txt-left");
            int indexOfSpanClosed5 = yrnoAlmostThere.indexOf("<img src");
            String wind = yrnoAlmostThere.substring(indexOfSpan5 + 17, indexOfSpanClosed5 - 13);
            int indexOfSpan6 = wind.indexOf("Wind:");
            int indexOfSpan6Closed = wind.indexOf("For the period");
            String finalwind = wind.substring(indexOfSpan6, indexOfSpan6Closed);
            System.out.println("Dla godziny:"+i+":00 " + finalwind);

            //System.out.println(wind);
        } catch (Exception e) {
            System.out.println("Dla godziny:" +i+":00"+" -- >Brak danych");
        }}



    }
}
