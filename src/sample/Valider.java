import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
/**
 * Listener pour l'ajout
 *
 * @author CLaire, Lucie, Rachel
 * @version 16/03/2021
 **/
public class Valider
{
    @FXML
    private TextField Nom;
    private TextField Prenom;
    private DatePicker dateNaissance;
    private ComboBox promotion;
    private ComboBox option;
    private TableView table;
    public Valider() {
       
    }
    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     **/
    @FXML
    private void validerListener(ActionEvent event) throws Exception
    {
        table.getItems().add(1,Nom.getText());
        
        //int i;
      
        //for (i = 0; i < P.size (); i++)
            // pers=P.get(i);
             
            // table.getItems().add(i,pers);
        
    }
}