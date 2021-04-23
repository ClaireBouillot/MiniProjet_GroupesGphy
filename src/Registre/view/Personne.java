package Registre.view;

import Registre.Main;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.Month;

/**
 * Implémentation des personnes
 *
 * @author Group 12
 * @version 23/04/2021
 */
public class Personne
{
    // variables d'instance
    private int x;
    private final StringProperty nom;
    private final StringProperty prenomP;
    private final StringProperty promoP;//ObjectProperty<ChoiceBox<String>> promoP;
    private final ObjectProperty<LocalDate> annivP;
    private final StringProperty optionP;

    /**
     * Constructeur
     */
    public Personne() {
        this(null, null, null, null, null);
    }

    /**
     * Constructeur
     */
    public Personne(String nom, String prenom, LocalDate anniv, String promo, String option) {
        this.nom = new SimpleStringProperty(nom);
        this.prenomP = new SimpleStringProperty(prenom);
        this.promoP = new SimpleStringProperty(promo);
        this.annivP = new SimpleObjectProperty<LocalDate>(anniv);
        this.optionP = new SimpleStringProperty(option);
    }

    /**
     * Modifie le nom de la personne
     */
    public void setNomP(String nomP) {
        this.nom.set(nomP);
    }

    /**
     * Retourne le nom de la personne
     * @return     nom de la personne
     */
    public String getNomP() {
        return nom.get();
    }

    /**
     * Retourne le nom de la personne dans un format adapté au fxml
     * @return     nom de la personne
     */
    public StringProperty nomProperty(){ return nom; }

    /**
     * Modifie le prénom de la personne
     */
    public void setPrenomP(String prenomP) { this.prenomP.set(prenomP); }
    public String getPrenomP() {
        return prenomP.get();
    }

    /**
     * Retourne le prénom de la personne dans un format adapté au fxml
     * @return     prénom de la personne
     */
    public StringProperty prenomProperty(){ return prenomP; }

    /**
     * Modifie la promotion de la personne
     */
    public void setPromoP(String promoP) { this.promoP.set(promoP); }

    /**
     * Retourne la promotion de la personne
     * @return     promotion de la personne
     */
    public String getPromoP() {
        return promoP.get();
    }

    /**
     * Retourne la promotion de la personne dans un format adapté au fxml
     * @return     promotion de la personne
     */
    public StringProperty promoProperty(){ return promoP; }

    /**
     * Modifie la date de naissance de la personne
     */
    public void setAnnivP(LocalDate annivP) {
        this.annivP.set(annivP);
    }

    /**
     * Retourne la date de naissance de la personne
     * @return     date de naissance de la personne
     */
    public LocalDate getAnnivP() {
        return annivP.get();
    }

    /**
     * Retourne la date de naissance de la personne dans un format adapté au fxml
     * @return     date de naissance de la personne
     */
    public ObjectProperty<LocalDate> annivProperty(){ return annivP; }

    /**
     * Modifie l'option de la personne
     */
    public void setOptionP(String optionP) {
        this.optionP.set(optionP);
    }


    /**
     * Retourne l'option de la personne
     * @return     l'option de la personne
     */
    public String getOptionP() { return optionP.get(); }

    /**
     * Retourne l'option de la personne dans un format adapté au fxml
     * @return     l'option de la personne
     */
    public StringProperty optionProperty(){ return optionP; }

}
