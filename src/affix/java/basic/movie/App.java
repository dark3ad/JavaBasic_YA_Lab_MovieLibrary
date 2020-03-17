package affix.java.basic.movie;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class App {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		boolean done = false;
		String choice;

		input.useDelimiter(System.getProperty("line.separator"));

		Library<Movie> lib =  new MyLibrary();

		//		configurator(lib);1

		if(args.length > 0) {
//			File config = new File(cfgFile);
			String cfgFile = args[0];
//			configurator(config);
			lib.readItemsFromTextfile(cfgFile);
			System.out.println();
			System.out.println("Config file loaded from argument(s)");
			System.out.println();
		}
		
		

//		try {
////			lib.readItemsFromTextfile("cfg.txt");
//			((MyLibrary)lib).readItemsSerialized("Movies.ser");
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}


		do {

			System.out.println();
			System.out.println("MovieLibrary");
			System.out.println();
			System.out.println("Menu");		String cfgFile = args[0];

			System.out.println("1 - Present complete contents (LIST)");
			System.out.println("2 - Add Movie to library (ADD)");
			System.out.println("3 - Remove Movie from library (REMOVE)");
			System.out.println("4 - Search for a Movie in library (SEARCH)");
			System.out.println("5 - Store current library contents in textfile (TXT-READ)");
			System.out.println("6 - Read contents from textfile to library (TXT-WRITE)");
			System.out.println("7 - Store current library contents in serialized file (SER.-READ)");
			System.out.println("8 - Read contents from serialized file to library (SER.-WRITE)");
			System.out.println("9 - START GUI VERSION");
			System.out.println("0 - Exit");

			System.out.print("Enter your choice: ");

			choice = input.next();

			Movie items = null;

			switch(choice) {

			case "1":
				lib.showLibraryContents();
				break;

			case "2":
				items = createItem();
				lib.addItem(items);
				break;

			case "3":
				lib.showLibraryContents();
				System.out.println("Enter id as number: ");

				String id = input.next();
				int movieId = 0;

				try {
					movieId = Integer.parseInt(id);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				items = lib.getItem(movieId);
				lib.removeItem(items);
				break;


			case "4":
				
				System.out.format("Enter a search keyword: ");
				String keyword = App.input.next();	
				
				List<Movie> results = lib.searchItem(keyword);
				for (Movie m: results) {
					System.out.println(m);
				}
				break;

			case "5":
				System.out.println("Store MovieData in textfile");
				lib.storeItemsToTextfile("Movies.txt");					
				break;

			case "6":
				System.out.println("MovieData import fro\n" + 
						"//m textfile");
				lib.readItemsFromTextfile("Movies.txt");					
				lib.showLibraryContents();
				break;

			case "7":
				System.out.println("Store MovieData in serialized file");
				((MyLibrary)lib).storeItemsSerialized("Movies.ser");
				break;

			case "8":
				System.out.println("MovieData import from serialized file");
				((MyLibrary)lib).readItemsSerialized("Movies.ser");
				break;

			case "9":
				MovieGUI();
				break;
				
			case "0":
				done = true;
				System.out.println("Program terminated.");
				break;

			default:
				System.out.println("Entered choice is not valid!");
				break;

			}

		} while (!done);

	}


	private static Movie createItem() {
		
		System.out.print("\nEnter title of Movie: ");
		String movieName = input.next();

		System.out.print("\nEnter main actor: ");
		String actor = input.next();

		System.out.print("\nEnter year of production: ");
		int year = input.nextInt();

		System.out.print("\nEnter length in minutes: ");
		int length = input.nextInt();

		Movie m = new Movie(movieName, actor, year, length);

		return m;
	}


	public static void MovieGUI(){
    	
    	Runnable guiRun=new Runnable(){
    		public void run(){
    			MyLibrary model = new MyLibrary();
    			model.readItemsFromTextfile("cfg.txt");
    	        JFrame jf=new MovieLibraryGUI(model);
    	        jf.setTitle("Movie Library GUI");
    	        jf.pack();
    	        jf.setVisible(true);    			
    		}
    	};
    	SwingUtilities.invokeLater(guiRun);
    }
	
}

