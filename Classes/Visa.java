import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class Visa {
    private String visa_holder_name;
	private String Visa_no;
	private int month;
	private int year;
	private int cvv;
	
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
	
	public boolean validvisa()
	{
		Calendar cal = Calendar.getInstance();
		if (this.year < cal.get(Calendar.YEAR))
			return false;
		
		else if(this.year == Year.now().getValue())
			if(this.month < cal.get(Calendar.MONTH))
				return false;
		
		return true;
	}
	
	public boolean addVisa(String visa_holder_name, String Visa_no, int month, int year, int cvv)
	{
		if(this.validvisa())
		{
			Visa v = new Visa(visa_holder_name, Visa_no, month, year, cvv);
			AllVisas.add(v);
			return true;
		}
		return false;		
	}
	
	public visa get_Visas(String visano)
	{
		Visa foundvisaa;
		for( Visa v : AllVisas)
		{
			if (v.getvisano().equalsIgnoreCase(visano)) 
			{
                foundvisaa = v;
                break;
            }
		}
		return visaa;
	}
	
	public boolean CVV_check(int cvv, String Visa_no){
		Visa v = get_Visas(Visa_no);
		if(v != null){
			if(cvv == v.getcvv())
				return true;
		}
		return false;
	}

	public String getvisano(){
		return Visa_no;
	}

	public int getcvv(){
		return cvv;
	}
}
