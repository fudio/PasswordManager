package Storage;

import java.sql.Date;
import java.util.Calendar;

public class Statistics implements java.lang.Comparable<Statistics> {

	public static void main(String[] args) {
		Statistics t = new Statistics(new Date(1), 0);
	}

	private int count;

	private Date createDate;

	public Statistics() {
	}

	public Statistics(Date createDate, int count) {
		this.createDate = createDate;
		this.count = count;
	}

	public void setDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.createDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		this.createDate = new Date(cal.getTime().getTime());
	}

	@Override
	public int compareTo(Statistics o) {
		return this.getCreateDate().compareTo(o.getCreateDate());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		final Statistics other = (Statistics) obj;
		if ((this.createDate == null) ? (other.createDate != null) : !this.createDate.equals(other.createDate)) {
			return false;
		}

		return true;
	}

	public int getCount() {
		return count;
	}

	public Date getCreateDate() {
		return createDate;
	}
}
