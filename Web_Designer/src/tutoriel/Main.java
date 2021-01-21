package tutoriel;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class Main extends Application {
 
    @Override
    public void start(final Stage stage) {
 
        Button buttonURL = new Button("Load Page https://eclipse.org");
        Button buttonHtmlString = new Button("Load HTML String");
        Button buttonHtmlFile = new Button("Load local HTML File");
        Button buttonHtmlJSFile = new Button("Load local HTML-JS");
        
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
 
        buttonURL.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                String url = "https://eclipse.org";
                // Load a page from remote url.
                webEngine.load(url);
            }
        });
 
        buttonHtmlString.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";
                // Load HTML String
                webEngine.loadContent(html);
            }
        });

         buttonHtmlFile.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                try {
                    File file = new File("./deps/Website_example/structure.html");
                    URL url = file.toURI().toURL();
                    System.out.println("Local URL: " + url.toString());
                    webEngine.load(url.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
 
            }
        });
         
         buttonHtmlJSFile.setOnAction(new EventHandler<ActionEvent>() {
        	 
             @Override
             public void handle(ActionEvent event) {
                 try {
                     File file = new File("./deps/Animation_example/canvasf.html");
                     URL url = file.toURI().toURL();
                     System.out.println("Local URL: " + url.toString());
                     webEngine.load(url.toString());
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 }
  
             }
         });
 
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().addAll(buttonURL, buttonHtmlString,buttonHtmlFile, buttonHtmlJSFile, browser);
 
        Scene scene = new Scene(root);
 
        stage.setTitle("JavaFX WebView (o7planning.org)");
        stage.setScene(scene);
        stage.setWidth(450);
        stage.setHeight(300);
 
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}
