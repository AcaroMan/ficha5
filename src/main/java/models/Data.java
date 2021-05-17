package models;

import java.util.Calendar;

public  class Data {

    private Calendar calendar;
    public Data(int dia,int mes,int ano){
        calendar = Calendar.getInstance();
        calendar.set(ano,mes,dia);
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public static Data parseData(String data){
        String[] arrOfStr = data.split("/", 5);
        int dia = Integer.parseInt(arrOfStr[0]);
        int mes = Integer.parseInt(arrOfStr[1]);
        int ano = Integer.parseInt(arrOfStr[2]);
        return new Data(dia,mes,ano);
    }
    public void toStringC(){
        System.out.println("calendar.get(Calendar.YEAR) = " + this.getCalendar().get(Calendar.YEAR));
        System.out.println("calendar.get(Calendar.MONDAY) = " + this.getCalendar().get(Calendar.MONDAY));
        System.out.println("calendar.get(Calendar.DATE) = " + this.getCalendar().get(Calendar.DATE));
    }
}
