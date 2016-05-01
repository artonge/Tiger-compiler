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
          ./src/checkers.c \
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
all : clean grammar c exec ## clean grammar c exec

clean : ## Clean the project
	$(info ${\n} ${line} CLEAN ${line} ${\n})
	rm -f m*.out


grammar : ## Compile the grammar using antlr3
	$(info ${\n} ${line} GRAMMAR ${line} ${\n})
	antlr3 ./src/Tiger.g -language C -make


c : ## Compile all the sources into the executable
	$(info ${\n} ${line} COMPILE ${line} ${\n})
	$(CC) $(SOURCES) $(PATH_EXTEND) $(FLAGS) $(OUTPUT)

exec : ## Execute the program with ./Tests/test.tiger file as input
	$(info ${\n} ${line} EXECUTION ${line} ${\n})
	./main.out ./Tests/test.tiger

c_e : c exec ## Compile C files and launch executable


test_report : ## Generate PDF files containing AST from tests files
	$(info ${\n} ${line} GENERATING PDF ${line} ${\n})
	antlr3 ./src/Tiger.g -language Java -make -fo test/build

	javac -cp "test/build/jar/*" test/build/*.java
	java -cp test/build/jar/*:test/build TestGenerator
	java -cp test/build/jar/*:test/build ReportGenerator
	pdflatex test/build/Report.tex

	rm test/build/*.class test/build/*.tex *.log *.aux *.toc
	rm test/build/Tiger*
	rm -r test/build/ast
	rm -r test/tests


###########################
########### HELP ##########
###########################
.PHONY: help
help :
	@grep -E '^[a-zA-Z_-]+ :.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
.DEFAULT_GOAL := help
