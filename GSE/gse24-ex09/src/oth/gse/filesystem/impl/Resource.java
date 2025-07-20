package oth.gse.filesystem.impl;

import static oth.gse.filesystem.impl.CyclicDependency.cyclicDependencyCheck;

public abstract class Resource {
	//fields
	private final String name;
	private FileSystem fileSystem;
	private Folder folder;
	
	public Resource(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public FileSystem getFileSystem() {
		return fileSystem;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFileSystem(FileSystem fs) {
		// resource -> fs
		if(this.fileSystem == fs){
			System.err.println("Warning: File system is already set");
			return;
		}
		//Exclusive, belong to only one FileSystem
		if(this.fileSystem != null){
			System.err.println("Warning: This resource already belongs to a file system.");
			this.fileSystem.roots.remove(this);
		}
		this.fileSystem = fs;
		// fs -> resource
		if (this.fileSystem.getRoots().isEmpty()) { // Because of the requirement, make root
			fs.addToRoots( this);
			if(this.folder != null){
				this.folder.getContents().remove(this);
				this.folder = null;
			}
		}
	}

	public void setFolder(Folder f) throws CyclicDependency {
		if(f == null){
			System.err.println("Warning: Folder is null");
			return;
		}
		cyclicDependencyCheck(this,f);
		if(this.folder == f){
			System.err.println("Warning: Folder is already set");
			return;
		}
		if(this.fileSystem != null){
			System.err.println("Warning: This resource already belongs to a file system.");
			this.fileSystem.getRoots().remove(this);
			this.fileSystem = null;
		}
		// Exclusive, belong to only one folder
		if(this.folder != null){
			System.err.println("Warning: Folder is already set by another folder.");
			this.folder.getContents().remove(this);
		}
		this.folder = f;
		if(!f.getContents().contains(this)) {
			f.addToContents(this);
		}
	}
}
