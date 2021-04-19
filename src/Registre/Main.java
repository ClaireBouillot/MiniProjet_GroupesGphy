package Registre;

import Registre.view.Personne;
import Registre.view.newAjoutController;
import Registre.view.registreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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
    private static BorderPane rootLayout;

    private ArrayList<Personne> listeP;
    private Personne P;

    //ObservableList<Personne> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public Main() {

        //personData.add(new Personne("Villard", "Rachel",LocalDate.of(1999, Month.JANUARY,1),"M1","Biotech"));
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    //public ObservableList<Personne> getPersonnes() {
    //    return personData;
    //}

    @Override
    public void start(Stage primaryStage) throws Exception
    {





        primaryStage.setTitle("Registre");

        initRootLayout(primaryStage);
        showOverview(primaryStage);
        primaryStage.show();


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

    public void initRootLayout(Stage primaryStage) throws IOException {
        try {



            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/newfx.fxml"));//Main.class.getResource("fx.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showOverview(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/overView.fxml"));
            AnchorPane overView = (AnchorPane) loader.load();

            rootLayout.setCenter(overView);

            registreController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Personne person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/newAjout.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter une personne");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            newAjoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void Main(String[] args) {
        launch(args);
    }

}
