package Registre.view;

import Registre.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;

import static Registre.Main.getPersonnes;

/**
 * Listener pour l'ajout
 *
 * @author CLaire, Lucie, Rachel
 * @version 16/03/2021
 **/
public class registreController {
    private Main main;

    @FXML
    private TableView<Personne> table;
    @FXML
    private TableColumn<Personne, String> nomCol;
    @FXML
    private TableColumn<Personne, String> prenomCol;
    @FXML
    private TableColumn<Personne, LocalDate> dateNCol;
    @FXML
    private TableColumn<Personne, String> promotionCol;
    @FXML
    private TableColumn<Personne, String> optionCol;
    private static Stage stage;

    public registreController() throws Exception {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        nomCol.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomCol.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        dateNCol.setCellValueFactory(cellData -> cellData.getValue().annivProperty());
        promotionCol.setCellValueFactory(cellData -> cellData.getValue().promoProperty());
        optionCol.setCellValueFactory(cellData -> cellData.getValue().optionProperty());

        table.setItems(getPersonnes());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param newMain
     */
    public void setMainApp(Main newMain) {
        main = newMain;
        // Add observable list data to the table
        table.setItems(getPersonnes());
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Personne tempPerson = new Personne();
        boolean okClicked = main.showPersonEditDialog(tempPerson);
        if (okClicked) {
            getPersonnes().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Personne selectedPerson = table.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = main.showPersonEditDialog(selectedPerson);
/*            if (okClicked) {
                //main.showPersonEditDialog(selectedPerson);
            }*/

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

}
