package fr.twixer.cypher.operation;

import java.util.ArrayList;

import fr.twixer.cypher.matrix.key;
import fr.twixer.cypher.matrix.message;

public class encrypte {

	public static encrypte isEncrypte;
	
	key key;
	ArrayList<message> messages = new ArrayList<>();
	ArrayList<int[][]> encryptedMessages = new ArrayList<>();
	ArrayList<Integer> newValue = new ArrayList<>();
	
	public encrypte(ArrayList<message> messages, key key) {
		int sum = 0;
		int tmp[][] = null;
		this.key = key;
		this.messages = messages;
		for (message msg : this.messages) {
			tmp = new int[key.getSize()][key.getSize()];
			for (int i = 0; i < key.getSize(); i++) { 
				for (int j = 0; j < key.getSize(); j++) { 
					sum = 0;
					for (int k = 0; k < key.getSize(); k++) {
						sum += msg.getMatrix()[i][k] * key.getMatrix()[k][j];
					}
					tmp[i][j] = sum;
				}
			}
			encryptedMessages.add(tmp);
		}
		isEncrypte = this;
	}

	public key getKey() {
		return key;
	}

	public void setKey(key key) {
		this.key = key;
	}

	public ArrayList<message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<message> messages) {
		this.messages = messages;
	}

	public ArrayList<int[][]> getEncryptedMessages() {
		return encryptedMessages;
	}

	public void setEncryptedMessages(ArrayList<int[][]> encryptedMessages) {
		this.encryptedMessages = encryptedMessages;
	}

	public ArrayList<Integer> getNewValue() {
		return newValue;
	}

	public void setNewValue(ArrayList<Integer> newValue) {
		this.newValue = newValue;
	}
	
	
	
}