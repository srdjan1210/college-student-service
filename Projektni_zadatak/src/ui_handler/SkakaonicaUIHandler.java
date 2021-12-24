package ui_handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Skakaonica;
import service.SkakaonicaService;

public class SkakaonicaUIHandler {
	private static final SkakaonicaService skakaonicaService = new SkakaonicaService();
	
	public void handleSkakaonicaMenu(){
		String answer;
		do {
			System.out.println("\nOdaberite opciju za rad nad skakaonicama:");
			System.out.println("1 - Prikaz svih");
			System.out.println("2 - Prikaz po identifikatoru");
			System.out.println("3 - Unos jedne skakaonice");
			System.out.println("4 - Unos vise skakaonica");
			System.out.println("5 - Izmena po identifikatoru");
			System.out.println("6 - Brisanje po identifikatoru");
			System.out.println("X - Izlazak iz rukovanja skakaonicama");

			answer = MainUIHandler.sc.nextLine();

			switch (answer) {
			case "1":
				showAll();
				break;
			case "2":
				showById();
				break;
			case "3":
				handleSingleInsert();
				break;
			case "4":
				handleMultipleInserts();
				break;
			case "5":
				handleUpdate();
				break;
			case "6":
				handleDelete();
				break;
			}

		} while (!answer.equalsIgnoreCase("X"));
	}
	
	private void showAll() {
		System.out.println(Skakaonica.getFormattedHeader());

		try {
			for (Skakaonica skak : skakaonicaService.getAll()) {
				System.out.println(skak);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private void showById() {
		System.out.println("ID skakaonice: ");
		String id = MainUIHandler.sc.nextLine();

		try {
			Skakaonica skakaonica = skakaonicaService.getById(id);
			System.out.println(Skakaonica.getFormattedHeader());
			System.out.println(skakaonica);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void handleSingleInsert() {
		System.out.println("Id skakaonice: ");
		String idsa = MainUIHandler.sc.nextLine();

		System.out.println("Naziv: ");
		String nazivsa = MainUIHandler.sc.nextLine();

		System.out.println("Duzina: ");
		int duzinasa = Integer.parseInt(MainUIHandler.sc.nextLine());

		System.out.println("Tip: ");
		String tipsa = MainUIHandler.sc.nextLine();

		System.out.println("Id drzave: ");
		String idd = MainUIHandler.sc.nextLine();

		try {
			skakaonicaService.save(new Skakaonica(idsa, nazivsa, duzinasa, tipsa, idd));
			System.out.println("Dodavanje uspesno.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void handleUpdate() {
		System.out.println("ID skakaonice: ");
		String idsa = MainUIHandler.sc.nextLine();

		try {
			if (!skakaonicaService.existsById(idsa)) {
				System.out.println("Uneta vrednost ne postoji!");
				return;
			}

			System.out.println("Naziv: ");
			String nazivsa = MainUIHandler.sc.nextLine();

			System.out.println("Duzina: ");
			int duzinasa = Integer.parseInt(MainUIHandler.sc.nextLine());

			System.out.println("Tip: ");
			String tipsa = MainUIHandler.sc.nextLine();

			System.out.println("Drzava: ");
			String idd = MainUIHandler.sc.nextLine();

			boolean success = skakaonicaService.save(new Skakaonica(idsa, nazivsa, duzinasa, tipsa, idd));
			if (success) {
				System.out.println("Skakaonica uspesno izmenjena.");
			} else {
				System.out.println("Izmena skakaonice nije uspela.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void handleDelete() {
		System.out.println("ID skakaonice: ");
		String id = MainUIHandler.sc.nextLine();

		try {
			boolean success = skakaonicaService.deleteById(id);
			if (success) {
				System.out.println("Skakaonica uspesno obrisana.");
			} else {
				System.out.println("Brisanje skakaonice nije uspelo.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void handleMultipleInserts() {
		List<Skakaonica> skakaonicaList = new ArrayList<>();
		String answer;
		do {
			System.out.println("ID skakaonice: ");
			String idsa = MainUIHandler.sc.nextLine();

			System.out.println("Naziv: ");
			String nazivsa = MainUIHandler.sc.nextLine();

			System.out.println("Duzina: ");
			int duzinasa = Integer.parseInt(MainUIHandler.sc.nextLine());

			System.out.println("Tip: ");
			String tipsa = MainUIHandler.sc.nextLine();

			System.out.println("Drzava: ");
			String idd = MainUIHandler.sc.nextLine();

			skakaonicaList.add(new Skakaonica(idsa, nazivsa, duzinasa, tipsa, idd));

			System.out.println("Prekinuti unos? X za potvrdu");
			answer = MainUIHandler.sc.nextLine();
		} while (!answer.equalsIgnoreCase("X"));

		try {
			int rowsSaved = skakaonicaService.saveAll(skakaonicaList);
			System.out.println("Uspesno ažurirano " + rowsSaved + " skakaonica.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
