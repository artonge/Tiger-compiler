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
          ./src/TigerLexer.c \
          ./src/TigerParser.c


FLAGS =	-pedantic \
        -pedantic-errors \
				# -Wall
				# -ansi

PATH_EXTEND = -I /usr/local/include/
OUTPUT = -o ./main.out


###########################
######## COMMANDES ########
###########################
all : clean grammar c exec ## clean grammar c exec

grammar : ## Compile the grammar using antlr3
	$(info ${\n} ${line} GRAMMAR ${line} ${\n})
	antlr3 ./src/Tiger.g

c : ## Compile all the sources into the executable
	$(info ${\n} ${line} COMPILE ${line} ${\n})
	$(CC) $(SOURCES) $(PATH_EXTEND) $(FLAGS) $(OUTPUT)

exec : ## Execute the program
	$(info ${\n} ${line} EXECUTION ${line} ${\n})
	./main.out

clean : ## Clean the project
	$(info ${\n} ${line} CLEAN ${line} ${\n})
	rm -f m*.out


###########################
########### HELP ##########
###########################
.PHONY: help
help :
	@grep -E '^[a-zA-Z_-]+ :.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
.DEFAULT_GOAL := help
