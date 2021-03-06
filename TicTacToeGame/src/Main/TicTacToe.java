package Main;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class TicTacToe extends Application {
	private static int isWin = 0; //1 for win //2 for draw
	private static int time = 0;
	private static int user = 1; //1 for X // 2 for O
	private static int arr[];
  public static void main(String args[]) {
	  Application.launch(args);
  }
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Stage myStage = new Stage();
		myStage.setResizable(false);
		Image icon = new Image("Main/close.png");
		myStage.getIcons().add(icon);
		
		VBox vb = new VBox();	
		
		HBox hb1StRow = new HBox();
		HBox hb2ndRow = new HBox();
		HBox hb3rdRow = new HBox();
		
		HBox hbForPlay = new HBox();
		
		Label lPlayAgain = new Label("Play Again?");
		lPlayAgain.getStyleClass().add("info");

		Button btnYes = new Button("Yes");
		btnYes.setPrefSize(70, 50);
		
		Button btnNo = new Button("No");
		btnNo.setPrefSize(70, 50);
		
		hbForPlay.getChildren().addAll(lPlayAgain);
		hbForPlay.setAlignment(Pos.CENTER);
		hbForPlay.setSpacing(10);
		
		arr = new int[9];
		for(int j = 0; j<9;j++)
		{
			arr[j] = -1;
		}
		
		Button button[] = new Button[9];
	
		vb.getChildren().addAll(hb1StRow,hb2ndRow,hb3rdRow,hbForPlay);
		vb.setSpacing(10);

		lPlayAgain.setText("User O's Turn");
		
		for(int i=0;i<9;i++)
		{

			button[i] = new Button();
//			button[i].setGraphic(new ImageView(new Image("Main/whitebg.png")));
			button[i].setStyle("-fx-background-color:white");
			int index = i;
			button[i].setOnAction(e->{
//			System.out.print("Win Condition :"+isWin);
//			System.out.print("\n");
			if(isWin == 0) {
				
				if(user == 1)
				{
					lPlayAgain.setText("User X's Turn");
				}
				else
				{
					lPlayAgain.setText("User O's Turn");
				}
				
						if(user == 1)
						{	
							if(isClick(index) == false)
							{
								Insert(1,index);
								display();
								button[index].setGraphic(new ImageView(new Image("Main/circle.png")));
								if(isHorizontalWin() == true || isVerticalWin() == true || isMainDiagonalWin() == true || isOtherDiagonalWin() == true)
								{
									isWin = 1;
//									System.out.println("Hey I'm Here");

									lPlayAgain.setText("User O Wins");
									
									hbForPlay.getChildren().clear();
									hbForPlay.getChildren().addAll(lPlayAgain,btnYes,btnNo);
								}
								if(isDraw())
								{
//									System.out.println("Hey I'm Here");

									isWin = 2; // Draw	
									lPlayAgain.setText("Draw. Play Again?");
									hbForPlay.getChildren().clear();
									hbForPlay.getChildren().addAll(lPlayAgain,btnYes,btnNo);								
								}
								
								user = 2;
							}
							
							vb.getChildren().remove(hbForPlay);
							vb.getChildren().add(hbForPlay);

						}
						else {
					     
							if(isClick(index) == false)
							{
								Insert(2,index);
								display();
								button[index].setGraphic(new ImageView(new Image("Main/close.png")));
								if(isHorizontalWin() == true || isVerticalWin() == true || isMainDiagonalWin() == true || isOtherDiagonalWin() == true)
								{
									isWin = 1;
									
									lPlayAgain.setText("User X Wins");
									vb.setSpacing(20);	
									hbForPlay.getChildren().clear();
									hbForPlay.getChildren().addAll(lPlayAgain,btnYes,btnNo);
								}
								if(isDraw())
								{
									isWin = 2; // Draw	
									lPlayAgain.setText("Draw");
									hbForPlay.getChildren().clear();
									hbForPlay.getChildren().addAll(lPlayAgain,btnYes,btnNo);
								}
								user = 1;
							}
						}
						
						
				}
			
			
				
			});
			button[i].setPrefSize(150, 150);			
		}
		
		btnYes.setOnAction(e->{
			isWin = 0;
			for(int i = 0; i<9;i++)
			{
				arr[i] = -1;
			}
			for(int i=0;i<9;i++)
			{
				button[i].setGraphic(new ImageView(new Image("Main/whitebg.png")));
				button[i].setStyle("-fx-background-color:white");
			}
			user = 1;
			vb.getChildren().clear();
			lPlayAgain.setText("User's O Turn");
			hbForPlay.getChildren().clear();
			hbForPlay.getChildren().add(lPlayAgain);
			vb.getChildren().addAll(hb1StRow,hb2ndRow,hb3rdRow,hbForPlay);

		});
		
		btnNo.setOnAction(e->{
			myStage.close();
		});
		
		hb1StRow.getChildren().addAll(button[0],button[1],button[2]);
		hb2ndRow.getChildren().addAll(button[3],button[4],button[5]);
		hb3rdRow.getChildren().addAll(button[6],button[7],button[8]);

		hb1StRow.setSpacing(10);
		hb2ndRow.setSpacing(10);
		hb3rdRow.setSpacing(10);

		
		Scene sc = new Scene(vb,500,600);
		 sc.getStylesheets().add(
			      getResource(
			        "../Style.css"
			      )
			    );		
	    myStage.setScene(sc);
		myStage.show();
		
	}
	
	public static boolean isDraw() {
	
		boolean isDraw = true;
		for(int i = 0; i<9; i++) {
			if(arr[i] == -1)
			{
				isDraw = false;
			}
		}
		return isDraw;
	}
	
	public static void Insert(int value,int time) {
		arr[time] = value;
		
	}
	
	public static void display() {
		for(int i = 0; i< 9;i++)
		{
//			System.out.print(arr[i]);
//			System.out.print("\t");
//			if(i == 2 )
//			{
//				System.out.print("\n");
//			}
//			
//			if(i == 5 )
//			{
//				System.out.print("\n");
//			}
//			
//			if(i == 8 )
//			{
//				System.out.print("\n");
//			}
		}
	}
	
	public static boolean isClick(int time)
	{
		if(arr[time] != -1)
		{
			return true;
		}
		return false;
	}
	  
	public static boolean isMainDiagonalWin()
	{
		boolean isWin = false;
		if(arr[0] == arr[4] && arr[4] == arr[8] && arr[0] !=-1)
		{
			isWin = true;
			
//				System.out.print("MD Wins");
//				System.out.print("\n");

		}
		return isWin;
	}
	public static boolean isOtherDiagonalWin()
	{
		boolean isWin = false;
		if(arr[2] == arr[4] && arr[4] == arr[6] && arr[2] !=-1)
		{
			isWin = true;
//			System.out.print("OD Wins");
//			System.out.print("\n");
		}
		return isWin;
	}
	
	public static boolean isHorizontalWin() {
		boolean isWin = false;
		for(int i = 0; i<9;i=i+3)
		{
			if(arr[i] == arr[i+1] && arr[i+1]== arr[i+2] && arr[i]!=-1)
			{
//				System.out.print("H Wins "+i+"rows");
//				System.out.print("\n");

				isWin = true;
			}
		}
		return isWin;
	}
	
	public static boolean isVerticalWin() {
		
		boolean isWin = false;
		for(int i = 0; i<3;i++)
		{
			if(arr[i] == arr[i+3] && arr[i+6]== arr[i+3] && arr[i]!=-1)
			{
//				System.out.print("V Wins "+i+"column");
//				System.out.print("\n");

				isWin = true;
			}
		}
		return isWin;
	}
	private String getResource(String resourceName) {
	    return getClass().getResource(resourceName).toExternalForm();
	  }
  
}
  