package demo;

import java.io.IOException;

import controller.Controller;
import controller.MyController;
import model.MyModel;

public class TestModle {

	public static void main(String[] args) throws IOException {
		
		Controller controller = new MyController();
		MyModel model = new MyModel();
		model.setController(controller);
		model.generate("Wonderland",10,3,3);
		model.generate("Underworld",13,13,103);
	/*	System.out.println(model.display("test-2"));
		System.out.println(model.display("test-1"));
		System.out.println(model.getCrossSection("test-1", 'x', 1));
		System.out.println(model.getCrossSection("test-2", 'y', 2));*/
		try {
		    Thread.sleep(1000);                
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
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
