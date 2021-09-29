package fr.twixer.cipher.matrix;

import java.util.ArrayList;

public class encrypteMessage {

	public static ArrayList<encrypteMessage> encrypteMessages = new ArrayList<>();
	private int ind;
	private static int whereStart;
	

	ArrayList<Integer> matrixTemp = new ArrayList<>();
	int[][] matrix;
	

	public encrypteMessage(String arg, key key) {
		converToArrayList(arg.substring(whereStart));
		this.matrix = new int[key.size][key.size];
		for (int i = 0; i < key.size; i++) {
			for (int j = 0 ; j < key.size; j++) {
				try {
					this.matrix[i][j] = matrixTemp.get(ind++);
					whereStart += ("" + matrixTemp.get(ind - 1)).length() + 1;
				} catch (Exception e) {
					this.matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void initEncrypteMessage(String[] args, key key) {
		while(whereStart <= args[0].length()) {
			encrypteMessages.add(new encrypteMessage(args[0], key));
		}
	}

	private void converToArrayList(String arg) {
		for (String str : arg.split(" ")) {
			try {
				matrixTemp.add(Integer.parseInt(str));
			} catch (Exception e) {
				System.exit(84);
			}
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	
}
