package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
/**
 * Listener pour l'ajout
 *
 * @author CLaire, Lucie, Rachel
 * @version 16/03/2021
 **/
public class Ajouter
{
    @FXML
    //private TableView table;
    private TextField Nom;
    private TextField Prenom;
    private DatePicker dateNaissance;
    private ComboBox promotion;
    private ComboBox option;
    private TableView<Personne> table;
    //private TableColumn NomC;
    private Stage secondaryStage;
    private Button Valider;
    public Ajouter() {
        //P=ListeP;
    }
    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     **/
    @FXML
    private void ajoutListener(ActionEvent event) throws Exception
    {
        //int i;

        //for (i = 0; i < P.size (); i++)
        // pers=P.get(i);

        // table.getItems().add(i,pers);
        Parent root = FXMLLoader.load(getClass().getResource("src/sample/ajout.fxml"));
        Scene scene = new Scene (root);
        secondaryStage = new Stage();



        // JavaFX must have a Scene (window content) inside a Stage (window)
        //Scene scene = new Scene(pane, 300,100);
        secondaryStage.setTitle("Ajouter");
        secondaryStage.setScene(scene);

        // Show the Stage (window)
        secondaryStage.show();
    }


    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     **/
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

    }
}

