/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.Observer;
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
public class RondeEenSchermController extends GridPane implements Observer
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
    
    private DomeinController dc;
    private Speler speler;
    private Speler bieke;
    private Speler brian;
    private Speler marianne;
    private Speler robin;

    /**
     * Initializes the controller class.
     */
    public RondeEenSchermController(DomeinController dc)
    {
        this.dc = dc;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RondeEenScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try
        {
            loader.load();
            bieke = dc.getSpeler("Bieke");
            brian = dc.getSpeler("Brian");
            marianne = dc.getSpeler("Marianne");
            robin = dc.getSpeler("Robin");
            txtBieke.setText(bieke.getName());
            txtBrian.setText(brian.getName());
            txtMarianne.setText(marianne.getName());
            txtRobin.setText(robin.getName());
            txtBiekeScore.setText(Integer.toString(bieke.getScore()));
            txtBrianScore.setText(Integer.toString(brian.getScore()));
            txtMarianneScore.setText(Integer.toString(marianne.getScore()));
            txtRobinScore.setText(Integer.toString(robin.getScore()));
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
        this.dc.addObserver(this);
    }

    @FXML
    private void selectBieke(ActionEvent event)
    {
        txtBieke.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = bieke;
    }

    @FXML
    private void selectBrian(ActionEvent event)
    {
        txtBrian.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = brian;
    }

    @FXML
    private void selectMarianne(ActionEvent event)
    {
        txtMarianne.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = marianne;
    }

    @FXML
    private void selectRobin(ActionEvent event)
    {
        txtRobin.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = robin;
    }

    @FXML
    private void goedGeantwoord(ActionEvent event)
    {
        speler.setScore(speler.getScore() + 5);
    }

    @FXML
    private void volgendeRonde(ActionEvent event)
    {
        Stage stage = new Stage();
        Scene scene = new Scene(new RondeTweeSchermController(dc));
        stage.setScene(scene);
        stage.setTitle("Open Deur");
        stage.show();
    }

    @Override
    public void update(int score)
    {
        txtBiekeScore.setText(Integer.toString(bieke.getScore()));
        txtBrianScore.setText(Integer.toString(brian.getScore()));
        txtMarianneScore.setText(Integer.toString(marianne.getScore()));
        txtRobinScore.setText(Integer.toString(robin.getScore()));
    }
    
}
