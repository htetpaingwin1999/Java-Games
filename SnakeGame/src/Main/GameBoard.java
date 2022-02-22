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

import java.awt.Color;
import java.util.*;

public class GameBoard extends Application {
	
  private final int borderWidth = 500;
  private final int borderHeight = 500;
  private final int dotSize = 10;
  private final int allDots = 900;
  private final int randomPosition = 29;
  private final int delay = 140;
  
  private final int x[] = new int[allDots];
  private final int y[] = new int[allDots];
  
  private int dots;
  private int appleX;
  private int appleY;
  
  private boolean left = false,right = true,up = false, down = false;
  private boolean inGame = true;
  
  private Timer timer;
  private Image ball;
  private Image apple;
  private Image head;
  
  
  public  GameBoard() {
	  //initBoard();
  }
  
//  private void initBoard() {
//	  addKeyListener(new TAdapter());
//	  setBackground(Color.BLACK);
//  }
  
  private void loadImages() {
	  ball = new Image("src/Main/dot.png");
	  
	  apple = new Image("src/Main/apple.png");
	  
	  head = new Image("src/Main/head.png");
	 
  }
  
  private void initGame() {
	  dots = 3;
	  
	  for(int i = 0; i< dots; i++)
	  {
		  x[i] = 50 - i * 10; // 
		  y[i] = 50;
	  }
	  	//locateApple();

//	  timer = new Timer();
//	  timer.
	  
  }
  
  
  
  
  
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
		
	}
}
  