package fr.twixer.cipher;

import java.util.ArrayList;

import fr.twixer.cipher.matrix.encrypteMessage;
import fr.twixer.cipher.matrix.key;
import fr.twixer.cipher.matrix.message;
import fr.twixer.cipher.operation.decrypte;
import fr.twixer.cipher.operation.encrypte;
import fr.twixer.cipher.operation.inverseMatrix;

public class Main {

	public static void main(String[] args) {
		if(args.length == 0)
			System.exit(84);
		if(args.length == 1 && args[0].equals("-h")) {
			System.out.println(
					"USAGE" + 
					"\n    ./103cipher message key flag" + 
					"\n\nDESCRIPTION" + 
					"\n    message\ta message, made of ASCII characters" + 
					"\n    key\t\tthe encryption key, made of ASCII characters" + 
					"\n    flag\t0 for the message to be encrypted, 1 to be decrypted");
		} else if(args.length == 3) {
			if(args[2].equals("0")) {
				try {
					encrypteMsg(args);
				} catch (Exception e) {
					System.exit(84);
				}
			} else if(args[2].equals("1")) {
				try {
					decrypteMsg(args);
				} catch (Exception e) {
					System.exit(84);
				}
			} else {
				System.exit(84);
			}
		} else {
			System.exit(84);
		}
	}
	
	private static void decrypteMsg(String[] args) {
		try {
			if(!containOnlyLetter(args[0])) {
				System.exit(84);
			}
			new key(args);
			System.out.println("Key matrix:");
			for (int i= 0 ; i < key.key.getSize(); i++ ) {
				for (int j=0 ; j < key.key.getSize();j++ ) {
					System.out.print(decrypte.round(inverseMatrix.invMatrix(key.key)[i][j]) + (j < key.key.getSize() - 1?"\t":"\n"));
				}
			}
			System.out.println("\nDecrypted message:");
			encrypteMessage.initEncrypteMessage(args, key.key);
			new decrypte(encrypteMessage.encrypteMessages, key.key);
			for (double[][] msg : decrypte.isDecrypte.getDecryptedMessages()) {
				for (int i= 0 ; i < key.key.getSize(); i++ ) {
					for (int j=0 ; j < key.key.getSize();j++ ) {
						System.out.print((Character.toString((char) msg[i][j])));
					}
				}
			}
			System.out.println();
		} catch (Exception e) {
			System.exit(84);
		}
	}
	
	private static void encrypteMsg(String[] args) {
		ArrayList<String> str = new ArrayList<>();
		new key(args);
		message.initMessage(args, key.key);
		System.out.println("Key matrix:");
		for (int i= 0 ; i < key.key.getSize(); i++ ) {
			for (int j=0 ; j < key.key.getSize();j++ ) {
				System.out.print(key.key.getMatrix()[i][j] + (j < key.key.getSize() - 1?"\t":"\n"));
			}
		}
		System.out.println("\nEncrypted message:");
		new encrypte(message.messages, key.key);
		for (int[][] msg : encrypte.isEncrypte.getEncryptedMessages()) {
			for (int i= 0 ; i < key.key.getSize(); i++ ) {
				for (int j=0 ; j < key.key.getSize();j++ ) {
					if (msg[i][j] != 0)
						str.add(msg[i][j] + "");
				}
			}
		}
		System.out.println(str.toString().replace("[", "").replace("]", "").replace(",", ""));
	}
	
	private static boolean containOnlyLetter(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (((int) s.charAt(i)) >= 65 && ((int) s.charAt(i)) <= 90 || ((int) s.charAt(i)) >= 97 && ((int) s.charAt(i)) <= 122) {
				return false;
			}
		}
		return true;
	}

}
