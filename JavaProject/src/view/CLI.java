/**
* <h1>The Class CLI</h1>
* The command line class 
*
* @author  Omri Polnikviat
* @version 1.0
* @since   2015-08-29 
*/

package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

/**
 * The Class CLI.
 */
public class CLI extends Thread{
	
	/** The input . */
	protected BufferedReader in;
	
	/** The output. */
	protected PrintWriter out;
	
	/** String to Commands HashMap. */
	HashMap<String,Command> cmdsHM;

	
	/**
	 * Instantiates a new cli.
	 *
	 * @param input the input
	 * @param output the output
	 * @param commandsHM the commands hm
	 */
	public CLI(BufferedReader input,PrintWriter output,HashMap<String,Command> commandsHM){
		in=input;
		out=output;
		cmdsHM=commandsHM;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#start()
	 */
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
