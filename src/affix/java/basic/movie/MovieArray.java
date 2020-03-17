package affix.java.basic.movie;

public class MovieArray {

	// Test of class Movie including implementation of Comparable
	public static void main(String[] args) {

		Movie[] bondMovies = new Movie[12];
		
		bondMovies[0] = new Movie("Dr No", "Sean Connory", 1962, 109);
		bondMovies[1] = new Movie("From Russia with Love", "Sean Connory", 1963, 115);
		bondMovies[2] = new Movie("Goldfinger", "Sean Connory", 1964, 110);
		bondMovies[3] = new Movie("Thunderball", "Sean Connory", 1965, 130);
		bondMovies[4] = new Movie("Live and Let Die", "Roger Moore", 1973, 121);
		bondMovies[5] = new Movie("Moonraker", "Roger Moore", 1979, 126);
		bondMovies[6] = new Movie("Octopussy", "Roger Moore", 1983, 131);
		bondMovies[7] = new Movie("Golden Eye", "Pierce Brosnan", 1995, 130);	
		bondMovies[8] = new Movie("Tomorrow Never Dies", "Pierce Brosnan", 1997, 119);
		bondMovies[9] = new Movie("Casino Royale", "Daniel Craig", 2006, 144);		
		bondMovies[10] = new Movie("Skyfall", "Daniel Craig", 2012, 143);
		bondMovies[11] = new Movie("Spectre", "Daniel Craig", 2015, 148);	
		
//		Arrays.sort(bondMovies);
		
		for(int i=0; i<bondMovies.length; i++){
			System.out.println(bondMovies[i]);
		}
	}

}
