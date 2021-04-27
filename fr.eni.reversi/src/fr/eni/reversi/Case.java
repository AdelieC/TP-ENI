package fr.eni.reversi;

public class Case implements Comparable<Case>{
	private int y, x, score;
	
	public Case(int y, int x, int score) {
		this.y = y;
		this.x = x;
		this.score = score;
	}
	
	public int[] getXY() {
		return new int[] { this.y, this.x };
	}
	
	@Override
	public int compareTo(Case other) {
		return Integer.compare(this.score, other.score);
	}
}
