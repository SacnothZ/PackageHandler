import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PackageHandlerApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/packagehandler.fxml"));
        stage.setTitle("CsomagKezelő");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
