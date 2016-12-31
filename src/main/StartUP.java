/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domein.DomeinController;
import gui.BeginschermController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dylan
 */

public class StartUP extends Application
{
    
    
    @Override
    public void start(Stage primaryStage)
    {
        DomeinController dc = new DomeinController();
        
        Scene scene = new Scene(new BeginschermController(dc));
        primaryStage.setScene(scene);
        primaryStage.setTitle("EindejaarsQuiz!");
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
