package com.example.testingproject;

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

	public boolean CreateVisa(String Visano, int Cvv)
	{
		if(User.getCurrentUser().Visa_Exist(Visano))
			return false;
		else
		{
			Visa v = new Visa(Visano, Cvv);
			User.getCurrentUser().addVisa(v);
			return true;
		}
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