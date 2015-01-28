package net.danilovic.dimitriye.compscifinal;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum CompSciFinal implements Runnable {
	INSTANCE;
	
	private void drawDiamond(Scanner scanner) {
		System.out.print(" Width: ");
		int sizeX = scanner.nextInt();
		System.out.print("Height: ");
		int sizeY = scanner.nextInt();
		System.out.println();
		System.out.println(new AsciiImage(sizeX, sizeY,
				(x, y) -> (y == x - sizeX / 2)
				       || (y - sizeY / 2 == x)
				       || (y == sizeX / 2 - (x + 1 - sizeX % 2))
				       || (sizeY / 2 - y == x + 1 - sizeX)
				       ? "*" : " "));
	}
	
	private void calcSum(Scanner scanner) {
		System.out.print("n = ");
		int n = scanner.nextInt();
		double sum = 0;
		for (int i = 1; i <= n; ++i) {
			sum += factorial(n - i) / (double) factorial(i);
		}
		System.out.println("Sum: " + sum);
	}
	
	private int factorial(int n) {
		return n == 0 ? 1 : n * factorial(n - 1);
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Please select procedure: ");
			System.out.println("1. Draw diamond");
			System.out.println("2. Calculate Sum");
			
			menuLoop: while (true) {
				int menuItem = scanner.nextInt();
				switch (menuItem) {
					case 1:
						drawDiamond(scanner);
						break menuLoop;
					case 2:
						calcSum(scanner);
						break menuLoop;
				}
				System.out.println("ERROR: Please enter a valid procedure.");
				System.out.print  ("Query procedure: ");
			}
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					"Terminal error: ", e);
		} catch (Throwable t) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					"Fatal error: ", t);
			System.exit(-1);
		} finally {
			scanner.close();
		}
	}
	
	public static void main(String[] args) {
		INSTANCE.run();
	}
}
