package affix.java.basic.movie;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;


public class MovieLibraryGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// GUI containers and components
	private JPanel infoPanel = new JPanel();
	
	private JPanel upperPanel = new JPanel();

	private JLabel movieJL = new JLabel(" Movie Title");
	private JLabel actorJL = new JLabel(" Actor");
	private JLabel yearJL = new JLabel(" Year");
	private JLabel lenghtJL = new JLabel(" Length");

	private JTextField movieJTF = new JTextField();
	private JTextField actorJTF = new JTextField();
	private JTextField yearJTF = new JTextField();
	private JTextField lenghtJTF = new JTextField();

	private JPanel outputPanel = new JPanel();
	private JTextArea outputText = new JTextArea(20,60);
	
	
	private JPanel controlPanel = new JPanel();
	
	private JButton showJB = new JButton("Show");
	private JButton addJB = new JButton("Add");
	private JButton removeJB = new JButton("Remove");
	private JButton searchJB = new JButton("Search");
	private JButton storeJB = new JButton("Store");
	private JButton readJB = new JButton("Read");
	private JButton clearJB = new JButton("Clear");
	private JButton exitJB = new JButton("Exit");

	private Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	
	// model reference
	MyLibrary theModel =  new MyLibrary();
	Movie items = null;
	
	public MovieLibraryGUI(MyLibrary model) {
		
		theModel = model;
		
		// define layout for Frame
		this.setLayout(new BorderLayout());
		
		// set layout for infoPanel
		infoPanel.setLayout(new GridLayout(2, 3));
		infoPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Movie Library GUI"));
		
		// set layout for upperPanel
		upperPanel.setLayout(new GridLayout(4, 2));
		
		// set layout for upperPanel
		outputPanel.setLayout(new FlowLayout());
		
		// add labels to panel
		movieJL.setHorizontalAlignment(JLabel.LEFT);
		upperPanel.add(movieJL);
		movieJTF.setHorizontalAlignment(JTextField.LEFT);
		upperPanel.add(movieJTF);
		actorJL.setHorizontalAlignment(JLabel.LEFT);
		upperPanel.add(actorJL);
		actorJTF.setHorizontalAlignment(JTextField.LEFT);
		upperPanel.add(actorJTF);
		yearJL.setHorizontalAlignment(JLabel.LEFT);
		upperPanel.add(yearJL);
		yearJTF.setHorizontalAlignment(JTextField.LEFT);
		upperPanel.add(yearJTF);
		lenghtJL.setHorizontalAlignment(JLabel.LEFT);
		upperPanel.add(lenghtJL);
		lenghtJTF.setHorizontalAlignment(JTextField.LEFT);
		upperPanel.add(lenghtJTF);
		

		outputPanel.add(outputText);
		
		// add infoPanel to main panel
		this.add(upperPanel, BorderLayout.NORTH);
		this.add(outputPanel, BorderLayout.CENTER);
		
		
		// set layout for controlPanel
		controlPanel.setLayout(new FlowLayout());
		
		// arm buttons, add them to controlPanel
		showJB.addActionListener(new AppActionListener());
		controlPanel.add(showJB);
		
		addJB.addActionListener(new AppActionListener());
		controlPanel.add(addJB);
		
		removeJB.addActionListener(new AppActionListener());
		controlPanel.add(removeJB);

		searchJB.addActionListener(new AppActionListener());
		controlPanel.add(searchJB);
		
		storeJB.addActionListener(new AppActionListener());
		controlPanel.add(storeJB);
		
		readJB.addActionListener(new AppActionListener());
		controlPanel.add(readJB);
		
		clearJB.addActionListener(new AppActionListener());
		controlPanel.add(clearJB);
		
		exitJB.addActionListener(new AppActionListener());
		controlPanel.add(exitJB);
		
		// add controlPanel to main panel
		this.add(controlPanel, BorderLayout.SOUTH);
		
		// force user to exit application via button
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);		
	}
	

	/**
	 * Inner class handling user interactions via buttons
	 *
	 */
	class AppActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			JButton trigger = (JButton)ae.getSource();
			
			switch(trigger.getText()) {

			
			case "Show":
				List<Movie> resultser = theModel.searchAll();

				outputText.setText("");

				for (Movie m: resultser) {
					outputText.append(m.toString());
					outputText.append(System.getProperty("line.separator"));
				}
				
				break;
				
			case "Add":
				
				String movie = movieJTF.getText().strip();
				String actor = actorJTF.getText().strip();
				String year = yearJTF.getText().strip();
				String lenght = lenghtJTF.getText().strip();
				
				if(actor.isEmpty()) actor = "unknown";
				if(year.isEmpty()) year = "2000";
				if(lenght.isEmpty()) lenght = "999";

				items = new Movie(movie, actor, Integer.parseInt(year), Integer.parseInt(lenght));
				theModel.addItem(items);
				
				List<Movie> resultserz = theModel.searchAll();

				outputText.setText("");

				for (Movie m: resultserz) {
					outputText.append(m.toString());
					outputText.append(System.getProperty("line.separator"));
				}
				
				break;
				
			case "Remove":
				
				System.out.println("Enter id as number: ");
				String id = JOptionPane.showInputDialog(null,"Enter id as number: ",
						"REMOVE MOVIE", JOptionPane.PLAIN_MESSAGE);
				
				int movieId = 0;

				try {
					movieId = Integer.parseInt(id);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				items = theModel.getItem(movieId);
				theModel.removeItem(items);
				
				List<Movie> resultser2 = theModel.searchAll();

				outputText.setText("");

				for (Movie m: resultser2) {
					outputText.append(m.toString());
					outputText.append(System.getProperty("line.separator"));
				}

				break;
				
			case "Search":

				
				String movieKeyword = JOptionPane.showInputDialog(null,"Enter a search keyword: ",
						"SEARCH MOVIE", JOptionPane.PLAIN_MESSAGE);

				List<Movie> resultsSearch = theModel.searchItem(movieKeyword);
				
				outputText.setText("");

				for (Movie m: resultsSearch) {
					outputText.append(m.toString());
					outputText.append(System.getProperty("line.separator"));
				}
				
				break;
				
			case "Store":
				theModel.storeItemsToTextfile("Movies.txt");		
				break;
				
			case "Read":
				theModel.readItemsFromTextfile("Movies.txt");					
				List<Movie> resultsers = theModel.searchAll();

				outputText.setText("");
				for (Movie m: resultsers) {
					outputText.append(m.toString());
					outputText.append(System.getProperty("line.separator"));
				}
				
				break;
				
			case "Clear":
				outputText.setText("");

				break;
				
			case "Exit":
				System.exit(0);
				break;
			
			}	
			// trigger update of the GUI when model has changed
			updateGUI();
		}	
	}
	
	/**
	 * This method will read model attributes and force a visual update
	 */
	private void updateGUI() {
//		movieJTF.setText(String.valueOf(theModel.getYear()));
//		monthJTF.setText(String.valueOf(theModel.getMonth()));
//		dayJTF.setText(String.valueOf(theModel.getDay()));
	}
}
