all: test

compile:
	antlr3 Tiger.g

test: compile
	javac TigerLexer.c TigerParser.c Test.java
	java Test
