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

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.HeuristicAirLine;
import algorithms.search.HeuristicManhattan;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.SearcherAStar;
import algorithms.search.SearcherBFS;
import algorithms.search.Solution;
import algorithms.search.State;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class MyModel implements Model {

	HashMap<String,SearchableMaze> _mazes;
	HashMap<String,Solution<Position>> _solutions;
	
	public MyModel() {
		super();
		this._mazes = new HashMap<String,SearchableMaze>();
		this._solutions = new HashMap<String,Solution<Position>>();
	}

	@Override
	public void generate(String name, int x, int y, int z) 
	{
		_mazes.put(name,new SearchableMaze(new MyMaze3dGenerator().generate(x, y, z)));
	}

	@Override
	public String display(String name) {
		return _mazes.get(name)._newMaze.toString();
	}

	@Override
	public int[][] getCrossSection(String name, char dim, int index) 
	{
		switch (dim) {
        case 'x':  return _mazes.get(name)._newMaze.getCrossSectionByX(index);
        case 'y':  return _mazes.get(name)._newMaze.getCrossSectionByY(index);
        case 'z':  return _mazes.get(name)._newMaze.getCrossSectionByZ(index);
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
			byte[] fileData = new byte[(int) new File(path).length()];
			in.read(fileData);
			in.close();
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void solve(String name,String alg) {
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
	}

	@Override
	public String displaySolution(String name) {
		return _solutions.get(name).toString();
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
