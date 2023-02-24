/**
 * Version 1.0 d'une appli bancaire simplifiée offrant la possibilitée de créer des clients, des comptes bancaires associés et des opérations ou
 * transactions bancaires sur ceux-ci telles que : versement, retrait ou virement 
 * + permet d'afficher l'historique des transactions sur un compte
 * + la gestion des cas particuliers est rudimentaire ici puisque la notion d'exception n'a pas encore été abordée
 * 
 * @author El babili - 2022
 * 
 */

package fr.fms;



import java.util.Scanner;

import fr.fms.business.IBankImpl;
import fr.fms.data.Data;


public class MyBankApp  {	
	public static void main(String[] args) {
		Data data = new Data();
		IBankImpl bankJob = data.generateData();
		while(true) {
		System.out.println("Veuillez entrer un numero de compte valide : ");
		try {
			Scanner scan = new Scanner(System.in);
			while(!scan.hasNextInt()) scan.next();
			int accountId = scan.nextInt();
			System.out.println("Bienvenue " 
			+ bankJob.consultAccount(accountId).getCustomer().getFirstName()
			+ " que souhaitez vous faire ? Taper le numéro correspondant");
			mainMenu();
			while(!scan.hasNextInt()) scan.next();
			int todo = -1;
			while(todo!=6) {
				todo = scan.nextInt();
			switch (todo) {
			
			case 1:{
				System.out.println("Combien voulez ajouter au compte ? ");
				double moneyToAdd = scan.nextDouble();
				bankJob.pay(accountId, moneyToAdd);
				System.out.println(bankJob.consultAccount(accountId).getBalance());
				System.out.println("---------Taper le numéro correspondant------------");
				mainMenu();
				break;
			} case 2:{
				System.out.println("Saisissez le montant à retirer sur ce compte : ");
				double amoutToRemove = scan.nextDouble();
				bankJob.withdraw(accountId, amoutToRemove);
				System.out.println(bankJob.consultAccount(accountId).getBalance());
				System.out.println("---------Taper le numéro correspondant------------");
				mainMenu();
				break;
			} case 3:{
				System.out.println("Saisissez le numéro de compte destinataire");
				int accountToTransfert = scan.nextInt();
				System.out.println("Saisissez le montant a transferer : ");
				double amountToTransfert = scan.nextDouble();
				bankJob.transfert(accountId, accountToTransfert, amountToTransfert);
				System.out.println(bankJob.consultAccount(accountId).getBalance());
				System.out.println("---------Taper le numéro correspondant------------");
				mainMenu();
				break;
			} case 4: {
				System.out.println(bankJob.consultAccount(accountId).toString());
				System.out.println("---------Taper le numéro correspondant------------");
				mainMenu();
				break;
			} case 5 : {
				System.out.println(bankJob.listTransactions(accountId));
				System.out.println("---------Taper le numéro correspondant------------");
				mainMenu();
				break;
			}
			
			
			}
			}
			System.out.println("Aurevoir "+ bankJob.consultAccount(accountId).getCustomer().getFirstName() + " !" );
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
			
		}
		
		
		}
	
		
	}
	public  static void mainMenu() {
		System.out.println("1:versement - 2:retrait - 3:virement - 4:information sur ce compte - 5:liste des opérations - 6:sortir");
	}
}
