package ui_handler;

import java.sql.SQLException;
import java.util.List;

import model.Drzava;
import model.Skakac;
import model.Skok;
import service.ComplexService;
import service.DrzavaService;
import service.SkakacService;
import service.SkokService;

public class ComplexUIHandler {
	
	private static final SkokService skokService = new SkokService();
	private static final DrzavaService drzavaService = new DrzavaService();
	private static final SkakacService skakacService = new SkakacService();
	private static final ComplexService complexService = new ComplexService();
	public void handleComplexQueryMenu(){
		String answer;
		do {
			System.out.println("\nOdaberite funkcionalnost:");
			System.out.println(
					"\n1  - Prikazati informacije o svim skokovima koji su vrseni na skakaonici sa unetim IDSA."
							+ "\n     Prikazati i broj razlicitih skakaca koji su izvodili te skokove");
			System.out.println(
					"\n2  - Prikazati podatke o svakoj drzavi. Za svaku drzavu treba prikazati i sve skokove koje su skakaci "
							+ "\n     iz te drzave izvodili na skakaonicama iz iste drzave.");
			System.out.println(
					"\n3  - Promeniti vrednost BVETAR na unetu vrednost za skok sa unetim ID skoka. U slucaju da"
					+ "\n nova vrednost ukupnog broja bodova prevazilazi vrednost PBSC u tabeli skakac, treba azurirati i"
					+ " vrednost najboljeg ostvarenog broja bodova.");

			System.out.println("\nX - Izlazak iz kompleksnih upita");

			answer = MainUIHandler.sc.nextLine();

			switch (answer) {
			case "1":
				showSkokoveForSkakaonica();
				break;
			case "2":
				showCountryReport();
				break;
			case "3":
				updateBVETARValue();
				break;
			
			}
		} while (!answer.equalsIgnoreCase("X"));
	}
	
	public void showSkokoveForSkakaonica(){
		try{
			System.out.println("ID skakaonice: ");
			String id = MainUIHandler.sc.nextLine();
			List<Skok> skokovi = skokService.getSkokBySkakaonicaId(id);
			if(!skokovi.isEmpty()){
				System.out.println("\t\t" + Skok.getFormattedHeader());
				for(Skok skok:skokovi){
					System.out.println("\t\t" + skok);		
				}
				System.out.println("\n\t\tBROJ RAZLICITIH SKAKACA KOJI SU IZVODILI TE SKOKOVE = "+skokService.getNumberOfSkakacBySkakaonicaId(id));
			}
			else{
				System.out.println("\t\tNEMA SKOKOVA.");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void showCountryReport(){
		try{
			List<Drzava> drzave = drzavaService.getAll();
			if(!drzave.isEmpty()){
				for(Drzava drzava:drzave){
					System.out.println("\t\t" + Drzava.getFormattedHeader());
					System.out.println("\t\t" + drzava);	
					List<Skok> skokovi = complexService.getSkokFromDrzava(drzava.getId());
					if(skokovi.isEmpty())
						System.out.println("\t\t (nema skakaca koji zadovoljavaju uslove pretrage)");
					else{
						 	System.out.println("\t\t\t"+Skok.getFormattedHeader());
						for(Skok skok : skokovi)
							System.out.println("\t\t\t"+skok);
					}
				}
			}
			else{
				System.out.println("\t\tNEMA DRZAVA.");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateBVETARValue(){
		try{
			System.out.println("Nova vrednost za BVETAR : ");
			double newValue = Double.parseDouble(MainUIHandler.sc.nextLine());
			System.out.println("ID skoka : ");
			String id = MainUIHandler.sc.nextLine();
			if(skokService.updateBVETAR(id,newValue))
			{
				System.out.println("Update uspesno izvrsen!");
				int skakacId = skokService.getSkakacIdFromSkokId(id);
				Skakac skakacBeforeUpdate = skakacService.getSkakacFromId(skakacId);			
				if(complexService.updatePBSCIfNeeded(id)){
					Skakac skakacAfterUpdate = skakacService.getSkakacFromId(skakacId);
					System.out.println("SKAKAC CIJI JE ID = "+skakacId+" JE OBORIO REKORD!!!\n");
					System.out.println("Skakac pre obaranja rekorda : ");
					System.out.println("\t\t"+Skakac.getFormattedHeader());
					System.out.println("\t\t"+skakacBeforeUpdate);
					
					System.out.println("\nSkakac nakon obaranja rekorda : ");
					System.out.println("\t\t"+Skakac.getFormattedHeader());
					System.out.println("\t\t"+skakacAfterUpdate);
				}
				else{
					System.out.println("Nije doslo do obaranja rekorda!!");
				}
			}
			else
				System.out.println("Update neuspesan!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
