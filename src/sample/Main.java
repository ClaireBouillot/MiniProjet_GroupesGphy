package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import javafx.scene.Parent;
import java.util.ArrayList;
import java.util.Date;
/**
 * The StepTwo of JavafX tutorial
 * Linking FXML and java code via java
 *
 * @author Patrick Girard
 * @version 22/03/2020
 */

public class Main extends Application
{
    private ArrayList<Personne> listeP;
    private Personne P;
    @Override
    public void start(Stage stage) throws Exception
    {
        listeP=new ArrayList<Personne>();
        SimpleDate date = new SimpleDate(12,2,2008);
        P=new Personne("toto","tutu",date,"m1","biotech");
        listeP.add(P);

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fx.fxml"));
       Scene scene = new Scene (root);

        stage.setTitle("Registre");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();

    }
}
