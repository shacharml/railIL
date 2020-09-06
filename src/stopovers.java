
public class stopovers {
private String name; 
private int hour;
private int minute;

public stopovers(String name, int hour, int minute) {

	this.name = name;
	this.hour = hour;
	this.minute=minute;
}

@Override
public String toString() {
	String st= " [name=" + name + ",  "+show()+"]\n";
	return st;
}

public String show() {
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
