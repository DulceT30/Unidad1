package Layout;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practica010_ListView_TresView extends Application {

    public static void main(String[] args) {
       launch  (args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView=new ListView<String>();
        ObservableList<String> elementos=FXCollections.observableArrayList();
        elementos.add("Manzana");
        elementos.add("Pera");
        elementos.add("Sandia");
        elementos.add("Melon");
        elementos.add("Aguacate");
        listView.setItems(elementos);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setOrientation(Orientation.HORIZONTAL);

        Button boton=new Button("Cuales estan seleccionados");
        boton.setOnAction(event -> {

            ObservableList<String> elementosSeleccionar=listView.getSelectionModel().getSelectedItems();

            System.out.println("Elementos seleccionados: ");

            for(String eSelected: elementosSeleccionar){
                System.out.println(eSelected);
            }

        });
        VBox layout=new VBox();
        layout.getChildren().add(listView);
        layout.getChildren().add(boton);
        Scene scene=new Scene(layout,150,50);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
