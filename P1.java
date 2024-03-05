//Linh Pham; P1; CIS 340; T/Th 3:00 - 4:15
import java.util.Scanner;
public class P1 {
	static Double [][] score;
	static String [] names;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		Scanner inputDevice = new Scanner(System.in);
		
		// ask and store number of scores each student have into array
		System.out.print("How many scores per student? ");
		int numberOfScores = Integer.parseInt(inputDevice.nextLine());
		
		
		names = new String [3];
		score = new Double[3][numberOfScores];
	
		// nested loop collect each score from each student
		for( int i = 0; i < names.length; i++)
		{
			System.out.printf("\nEnter name for student %d: ", i+1);
			names[i] = inputDevice.nextLine();
			System.out.printf("\nEntering score for %s\n", names[i] );
			
			for ( int j = 0; j < score[i].length; j++)
			{
				System.out.printf("Quiz %d: ", j+1);
				score[i][j] = Double.parseDouble(inputDevice.nextLine());
			}
			
		// do while loop for repeated menu after every requested task 
		}
		char choice;
		do {
		System.out.print("\n\n\n\n\n");
		System.out.print("\t\tMenu");
		System.out.println("\n1. Class Average");
		System.out.println("2. Student Average");
		System.out.println("3. Quiz Average");
		System.out.print("\nEnter choice number, or x to exit: ");
	    choice = inputDevice.nextLine().charAt(0);
		
		
		// Calculate and display based on choice
	    // switch method to show the values based on the characters users choose 
		switch (choice) 
		{
			case '1':
		// Calculate and display class average
			P1.classAverage();	
			break;
			case '2':
		    // Calculate and display student averages
			P1.studentAverage();
		    break;
		    case '3':
		    // Calculate and display quiz averages
		    P1.quizAverage();
		    break;
		    case 'x':
		    System.out.print("Exiting the program");
		    // Hit x to exiting the program
		    
		} 
		} while (choice != 'x');
		    

		inputDevice.close();
	}
	

	// method to calculate the average of class 
	public static void classAverage()
	{
		double classAverage = 0.0;
		int scoreCount = 0;

		for (int i = 0; i < score.length; i++) 
		{
			for ( int j = 0; j < score[i].length; j++)
			{
				classAverage += score[i][j];
				scoreCount++;
			}
				
		}
			classAverage /= scoreCount;
			System.out.printf("Class average for all quizzes is: %.2f\n", classAverage);	

	}
	// method calculate the average by student
	public static void studentAverage()
	{
		System.out.println("\nCalculating average by student.");
		Scanner inputDevice = new Scanner(System.in);
		System.out.print("\nEnter student name: ");
		String inputName = inputDevice.nextLine();
		

		double studentAverage = 0.0;
	
		
	    for (int i = 0; i < names.length; i++) 
	    {
			if (inputName.equalsIgnoreCase(names[i]))
	    	{
	    		
		    	for (int j = 0; j < score[i].length; j++) 
		    	{
		    		studentAverage += score[i][j];
		        }
	    
	        	studentAverage /= score[i].length;
	        	System.out.printf("%s's score are: ", names[i]);
	        	for ( int k = 0; k < score[i].length; k++)
	        	{
	        		// using for loop to show the list of scores each student have 
	        		System.out.printf("%.2f ", score[i][k]);
	        	}

	        		System.out.printf("\n%s's average is %.2f\n", names[i], studentAverage);
	        		return;
	    	}
	    }
			    // if the loop complete without returning, student is not found.
				System.out.print("Student not found.");
			
	    
		
	}
	public static void quizAverage()
	{
		// method to calculate average by quiz number
		System.out.println("\nCalculating average by Quiz Number.");
		Scanner inputDevice = new Scanner(System.in);
		System.out.print("\nEnter quiz number: ");
	    int inputQuizNumber = Integer.parseInt(inputDevice.nextLine());
	    
	    if ( inputQuizNumber >=1 && inputQuizNumber <= score[0].length )
	    {
	    	double quizAverage = 0.0;
			for ( int i = 0; i < names.length; i++ )
			{
			quizAverage += score[i][inputQuizNumber - 1];
			}
			    quizAverage /= names.length;
			    System.out.printf("\nQuiz %d Average: %.2f\n", inputQuizNumber, quizAverage);
	    }
	    
		
	}
	

}
