package Registre.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Calendar;

import static Registre.Main.getPersonnes;

public class newAjoutController {

    //registreController ajout;
    ObservableList<String> promotionList = FXCollections.observableArrayList("L3", "M1", "M2");
    ObservableList<String> optionList = FXCollections.observableArrayList("Physio", "Biotech", "Imageur");

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
    //TableView tableV = new TableView(registreController.getPersonnes());

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        promotionBox.setValue("L3");
        promotionBox.setItems(promotionList);
        optionBox.setValue("Physio");
        optionBox.setItems(optionList);
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
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
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
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
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) {
            errorMessage += "Nom non valide!\n";
        }
        if (prenomField.getText() == null || prenomField.getText().length() == 0) {
            errorMessage += "PrÃ©nom non valide!\n";
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
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

/*    @FXML
    public void validerAjout() {


        getPersonnes().add(new Personne(prenomField.getText(),
                nomField.getText(),
                dateNaissance.getValue(),
                promotionBox.getAccessibleText(),
                optionBox.getAccessibleText()));

        System.out.println("Displaying");

        //ajout.ajouterUnePersonne(newPersonne);
        //table.getItem().add(newPersonne);
    }*/

}