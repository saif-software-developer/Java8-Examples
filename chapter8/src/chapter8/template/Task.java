package chapter8.template;

public class Task {

	private String id;
	private int progress;
	
	public Task(String id, int progress) {
		super();
		this.id = id;
		this.progress = progress;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
}
