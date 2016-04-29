/** \file
 *  This C header file was generated by $ANTLR version 3.4
 *
 *     -  From the grammar source file : ./src/Tiger.g
 *     -                            On : 2016-04-25 20:26:39
 *     -                for the parser : TigerParserParser
 *
 * Editing it, at least manually, is not wise.
 *
 * C language generator and runtime by Jim Idle, jimi|hereisanat|idle|dotgoeshere|ws.
 *
 *
 * The parser 
TigerParser

has the callable functions (rules) shown below,
 * which will invoke the code for the associated rule in the source grammar
 * assuming that the input stream is pointing to a token/text stream that could begin
 * this rule.
 *
 * For instance if you call the first (topmost) rule in a parser grammar, you will
 * get the results of a full parse, but calling a rule half way through the grammar will
 * allow you to pass part of a full token stream to the parser, such as for syntax checking
 * in editors and so on.
 *
 * The parser entry points are called indirectly (by function pointer to function) via
 * a parser context typedef pTigerParser, which is returned from a call to TigerParserNew().
 *
 * The methods in pTigerParser are  as follows:
 *
 *  - 
 TigerParser_program_return
      pTigerParser->program(pTigerParser)
 *  - 
 TigerParser_instructions_return
      pTigerParser->instructions(pTigerParser)
 *  - 
 TigerParser_declaration_return
      pTigerParser->declaration(pTigerParser)
 *  - 
 TigerParser_params_return
      pTigerParser->params(pTigerParser)
 *  - 
 TigerParser_param_return
      pTigerParser->param(pTigerParser)
 *  - 
 TigerParser_instruction_return
      pTigerParser->instruction(pTigerParser)
 *  - 
 TigerParser_atom_return
      pTigerParser->atom(pTigerParser)
 *  - 
 TigerParser_expr_return
      pTigerParser->expr(pTigerParser)
 *  - 
 TigerParser_assignExpr_return
      pTigerParser->assignExpr(pTigerParser)
 *  - 
 TigerParser_logExpr_return
      pTigerParser->logExpr(pTigerParser)
 *  - 
 TigerParser_andExpr_return
      pTigerParser->andExpr(pTigerParser)
 *  - 
 TigerParser_compExpr_return
      pTigerParser->compExpr(pTigerParser)
 *  - 
 TigerParser_addMinExpr_return
      pTigerParser->addMinExpr(pTigerParser)
 *  - 
 TigerParser_multDivExpr_return
      pTigerParser->multDivExpr(pTigerParser)
 *  - 
 TigerParser_addMin_return
      pTigerParser->addMin(pTigerParser)
 *  - 
 TigerParser_multDiv_return
      pTigerParser->multDiv(pTigerParser)
 *  - 
 TigerParser_comp_return
      pTigerParser->comp(pTigerParser)
 *  - 
 TigerParser_and_return
      pTigerParser->and(pTigerParser)
 *  - 
 TigerParser_or_return
      pTigerParser->or(pTigerParser)
 *  - 
 TigerParser_assign_return
      pTigerParser->assign(pTigerParser)
 *
 * The return type for any particular rule is of course determined by the source
 * grammar file.
 */
// [The "BSD license"]
// Copyright (c) 2005-2009 Jim Idle, Temporal Wave LLC
// http://www.temporal-wave.com
// http://www.linkedin.com/in/jimidle
//
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
// 1. Redistributions of source code must retain the above copyright
//    notice, this list of conditions and the following disclaimer.
// 2. Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
// 3. The name of the author may not be used to endorse or promote products
//    derived from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
// IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
// OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
// IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
// NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
// THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

#ifndef	_TigerParser_H
#define _TigerParser_H
/* =============================================================================
 * Standard antlr3 C runtime definitions
 */
#include    <antlr3.h>

/* End of standard antlr 3 runtime definitions
 * =============================================================================
 */

#ifdef __cplusplus
extern "C" {
#endif

// Forward declare the context typedef so that we can use it before it is
// properly defined. Delegators and delegates (from import statements) are
// interdependent and their context structures contain pointers to each other
// C only allows such things to be declared if you pre-declare the typedef.
//
typedef struct TigerParser_Ctx_struct TigerParser, * pTigerParser;



#ifdef	ANTLR3_WINDOWS
// Disable: Unreferenced parameter,							- Rules with parameters that are not used
//          constant conditional,							- ANTLR realizes that a prediction is always true (synpred usually)
//          initialized but unused variable					- tree rewrite variables declared but not needed
//          Unreferenced local variable						- lexer rule declares but does not always use _type
//          potentially unitialized variable used			- retval always returned from a rule
//			unreferenced local function has been removed	- susually getTokenNames or freeScope, they can go without warnigns
//
// These are only really displayed at warning level /W4 but that is the code ideal I am aiming at
// and the codegen must generate some of these warnings by necessity, apart from 4100, which is
// usually generated when a parser rule is given a parameter that it does not use. Mostly though
// this is a matter of orthogonality hence I disable that one.
//
#pragma warning( disable : 4100 )
#pragma warning( disable : 4101 )
#pragma warning( disable : 4127 )
#pragma warning( disable : 4189 )
#pragma warning( disable : 4505 )
#pragma warning( disable : 4701 )
#endif
typedef struct TigerParser_program_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_program_return;



typedef struct TigerParser_instructions_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_instructions_return;



typedef struct TigerParser_declaration_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_declaration_return;



typedef struct TigerParser_params_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_params_return;



typedef struct TigerParser_param_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_param_return;



typedef struct TigerParser_instruction_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_instruction_return;



typedef struct TigerParser_atom_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_atom_return;



typedef struct TigerParser_expr_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_expr_return;



typedef struct TigerParser_assignExpr_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_assignExpr_return;



typedef struct TigerParser_logExpr_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_logExpr_return;



typedef struct TigerParser_andExpr_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_andExpr_return;



typedef struct TigerParser_compExpr_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_compExpr_return;



typedef struct TigerParser_addMinExpr_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_addMinExpr_return;



typedef struct TigerParser_multDivExpr_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_multDivExpr_return;



typedef struct TigerParser_addMin_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_addMin_return;



typedef struct TigerParser_multDiv_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_multDiv_return;



typedef struct TigerParser_comp_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_comp_return;



typedef struct TigerParser_and_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_and_return;



typedef struct TigerParser_or_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_or_return;



typedef struct TigerParser_assign_return_struct
{
    /** Generic return elements for ANTLR3 rules that are not in tree parsers or returning trees
     */
    pANTLR3_COMMON_TOKEN    start;
    pANTLR3_COMMON_TOKEN    stop;
    pANTLR3_BASE_TREE	tree;

}
    TigerParser_assign_return;




/** Context tracking structure for 
TigerParser

 */
struct TigerParser_Ctx_struct
{
    /** Built in ANTLR3 context tracker contains all the generic elements
     *  required for context tracking.
     */
    pANTLR3_PARSER   pParser;

     TigerParser_program_return
     (*program)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_instructions_return
     (*instructions)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_declaration_return
     (*declaration)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_params_return
     (*params)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_param_return
     (*param)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_instruction_return
     (*instruction)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_atom_return
     (*atom)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_expr_return
     (*expr)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_assignExpr_return
     (*assignExpr)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_logExpr_return
     (*logExpr)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_andExpr_return
     (*andExpr)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_compExpr_return
     (*compExpr)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_addMinExpr_return
     (*addMinExpr)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_multDivExpr_return
     (*multDivExpr)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_addMin_return
     (*addMin)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_multDiv_return
     (*multDiv)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_comp_return
     (*comp)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_and_return
     (*and)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_or_return
     (*or)	(struct TigerParser_Ctx_struct * ctx);

     TigerParser_assign_return
     (*assign)	(struct TigerParser_Ctx_struct * ctx);
    // Delegated rules

    const char * (*getGrammarFileName)();
    void            (*reset)  (struct TigerParser_Ctx_struct * ctx);
    void	    (*free)   (struct TigerParser_Ctx_struct * ctx);
/* @headerFile.members() */
pANTLR3_BASE_TREE_ADAPTOR	adaptor;
pANTLR3_VECTOR_FACTORY		vectors;
/* End @headerFile.members() */
};

// Function protoypes for the constructor functions that external translation units
// such as delegators and delegates may wish to call.
//
ANTLR3_API pTigerParser TigerParserNew         (
pANTLR3_COMMON_TOKEN_STREAM
 instream);
ANTLR3_API pTigerParser TigerParserNewSSD      (
pANTLR3_COMMON_TOKEN_STREAM
 instream, pANTLR3_RECOGNIZER_SHARED_STATE state);

/** Symbolic definitions of all the tokens that the 
parser
 will work with.
 * \{
 *
 * Antlr will define EOF, but we can't use that as it it is too common in
 * in C header files and that would be confusing. There is no way to filter this out at the moment
 * so we just undef it here for now. That isn't the value we get back from C recognizers
 * anyway. We are looking for ANTLR3_TOKEN_EOF.
 */
#ifdef	EOF
#undef	EOF
#endif
#ifdef	Tokens
#undef	Tokens
#endif
#define EOF      -1
#define T__34      34
#define T__35      35
#define T__36      36
#define T__37      37
#define T__38      38
#define T__39      39
#define T__40      40
#define T__41      41
#define T__42      42
#define T__43      43
#define T__44      44
#define T__45      45
#define T__46      46
#define T__47      47
#define T__48      48
#define T__49      49
#define T__50      50
#define T__51      51
#define T__52      52
#define T__53      53
#define T__54      54
#define T__55      55
#define T__56      56
#define T__57      57
#define T__58      58
#define T__59      59
#define T__60      60
#define T__61      61
#define T__62      62
#define T__63      63
#define T__64      64
#define T__65      65
#define T__66      66
#define ADD      4
#define AND      5
#define ARGS      6
#define ASSIGNE      7
#define BREAK      8
#define COMMENT      9
#define COMP      10
#define DECLARATIONS      11
#define EXPR      12
#define FOR      13
#define FUNC_DECLARATION      14
#define ID      15
#define IF      16
#define INSTRUCTIONS      17
#define INT      18
#define INTEGER      19
#define LET      20
#define LETTER      21
#define MULT      22
#define NEG      23
#define NIL      24
#define OR      25
#define PARAM      26
#define PARAMS      27
#define RETURN      28
#define STR      29
#define STRING      30
#define VAR_DECLARATION      31
#define WHILE      32
#define WHITESPACE      33
#ifdef	EOF
#undef	EOF
#define	EOF	ANTLR3_TOKEN_EOF
#endif

#ifndef TOKENSOURCE
#define TOKENSOURCE(lxr) lxr->pLexer->rec->state->tokSource
#endif

/* End of token definitions for TigerParser
 * =============================================================================
 */
/** } */

#ifdef __cplusplus
}
#endif

#endif

/* END - Note:Keep extra line feed to satisfy UNIX systems */
