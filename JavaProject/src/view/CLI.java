package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI extends Thread{
	
	protected BufferedReader in;
	protected PrintWriter out;
	HashMap<String,Command> cmdsHM;

	
	public CLI(BufferedReader input,PrintWriter output,HashMap<String,Command> commandsHM){
		in=input;
		out=output;
		cmdsHM=commandsHM;
	}
	
	public void start(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				String line=null;
				try {
					line = in.readLine();
				} 
				catch (IOException e) {
					
					e.printStackTrace();
				}
				while(!line.equals("exit")){
			        Command cmd=cmdsHM.get(line);
			        if (cmd != null)
			        	cmd.doCommand();
			        else
			        	out.write("The option does not exist");
			      }
			    }
			  }).start();


			
		}
	
}
