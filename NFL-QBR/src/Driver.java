import java.util.Scanner;

public class Driver {

	static Scanner input = new Scanner(System.in);
	public static double attempts; public static double completions;
	public static double yards; public static double touch;
	public static double inter; 
	public static double rule1; public static double rule2;
	public static double rule3; public static double rule4;
	public static double rating;
	
	public static void main(String[] args) {
		
		System.out.println("This is an NFL QB Rating.\n");
		input();
		calc();
		System.out.println("QBR: " + Math.round(rating * 100.0) / 100.0);
	}
	
	public static void input() {
		
		System.out.println("Please enter passes attempted:");			
		while (!input.hasNextInt()) { 		
			System.out.println("Attempts must be an integer:");
		    input.next();
		}
		attempts = input.nextInt();
		
		if (attempts != 0) {
			boolean good = false;
			do { 	
				System.out.println("Please enter passes completed:");
				
				while (!input.hasNextInt()) { 		
					System.out.println("Completions must be an integer:");
				    input.next();
				}
				completions = input.nextInt();
				
				if (completions <= attempts ) 
					good = true;
				else
					System.out.println("Completions must not exceed attempts:");
			}	
			while (!good); 
			
			if (completions != 0) {
						
				System.out.println("Please enter yards gained:");
				while (!input.hasNextInt()) { 		
					System.out.println("Yards must be an integer:");
				    input.next();
				}
				yards = input.nextInt();
				
				good = false;
				do { 	
					System.out.println("Please enter touchdowns thrown:");
					
					while (!input.hasNextInt()) { 		
						System.out.println("Touchdowns must be an integer:");
					    input.next();
					}
					
					touch = input.nextInt();
					if (touch <= completions) 
						good = true;
					else
						System.out.println("Touchdowns must not exceed completions:");
				}	
				while (!good); 
			
				good = false;
				do { 	
					System.out.println("Please enter interceptions thrown:");
					
					while (!input.hasNextInt()) { 		
						System.out.println("Interceptions must be an integer:");
					    input.next();
					}
					
					inter = input.nextInt();
					if (inter + touch <= attempts) 
						good = true;
					else
						System.out.println("Interceptions and touchdowns must not exceed attempts:");
				}			
				while (!good); 		
			}
			
			else { 
				
				yards = 0; touch = 0; 
				
				good = false;
				do { 	
					System.out.println("Please enter interceptions thrown:");
					
					while (!input.hasNextInt()) { 		
						System.out.println("Interceptions must be an integer:");
					    input.next();
					}
					
					inter = input.nextInt();
					if (inter + touch <= attempts) 
						good = true;
					else
						System.out.println("Interceptions must not exceed attempts:");
				}			
				while (!good); 
			}
		}
		else {
			
			completions = 0; yards = 0;
			touch = 0; inter = 0;
		}
	}
	
	public static void calc() {
		
		rule1 = (int) ((((completions / attempts) * 100) - 30) * 0.05);
		if (rule1 < 0) rule1 = 0;
		else if (rule1 > 2.375) rule1 = 2.375;
			
		rule2 = ((yards / attempts) - 3) * 0.25;
		if (rule2 < 0) rule2 = 0;
		else if (rule2 > 2.375) rule2 = 2.375;
		
		rule3 = ((touch / attempts) * 100) * 0.2;
		if (rule3 > 2.375) rule3 = 2.375;
		
		rule4 = 2.375 - (((inter / attempts) * 100) * 0.25);
		if (rule4 < 0) rule4 = 0;

		rating = ((rule1 + rule2 + rule3 + rule4) / 6) * 100;	
	}
}