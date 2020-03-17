/**
 * JavaBasic
 * Chapter 8 - I/O
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package affix.java.basic.movie;

import java.io.*;
import java.util.*;


/**
 * Support class for storing/retrieving WeatherData to/from streams
 */
public class MovieIO {

	// store data in a text file
	public static void storeText(Map<String, Movie> items, String filename){

		try(PrintWriter pw = new PrintWriter(new FileWriter(filename))){			
			for(Movie mv : items.values()){
				pw.println(mv);
			}
		} 
		catch (IOException ioe) {
			System.out.println("Exception occurred: " + ioe);
		}

	}

	// read data from a text file
	public static List<Movie> readText(String filename){

		List<Movie> movieList = new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			while(br.ready()){
				String movieString = br.readLine();			
				Movie mv = parseData(movieString);
				movieList.add(mv);
			}
		} 
		catch (IOException ioe) {
			System.out.println("Exception occurred: " + ioe);
		}

		return movieList;
	}

	// store data in file using serialization     List<Movie> movieList = new ArrayList<>();
	public static void storeObject(Map<String, Movie> items, String filename){

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(items);			
		}
		// handle any exception
		catch(IOException ioe){
			System.out.println("Exception occurred: " + ioe);
		}
	}
	
	// read data from file using deserialization
	@SuppressWarnings("unchecked")
	public static Map<String, Movie> readObject(String filename){
		
		Map<String, Movie> movieList = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			movieList = (Map<String, Movie>)ois.readObject();
		}
		// handle any exception
		catch(IOException | ClassNotFoundException ioe){
			System.out.println("Exception occurred: " + ioe);
		} 
		
//		presentFileContents(movieList);
		return (Map<String, Movie>) movieList;
	}
	
	static void presentFileContents(Map<String, Movie> fileData){

		System.out.println("---------------------------------------------------");
		for(List<Movie> mv : fileData.values()){
			System.out.println(mv);			
		}
//		for(List<Movie> m: items.values()) {
//			System.out.println(m);
//		}
		
	}
	
	// format MovieData String.format("Movie id=%d name=%s, actor=%s, year=%d, lenght=%d.", elementNo, movieName, actor, year,
//	lenght);]
	private static Movie parseData(String movieString) {

		String[] parts = movieString.substring(movieString.indexOf("id=")).split(",");

		String myId = parts[0].trim();
		StringTokenizer str0 = 
	             new StringTokenizer(myId, "="); 

		String temp = null;
		
		 while (str0.hasMoreTokens()) {
			 temp = str0.nextToken();		 
		 }  myId = temp; temp = null;
		 int id = Integer.parseInt(myId);
		 

			 	 
		String movieName = parts[1].trim();
		StringTokenizer str1 = 
	             new StringTokenizer(movieName, "="); 

//		String temp = null;
		 while (str1.hasMoreTokens()) {
			 temp = str1.nextToken();		 
		 }  movieName = temp; temp = null;


		
		String actor = parts[2].trim();	
		StringTokenizer str2 = 
	             new StringTokenizer(actor, "="); 
		 while (str2.hasMoreTokens()) {
			 temp = str2.nextToken();		 
		 }  actor = temp; temp = null;


		String mvYear = parts[3].trim();	
		
		StringTokenizer str3 = 
	             new StringTokenizer(mvYear, "="); 
		 while (str3.hasMoreTokens()) {
			 temp = str3.nextToken();		 
		 }  mvYear = temp; temp = null;
		 int year = Integer.parseInt(mvYear);
		 

		String mvLenght = parts[4].trim();
		mvLenght = mvLenght.replace('.', ' ').trim();
		StringTokenizer str4 = 
	             new StringTokenizer(mvLenght, "="); 
		 while (str4.hasMoreTokens()) {
			 temp = str4.nextToken();		 
		 }  mvLenght = temp; temp = null;
		 int lenght = Integer.parseInt(mvLenght);
	

		Movie mv = new Movie(id, movieName, actor, year, lenght);

		return mv;
	}


}

