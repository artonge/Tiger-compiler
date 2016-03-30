all: grammar

grammar:
	antlr3 Tiger.g -o output
