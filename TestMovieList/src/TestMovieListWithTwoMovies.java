import junit.framework.TestCase;

public class TestMovieListWithTwoMovies extends TestCase {
	 
	private MovieList movieList = null;
	private Movies starWars = null;
	private Movies starTrek = null;
	private Movies stargate = null;
	
	protected void setUp() {
		starWars = new Movies("Star Wars");
		starTrek = new Movies("Star Trek");
		stargate = new Movies("StarGate");
		movieList = new MovieList();
		movieList.add(starWars);
		movieList.add(starTrek);
	}
	
	public void testSizeAfterAddingTwo() {
		assertEquals("Size of a two item list should be 2.", 2, movieList.size());
	}
	public void testContents() {
		assertTrue("List should contain starWars.", movieList.contains(starWars));
		assertTrue("List should contain starTrek.", movieList.contains(starTrek));
		assertFalse("List should not contain stargate.", movieList.contains(stargate));
	}
//	public static void main(String[] args) {
//		junit.textui.TestRunner.run(TestMovieListWithTwoMovies.class);
//	}
}