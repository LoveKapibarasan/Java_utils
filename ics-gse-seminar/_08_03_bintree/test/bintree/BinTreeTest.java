package bintree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinTreeTest {
	private BinTree root;
	
	@BeforeEach
	public void before() {
		root = new BinTree("root");
	}
	
	@AfterEach
	public void after() {
		root = null;
	}
		
	@Test
	public void singleToString() {
		assertEquals("(root)", root.toString());
	}
	
	@Test
	public void insertSubtreeLeft() {
		BinTree sub = new BinTree("raat");
		root.insert(sub);
		assertNotNull(root.left);
		assertEquals("raat", root.left.value);		
	}
	
	@Test
	public void insertSubtreeRight() {
		BinTree sub = new BinTree("rwwt");
		root.insert(sub);
		assertNotNull(root.right);
		assertEquals("rwwt", root.right.value);
	}

	@Test
	public void insertText() {
		root.insert("r");
		root.insert("t");
		assertEquals("((r)root(t))", root.toString());
	}
	
	@Test
	public void insertLeftLeft() {
		root.insert("r");
		root.insert("q");
		assertNotNull(root.left);
		assertEquals("r", root.left.value);
		assertNotNull(root.left.left);
		assertEquals("q", root.left.left.value);
	}
	
	@Test
	public void insertRightRight() {
		root.insert("t");
		root.insert("u");
		assertNotNull(root.right);
		assertEquals("t", root.right.value);
		assertNotNull(root.right.right);
		assertEquals("u", root.right.right.value);
	}

	@Test
	public void testContains() {
		root.insert("q");
		root.insert("u");
		assertTrue(root.contains("root"));
		assertFalse(root.contains("nope"));
		assertTrue(root.contains("q"));
		assertFalse(root.contains("t"));
	}

	@Test
	public void testContainsNested() {
		root.insert("r");
		root.insert("q");
		root.insert("t");
		root.insert("u");
		assertTrue(root.contains("root"));
		assertFalse(root.contains("nope"));
		assertTrue(root.contains("r"));
		assertTrue(root.contains("q"));
		assertTrue(root.contains("t"));
		assertTrue(root.contains("u"));
	}
}
