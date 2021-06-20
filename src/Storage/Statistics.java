package Storage;

import static java.lang.Integer.max;
import java.sql.Date;
import java.util.Calendar;

public class Statistics implements java.lang.Comparable<Statistics> {

	public static void main(String[] args) {
		Statistics t = new Statistics(new Date(1), 0);
	}

	private int count;

	private Date createDate;

	private int i;

	public Statistics(Date createDate, int count) {
		this.createDate = createDate;
		this.count = count;
		this.i = 0;
	}

	public Statistics(Date createDate, int count, int i) {
		this.createDate = createDate;
		this.count = count;
		this.i = i;
	}

	public void add(int count_) {
		this.count += count_;
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
		int i_ = max(this.getI(), other.getI());
		switch (i_) {
		case 0:
			if ((this.createDate == null) ? (other.createDate != null) : this.getYear() != other.getYear()) {
				return false;
			}
			break;
		case 1:
			if ((this.createDate == null) ? (other.createDate != null)
					: (this.getYear() != other.getYear() || this.getMonth() != other.getMonth())) {
				return false;
			}
			break;
		case 2:
			if ((this.createDate == null) ? (other.createDate != null)
					: (this.getYear() != other.getYear() || this.getMonth() != other.getMonth()
							|| this.getDay() != other.getDay())) {
				return false;
			}
			break;
		}

		return true;
	}

	public int getCount() {
		return count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	private int getDay() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.createDate);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public int getI() {
		return i;
	}

	private int getMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.createDate);
		return cal.get(Calendar.MONTH);
	}

	private int getYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.createDate);
		return cal.get(Calendar.YEAR);
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

	public void setI(int i_) {
		this.i = i_;
	}

}
