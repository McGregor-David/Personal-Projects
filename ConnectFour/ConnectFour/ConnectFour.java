package ConnectFour;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


		public class ConnectFour extends Application{
			
			int turn = 0;
	
			@Override
			public void start(Stage primaryStage) throws Exception {
				// TODO Auto-generated method stub
				//Button test = new Button();		
				
//				//Pane
				GridPane grid1 = new GridPane();	
				grid1.setAlignment(Pos.CENTER);
				grid1.setHgap(10);
				grid1.setVgap(10);
				grid1.setPadding(new Insets(60, 60, 60, 60));
//							
//				//Scene
				Scene scene1 = new Scene(grid1,400,400);
				scene1.getStylesheets().add("Custom-Layout.css");
//				
//			
				//Horizontal boxes			
				HBox H1 = new HBox();
					for(int i = 0; i < 7; i++) {
						Button temp = new Button();
						temp.getStyleClass().addAll("btn");
						temp.setMinWidth(30);
						temp.setOnAction(e->{ 
							if(turn%2 == 1) {						
								temp.getStyleClass().add("black");							
							}else{
								temp.getStyleClass().add("red");								
							}
							turn++;
							temp.setDisable(true);});
						H1.getChildren().add(temp);
					}

				HBox H2 = new HBox();
					for(int i = 0; i < 7; i++) {
						Button temp = new Button();
						temp.getStyleClass().add("btn");
						temp.setMinWidth(30);
						temp.setOnAction(e->{ 
							if(turn%2 == 1) {
								temp.getStyleClass().add("black");							
							}else{
								temp.getStyleClass().add("red");								
							}
							turn++;
							temp.setDisable(true);});
						H2.getChildren().add(temp);
						
					}
				HBox H3 = new HBox();
					for(int i = 0; i < 7; i++) {
						Button temp = new Button();
						temp.getStyleClass().add("btn");
						temp.setMinWidth(30);
						temp.setOnAction(e->{ 
							if(turn%2 == 1) {
								temp.getStyleClass().add("black");							
							}else{
								temp.getStyleClass().add("red");								
							}
							turn++;
							temp.setDisable(true);});
						H3.getChildren().add(temp);
					}
				HBox H4 = new HBox();
					for(int i = 0; i < 7; i++) {
						Button temp = new Button();
						temp.getStyleClass().add("btn");
						temp.setMinWidth(30);
						temp.setOnAction(e->{ 
							if(turn%2 == 1) {
								temp.getStyleClass().add("black");							
							}else{
								temp.getStyleClass().add("red");								
							}
							turn++;
							temp.setDisable(true);});
						H4.getChildren().add(temp);
					}
				HBox H5 = new HBox();
					for(int i = 0; i < 7; i++) {
						Button temp = new Button();
						temp.getStyleClass().add("btn");
						temp.setMinWidth(30);
						temp.setOnAction(e->{ 
							if(turn%2 == 1) {
								temp.getStyleClass().add("black");							
							}else{
								temp.getStyleClass().add("red");								
							}
							turn++;
							temp.setDisable(true);});
						H5.getChildren().add(temp);
					}
				HBox H6 = new HBox();
					for(int i = 0; i < 7; i++) {
						Button temp = new Button();
						temp.getStyleClass().add("btn");
						temp.setMinWidth(30);
						temp.setOnAction(e->{ 
							if(turn%2 == 1) {
								temp.getStyleClass().add("black");							
							}else{
								temp.getStyleClass().add("red");								
							}
							turn++;
							temp.setDisable(true);});
						H6.getChildren().add(temp);
					}
				grid1.add(H1,0,0);
				grid1.add(H2,0,1);
				grid1.add(H3,0,2);
				grid1.add(H4,0,3);
				grid1.add(H5,0,4);
				grid1.add(H6,0,5);
				

				//PrimaryStage
				primaryStage.setScene(scene1);
				primaryStage.setTitle("Connect-Four");
				
				//Show PrimaryStage
				primaryStage.show();
				
			}
			
		
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
				launch();
				
			}	

}
