package dotsandboxes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/** Our main class that launches the app. */
public class Main extends Application {

    DotsAndBoxesGrid grid = new DotsAndBoxesGrid(15, 8, 2);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Dots and Boxes");

        Label label = new Label("My label");

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(label);
        Scene scene = new Scene(borderPane, 600, 400);

        DotsAndBoxesUI dbUi = new DotsAndBoxesUI(grid);
        borderPane.setCenter(dbUi.anchorPane);
        borderPane.setTop(dbUi.label);

        primaryStage.setScene(scene);

        primaryStage.show();

        // This sets what to do when we close the main window.
        // Notice that we are using a "lambda function" (i.e., an anonymously defined function defined within the
        // call to setOnCloseRequest). These are very useful in GUI code and we'll probably see a lot of them in the
        // project.
        primaryStage.setOnCloseRequest((evt) -> System.exit(0));
    }

}
