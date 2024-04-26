import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class GuessTheNumberGame extends Application {

    private int randomNumber;
    private Label result;

    @Override
    public void start(Stage primaryStage) {
     
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; 

       
        Label game = new Label("Guess the Number Game");
        Label instruction = new Label("Enter a number between 1 and 100:");
        TextField guessText = new TextField();
        Button guessButt = new Button("Guess");
        result = new Label();

        
        guessButt.setOnAction(e -> {
            try {
                int guess = Integer.parseInt(guessText.getText());
                checkGuess(guess);
            } catch (NumberFormatException ex) {
                result.setText("Please enter a valid number.");
            }
        });

        
        VBox vbox = new VBox(10); 
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(game, instruction, guessText, guessButt, result);

        
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Guess the Number Game_Lumata");
        primaryStage.show();
    }

    private void checkGuess(int guess) {
        if (guess == randomNumber) {
            result.setText("Congratulations! You guessed the correct number: " + randomNumber);
        } else if (guess < randomNumber) {
            result.setText("Too low! Try again.");
        } else {
            result.setText("Too high! Try again.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
