package FHMDS;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import FHMDS.ds.AlgoFHM_DS;



/**
 * This example shows how to use the FHM-DS algorithm using the source code of SPMF.
 * @author Siddharth Dawar et al.
 *
 */
public class MainTestFHMDS {

	public static void main(String[] args) throws IOException {
		
		String input = ".//retail1.txt";
		String output = ".//output.txt";

		int min_utility = 30;
		float min_Pro = (float) 0.1;
		
		//int k =  5;
		
		// Win size is the number of batches in a window
		int win_size = 2;
		
		// number_of_transactions_batch is the number of transactions in a batch
		int number_of_transactions_batch = 2;

		// Run the algorithm
		AlgoFHM_DS algorithm = new AlgoFHM_DS();
		algorithm.runAlgorithm(
				input,
				//k,
				min_utility,
				min_Pro,
				win_size, 
				number_of_transactions_batch, output);
		
		algorithm.printStats();  

	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestFHMDS.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}

}
