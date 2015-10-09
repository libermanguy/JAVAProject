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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
					String[] splited = line.split(" ");
				    ArrayList<String> stringList =new ArrayList<String>(Arrays.asList(splited));  
					Command cmd=cmdsHM.get(splited[0]);
					System.out.println(stringList.get(0));
					if (cmd!=null){
						stringList.remove(0);
						splited = stringList.toArray(new String[stringList.size()]);
						cmd.doCommand(splited);
					}
					else {
						cmd=cmdsHM.get(stringList.get(0) +" "+stringList.get(1));
						if (cmd!=null){
							stringList.remove(0);
							stringList.remove(1);
							splited = stringList.toArray(new String[stringList.size()]);
							cmd.doCommand(splited);
						}
						else{
							String tempStr=stringList.get(0) +" "+stringList.get(1)+ " "+ stringList.get(2);
							cmd=cmdsHM.get(tempStr);
							if (cmd!=null){

								stringList.remove(1);
								stringList.remove(2);
								if (tempStr.equals("generate 3d maze")){
									splited = stringList.toArray(new String[stringList.size()]);
									cmd.doCommand(splited);
								}
								else{
									stringList.remove(3);
									stringList.remove(6);
									splited = stringList.toArray(new String[stringList.size()]);
									cmd.doCommand(splited);
								}
							}
							else{
								out.write("The command does not exist");
							}
						}	
					
					}
			       	
			      }
				
				if (line.equals("exit")){
					cmdsHM.get("exit").doCommand(null);
				}
			    }
			  }).start();


			
		}
	
}
