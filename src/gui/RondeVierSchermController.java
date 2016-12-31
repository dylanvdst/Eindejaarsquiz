/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.Speler;
import domein.Vraag;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class RondeVierSchermController extends GridPane
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
    private TextArea txtAntwoord1;
    @FXML
    private TextArea txtAntwoord3;
    @FXML
    private TextArea txtAntwoord4;
    @FXML
    private TextArea txtAntwoord2;
    @FXML
    private Button btnA1;
    @FXML
    private Button btnA2;
    @FXML
    private Button btnA3;
    @FXML
    private Button btnA4;
    @FXML
    private Button btnVolgendeVraag;
    @FXML
    private Button btnVolgendeRonde;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
    @FXML
    private ImageView ivImageView;
    private DomeinController dc;
    private Speler speler;
    private List<Vraag> vragen;
    private int vraagNr;
    private Vraag vraag;

    public RondeVierSchermController(DomeinController dc)
    {
        this.dc = dc;
        vragen = dc.getVragenRonde4();
        vraagNr = 0;
        vraag = vragen.get(vraagNr);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RondeVierScherm.fxml"));
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
            btnStop.setDisable(true);
        } catch (IOException ex)
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
        this.speler = this.dc.getSpeler("Bieke");
    }

    @FXML
    private void selectBrian(ActionEvent event)
    {
        txtBrian.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = this.dc.getSpeler("Brian");
    }

    @FXML
    private void selectMarianne(ActionEvent event)
    {
        txtMarianne.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtRobin.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = this.dc.getSpeler("Marianne");
    }

    @FXML
    private void selectRobin(ActionEvent event)
    {
        txtRobin.setFont(Font.font("Verdana", FontWeight.BOLD, USE_PREF_SIZE));
        txtBieke.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtBrian.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        txtMarianne.setFont(Font.font("Verdana", FontWeight.NORMAL, USE_PREF_SIZE));
        this.speler = this.dc.getSpeler("Robin");
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
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(vraag.getText()));
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            ivImageView.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger("FOUT");
        }

        ivImageView.setVisible(true);
        txtAntwoord1.setText(vraag.getAntwoord().get(0));
        txtAntwoord1.setVisible(false);
        txtAntwoord2.setText(vraag.getAntwoord().get(1));
        txtAntwoord2.setVisible(false);
        txtAntwoord3.setText(vraag.getAntwoord().get(2));
        txtAntwoord3.setVisible(false);
        txtAntwoord4.setText(vraag.getAntwoord().get(3));
        txtAntwoord4.setVisible(false);
        btnToonEerste.setDisable(true);
    }

    @FXML
    private void a1(ActionEvent event)
    {
        txtAntwoord1.setVisible(true);
        btnA1.setDisable(true);
        if (speler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void a2(ActionEvent event)
    {
        txtAntwoord2.setVisible(true);
        btnA2.setDisable(true);
        if (speler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void a3(ActionEvent event)
    {
        txtAntwoord3.setVisible(true);
        btnA3.setDisable(true);
        if (speler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void a4(ActionEvent event)
    {
        txtAntwoord4.setVisible(true);
        btnA4.setDisable(true);
        if (speler != null)
        {
            goedGeantwoord();
        }
    }

    @FXML
    private void volgendeVraag(ActionEvent event)
    {
        vraagNr++;
        if (vraagNr < vragen.size())
        {
            vraag = vragen.get(vraagNr);
            try {
                BufferedImage bufferedImage = ImageIO.read(new File(vraag.getText()));
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                ivImageView.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger("FOUT");
            }
            txtAntwoord1.setText(vraag.getAntwoord().get(0));
            txtAntwoord1.setVisible(false);
            txtAntwoord2.setText(vraag.getAntwoord().get(1));
            txtAntwoord2.setVisible(false);
            txtAntwoord3.setText(vraag.getAntwoord().get(2));
            txtAntwoord3.setVisible(false);
            txtAntwoord4.setText(vraag.getAntwoord().get(3));
            txtAntwoord4.setVisible(false);
            btnStop.setDisable(true);
            btnStart.setDisable(false);
            btnA1.setDisable(false);
            btnA2.setDisable(false);
            btnA3.setDisable(false);
            btnA4.setDisable(false);
        } else if (vraagNr >= vragen.size())
        {
            btnVolgendeVraag.setDisable(true);
        }
    }

    @FXML
    private void volgendeRonde(ActionEvent event)
    {
    }

    @FXML
    private void startTimer(ActionEvent event)
    {
        btnStart.setDisable(true);
        btnStop.setDisable(false);
        speler.timer();
        if (speler.getName().equals("Bieke"))
        {
            txtBiekeScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Brian"))
        {
            txtBrianScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Marianne"))
        {
            txtMarianneScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Robin"))
        {
            txtRobinScore.setText(Integer.toString(speler.getScore()));
        }
    }

    @FXML
    private void stopTimer(ActionEvent event)
    {
        btnStart.setDisable(false);
        btnStop.setDisable(true);
        speler.stopTimer();
        if (speler.getName().equals("Bieke"))
        {
            txtBiekeScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Brian"))
        {
            txtBrianScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Marianne"))
        {
            txtMarianneScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Robin"))
        {
            txtRobinScore.setText(Integer.toString(speler.getScore()));
        }
    }

    private void goedGeantwoord()
    {
        speler.stopTimer();
        this.speler.setScore(this.speler.getScore() + 20);
        if (speler.getName().equals("Bieke"))
        {
            txtBiekeScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Brian"))
        {
            txtBrianScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Marianne"))
        {
            txtMarianneScore.setText(Integer.toString(speler.getScore()));
        } else if (speler.getName().equals("Robin"))
        {
            txtRobinScore.setText(Integer.toString(speler.getScore()));
        }
        speler.timer();
    }
    
}
