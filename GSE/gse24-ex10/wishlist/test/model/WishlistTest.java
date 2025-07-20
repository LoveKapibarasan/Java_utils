package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WishlistTest {
	
	@Test
	public void testSortByPriority() {
		Wishlist wl = new Wishlist();
		wl.setOwner("Tom");
		
		WishlistItem i1 = new WishlistItem();
		i1.setName("Tyrannosaurus Rex");
		i1.setPriority(Priority.NICE_TO_HAVE);
		wl.addItem(i1);
		
		WishlistItem i2 = new WishlistItem();
		i2.setName("Drum set");
		i2.setComment("A real one, not a toy");
		i2.setPriority(Priority.FAVORITE);
		wl.addItem(i2);

		WishlistItem i3 = new WishlistItem();
		i3.setName("Sled");
		i3.setPriority(Priority.MUST_HAVE);
		wl.addItem(i3);
		
		assertEquals(3, wl.getItems().size());
		assertEquals("Tyrannosaurus Rex", wl.getItems().get(0).getName());
		assertEquals("A real one, not a toy", wl.getItems().get(1).getComment());
		assertEquals("Sled", wl.getItems().get(2).getName());

		wl.sortByPriority();
		
		assertEquals(3, wl.getItems().size());
		assertEquals("A real one, not a toy", wl.getItems().get(0).getComment());
		assertEquals("Sled", wl.getItems().get(1).getName());
		assertEquals("Tyrannosaurus Rex", wl.getItems().get(2).getName());
	}
	
	@Test
	public void testSortByName() {
		Wishlist wl = new Wishlist();
		wl.setOwner("Mia");
		
		WishlistItem i1 = new WishlistItem();
		i1.setName("Game of Thrones Season 9");
		i1.setPriority(Priority.MUST_HAVE);
		wl.addItem(i1);
		
		WishlistItem i2 = new WishlistItem();
		i2.setName("Game of Thrones Season 7");
		i2.setPriority(Priority.FAVORITE);
		wl.addItem(i2);

		WishlistItem i3 = new WishlistItem();
		i3.setName("Game of Thrones Season 8");
		i3.setPriority(Priority.MUST_HAVE);
		wl.addItem(i3);
		
		assertEquals(3, wl.getItems().size());
		assertTrue(wl.getItems().get(0).getName().contains("9"));
		assertTrue(wl.getItems().get(1).getName().contains("7"));
		assertTrue(wl.getItems().get(2).getName().contains("8"));

		wl.sortByName();
		
		assertEquals(3, wl.getItems().size());
		assertTrue(wl.getItems().get(0).getName().contains("7"));
		assertTrue(wl.getItems().get(1).getName().contains("8"));
		assertTrue(wl.getItems().get(2).getName().contains("9"));
	}

}
