package Registre;

import java.util.*;
import java.text.*;

/**
 * Implémentation des dates
 * 
 * @author Group 12
 * @version 23/04/2021
 */
public class SimpleDate
{
    // variable d'instance
    private Date date;
    
    // Pour formater les dates
    private static final SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat formatHour = new SimpleDateFormat("hh:mm");

    /**
     * Constructeur
     */
    public SimpleDate()
    {
        // initialisation de variables d'instances
        date = new Date();
    }

    /**
     * Constructeur
     */
    public SimpleDate(int day, int month, int year)
    {
        // initialisation des variables d'instances
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        date = c.getTime();
    }
        
    /**
     * Retourne une date sous le format : jj/mm/aaaa hh:mm
     * 
     * @return     la date sous forme de string
     */
    public String getCompleteDate()
    {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return formatDate.format(date);
    }
    
    /**
     * Retounre la date sous le format : jj/mm/aaaa
     * 
     * @return     la date sous forme de string
     */
    public String getDate()
    {
        return formatDate.format(date);
    }
    
    /**
     * Retounre l'heure sous le format  : hh:mm
     * 
     * @return     l'heure sous forme de string
     */
    
    public String getTime()
    {
        return formatHour.format(date);
    }
    
    /**
     * Retounre l'année de la doate courante
     * 
     * @return     l'année au format integer
     */
    
    public int getYear()
    {
        String dateYear = formatDate.format(date).substring(6,10);
        return (new Integer(dateYear)).intValue();
    }
    
    /**
     * Retourne le mois de la date courante
     * 
     * @return     le mois sous format integer
     */
    
    public int getMonth()
    {
        String dateMonth = formatDate.format(date).substring(3,5);
        return (new Integer(dateMonth)).intValue();
    }
    
    /**
     * Retounre le jour de la date courante
     * 
     * @return     le jour dans un format integer
     */
    
    public int getDay()
    {
        String dateDay = formatDate.format(date).substring(0,2);
        return (new Integer(dateDay)).intValue();
    }    
    
    /**
     * Retounre l'heure de la date courante
     * 
     * @return     l'heure en integer
     */
    
    public int getHour()
    {
        String dateHour = formatHour.format(date).substring(0,2);
        return (new Integer(dateHour)).intValue();
    }    
    
    /**
     * Retounre les minutes de la date courante
     * 
     * @return   les minutes en integer
     */
    
    public int getMinute()
    {
        String dateMinute = formatHour.format(date).substring(3,5);
        return (new Integer(dateMinute)).intValue();
    }    
}