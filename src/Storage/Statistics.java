package Storage;

import java.sql.Date;

public class Statistics {
	private Date createDate;
	private int count;

	public Statistics(Date createDate, int count) {
		super();
		this.createDate = createDate;
		this.count = count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getCount() {
		return count;
	}

}
