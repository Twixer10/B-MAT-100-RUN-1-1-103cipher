package fr.twixer.cypher;

import java.util.ArrayList;

import fr.twixer.cypher.matrix.key;
import fr.twixer.cypher.matrix.message;
import fr.twixer.cypher.operation.encrypte;

public class Main {

	public static void main(String[] args) {
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
					encrypteMessage(args);
				} catch (Exception e) {
					System.exit(84);
				}
			} else if(args[2].equals("1")) {
				
			} else {
				System.exit(84);
			}
		}
	}
	
	private static void encrypteMessage(String[] args) {
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
}
