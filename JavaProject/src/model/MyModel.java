 package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import algorithms.mazeGenerators.*;
import algorithms.search.*;
import controller.Controller;
import general.Position;
import general.Solution;
import general.State;
import io.*;


public class MyModel implements Model {

	HashMap<String,SearchableMaze> _mazes;
	HashMap<String,Solution<Position>> _solutions;
	Controller controller;
	
	public MyModel() {
		super();
		this._mazes = new HashMap<String,SearchableMaze>();
		this._solutions = new HashMap<String,Solution<Position>>();
	}

	@Override
	public void generate(String name, int x, int y, int z) 
	{
		new Thread(new Runnable() {
			@Override
			public void run() {
				_mazes.put(name,new SearchableMaze(new MyMaze3dGenerator().generate(x, y, z)));
				controller.PleaseTellView("your glorious " + name + " is ready sire !");
			    }
			  }).start();		
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Object[] display(String name) {
		Object[] arg = {_mazes.get(name)._newMaze.getXLength(),
						_mazes.get(name)._newMaze.getYLength(),
						_mazes.get(name)._newMaze.getZLength(),
						_mazes.get(name)._newMaze.get_maze3d(),
						_mazes.get(name)._newMaze.getStartPosition(),
						_mazes.get(name)._newMaze.getGoalPosition()};
		return arg;
	}

	@Override
	public Object getCrossSection(String name, char dim, int index) throws ArrayIndexOutOfBoundsException
	{
		switch (dim) {
        case 'x':  return (Object)_mazes.get(name)._newMaze.getCrossSectionByX(index);
        case 'y':  return (Object)_mazes.get(name)._newMaze.getCrossSectionByY(index);
        case 'z':  return (Object)_mazes.get(name)._newMaze.getCrossSectionByZ(index);
        default: return null;
		   }
	}

	@Override
	public void save(String name, String path) throws FileNotFoundException 
	{
		OutputStream out=new MyCompressorOutputStream(new FileOutputStream(path));
		try {
			out.write(_mazes.get(name)._newMaze.toByteArray());
			out.flush();
			out.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Override
	public void load(String name, String path) throws IOException {
		InputStream in;
		try 
		{
			in = new MyDecompressorInputStream(new FileInputStream(path));
			ArrayList<Integer> buff = new ArrayList<Integer>();
			int current = in.read();
			while (current != -1)
			{
			 buff.add(current);
			 current = in.read();
			}
			in.close();
			byte fileData[]=new byte[buff.size()];
			for ( int i = 0 ; i < buff.size() ; i ++ )
				fileData[i] = buff.get(i).byteValue();
			_mazes.put(name, new SearchableMaze(new Maze3d(fileData)));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public int mazeSize(String name) 
	{
		return _mazes.get(name)._newMaze.size();
	}

	@Override
	public int fileSize(String name) {
		File f = new File(name);
		return (int) f.length();
	}

	@Override
	public void solve(String name,String alg) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Searcher<Position> searcher = null;
				switch (alg) {
		    case "bfs": 
		    	searcher = new SearcherBFS<Position>();
		    case "man":  
		    	searcher = new SearcherAStar<Position>(new HeuristicManhattan());
		    case "air":  
		    	searcher = new SearcherAStar<Position>(new HeuristicAirLine());
			   }
			_solutions.put(name, searcher.search(_mazes.get(name)));
				controller.PleaseTellView("sire, i have unraveled your " + name + " punishment !");
			    }
			  }).start();		

	}

	@Override
	public Solution<Position> displaySolution(String name) {
		return _solutions.get(name);
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
