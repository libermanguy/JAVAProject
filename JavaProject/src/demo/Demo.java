package demo;

import algorithms.mazeGenerators.*;
import algorithms.search.*;

// TODO: Auto-generated Javadoc
/**
 * <h1>Maze Demo</h1>
 * The Maze Demo Class
 * <p>
 * Runs All Searchers For Test
 *
 * @author  Guy Liberman
 * @version 1.0
 * @since   2015-08-22
 */
public class Demo {

	/**
	 * Run.
	 */
	public static void run()
	{
		MyMaze3dGenerator mg = new MyMaze3dGenerator();
		Maze3d newmaze  = mg.generate(10,10,10);	
		newmaze.print();
		
		SearchableMaze searchable = new SearchableMaze(newmaze);
		Searcher<Position> searcher = new SearcherBFS<Position>();
		
		System.out.println("Start:              " + newmaze.getStartPosition());
		System.out.println("End:                " + newmaze.getGoalPosition());
		System.out.println(searcher.search(searchable));
		int n = searcher.getNumberOfNodesEvaluated();
		System.out.println("BFS Took:           " + n + " nodes to evaluate");
		
		searcher = new SearcherAStar<Position>(new HeuristicManhattan());
		System.out.println(searcher.search(searchable));
		
		n = searcher.getNumberOfNodesEvaluated();
		System.out.println("A* Manhattan Took : " + n + " nodes to evaluate");
		
		searcher = new SearcherAStar<Position>(new HeuristicAirLine());
		System.out.println(searcher.search(searchable));
		n = searcher.getNumberOfNodesEvaluated();
		System.out.println("A* AirLine Took :   " + n + " nodes to evaluate");
	}
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		run();
	}

}
