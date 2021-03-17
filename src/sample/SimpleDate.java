package sample;

import java.util.*;
import java.text.*;

/**
 * A simple implementation of dates
 * 
 * @author Patrick Girard 
 * @version 13/08/2010
 */
public class SimpleDate
{
    // instance variables - replace the example below with your own
    private Date date;
    
    // For formatting the dates
    private static final SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat formatHour = new SimpleDateFormat("hh:mm");

    /**
     * Constructor for objects of class SimpleDate
     */
    public SimpleDate()
    {
        // initialise instance variables
        date = new Date();
    }

    /**
         * Constructor for objects of class SimpleDate
         */
        public SimpleDate(int day, int month, int year)
        {
            // initialise instance variables
            Calendar c = Calendar.getInstance();
            c.set(year, month, day);
            date = c.getTime();
        }
        
    /**
     * Return the date in a complete text format - jj/mm/aaaa hh:mm
     * 
     * @return     the date in String format
     */
    public String getCompleteDate()
    {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return formatDate.format(date);
    }
    
    /**
     * Return the date in a simple text format - jj/mm/aaaa
     * 
     * @return     the date in String format
     */
    public String getDate()
    {
        return formatDate.format(date);
    }
    
    /**
     * Return the hour in a simple text format - hh:mm
     * 
     * @return     the hour in String format 
     */
    
    public String getTime()
    {
        return formatHour.format(date);
    }
    
    /**
     * Return the year of the current date
     * 
     * @return     the year in int format
     */
    
    public int getYear()
    {
        String dateYear = formatDate.format(date).substring(6,10);
        return (new Integer(dateYear)).intValue();
    }
    
    /**
     * Return the month of the current date
     * 
     * @return     the month in int format
     */
    
    public int getMonth()
    {
        String dateMonth = formatDate.format(date).substring(3,5);
        return (new Integer(dateMonth)).intValue();
    }
    
    /**
     * Return the day of the current date
     * 
     * @return     the day in int format
     */
    
    public int getDay()
    {
        String dateDay = formatDate.format(date).substring(0,2);
        return (new Integer(dateDay)).intValue();
    }    
    
    /**
     * Return the hour of the current date
     * 
     * @return     the hour in int format
     */
    
    public int getHour()
    {
        String dateHour = formatHour.format(date).substring(0,2);
        return (new Integer(dateHour)).intValue();
    }    
    
    /**
     * Return the minutes of the current date
     * 
     * @return     the minutes in int format
     */
    
    public int getMinute()
    {
        String dateMinute = formatHour.format(date).substring(3,5);
        return (new Integer(dateMinute)).intValue();
    }    
}