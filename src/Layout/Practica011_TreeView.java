package Layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practica011_TreeView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TreeItem<String> raiz, rama1, rama2;
        raiz=new TreeItem<String>("Alimentos");//nodo principal
        raiz.setExpanded(true);


        rama1=crearHijo("Vegetales",raiz);
        rama2= crearHijo("Carnes", raiz);

        crearHijo("Cebolla",rama1);
        crearHijo("Papa",rama1);

        crearHijo("Res",rama2);
        crearHijo("Pavo",rama2);

        TreeView treeView=new TreeView(raiz);
        treeView.setShowRoot(true);

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(newValue);
            }
        });

        VBox layout= new VBox();
        layout.getChildren().add(treeView);

        Scene scene=new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TreeItem<String> crearHijo(String titulo, TreeItem padre){
        TreeItem<String> hijo=new TreeItem<>(titulo);
        hijo.setExpanded(true);//para expander las opciones
        padre.getChildren().add(hijo);
        return hijo;
    }
}
