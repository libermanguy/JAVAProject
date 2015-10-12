	package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import general.Position;
import general.Solution;

public interface Model {
	public void generate(String name,int x,int y,int z);
	public Object[] display(String name);
	public Object getCrossSection(String name,char dim,int index);
	public void save(String name, String path) throws Exception;
	public void load(String name,String path) throws Exception;
	public int mazeSize(String name);
	public int fileSize(String name);
	public void solve(String name,String alg);
	public Solution<Position> displaySolution(String name);
	public void exit();
}
