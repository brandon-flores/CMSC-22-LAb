

/**
 * 
 */
public class Date{

	private int day;
	private int month;
	private int year;

	public Date(){
		this.day = 1;
		this.month = 1;
		this.year = 1000;
	}

	public Date(int y, int m, int d){
		setDay(d);
		setMonth(m);
		setYear(y);
	}

	public void setYear(int y){
		if(y < 1000 || y > 9999){
			throw new IllegalArgumentException("Invalid Year");
		}
		this.year = y;
	}

	public void setMonth(int m){
		if(m < 1 || m >12){
			throw new IllegalArgumentException("Invalid Month");
		}
		this.month = m;
	}

	public void setDay(int d){
		boolean leap = false;
		if(this.year % 100 == 0 && this.year % 400 == 0){
			if(this.month == 2 && d > 29){
				throw new IllegalArgumentException("Invalid Day");
			}
			else leap = true;
		}
		if(this.month <= 7){
			if(this.month == 2 && !leap && d > 29){
				throw new IllegalArgumentException("Invalid Day");
			}
			else{
				if(this.month % 2 == 0 && this.month != 2 && d > 30){
					throw new IllegalArgumentException("Invalid Day");
				}
				if(this.month % 2 != 0 && d > 31){
					throw new IllegalArgumentException("Invalid Day");
				}
			}
		}
		if(this.month > 7){

			if(this.month % 2 == 0 && d > 31){
				throw new IllegalArgumentException("Invalid Day");
			}
			if(this.month % 2 != 0 && d > 30){
				throw new IllegalArgumentException("Invalid Day");
			}
		}
		this.day = d;
	}

	public void setDate(int d, int m, int y){
		setYear(y);
		setMonth(m);
		setDay(d);
	}

	public int getYear(){
		return this.year;
	}

	public int getMonth(){
		return this.month;
	}

	public int getDay(){
		return this.day;
	}

	public String toString(){
		return String.format("%02d/%02d/%02d",this.day, this.month, this.year);
	}


}

