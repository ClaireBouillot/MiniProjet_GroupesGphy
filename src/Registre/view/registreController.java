package Registre.view;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import Registre.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Listener pour l'ajout
 *
 * @author CLaire, Lucie, Rachel
 * @version 16/03/2021
 **/
public class registreController
{
    private Main main;
    private String nom;
    private String prenom;
    private LocalDate date;
    private String promo;
    private String opt;

    private Personne p;

    @FXML private TableView<Personne> table;
    @FXML private TableColumn<Personne, String> nomCol;
    @FXML private TableColumn<Personne, String> prenomCol;
    @FXML private TableColumn<Personne, LocalDate> dateNCol;
    @FXML private TableColumn<Personne, String> promotionCol;
    @FXML private TableColumn<Personne, String> optionCol;

    public static ObservableList<Personne> getPersonnes(){
        ObservableList<Personne> person = FXCollections.observableArrayList();
        person.add(new Personne("Rachel","Villard",LocalDate.of(1999, Month.JANUARY,1),"M1","Biotech"));

        return person;
    }


    @FXML
    private void initialize() {
        nomCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("nomP"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenomP"));
        dateNCol.setCellValueFactory(new PropertyValueFactory<Personne, LocalDate>("annivP"));
        promotionCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("promoP"));
        optionCol.setCellValueFactory(new PropertyValueFactory<Personne, String>("optionP"));

        table.setItems(getPersonnes());

    }

    public void showAjouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/newAjout.fxml"));
        Parent ajout_parent = loader.load();

        newAjoutController addController = loader.getController();
        addController.setTableItems(table.getItems());

        Scene scene = new Scene(ajout_parent);
        Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

    }

     public void setTableItems(ObservableList<Personne> pers) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("newfx.fxml"));
         Scene registre = new Scene(loader.load());

         registreController controller = loader.getController();
         controller.setTableItems(pers);
    }

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

