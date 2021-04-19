package Registre.view;

import Registre.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.Month;

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

    public registreController() {
    }

    ObservableList<Personne> personData = FXCollections.observableArrayList();

    public ObservableList<Personne> getPersonnes() {
        personData.add(new Personne("Villard", "Rachel", LocalDate.of(1999, Month.JANUARY, 1), "M1", "Biotech"));

        return personData;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
  /**  private void initialize() {
        nomCol.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomCol.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        dateNCol.setCellValueFactory(cellData -> cellData.getValue().annivProperty());
        promotionCol.setCellValueFactory(cellData -> cellData.getValue().promoProperty());
        optionCol.setCellValueFactory(cellData -> cellData.getValue().optionProperty());

        table.setItems(getPersonnes());

    }**/

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;

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
       /** boolean okClicked = main.showPersonEditDialog(tempPerson);
        if (okClicked) {
            getPersonnes().add(tempPerson);
        }**/
    }

    /*    *//**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     *//*
    @FXML
    private void handleEditPerson() {
        Personne selectedPerson = table.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = main.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonEditDialog(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }*/
/*    public void setTableItems(ObservableList<Personne> pers) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newfx.fxml"));
        Scene registre = new Scene(loader.load());

        registreController controller = loader.getController();
        controller.setTableItems(pers);
    }*/


    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     **/
/*    @FXML
    private void ajoutListener(ActionEvent event) throws Exception
    {
        //int i;

        //for (i = 0; i < P.size (); i++)
        // pers=P.get(i);

        // table.getItems().add(i,pers);
        Parent root = FXMLLoader.load(getClass().getResource("ajout.fxml"));
        Scene scene = new Scene (root);
        secondaryStage = new Stage();



        // JavaFX must have a Scene (window content) inside a Stage (window)
        //Scene scene = new Scene(pane, 300,100);
        secondaryStage.setTitle("Ajouter");
        secondaryStage.setScene(scene);

        // Show the Stage (window)
        secondaryStage.show();
    }


    *//**
     * This will be executed when the button is clicked
     * It increments the count by 1
     **//*
    @FXML
    private void validerListener(ActionEvent event) throws Exception
    {
        System.out.println(Nom.getText());
        SimpleDate date = new SimpleDate(12,2,2008);
        Personne P=new Personne("toto","tutu",date,"m1","biotech");
        table.getItems().add(P);
        //table.getItems().add(1,Nom.getText());

        //int i;

        //for (i = 0; i < P.size (); i++)
        // pers=P.get(i);

        // table.getItems().add(i,pers);

    }*/
}
