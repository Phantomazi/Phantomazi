import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class AssignmentTemplate extends Application{
	public static void main(String[] args){
		launch(args);
	}
	
	Scene scene;
	TabPane root;
	Tab tab1, tab2;
	Button play, score, reset, generate, ansNum0, ansNum1, ansNum2, ansNum3, ansNum4, ansNum5, ansNum6, ansNum7, ansNum8, ansNum9;
	BorderPane borderPane;
	Pane controlPane, gamePane;
	Number number, equals;
	Question question;
	Label questionNumber1 = new Label();
	Label questionNumber2 = new Label();
	Label questionOperator = new Label();
	Label finalAnsNum1 = new Label();
	Label finalAnsNum2 = new Label();
	//Label equals = new Label();
	boolean pos1 = true;
	boolean pos2 = true;
	int ansID1=0;
	int ansID2=-1;
	
	EventHandler bHandler = new EventHandler(){
		
		@Override
		public void handle(Event arg0) {
			makeEquation();
			
		}
	};
	
EventHandler checkHandler = new EventHandler(){
		
		@Override
		public void handle(Event arg0) {
			checkAnswer();
			
		}
	};
	
EventHandler resetHandler = new EventHandler(){
		
		@Override
		public void handle(Event arg0) {
			reset();
			
		}
	};
	
EventHandler playHandler = new EventHandler(){
		
		@Override
		public void handle(Event arg0) {
			startGame();
			
		}
	};	
	public void start(Stage stage) throws Exception{
		stage.setTitle("Software Architectures - Rosen Todorov");
		root = new TabPane();
		borderPane = new BorderPane();
		controlPane = new Pane();
		gamePane = new Pane();
		scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		
		tab1 = new Tab();
		tab1.setText("Game");
		tab1.setClosable(false);
		
		play = new Button();
		play.setText("Play");
		play.setLayoutX(20);
		play.setLayoutY(100);
		play.setOnAction(playHandler);
		
		score = new Button();
		score.setText("Score");
		score.setLayoutX(20);
		score.setLayoutY(130);
		
		reset = new Button();
		reset.setText("Reset");
		reset.setLayoutX(20);
		reset.setLayoutY(160);
		reset.setOnAction(resetHandler);
		
		controlPane.setStyle("-fx-background-color: #336699;");
		controlPane.setPrefSize(100, 600);
		controlPane.getChildren().addAll(play, score, reset);
		borderPane.setLeft(controlPane);
		
		
		tab1.setContent(borderPane);		
	    root.getTabs().add(tab1);	  
		
		tab2 = new Tab();
		tab2.setText("Instructions");
		tab2.setClosable(false);
		root.getTabs().add(tab2);
		
		stage.show();
	}
	
	public void makeEquation(){
		
		gamePane.getChildren().removeAll(questionNumber1, questionOperator, questionNumber2, equals, finalAnsNum1, finalAnsNum2);
		pos1 = false;
		pos2 = false;
		ansID1=0;
		ansID2=-1;
		
		int positiveAnswer=-1;
		while(positiveAnswer<0){
			question = new Question();
			positiveAnswer = question.getAnswer();
		}
		
		Number number1 = new Number(30.0, 30.0, question.getNumber());
		questionNumber1.setGraphic(number1);			
		Number operator = new Number(30.0, 30.0, question.getOperator());
		questionOperator.setGraphic(operator);
		Number number2 = new Number(30.0, 30.0, question.getNumber1());
		questionNumber2.setGraphic(number2);
		equals = new Number(30.0, 30.0, 14);
		
	
		questionNumber1.setLayoutX(150);
		questionNumber1.setLayoutY(150);
		questionNumber2.setLayoutX(350);
		questionNumber2.setLayoutY(150);
		questionOperator.setLayoutX(250);
		questionOperator.setLayoutY(150);
		equals.setLayoutX(400);
		equals.setLayoutY(130);
		
		gamePane.getChildren().addAll(questionNumber1, questionOperator, questionNumber2, equals);

	}
	
//	public void checkAnswer(){		
//		int answer = question.getAnswer(); 		
//			if(ansID2==-1){
//				if(String.valueOf(answer).equals(String.valueOf(ansID1))){
//					makeEquation();
//				}
//			}else{
//				if(String.valueOf(answer).equals(String.valueOf(ansID1) + String.valueOf(ansID2))){
//					makeEquation();
//				}
//			}
//	}
	public void checkAnswer(){      
	    int answer = question.getAnswer();
	    int response = ansID1;

	    if(ansID2 >= 0) {
	        response = 10 * response + ansID2;
	    } // else a one-digit response
	    if (answer == response) {
	        makeEquation();
	    }
	}
	
	public void reset(){
		gamePane.getChildren().removeAll(finalAnsNum1, finalAnsNum2);
		pos1 = false;
		pos2 = false;
		ansID1=0;
		ansID2=-1;
	}
	
	public void startGame(){

		generate = new Button();
		generate.setText("Generate");
		generate.setLayoutX(20);
		generate.setLayoutY(450);
		generate.setOnAction(bHandler);
		
		Button checkAnswer = new Button();
		checkAnswer.setText("Check Answer");
		checkAnswer.setLayoutX(120);
		checkAnswer.setLayoutY(450);
		checkAnswer.setOnAction(checkHandler);
		
		
		ansNum0 = new Button(null, new ImageView(new Image("resources/0_e.png")));
		ansNum0.setLayoutX(20);
		ansNum0.setLayoutY(300);
		EventHandler num0Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum0 = new Number(30.0, 30.0, 0);
		
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum0);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 0;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum0);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 0;
					gamePane.getChildren().add(finalAnsNum2);
				}
			}
		};
		ansNum0.setOnAction(num0Handler);
		
		
		ansNum1 = new Button(null, new ImageView(new Image("resources/1_e.png")));
		ansNum1.setLayoutX(85);
		ansNum1.setLayoutY(300);
		EventHandler num1Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum1 = new Number(30.0, 30.0, 1);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum1);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1=1;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum1);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2=1;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum1.setOnAction(num1Handler);
		
		ansNum2 = new Button(null, new ImageView(new Image("resources/2_e.png")));
		ansNum2.setLayoutX(150);
		ansNum2.setLayoutY(300);
		EventHandler num2Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum2 = new Number(30.0, 30.0, 2);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum2);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1=2;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum2);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2=2;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum2.setOnAction(num2Handler);
		
		ansNum3 = new Button(null, new ImageView(new Image("resources/3_e.png")));
		ansNum3.setLayoutX(215);
		ansNum3.setLayoutY(300);
		EventHandler num3Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum3 = new Number(30.0, 30.0, 3);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum3);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 3;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum3);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 3;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum3.setOnAction(num3Handler);
		
		ansNum4 = new Button(null, new ImageView(new Image("resources/4_e.png")));
		ansNum4.setLayoutX(280);
		ansNum4.setLayoutY(300);
		EventHandler num4Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum4 = new Number(30.0, 30.0, 4);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum4);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 4;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum4);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 4;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum4.setOnAction(num4Handler);
		
		ansNum5 = new Button(null, new ImageView(new Image("resources/5_e.png")));
		ansNum5.setLayoutX(345);
		ansNum5.setLayoutY(300);
		EventHandler num5Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum5 = new Number(30.0, 30.0, 5);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum5);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 5;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum5);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 5;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum5.setOnAction(num5Handler);

		ansNum6 = new Button(null, new ImageView(new Image("resources/6_e.png")));
		ansNum6.setLayoutX(410);
		ansNum6.setLayoutY(300);
		EventHandler num6Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum6 = new Number(30.0, 30.0, 6);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum6);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 6;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum6);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 6;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum6.setOnAction(num6Handler);
		
		ansNum7 = new Button(null, new ImageView(new Image("resources/7_e.png")));
		ansNum7.setLayoutX(475);
		ansNum7.setLayoutY(300);
		EventHandler num7Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum7 = new Number(30.0, 30.0, 7);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum7);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 7;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum7);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 7;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum7.setOnAction(num7Handler);
		
		ansNum8 = new Button(null, new ImageView(new Image("resources/8_e.png")));
		ansNum8.setLayoutX(540);
		ansNum8.setLayoutY(300);
		EventHandler num8Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum8 = new Number(30.0, 30.0, 8);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum8);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 8;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum8);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 8;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum8.setOnAction(num8Handler);
		
		ansNum9 = new Button(null, new ImageView(new Image("resources/9_e.png")));
		ansNum9.setLayoutX(605);
		ansNum9.setLayoutY(300);
		EventHandler num9Handler = new EventHandler(){
			
			@Override
			public void handle(Event arg0) {
				Number ansNum9 = new Number(30.0, 30.0, 9);
				
				if(pos1==false){
					finalAnsNum1.setGraphic(ansNum9);
					finalAnsNum1.setLayoutX(500);
					finalAnsNum1.setLayoutY(150);
					pos1=true;
					ansID1 = 9;
					gamePane.getChildren().add(finalAnsNum1);
				}else if(pos2==false){
					finalAnsNum2.setGraphic(ansNum9);
					finalAnsNum2.setLayoutX(550);
					finalAnsNum2.setLayoutY(150);
					pos2=true;
					ansID2 = 9;
					gamePane.getChildren().add(finalAnsNum2);
				}

			}
		};
		ansNum9.setOnAction(num9Handler);
		
		
		makeEquation();
		//gamePane.setStyle(Color.YELLOW);
		gamePane.setPrefSize(700, 600);
		gamePane.getChildren().addAll(generate, checkAnswer, ansNum0, ansNum1, ansNum2, ansNum3, ansNum4, ansNum5, ansNum6, ansNum7, ansNum8, ansNum9);

		borderPane.setCenter(gamePane);
		
		
		
	}
}
