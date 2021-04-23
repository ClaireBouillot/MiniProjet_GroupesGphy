package Registre;

import Registre.view.Personne;
import Registre.view.newAjoutController;
import Registre.view.registreController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * Projet IHM
 * Lie fichier FXML et code avec java
 *
 * @author GROUPE 12 Villard Rachel, Bouillot Claire, Tella Lucie
 * @version 23/04/2021
 */
/**
 * Main de l'application
 **/
public class Main extends Application
{
    private static Stage primaryStage;
    private static BorderPane rootLayout;

    private ArrayList<Personne> listeP;
    private Personne P;
    private registreController control;
    static ObservableList<Personne> personData = FXCollections.observableArrayList();

    /**
     * Constructeur du Main
     */
    public Main() {
        personData.add(new Personne("Villard", "Rachel", LocalDate.of(1999, Month.JANUARY,1),"M1","Biotech"));
        System.out.println(personData.get(0));
    }

    /**
     * Retourne les valeurs de la liste observable des personnes
     * @return
     */
    public static ObservableList<Personne> getPersonnes() {
        return personData;
    }
    /**
     * Prend en paramètre la fenêtre
     * utilise initRootLayout
     *
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {

        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Registre");

        initRootLayout();

    }

    /**
     * Initialise le root layout
     *
     */
    public void initRootLayout() {
        try {
            // charge le root layout du fichier newfx.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/newfx.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Montre le contenu de root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            registreController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Ouvre la page de dialogue pour enregistrer une personne.
     * Si l'utilisateur clique sur valider la personne est enregistrée.
     *
     * @param person la personne est l'objet a enregistrer
     *
     */
    public boolean showPersonEditDialog(Personne person) {
        try {
            // charge le fichier fxml et créer une nouvelle page pour le dialogue.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/modif.fxml"));
            BorderPane page = (BorderPane) loader.load();

            // Créer la page de dialogue.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modifier une personne");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // passe la personne dans la controller.
            newAjoutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // montrer la page dialogue et attendre que l'utilisateur la ferme.
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ObservableList<Personne> getPersonData() {
        return personData;
    }

    /**
     * Retourne la page du main.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     * lance le programme
     */
    public static void Main(String[] args) {
        launch(args);
    }

}
