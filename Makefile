##
## EPITECH PROJECT, 2020
## makefile exe
## File description:
## fct
##

SRCJAVA = src/fr/twixer/cipher/Main.java \
		  src/fr/twixer/cipher/matrix/key.java \
		  src/fr/twixer/cipher/matrix/message.java \
		  src/fr/twixer/cipher/operation/encrypte.java \
		  src/fr/twixer/cipher/matrix/encrypteMessage.java \
		  src/fr/twixer/cipher/operation/inverseMatrix.java \
		  src/fr/twixer/cipher/operation/decrypte.java

SRCCLASS = fr/twixer/cipher/Main.class \
		   fr/twixer/cipher/matrix/key.class \
		   fr/twixer/cipher/matrix/message.class \
		   fr/twixer/cipher/operation/encrypte.class \
		   fr/twixer/cipher/matrix/encrypteMessage.class \
		   fr/twixer/cipher/operation/inverseMatrix.class \
		   fr/twixer/cipher/operation/decrypte.class

SRC = 103cipher.jar

NAME = 103cipher

all:
	mkdir class/
	javac -d ./class $(SRCJAVA)
	cp -r manifest.mf class/
	cd class/ && jar cmf manifest.mf $(SRC) $(SRCCLASS)
	cp -r class/$(SRC) ./
	cp 103cipher.sh $(NAME)
	chmod 755 $(NAME)

clean:
	rm -r class/
	rm $(SRC)

fclean: clean
	rm $(NAME)

re:	fclean all
