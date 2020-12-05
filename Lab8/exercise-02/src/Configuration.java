import java.util.*;
//added setters, getter, extracted similar code to methods
public class Configuration {
	public int interval;

	public int duration;

	public int departure;

	public void setDeparture(int departure) {
		this.departure = departure;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getInterval() {
		return interval;
	}

	public void load(Properties props) throws ConfigurationException {

		String intervalString = props.getProperty("interval");
		checkNull(intervalString, "monitor interval");
		int intervalValue = Integer.parseInt(intervalString);
		checkValue(intervalValue, "monitor interval > 0");
		setInterval(intervalValue);


		String durationString = props.getProperty("duration");
		checkNull(durationString, "duration");
		int durationValue = Integer.parseInt(durationString);
		checkValue(durationValue, "duration > 0");
		checkReminder(durationValue, "duration % interval");
		setDuration(durationValue);

		String depString = props.getProperty("departure");
		checkNull(depString, "departure offset");
		int depValue = Integer.parseInt(depString);
		checkValue(depValue, "departure > 0");
		checkReminder(depValue,"departure % interval");
		setDeparture(depValue);
	}


	public void checkNull(String valueString, String msg) throws ConfigurationException {
		if (valueString == null) {
			throw new ConfigurationException(msg);
		}
	}

	public void checkValue(int value, String msg) throws ConfigurationException {
		if (value <= 0) {
			throw new ConfigurationException(msg);
		}
	}

	public void checkReminder(int value, String msg) throws ConfigurationException {
		if ((value % getInterval()) != 0) {
			throw new ConfigurationException(msg);
		}
	}
}
