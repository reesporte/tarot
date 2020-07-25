.PHONY: build

default: build

build: Main.java
	javac -d build -cp jars/*.jar Main.java src/*.java

build/Main.class:
	make build

run: build/Main.class
	java -cp ./build:./jars/json-20200518.jar Main

clean:
	rm build/*.class
