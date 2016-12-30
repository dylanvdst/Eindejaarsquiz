/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.Speler;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class RondeEenSchermController extends GridPane
{

    @FXML
    private Button btnBieke;
    @FXML
    private Button btnBrian;
    @FXML
    private Button btnMarianne;
    @FXML
    private Button btnRobin;
    @FXML
    private Button btnGoedGeantwoord;
    @FXML
    private Button btnNext;
    @FXML
    private TextArea txtBieke;
    @FXML
    private TextArea txtBiekeScore;
    @FXML
    private TextArea txtBrian;
    @FXML
    private TextArea txtBrianScore;
    @FXML
    private TextArea txtMarianne;
    @FXML
    private TextArea txtMarianneScore;
    @FXML
    private TextArea txtRobin;
    @FXML
    private TextArea txtRobinScore;
    
    private DomeinController domeinController;
    private Speler speler;

    /**
     * Initializes the controller class.
     */
    public RondeEenSchermController(DomeinController dc)
    {
        this.domeinController = dc;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RondeEenScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try
        {
            loader.load();
            txtBieke.setText(dc.getSpeler("Bieke").getName());
            txtBrian.setText(dc.getSpeler("Brian").getName());
            txtMarianne.setText(dc.getSpeler("Marianne").getName());
            txtRobin.setText(dc.getSpeler("Robin").getName());
            txtBiekeScore.setText(Integer.toString(dc.getSpeler("Bieke").getScore()));
            txtBrianScore.setText(Integer.toString(dc.getSpeler("Brian").getScore()));
            txtMarianneScore.setText(Integer.toString(dc.getSpeler("Marianne").getScore()));
            txtRobinScore.setText(Integer.toString(dc.getSpeler("Robin").getScore()));
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    private void selectBieke(ActionEvent event)
    {
        txtBieke.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = this.domeinController.getSpeler("Bieke");
    }

    @FXML
    private void selectBrian(ActionEvent event)
    {
        txtBrian.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = this.domeinController.getSpeler("Brian");
    }

    @FXML
    private void selectMarianne(ActionEvent event)
    {
        txtMarianne.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = this.domeinController.getSpeler("Marianne");
    }

    @FXML
    private void selectRobin(ActionEvent event)
    {
        txtRobin.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = this.domeinController.getSpeler("Robin");
    }

    @FXML
    private void goedGeantwoord(ActionEvent event)
    {
        speler.setScore(speler.getScore() + 5);
        if(speler.getName().equals("Bieke"))
            txtBiekeScore.setText(Integer.toString(speler.getScore()));
        else if(speler.getName().equals("Brian"))
            txtBrianScore.setText(Integer.toString(speler.getScore()));
        else if(speler.getName().equals("Marianne"))
            txtMarianneScore.setText(Integer.toString(speler.getScore()));
        else if(speler.getName().equals("Robin"))
            txtRobinScore.setText(Integer.toString(speler.getScore()));
    }

    @FXML
    private void volgendeRonde(ActionEvent event)
    {
        Stage stage = new Stage();
        Scene scene = new Scene(new RondeTweeSchermController(domeinController));
        stage.setScene(scene);
        stage.setTitle("Open Deur");
        stage.show();
    }
    
}
