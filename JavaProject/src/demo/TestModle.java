package demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.print.attribute.standard.PrinterLocation;

import model.MyModel;

public class TestModle {

	public static void main(String[] args) throws IOException {
		
		MyModel model = new MyModel();
		model.generate("test-1",5,5,5);
		model.generate("test-2",10,10,10);
	//	System.out.println(model.display("test-2"));
	//	System.out.println(model.display("test-1"));
	//	System.out.println(model.getCrossSection("test-1", 'x', 1));
	//	System.out.println(model.getCrossSection("test-2", 'y', 2));
		model.save("test-1", "C:\\Java Project\\test-1.maz");
		//model.load("test-3", "C:\\Java Project\\test-1.maz");
		System.out.println(model.mazeSize("test-1"));
	//	System.out.println(model.mazeSize("test-3"));
		model.solve("test-2", "man");
		model.solve("test-1", "man");
		System.out.println(model.displaySolution("test-2"));
		System.out.println(model.displaySolution("test-1"));
		
	// 	public void exit();*/

	}

}
