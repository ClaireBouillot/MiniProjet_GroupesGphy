package sample;

import java.util.Date;
/**
 * Décrivez votre classe Personne ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Personne
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;
    private String nomP;
    private String prenomP;
    private String promoP;
    private SimpleDate annivP;
    private String optionP;
    
    /**
     * Constructeur d'objets de classe Personne
     */
    public Personne(String nom,String prenom, SimpleDate anniv, String promotion, String option)
    {
        nomP=nom;
        prenomP=prenom;
        promoP=promotion;
        optionP=option;
        annivP=anniv;
    }
    public void setNom(String newN){
        nomP=newN;
    }
    public String getNom() {
        return nomP;
    }
    public void setPrenom(String newP){
        prenomP=newP;
    }
    public String getPrenom() {
        return prenomP;
    }
   
}
