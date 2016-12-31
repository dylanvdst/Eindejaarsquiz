/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.Observer;
import domein.Speler;
import domein.Vraag;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class FinaleSchermController extends GridPane implements Observer
{

    @FXML
    private TextArea txtSpeler1;
    @FXML
    private TextArea txtSpeler1Score;
    @FXML
    private TextArea txtSpeler2;
    @FXML
    private TextArea txtSpeler2Score;
    @FXML
    private TextArea txtA1;
    @FXML
    private TextArea txtA3;
    @FXML
    private TextArea txtA5;
    @FXML
    private TextArea txtA2;
    @FXML
    private TextArea txtA4;
    @FXML
    private Button btnSpeler1;
    @FXML
    private Button btnSpeler2;
    @FXML
    private TextArea txtVraag;
    @FXML
    private Button btnA1;
    @FXML
    private Button btnA2;
    @FXML
    private Button btnA3;
    @FXML
    private Button btnA4;
    @FXML
    private Button btnA5;
    @FXML
    private Button btnStartTimer;
    @FXML
    private Button btnStopTimer;
    @FXML
    private Button btnVolgendeVraag;
    private final DomeinController dc;
    private Speler speler1;
    private Speler speler2;
    private Speler spelendeSpeler;
    private Speler kijkendeSpeler;
    @FXML
    private Button btnDeselecteer;
    private List<Vraag> vragen;
    private int vraagNr;
    private Vraag vraag;
    @FXML
    private Button btnEerste;

    public FinaleSchermController(DomeinController dc)
    {
        this.dc = dc;
        vragen = dc.getFinaleVragen();
        vraagNr = 0;
        vraag = vragen.get(vraagNr);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinaleScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);    
        try
        {
            loader.load();
            ArrayList<Speler> finalisten = this.dc.bepaalFinalisten();
            speler1 = finalisten.get(0);
            speler2 = finalisten.get(1);
            txtSpeler1.setText(speler1.getName());
            txtSpeler1Score.setText(Integer.toString(speler1.getScore()));
            txtSpeler2.setText(speler2.getName());
            txtSpeler2Score.setText(Integer.toString(speler2.getScore()));
            btnStopTimer.setDisable(true);
            btnSpeler1.setText(speler1.getName());
            btnSpeler2.setText(speler2.getName());
            
        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
        this.dc.addObserver(this);
    }

    @FXML
    private void selecteerSpeler1(ActionEvent event)
    {
        txtSpeler1.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtSpeler2.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.spelendeSpeler = speler1;
        this.kijkendeSpeler = speler2;
    }

    @FXML
    private void selecteerSpeler2(ActionEvent event)
    {
        txtSpeler1.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtSpeler2.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        this.spelendeSpeler = speler2;
        this.kijkendeSpeler = speler1;
    }

    @FXML
    private void a1(ActionEvent event)
    {
        txtA1.setVisible(true);
        btnA1.setDisable(true);
        if (spelendeSpeler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void a2(ActionEvent event)
    {
        txtA2.setVisible(true);
        btnA2.setDisable(true);
        if (spelendeSpeler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void a3(ActionEvent event)
    {
        txtA3.setVisible(true);
        btnA3.setDisable(true);
        if (spelendeSpeler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void a4(ActionEvent event)
    {
        txtA4.setVisible(true);
        btnA4.setDisable(true);
        if (spelendeSpeler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void a5(ActionEvent event)
    {
        txtA5.setVisible(true);
        btnA5.setDisable(true);
        if (spelendeSpeler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void startTimer(ActionEvent event)
    {
        btnStartTimer.setDisable(true);
        btnStopTimer.setDisable(false);
        spelendeSpeler.timer();
        if (spelendeSpeler.equals(speler1))
        {
            txtSpeler1Score.setText(Integer.toString(speler1.getScore()));
        } else if (spelendeSpeler.equals(speler2))
        {
            txtSpeler2Score.setText(Integer.toString(speler2.getScore()));
        }
    }

    @FXML
    private void stopTimer(ActionEvent event)
    {
        btnStartTimer.setDisable(false);
        btnStopTimer.setDisable(true);
        spelendeSpeler.stopTimer();
        if (spelendeSpeler.equals(speler1))
        {
            txtSpeler1Score.setText(Integer.toString(speler1.getScore()));
        } else if (spelendeSpeler.equals(speler2))
        {
            txtSpeler2Score.setText(Integer.toString(speler2.getScore()));
        }
    }

    @FXML
    private void volgendeVraag(ActionEvent event)
    {
    }

    private void goedGeantwoord()
    {
        spelendeSpeler.stopTimer();
        this.kijkendeSpeler.setScore(this.kijkendeSpeler.getScore() - 20);
        if (spelendeSpeler.equals(speler1))
        {
            txtSpeler1Score.setText(Integer.toString(speler1.getScore()));
        } else if (spelendeSpeler.equals(speler2))
        {
            txtSpeler2Score.setText(Integer.toString(speler2.getScore()));
        }
        spelendeSpeler.timer();
    }

    @FXML
    private void deselecteerSpeler(ActionEvent event)
    {
        this.spelendeSpeler = null;
        this.kijkendeSpeler = null;
        txtSpeler1.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtSpeler2.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
    }

    @FXML
    private void eersteRonde(ActionEvent event)
    {
        txtVraag.setText(vraag.getText());
        txtA1.setText(vraag.getAntwoord().get(0));
        txtA1.setVisible(false);
        txtA2.setText(vraag.getAntwoord().get(1));
        txtA2.setVisible(false);
        txtA3.setText(vraag.getAntwoord().get(2));
        txtA3.setVisible(false);
        txtA4.setText(vraag.getAntwoord().get(3));
        txtA4.setVisible(false);
        txtA5.setText(vraag.getAntwoord().get(4));
        txtA5.setVisible(false);
        btnEerste.setDisable(true);
    }

    @Override
    public void update(int score)
    {
        txtSpeler1Score.setText(Integer.toString(speler1.getScore()));
        txtSpeler2Score.setText(Integer.toString(speler2.getScore()));
    }
    
}
