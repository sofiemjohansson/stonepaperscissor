package sten;

import java.util.Scanner; // Tv� olika klasser b�de random och scanner.
import java.util.Random;

public class sten {
	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in); // skapar scanner objekt som ber om anv�ndarnamn
		System.out.println("Skriv in ditt anv�ndarnamn:");

		String userName = myObj.nextLine(); //
		System.out.println("Anv�ndarnamn: " + userName); // Skriver namn i programmet innan spelet b�rjar

		System.out.println("V�lkommen till sten sax p�se. Hur m�nga g�nger vill du spela?"); // F�rsta meningen man ser
																								// som fr�gar efter hur
																								// m�nga omg�ngar spel
																								// man �nskar att spela
		int userScore = 0;
		int compScore = 0;
		Scanner scanner = new Scanner(System.in);
		int numberOfRounds = scanner.nextInt();
		Random r = new Random(); // Random anv�nder jag f�r att skapa slumpm�ssigt tal med datorn
		for (int x = 1; x <= numberOfRounds; x++) { // H�r har spelaren m�jlighete att f� v�lja antal omg�ngar som man
													// vill spela.
			int compChoice = r.nextInt(3);
			System.out.println("V�lj 1 slt Sten, 2 alt sax, 3 alt p�se?");
			String userChoice = scanner.next().toLowerCase();
			String[] choices = { "Sten", "Sax", "P�se" };
			String[] choices1 = { "1", "2", "3" };
			switch (userChoice) { // �r i princip samma sak som else if satsen som vi l�rde oss om i veckan. det
									// innneb�r ingen st�rre skillnad i prestanda eller funktion. B�da g�r bra.

			case "sten": // F�r att kunna f� v�lja mellan text och siffra la jag till b�de 1 och bokstav
			case "1":
				if (compChoice == 0) {
					System.out.println(userChoice); // Skriver ut vad spelaren v�ljer
					System.out.println("Det blev oavgjort");
				}
				if (compChoice == 1) {
					System.out.println(choices[compChoice]);
					System.out.println("Yay du vann!");
					userScore++;
				}
				if (compChoice == 2) {
					System.out.println(choices[compChoice]);
					System.out.println("Tyv�rr du f�rlorade");
					compScore++;
				}
				break;
			case "sax":
			case "2":
				if (compChoice == 0) {
					System.out.println(choices[compChoice]);
					System.out.println("Du f�rlorade");
					compScore++;
				}
				if (compChoice == 1) {
					System.out.println(userChoice);
					System.out.println("Oavgjort!");
				}
				if (compChoice == 2) {
					System.out.println(choices[compChoice]);
					System.out.println("Du vann!");
					userScore++;
				}
				break;
			case "p�se":
			case "3":
				if (compChoice == 0) {
					System.out.println(choices[compChoice]);
					System.out.println("Du vann!");
					userScore++;
				}
				if (compChoice == 1) {
					System.out.println(choices[compChoice]);
					System.out.println("Du f�rlorade");
					compScore++;
				}
				if (compChoice == 2) {
					System.out.println(userChoice);
					System.out.println("Oavgjort!");
				}
				break;
			default:
				System.out.println("Du angedde n�got vi inte kan l�sa"); // anv�nds f�r att skapa ett felmeddelande vid
																			// fel inmatning under spelets g�ng.
				compScore++;
			}

		}
		String status = (userScore > compScore) ? "till dig" : "till datorn";
		if (userScore == compScore) {
			status = "";
		}
		String result = Integer.toString(userScore) + " - " + Integer.toString(compScore);
		System.out.println("Matchen slutade " + result + " " + status); // slutgiltliga resutatet.
	}
}