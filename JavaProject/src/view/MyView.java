package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;;

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
		
	}

	@Override
	public void displayMaze(Object[] obj){
		
	}
	
	@Override
	public void displayCrossSection(int[][] array){
		
	}
	
	@Override
	public void displayMazeSize(int size){
		
	}
	
	@Override
	public void displayFileSize(int size){
		
	}
	
	@Override
	public void displaySolution(String solution){
		
	}
		
		
	
	}

