package fr.twixer.cypher.matrix;

import java.util.ArrayList;
import java.util.List;

public class key {
	
	public static key key;
	private int ind = 0;
	
	int size;
	ArrayList<Character> matrixTemp = new ArrayList<>();
	int[][] matrix;
	
	
	public key(String[] args) {
		char[] charArgs = args[1].toCharArray();
		converToArrayList(matrixTemp, charArgs);
		if(charArgs.length <= 1) {
			this.size = 1;
		}
		if(charArgs.length <= 4 && charArgs.length > 1) {
			this.size = 2;
		}
		if(charArgs.length <= 9 && charArgs.length > 4) {
			this.size = 3;
		}
		if(charArgs.length <= 16 && charArgs.length > 9) {
			this.size = 4;
		} else if(charArgs.length > 16) {
			System.out.println("The lenght of the key is too long.");
			System.exit(84);
		}
		this.matrix = new int[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0 ; j < this.size; j++) {
				try {
					this.matrix[i][j] = (int) matrixTemp.get(ind++);
				} catch (Exception e) {
					this.matrix[i][j] = 0;
				}
			}
		}
		key = this;
	}



	private void converToArrayList(List<Character> matrixTemp2, char[] charArgs) {
		for(char c : charArgs) {
			matrixTemp2.add(c);
		}
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int[][] getMatrix() {
		return matrix;
	}


	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

}
