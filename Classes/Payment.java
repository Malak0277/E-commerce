import java.time.Year;
import java.util.Calendar;

public class Payment {
    public String visa_holder_name;
	public String Visa_no;
	public int month;
	public int year;
	public int cvv;
	
	public Payment(String visa_holder_name, String Visa_no, int month, int year, int cvv)
	{
		this.visa_holder_name = visa_holder_name;
		this.Visa_no = Visa_no;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
	}
	
	public boolean validvisa()
	{
		Calendar cal = Calendar.getInstance();
		if (this.year < cal.get(Calendar.YEAR))
			return true;
		
		else if(this.year == Year.now().getValue())
			if(this.month < cal.get(Calendar.MONTH))
				return true;
		
		return false;
	}
	
	public boolean addVisa(String visa_holder_name, String Visa_no, int month, int year, int cvv)
	{
		if(this.validvisa())
		{
			new Payment(visa_holder_name, Visa_no, month, year, cvv);
			return true;
		}
		
		return false;		
	}
	
	/*public String[] get_Visas()
	{
		String [] info = {this.Visa_no};
		
		return info;
	}
	
	public boolean CVV_check(int cvv, String Visa_no)
	{
		if(cvv == this.cvv)
			return true;
		
		return false;
	}*/
}
