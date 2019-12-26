package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class Arithmetic extends Application {
    Group root = new Group();
    final private int WIDTH = 700;
    final private int HEIGHT = 200;
    VBox strings = new VBox();
    HBox numbers = new HBox();
    HBox action = new HBox();
    HBox result = new HBox();
    TextField x = new TextField();
    TextField y = new TextField();
    private ArrayList<String> actions = new ArrayList<>();
    ComboBox<String> actionBox = new ComboBox<>();
    Text calcualtionResult = new Text();
    Button calculate = new Button("Calculate");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        actions.add("+");
        actions.add("-");
        actions.add("*");
        actions.add("/");
        actions.add("%");
        actions.add("==");
        actions.add("<");
        actions.add(">");
        actionBox.getItems().addAll(actions);

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (x==null||y==null||actionBox==null) {
                    calcualtionResult.setText("Some value is missing");
                }
                else {
                String selectedAction = actionBox.getValue();
                try {
                    Double xValue = Double.parseDouble(x.getText());
                    Double yValue = Double.parseDouble(y.getText());
                    switch (selectedAction) {
                        case "+":
                            calcualtionResult.setText(MathOps.addition(xValue, yValue)); break;
                        case "-":
                            calcualtionResult.setText(MathOps.substraction(xValue, yValue)); break;
                        case "*":
                            calcualtionResult.setText(MathOps.multiplication(xValue, yValue)); break;
                        case "/":
                            calcualtionResult.setText(MathOps.division(xValue, yValue)); break;
                        case "%":
                            calcualtionResult.setText(MathOps.reminder(xValue, yValue)); break;
                        case "==":
                            calcualtionResult.setText(MathOps.equality(xValue, yValue)); break;
                        case ">":
                            calcualtionResult.setText(MathOps.moreThan(xValue, yValue)); break;
                        case "<":
                            calcualtionResult.setText(MathOps.lessThan(xValue, yValue)); break;
                        default:
                            System.out.println("Invalid input"); break;
                    }
                    x.clear(); y.clear();
                }
                catch (NumberFormatException ee) {
                        calcualtionResult.setText("Number Format exception." );
                    }

            }}
        });

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Arithmetics");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.getChildren().add(strings);
        strings.setPadding(new Insets(30, 30, 10, 30));
        strings.setSpacing(20);
        strings.getChildren().add(new Text("Arithmetics operations. Enter two numbers"));
        strings.getChildren().add(numbers);
        numbers.setSpacing(10);
        numbers.getChildren().add(new Text("First number x: "));
        numbers.getChildren().add(x);
        numbers.getChildren().add(new Text("Second number y: "));
        numbers.getChildren().add(y);
        strings.getChildren().add(action);
        action.setSpacing(30);
        action.getChildren().add(new Text("Select Action (x ? y) :"));
        action.getChildren().add(actionBox);
        action.getChildren().add(calculate);
        strings.getChildren().add(result);
        result.getChildren().add(calcualtionResult);

    }
}
