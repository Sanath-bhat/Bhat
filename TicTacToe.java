import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
 	static ArrayList<Integer> Playerpositions = new ArrayList<Integer>();
 	static ArrayList<Integer> CPUpositions = new ArrayList<Integer>();
 	

	public static void main(String[] args) {
		char[][] Board = { {' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},};
		
		
		displayBoard(Board);
		
		while(true) {
			
			Scanner scan=new Scanner(System.in);
			
			System.out.println("Enter your position (1-9)");
			int playpos = scan.nextInt();
			if(playpos>9)
			{
				System.out.println("Invalid position, Please enter correct position");
				playpos=scan.nextInt();
		    }
			while(Playerpositions.contains(playpos)|| CPUpositions.contains(playpos))
			{
				System.out.println("Position already taken,Enter the correct position");
				playpos=scan.nextInt();
			}
			
			
		    position(Board,playpos,"Player");
		    String result = FindWinner();
		    if(result.length()>0) {
				System.out.println(result);
				break;
			}
		    
		    Random rand=new Random();
		    int cpupos=rand.nextInt(9)+1;
		    while(Playerpositions.contains(cpupos)|| CPUpositions.contains(cpupos))
			{
				cpupos=rand.nextInt(9)+1;
			}
			
		    
		    position(Board,cpupos,"CPU");
		      
			displayBoard(Board);
			
			 result = FindWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
		
			
		}
		
		
}
	public static void displayBoard(char[][] Board) {
		for(int i=0;i<Board.length;i++)
		{
			for(int j=0;j<Board.length;j++)
			{
			System.out.print(Board[i][j]);
			}
			System.out.println();
		}
			
	}
		public static void position(char[][] Board, int pos, String user) {
			char symbol=' ';	
			if(user.equals("Player")){
				symbol='X';
				Playerpositions.add(pos);
			}
			else if(user.equals("CPU")){
				symbol='O';
				CPUpositions.add(pos);
				}
				
				
			switch(pos) {
				case 1:
					Board[0][0] = symbol;
					break;
				case 2:
					Board[0][2] = symbol;
					break;
				case 3:
					Board[0][4] = symbol;
					break;
				case 4:
					Board[2][0] = symbol;
					break;
				case 5:
					Board[2][2] = symbol;
					break;
				case 6:
					Board[2][4] = symbol;
					break;
				case 7:
					Board[4][0] = symbol;
					break;
				case 8:
					Board[4][2] = symbol;
					break;
				case 9:
					Board[4][4] = symbol;
					break;
				default:
					
				}
			}
				public static String FindWinner() {
					
					List Rowone   = Arrays.asList(1,2,3);
					List Rowtwo   = Arrays.asList(4,5,6);
					List Rowthree = Arrays.asList(7,8,9);
					List Colone   = Arrays.asList(1,4,7);
					List Coltwo   = Arrays.asList(2,5,8);
					List Colthree = Arrays.asList(3,6,9);
					List diag1    = Arrays.asList(1,5,9);
					List diag2    = Arrays.asList(3,5,7);
					
					List<List> wincheck  = new ArrayList<List>();
					
					wincheck.add(Rowone);
					wincheck.add(Rowtwo);
					wincheck.add(Rowthree);
					wincheck.add(Colone);
					wincheck.add(Coltwo);
					wincheck.add(Colthree);
					wincheck.add(diag1);
					wincheck.add(diag2);
					
					for(List l:wincheck)
					{
						if(Playerpositions.containsAll(l)){
							return "Congragulations you won!!!";
						}
						else if(CPUpositions.containsAll(l)) {
							return "Oops You lost :(";
						}}
						 if(Playerpositions.size() + CPUpositions.size() ==9) {
							return "It's Draw";
						}
					
					
					
					return "";
				}
}