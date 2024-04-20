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
		if (year < cal.get(Calendar.YEAR))
			return false;
		else if (year > cal.get(Calendar.YEAR)+5)
			return false;
		else if(year == Year.now().getValue())
			if(month < cal.get(Calendar.MONTH))
				return false;

		return true;
	}

	public boolean addVisa(String visa_holder_name, String Visa_no, int month, int year, int cvv)
	{
		if(validvisa(year, month))
		{
			Visa v = new Visa(visa_holder_name, Visa_no, month, year, cvv);
			AllVisas.add(v);
			return true;
		}
		return false;
	}


	public boolean CVV_check(int cvv){
		if(this.cvv == cvv)
			return true;
		
		return false;
	}

	
}