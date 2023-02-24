package fr.fms.data;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.fms.MyBankApp;
import fr.fms.business.IBankImpl;
import fr.fms.entities.Account;
import fr.fms.entities.Current;
import fr.fms.entities.Customer;
import fr.fms.entities.Saving;

public class Data{
	 
	
	
	
	public static ArrayList<Customer> initCustomerDB(){
		ArrayList<Customer>customerList = new ArrayList<Customer>();
		customerList.add(new Customer(1, "dupont", "robert", "robert.dupont@xmail.com"));
		customerList.add(new Customer(2, "jolie", "julie", "julie.jolie@xmail.com"));
		customerList.add(new Customer(3, "Monjeau", "Capucine ", "Capucine.Monjeau@xmail.com"));
		return customerList;
	}
	public static ArrayList<Saving> initSavingDB(){
		ArrayList<Saving>savingList = new ArrayList<Saving>();
		savingList.add(new Saving(200300400, new Date(), 2000, 5.5, initCustomerDB().get(0)));
		savingList.add(new Saving(200300500, new Date(), 2000, 5.5, initCustomerDB().get(1)));
		savingList.add(new Saving(200300600, new Date(), 2000, 5.5, initCustomerDB().get(2)));
		return savingList;
	}
	public static List<Current> initCurrentDB(){
		List<Current>currentList = new ArrayList<Current>();
		currentList.add(new Current(100200300, new Date(), 1500, 200 , initCustomerDB().get(0)));
		currentList.add(new Current(100200400, new Date(), 1500, 200 , initCustomerDB().get(1)));
		currentList.add(new Current(100200500, new Date(), 1500, 200 , initCustomerDB().get(2)));
		return currentList;
	}
	
	public IBankImpl   generateData() {
         IBankImpl bankJob = new IBankImpl();
         
         for(Current current : initCurrentDB()) {
        	 bankJob.addAccount(current);
         }
         
         for(Saving saving : initSavingDB()) {
        	 bankJob.addAccount(saving);
         }
         
//         Account test = initCurrentDB().get(2);
//		 bankJob.addAccount(test);
		//System.out.println(test);
		return bankJob;
	}
	
}
