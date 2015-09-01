package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Model {
	public void generate(String name,int x,int y,int z);
	public InputStream display(String name);
	public int[][] getCrossSection(String name,char dim,int index);
	public void save(String name, String path) throws FileNotFoundException;
	public void load(String name,String path) throws FileNotFoundException, IOException;
	public int mazeSize(String name);
	public int fileSize(String name);
	public void solve(String name,String alg);
	public String displaySolution(String name);
	public void exit();
}
