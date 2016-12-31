/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.Observer;
import domein.Puzzel;
import domein.Speler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class RondeDrieSchermController extends GridPane implements Observer
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
    private Button btnDeselecteer;
    @FXML
    private Button btnToonEerste;
    @FXML
    private TextArea txtBieke;
    @FXML
    private TextArea txtBiekeScore;
    @FXML
    private TextArea txtMarianne;
    @FXML
    private TextArea txtMarianneScore;
    @FXML
    private TextArea txtBrian;
    @FXML
    private TextArea txtBrianScore;
    @FXML
    private TextArea txtRobin;
    @FXML
    private TextArea txtRobinScore;
    @FXML
    private Button btnA1;
    @FXML
    private Button btnA2;
    @FXML
    private Button btnA3;
    @FXML
    private Button btnVolgendeVraag;
    @FXML
    private Button btnVolgendeRonde;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
    @FXML
    private TextArea txtS1;
    @FXML
    private TextArea txtS2;
    @FXML
    private TextArea txtS3;
    @FXML
    private TextArea txtS4;
    @FXML
    private TextArea txtS9;
    @FXML
    private TextArea txtS8;
    @FXML
    private TextArea txtS7;
    @FXML
    private TextArea txtS6;
    @FXML
    private TextArea txtS5;
    @FXML
    private TextArea txtS11;
    @FXML
    private TextArea txtS12;
    @FXML
    private TextArea txtS10;
    @FXML
    private TextArea txtA1;
    @FXML
    private TextArea txtA2;
    @FXML
    private TextArea txtA3;
    private DomeinController dc;
    private Puzzel p1;
    private Puzzel p2;
    private Puzzel p3;
    private Puzzel p4;
    private int puzzelId;
    private Puzzel puzzel;
    private Speler speler;
    private Speler bieke;
    private Speler brian;
    private Speler marianne;
    private Speler robin;
    private List<TextArea> txtLijst = new ArrayList();
    private boolean flag = true;

    public RondeDrieSchermController(DomeinController dc)
    {
        this.dc = dc;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RondeDrieScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        p1 = dc.puzzel1();
        p2 = dc.puzzel2();
        p3 = dc.puzzel3();
        p4 = dc.puzzel4();
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
            btnStop.setDisable(true);
            txtLijst.add(txtS1);
            txtLijst.add(txtS2);
            txtLijst.add(txtS3);
            txtLijst.add(txtS4);
            txtLijst.add(txtS5);
            txtLijst.add(txtS6);
            txtLijst.add(txtS7);
            txtLijst.add(txtS8);
            txtLijst.add(txtS9);
            txtLijst.add(txtS10);
            txtLijst.add(txtS11);
            txtLijst.add(txtS12);

        } catch (IOException ex)
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
        btnBieke.setDisable(true);
        this.speler = bieke;
    }

    @FXML
    private void selectBrian(ActionEvent event)
    {
        txtBrian.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        btnBrian.setDisable(true);
        this.speler = brian;
    }

    @FXML
    private void selectMarianne(ActionEvent event)
    {
        txtMarianne.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        btnMarianne.setDisable(true);
        this.speler = marianne;
    }

    @FXML
    private void selectRobin(ActionEvent event)
    {
        txtRobin.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        btnRobin.setDisable(true);
        this.speler = robin;
    }

    @FXML
    private void deselecteerSpeler(ActionEvent event)
    {
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = null;
    }

    @FXML
    private void eersteRonde(ActionEvent event)
    {
        puzzelId = 1;
        puzzel = p1;
        List<String> lijst = puzzel.getStukjesRandom();
        List<String> antwoorden = puzzel.getAntwoorden();
        txtS1.setText(lijst.get(0));
        txtS2.setText(lijst.get(1));
        txtS3.setText(lijst.get(2));
        txtS4.setText(lijst.get(3));
        txtS5.setText(lijst.get(4));
        txtS6.setText(lijst.get(5));
        txtS7.setText(lijst.get(6));
        txtS8.setText(lijst.get(7));
        txtS9.setText(lijst.get(8));
        txtS10.setText(lijst.get(9));
        txtS11.setText(lijst.get(10));
        txtS12.setText(lijst.get(11));
        txtA1.setText(antwoorden.get(0));
        txtA1.setVisible(false);
        txtA2.setText(antwoorden.get(1));
        txtA2.setVisible(false);
        txtA3.setText(antwoorden.get(2));
        txtA3.setVisible(false);
        btnToonEerste.setDisable(true);
    }

    @FXML
    private void a1(ActionEvent event)
    {
        txtA1.setVisible(true);
        btnA1.setDisable(true);
        List<String> stukjes = puzzel.getStukjesVoorEersteAntwoord();
        String stuk1 = stukjes.get(0);
        String stuk2 = stukjes.get(1);
        String stuk3 = stukjes.get(2);
        String stuk4 = stukjes.get(3);
        if (speler != null)
        {
            goedGeantwoord();
        }
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk1))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk2))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk3))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk4))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
    }

    @FXML
    private void a2(ActionEvent event)
    {
        txtA2.setVisible(true);
        btnA2.setDisable(true);
        List<String> stukjes = puzzel.getStukjesVoorTweedeAntwoord();
        String stuk1 = stukjes.get(0);
        String stuk2 = stukjes.get(1);
        String stuk3 = stukjes.get(2);
        String stuk4 = stukjes.get(3);
        if (speler != null)
        {
            goedGeantwoord();
        }
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk1))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk2))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk3))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk4))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
    }

    @FXML
    private void a3(ActionEvent event)
    {
        txtA3.setVisible(true);
        btnA3.setDisable(true);
        List<String> stukjes = puzzel.getStukjesVoorDerdeAntwoord();
        String stuk1 = stukjes.get(0);
        String stuk2 = stukjes.get(1);
        String stuk3 = stukjes.get(2);
        String stuk4 = stukjes.get(3);
        if (speler != null)
        {
            goedGeantwoord();
        }
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk1))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk2))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk3))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
        txtLijst.stream().filter((t) -> (t.getText().equals(stuk4))).forEach((t)
                -> 
                {
                    t.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, USE_PREF_SIZE));
        });
    }

    @FXML
    private void volgendeVraag(ActionEvent event)
    {
        if (flag)
        {
            if (puzzelId == 1)
            {
                puzzelId = 2;
                puzzel = p2;
            } else if (puzzelId == 2)
            {
                puzzelId = 3;
                puzzel = p3;

            } else if (puzzelId == 3)
            {
                puzzelId = 4;
                puzzel = p4;
                flag = false;
            }
            List<String> lijst = puzzel.getStukjesRandom();
            List<String> antwoorden = puzzel.getAntwoorden();
            txtS1.setText(lijst.get(0));
            txtS2.setText(lijst.get(1));
            txtS3.setText(lijst.get(2));
            txtS4.setText(lijst.get(3));
            txtS5.setText(lijst.get(4));
            txtS6.setText(lijst.get(5));
            txtS7.setText(lijst.get(6));
            txtS8.setText(lijst.get(7));
            txtS9.setText(lijst.get(8));
            txtS10.setText(lijst.get(9));
            txtS11.setText(lijst.get(10));
            txtS12.setText(lijst.get(11));
            txtA1.setText(antwoorden.get(0));
            txtA1.setVisible(false);
            txtA2.setText(antwoorden.get(1));
            txtA2.setVisible(false);
            txtA3.setText(antwoorden.get(2));
            txtA3.setVisible(false);
            txtLijst.stream().forEach((t)
                    -> 
                    {
                        t.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
            });
            btnStop.setDisable(true);
            btnStart.setDisable(false);
            btnA1.setDisable(false);
            btnA2.setDisable(false);
            btnA3.setDisable(false);
            btnBieke.setDisable(false);
            btnBrian.setDisable(false);
            btnRobin.setDisable(false);
            btnMarianne.setDisable(false);
        }

    }

    @FXML
    private void volgendeRonde(ActionEvent event)
    {
        Stage stage = new Stage();
        Scene scene = new Scene(new RondeVierSchermController(dc));
        stage.setScene(scene);
        stage.setTitle("Foto Ronde");
        stage.show();
    }

    @FXML
    private void startTimer(ActionEvent event)
    {
        btnStart.setDisable(true);
        btnStop.setDisable(false);
        speler.timer();
    }

    @FXML
    private void stopTimer(ActionEvent event)
    {
        btnStart.setDisable(false);
        btnStop.setDisable(true);
        speler.stopTimer();
    }

    private void goedGeantwoord()
    {
        speler.stopTimer();
        this.speler.setScore(this.speler.getScore() + 25);
        speler.timer();
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
