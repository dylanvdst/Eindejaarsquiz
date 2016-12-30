/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import domein.DomeinController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class BeginschermController extends StackPane
{

    @FXML
    private Button btnBegin;

    private DomeinController domeinController;
    
    public BeginschermController(DomeinController domeinController)
    {
        this.domeinController = domeinController;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Beginscherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
      

    @FXML
    private void beginQuiz(ActionEvent event)
    {
        domeinController.maakSpelers();
        Stage stage = new Stage();
        Scene scene = new Scene(new RondeEenSchermController(domeinController));
        stage.setScene(scene);
        stage.setTitle("Snelle Vragen Ronde");
        stage.show();
        
    }
    
}
