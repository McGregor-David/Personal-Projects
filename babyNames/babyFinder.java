package babyNames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


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
import javafx.scene.layout.VBox;

	public class babyFinder extends Application{
		
		private static final int YEARLIMIT = 4;
		private static final int GENDERLIMIT = 1;
		private static final int NAMELIMIT = 30;
		Label actiontarget = null;
		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			//Button test = new Button();

			
			//Pane
			GridPane grid1 = new GridPane();	
			grid1.setAlignment(Pos.CENTER);
			grid1.setHgap(10);
			grid1.setVgap(10);
			grid1.setPadding(new Insets(60, 60, 60, 60));
						
			//Scene
			Scene scene1 = new Scene(grid1);
			
			
			
			//Vertical boxes
			HBox yearBox = new HBox();
			HBox genderBox = new HBox();
			HBox nameBox = new HBox();
			HBox ActionTargetBox = new HBox();
			HBox HBbuttons = new HBox();
		
				
			//set VBox padding
			yearBox.setSpacing(10);
			genderBox.setSpacing(10);
			nameBox.setSpacing(10);
			
			//Labels
			Label enterYear = new Label("Enter the year: ");
			Label enterGender = new Label("Enter the gender: ");
			Label enterName = new Label("Enter the Name: ");

			
			//Text fields
			TextField yearField = new TextField();
			TextField GenderField = new TextField();
			TextField NameField = new TextField();
			
			//text field widths
			yearField.setPrefWidth(100);
			NameField.setPrefWidth(100);
			GenderField.setPrefWidth(40);
			
			//Adding year label and text field to yearBox HBox
			yearBox.getChildren().addAll(enterYear, yearField);
			grid1.add(yearBox, 0, 0);
			
			//Adding gender label and text field to genderBox HBox
			genderBox.getChildren().addAll(enterGender,GenderField);
			grid1.add(genderBox, 0, 1);
			
			//Adding Name label and text field to nameBox HBox
			nameBox.getChildren().addAll(enterName,NameField);
			grid1.add(nameBox, 0, 2);
			
			ActionTargetBox.setMinWidth(275);
				
			
			//Buttons
			Button submitButton = new Button("Submit");
			Button exitButton = new Button("Exit");
				submitButton.setMinWidth(75);
				exitButton.setMinWidth(75);
			
			HBbuttons.getChildren().addAll(submitButton,exitButton);
			HBbuttons.setSpacing(70);
			grid1.add(HBbuttons, 0, 6);
			
			
			//Exit button function
			exitButton.setOnAction(e -> {
				Platform.exit();
	        });

			
			//Submit button function, searches the baby name files
			submitButton.setOnAction(e -> {
				
				ActionTargetBox.getChildren().remove(actiontarget);
				ActionTargetBox.getChildren().clear();
				
				
				//in case of no entry
				String valueForName = null;
				Integer valueForYear = null;
				String valueForGender = null;
				try {
					valueForName = String.valueOf(NameField.getText());
					valueForYear = Integer.valueOf(yearField.getText());
					valueForGender = String.valueOf(GenderField.getText());
				} catch (NumberFormatException e11) {
					actiontarget = new Label("Fields must not be blank");
					ActionTargetBox.getChildren().addAll(actiontarget);
					grid1.add(ActionTargetBox, 0, 4);
					return;
				} catch(IllegalArgumentException e16) {
					System.out.println("Duplicated");					
				} catch(Exception ee) {
					System.out.println("Somthing has gone wrong");
				}
			
//				java.lang.IllegalArgumentException e16) {
//				System.out.println("Duplicated");
						if(valueForYear.toString().length() < YEARLIMIT || valueForYear.toString().length() > YEARLIMIT) {
							actiontarget = new Label("Year must contain four numbers");
							ActionTargetBox.getChildren().addAll(actiontarget);
							grid1.add(ActionTargetBox, 0, 4);
							return;
						}
						if(valueForGender.length() > GENDERLIMIT) {
							actiontarget = new Label("Available genders are M and F");
							ActionTargetBox.getChildren().addAll(actiontarget);
							grid1.add(ActionTargetBox, 0, 4);	
							return;
						}
						if(valueForName.length() > NAMELIMIT) {
							actiontarget = new Label("Name is way too long, bro");
							ActionTargetBox.getChildren().addAll(actiontarget);
							grid1.add(ActionTargetBox, 0, 4);
							return;
						}					
						
						
						if(valueForYear <= 2000 || valueForYear > 2011) {
							actiontarget = new Label("Year must be between 2001 and 2010");
							ActionTargetBox.getChildren().addAll(actiontarget);
							grid1.add(ActionTargetBox, 0, 4);	
							return;
						}
				
					
						 Scanner sc2 = null;
						 Scanner tokenize = null;
						 
						 
						 String entireLine = new String();
						    try {
						    	File babyFile = new File("babyNames/babynamesranking" + valueForYear + ".txt");
						        sc2 = new Scanner(babyFile);
						    } catch (FileNotFoundException e5) {
						       System.out.println("File not found");  
						    } catch(NullPointerException e20) {
						    	System.out.println("File not created");
						    }
						    while (sc2.hasNextLine()) {						
						           Scanner s2 = new Scanner(entireLine = sc2.nextLine());
						        if(entireLine.contains(valueForName)) {
						        	ArrayList<String> tokens = new ArrayList<String>();
						        	tokenize = new Scanner(entireLine);
						        	while (tokenize.hasNext()) {
						        	    tokens.add(tokenize.next());
						        	}
						        	//print male results
						        	if(valueForGender.toUpperCase().contains("M")){								        		
					            		actiontarget = new Label("Boy name " + valueForName + " is ranked # " + tokens.get(0) + " in the year " + valueForYear);					            		
										ActionTargetBox.getChildren().addAll(actiontarget);
										grid1.add(ActionTargetBox, 0, 4);
					            	}
						        	//print female results
						        	if(valueForGender.toUpperCase().contains("F")){						            							    
					            		actiontarget = new Label("Girl name " + valueForName + " is ranked #" + tokens.get(0) + " in the year " + valueForYear);
										ActionTargetBox.getChildren().addAll(actiontarget);
										grid1.add(ActionTargetBox, 0, 4);
					            	}						        	
						        }
						    }
					});
				    	
			
			//PrimaryStage
			primaryStage.sizeToScene();
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Search Name Ranking Application");
			
			//Show PrimaryStage
			primaryStage.show();
			
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			launch();
			
		}	
	}