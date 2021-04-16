package Registre.view;

import Registre.SimpleDate;

import java.time.LocalDate;

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
    private LocalDate annivP;
    private String optionP;

    public Personne(String nom, String prenom, LocalDate anniv,String promo,  String option) {
        this.nomP = nom;
        this.prenomP = prenom;
        this.promoP = promo;
        this.annivP = anniv;
        this.optionP = option;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }
    public String getNomP() {
        return nomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }
    public String getPrenomP() {
        return prenomP;
    }

    public void setPromoP(String promoP) {
        this.promoP = promoP;
    }
    public String getPromoP() {
        return promoP;
    }

    public void setAnnivP(LocalDate annivP) {
        this.annivP = annivP;
    }
    public LocalDate getAnnivP() {
        return annivP;
    }

    public void setOptionP(String optionP) {
        this.optionP = optionP;
    }
    public String getOptionP() {
        return optionP;
    }
   
}
