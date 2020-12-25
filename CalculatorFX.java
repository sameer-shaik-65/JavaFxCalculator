package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 
public class CalculatorFX extends Application {
     
    TextField number1;
    TextField number2;
    Button Division;
    Button Multiplication;
    Button Addition;
    Button Subtraction;
    Button btnClear;
    Button btnEqual;
    Label Result;
    Label lblnum1;
    Label lblnum2;
     
    @Override
    public void start(Stage primaryStage) {
         
        number1 = new TextField();
        number2 = new TextField();
        Division = new Button("divide");
        Multiplication = new Button("multiply");
        Addition = new Button("add");
        Subtraction = new Button("substraction");
        btnClear = new Button("Clear");
        btnEqual= new Button(" Result is ");
        Result = new Label("");
        lblnum1 = new Label ("Enter first num:"); 
        lblnum2 = new Label("Enter second num:"); 
         
        Result.setAlignment(Pos.CENTER);
        Result.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
         
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
         
        root.setHgap(15);
        root.setVgap(15);
         
        root.add(Division, 2, 1);
        root.add(Multiplication, 3, 1);
        root.add(Addition, 0, 1);
        root.add(Subtraction, 1, 1);
        root.add(btnEqual, 1, 3, 2, 1);
        root.add(btnClear, 1, 5, 2, 1);
         
        root.add(number1, 1, 0);
        root.add(number2, 1, 2);
        root.add(Result, 1, 4, 2, 1);
        root.add(lblnum1, 0,0);
        root.add(lblnum2, 0,2);
         
        setWidths();
        attachCode();
         
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    private void setWidths() {
        number1.setPrefWidth(150);
        number2.setPrefWidth(150);
        Division.setPrefWidth(150);
        Multiplication.setPrefWidth(150);
        Addition.setPrefWidth(150);
        Subtraction.setPrefWidth(150);
        btnEqual.setPrefWidth(150);
        btnClear.setPrefWidth(150);
        Result.setPrefWidth(250);
        lblnum1.setPrefWidth(150);
        lblnum2.setPrefWidth(150);
    }
 
    public void attachCode() {
    	
        //have each button run BTNCODE when clicked
    	
        Addition.setOnAction(e -> btncode(e));
        Subtraction.setOnAction(e -> btncode(e));
        Multiplication.setOnAction(e -> btncode(e));
        Division.setOnAction(e -> btncode(e));
        btnClear.setOnAction(e -> btncode(e));
          btnEqual.setOnAction(e-> btncode(e));
    }
 
    public void btncode(ActionEvent e) {
        int num1, num2, answer;
        char symbol;
        
        //e tells us which button was clicked
        
        if (e.getSource() == btnClear) {
            number1.setText("");
            number2.setText("");
            Result.setText("?");
            number1.requestFocus();
            return;
        }
        
        //read numbers in from textfields
        
        num1 = Integer.parseInt(number1.getText());
        num2 = Integer.parseInt(number2.getText());
        if (e.getSource() == Addition) {
            symbol = '+';
            answer = num1 + num2;
        } else if (e.getSource() == Subtraction) {
            symbol = '-';
            answer = num1 - num2;
        } else if (e.getSource() == Multiplication) {
            symbol = 'x';
            answer = num1 * num2;
        } else {
            symbol = '/';
            answer = num1 / num2;
        }
        //display answer
        Result.setText("" + num1 + symbol + num2 + "=" + answer);
    }
     
    public static void main(String[] args) {
        launch(args);
    }
}