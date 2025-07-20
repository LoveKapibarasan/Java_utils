package oth.gse.filesystem.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileSystemTest {

	@Test
	public void testNFiles() throws CyclicDependency {
		FileSystem fs = new FileSystem();
		Folder users = new Folder("Users");
		Folder me = new Folder("me");
		Folder pictures = new Folder("Pictures");
		File cat = new File("cat.jpg");
		File vimrc = new File(".vimrc");
		fs.addToRoots(users);
		users.addToContents(me);
		me.addToContents(pictures);
		pictures.addToContents(cat);
		me.addToContents(vimrc);
		assertEquals(2, fs.nFiles());
	}
	
	@Test
	public void testAddToFileSystem() throws CyclicDependency {
		File f = new File("f");
		FileSystem fs = new FileSystem();
		fs.addToRoots(f);
		assertTrue(fs.getRoots().contains(f));
		assertEquals(fs, f.getFileSystem());
		assertNull(f.getFolder());
	}
	
	@Test
	public void testAddToFolder() throws CyclicDependency {
		File f = new File("f");
		Folder fo = new Folder("fo");
		fo.addToContents(f);
		assertTrue(fo.getContents().contains(f));
		assertEquals(fo, f.getFolder());
		assertNull(f.getFileSystem());
	}
	
	@Test
	public void testSetFileSystem() {
		File f = new File("f");
		FileSystem fs = new FileSystem();
		f.setFileSystem(fs);// Shouldn't the FileSystem, not Resource explicitly determine the root?
		assertTrue(fs.getRoots().contains(f));
		assertEquals(fs, f.getFileSystem());
		assertNull(f.getFolder());
	}
	
	@Test
	public void testSetFolder() throws CyclicDependency {
		File f = new File("f");
		Folder fo = new Folder("fo");
		f.setFolder(fo);
		assertTrue(fo.getContents().contains(f));
		assertEquals(fo, f.getFolder());
		assertNull(f.getFileSystem());
	}
	
	@Test
	public void testExclusiveFileSystem() throws CyclicDependency {
		File f = new File("f");
		Folder fo = new Folder("fo");
		f.setFolder(fo);
		
		FileSystem fs1 = new FileSystem();
		f.setFileSystem(fs1);
		assertFalse(fo.getContents().contains(f));
		assertNull(f.getFolder());
		
		FileSystem fs2 = new FileSystem();
		f.setFileSystem(fs2);
		assertFalse(fs1.getRoots().contains(f));
	}
	
	@Test
	public void testExclusiveFolder() throws CyclicDependency {
		File f = new File("f");
		FileSystem fs1 = new FileSystem();
		f.setFileSystem(fs1);
		
		Folder fo1 = new Folder("fo1");
		f.setFolder(fo1);
		assertFalse(fs1.getRoots().contains(f));
		assertNull(f.getFileSystem());
		
		Folder fo2 = new Folder("fo2");
		f.setFolder(fo2);
		assertFalse(fo1.getContents().contains(f));
	}
	
	@Test
	public void testAcyclicity() throws CyclicDependency {
		Folder fo1 = new Folder("fo1");
		Folder fo2 = new Folder("fo2");
		fo1.addToContents(fo2);
		
		assertThrows(CyclicDependency.class, () -> {
			fo2.addToContents(fo1);
		});
		assertThrows(CyclicDependency.class, () -> {
			fo1.setFolder(fo2);
		});
		
		assertNull(fo1.getFolder());
		assertTrue(fo2.getContents().isEmpty());
	}
	
	@Test
	public void testTransitiveAcyclicity() throws CyclicDependency {
		Folder fo1 = new Folder("fo1");
		Folder fo2 = new Folder("fo2");
		Folder fo3 = new Folder("fo3");
		fo1.addToContents(fo2);
		fo2.addToContents(fo3);

		assertThrows(CyclicDependency.class, () -> {
			fo3.addToContents(fo1);
		});
		assertThrows(CyclicDependency.class, () -> {
			fo1.setFolder(fo3);
		});
		
		assertNull(fo1.getFolder());
		assertTrue(fo3.getContents().isEmpty());
	}

}
