###########################
######### DEFINES #########
###########################
define \n


endef

define line
-------------------
endef


###########################
######## VARIABLES ########
###########################
CC = gcc

SOURCES = ./src/main.c \
					./src/tds.c \
					./src/tds_helpers.c \
          ./src/checkers.c \
          ./src/helpers.c \
          ./src/TigerLexer.c \
          ./src/TigerParser.c

FLAGS =	-pedantic \
        -pedantic-errors \
				-w

PATH_EXTEND = -I /usr/local/include/ \
							-L /usr/local/opt/libantlr3c/lib \
							-l antlr3c
OUTPUT = -o ./main.out

###########################
######## COMMANDES ########
###########################
all : grammar c exec ## grammar c exec

clean : ## Clean the project
	$(info ${\n} ${line} CLEAN ${line} ${\n})
	rm -f main.out
	rm -f src/TigerLexer*
	rm -f src/TigerParser*
	rm -f Tiger.tokens
	rm -f Report.Tex

	rm -f test/build/*.class test/build/*.tex *.log *.aux *.toc
	rm -f test/build/Tiger*
	rm -fdr test/build/ast
	rm -fdr ast
	rm -fdr test/tests


grammar : ## Compile the grammar using antlr3
	$(info ${\n} ${line} GRAMMAR ${line} ${\n})
	$(info Make sure `language = C;` is uncommented in grammar options${\n})
	antlr3 ./src/Tiger.g -make

c : ## Compile all the sources into the executable
	$(info ${\n} ${line} COMPILE ${line} ${\n})
	$(info Make sure libantlr3c and header are in the same place as PATH_EXTEND${\n})
	$(CC) $(SOURCES) $(PATH_EXTEND) $(FLAGS) $(OUTPUT)

c_ben : ## Compile all the sources into the executable
	$(info ${\n} ${line} COMPILE ${line} ${\n})
	$(info Make sure libantlr3c and header are in the same place as PATH_EXTEND${\n})
	$(CC) $(SOURCES) $(PATH_EXTEND) $(FLAGS) $(OUTPUT) -m32

exec : ## Execute the program with ./Tests/test.tiger file as input
	$(info ${\n} ${line} EXECUTION ${line} ${\n})
	./main.out ./test/test.tiger

c_e : c exec ## Compile C files and launch executable

c_e_ben : c_ben exec ## Compile C files and launch executable


test_report : ## Generate PDF files containing AST from tests files
	$(info ${\n} ${line} GENERATING PDF ${line} ${\n})
	antlr3 ./src/Tiger.g -language Java -make -fo test/build
	javac -cp "test/build/jar/*" test/build/*.java
	java -cp test/build/jar/*:test/build TestGenerator
	java -cp test/build/jar/*:test/build ReportGenerator
	pdflatex Report.tex
	pdflatex Report.tex

###########################
########### HELP ##########
###########################
.PHONY: help
help :
	@grep -E '^[a-zA-Z_-]+ :.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
.DEFAULT_GOAL := help
