package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;
import controller.MyController;
import general.Position;
import general.Solution;
import general.State;

public class MyView implements View
{
	CLI cli;
	Controller controller;
	
	public void setCLI(HashMap<String,Command> cmdsHM) {
		cli=new CLI(new BufferedReader(new InputStreamReader(System.in)), 
				new PrintWriter(new OutputStreamWriter(System.out)), cmdsHM);
		
	}
	
	public void setController(Controller c){
		controller=c;
		setCLI(controller.getCommands());
	}


	@Override
	public void Dir(String path) {
	File currentFolder=new File(path);
		try{
			for (File obj :currentFolder.listFiles()){
				System.out.println(obj.getName());
			
			}
		}
		catch (NullPointerException e) {
			System.out.println("Path is not exist");
		}
	}
	
	@Override
	public void display(Object[] arg){
		System.out.println(arg);
	}

	@Override
	public void displayMaze(Object[] obj){
		System.out.println(obj);
	}
	
	@Override
	public void displayCrossSection(Object[] array){
			for (int[] row: (int[][])array)
				System.out.println(java.util.Arrays.toString(row));
				System.out.println();
	}
	
	@Override
	public void displayMazeSize(int size){
		System.out.println("Maze size is : " + size);
	}
	
	@Override
	public void displayFileSize(int size){
		System.out.println("File size is : " + size);
	}
	
	@Override
	public void displaySolution(Solution<Position> solution){
		
	}
	
	public void startCLI(){
		cli.start();
	}
		
		
	
	}

