package People;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonStreamParser;

public class Record {
	public static boolean addRecord(Profile person,String quakeName){
		/*try{
			File records = new File("allRecords.ser");
			if(!records.exists()){
				records.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(records,true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(person);
			oos.flush();
			fos.close();
			oos.close();
			return true;
		}catch(Exception e){
			System.out.println("Exception is caught" + e);
			return false;
		}*/
		Gson gson = new Gson();
		String stringForObject = gson.toJson(person);
		try {  
			   //write converted json data to a file named "quakeNameGSON.json" 
				quakeName+="GSON.json";
			   FileWriter writer = new FileWriter(quakeName,true);//add true here  
			   writer.write(stringForObject);  
			   writer.close();  
			   return true;
		} catch (Exception e) {
			System.out.println("Caught Exception while writing GSon");
			   //e.printStackTrace();
			return false;
	   }  
	}
	public static ArrayList<Profile> searchRecord(Profile partial,String quakeName){
		long partialHash=0;
		long factor = 2;
		String partialName = partial.getName().toUpperCase();
		int i=0;
		while(i<partialName.length()){
			partialHash+=(factor*((int)(partialName.charAt(i))));
			factor*=2;
			i++;
		}
		/*File records = new File("allRecords.ser");
		if(!records.exists()){
			//there is no list so arraylist is null
			return null;
		}*/
		// create a empty list
		ArrayList<Profile> potentialMatches = new ArrayList<Profile>();
		//read records
		Profile person;
		/*try{
			FileInputStream fis = new FileInputStream(records);
			ObjectInputStream ois = null;
			try{
				ois = new ObjectInputStream(fis);
				while(true){
					System.out.println("Read Now");
					person = (Profile) ois.readObject();
					person.print();
					if(partialHash==person.hash){
						if(partial.name.equals(person.name)){
							potentialMatches.add(person);
						}
					}
						
				}
			}catch(Exception e){
				System.out.println("caught exception " + e);
				e.printStackTrace();
				ois.close();
			}	
		}catch(Exception e){
			
		}*/
	  Gson gson = new Gson();  

	  try {
		  quakeName+="GSON.json";
		  File file = new File(quakeName);
		  if(!file.exists()){
			  // there is no record
			  System.out.println("File does not exists");
			  return null;
		  }
		JsonStreamParser parser = new JsonStreamParser(new FileReader(quakeName));
		while(parser.hasNext()){
			person = gson.fromJson(parser.next(), Profile.class);
			//System.out.println(partialHash+" != "+person.hash);
			if(partialHash==person.hash){
				 
				person.print();
				if(partial.name.equalsIgnoreCase(person.name)){
					potentialMatches.add(person);
				}
			}
		}
	} catch (FileNotFoundException e) {
		System.out.println("Exception during reading");
		//e.printStackTrace();
	}

		return potentialMatches;
	}
}
