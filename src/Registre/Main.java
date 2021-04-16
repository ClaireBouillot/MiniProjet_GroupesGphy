package Registre;

import Registre.view.Personne;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * The StepTwo of JavafX tutorial
 * Linking FXML and java code via java
 *
 * @author Patrick Girard
 * @version 22/03/2020
 */

public class Main extends Application
{
    private static Stage primaryStage;
    private static BorderPane mainLayout;
    private ArrayList<Personne> listeP;
    private Personne P;



    @Override
    public void start(Stage stage) throws Exception
    {
        this.primaryStage=stage;
        this.primaryStage.setTitle("Registre");

        showMainView();

        /*listeP=new ArrayList<Personne>();
        SimpleDate date = new SimpleDate(12,2,2008);
        P=new Personne("toto","tutu",date,"m1","biotech");
        listeP.add(P);

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fx.fxml"));
       Scene scene = new Scene (root);

        stage.setTitle("Registre");
        stage.setScene(scene);*/

        // Show the Stage (window)
        //stage.show();

    }

    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/newfx.fxml"));//Main.class.getResource("fx.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showAjouter() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/newAjout.fxml"));
        BorderPane ajout = loader.load();

        Stage addStage = new Stage();
        addStage.setTitle("Ajouter");
        addStage.initModality(Modality.WINDOW_MODAL);
        addStage.initOwner(primaryStage);
        //mainLayout.setCenter(ajout);
        Scene scene = new Scene(ajout);
        addStage.setScene(scene);
        addStage.showAndWait();

    }


    public static void Main(String[] args) {
        launch(args);
    }

}
