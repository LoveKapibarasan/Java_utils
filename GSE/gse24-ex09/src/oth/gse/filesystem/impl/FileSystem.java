package oth.gse.filesystem.impl;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
	
	public List<Resource> roots = new ArrayList<Resource>();
	
	public List<Resource> getRoots() {
		return roots;
	}
	
	public void addToRoots(Resource r) {
		roots.add(r);
		r.setFileSystem(this);
	}
	
	public int nFiles() {
		int result = 0;
		for (Resource r : roots) {
			result += nFiles(r);
		}
		return result;
	}

	private int nFiles(Resource r) {
		if (r instanceof File) {
			return 1;
		} else if (r instanceof Folder) {
			int result = 0;
			for (Resource c : ((Folder) r).getContents()) {
				result += nFiles(c);
			}
			return result;
		} else return 0;
	}

}
