package ATM_;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

	//import javafx.scene.layout.StackPane;

	public class AtmSignIn extends Application{
				
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
			
			HBox accountBox = new HBox();
			HBox passwordBox = new HBox();
			
			Label accountNumberVer = new Label("Please enter an account number: ");
			TextField accNameField = new TextField();
			accNameField.setPrefWidth(200);
				accountBox.getChildren().addAll(accountNumberVer, accNameField);
				accountBox.setSpacing(10);
				grid1.add(accountBox, 0, 0);
			
			
			Label passwordVer = new Label("Please enter your PIN number: ");
			PasswordField passwordVerField = new PasswordField();
			passwordVerField.setPrefWidth(60);
				passwordBox.getChildren().addAll(passwordVer, passwordVerField);
				passwordBox.setSpacing(22);
				grid1.add(passwordBox, 0, 1);
			
		    Label actiontarget = new Label();	
			
		        
		    
			//Buttons
			HBox HBbuttons = new HBox();
				Button submitButton = new Button("Submit");
					submitButton.setMinWidth(100);
			HBbuttons.getChildren().addAll(submitButton,actiontarget);
			HBbuttons.setSpacing(70);
			grid1.add(HBbuttons, 0, 4);
			
//			boolean[] loginSuccess = {false}; // must be an array to Resolve Local Variable Defined in an Enclosing Scope Must be Final or Effectively Final Error 
//			
//			while(loginSuccess[0] = false) {
//				
//			submitButton.setOnAction(e -> {
//		            int accNum = Integer.parseInt(accNameField.getText());
//		            int password = Integer.parseInt(passwordVerField.getText());
//		            loginSuccess[0] = FileUtilities.accountVerifier(accNum, password);	
//		        });
//				if(loginSuccess[0] = false) {System.out.println("Sorry, either your pin or account information is incorrect");}
//			}
			
			 
		    submitButton.setOnAction(new EventHandler<ActionEvent>() {
		    	 
		        @Override
		        public void handle(ActionEvent e) {
		        	if(accNameField.getText() == "" && passwordVerField.getText() == "") {	        	
		        		actiontarget.setText("Acccount number and password is required");
		        		actiontarget.setTextFill(Color.RED);
		        	
		        	}
		        	int accNum = Integer.parseInt(accNameField.getText());
		            int password = Integer.parseInt(passwordVerField.getText());
		            boolean loginSuccess = FileUtilities.accountVerifier(accNum, password);
		            if(loginSuccess == false) {
		            	actiontarget.setText("Password or account number is incorrect");
		        		actiontarget.setTextFill(Color.RED);
		            }
		        }
		    });
			
			//PrimaryStage
			//primaryStage.setResizable(false);
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Welcome to David's ATM");
			
			//Show PrimaryStage
			primaryStage.show();
			
		}
		
				
		public static void main(File file) {
			// TODO Auto-generated method stub
			
			launch();
			
		}	
	}