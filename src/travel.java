
public class travel {
	private String startingState;
	private String lastgState;
	private int hour;
	private int minute;
	
	
	public travel(String startingState , String lastState , int hour , int minute) {
	
		this.lastgState = lastState;
		this.startingState = startingState;
		this.hour = hour;
		this.minute = minute;
		
		
		
		
	}


	@Override
	public String toString() {
		return "travel [startingState=" + startingState + ", lastgState="
				+ lastgState + ", hour=" + hour + ", minute=" + minute + "]";
	}
	

}
