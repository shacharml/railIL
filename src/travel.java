
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
		return "travel [Starting State=" + startingState + ", Lastg State=" + lastgState + ", Departure time = "
				+ show2() + "] \n";
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

	public void show() {

		if (hour < 10) {
			System.out.print("0" + hour);
		}
		if (minute < 10) {
			System.out.print(":0" + minute);
		}

	}

	public String show2() {
		String str = "";
		if (hour < 10) {
			str = "0" + hour + ":";
			if (minute < 10) {
				str += "0" + minute;
			} else {
				str += minute;
			}

		} else if (minute < 10) {
			str = hour + ":0" + minute;

		} else {
			str += hour + ":" + minute;
		}

		return str;

	}

}
