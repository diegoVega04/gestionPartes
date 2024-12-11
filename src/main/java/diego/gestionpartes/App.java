package diego.gestionpartes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class    App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/listaPartes.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/listaAlumnos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 990, 630);
        stage.setTitle("PRUEBA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}