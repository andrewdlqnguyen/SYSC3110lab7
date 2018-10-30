
	import java.awt.Container;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JTextArea;
	//import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.io.UnsupportedEncodingException;

	import javax.swing.*;


	public class gui extends JFrame {
		
		JMenu menu1, menu2;
		JMenuBar menuBar;
		JMenuItem createMovieList, saveMovieList, displayMovies, addMovie;
		JTextArea textArea;
		JOptionPane optionPane;
		Container contentPane;
		FlowLayout layout;
		MovieList movieList;

		
		public gui(MovieList theList) {
			super("MovieList GUI");
			this.movieList = theList;
			
			setLocationRelativeTo(null);
			setSize(400, 400);
			layout = new FlowLayout();
			
			contentPane = getContentPane();
			contentPane.setLayout(layout);
			
			//Creating Menu Bar
			menuBar = new JMenuBar();
			
			menu1 = new JMenu("MovieList");
			menu2 = new JMenu("Movies");
			menuBar.add(menu1);
			menuBar.add(menu2);
			
			//List of menu item for AddressBook
			createMovieList = new JMenuItem("Create MovieList");
			saveMovieList = new JMenuItem("Save MovieList");
			displayMovies = new JMenuItem("Display MovieList");
			menu1.add(createMovieList);
			menu1.add(saveMovieList);
			menu1.add(displayMovies);
			
			//List of menu item for BuddyList
			addMovie = new JMenuItem("Add a Movie to Movie List");
			menu2.add(addMovie);
			
			theHandler handler = new theHandler();
			createMovieList.addActionListener(handler);
			saveMovieList.addActionListener(handler);
			displayMovies.addActionListener(handler);
			addMovie.addActionListener(handler);
			saveMovieList.setEnabled(false);
			displayMovies.setEnabled(false);
			addMovie.setEnabled(false);
			
			
			//Setting up final interface
			textArea = new JTextArea(20,30);
			textArea.setEditable(false);
			
			
			contentPane.add(textArea);
			setJMenuBar(menuBar);
			
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		
		private class theHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
		
				if(e.getSource() == createMovieList) {
					System.out.println(e.getActionCommand());
					textArea.setText("MovieList Created");
					createMovieList.setEnabled(false);
					saveMovieList.setEnabled(true);
					displayMovies.setEnabled(true);
					addMovie.setEnabled(true);
				}
				if(e.getSource() == saveMovieList) {
					System.out.println(e.getActionCommand());
					textArea.setText("MovieListSaved Saved!");
						try {
							PrintWriter writer = new PrintWriter("addbookfile.txt", "UTF-8");
							writer.println(movieList.getMovieList());
							writer.close();
						} catch (FileNotFoundException e1) {
							System.out.println("Can't Create File");
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							System.out.println("Unsupported Encoding");
						}	
				}
				if(e.getSource() == displayMovies) {
					System.out.println(e.getActionCommand());
					textArea.setText(movieList.getMovieList());
					//textArea.setText(addressBook.get);
				}
				if(e.getSource() == addMovie) {
					System.out.println(e.getActionCommand());
					String newName = JOptionPane.showInputDialog("Enter Movie Name:");				
					
					movieList.add(new Movies(newName));
				}
			}
		}
	}
