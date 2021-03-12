package t4ouf;

import java.io.File;
import java.io.IOException;
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
import javafx.concurrent.Worker.State;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import dataStructures.Palet;
import parser.CSSFile;
import parser.CSSParser;
import parser.XMLParser;

@SuppressWarnings("restriction")
public class Main extends Application {

	@Override
	public void start(final Stage stage) throws Exception {

		Button buttonURL = new Button("Load Page https://eclipse.org");
		Button buttonHtmlString = new Button("Load HTML String");
		
		Button buttonHtmlFile1 = new Button("Load local website with style 1");
		Button buttonHtmlFile2 = new Button("Load local website with style 2");
				
		Button buttonHtmlJSFile = new Button("Load local HTML-JS");

		final WebView browser = new WebView();
		final WebEngine webEngine = browser.getEngine();

		File file = new File("./deps/Website_example/structure.html");
		URL url = file.toURI().toURL();
		webEngine.load(url.toString());
		
		buttonURL.setOnAction(new EventHandler < ActionEvent > () {

			@Override
			public void handle(ActionEvent event) {
				String url = "https://eclipse.org";
				// Load a page from remote url.
				webEngine.load(url);
			}
		});

		buttonHtmlString.setOnAction(new EventHandler < ActionEvent > () {

			@Override
			public void handle(ActionEvent event) {
                String html = "<html><h1>Hello 1</h1><h2 id=\"titreH2\">Hello 2</h2></html>";
                // Load HTML String
                webEngine.loadContent(html);

                //Parse the HTML content with Jsoup
                Document doc = Jsoup.parse(html);
                Element h2 = doc.getElementById("titreH2");
                System.out.println(h2.toString());

            }
		});

		buttonHtmlFile1.setOnAction(new EventHandler < ActionEvent > () {

			@Override
			public void handle(ActionEvent event) {
				try {
					
					File file = new File("./deps/Website_example/structure.html");
					URL url = file.toURI().toURL();
					
					XMLParser parser = new XMLParser();
					Palet p = parser.ParseXMLPalet("./deps/Website_example/palet1.xml");
					
					CSSFile css = new CSSFile("./deps/Website_example/structure.css");
					
					css.addProperties(".Prim1", "background-color:"+p.colorMain1);
					css.addProperties(".PrimVar1", "background-color:"+p.color1Var1);
					css.addProperties(".PrimVar2", "background-color:"+p.color1Var2);
					
					CSSParser.writeToFile(css, "./deps/Website_example/structure.css");
				
					
					//temp solution : https://stackoverflow.com/questions/16211920/javafx-webview-webengine-cache-external-javascript
					System.out.println("Local URL: " + url.toString());
					System.out.println(webEngine.getLoadWorker().stateProperty());
					if( webEngine.getLoadWorker().stateProperty().get().compareTo(State.SUCCEEDED) == 0 ) {
						webEngine.setJavaScriptEnabled(true);
						webEngine.executeScript("location.reload(true);");
						webEngine.load(url.toString());
						browser.getEngine().reload();
					}
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

		buttonHtmlFile2.setOnAction(new EventHandler < ActionEvent > () {

			@Override
			public void handle(ActionEvent event) {
				try {
					File file = new File("./deps/Website_example/structure.html");
					URL url = file.toURI().toURL();
					
					XMLParser parser = new XMLParser();
					Palet p = parser.ParseXMLPalet("./deps/Website_example/palet1.xml");
					
					CSSFile css = new CSSFile("./deps/Website_example/structure.css");
					
					css.addProperties(".Prim1", "background-color:"+p.colorMain3);
					css.addProperties(".PrimVar1", "background-color:"+p.color3Var1);
					css.addProperties(".PrimVar2", "background-color:"+p.color3Var2);
					
					CSSParser.writeToFile(css, "./deps/Website_example/structure.css");
					
					System.out.println("Local URL: " + url.toString());
					System.out.println(webEngine.getLoadWorker().stateProperty());
					if( webEngine.getLoadWorker().stateProperty().get().compareTo(State.SUCCEEDED) == 0 ) {
						webEngine.setJavaScriptEnabled(true);
						webEngine.executeScript("location.reload(true);");
						webEngine.load(url.toString());		
						browser.getEngine().reload();
					}
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		
		buttonHtmlJSFile.setOnAction(new EventHandler < ActionEvent > () {

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
		root.getChildren().addAll(buttonURL, buttonHtmlString, buttonHtmlJSFile, buttonHtmlFile1, buttonHtmlFile2, browser);

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