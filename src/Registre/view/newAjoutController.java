package Registre.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Calendar;

public class newAjoutController {

    registreController ajout;
    ObservableList<String> promotionList = FXCollections.observableArrayList("L3", "M1", "M2");
    ObservableList<String> optionList = FXCollections.observableArrayList("Physio", "Biotech", "Imageur");

    @FXML private TextField nomField;
    @FXML private TextField prenomField;
    @FXML private DatePicker dateNaissance;
    @FXML private ChoiceBox promotionBox;
    @FXML private ChoiceBox optionBox;

    TableView tableV = new TableView(registreController.getPersonnes());

    @FXML
    private void initialize(){
        promotionBox.setValue("L3");
        promotionBox.setItems(promotionList);
        optionBox.setValue("Physio");
        optionBox.setItems(optionList);
    }


    @FXML
    private void showDate(){
        Calendar now = Calendar.getInstance();

    }

    @FXML
    public void ajoutValider() throws IOException {
        registreController.getPersonnes().add(new Personne(prenomField.getText(),
                                    nomField.getText(),
                                    dateNaissance.getValue(),
                                    promotionBox.getAccessibleText(),
                                    optionBox.getAccessibleText()));

        System.out.println("Displaying");

        //ajout.ajouterUnePersonne(newPersonne);
        //table.getItem().add(newPersonne);
    }
}
