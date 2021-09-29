package fr.twixer.cypher.matrix;

import java.util.ArrayList;
import java.util.List;

public class message {
	
	public static ArrayList<message> messages = new ArrayList<>();
	private int ind;
	private static int whereStart;
	

	ArrayList<Character> matrixTemp = new ArrayList<>();
	int[][] matrix;
	
	
	public message(String arg, key key) {
		char[] charArgs = arg.substring(whereStart).toCharArray();
		converToArrayList(matrixTemp, charArgs);
		this.matrix = new int[key.size][key.size];
		for (int i = 0; i < key.size; i++) {
			for (int j = 0 ; j < key.size; j++) {
				try {
					this.matrix[i][j] = (int) matrixTemp.get(ind++);
				} catch (Exception e) {
					this.matrix[i][j] = 0;
				}
			}
		}
		whereStart += (key.size * key.size);
	}
	
	public message(ArrayList<Integer> newMatrix, key key) {
		int tmp = 0;
		this.matrix = new int[key.size][key.size];
		for (int i = 0; i < key.size; i++) {
			for (int j = 0 ; j < key.size; j++) {
				try {
					this.matrix[i][j] = newMatrix.get(tmp++);
				} catch (Exception e) {
					this.matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void initMessage(String[] args, key key) {
		while(whereStart <= args[0].length()) {
			messages.add(new message(args[0], key));
		}
	}


	private void converToArrayList(List<Character> matrixTemp2, char[] charArgs) {
		for(char c : charArgs) {
			matrixTemp2.add(c);
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
}
