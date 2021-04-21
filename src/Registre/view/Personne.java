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
 * Décrivez votre classe Personne ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Personne
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int x;
    private final StringProperty nom;
    private final StringProperty prenomP;
    private final StringProperty promoP;//ObjectProperty<ChoiceBox<String>> promoP;
    private final ObjectProperty<LocalDate> annivP;
    private final StringProperty optionP;

    /**
     * Default constructor.
     */
    public Personne() {
        this(null, null, null, null, null);
    }

    public Personne(String nom, String prenom, LocalDate anniv, String promo, String option) {
        this.nom = new SimpleStringProperty(nom);
        this.prenomP = new SimpleStringProperty(prenom);
        this.promoP = new SimpleStringProperty(promo);
        this.annivP = new SimpleObjectProperty<LocalDate>(anniv);
        this.optionP = new SimpleStringProperty(option);
    }

    public void setNomP(String nomP) {
        this.nom.set(nomP);
    }
    public String getNomP() {
        return nom.get();
    }
    public StringProperty nomProperty(){ return nom; }

    public void setPrenomP(String prenomP) { this.prenomP.set(prenomP); }
    public String getPrenomP() {
        return prenomP.get();
    }
    public StringProperty prenomProperty(){ return prenomP; }

    public void setPromoP(String promoP) { this.promoP.set(promoP); }
    public String getPromoP() {
        return promoP.get();
    }
    public StringProperty promoProperty(){ return promoP; }

    public void setAnnivP(LocalDate annivP) {
        this.annivP.set(annivP);
    }
    public LocalDate getAnnivP() {
        return annivP.get();
    }
    public ObjectProperty<LocalDate> annivProperty(){ return annivP; }

    public void setOptionP(String optionP) {
        this.optionP.set(optionP);
    }
    public String getOptionP() { return optionP.get(); }
    public StringProperty optionProperty(){ return optionP; }

}
