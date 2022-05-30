import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Main extends Application {

    
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Método que inicializa o controller após o arquivo fxml ter sido carregado
     */
     
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
        Parent root = loader.load();
        Scene tela = new Scene(root);

        tela.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setTitle("Historia");
        primaryStage.setScene(tela);
        primaryStage.show();
    }

}
