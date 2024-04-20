import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class Visa {
	private String visa_holder_name;
	private String Visa_no;
	private int month;
	private int year;
	private int cvv;
	private User user;

	private ArrayList<Visa> AllVisas;

	public Visa(){}

	public Visa(String visa_holder_name, String Visa_no, int month, int year, int cvv)
	{
		this.visa_holder_name = visa_holder_name;
		this.Visa_no = Visa_no;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
	}

	public boolean validvisa(int year, int month)
	{
		Calendar cal = Calendar.getInstance();
		if (year < cal.get(Calendar.YEAR))
			return false;
		else if (year > cal.get(Calendar.YEAR)+5)
			return true;
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

	public Visa get_Visas(String visano)
	{
		Visa foundvisaa = null;
		for( Visa v : AllVisas)
		{
			if (v.Visa_no .equalsIgnoreCase(visano))
			{
				foundvisaa = v;
				break;
			}
		}
		return foundvisaa;
	}

	public boolean CVV_check(int cvv, String Visa_no){
		Visa v = get_Visas(Visa_no);
		if(v != null){
			if(cvv == v.cvv)
				return true;
		}
		return false;
	}
}