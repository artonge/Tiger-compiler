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
          ./src/tds/tds.c \
          ./src/tds/tds_helpers.c \
          ./src/checkers/checkers.c \
          ./src/generation/generation.c \
          ./src/generation/generation_helpers.c \
          ./src/helpers.c \
          ./src/TigerLexer.c \
          ./src/TigerParser.c

FLAGS =	-pedantic \
        -pedantic-errors \
        -w

PATH_EXTEND = -I ./src/ \
              -I ./src/tds \
              -I ./src/generation \
              -I ./src/checkers \
              -I /usr/local/include/ \
              -L /usr/local/opt/libantlr3c/lib \
              -l antlr3c

OUTPUT = -o ./tigerc

###########################
######## COMMANDES ########
###########################
all : exec ## grammar c exec

clean : ## Clean the project
	$(info ${\n} ${line} CLEAN ${line} ${\n})
	rm -f tigerc
	rm -f src/TigerLexer*
	rm -f src/TigerParser*
	rm -f Tiger.tokens
	rm -f *.asm
	rm -f *.iup
	rm -f Report.Tex
	sudo rm -fr src/output

	rm -f test/build/*.class test/build/*.tex *.log *.aux *.toc
	rm -f test/build/Tiger*
	rm -fdr test/build/ast
	rm -fdr ast
	rm -fdr test/tests


grammar : ## Compile the grammar using antlr3
	$(info ${\n} ${line} GRAMMAR ${line} ${\n})
	$(info Make sure `language = C;` is uncommented in grammar options${\n})
	antlr3 ./src/Tiger.g -make
	
grammar_lil : ## Compile the grammar using antlr3
	$(info ${\n} ${line} GRAMMAR ${line} ${\n})
	$(info Make sure `language = C;` is uncommented in grammar options${\n})
	java -jar antlr-3.5.2.jar ./src/Tiger.g -make

c : grammar ## Compile all the sources into the executable
	$(info ${\n} ${line} COMPILE ${line} ${\n})
	$(info Make sure libantlr3c and header are in the same place as PATH_EXTEND${\n})
	$(CC) $(SOURCES) $(PATH_EXTEND) $(FLAGS) $(OUTPUT)

c_ben : ## Compile all the sources into the executable
	$(info ${\n} ${line} COMPILE ${line} ${\n})
	$(info Make sure libantlr3c and header are in the same place as PATH_EXTEND${\n})
	$(CC) $(SOURCES) $(PATH_EXTEND) $(FLAGS) $(OUTPUT) -m32

exec : c ## Execute the program with ./Tests/test.tiger file as input
	$(info ${\n} ${line} EXECUTION ${line} ${\n})
	./tigerc ./test/test.tiger

test_report : ## Generate PDF files containing AST from tests files
	$(info ${\n} ${line} GENERATING PDF ${line} ${\n})
	antlr3 ./src/Tiger.g -language Java -make -fo test/build
	javac -cp "test/build/jar/*" test/build/*.java
	java -cp test/build/jar/*:test/build TestGenerator
	java -cp test/build/jar/*:test/build ReportGenerator
	pdflatex Report.tex
	pdflatex Report.tex

iup : exec ## compile asm file into .iup and launch simulator
	java -jar microPIUPK.jar -ass a.asm

sim :
	java -jar microPIUPK.jar -sim


###########################
########### HELP ##########
###########################
.PHONY: help
help :
	@grep -E '^[a-zA-Z_-]+ :.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
.DEFAULT_GOAL := help
