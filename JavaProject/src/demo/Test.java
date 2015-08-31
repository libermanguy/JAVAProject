package demo;

import java.io.*;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class Test {

	public static void main(String[] args) throws IOException {
		MyMaze3dGenerator mg = new MyMaze3dGenerator();
		Maze3d maze  = mg.generate(3,3,3);	
		maze.print();
		System.out.println(maze.getStartPosition().toString());
		System.out.println(maze.getGoalPosition().toString());
		OutputStream out=new MyCompressorOutputStream(new FileOutputStream("C:\\Java Project\\c1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();		
		
		InputStream in = new MyDecompressorInputStream(new FileInputStream("C:\\Java Project\\c1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3d loaded=new Maze3d(b);
		System.out.println(loaded.equals(maze));
	}

}
