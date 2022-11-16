
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends javafx.application.Application {
    public static void main(String[] args) throws Exception {
        launch(args);    }

    @Override
    public void start(Stage arg0) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(App.class.getResource("/HomePage/Home.fxml")));
        arg0.setScene(scene);
        arg0.show();
    }
}
