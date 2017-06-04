package milkyway.SaveableSerializing.Java8.Util.Calendar;

import milkyway.SaveableSerializing.Java8.API.WithoutExcpetionParser;
import milkyway.SaveableSerializing.Parser.SaveableData;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Developer_Unlocated on 2017-05-22.
 */
public class SaveableGregorianCalendar implements SaveableData,SaveableCalendar{
    private int year = 1999;
    private int month = 0;
    private int date = 1;
    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    private int millsec = 0;
    public SaveableGregorianCalendar(Calendar calendar){
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        date = calendar.get(Calendar.DATE);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        millsec = calendar.get(Calendar.MILLISECOND);

    }
    @Override
    public void writeBy(StringBuilder builder) {
        builder.append(year).append("\n");
        builder.append(month).append("\n");
        builder.append(date).append("\n");
        builder.append(hour).append("\n");
        builder.append(minute).append("\n");
        builder.append(second).append("\n");
        builder.append(millsec).append("\n");
    }

    @Override
    public void appendTo(List<String> builded) {
        year = WithoutExcpetionParser.parse(builded.get(0),1999);
        month = WithoutExcpetionParser.parse(builded.get(1),0);
        date = WithoutExcpetionParser.parse(builded.get(2),1);
        hour = WithoutExcpetionParser.parse(builded.get(3),1);
        minute = WithoutExcpetionParser.parse(builded.get(4),0);
        second = WithoutExcpetionParser.parse(builded.get(5),0);
        millsec = WithoutExcpetionParser.parse(builded.get(0),0);
    }

    @Override
    public String getName() {
        return "Java8_SaveableGregorian";
    }

    @Override
    public void appendObject(String str, SaveableData data) {

    }

    @Override
    public Object getOriginal() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DATE,date);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        calendar.set(Calendar.MILLISECOND,millsec);
        return calendar;
    }
    public SaveableGregorianCalendar(){}
    @Override
    public SaveableData getNewInstance() {
        return new SaveableGregorianCalendar();
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonth() {
        return month+1;
    }

    @Override
    public int getDate() {
        return date;
    }

    @Override
    public int getHours() {
        return hour;
    }

    @Override
    public int getMinute() {
        return minute;
    }

    @Override
    public int getSecond() {
        return second;
    }

    @Override
    public int getMilliSecond() {
        return millsec;
    }
}
