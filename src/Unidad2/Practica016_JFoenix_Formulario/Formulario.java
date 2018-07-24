package Unidad2.Practica016_JFoenix_Formulario;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Formulario extends Application {

    @FXML
    private AnchorPane paneMapa;

    @FXML
    private ImageView bUsuraio;

    @FXML
    private ImageView bMapa;

    @FXML
    private ImageView bEscuela;

    @FXML
    private ImageView bSalir;

    @FXML
    private AnchorPane paneUsuario;

    @FXML
    private ImageView upUsuario;

    @FXML
    private ImageView upEscuela;

    @FXML
    private ImageView upMapa;

    @FXML
    private AnchorPane paneEscuela;

    @FXML
    void mostrarEscuela(MouseEvent event) {
        mostrarPane("Escuela");
    }

    @FXML
    void mostrarMapa(MouseEvent event) {
        mostrarPane("Mapa");
    }

    @FXML
    void mostrarUsuario(MouseEvent event) {
        mostrarPane("Usuario");
    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();
    }

    private void mostrarPane(String pane){

        switch (pane){
            case "Usuario":
                if(paneUsuario.isVisible()){
                paneUsuario.setVisible(false);
                    upUsuario.setVisible(false);
                    return;
            }
            break;
            case "Escuela":
                if(paneEscuela.isVisible()){
                    paneEscuela.setVisible(false);
                    upEscuela.setVisible(false);
                    return;
                }
                break;
            case "Mapa":
                if(paneMapa.isVisible()){
                    paneMapa.setVisible(false);
                    upMapa.setVisible(false);
                    return;
                }
                break;
        }

        paneUsuario.setVisible(false);
        paneMapa.setVisible(false);
        paneEscuela.setVisible(false);
        upUsuario.setVisible(false);
        upEscuela.setVisible(false);
        upMapa.setVisible(false);

        switch (pane){
            case "Usuario":
                paneUsuario.setVisible(true);
                upUsuario.setVisible(true);
                break;
            case "Mapa":
                paneMapa.setVisible(true);
                upMapa.setVisible(true);
                break;
            case "Escuela":
                paneEscuela.setVisible(true);
                upEscuela.setVisible(true);
                break;
        }
    }
    private  double posX, posY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout=FXMLLoader.load(getClass().getResource("Formulario.fxml"));

        layout.setOnMousePressed(event -> {
            posX= primaryStage.getX()- event.getX();
            posY=primaryStage.getY()-event.getY();
            //System.out.println(posX+","+ posY);
            //System.out.println(primaryStage.getX()+","+ primaryStage.);
        });

        layout.setOnMouseDragged(event ->{
            primaryStage.setX(event.getX()+posX);
            primaryStage.setY(event.getY()+posX);
        } );

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene=new Scene(layout);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
