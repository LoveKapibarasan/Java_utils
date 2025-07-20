package oth.gse.filesystem.impl;

import java.util.ArrayList;
import java.util.List;

import static oth.gse.filesystem.impl.CyclicDependency.cyclicDependencyCheck;


public class Folder extends Resource {

	public Folder(String name) {
		super(name);
	}

	private final List<Resource> contents = new ArrayList<Resource>();

	public List<Resource> getContents() {
		return contents;
	}

	public void addToContents(Resource r) throws CyclicDependency {
		if(r == null){
			System.err.println("Warning: Resource is null");
			return;
		}
		if(this.contents.contains(r)){
			System.err.println("Warning: This resource already belongs to this folder.");
			return;
		}
		cyclicDependencyCheck(r, this);
		this.contents.add(r);
		if(r.getFolder() != this) {
			r.setFolder(this);
		}

	}
}
