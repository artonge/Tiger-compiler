// $ANTLR 3.5.1 /Users/moshi/compilation/src/Tiger.g 2016-04-29 12:25:19

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class TigerParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "AND", "ARGS", "ASSIGNE", 
		"COMMENT", "COMP", "DECLARATIONS", "EXPR", "FOR", "FUNC_DECLARATION", 
		"ID", "IF", "INSTRUCTIONS", "INT", "INTEGER", "LET", "LETTER", "MULT", 
		"NEG", "NIL", "OR", "PARAM", "PARAMS", "STR", "STRING", "TYPE", "VAR_DECLARATION", 
		"WHILE", "WHITESPACE", "'&'", "'('", "')'", "'*'", "'+'", "','", "'-'", 
		"'/'", "':'", "':='", "';'", "'<'", "'<='", "'<>'", "'='", "'>'", "'>='", 
		"'break'", "'do'", "'else'", "'end'", "'for'", "'function'", "'if'", "'in'", 
		"'let'", "'nil'", "'then'", "'to'", "'var'", "'while'", "'|'"
	};
	public static final int EOF=-1;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int ADD=4;
	public static final int AND=5;
	public static final int ARGS=6;
	public static final int ASSIGNE=7;
	public static final int COMMENT=8;
	public static final int COMP=9;
	public static final int DECLARATIONS=10;
	public static final int EXPR=11;
	public static final int FOR=12;
	public static final int FUNC_DECLARATION=13;
	public static final int ID=14;
	public static final int IF=15;
	public static final int INSTRUCTIONS=16;
	public static final int INT=17;
	public static final int INTEGER=18;
	public static final int LET=19;
	public static final int LETTER=20;
	public static final int MULT=21;
	public static final int NEG=22;
	public static final int NIL=23;
	public static final int OR=24;
	public static final int PARAM=25;
	public static final int PARAMS=26;
	public static final int STR=27;
	public static final int STRING=28;
	public static final int TYPE=29;
	public static final int VAR_DECLARATION=30;
	public static final int WHILE=31;
	public static final int WHITESPACE=32;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "multDiv", "instructions", "multDivExpr", "atom", "assign", 
		"instruction", "params", "addMin", "compExpr", "and", "addMinExpr", "param", 
		"expr", "program", "logExpr", "andExpr", "comp", "or", "assignExpr", "declaration"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public TigerParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public TigerParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public TigerParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return TigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/moshi/compilation/src/Tiger.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// /Users/moshi/compilation/src/Tiger.g:28:1: program : instructions ;
	public final TigerParser.program_return program() throws RecognitionException {
		TigerParser.program_return retval = new TigerParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope instructions1 =null;


		try { dbg.enterRule(getGrammarFileName(), "program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(28, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:28:9: ( instructions )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:28:11: instructions
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(28,11);
			pushFollow(FOLLOW_instructions_in_program249);
			instructions1=instructions();
			state._fsp--;

			adaptor.addChild(root_0, instructions1.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(28, 23);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "program"


	public static class instructions_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "instructions"
	// /Users/moshi/compilation/src/Tiger.g:30:1: instructions : instruction -> ^( INSTRUCTIONS instruction ) ;
	public final TigerParser.instructions_return instructions() throws RecognitionException {
		TigerParser.instructions_return retval = new TigerParser.instructions_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope instruction2 =null;

		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");

		try { dbg.enterRule(getGrammarFileName(), "instructions");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(30, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:31:3: ( instruction -> ^( INSTRUCTIONS instruction ) )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:31:5: instruction
			{
			dbg.location(31,5);
			pushFollow(FOLLOW_instruction_in_instructions260);
			instruction2=instruction();
			state._fsp--;

			stream_instruction.add(instruction2.getTree());
			// AST REWRITE
			// elements: instruction
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 31:81: -> ^( INSTRUCTIONS instruction )
			{
				dbg.location(31,84);
				// /Users/moshi/compilation/src/Tiger.g:31:84: ^( INSTRUCTIONS instruction )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(31,86);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INSTRUCTIONS, "INSTRUCTIONS"), root_1);
				dbg.location(31,99);
				adaptor.addChild(root_1, stream_instruction.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(32, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "instructions");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "instructions"


	public static class declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// /Users/moshi/compilation/src/Tiger.g:36:1: declaration : ( 'var' name= ID ( ':' type= ID )? ':=' expr -> ^( VAR_DECLARATION $name ( $type)? expr ) | 'function' name= ID params ( ':' return_type= ID )? '=' instructions -> ^( FUNC_DECLARATION $name params ^( TYPE ( $return_type)? ) instructions ) );
	public final TigerParser.declaration_return declaration() throws RecognitionException {
		TigerParser.declaration_return retval = new TigerParser.declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token name=null;
		Token type=null;
		Token return_type=null;
		Token string_literal3=null;
		Token char_literal4=null;
		Token string_literal5=null;
		Token string_literal7=null;
		Token char_literal9=null;
		Token char_literal10=null;
		ParserRuleReturnScope expr6 =null;
		ParserRuleReturnScope params8 =null;
		ParserRuleReturnScope instructions11 =null;

		Object name_tree=null;
		Object type_tree=null;
		Object return_type_tree=null;
		Object string_literal3_tree=null;
		Object char_literal4_tree=null;
		Object string_literal5_tree=null;
		Object string_literal7_tree=null;
		Object char_literal9_tree=null;
		Object char_literal10_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_instructions=new RewriteRuleSubtreeStream(adaptor,"rule instructions");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_params=new RewriteRuleSubtreeStream(adaptor,"rule params");

		try { dbg.enterRule(getGrammarFileName(), "declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(36, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:37:3: ( 'var' name= ID ( ':' type= ID )? ':=' expr -> ^( VAR_DECLARATION $name ( $type)? expr ) | 'function' name= ID params ( ':' return_type= ID )? '=' instructions -> ^( FUNC_DECLARATION $name params ^( TYPE ( $return_type)? ) instructions ) )
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==62) ) {
				alt3=1;
			}
			else if ( (LA3_0==55) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:37:5: 'var' name= ID ( ':' type= ID )? ':=' expr
					{
					dbg.location(37,5);
					string_literal3=(Token)match(input,62,FOLLOW_62_in_declaration347);  
					stream_62.add(string_literal3);
					dbg.location(37,15);
					name=(Token)match(input,ID,FOLLOW_ID_in_declaration351);  
					stream_ID.add(name);
					dbg.location(37,19);
					// /Users/moshi/compilation/src/Tiger.g:37:19: ( ':' type= ID )?
					int alt1=2;
					try { dbg.enterSubRule(1);
					try { dbg.enterDecision(1, decisionCanBacktrack[1]);

					int LA1_0 = input.LA(1);
					if ( (LA1_0==41) ) {
						alt1=1;
					}
					} finally {dbg.exitDecision(1);}

					switch (alt1) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:37:20: ':' type= ID
							{
							dbg.location(37,20);
							char_literal4=(Token)match(input,41,FOLLOW_41_in_declaration354);  
							stream_41.add(char_literal4);
							dbg.location(37,28);
							type=(Token)match(input,ID,FOLLOW_ID_in_declaration358);  
							stream_ID.add(type);

							}
							break;

					}
					} finally {dbg.exitSubRule(1);}
					dbg.location(37,34);
					string_literal5=(Token)match(input,42,FOLLOW_42_in_declaration362);  
					stream_42.add(string_literal5);
					dbg.location(37,39);
					pushFollow(FOLLOW_expr_in_declaration364);
					expr6=expr();
					state._fsp--;

					stream_expr.add(expr6.getTree());
					// AST REWRITE
					// elements: expr, name, type
					// token labels: name, type
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
					RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 37:81: -> ^( VAR_DECLARATION $name ( $type)? expr )
					{
						dbg.location(37,84);
						// /Users/moshi/compilation/src/Tiger.g:37:84: ^( VAR_DECLARATION $name ( $type)? expr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(37,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_DECLARATION, "VAR_DECLARATION"), root_1);
						dbg.location(37,103);
						adaptor.addChild(root_1, stream_name.nextNode());dbg.location(37,109);
						// /Users/moshi/compilation/src/Tiger.g:37:109: ( $type)?
						if ( stream_type.hasNext() ) {
							dbg.location(37,109);
							adaptor.addChild(root_1, stream_type.nextNode());
						}
						stream_type.reset();
						dbg.location(37,115);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/moshi/compilation/src/Tiger.g:38:5: 'function' name= ID params ( ':' return_type= ID )? '=' instructions
					{
					dbg.location(38,5);
					string_literal7=(Token)match(input,55,FOLLOW_55_in_declaration422);  
					stream_55.add(string_literal7);
					dbg.location(38,20);
					name=(Token)match(input,ID,FOLLOW_ID_in_declaration426);  
					stream_ID.add(name);
					dbg.location(38,24);
					pushFollow(FOLLOW_params_in_declaration428);
					params8=params();
					state._fsp--;

					stream_params.add(params8.getTree());dbg.location(38,31);
					// /Users/moshi/compilation/src/Tiger.g:38:31: ( ':' return_type= ID )?
					int alt2=2;
					try { dbg.enterSubRule(2);
					try { dbg.enterDecision(2, decisionCanBacktrack[2]);

					int LA2_0 = input.LA(1);
					if ( (LA2_0==41) ) {
						alt2=1;
					}
					} finally {dbg.exitDecision(2);}

					switch (alt2) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:38:32: ':' return_type= ID
							{
							dbg.location(38,32);
							char_literal9=(Token)match(input,41,FOLLOW_41_in_declaration431);  
							stream_41.add(char_literal9);
							dbg.location(38,47);
							return_type=(Token)match(input,ID,FOLLOW_ID_in_declaration435);  
							stream_ID.add(return_type);

							}
							break;

					}
					} finally {dbg.exitSubRule(2);}
					dbg.location(38,53);
					char_literal10=(Token)match(input,47,FOLLOW_47_in_declaration439);  
					stream_47.add(char_literal10);
					dbg.location(38,57);
					pushFollow(FOLLOW_instructions_in_declaration441);
					instructions11=instructions();
					state._fsp--;

					stream_instructions.add(instructions11.getTree());
					// AST REWRITE
					// elements: params, name, return_type, instructions
					// token labels: return_type, name
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_return_type=new RewriteRuleTokenStream(adaptor,"token return_type",return_type);
					RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 38:81: -> ^( FUNC_DECLARATION $name params ^( TYPE ( $return_type)? ) instructions )
					{
						dbg.location(38,84);
						// /Users/moshi/compilation/src/Tiger.g:38:84: ^( FUNC_DECLARATION $name params ^( TYPE ( $return_type)? ) instructions )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(38,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_DECLARATION, "FUNC_DECLARATION"), root_1);
						dbg.location(38,104);
						adaptor.addChild(root_1, stream_name.nextNode());dbg.location(38,109);
						adaptor.addChild(root_1, stream_params.nextTree());dbg.location(38,116);
						// /Users/moshi/compilation/src/Tiger.g:38:116: ^( TYPE ( $return_type)? )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(38,118);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPE, "TYPE"), root_2);
						dbg.location(38,124);
						// /Users/moshi/compilation/src/Tiger.g:38:124: ( $return_type)?
						if ( stream_return_type.hasNext() ) {
							dbg.location(38,124);
							adaptor.addChild(root_2, stream_return_type.nextNode());
						}
						stream_return_type.reset();

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(38,138);
						adaptor.addChild(root_1, stream_instructions.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(39, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "declaration"


	public static class params_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "params"
	// /Users/moshi/compilation/src/Tiger.g:41:1: params : '(' ( param ( ',' param )* )? ')' -> ^( PARAMS ( param )* ) ;
	public final TigerParser.params_return params() throws RecognitionException {
		TigerParser.params_return retval = new TigerParser.params_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal12=null;
		Token char_literal14=null;
		Token char_literal16=null;
		ParserRuleReturnScope param13 =null;
		ParserRuleReturnScope param15 =null;

		Object char_literal12_tree=null;
		Object char_literal14_tree=null;
		Object char_literal16_tree=null;
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");

		try { dbg.enterRule(getGrammarFileName(), "params");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(41, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:42:3: ( '(' ( param ( ',' param )* )? ')' -> ^( PARAMS ( param )* ) )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:42:5: '(' ( param ( ',' param )* )? ')'
			{
			dbg.location(42,5);
			char_literal12=(Token)match(input,34,FOLLOW_34_in_params486);  
			stream_34.add(char_literal12);
			dbg.location(42,9);
			// /Users/moshi/compilation/src/Tiger.g:42:9: ( param ( ',' param )* )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==ID) ) {
				alt5=1;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:42:11: param ( ',' param )*
					{
					dbg.location(42,11);
					pushFollow(FOLLOW_param_in_params490);
					param13=param();
					state._fsp--;

					stream_param.add(param13.getTree());dbg.location(42,17);
					// /Users/moshi/compilation/src/Tiger.g:42:17: ( ',' param )*
					try { dbg.enterSubRule(4);

					loop4:
					while (true) {
						int alt4=2;
						try { dbg.enterDecision(4, decisionCanBacktrack[4]);

						int LA4_0 = input.LA(1);
						if ( (LA4_0==38) ) {
							alt4=1;
						}

						} finally {dbg.exitDecision(4);}

						switch (alt4) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:42:18: ',' param
							{
							dbg.location(42,18);
							char_literal14=(Token)match(input,38,FOLLOW_38_in_params493);  
							stream_38.add(char_literal14);
							dbg.location(42,22);
							pushFollow(FOLLOW_param_in_params495);
							param15=param();
							state._fsp--;

							stream_param.add(param15.getTree());
							}
							break;

						default :
							break loop4;
						}
					}
					} finally {dbg.exitSubRule(4);}

					}
					break;

			}
			} finally {dbg.exitSubRule(5);}
			dbg.location(42,32);
			char_literal16=(Token)match(input,35,FOLLOW_35_in_params501);  
			stream_35.add(char_literal16);

			// AST REWRITE
			// elements: param
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 42:81: -> ^( PARAMS ( param )* )
			{
				dbg.location(42,84);
				// /Users/moshi/compilation/src/Tiger.g:42:84: ^( PARAMS ( param )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(42,86);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMS, "PARAMS"), root_1);
				dbg.location(42,93);
				// /Users/moshi/compilation/src/Tiger.g:42:93: ( param )*
				while ( stream_param.hasNext() ) {
					dbg.location(42,93);
					adaptor.addChild(root_1, stream_param.nextTree());
				}
				stream_param.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(43, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "params");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "params"


	public static class param_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "param"
	// /Users/moshi/compilation/src/Tiger.g:44:1: param : name= ID ':' type= ID -> ^( PARAM $name $type) ;
	public final TigerParser.param_return param() throws RecognitionException {
		TigerParser.param_return retval = new TigerParser.param_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token name=null;
		Token type=null;
		Token char_literal17=null;

		Object name_tree=null;
		Object type_tree=null;
		Object char_literal17_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");

		try { dbg.enterRule(getGrammarFileName(), "param");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(44, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:45:3: (name= ID ':' type= ID -> ^( PARAM $name $type) )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:45:5: name= ID ':' type= ID
			{
			dbg.location(45,9);
			name=(Token)match(input,ID,FOLLOW_ID_in_param569);  
			stream_ID.add(name);
			dbg.location(45,13);
			char_literal17=(Token)match(input,41,FOLLOW_41_in_param571);  
			stream_41.add(char_literal17);
			dbg.location(45,21);
			type=(Token)match(input,ID,FOLLOW_ID_in_param575);  
			stream_ID.add(type);

			// AST REWRITE
			// elements: name, type
			// token labels: name, type
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
			RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 45:81: -> ^( PARAM $name $type)
			{
				dbg.location(45,84);
				// /Users/moshi/compilation/src/Tiger.g:45:84: ^( PARAM $name $type)
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(45,86);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAM, "PARAM"), root_1);
				dbg.location(45,93);
				adaptor.addChild(root_1, stream_name.nextNode());dbg.location(45,99);
				adaptor.addChild(root_1, stream_type.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(46, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "param"


	public static class instruction_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "instruction"
	// /Users/moshi/compilation/src/Tiger.g:50:1: instruction : ( 'let' ( declaration )+ 'in' instructions 'end' -> ^( LET ^( DECLARATIONS ( declaration )+ ) instructions ) | expr | 'if' expr 'then' i1= instructions ( options {greedy=true; } : 'else' i2= instructions )? -> ^( IF expr $i1 ( $i2)? ) | 'while' expr 'do' instructions -> ^( WHILE expr instructions ) | 'for' ID ':=' v1= expr 'to' v2= expr 'do' instructions -> ^( FOR ID $v1 $v2 instructions ) | 'break' );
	public final TigerParser.instruction_return instruction() throws RecognitionException {
		TigerParser.instruction_return retval = new TigerParser.instruction_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal18=null;
		Token string_literal20=null;
		Token string_literal22=null;
		Token string_literal24=null;
		Token string_literal26=null;
		Token string_literal27=null;
		Token string_literal28=null;
		Token string_literal30=null;
		Token string_literal32=null;
		Token ID33=null;
		Token string_literal34=null;
		Token string_literal35=null;
		Token string_literal36=null;
		Token string_literal38=null;
		ParserRuleReturnScope i1 =null;
		ParserRuleReturnScope i2 =null;
		ParserRuleReturnScope v1 =null;
		ParserRuleReturnScope v2 =null;
		ParserRuleReturnScope declaration19 =null;
		ParserRuleReturnScope instructions21 =null;
		ParserRuleReturnScope expr23 =null;
		ParserRuleReturnScope expr25 =null;
		ParserRuleReturnScope expr29 =null;
		ParserRuleReturnScope instructions31 =null;
		ParserRuleReturnScope instructions37 =null;

		Object string_literal18_tree=null;
		Object string_literal20_tree=null;
		Object string_literal22_tree=null;
		Object string_literal24_tree=null;
		Object string_literal26_tree=null;
		Object string_literal27_tree=null;
		Object string_literal28_tree=null;
		Object string_literal30_tree=null;
		Object string_literal32_tree=null;
		Object ID33_tree=null;
		Object string_literal34_tree=null;
		Object string_literal35_tree=null;
		Object string_literal36_tree=null;
		Object string_literal38_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_instructions=new RewriteRuleSubtreeStream(adaptor,"rule instructions");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");

		try { dbg.enterRule(getGrammarFileName(), "instruction");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(50, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:51:3: ( 'let' ( declaration )+ 'in' instructions 'end' -> ^( LET ^( DECLARATIONS ( declaration )+ ) instructions ) | expr | 'if' expr 'then' i1= instructions ( options {greedy=true; } : 'else' i2= instructions )? -> ^( IF expr $i1 ( $i2)? ) | 'while' expr 'do' instructions -> ^( WHILE expr instructions ) | 'for' ID ':=' v1= expr 'to' v2= expr 'do' instructions -> ^( FOR ID $v1 $v2 instructions ) | 'break' )
			int alt8=6;
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			switch ( input.LA(1) ) {
			case 58:
				{
				alt8=1;
				}
				break;
			case ID:
			case INTEGER:
			case STRING:
			case 34:
			case 39:
			case 59:
				{
				alt8=2;
				}
				break;
			case 56:
				{
				alt8=3;
				}
				break;
			case 63:
				{
				alt8=4;
				}
				break;
			case 54:
				{
				alt8=5;
				}
				break;
			case 50:
				{
				alt8=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:51:5: 'let' ( declaration )+ 'in' instructions 'end'
					{
					dbg.location(51,5);
					string_literal18=(Token)match(input,58,FOLLOW_58_in_instruction658);  
					stream_58.add(string_literal18);
					dbg.location(51,11);
					// /Users/moshi/compilation/src/Tiger.g:51:11: ( declaration )+
					int cnt6=0;
					try { dbg.enterSubRule(6);

					loop6:
					while (true) {
						int alt6=2;
						try { dbg.enterDecision(6, decisionCanBacktrack[6]);

						int LA6_0 = input.LA(1);
						if ( (LA6_0==55||LA6_0==62) ) {
							alt6=1;
						}

						} finally {dbg.exitDecision(6);}

						switch (alt6) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:51:11: declaration
							{
							dbg.location(51,11);
							pushFollow(FOLLOW_declaration_in_instruction660);
							declaration19=declaration();
							state._fsp--;

							stream_declaration.add(declaration19.getTree());
							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt6++;
					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(51,24);
					string_literal20=(Token)match(input,57,FOLLOW_57_in_instruction663);  
					stream_57.add(string_literal20);
					dbg.location(51,29);
					pushFollow(FOLLOW_instructions_in_instruction665);
					instructions21=instructions();
					state._fsp--;

					stream_instructions.add(instructions21.getTree());dbg.location(51,42);
					string_literal22=(Token)match(input,53,FOLLOW_53_in_instruction667);  
					stream_53.add(string_literal22);

					// AST REWRITE
					// elements: declaration, instructions
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 51:81: -> ^( LET ^( DECLARATIONS ( declaration )+ ) instructions )
					{
						dbg.location(51,84);
						// /Users/moshi/compilation/src/Tiger.g:51:84: ^( LET ^( DECLARATIONS ( declaration )+ ) instructions )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(51,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LET, "LET"), root_1);
						dbg.location(51,90);
						// /Users/moshi/compilation/src/Tiger.g:51:90: ^( DECLARATIONS ( declaration )+ )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(51,92);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(DECLARATIONS, "DECLARATIONS"), root_2);
						dbg.location(51,105);
						if ( !(stream_declaration.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_declaration.hasNext() ) {
							dbg.location(51,105);
							adaptor.addChild(root_2, stream_declaration.nextTree());
						}
						stream_declaration.reset();

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(51,119);
						adaptor.addChild(root_1, stream_instructions.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/moshi/compilation/src/Tiger.g:53:5: expr
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(53,5);
					pushFollow(FOLLOW_expr_in_instruction722);
					expr23=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr23.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/moshi/compilation/src/Tiger.g:55:5: 'if' expr 'then' i1= instructions ( options {greedy=true; } : 'else' i2= instructions )?
					{
					dbg.location(55,5);
					string_literal24=(Token)match(input,56,FOLLOW_56_in_instruction729);  
					stream_56.add(string_literal24);
					dbg.location(55,10);
					pushFollow(FOLLOW_expr_in_instruction731);
					expr25=expr();
					state._fsp--;

					stream_expr.add(expr25.getTree());dbg.location(55,15);
					string_literal26=(Token)match(input,60,FOLLOW_60_in_instruction733);  
					stream_60.add(string_literal26);
					dbg.location(55,24);
					pushFollow(FOLLOW_instructions_in_instruction737);
					i1=instructions();
					state._fsp--;

					stream_instructions.add(i1.getTree());dbg.location(56,5);
					// /Users/moshi/compilation/src/Tiger.g:56:5: ( options {greedy=true; } : 'else' i2= instructions )?
					int alt7=2;
					try { dbg.enterSubRule(7);
					try { dbg.enterDecision(7, decisionCanBacktrack[7]);

					int LA7_0 = input.LA(1);
					if ( (LA7_0==52) ) {
						alt7=1;
					}
					} finally {dbg.exitDecision(7);}

					switch (alt7) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:56:31: 'else' i2= instructions
							{
							dbg.location(56,31);
							string_literal27=(Token)match(input,52,FOLLOW_52_in_instruction753);  
							stream_52.add(string_literal27);
							dbg.location(56,40);
							pushFollow(FOLLOW_instructions_in_instruction757);
							i2=instructions();
							state._fsp--;

							stream_instructions.add(i2.getTree());
							}
							break;

					}
					} finally {dbg.exitSubRule(7);}

					// AST REWRITE
					// elements: expr, i1, i2
					// token labels: 
					// rule labels: i1, i2, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_i1=new RewriteRuleSubtreeStream(adaptor,"rule i1",i1!=null?i1.getTree():null);
					RewriteRuleSubtreeStream stream_i2=new RewriteRuleSubtreeStream(adaptor,"rule i2",i2!=null?i2.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 56:81: -> ^( IF expr $i1 ( $i2)? )
					{
						dbg.location(56,84);
						// /Users/moshi/compilation/src/Tiger.g:56:84: ^( IF expr $i1 ( $i2)? )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(56,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						dbg.location(56,89);
						adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(56,95);
						adaptor.addChild(root_1, stream_i1.nextTree());dbg.location(56,99);
						// /Users/moshi/compilation/src/Tiger.g:56:99: ( $i2)?
						if ( stream_i2.hasNext() ) {
							dbg.location(56,99);
							adaptor.addChild(root_1, stream_i2.nextTree());
						}
						stream_i2.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/moshi/compilation/src/Tiger.g:57:5: 'while' expr 'do' instructions
					{
					dbg.location(57,5);
					string_literal28=(Token)match(input,63,FOLLOW_63_in_instruction805);  
					stream_63.add(string_literal28);
					dbg.location(57,13);
					pushFollow(FOLLOW_expr_in_instruction807);
					expr29=expr();
					state._fsp--;

					stream_expr.add(expr29.getTree());dbg.location(57,18);
					string_literal30=(Token)match(input,51,FOLLOW_51_in_instruction809);  
					stream_51.add(string_literal30);
					dbg.location(57,23);
					pushFollow(FOLLOW_instructions_in_instruction811);
					instructions31=instructions();
					state._fsp--;

					stream_instructions.add(instructions31.getTree());
					// AST REWRITE
					// elements: instructions, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 57:81: -> ^( WHILE expr instructions )
					{
						dbg.location(57,84);
						// /Users/moshi/compilation/src/Tiger.g:57:84: ^( WHILE expr instructions )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(57,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						dbg.location(57,92);
						adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(57,97);
						adaptor.addChild(root_1, stream_instructions.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/moshi/compilation/src/Tiger.g:58:5: 'for' ID ':=' v1= expr 'to' v2= expr 'do' instructions
					{
					dbg.location(58,5);
					string_literal32=(Token)match(input,54,FOLLOW_54_in_instruction872);  
					stream_54.add(string_literal32);
					dbg.location(58,11);
					ID33=(Token)match(input,ID,FOLLOW_ID_in_instruction874);  
					stream_ID.add(ID33);
					dbg.location(58,14);
					string_literal34=(Token)match(input,42,FOLLOW_42_in_instruction876);  
					stream_42.add(string_literal34);
					dbg.location(58,21);
					pushFollow(FOLLOW_expr_in_instruction880);
					v1=expr();
					state._fsp--;

					stream_expr.add(v1.getTree());dbg.location(58,27);
					string_literal35=(Token)match(input,61,FOLLOW_61_in_instruction882);  
					stream_61.add(string_literal35);
					dbg.location(58,34);
					pushFollow(FOLLOW_expr_in_instruction886);
					v2=expr();
					state._fsp--;

					stream_expr.add(v2.getTree());dbg.location(58,40);
					string_literal36=(Token)match(input,51,FOLLOW_51_in_instruction888);  
					stream_51.add(string_literal36);
					dbg.location(58,45);
					pushFollow(FOLLOW_instructions_in_instruction890);
					instructions37=instructions();
					state._fsp--;

					stream_instructions.add(instructions37.getTree());
					// AST REWRITE
					// elements: v1, instructions, ID, v2
					// token labels: 
					// rule labels: v1, v2, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_v1=new RewriteRuleSubtreeStream(adaptor,"rule v1",v1!=null?v1.getTree():null);
					RewriteRuleSubtreeStream stream_v2=new RewriteRuleSubtreeStream(adaptor,"rule v2",v2!=null?v2.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 58:81: -> ^( FOR ID $v1 $v2 instructions )
					{
						dbg.location(58,84);
						// /Users/moshi/compilation/src/Tiger.g:58:84: ^( FOR ID $v1 $v2 instructions )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(58,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
						dbg.location(58,90);
						adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(58,94);
						adaptor.addChild(root_1, stream_v1.nextTree());dbg.location(58,98);
						adaptor.addChild(root_1, stream_v2.nextTree());dbg.location(58,101);
						adaptor.addChild(root_1, stream_instructions.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/moshi/compilation/src/Tiger.g:59:5: 'break'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(59,5);
					string_literal38=(Token)match(input,50,FOLLOW_50_in_instruction935); 
					string_literal38_tree = (Object)adaptor.create(string_literal38);
					adaptor.addChild(root_0, string_literal38_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(60, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "instruction");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "instruction"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/moshi/compilation/src/Tiger.g:62:1: atom : ( ID ( '(' ( expr ( ',' expr )* )? ')' )? -> ^( ID ( ^( ARGS ( expr )* ) )? ) | '(' instruction ( ';' instruction )* ')' -> ( instruction )+ | STRING -> ^( STR STRING ) | INTEGER -> ^( INT INTEGER ) | '-' INTEGER -> ^( NEG INTEGER ) | 'nil' -> ^( NIL ) );
	public final TigerParser.atom_return atom() throws RecognitionException {
		TigerParser.atom_return retval = new TigerParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID39=null;
		Token char_literal40=null;
		Token char_literal42=null;
		Token char_literal44=null;
		Token char_literal45=null;
		Token char_literal47=null;
		Token char_literal49=null;
		Token STRING50=null;
		Token INTEGER51=null;
		Token char_literal52=null;
		Token INTEGER53=null;
		Token string_literal54=null;
		ParserRuleReturnScope expr41 =null;
		ParserRuleReturnScope expr43 =null;
		ParserRuleReturnScope instruction46 =null;
		ParserRuleReturnScope instruction48 =null;

		Object ID39_tree=null;
		Object char_literal40_tree=null;
		Object char_literal42_tree=null;
		Object char_literal44_tree=null;
		Object char_literal45_tree=null;
		Object char_literal47_tree=null;
		Object char_literal49_tree=null;
		Object STRING50_tree=null;
		Object INTEGER51_tree=null;
		Object char_literal52_tree=null;
		Object INTEGER53_tree=null;
		Object string_literal54_tree=null;
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(62, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:63:3: ( ID ( '(' ( expr ( ',' expr )* )? ')' )? -> ^( ID ( ^( ARGS ( expr )* ) )? ) | '(' instruction ( ';' instruction )* ')' -> ( instruction )+ | STRING -> ^( STR STRING ) | INTEGER -> ^( INT INTEGER ) | '-' INTEGER -> ^( NEG INTEGER ) | 'nil' -> ^( NIL ) )
			int alt13=6;
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			switch ( input.LA(1) ) {
			case ID:
				{
				alt13=1;
				}
				break;
			case 34:
				{
				alt13=2;
				}
				break;
			case STRING:
				{
				alt13=3;
				}
				break;
			case INTEGER:
				{
				alt13=4;
				}
				break;
			case 39:
				{
				alt13=5;
				}
				break;
			case 59:
				{
				alt13=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:63:5: ID ( '(' ( expr ( ',' expr )* )? ')' )?
					{
					dbg.location(63,5);
					ID39=(Token)match(input,ID,FOLLOW_ID_in_atom948);  
					stream_ID.add(ID39);
					dbg.location(63,8);
					// /Users/moshi/compilation/src/Tiger.g:63:8: ( '(' ( expr ( ',' expr )* )? ')' )?
					int alt11=2;
					try { dbg.enterSubRule(11);
					try { dbg.enterDecision(11, decisionCanBacktrack[11]);

					int LA11_0 = input.LA(1);
					if ( (LA11_0==34) ) {
						alt11=1;
					}
					} finally {dbg.exitDecision(11);}

					switch (alt11) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:63:9: '(' ( expr ( ',' expr )* )? ')'
							{
							dbg.location(63,9);
							char_literal40=(Token)match(input,34,FOLLOW_34_in_atom951);  
							stream_34.add(char_literal40);
							dbg.location(63,13);
							// /Users/moshi/compilation/src/Tiger.g:63:13: ( expr ( ',' expr )* )?
							int alt10=2;
							try { dbg.enterSubRule(10);
							try { dbg.enterDecision(10, decisionCanBacktrack[10]);

							int LA10_0 = input.LA(1);
							if ( (LA10_0==ID||LA10_0==INTEGER||LA10_0==STRING||LA10_0==34||LA10_0==39||LA10_0==59) ) {
								alt10=1;
							}
							} finally {dbg.exitDecision(10);}

							switch (alt10) {
								case 1 :
									dbg.enterAlt(1);

									// /Users/moshi/compilation/src/Tiger.g:63:14: expr ( ',' expr )*
									{
									dbg.location(63,14);
									pushFollow(FOLLOW_expr_in_atom954);
									expr41=expr();
									state._fsp--;

									stream_expr.add(expr41.getTree());dbg.location(63,19);
									// /Users/moshi/compilation/src/Tiger.g:63:19: ( ',' expr )*
									try { dbg.enterSubRule(9);

									loop9:
									while (true) {
										int alt9=2;
										try { dbg.enterDecision(9, decisionCanBacktrack[9]);

										int LA9_0 = input.LA(1);
										if ( (LA9_0==38) ) {
											alt9=1;
										}

										} finally {dbg.exitDecision(9);}

										switch (alt9) {
										case 1 :
											dbg.enterAlt(1);

											// /Users/moshi/compilation/src/Tiger.g:63:20: ',' expr
											{
											dbg.location(63,20);
											char_literal42=(Token)match(input,38,FOLLOW_38_in_atom957);  
											stream_38.add(char_literal42);
											dbg.location(63,24);
											pushFollow(FOLLOW_expr_in_atom959);
											expr43=expr();
											state._fsp--;

											stream_expr.add(expr43.getTree());
											}
											break;

										default :
											break loop9;
										}
									}
									} finally {dbg.exitSubRule(9);}

									}
									break;

							}
							} finally {dbg.exitSubRule(10);}
							dbg.location(63,33);
							char_literal44=(Token)match(input,35,FOLLOW_35_in_atom965);  
							stream_35.add(char_literal44);

							}
							break;

					}
					} finally {dbg.exitSubRule(11);}

					// AST REWRITE
					// elements: expr, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 63:81: -> ^( ID ( ^( ARGS ( expr )* ) )? )
					{
						dbg.location(63,84);
						// /Users/moshi/compilation/src/Tiger.g:63:84: ^( ID ( ^( ARGS ( expr )* ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(63,86);
						root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
						dbg.location(63,89);
						// /Users/moshi/compilation/src/Tiger.g:63:89: ( ^( ARGS ( expr )* ) )?
						if ( stream_expr.hasNext() ) {
							dbg.location(63,89);
							// /Users/moshi/compilation/src/Tiger.g:63:89: ^( ARGS ( expr )* )
							{
							Object root_2 = (Object)adaptor.nil();
							dbg.location(63,91);
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGS, "ARGS"), root_2);
							dbg.location(63,96);
							// /Users/moshi/compilation/src/Tiger.g:63:96: ( expr )*
							while ( stream_expr.hasNext() ) {
								dbg.location(63,96);
								adaptor.addChild(root_2, stream_expr.nextTree());
							}
							stream_expr.reset();

							adaptor.addChild(root_1, root_2);
							}

						}
						stream_expr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/moshi/compilation/src/Tiger.g:65:5: '(' instruction ( ';' instruction )* ')'
					{
					dbg.location(65,5);
					char_literal45=(Token)match(input,34,FOLLOW_34_in_atom1030);  
					stream_34.add(char_literal45);
					dbg.location(65,9);
					pushFollow(FOLLOW_instruction_in_atom1032);
					instruction46=instruction();
					state._fsp--;

					stream_instruction.add(instruction46.getTree());dbg.location(65,21);
					// /Users/moshi/compilation/src/Tiger.g:65:21: ( ';' instruction )*
					try { dbg.enterSubRule(12);

					loop12:
					while (true) {
						int alt12=2;
						try { dbg.enterDecision(12, decisionCanBacktrack[12]);

						int LA12_0 = input.LA(1);
						if ( (LA12_0==43) ) {
							alt12=1;
						}

						} finally {dbg.exitDecision(12);}

						switch (alt12) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:65:22: ';' instruction
							{
							dbg.location(65,22);
							char_literal47=(Token)match(input,43,FOLLOW_43_in_atom1035);  
							stream_43.add(char_literal47);
							dbg.location(65,26);
							pushFollow(FOLLOW_instruction_in_atom1037);
							instruction48=instruction();
							state._fsp--;

							stream_instruction.add(instruction48.getTree());
							}
							break;

						default :
							break loop12;
						}
					}
					} finally {dbg.exitSubRule(12);}
					dbg.location(65,40);
					char_literal49=(Token)match(input,35,FOLLOW_35_in_atom1041);  
					stream_35.add(char_literal49);

					// AST REWRITE
					// elements: instruction
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 65:81: -> ( instruction )+
					{
						dbg.location(65,84);
						if ( !(stream_instruction.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_instruction.hasNext() ) {
							dbg.location(65,84);
							adaptor.addChild(root_0, stream_instruction.nextTree());
						}
						stream_instruction.reset();

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/moshi/compilation/src/Tiger.g:67:5: STRING
					{
					dbg.location(67,5);
					STRING50=(Token)match(input,STRING,FOLLOW_STRING_in_atom1090);  
					stream_STRING.add(STRING50);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 67:81: -> ^( STR STRING )
					{
						dbg.location(67,84);
						// /Users/moshi/compilation/src/Tiger.g:67:84: ^( STR STRING )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(67,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STR, "STR"), root_1);
						dbg.location(67,90);
						adaptor.addChild(root_1, stream_STRING.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/moshi/compilation/src/Tiger.g:68:5: INTEGER
					{
					dbg.location(68,5);
					INTEGER51=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_atom1173);  
					stream_INTEGER.add(INTEGER51);

					// AST REWRITE
					// elements: INTEGER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 68:81: -> ^( INT INTEGER )
					{
						dbg.location(68,84);
						// /Users/moshi/compilation/src/Tiger.g:68:84: ^( INT INTEGER )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(68,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INT, "INT"), root_1);
						dbg.location(68,90);
						adaptor.addChild(root_1, stream_INTEGER.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/moshi/compilation/src/Tiger.g:69:5: '-' INTEGER
					{
					dbg.location(69,5);
					char_literal52=(Token)match(input,39,FOLLOW_39_in_atom1255);  
					stream_39.add(char_literal52);
					dbg.location(69,9);
					INTEGER53=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_atom1257);  
					stream_INTEGER.add(INTEGER53);

					// AST REWRITE
					// elements: INTEGER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 69:81: -> ^( NEG INTEGER )
					{
						dbg.location(69,84);
						// /Users/moshi/compilation/src/Tiger.g:69:84: ^( NEG INTEGER )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(69,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_1);
						dbg.location(69,90);
						adaptor.addChild(root_1, stream_INTEGER.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/moshi/compilation/src/Tiger.g:70:5: 'nil'
					{
					dbg.location(70,5);
					string_literal54=(Token)match(input,59,FOLLOW_59_in_atom1335);  
					stream_59.add(string_literal54);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 70:81: -> ^( NIL )
					{
						dbg.location(70,84);
						// /Users/moshi/compilation/src/Tiger.g:70:84: ^( NIL )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(70,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NIL, "NIL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(71, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atom");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "atom"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// /Users/moshi/compilation/src/Tiger.g:75:1: expr : assignExpr ;
	public final TigerParser.expr_return expr() throws RecognitionException {
		TigerParser.expr_return retval = new TigerParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope assignExpr55 =null;


		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(75, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:75:6: ( assignExpr )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:75:8: assignExpr
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(75,8);
			pushFollow(FOLLOW_assignExpr_in_expr1424);
			assignExpr55=assignExpr();
			state._fsp--;

			adaptor.addChild(root_0, assignExpr55.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(75, 18);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr"


	public static class assignExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignExpr"
	// /Users/moshi/compilation/src/Tiger.g:77:1: assignExpr : logExpr ( assign ^ logExpr )* ;
	public final TigerParser.assignExpr_return assignExpr() throws RecognitionException {
		TigerParser.assignExpr_return retval = new TigerParser.assignExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope logExpr56 =null;
		ParserRuleReturnScope assign57 =null;
		ParserRuleReturnScope logExpr58 =null;


		try { dbg.enterRule(getGrammarFileName(), "assignExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(77, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:77:13: ( logExpr ( assign ^ logExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:77:15: logExpr ( assign ^ logExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(77,15);
			pushFollow(FOLLOW_logExpr_in_assignExpr1434);
			logExpr56=logExpr();
			state._fsp--;

			adaptor.addChild(root_0, logExpr56.getTree());
			dbg.location(77,27);
			// /Users/moshi/compilation/src/Tiger.g:77:27: ( assign ^ logExpr )*
			try { dbg.enterSubRule(14);

			loop14:
			while (true) {
				int alt14=2;
				try { dbg.enterDecision(14, decisionCanBacktrack[14]);

				int LA14_0 = input.LA(1);
				if ( (LA14_0==42) ) {
					alt14=1;
				}

				} finally {dbg.exitDecision(14);}

				switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:77:30: assign ^ logExpr
					{
					dbg.location(77,36);
					pushFollow(FOLLOW_assign_in_assignExpr1443);
					assign57=assign();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(assign57.getTree(), root_0);dbg.location(77,42);
					pushFollow(FOLLOW_logExpr_in_assignExpr1450);
					logExpr58=logExpr();
					state._fsp--;

					adaptor.addChild(root_0, logExpr58.getTree());

					}
					break;

				default :
					break loop14;
				}
			}
			} finally {dbg.exitSubRule(14);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(77, 51);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assignExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "assignExpr"


	public static class logExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "logExpr"
	// /Users/moshi/compilation/src/Tiger.g:78:1: logExpr : andExpr ( or ^ andExpr )* ;
	public final TigerParser.logExpr_return logExpr() throws RecognitionException {
		TigerParser.logExpr_return retval = new TigerParser.logExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope andExpr59 =null;
		ParserRuleReturnScope or60 =null;
		ParserRuleReturnScope andExpr61 =null;


		try { dbg.enterRule(getGrammarFileName(), "logExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(78, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:78:13: ( andExpr ( or ^ andExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:78:15: andExpr ( or ^ andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(78,15);
			pushFollow(FOLLOW_andExpr_in_logExpr1464);
			andExpr59=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, andExpr59.getTree());
			dbg.location(78,27);
			// /Users/moshi/compilation/src/Tiger.g:78:27: ( or ^ andExpr )*
			try { dbg.enterSubRule(15);

			loop15:
			while (true) {
				int alt15=2;
				try { dbg.enterDecision(15, decisionCanBacktrack[15]);

				int LA15_0 = input.LA(1);
				if ( (LA15_0==64) ) {
					alt15=1;
				}

				} finally {dbg.exitDecision(15);}

				switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:78:34: or ^ andExpr
					{
					dbg.location(78,36);
					pushFollow(FOLLOW_or_in_logExpr1477);
					or60=or();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(or60.getTree(), root_0);dbg.location(78,42);
					pushFollow(FOLLOW_andExpr_in_logExpr1484);
					andExpr61=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, andExpr61.getTree());

					}
					break;

				default :
					break loop15;
				}
			}
			} finally {dbg.exitSubRule(15);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(78, 51);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "logExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "logExpr"


	public static class andExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andExpr"
	// /Users/moshi/compilation/src/Tiger.g:79:1: andExpr : compExpr ( and ^ compExpr )* ;
	public final TigerParser.andExpr_return andExpr() throws RecognitionException {
		TigerParser.andExpr_return retval = new TigerParser.andExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope compExpr62 =null;
		ParserRuleReturnScope and63 =null;
		ParserRuleReturnScope compExpr64 =null;


		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:79:13: ( compExpr ( and ^ compExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:79:15: compExpr ( and ^ compExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(79,15);
			pushFollow(FOLLOW_compExpr_in_andExpr1498);
			compExpr62=compExpr();
			state._fsp--;

			adaptor.addChild(root_0, compExpr62.getTree());
			dbg.location(79,27);
			// /Users/moshi/compilation/src/Tiger.g:79:27: ( and ^ compExpr )*
			try { dbg.enterSubRule(16);

			loop16:
			while (true) {
				int alt16=2;
				try { dbg.enterDecision(16, decisionCanBacktrack[16]);

				int LA16_0 = input.LA(1);
				if ( (LA16_0==33) ) {
					alt16=1;
				}

				} finally {dbg.exitDecision(16);}

				switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:79:33: and ^ compExpr
					{
					dbg.location(79,36);
					pushFollow(FOLLOW_and_in_andExpr1509);
					and63=and();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and63.getTree(), root_0);dbg.location(79,41);
					pushFollow(FOLLOW_compExpr_in_andExpr1515);
					compExpr64=compExpr();
					state._fsp--;

					adaptor.addChild(root_0, compExpr64.getTree());

					}
					break;

				default :
					break loop16;
				}
			}
			} finally {dbg.exitSubRule(16);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(79, 51);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "andExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "andExpr"


	public static class compExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "compExpr"
	// /Users/moshi/compilation/src/Tiger.g:80:1: compExpr : addMinExpr ( comp ^ addMinExpr )? ;
	public final TigerParser.compExpr_return compExpr() throws RecognitionException {
		TigerParser.compExpr_return retval = new TigerParser.compExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope addMinExpr65 =null;
		ParserRuleReturnScope comp66 =null;
		ParserRuleReturnScope addMinExpr67 =null;


		try { dbg.enterRule(getGrammarFileName(), "compExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(80, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:80:13: ( addMinExpr ( comp ^ addMinExpr )? )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:80:15: addMinExpr ( comp ^ addMinExpr )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(80,15);
			pushFollow(FOLLOW_addMinExpr_in_compExpr1528);
			addMinExpr65=addMinExpr();
			state._fsp--;

			adaptor.addChild(root_0, addMinExpr65.getTree());
			dbg.location(80,27);
			// /Users/moshi/compilation/src/Tiger.g:80:27: ( comp ^ addMinExpr )?
			int alt17=2;
			try { dbg.enterSubRule(17);
			try { dbg.enterDecision(17, decisionCanBacktrack[17]);

			int LA17_0 = input.LA(1);
			if ( ((LA17_0 >= 44 && LA17_0 <= 49)) ) {
				alt17=1;
			}
			} finally {dbg.exitDecision(17);}

			switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:80:32: comp ^ addMinExpr
					{
					dbg.location(80,36);
					pushFollow(FOLLOW_comp_in_compExpr1536);
					comp66=comp();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(comp66.getTree(), root_0);dbg.location(80,39);
					pushFollow(FOLLOW_addMinExpr_in_compExpr1540);
					addMinExpr67=addMinExpr();
					state._fsp--;

					adaptor.addChild(root_0, addMinExpr67.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(17);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(80, 51);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "compExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "compExpr"


	public static class addMinExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addMinExpr"
	// /Users/moshi/compilation/src/Tiger.g:81:1: addMinExpr : multDivExpr ( addMin ^ multDivExpr )* ;
	public final TigerParser.addMinExpr_return addMinExpr() throws RecognitionException {
		TigerParser.addMinExpr_return retval = new TigerParser.addMinExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope multDivExpr68 =null;
		ParserRuleReturnScope addMin69 =null;
		ParserRuleReturnScope multDivExpr70 =null;


		try { dbg.enterRule(getGrammarFileName(), "addMinExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(81, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:81:13: ( multDivExpr ( addMin ^ multDivExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:81:15: multDivExpr ( addMin ^ multDivExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(81,15);
			pushFollow(FOLLOW_multDivExpr_in_addMinExpr1551);
			multDivExpr68=multDivExpr();
			state._fsp--;

			adaptor.addChild(root_0, multDivExpr68.getTree());
			dbg.location(81,27);
			// /Users/moshi/compilation/src/Tiger.g:81:27: ( addMin ^ multDivExpr )*
			try { dbg.enterSubRule(18);

			loop18:
			while (true) {
				int alt18=2;
				try { dbg.enterDecision(18, decisionCanBacktrack[18]);

				int LA18_0 = input.LA(1);
				if ( (LA18_0==37||LA18_0==39) ) {
					alt18=1;
				}

				} finally {dbg.exitDecision(18);}

				switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:81:30: addMin ^ multDivExpr
					{
					dbg.location(81,36);
					pushFollow(FOLLOW_addMin_in_addMinExpr1556);
					addMin69=addMin();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(addMin69.getTree(), root_0);dbg.location(81,38);
					pushFollow(FOLLOW_multDivExpr_in_addMinExpr1559);
					multDivExpr70=multDivExpr();
					state._fsp--;

					adaptor.addChild(root_0, multDivExpr70.getTree());

					}
					break;

				default :
					break loop18;
				}
			}
			} finally {dbg.exitSubRule(18);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(81, 51);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "addMinExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "addMinExpr"


	public static class multDivExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multDivExpr"
	// /Users/moshi/compilation/src/Tiger.g:82:1: multDivExpr : atom ( multDiv ^ atom )* ;
	public final TigerParser.multDivExpr_return multDivExpr() throws RecognitionException {
		TigerParser.multDivExpr_return retval = new TigerParser.multDivExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope atom71 =null;
		ParserRuleReturnScope multDiv72 =null;
		ParserRuleReturnScope atom73 =null;


		try { dbg.enterRule(getGrammarFileName(), "multDivExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(82, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:82:13: ( atom ( multDiv ^ atom )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:82:15: atom ( multDiv ^ atom )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(82,15);
			pushFollow(FOLLOW_atom_in_multDivExpr1569);
			atom71=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom71.getTree());
			dbg.location(82,27);
			// /Users/moshi/compilation/src/Tiger.g:82:27: ( multDiv ^ atom )*
			try { dbg.enterSubRule(19);

			loop19:
			while (true) {
				int alt19=2;
				try { dbg.enterDecision(19, decisionCanBacktrack[19]);

				int LA19_0 = input.LA(1);
				if ( (LA19_0==36||LA19_0==40) ) {
					alt19=1;
				}

				} finally {dbg.exitDecision(19);}

				switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:82:29: multDiv ^ atom
					{
					dbg.location(82,36);
					pushFollow(FOLLOW_multDiv_in_multDivExpr1580);
					multDiv72=multDiv();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(multDiv72.getTree(), root_0);dbg.location(82,45);
					pushFollow(FOLLOW_atom_in_multDivExpr1590);
					atom73=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom73.getTree());

					}
					break;

				default :
					break loop19;
				}
			}
			} finally {dbg.exitSubRule(19);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(82, 51);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "multDivExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "multDivExpr"


	public static class addMin_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addMin"
	// /Users/moshi/compilation/src/Tiger.g:85:2: addMin : ( '+' | '-' );
	public final TigerParser.addMin_return addMin() throws RecognitionException {
		TigerParser.addMin_return retval = new TigerParser.addMin_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set74=null;

		Object set74_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "addMin");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(85, 1);

		try {
			// /Users/moshi/compilation/src/Tiger.g:85:9: ( '+' | '-' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(85,9);
			set74=input.LT(1);
			if ( input.LA(1)==37||input.LA(1)==39 ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set74));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(85, 18);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "addMin");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "addMin"


	public static class multDiv_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multDiv"
	// /Users/moshi/compilation/src/Tiger.g:86:1: multDiv : ( '*' | '/' );
	public final TigerParser.multDiv_return multDiv() throws RecognitionException {
		TigerParser.multDiv_return retval = new TigerParser.multDiv_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set75=null;

		Object set75_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "multDiv");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:86:9: ( '*' | '/' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(86,9);
			set75=input.LT(1);
			if ( input.LA(1)==36||input.LA(1)==40 ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set75));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(86, 18);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "multDiv");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "multDiv"


	public static class comp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "comp"
	// /Users/moshi/compilation/src/Tiger.g:87:4: comp : ( '<' | '>' | '<=' | '>=' | '=' | '<>' );
	public final TigerParser.comp_return comp() throws RecognitionException {
		TigerParser.comp_return retval = new TigerParser.comp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set76=null;

		Object set76_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "comp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(87, 3);

		try {
			// /Users/moshi/compilation/src/Tiger.g:87:9: ( '<' | '>' | '<=' | '>=' | '=' | '<>' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(87,9);
			set76=input.LT(1);
			if ( (input.LA(1) >= 44 && input.LA(1) <= 49) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set76));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(87, 37);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "comp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "comp"


	public static class and_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "and"
	// /Users/moshi/compilation/src/Tiger.g:88:5: and : '&' ;
	public final TigerParser.and_return and() throws RecognitionException {
		TigerParser.and_return retval = new TigerParser.and_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal77=null;

		Object char_literal77_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "and");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(88, 4);

		try {
			// /Users/moshi/compilation/src/Tiger.g:88:9: ( '&' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:88:11: '&'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(88,11);
			char_literal77=(Token)match(input,33,FOLLOW_33_in_and1648); 
			char_literal77_tree = (Object)adaptor.create(char_literal77);
			adaptor.addChild(root_0, char_literal77_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(88, 14);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "and");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "and"


	public static class or_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "or"
	// /Users/moshi/compilation/src/Tiger.g:89:5: or : '|' ;
	public final TigerParser.or_return or() throws RecognitionException {
		TigerParser.or_return retval = new TigerParser.or_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal78=null;

		Object char_literal78_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "or");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 4);

		try {
			// /Users/moshi/compilation/src/Tiger.g:89:9: ( '|' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:89:11: '|'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(89,11);
			char_literal78=(Token)match(input,64,FOLLOW_64_in_or1661); 
			char_literal78_tree = (Object)adaptor.create(char_literal78);
			adaptor.addChild(root_0, char_literal78_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(89, 14);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "or");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "or"


	public static class assign_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// /Users/moshi/compilation/src/Tiger.g:90:1: assign : ':=' ;
	public final TigerParser.assign_return assign() throws RecognitionException {
		TigerParser.assign_return retval = new TigerParser.assign_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal79=null;

		Object string_literal79_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "assign");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(90, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:90:9: ( ':=' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:90:11: ':='
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(90,11);
			string_literal79=(Token)match(input,42,FOLLOW_42_in_assign1670); 
			string_literal79_tree = (Object)adaptor.create(string_literal79);
			adaptor.addChild(root_0, string_literal79_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(90, 15);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assign");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "assign"

	// Delegated rules



	public static final BitSet FOLLOW_instructions_in_program249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_instruction_in_instructions260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_declaration347 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_declaration351 = new BitSet(new long[]{0x0000060000000000L});
	public static final BitSet FOLLOW_41_in_declaration354 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_declaration358 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_declaration362 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_expr_in_declaration364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_declaration422 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_declaration426 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_params_in_declaration428 = new BitSet(new long[]{0x0000820000000000L});
	public static final BitSet FOLLOW_41_in_declaration431 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_declaration435 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_declaration439 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instructions_in_declaration441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_params486 = new BitSet(new long[]{0x0000000800004000L});
	public static final BitSet FOLLOW_param_in_params490 = new BitSet(new long[]{0x0000004800000000L});
	public static final BitSet FOLLOW_38_in_params493 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_param_in_params495 = new BitSet(new long[]{0x0000004800000000L});
	public static final BitSet FOLLOW_35_in_params501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_param569 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_param571 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_param575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_instruction658 = new BitSet(new long[]{0x4080000000000000L});
	public static final BitSet FOLLOW_declaration_in_instruction660 = new BitSet(new long[]{0x4280000000000000L});
	public static final BitSet FOLLOW_57_in_instruction663 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instructions_in_instruction665 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_instruction667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_instruction722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_instruction729 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_expr_in_instruction731 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_instruction733 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instructions_in_instruction737 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_52_in_instruction753 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instructions_in_instruction757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_instruction805 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_expr_in_instruction807 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_instruction809 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instructions_in_instruction811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_instruction872 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ID_in_instruction874 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_instruction876 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_expr_in_instruction880 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_instruction882 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_expr_in_instruction886 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_instruction888 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instructions_in_instruction890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_instruction935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom948 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_atom951 = new BitSet(new long[]{0x0800008C10044000L});
	public static final BitSet FOLLOW_expr_in_atom954 = new BitSet(new long[]{0x0000004800000000L});
	public static final BitSet FOLLOW_38_in_atom957 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_expr_in_atom959 = new BitSet(new long[]{0x0000004800000000L});
	public static final BitSet FOLLOW_35_in_atom965 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_atom1030 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instruction_in_atom1032 = new BitSet(new long[]{0x0000080800000000L});
	public static final BitSet FOLLOW_43_in_atom1035 = new BitSet(new long[]{0x8D44008410044000L});
	public static final BitSet FOLLOW_instruction_in_atom1037 = new BitSet(new long[]{0x0000080800000000L});
	public static final BitSet FOLLOW_35_in_atom1041 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_atom1090 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_atom1173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_atom1255 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_INTEGER_in_atom1257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_atom1335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignExpr_in_expr1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logExpr_in_assignExpr1434 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_assign_in_assignExpr1443 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_logExpr_in_assignExpr1450 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_andExpr_in_logExpr1464 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_or_in_logExpr1477 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_andExpr_in_logExpr1484 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_compExpr_in_andExpr1498 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_and_in_andExpr1509 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_compExpr_in_andExpr1515 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_addMinExpr_in_compExpr1528 = new BitSet(new long[]{0x0003F00000000002L});
	public static final BitSet FOLLOW_comp_in_compExpr1536 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_addMinExpr_in_compExpr1540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multDivExpr_in_addMinExpr1551 = new BitSet(new long[]{0x000000A000000002L});
	public static final BitSet FOLLOW_addMin_in_addMinExpr1556 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_multDivExpr_in_addMinExpr1559 = new BitSet(new long[]{0x000000A000000002L});
	public static final BitSet FOLLOW_atom_in_multDivExpr1569 = new BitSet(new long[]{0x0000011000000002L});
	public static final BitSet FOLLOW_multDiv_in_multDivExpr1580 = new BitSet(new long[]{0x0800008410044000L});
	public static final BitSet FOLLOW_atom_in_multDivExpr1590 = new BitSet(new long[]{0x0000011000000002L});
	public static final BitSet FOLLOW_33_in_and1648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_or1661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_assign1670 = new BitSet(new long[]{0x0000000000000002L});
}
