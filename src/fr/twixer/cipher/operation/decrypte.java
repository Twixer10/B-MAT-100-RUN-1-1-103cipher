package fr.twixer.cipher.operation;

import java.util.ArrayList;

import fr.twixer.cipher.matrix.encrypteMessage;
import fr.twixer.cipher.matrix.key;

public class decrypte {
	
	public static decrypte isDecrypte;
	
	key key;
	ArrayList<encrypteMessage> messages = new ArrayList<>();
	ArrayList<double[][]> decryptedMessages = new ArrayList<>();
	ArrayList<Double> newValue = new ArrayList<>();
	
	public decrypte(ArrayList<encrypteMessage> messages, key key) {
		double sum = 0;
		double tmp[][] = null;
		this.key = key;
		this.messages = messages;
		for (encrypteMessage msg : this.messages) {
			tmp = new double[key.getSize()][key.getSize()];
			for (int i = 0; i < key.getSize(); i++) { 
				for (int j = 0; j < key.getSize(); j++) { 
					sum = 0;
					for (int k = 0; k < key.getSize(); k++) {
						sum += msg.getMatrix()[i][k] * inverseMatrix.invMatrix(key)[k][j];
					}
					tmp[i][j] = Math.round(sum);
				}
			}
			decryptedMessages.add(tmp);
		}
		isDecrypte = this;
	}
	
	public static double round(double value) {
	    long factor = (long) Math.pow(10, 3);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	public static decrypte getIsDecrypte() {
		return isDecrypte;
	}

	public static void setIsDecrypte(decrypte isDecrypte) {
		decrypte.isDecrypte = isDecrypte;
	}

	public ArrayList<encrypteMessage> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<encrypteMessage> messages) {
		this.messages = messages;
	}

	public ArrayList<double[][]> getDecryptedMessages() {
		return decryptedMessages;
	}

	public void setDecryptedMessages(ArrayList<double[][]> decryptedMessages) {
		this.decryptedMessages = decryptedMessages;
	}
	
	

}
