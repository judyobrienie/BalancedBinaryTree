package controllers;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import utils.Serializer;

public class DictionaryAPI  {

	private Serializer serializer;

    public Map<String, String> dictionary = new TreeMap<>();
    
   // MaxHeap maxHeap = new MaxHeap();
   BalancedBinaryTree sbbst = new BalancedBinaryTree();

    public  DictionaryAPI(Serializer serializer)throws Exception {

		this.serializer = serializer; 

	}

	/**
	 * @param an empty Constructor 
	 */
	public DictionaryAPI() {

	}


	/**
	 * @param load from xml file 
	 */
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		//maxHeap = (MaxHeap) serializer.pop();
		dictionary = (Map<String, String>) serializer.pop();
		

	}

	/**
	 * @param save to xml file

	 */


	public void store() throws Exception
	{

		serializer.push(dictionary);
		//serializer.push(maxHeap);
		serializer.write(); 


	}

	
	
	/**
	 *@param loadDefaultfiles external files with dictionary data
	 *@return populated   hashtree of dictionary 
	 */

	public void loadDefaultFiles() throws FileNotFoundException{

		File usersFile = new File("../BalancedBinaryTree/lib/Spanish.txt");
		Scanner inUsers = new Scanner(usersFile);
		String delims = "\t";//each field in the file is separated(delimited) by a space.
		while (inUsers.hasNextLine()) {
			// get name and meaning from data source
			String userDetails = inUsers.nextLine();
			userDetails=userDetails.trim();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			Item items = new Item(userTokens[0],userTokens[1]);


			dictionary.put((userTokens[0]),userTokens[1]);
	
			
			//maxHeap.add(items);
			sbbst.insert(items);
		}
		inUsers.close();


	}
}

