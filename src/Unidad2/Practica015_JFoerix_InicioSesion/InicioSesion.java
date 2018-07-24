package Unidad2.Practica015_JFoerix_InicioSesion;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;


public class InicioSesion extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Genius Coder: Inicio De Sesion");
        primaryStage.show();
    }


    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXPasswordField clave;

    @FXML
    void iniciarSesion(ActionEvent event){

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:basedatos1.db");

            Statement statement=connection.createStatement();
            statement.setQueryTimeout(30);

            String correo=usuario.getText();
            String clav=clave.getText();
            String consulta= "SELECT * FROM usuarios WHERE correo='"+correo+"' AND clave='"+clav+"'";

            ResultSet rs=statement.executeQuery(consulta);
            if (rs.next()) {

                System.out.println("Usuario Valido");
                System.out.println(rs.getString("nombre"));
            }
            else {
                System.out.println("Usuario NO valido");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Usuario: "+usuario.getText());
     System.out.println("Clave: "+clave.getText());
    }
}