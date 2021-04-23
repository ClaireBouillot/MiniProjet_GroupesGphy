package Registre.view;

import Registre.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.time.LocalDate;
import static Registre.Main.getPersonnes;

/**
 * Projet IHM
 * Lie fichier FXML et code avec java
 *
 * @author GROUPE 12 Villard Rachel, Bouillot Claire, Tella Lucie
 * @version 23/04/2021
 */
/**
 * Listener pour l'ajout
 * Listener Modification
 * Listener Suppression
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
     * Initialise la classe du controller, cette méthode est appelée après le chargement de newfx.fxml
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
     * Appelé par le main de l'application pour faire référence à elle même.
     *
     * @param newMain
     */
    public void setMainApp(Main newMain) {
        main = newMain;
        // Charge la liste des données du tableaux
        table.setItems(getPersonnes());
    }

    /**
     * Appellé lorsque l'utilisateur appuie sur le boutton ajouter
     * Ouvre la page de dialogue
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
     * Appellé lorsque l'utilisateur appuie pour modifier.
     * Ouvre la page de dialogue pour modifier une personne.
     */
    @FXML
    private void handleEditPerson() {
        Personne selectedPerson = table.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = main.showPersonEditDialog(selectedPerson);

        } else {
            // Si rien n'est sélectionné, apparition d'un message d'erreur.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Appellé quand l'utilisateur appuie sur le boutton supprimer
     *
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            table.getItems().remove(selectedIndex);
        } else {
            // Si personne n'est sélectionné, apparition d'un message d'erreur.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

}
