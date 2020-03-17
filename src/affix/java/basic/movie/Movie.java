package affix.java.basic.movie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Movie implements Comparable<Movie>, Iterator<Movie>, List<Movie>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int Min_Year = 1900;
	public static final int Max_Year = 2020;
	public static final int Min_Length = 60;
	private final String movieName;
	private final String actor;
	private final int year;
	private final int lenght;
	private static int id = 0;
	private final int elementNo;

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}


	/**
	 * @return the actor
	 */
	public final String getActor() {
		return actor;
	}


	/**
	 * @return the year
	 */
	public final int getYear() {
		return year;
	}


	/**
	 * @return the lenght
	 */
	public final int getLenght() {
		return lenght;
	}


	public  int getElementNo() {
		return this.elementNo;  

	}
	
	/**
	 * @param name
	 * @param actor
	 * @param year
	 * @param lenght
	 * @param id
	 */
	public Movie(int id, String movieName, String actor, int year, int lenght) {
		super();
		
		if (movieName == null || movieName.isEmpty()) {
			throw new IllegalArgumentException("Title missing");
		}
		else {
			if (actor == null || actor.isEmpty()) {
				throw new IllegalArgumentException("Actor missing");
			}
			else {
				if (year < Min_Year || year > Max_Year) {
					throw new IllegalArgumentException(String.format("Production Year (%d) not Accepted", year));
				}
				else {
					if (lenght < Min_Length) {
						throw new IllegalArgumentException(String.format("Length (%d) is not Accepted", lenght));
					}
				}
			}
			
		}
		
//		elementNo = ++id;
		this.movieName = movieName;
		this.actor = actor;
		this.year = year;
		this.lenght = lenght;
		this.elementNo = id;
		
		Movie.id = id;

	}
	
	public Movie(String movieName, String actor, int year, int lenght) {
//		super();
//		
//		if (movieName == null || movieName.isEmpty()) {
//			throw new IllegalArgumentException("Title missing");
//		}
//		else {
//			if (actor == null || actor.isEmpty()) {
//				throw new IllegalArgumentException("Actor missing");
//			}
//			else {
//				if (year < Min_Year || year > Max_Year) {
//					throw new IllegalArgumentException(String.format("Production Year (%d) not Accepted", year));
//				}
//				else {
//					if (lenght < Min_Length) {
//						throw new IllegalArgumentException(String.format("Length (%d) is not Accepted", lenght));
//					}
//				}
//			}
//			
//		}
//		
//		elementNo = ++id;
//		this.movieName = movieName;
//		this.actor = actor;
//		this.year = year;
//		this.lenght = lenght;
		this(++id, movieName, actor, year, lenght);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + lenght;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + year;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (lenght != other.lenght)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (year != other.year)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format("Movie id=%d, name=%s, actor=%s, year=%d, lenght=%d.", elementNo, movieName, actor, year,
				lenght);
	}


	public int compareTo(Movie that) {


		int y, n;

		n = this.movieName.compareTo(that.movieName);
		if (n != 0) {
			return n;
		} else {
			y = this.year - that.year;
			if (y != 0) return y;			   
		}

		return Integer.compare(n, y);
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		
		oos.defaultWriteObject();
		oos.writeInt(id);
		System.out.println("DEBUG: passed writeObject(Movie)");
	}
	private void readObject(ObjectInputStream ois) throws Exception {
		
		ois.defaultReadObject();
		id = ois.readInt();
		System.out.println("DEBUG: passed readObject(Movie)");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterator<Movie> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean add(Movie e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(Collection<? extends Movie> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addAll(int index, Collection<? extends Movie> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Movie get(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Movie set(int index, Movie element) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void add(int index, Movie element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Movie remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ListIterator<Movie> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListIterator<Movie> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Movie> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Movie next() {
		// TODO Auto-generated method stub
		return null;
	}

}
