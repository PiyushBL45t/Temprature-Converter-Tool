package com.internshala.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class MyMain extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Init");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout_2.fxml"));
        VBox rootNode = loader.load();

        MenuBar menubar = createMenu();
        rootNode.getChildren().add(0,menubar); // adding it to the actual menubar

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool ");
        primaryStage.show();

    }

    private MenuBar createMenu(){

        // file menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> System.out.println("Clicked!!!"));


        SeparatorMenuItem seprator = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(event -> {Platform.exit();
        System.exit(0);});


        fileMenu.getItems().addAll(newMenuItem, seprator,quitMenuItem);

        //help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutitem = new MenuItem("About");

        aboutitem.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll(aboutitem);


        // Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About");
        alertDialog.setHeaderText("App info");
        alertDialog.setContentText("This is a temperature converter tool that converts temperature from degree Celsius to degree Fahrenheit and vice versa.");

        ButtonType yesButton = new ButtonType("Ok");

        alertDialog.getButtonTypes().setAll(yesButton);

        Optional<ButtonType> clickedButton = alertDialog.showAndWait();

        alertDialog.show();
        }


    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }
}
