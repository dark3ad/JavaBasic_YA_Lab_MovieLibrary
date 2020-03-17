package affix.java.basic.movie;

import java.io.Serializable;
import java.util.*;


import affix.java.basic.movie.Library;

public class MyLibrary implements Library<Movie>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private List<Movie> items;
	private Map<String, Movie> items;


	public MyLibrary() {
		//		items = new ArrayList<>();
		items = new TreeMap<String, Movie>();
	}

	@Override
	public boolean addItem(Movie item) {
		// TODO Auto-generated method stub

		//		movies.putIfAbsent(mvi.getMainActor(),new ArrayList<Movie>());
		//		List<Movie> x = movies.get(mvi.getMainActor());
		//		if(!x.contains(mvi)) {
		//			return movies.get(mvi.getMainActor()).add(mvi);
		//		}
		//		return false;

		Movie oldMovie = items.putIfAbsent(item.getMovieName(), item);

		//		List<Movie> x = item.get(item.getMovieName());
		//		if(!x.contains(item)) {
		//			return item.get(item.getMovieName()).add(item);
		//			return item.get(item.getMovieName());
		//		}
		//		return false;

		return (oldMovie == null)? true: false;
	}
	@Override
	public boolean removeItem(Movie item) {
		// TODO Auto-generated method stub

		Movie oldMovie = items.remove(item.getMovieName());

		//		if(item.getMovieName().equals(null)) {
		//			return false;
		//		} else {
		//
		//			items.remove(item.getMovieName());
		//			return true;
		//		}

		return (oldMovie != null)? true: false;
	}//				String movieIn = new Movie(SwingDateApp.YEAR, SwingDateApp.MONTH, SwingDateApp.DAY);


	@Override
	public int getNoOfItems() {

		return items.size();
	}
	@Override
	public void showLibraryContents() {
		// TODO Auto-generated method stub

		//		Collections.sort(items); *** TREEMAP SORTERAD ***
		for(List<Movie> m: items.values()) {
			System.out.println(m);
		}

	}

	public List<Movie> searchAll() {

		List<Movie> resultList = new ArrayList<>();

		for(Movie m: items.values()) {
			resultList.add(m);
		}


		return resultList;

	}

	public List<Movie> searchItem(String keyword) {

		List<Movie> resultList = new ArrayList<>();


		
			Iterator<String> valueIter = items.keySet().iterator() ;
			while(valueIter.hasNext()) {
				Movie m = items.get(valueIter.next());
				if(m.getMovieName().contains(keyword)) {
					resultList.add(m);
				}
				else if(m.getActor().contains(keyword)) {
					resultList.add(m);
				}
				else if(String.valueOf(m.getYear()).contains(keyword)) {
					resultList.add(m);
				}	
				else if(String.valueOf(m.getLenght()).contains(keyword)) {
					resultList.add(m);
				}
			}
				
		return resultList;
		// TODO Auto-generated method stub

	}

	@Override
	public void storeItemsToTextfile(String filename) {
		// TODO Auto-generated method stub
		MovieIO.storeText(items, filename);

	}
	@Override
	public void readItemsFromTextfile(String filename) {

		List<Movie> movieList = MovieIO.readText(filename);
		
		for(Movie m: movieList) {
			addItem(m);
//			System.out.println(m);
		}
		
	}

	public Movie getItem(int movieId) {

		Iterator<String> movieKeys = items.keySet().iterator();

		while(movieKeys.hasNext()) {

			Iterator<Movie> temp = items.get(movieKeys.next());
			if(((Movie) temp).getElementNo() == movieId) {
				return (Movie) temp;
			}
		}


		return null;

	}
	
	
	public void storeItemsSerialized(String filename) {
		MovieIO.storeObject(items, filename);
	}
	public void readItemsSerialized(String filename) {
		items = MovieIO.readObject(filename);
	}
	
}
