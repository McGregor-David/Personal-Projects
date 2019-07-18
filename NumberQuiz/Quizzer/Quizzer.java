package numberQuiz;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

	public class Quizzer extends Application{
		
		Random randInts = new Random();
		double randNum1 = randInts.nextInt(12 - 1) + 1;
		double randNum2 = randInts.nextInt(12 - 1) + 1;
		double addSum = (randNum1 + randNum2);
		double subtractionSum = (randNum1 - randNum2);
		double multiSum = (randNum1 * randNum2);
		double divisionSum = divisionFunc(randNum1,randNum2);
		static int corrAnswers = 0;
		static int badAnswers = 0;
		
		
		//functions for inputed numbers
		//Maybe instead of this I can include 0 in the random number pool and just check for zero division.
		static double divisionFunc(double randNum1, double randNum2) {
			double truncNum =  randNum1 / randNum2;
			truncNum = Math.floor(truncNum * 100)/100;
			return truncNum;
		}
		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			//Button test = new Button();

			
			//Pane
			GridPane grid1 = new GridPane();
			grid1.setAlignment(Pos.CENTER);
			grid1.setHgap(10);
			grid1.setVgap(20);
			grid1.setPadding(new Insets(60, 60, 60, 60));
				
			
			//Scene
			Scene scene1 = new Scene(grid1);
			
			
			//Horizontal boxes
			HBox numbersBox = new HBox();
			HBox additionBox = new HBox();
			HBox subtractionBox = new HBox();
			HBox multiplicationBox = new HBox();
			HBox divisionBox = new HBox();
			HBox tryAgainBox = new HBox();
			HBox guessBox = new HBox();
				
			//set HBox padding
			numbersBox.setSpacing(10);
			additionBox.setSpacing(10);
			subtractionBox.setSpacing(10);
			multiplicationBox.setSpacing(10);
			divisionBox.setSpacing(10);
			tryAgainBox.setSpacing(40);
			guessBox.setSpacing(70);
			
			//Labels
			Label twoNumbers = new Label("The two random numbers selected are: " + randNum1 + " and " + randNum2);
			Label whatAddition = new Label("What is the addition of " + randNum1 + " and " + randNum2);
			Label whatSubtraction = new Label("What is the subtraction of " + randNum1 + " and " + randNum2);
			Label whatMultiplication = new Label("What is the multiplication of " + randNum1 + " and " + randNum2);
			Label whatDivision = new Label("What is the division of " + randNum1 + " and " + randNum2);
			Label correctAnswers = new Label("Correct Answers: ");
			Label wrongAnswers = new Label("Incorrect Answers: ");
			Label tryAgain = new Label("Would you like to try again with two different numbers? ");
			Label errorField = new Label("Please enter numbers only");
						
		
			//Text fields
			TextField fieldAddition = new TextField();
			TextField fieldSubtraction = new TextField();
			TextField fieldMultiplication = new TextField();
			TextField fieldDivision = new TextField();
			TextField fieldtryAgain = new TextField();
			
			//text field widths
			fieldAddition.setPrefWidth(100);
			fieldSubtraction.setPrefWidth(100);
			fieldMultiplication.setPrefWidth(100);
			fieldDivision.setPrefWidth(100);
			fieldtryAgain.setPrefWidth(15);
			errorField.setPadding(new Insets(0,0,0,100));
			
			//Buttons 
			Button goAgain = new Button("Reset");
			Button exitProg = new Button("Exit");
			Button checkBtn = new Button("Check");
				goAgain.setMinWidth(75);
				exitProg.setMinWidth(75);
				checkBtn.setMinWidth(75);
									
				
			//Add all labels and fields to their respective Hboxes, then add them to the scene
			numbersBox.getChildren().add(twoNumbers);
			grid1.add(numbersBox, 0, 0);
			
			additionBox.getChildren().addAll(whatAddition,fieldAddition);
			grid1.add(additionBox, 0, 1);
			
			subtractionBox.getChildren().addAll(whatSubtraction,fieldSubtraction);
			grid1.add(subtractionBox, 0, 2);
			
			multiplicationBox.getChildren().addAll(whatMultiplication,fieldMultiplication);
			grid1.add(multiplicationBox, 0, 3);
			
			divisionBox.getChildren().addAll(whatDivision,fieldDivision);
			grid1.add(divisionBox, 0, 4);
			
			tryAgainBox.getChildren().addAll(checkBtn,goAgain,exitProg);
			grid1.add(tryAgain,0,7);
			grid1.add(tryAgainBox, 0, 8);
			
			grid1.add(errorField, 0, 6);
			errorField.setVisible(false);
			
			guessBox.getChildren().addAll(correctAnswers,wrongAnswers);
			grid1.add(guessBox,0,5);
			
			//PrimaryStage
			primaryStage.sizeToScene();
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Math Quizzer 4000");
			
			//Show PrimaryStage
			primaryStage.show();
			
			
			//Action Handling
			//Handle reset Button action
			goAgain.setOnAction(e->{
				Quizzer app = new Quizzer();
				try {
					app.start(primaryStage);
				} catch(Exception e1){
					e1.printStackTrace();
				};
			});
		
			
			//Handle Exit button action
			exitProg.setOnAction(e->{
				Platform.exit();
			});
			
			//addition check button
			checkBtn.setOnAction(e->{
				try {					
					double tempAdd = Double.valueOf(fieldAddition.getText());
					double tempSub = Double.valueOf(fieldSubtraction.getText());
					double tempMulti = Double.valueOf(fieldMultiplication.getText());
					double tempDiv = Double.valueOf(fieldDivision.getText());
					errorField.setVisible(false);
					if(tempAdd == addSum) {
						if(fieldAddition.isDisabled()==false) {corrAnswers++;}
						fieldAddition.setDisable(true);
						fieldAddition.setStyle("-fx-control-inner-background: Green");					
					}
					else {
						fieldAddition.setStyle("-fx-control-inner-background: #FE7171");
						badAnswers++;
						}
					
					if(tempSub == subtractionSum) {
						if(fieldSubtraction.isDisabled()==false) {corrAnswers++;}
						fieldSubtraction.setDisable(true);
						fieldSubtraction.setStyle("-fx-control-inner-background: Green");
					}else {
						fieldSubtraction.setStyle("-fx-control-inner-background: #FE7171");
						badAnswers++;
						}
					
					if(tempMulti == multiSum) {
						if(fieldMultiplication.isDisabled()==false) {corrAnswers++;}
						fieldMultiplication.setDisable(true);
						fieldMultiplication.setStyle("-fx-control-inner-background: Green");
					}else {
						fieldMultiplication.setStyle("-fx-control-inner-background: #FE7171");
						badAnswers++;
						}
					
					if(tempDiv == divisionSum) {
						if(fieldDivision.isDisabled()==false) {corrAnswers++;}
						fieldDivision.setDisable(true);
						fieldDivision.setStyle("-fx-control-inner-background: Green");
					}else {
						fieldDivision.setStyle("-fx-control-inner-background: #FE7171");
						badAnswers++;
						}
					correctAnswers.setText("Correct Answers: " + corrAnswers);
					wrongAnswers.setText("Incorrect Answers: " + badAnswers);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					if(fieldAddition.isDisabled()==false) {fieldAddition.setStyle("-fx-control-inner-background: #FE7171");}
					if(fieldSubtraction.isDisabled()==false) {fieldSubtraction.setStyle("-fx-control-inner-background: #FE7171");}
					if(fieldMultiplication.isDisabled()==false) {fieldMultiplication.setStyle("-fx-control-inner-background: #FE7171");}
					if(fieldDivision.isDisabled()==false) {fieldDivision.setStyle("-fx-control-inner-background: #FE7171");}
					errorField.setTextFill(Color.web("#ff0000", 0.8));
					errorField.setVisible(true);
				}			
			
			});
		}
	
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			launch();
			
		}	
	}