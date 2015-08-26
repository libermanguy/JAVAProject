package boot;
import algorithms.mazeGenerators.*;


public class Run 
{
		private static void testMazeGenerator(Maze3dGenerator mg)		// prints the time it takes the algorithm to run
		{		
		System.out.println(mg.measureAlgorithmTime(20,20,3));				// generate another 3d maze
		Maze3d maze  = mg.generate(20,20,20);	
		maze.print();
		Position p=maze.getStartPosition();								// get the maze entrance
		System.out.println(p);											// format "{x,y,z}"					
		String[] moves=maze.getPossibleMoves(p);						// get all the possible moves from a position
		for(String move : moves)										// print the moves
				System.out.println(move);								// prints the maze exit position
		System.out.println(maze.getGoalPosition()); 
		try
		{
			System.out.println("\nget Cross Section By X:");
			int[][] maze2dx=maze.getCrossSectionByX(2);					// get 2d cross sections of the 3d maze
			for (int[] dimension: maze2dx)
				System.out.println(java.util.Arrays.toString(dimension));
			int[][] maze2dy=maze.getCrossSectionByY(5);
			System.out.println("\nget Cross Section By Y:");
			for (int[] dimension: maze2dy)
				System.out.println(java.util.Arrays.toString(dimension));
			int[][] maze2dz=maze.getCrossSectionByZ(0);
			System.out.println("\nget Cross Section By Z:");
			for (int[] dimension: maze2dz)
				System.out.println(java.util.Arrays.toString(dimension));
			maze.getCrossSectionByX(-1);								// this should throw an exception!
		} 
	
	
	catch (IndexOutOfBoundsException e)
		{
			System.out.println("\ngood!");
		}
	}
	public static void main(String[] args) 
	{
		testMazeGenerator(new SimpleMaze3dGenerator());
		testMazeGenerator(new MyMaze3dGenerator());
	}
}