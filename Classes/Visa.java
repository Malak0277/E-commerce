import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class Visa {
	private String Visa_no;
	private int cvv;

	public Visa(){}

	public Visa(String Visa_no, int cvv)
	{
		this.Visa_no = Visa_no;
		this.cvv = cvv;
	}

	public boolean validvisa(int year, int month)
	{
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR)% 100;
		int currentMonth = cal.get(Calendar.MONTH) + 1;

		if (year < currentYear || year > currentYear + 5) {
			return false;
		}
		else if (year == currentYear && month < currentMonth) {
			return false;
		}
		return true;
	}

	public boolean CVV_check(int cvv){
		if(this.cvv == cvv)
			return true;

		return false;
	}

	public String getVisaNumber(){
		return Visa_no;
	}

}