package teste;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
    
    public static void main(String[] args) throws Exception {

        launch(args);
      
    }

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/layout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        

        primaryStage.setTitle("Teste");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
}
