package sten;

import java.util.Scanner; // Två olika klasser både random och scanner.
import java.util.Random;

public class sten {
	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in); // skapar scanner objekt som ber om användarnamn
		System.out.println("Skriv in ditt användarnamn:");

		String userName = myObj.nextLine(); //
		System.out.println("Användarnamn: " + userName); // Skriver namn i programmet innan spelet börjar

		System.out.println("Välkommen till sten sax påse. Hur många gånger vill du spela?"); // Första meningen man ser
																								// som frågar efter hur
																								// många omgångar spel
																								// man önskar att spela
		int userScore = 0;
		int compScore = 0;
		Scanner scanner = new Scanner(System.in);
		int numberOfRounds = scanner.nextInt();
		Random r = new Random(); // Random använder jag för att skapa slumpmässigt tal med datorn
		for (int x = 1; x <= numberOfRounds; x++) { // Här har spelaren möjlighete att få välja antal omgångar som man
													// vill spela.
			int compChoice = r.nextInt(3);
			System.out.println("Välj 1 slt Sten, 2 alt sax, 3 alt påse?");
			String userChoice = scanner.next().toLowerCase();
			String[] choices = { "Sten", "Sax", "Påse" };
			String[] choices1 = { "1", "2", "3" };
			switch (userChoice) { // är i princip samma sak som else if satsen som vi lärde oss om i veckan. det
									// innnebär ingen större skillnad i prestanda eller funktion. Båda går bra.

			case "sten": // För att kunna få välja mellan text och siffra la jag till både 1 och bokstav
			case "1":
				if (compChoice == 0) {
					System.out.println(userChoice); // Skriver ut vad spelaren väljer
					System.out.println("Det blev oavgjort");
				}
				if (compChoice == 1) {
					System.out.println(choices[compChoice]);
					System.out.println("Yay du vann!");
					userScore++;
				}
				if (compChoice == 2) {
					System.out.println(choices[compChoice]);
					System.out.println("Tyvärr du förlorade");
					compScore++;
				}
				break;
			case "sax":
			case "2":
				if (compChoice == 0) {
					System.out.println(choices[compChoice]);
					System.out.println("Du förlorade");
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
			case "påse":
			case "3":
				if (compChoice == 0) {
					System.out.println(choices[compChoice]);
					System.out.println("Du vann!");
					userScore++;
				}
				if (compChoice == 1) {
					System.out.println(choices[compChoice]);
					System.out.println("Du förlorade");
					compScore++;
				}
				if (compChoice == 2) {
					System.out.println(userChoice);
					System.out.println("Oavgjort!");
				}
				break;
			default:
				System.out.println("Du angedde något vi inte kan läsa"); // används för att skapa ett felmeddelande vid
																			// fel inmatning under spelets gång.
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