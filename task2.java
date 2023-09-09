import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class task2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
     System.out.println("How many rounds do you want to perform?" +" : ");
		int round = sc.nextInt();
		do {
		System.out.print("Enter your total number of subject : ");
		int totalsubject = sc.nextInt();
		double totalsum = 0;
		int count = 0;
		for (int i = 0; i < totalsubject; i++) {
			System.out.println("Enter your " + i + " subject of number = ");
			double num = sc.nextDouble();
			if (num < 33)
				count++;
			totalsum += num;
		}

		double percetage = ((double) totalsum / (totalsubject * 100) * 100);

		String grade = null;
		if (count == 0) {
			if (percetage >= 90) {
				grade = "A";
			} else if (percetage >= 80) {
				grade = "B";
			} else if (percetage >= 70) {
				grade = "C";
			} else if (percetage >= 60) {
				grade = "D";
			} else if (percetage >= 50) {
				grade = "E";
			} else {
				grade = "F";
			}
			System.out.println("Tatal Marks : " + totalsum);
			System.out.println("Average Percentage : " + percetage + "%");
			System.out.println("Grade : " + grade);

		} else {
			System.out.println("You fail because you have less than 33 marks in " + count + " subjects. !... ");
			System.out.println("Tatal Marks : " + totalsum);
			System.out.println("Average Percentage : " + percetage + "%");
			System.out.println("Grade : F");
		}
     }while(round-- > 1);

	}

}
