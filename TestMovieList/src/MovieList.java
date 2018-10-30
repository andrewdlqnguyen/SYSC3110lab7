import javax.swing.DefaultListModel;

    public class MovieList {
        
        private DefaultListModel<Movies> movieList;
        
        public MovieList() {
            this.movieList = new DefaultListModel<Movies>();
        }
        
        public int size() {
			return movieList.getSize();
        }

        public void add(Movies newAdd) {
            this.movieList.addElement(newAdd);
        }
        
        public String getMovieList() {
            String result = "";
            for(int i=0; i<movieList.getSize(); i++){
                result += movieList.get(i).getName()+"\r\n";
            }
            return result;
        }
        
        public DefaultListModel<Movies> getMovieListNew() {
            return movieList;
        }
        
        public void setName(int index, String name) {
            movieList.getElementAt(index).setName(name);
        }
        
        public boolean contains(Movies aMovie) {
        	 return movieList.contains(aMovie);
        	}

        public static void main(String[] args){
            System.out.println("Address movieList");
            
            Movies buddy = new Movies("Jimmy");
            Movies buddy2 = new Movies("George");
            Movies buddy3 = new Movies("Susan");
            MovieList newMovieList = new MovieList();
            newMovieList.add(buddy);
            newMovieList.add(buddy2);
            newMovieList.add(buddy3);
            
            gui newgui = new gui(newMovieList);
        }


}