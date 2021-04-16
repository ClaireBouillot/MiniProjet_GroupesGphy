package Registre;

import Registre.view.Personne;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/newfx.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene (root);

        stage.setTitle("Registre");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();

    }




    public static void Main(String[] args) {
        launch(args);
    }

}
