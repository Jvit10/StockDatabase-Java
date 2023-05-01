
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("DatabaseInterface.fxml"));
        primaryStage.setTitle("Stock Database");


        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //creates an empty file upon execution
       File dataFile = new File("data.txt");
       try {
           dataFile.createNewFile();
       }
       catch (IOException e) {
           System.out.println("Error creating file");
       }

        //launches GUI
        launch(args);
    }
}
