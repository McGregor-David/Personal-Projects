package ATM_;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

	//import javafx.scene.layout.StackPane;

			public class AtmLoggedIn extends Application{
			
			
			@Override
			public void start(Stage primaryStage) throws Exception {
				// TODO Auto-generated method stub
				//Button test = new Button();
						
				//Pane
				GridPane grid1 = new GridPane();	
				grid1.setAlignment(Pos.CENTER);
				grid1.setHgap(10);
				grid1.setVgap(10);
				grid1.setPadding(new Insets(25, 25, 25, 25));
				
				//Scene
				Scene scene1 = new Scene(grid1);
				
				
				//Labels
				VBox welcomeLabels = new VBox();
				welcomeLabels.setSpacing(10);
				
				
				Label helloAcc = new Label("Welcome Account ");
					welcomeLabels.getChildren().add(helloAcc);
					
				Label whatToDo = new Label("What would you like to do? ");
					welcomeLabels.getChildren().add(whatToDo);
					welcomeLabels.setAlignment(Pos.CENTER);
				grid1.getChildren().addAll(welcomeLabels);
							
				//Buttons
					VBox HBbuttons = new VBox();
					Button CheckBalButton = new Button("Check Balance");
					Button WithdrawButton = new Button("Withdraw Money");
					Button DepositButton = new Button("Deposit Money");
					Button ExitButton = new Button("Exit");
						CheckBalButton.setMinWidth(100);
						WithdrawButton.setMinWidth(100);
						DepositButton.setMinWidth(100);
						ExitButton.setMinWidth(100);
				
				HBbuttons.setAlignment(Pos.CENTER);
				HBbuttons.setSpacing(10);
				HBbuttons.getChildren().addAll(CheckBalButton,WithdrawButton,DepositButton,ExitButton);
				grid1.add(HBbuttons, 0, 4);
				
				
				//PrimaryStage
				//primaryStage.setResizable(false);
				primaryStage.setScene(scene1);
				primaryStage.setTitle("Welcome to David's ATM");
				
				//Show PrimaryStage
				primaryStage.show();
				
			}
			
			
			public static void main() {
				// TODO Auto-generated method stub
				
				launch();
			}	
		}

