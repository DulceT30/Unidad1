package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Practica004_FlowPane extends Application {
    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Button boton1=new Button("Bonton 1");
        Button boton2=new Button("Bonton 2");
        Button boton3=new Button("Bonton 3");
        Button boton4=new Button("Bonton 4");
        Button boton5=new Button("Bonton 5");

        FlowPane layout=new FlowPane(Orientation.VERTICAL);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(10));
        layout.setVgap(20);//espacio vertical
        layout.setHgap(10);//espacio horizontal
        layout.getChildren().addAll(boton1,boton2,boton3,boton4,boton5);

        Scene escena=new Scene(layout,400,400);

        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
