package Registre.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Projet IHM
 * Lie fichier FXML et code avec java
 *
 * @author GROUPE 12 Villard Rachel, Bouillot Claire, Tella Lucie
 * @version 23/04/2021
 */

/**
 * Listener pour la validation
 **/
public class newAjoutController {

    //registreController ajout;
    ObservableList<String> promotionList = FXCollections.observableArrayList("Selectionner","L3", "M1", "M2");
    ObservableList<String> optionList = FXCollections.observableArrayList("Selectionner","Physio", "Biotech", "Imageur");

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private DatePicker dateNaissance;
    @FXML
    private ChoiceBox<String> promotionBox;
    @FXML
    private ChoiceBox<String> optionBox;

    private Stage dialogStage;
    private Personne person;
    private boolean okClicked = false;


    /**
     * Initialise la classe du controller.
     * Cette méthode est automatiquement appelée après le chargement du fichier fxml newAjout.
     *
     */
    @FXML
    private void initialize() {
        promotionBox.setValue("Selectionner");
        promotionBox.setItems(promotionList);
        optionBox.setValue("Selectionner");
        optionBox.setItems(optionList);
    }

    /**
     * Changer la page de dialogue
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * changer la personne qui doit etre éditée
     *
     * @param person
     */
    public void setPerson(Personne person) {
        this.person = person;

        nomField.setText(person.getNomP());
        prenomField.setText(person.getPrenomP());
        promotionBox.setValue(String.valueOf(person.getPromoP()));
        dateNaissance.setValue(person.getAnnivP());
        optionBox.setValue(String.valueOf(person.getOptionP()));
    }

    /**
     * Retourne vrai si l'utilisateur clique sur ok.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Appelle handleOk quand l'utilisateur clique sur Ok.
     * charge les données de la personne
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNomP(nomField.getText());
            person.setPrenomP(prenomField.getText());
            person.setAnnivP(dateNaissance.getValue());
            person.setPromoP(promotionBox.getValue());
            person.setOptionP(optionBox.getValue());


            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Appelle quand l'utilisateur click sur fermé.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     *Valide si les champs sont remplies.
     *
     * @return true si les champs sont valides
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) {
            errorMessage += "Nom non valide!\n";
        }
        if (prenomField.getText() == null || prenomField.getText().length() == 0) {
            errorMessage += "Prenom non valide!\n";
        }
        if (dateNaissance.getValue() == null || dateNaissance.getValue() == null) {
            errorMessage += "Date de naissance non valide!\n";
        }
        if (promotionBox.getValue() == null || promotionBox.getValue() == null) {
            errorMessage += "No valid street!\n";
        }
        if (optionBox.getValue() == null || optionBox.getValue() == null) {
            errorMessage += "No valid city!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Montre un message d'erreur.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}