package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.PrintStream;


public class GridPaneExample extends Application{

    private PrintStream printStream = new PrintStream("students.txt");

    public GridPaneExample() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws  Exception{
        Text text1 = new Text("FIRSTNAME");

        Text text2 = new Text("LASTNAME");

        Text text3 = new Text("EMAIL");

        TextField textField1 = new TextField();

        TextField textField2 = new TextField();

        TextField textField3 = new TextField();

        //Creating Buttons
        Button button1 = new Button("Submit");
        Button button2 = new Button("Clear");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);

        //Creating a scene object
        Scene scene = new Scene(gridPane);

        //Setting title to the Stage
        stage.setTitle("Grid Pane-LABOR13-2");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String firstname = text1.getText();
                String lastname = text2.getText();
                String email = text3.getText();
                Student student =  new Student(firstname, lastname, email);
                printStream.println(student);
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
    }
}
