package model;

public class WishlistItem {
	private String name;
	private Priority priority;
	private String comment;
	
	public String getName() {
		return name;
	}
	
	public Priority getPriority() {
		return priority;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
