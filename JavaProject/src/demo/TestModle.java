package demo;

import java.io.IOException;

import controller.Controller;
import controller.MyController;
import model.MyModel;
import view.MyView;

public class TestModle {

	public static void main(String[] args) throws IOException {
		
		MyView myview=new MyView();
		myview.Dir("/users/omripolnikviat");
		/*Controller controller = new MyController();
		MyModel model = new MyModel();
		model.setController(controller);
		model.generate("Wonderland",2,10,10);
		model.generate("Underworld",13,13,103);
		try {
		    Thread.sleep(1000);                
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		int x = (int)(model.display("Wonderland")[0]);
		int y = (int)(model.display("Wonderland")[1]);
		int z = (int)(model.display("Wonderland")[2]);
		int[][][] maze = (int[][][])(model.display("Wonderland")[3]);
		for (int i = 0 ; i < x ; i++ )
			{System.out.println();
			for (int j = 0 ; j < y ; j++ ){
				System.out.println();
				for (int k = 0 ; k < z ; k++ )
					System.out.print(maze[i][j][k]);}}
		System.out.println();
		System.out.println();
		System.out.println("start pos " + (model.display("Wonderland"))[4]);
		System.out.println("goal pos  " + (model.display("Wonderland"))[5]);
		int[][] cross = (int[][])model.getCrossSection("Wonderland", 'x', 1);
		for (int j = 0 ; j < y ; j++ ){
			System.out.println();
			for (int k = 0 ; k < z ; k++ )
				System.out.print(cross[j][k]);}
		System.out.println();
		System.out.println("another test");
		cross = (int[][]) model.getCrossSection("Wonderland", 'y', 2);
		for (int j = 0 ; j < x ; j++ ){
			System.out.println();
			for (int k = 0 ; k < z ; k++ )
			
				System.out.print(cross[j][k]);}
				*/
	/*
		model.save("Wonderland", "C:\\Java Project\\test-1.maz");
		model.load("Bathroom", "C:\\Java Project\\test-1.maz");
	//	System.out.println(model.mazeSize("test-1"));
	//	System.out.println(model.mazeSize("test-3"));
		model.solve("Wonderland", "bfs");
		model.solve("Underworld", "man");
		model.solve("Bathroom", "air");
/*		try {
		    Thread.sleep(15000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	System.out.println(model.displaySolution("test-2"));
		System.out.println(model.displaySolution("test-1"));
		System.out.println(model.displaySolution("test-3"));
		
	 	public void exit();*/

	}

}
