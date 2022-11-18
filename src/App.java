<<<<<<< HEAD
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/login/Login.fxml")));
        stage.setScene(scene);
        stage.show();    

=======
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
>>>>>>> 252eca7b14b043d655c139fa6dedbd0cb49899b6
    }
}
