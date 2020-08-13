
public class travel {
	private String startingState;
	private String lastgState;
	private int hour;
	private int minute;

	public travel(String startingState, String lastState, int hour, int minute) {

		this.lastgState = lastState;
		this.startingState = startingState;
		this.hour = hour;
		this.minute = minute;

	}

	@Override
	public String toString() {
		return "travel [Starting State=" + startingState + ", Lastg State=" + lastgState + ", Departure time = " + hour +":" + minute + "] \n";
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

}
