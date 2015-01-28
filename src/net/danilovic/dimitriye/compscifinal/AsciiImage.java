package net.danilovic.dimitriye.compscifinal;

import java.util.function.BiFunction;

public class AsciiImage {

	private final char[][] canvas;
	private final int sizeX;
	private final int sizeY;

	public AsciiImage(int sizeX, int sizeY, char fillerChar) {
		if (sizeX <= 0 && sizeY <= 0) {
			throw new IllegalArgumentException("arguments sizeX and sizeY must"
					+ " be positive integers");
		} else if (sizeX <= 0) {
			throw new IllegalArgumentException("argument sizeX must be a"
					+ " positive integer");
		} else if (sizeY <= 0) {
			throw new IllegalArgumentException("argument sizeY must be a"
					+ " positive integer");
		}
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		canvas = new char[sizeY][sizeX];
		
		fill(fillerChar);
	}

	public AsciiImage(int sizeX, int sizeY,
			BiFunction<Integer, Integer, String> charFunction) {
		if (sizeX <= 0 && sizeY <= 0) {
			throw new IllegalArgumentException("arguments sizeX and sizeY must"
					+ " be positive integers");
		} else if (sizeX <= 0) {
			throw new IllegalArgumentException("argument sizeX must be a"
					+ " positive integer");
		} else if (sizeY <= 0) {
			throw new IllegalArgumentException("argument sizeY must be a"
					+ " positive integer");
		}
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		canvas = new char[sizeY][sizeX];
		
		fill(charFunction);
	}

	public AsciiImage(int sizeX, int sizeY) {
		if (sizeX <= 0 && sizeY <= 0) {
			throw new IllegalArgumentException("arguments sizeX and sizeY must"
					+ " be positive integers");
		} else if (sizeX <= 0) {
			throw new IllegalArgumentException("argument sizeX must be a"
					+ " positive integer");
		} else if (sizeY <= 0) {
			throw new IllegalArgumentException("argument sizeY must be a"
					+ " positive integer");
		}
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		canvas = new char[sizeY][sizeX];
		
		fill(' ');
	}
	
	private void assertInBounds(int x, int y) {
		if ((x < 0 || x >= sizeX) && (y < 0 || y >= sizeY)) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void set(int x, int y, char c) {
		assertInBounds(x, y);
		canvas[x][y] = c;
	}
	
	public char get(int x, int y) {
		assertInBounds(x, y);
		return canvas[x][y];
	}
	
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int j = 0; j < sizeY; ++j) {
			for (int i = 0; i < sizeX; ++i) {
				out.append(canvas[i][j]);
			}
			out.append('\n');
		}
		return out.toString();
	}
	
	public void fill(char c) {
		for (int i = 0; i < sizeX; ++i) {
			for (int j = 0; j < sizeY; ++j) {
				canvas[i][j] = c;
			}
		}
	}
	
	public void fill(BiFunction<Integer, Integer, String> charFunction) {
		for (int i = 0; i < sizeX; ++i) {
			for (int j = 0; j < sizeY; ++j) {
				canvas[i][j] = charFunction.apply(i, j).charAt(0);
			}
		}
	}

}
