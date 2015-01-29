
   import java.util.Scanner;
   import java.util.Random;

	public class Question {
		static String question;
		int number,number1,answer;
		int operator;

	//	   public static void main (String [] args) {
//		   createQuestion();
//	   }
	   public Question(){
		   createQuestion();
	   }
	   public void createQuestion(){
		 Scanner input=new Scanner (System.in);

		 

		Random rand = new Random();
		int oper = (rand.nextInt(3) + 1);
	    operator = -1;

		switch (oper)
		{
		case 1: operator = 10;
				
		break;
		case 2: operator = 11;
		break;
		case 3: operator = 12;
		break;
//		case 4: operator = 13;
//		break;
		}

		 number=(int)(9*Math.random()+1);
		 number1=(int)(9*Math.random()+1);

//Addition
		 
		 if (oper == 1){
			 answer=number+number1;
			 //System.out.print ("What is "+number+" + "+number1+": ");
			 question = "What is "+number+ operator +number1+": ";
//			answer=input.nextInt();
//			if (answer==number+number1) {
//				 System.out.print ("Correct");
//			 } else if (answer!=(number+number1)) {
//				 System.out.print ("Incorrect");
//			 }
		 }
		 


//Subtraction
		
		 if (oper == 2){
			 answer=number-number1;
			 //System.out.print  ("What is "+number+" - "+number1+": ");
			 question = "What is "+number+ operator +number1+": ";
//			answer=input.nextInt();
//			 if (answer==number-number1) {
//				 System.out.print ("Correct");
//			 } else if (answer!=(number+number1)) {
//				 System.out.print ("Incorrect");
//			 }
		 }

		

//Multiplication
	 
		 if (oper == 3){
			  answer=number*number1;
			
			 question = "What is "+number+ operator +number1+": ";
//			answer=input.nextInt();
//
//			 if (answer==number*number1) {
//				 System.out.print ("Correct");
//			 } else if (answer!=(number*number1)) {
//				 System.out.print ("Incorrect");
//			 }
		 }


//Division
//		 
//		 if (oper == 4){
//			 answer=number/number1;
//			// System.out.print  ("What is "+number+" / "+number1);
//			 question = "What is "+number+ operator +number1+": ";
////			answer=input.nextInt();
////			if (answer==number/number1) {
////				 System.out.print ("Correct");
////			 } else if (answer!=(number*number1)) {
////				 System.out.print ("Incorrect");
////			 }
//		 }

		 


	  }
	   
	   public String getQuestion(){
		   return question;
	   }
	   public int getNumber() {
			return number;
	   }
	   public int getNumber1() {
			return number1;
	   }
	   public int getOperator(){
		   return operator;
	   }
	   public int getAnswer(){
		   return answer;
	   }
   }
