all: test

compile:
	antlr3 Tiger.g

test: compile
	javac TLexer.java TParser.java Test.java
	java Test
