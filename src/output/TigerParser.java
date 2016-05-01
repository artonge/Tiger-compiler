// $ANTLR 3.5.1 /Users/moshi/compilation/src/Tiger.g 2016-05-01 10:49:39

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
		"BREAK", "COMMENT", "COMP", "DECLARATIONS", "EXPR", "FOR", "FUNC_DECLARATION", 
		"ID", "IF", "INSTRUCTIONS", "INT", "INTEGER", "LET", "LETTER", "MULT", 
		"NEG", "NIL", "OR", "PARAM", "PARAMS", "RETURN", "STR", "STRING", "VAR_DECLARATION", 
		"WHILE", "WHITESPACE", "'&'", "'('", "')'", "'*'", "'+'", "','", "'-'", 
		"'/'", "':'", "':='", "';'", "'<'", "'<='", "'<>'", "'='", "'>'", "'>='", 
		"'break'", "'do'", "'else'", "'end'", "'for'", "'function'", "'if'", "'in'", 
		"'let'", "'nil'", "'return'", "'then'", "'to'", "'var'", "'while'", "'|'"
	};
	public static final int EOF=-1;
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
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int ADD=4;
	public static final int AND=5;
	public static final int ARGS=6;
	public static final int ASSIGNE=7;
	public static final int BREAK=8;
	public static final int COMMENT=9;
	public static final int COMP=10;
	public static final int DECLARATIONS=11;
	public static final int EXPR=12;
	public static final int FOR=13;
	public static final int FUNC_DECLARATION=14;
	public static final int ID=15;
	public static final int IF=16;
	public static final int INSTRUCTIONS=17;
	public static final int INT=18;
	public static final int INTEGER=19;
	public static final int LET=20;
	public static final int LETTER=21;
	public static final int MULT=22;
	public static final int NEG=23;
	public static final int NIL=24;
	public static final int OR=25;
	public static final int PARAM=26;
	public static final int PARAMS=27;
	public static final int RETURN=28;
	public static final int STR=29;
	public static final int STRING=30;
	public static final int VAR_DECLARATION=31;
	public static final int WHILE=32;
	public static final int WHITESPACE=33;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "multDiv", "logExpr", "params", "comp", "declaration", 
		"andExpr", "param", "assignExpr", "and", "expr", "multDivExpr", "addMin", 
		"compExpr", "addMinExpr", "or", "instructions", "atom", "program", "instruction", 
		"assign"
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
			pushFollow(FOLLOW_instructions_in_program252);
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
			pushFollow(FOLLOW_instruction_in_instructions263);
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
	// /Users/moshi/compilation/src/Tiger.g:36:1: declaration : ( 'var' name= ID ( ':' type= ID )? ':=' expr -> ^( VAR_DECLARATION $name ( $type)? expr ) | 'function' name= ID params ( ':' return_type= ID )? '=' instructions -> ^( FUNC_DECLARATION $name params ( $return_type)? instructions ) );
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
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_instructions=new RewriteRuleSubtreeStream(adaptor,"rule instructions");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_params=new RewriteRuleSubtreeStream(adaptor,"rule params");

		try { dbg.enterRule(getGrammarFileName(), "declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(36, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:37:3: ( 'var' name= ID ( ':' type= ID )? ':=' expr -> ^( VAR_DECLARATION $name ( $type)? expr ) | 'function' name= ID params ( ':' return_type= ID )? '=' instructions -> ^( FUNC_DECLARATION $name params ( $return_type)? instructions ) )
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==64) ) {
				alt3=1;
			}
			else if ( (LA3_0==56) ) {
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
					string_literal3=(Token)match(input,64,FOLLOW_64_in_declaration350);  
					stream_64.add(string_literal3);
					dbg.location(37,15);
					name=(Token)match(input,ID,FOLLOW_ID_in_declaration354);  
					stream_ID.add(name);
					dbg.location(37,19);
					// /Users/moshi/compilation/src/Tiger.g:37:19: ( ':' type= ID )?
					int alt1=2;
					try { dbg.enterSubRule(1);
					try { dbg.enterDecision(1, decisionCanBacktrack[1]);

					int LA1_0 = input.LA(1);
					if ( (LA1_0==42) ) {
						alt1=1;
					}
					} finally {dbg.exitDecision(1);}

					switch (alt1) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:37:20: ':' type= ID
							{
							dbg.location(37,20);
							char_literal4=(Token)match(input,42,FOLLOW_42_in_declaration357);  
							stream_42.add(char_literal4);
							dbg.location(37,28);
							type=(Token)match(input,ID,FOLLOW_ID_in_declaration361);  
							stream_ID.add(type);

							}
							break;

					}
					} finally {dbg.exitSubRule(1);}
					dbg.location(37,34);
					string_literal5=(Token)match(input,43,FOLLOW_43_in_declaration365);  
					stream_43.add(string_literal5);
					dbg.location(37,39);
					pushFollow(FOLLOW_expr_in_declaration367);
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
					string_literal7=(Token)match(input,56,FOLLOW_56_in_declaration425);  
					stream_56.add(string_literal7);
					dbg.location(38,20);
					name=(Token)match(input,ID,FOLLOW_ID_in_declaration429);  
					stream_ID.add(name);
					dbg.location(38,24);
					pushFollow(FOLLOW_params_in_declaration431);
					params8=params();
					state._fsp--;

					stream_params.add(params8.getTree());dbg.location(38,31);
					// /Users/moshi/compilation/src/Tiger.g:38:31: ( ':' return_type= ID )?
					int alt2=2;
					try { dbg.enterSubRule(2);
					try { dbg.enterDecision(2, decisionCanBacktrack[2]);

					int LA2_0 = input.LA(1);
					if ( (LA2_0==42) ) {
						alt2=1;
					}
					} finally {dbg.exitDecision(2);}

					switch (alt2) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:38:32: ':' return_type= ID
							{
							dbg.location(38,32);
							char_literal9=(Token)match(input,42,FOLLOW_42_in_declaration434);  
							stream_42.add(char_literal9);
							dbg.location(38,47);
							return_type=(Token)match(input,ID,FOLLOW_ID_in_declaration438);  
							stream_ID.add(return_type);

							}
							break;

					}
					} finally {dbg.exitSubRule(2);}
					dbg.location(38,53);
					char_literal10=(Token)match(input,48,FOLLOW_48_in_declaration442);  
					stream_48.add(char_literal10);
					dbg.location(38,57);
					pushFollow(FOLLOW_instructions_in_declaration444);
					instructions11=instructions();
					state._fsp--;

					stream_instructions.add(instructions11.getTree());
					// AST REWRITE
					// elements: return_type, instructions, name, params
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
					// 38:81: -> ^( FUNC_DECLARATION $name params ( $return_type)? instructions )
					{
						dbg.location(38,84);
						// /Users/moshi/compilation/src/Tiger.g:38:84: ^( FUNC_DECLARATION $name params ( $return_type)? instructions )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(38,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_DECLARATION, "FUNC_DECLARATION"), root_1);
						dbg.location(38,104);
						adaptor.addChild(root_1, stream_name.nextNode());dbg.location(38,109);
						adaptor.addChild(root_1, stream_params.nextTree());dbg.location(38,117);
						// /Users/moshi/compilation/src/Tiger.g:38:117: ( $return_type)?
						if ( stream_return_type.hasNext() ) {
							dbg.location(38,117);
							adaptor.addChild(root_1, stream_return_type.nextNode());
						}
						stream_return_type.reset();
						dbg.location(38,130);
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
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
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
			char_literal12=(Token)match(input,35,FOLLOW_35_in_params485);  
			stream_35.add(char_literal12);
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
					pushFollow(FOLLOW_param_in_params489);
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
						if ( (LA4_0==39) ) {
							alt4=1;
						}

						} finally {dbg.exitDecision(4);}

						switch (alt4) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:42:18: ',' param
							{
							dbg.location(42,18);
							char_literal14=(Token)match(input,39,FOLLOW_39_in_params492);  
							stream_39.add(char_literal14);
							dbg.location(42,22);
							pushFollow(FOLLOW_param_in_params494);
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
			char_literal16=(Token)match(input,36,FOLLOW_36_in_params500);  
			stream_36.add(char_literal16);

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
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");

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
			name=(Token)match(input,ID,FOLLOW_ID_in_param568);  
			stream_ID.add(name);
			dbg.location(45,13);
			char_literal17=(Token)match(input,42,FOLLOW_42_in_param570);  
			stream_42.add(char_literal17);
			dbg.location(45,21);
			type=(Token)match(input,ID,FOLLOW_ID_in_param574);  
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
	// /Users/moshi/compilation/src/Tiger.g:50:1: instruction : ( 'let' ( declaration )+ 'in' instructions 'end' -> ^( LET ^( DECLARATIONS ( declaration )+ ) instructions ) | expr | 'if' expr 'then' i1= instructions ( options {greedy=true; } : 'else' i2= instructions )? -> ^( IF expr $i1 ( $i2)? ) | 'while' expr 'do' instructions -> ^( WHILE expr instructions ) | 'for' ID ':=' v1= expr 'to' v2= expr 'do' instructions -> ^( FOR ID $v1 $v2 instructions ) | 'break' -> BREAK | 'return' expr -> ^( RETURN expr ) );
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
		Token string_literal39=null;
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
		ParserRuleReturnScope expr40 =null;

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
		Object string_literal39_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_instructions=new RewriteRuleSubtreeStream(adaptor,"rule instructions");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");

		try { dbg.enterRule(getGrammarFileName(), "instruction");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(50, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:51:3: ( 'let' ( declaration )+ 'in' instructions 'end' -> ^( LET ^( DECLARATIONS ( declaration )+ ) instructions ) | expr | 'if' expr 'then' i1= instructions ( options {greedy=true; } : 'else' i2= instructions )? -> ^( IF expr $i1 ( $i2)? ) | 'while' expr 'do' instructions -> ^( WHILE expr instructions ) | 'for' ID ':=' v1= expr 'to' v2= expr 'do' instructions -> ^( FOR ID $v1 $v2 instructions ) | 'break' -> BREAK | 'return' expr -> ^( RETURN expr ) )
			int alt8=7;
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			switch ( input.LA(1) ) {
			case 59:
				{
				alt8=1;
				}
				break;
			case ID:
			case INTEGER:
			case STRING:
			case 35:
			case 40:
			case 60:
				{
				alt8=2;
				}
				break;
			case 57:
				{
				alt8=3;
				}
				break;
			case 65:
				{
				alt8=4;
				}
				break;
			case 55:
				{
				alt8=5;
				}
				break;
			case 51:
				{
				alt8=6;
				}
				break;
			case 61:
				{
				alt8=7;
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
					string_literal18=(Token)match(input,59,FOLLOW_59_in_instruction657);  
					stream_59.add(string_literal18);
					dbg.location(51,11);
					// /Users/moshi/compilation/src/Tiger.g:51:11: ( declaration )+
					int cnt6=0;
					try { dbg.enterSubRule(6);

					loop6:
					while (true) {
						int alt6=2;
						try { dbg.enterDecision(6, decisionCanBacktrack[6]);

						int LA6_0 = input.LA(1);
						if ( (LA6_0==56||LA6_0==64) ) {
							alt6=1;
						}

						} finally {dbg.exitDecision(6);}

						switch (alt6) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:51:11: declaration
							{
							dbg.location(51,11);
							pushFollow(FOLLOW_declaration_in_instruction659);
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
					string_literal20=(Token)match(input,58,FOLLOW_58_in_instruction662);  
					stream_58.add(string_literal20);
					dbg.location(51,29);
					pushFollow(FOLLOW_instructions_in_instruction664);
					instructions21=instructions();
					state._fsp--;

					stream_instructions.add(instructions21.getTree());dbg.location(51,42);
					string_literal22=(Token)match(input,54,FOLLOW_54_in_instruction666);  
					stream_54.add(string_literal22);

					// AST REWRITE
					// elements: instructions, declaration
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
					pushFollow(FOLLOW_expr_in_instruction721);
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
					string_literal24=(Token)match(input,57,FOLLOW_57_in_instruction728);  
					stream_57.add(string_literal24);
					dbg.location(55,10);
					pushFollow(FOLLOW_expr_in_instruction730);
					expr25=expr();
					state._fsp--;

					stream_expr.add(expr25.getTree());dbg.location(55,15);
					string_literal26=(Token)match(input,62,FOLLOW_62_in_instruction732);  
					stream_62.add(string_literal26);
					dbg.location(55,24);
					pushFollow(FOLLOW_instructions_in_instruction736);
					i1=instructions();
					state._fsp--;

					stream_instructions.add(i1.getTree());dbg.location(56,5);
					// /Users/moshi/compilation/src/Tiger.g:56:5: ( options {greedy=true; } : 'else' i2= instructions )?
					int alt7=2;
					try { dbg.enterSubRule(7);
					try { dbg.enterDecision(7, decisionCanBacktrack[7]);

					int LA7_0 = input.LA(1);
					if ( (LA7_0==53) ) {
						alt7=1;
					}
					} finally {dbg.exitDecision(7);}

					switch (alt7) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:56:31: 'else' i2= instructions
							{
							dbg.location(56,31);
							string_literal27=(Token)match(input,53,FOLLOW_53_in_instruction752);  
							stream_53.add(string_literal27);
							dbg.location(56,40);
							pushFollow(FOLLOW_instructions_in_instruction756);
							i2=instructions();
							state._fsp--;

							stream_instructions.add(i2.getTree());
							}
							break;

					}
					} finally {dbg.exitSubRule(7);}

					// AST REWRITE
					// elements: i2, expr, i1
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
					string_literal28=(Token)match(input,65,FOLLOW_65_in_instruction804);  
					stream_65.add(string_literal28);
					dbg.location(57,13);
					pushFollow(FOLLOW_expr_in_instruction806);
					expr29=expr();
					state._fsp--;

					stream_expr.add(expr29.getTree());dbg.location(57,18);
					string_literal30=(Token)match(input,52,FOLLOW_52_in_instruction808);  
					stream_52.add(string_literal30);
					dbg.location(57,23);
					pushFollow(FOLLOW_instructions_in_instruction810);
					instructions31=instructions();
					state._fsp--;

					stream_instructions.add(instructions31.getTree());
					// AST REWRITE
					// elements: expr, instructions
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
					string_literal32=(Token)match(input,55,FOLLOW_55_in_instruction871);  
					stream_55.add(string_literal32);
					dbg.location(58,11);
					ID33=(Token)match(input,ID,FOLLOW_ID_in_instruction873);  
					stream_ID.add(ID33);
					dbg.location(58,14);
					string_literal34=(Token)match(input,43,FOLLOW_43_in_instruction875);  
					stream_43.add(string_literal34);
					dbg.location(58,21);
					pushFollow(FOLLOW_expr_in_instruction879);
					v1=expr();
					state._fsp--;

					stream_expr.add(v1.getTree());dbg.location(58,27);
					string_literal35=(Token)match(input,63,FOLLOW_63_in_instruction881);  
					stream_63.add(string_literal35);
					dbg.location(58,34);
					pushFollow(FOLLOW_expr_in_instruction885);
					v2=expr();
					state._fsp--;

					stream_expr.add(v2.getTree());dbg.location(58,40);
					string_literal36=(Token)match(input,52,FOLLOW_52_in_instruction887);  
					stream_52.add(string_literal36);
					dbg.location(58,45);
					pushFollow(FOLLOW_instructions_in_instruction889);
					instructions37=instructions();
					state._fsp--;

					stream_instructions.add(instructions37.getTree());
					// AST REWRITE
					// elements: v2, v1, instructions, ID
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
					dbg.location(59,5);
					string_literal38=(Token)match(input,51,FOLLOW_51_in_instruction934);  
					stream_51.add(string_literal38);

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
					// 59:81: -> BREAK
					{
						dbg.location(59,84);
						adaptor.addChild(root_0, (Object)adaptor.create(BREAK, "BREAK"));
					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /Users/moshi/compilation/src/Tiger.g:60:5: 'return' expr
					{
					dbg.location(60,5);
					string_literal39=(Token)match(input,61,FOLLOW_61_in_instruction1012);  
					stream_61.add(string_literal39);
					dbg.location(60,14);
					pushFollow(FOLLOW_expr_in_instruction1014);
					expr40=expr();
					state._fsp--;

					stream_expr.add(expr40.getTree());
					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 60:81: -> ^( RETURN expr )
					{
						dbg.location(60,84);
						// /Users/moshi/compilation/src/Tiger.g:60:84: ^( RETURN expr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(60,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN, "RETURN"), root_1);
						dbg.location(60,93);
						adaptor.addChild(root_1, stream_expr.nextTree());
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
		dbg.location(61, 2);

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
	// /Users/moshi/compilation/src/Tiger.g:63:1: atom : ( ID ( '(' ( expr ( ',' expr )* )? ')' )? -> ^( ID ( ^( ARGS ( expr )* ) )? ) | '(' instruction ( ';' instruction )* ')' -> ( instruction )+ | STRING -> ^( STR STRING ) | INTEGER -> ^( INT INTEGER ) | '-' INTEGER -> ^( NEG INTEGER ) | 'nil' -> ^( NIL ) );
	public final TigerParser.atom_return atom() throws RecognitionException {
		TigerParser.atom_return retval = new TigerParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID41=null;
		Token char_literal42=null;
		Token char_literal44=null;
		Token char_literal46=null;
		Token char_literal47=null;
		Token char_literal49=null;
		Token char_literal51=null;
		Token STRING52=null;
		Token INTEGER53=null;
		Token char_literal54=null;
		Token INTEGER55=null;
		Token string_literal56=null;
		ParserRuleReturnScope expr43 =null;
		ParserRuleReturnScope expr45 =null;
		ParserRuleReturnScope instruction48 =null;
		ParserRuleReturnScope instruction50 =null;

		Object ID41_tree=null;
		Object char_literal42_tree=null;
		Object char_literal44_tree=null;
		Object char_literal46_tree=null;
		Object char_literal47_tree=null;
		Object char_literal49_tree=null;
		Object char_literal51_tree=null;
		Object STRING52_tree=null;
		Object INTEGER53_tree=null;
		Object char_literal54_tree=null;
		Object INTEGER55_tree=null;
		Object string_literal56_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(63, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:64:3: ( ID ( '(' ( expr ( ',' expr )* )? ')' )? -> ^( ID ( ^( ARGS ( expr )* ) )? ) | '(' instruction ( ';' instruction )* ')' -> ( instruction )+ | STRING -> ^( STR STRING ) | INTEGER -> ^( INT INTEGER ) | '-' INTEGER -> ^( NEG INTEGER ) | 'nil' -> ^( NIL ) )
			int alt13=6;
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			switch ( input.LA(1) ) {
			case ID:
				{
				alt13=1;
				}
				break;
			case 35:
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
			case 40:
				{
				alt13=5;
				}
				break;
			case 60:
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

					// /Users/moshi/compilation/src/Tiger.g:64:5: ID ( '(' ( expr ( ',' expr )* )? ')' )?
					{
					dbg.location(64,5);
					ID41=(Token)match(input,ID,FOLLOW_ID_in_atom1097);  
					stream_ID.add(ID41);
					dbg.location(64,8);
					// /Users/moshi/compilation/src/Tiger.g:64:8: ( '(' ( expr ( ',' expr )* )? ')' )?
					int alt11=2;
					try { dbg.enterSubRule(11);
					try { dbg.enterDecision(11, decisionCanBacktrack[11]);

					int LA11_0 = input.LA(1);
					if ( (LA11_0==35) ) {
						alt11=1;
					}
					} finally {dbg.exitDecision(11);}

					switch (alt11) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:64:9: '(' ( expr ( ',' expr )* )? ')'
							{
							dbg.location(64,9);
							char_literal42=(Token)match(input,35,FOLLOW_35_in_atom1100);  
							stream_35.add(char_literal42);
							dbg.location(64,13);
							// /Users/moshi/compilation/src/Tiger.g:64:13: ( expr ( ',' expr )* )?
							int alt10=2;
							try { dbg.enterSubRule(10);
							try { dbg.enterDecision(10, decisionCanBacktrack[10]);

							int LA10_0 = input.LA(1);
							if ( (LA10_0==ID||LA10_0==INTEGER||LA10_0==STRING||LA10_0==35||LA10_0==40||LA10_0==60) ) {
								alt10=1;
							}
							} finally {dbg.exitDecision(10);}

							switch (alt10) {
								case 1 :
									dbg.enterAlt(1);

									// /Users/moshi/compilation/src/Tiger.g:64:14: expr ( ',' expr )*
									{
									dbg.location(64,14);
									pushFollow(FOLLOW_expr_in_atom1103);
									expr43=expr();
									state._fsp--;

									stream_expr.add(expr43.getTree());dbg.location(64,19);
									// /Users/moshi/compilation/src/Tiger.g:64:19: ( ',' expr )*
									try { dbg.enterSubRule(9);

									loop9:
									while (true) {
										int alt9=2;
										try { dbg.enterDecision(9, decisionCanBacktrack[9]);

										int LA9_0 = input.LA(1);
										if ( (LA9_0==39) ) {
											alt9=1;
										}

										} finally {dbg.exitDecision(9);}

										switch (alt9) {
										case 1 :
											dbg.enterAlt(1);

											// /Users/moshi/compilation/src/Tiger.g:64:20: ',' expr
											{
											dbg.location(64,20);
											char_literal44=(Token)match(input,39,FOLLOW_39_in_atom1106);  
											stream_39.add(char_literal44);
											dbg.location(64,24);
											pushFollow(FOLLOW_expr_in_atom1108);
											expr45=expr();
											state._fsp--;

											stream_expr.add(expr45.getTree());
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
							dbg.location(64,33);
							char_literal46=(Token)match(input,36,FOLLOW_36_in_atom1114);  
							stream_36.add(char_literal46);

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
					// 64:81: -> ^( ID ( ^( ARGS ( expr )* ) )? )
					{
						dbg.location(64,84);
						// /Users/moshi/compilation/src/Tiger.g:64:84: ^( ID ( ^( ARGS ( expr )* ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(64,86);
						root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
						dbg.location(64,89);
						// /Users/moshi/compilation/src/Tiger.g:64:89: ( ^( ARGS ( expr )* ) )?
						if ( stream_expr.hasNext() ) {
							dbg.location(64,89);
							// /Users/moshi/compilation/src/Tiger.g:64:89: ^( ARGS ( expr )* )
							{
							Object root_2 = (Object)adaptor.nil();
							dbg.location(64,91);
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGS, "ARGS"), root_2);
							dbg.location(64,96);
							// /Users/moshi/compilation/src/Tiger.g:64:96: ( expr )*
							while ( stream_expr.hasNext() ) {
								dbg.location(64,96);
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

					// /Users/moshi/compilation/src/Tiger.g:66:5: '(' instruction ( ';' instruction )* ')'
					{
					dbg.location(66,5);
					char_literal47=(Token)match(input,35,FOLLOW_35_in_atom1179);  
					stream_35.add(char_literal47);
					dbg.location(66,9);
					pushFollow(FOLLOW_instruction_in_atom1181);
					instruction48=instruction();
					state._fsp--;

					stream_instruction.add(instruction48.getTree());dbg.location(66,21);
					// /Users/moshi/compilation/src/Tiger.g:66:21: ( ';' instruction )*
					try { dbg.enterSubRule(12);

					loop12:
					while (true) {
						int alt12=2;
						try { dbg.enterDecision(12, decisionCanBacktrack[12]);

						int LA12_0 = input.LA(1);
						if ( (LA12_0==44) ) {
							alt12=1;
						}

						} finally {dbg.exitDecision(12);}

						switch (alt12) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/moshi/compilation/src/Tiger.g:66:22: ';' instruction
							{
							dbg.location(66,22);
							char_literal49=(Token)match(input,44,FOLLOW_44_in_atom1184);  
							stream_44.add(char_literal49);
							dbg.location(66,26);
							pushFollow(FOLLOW_instruction_in_atom1186);
							instruction50=instruction();
							state._fsp--;

							stream_instruction.add(instruction50.getTree());
							}
							break;

						default :
							break loop12;
						}
					}
					} finally {dbg.exitSubRule(12);}
					dbg.location(66,40);
					char_literal51=(Token)match(input,36,FOLLOW_36_in_atom1190);  
					stream_36.add(char_literal51);

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
					// 66:81: -> ( instruction )+
					{
						dbg.location(66,84);
						if ( !(stream_instruction.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_instruction.hasNext() ) {
							dbg.location(66,84);
							adaptor.addChild(root_0, stream_instruction.nextTree());
						}
						stream_instruction.reset();

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/moshi/compilation/src/Tiger.g:68:5: STRING
					{
					dbg.location(68,5);
					STRING52=(Token)match(input,STRING,FOLLOW_STRING_in_atom1239);  
					stream_STRING.add(STRING52);

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
					// 68:81: -> ^( STR STRING )
					{
						dbg.location(68,84);
						// /Users/moshi/compilation/src/Tiger.g:68:84: ^( STR STRING )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(68,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STR, "STR"), root_1);
						dbg.location(68,90);
						adaptor.addChild(root_1, stream_STRING.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/moshi/compilation/src/Tiger.g:69:5: INTEGER
					{
					dbg.location(69,5);
					INTEGER53=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_atom1322);  
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
					// 69:81: -> ^( INT INTEGER )
					{
						dbg.location(69,84);
						// /Users/moshi/compilation/src/Tiger.g:69:84: ^( INT INTEGER )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(69,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INT, "INT"), root_1);
						dbg.location(69,90);
						adaptor.addChild(root_1, stream_INTEGER.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/moshi/compilation/src/Tiger.g:70:5: '-' INTEGER
					{
					dbg.location(70,5);
					char_literal54=(Token)match(input,40,FOLLOW_40_in_atom1404);  
					stream_40.add(char_literal54);
					dbg.location(70,9);
					INTEGER55=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_atom1406);  
					stream_INTEGER.add(INTEGER55);

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
					// 70:81: -> ^( NEG INTEGER )
					{
						dbg.location(70,84);
						// /Users/moshi/compilation/src/Tiger.g:70:84: ^( NEG INTEGER )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(70,86);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_1);
						dbg.location(70,90);
						adaptor.addChild(root_1, stream_INTEGER.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/moshi/compilation/src/Tiger.g:71:5: 'nil'
					{
					dbg.location(71,5);
					string_literal56=(Token)match(input,60,FOLLOW_60_in_atom1484);  
					stream_60.add(string_literal56);

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
					// 71:81: -> ^( NIL )
					{
						dbg.location(71,84);
						// /Users/moshi/compilation/src/Tiger.g:71:84: ^( NIL )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(71,86);
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
		dbg.location(72, 2);

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
	// /Users/moshi/compilation/src/Tiger.g:76:1: expr : assignExpr ;
	public final TigerParser.expr_return expr() throws RecognitionException {
		TigerParser.expr_return retval = new TigerParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope assignExpr57 =null;


		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(76, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:76:6: ( assignExpr )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:76:8: assignExpr
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(76,8);
			pushFollow(FOLLOW_assignExpr_in_expr1573);
			assignExpr57=assignExpr();
			state._fsp--;

			adaptor.addChild(root_0, assignExpr57.getTree());

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
		dbg.location(76, 18);

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
	// /Users/moshi/compilation/src/Tiger.g:78:1: assignExpr : logExpr ( assign ^ logExpr )* ;
	public final TigerParser.assignExpr_return assignExpr() throws RecognitionException {
		TigerParser.assignExpr_return retval = new TigerParser.assignExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope logExpr58 =null;
		ParserRuleReturnScope assign59 =null;
		ParserRuleReturnScope logExpr60 =null;


		try { dbg.enterRule(getGrammarFileName(), "assignExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(78, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:78:13: ( logExpr ( assign ^ logExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:78:15: logExpr ( assign ^ logExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(78,15);
			pushFollow(FOLLOW_logExpr_in_assignExpr1583);
			logExpr58=logExpr();
			state._fsp--;

			adaptor.addChild(root_0, logExpr58.getTree());
			dbg.location(78,27);
			// /Users/moshi/compilation/src/Tiger.g:78:27: ( assign ^ logExpr )*
			try { dbg.enterSubRule(14);

			loop14:
			while (true) {
				int alt14=2;
				try { dbg.enterDecision(14, decisionCanBacktrack[14]);

				int LA14_0 = input.LA(1);
				if ( (LA14_0==43) ) {
					alt14=1;
				}

				} finally {dbg.exitDecision(14);}

				switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:78:30: assign ^ logExpr
					{
					dbg.location(78,36);
					pushFollow(FOLLOW_assign_in_assignExpr1592);
					assign59=assign();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(assign59.getTree(), root_0);dbg.location(78,42);
					pushFollow(FOLLOW_logExpr_in_assignExpr1599);
					logExpr60=logExpr();
					state._fsp--;

					adaptor.addChild(root_0, logExpr60.getTree());

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
		dbg.location(78, 51);

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
	// /Users/moshi/compilation/src/Tiger.g:79:1: logExpr : andExpr ( or ^ andExpr )* ;
	public final TigerParser.logExpr_return logExpr() throws RecognitionException {
		TigerParser.logExpr_return retval = new TigerParser.logExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope andExpr61 =null;
		ParserRuleReturnScope or62 =null;
		ParserRuleReturnScope andExpr63 =null;


		try { dbg.enterRule(getGrammarFileName(), "logExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:79:13: ( andExpr ( or ^ andExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:79:15: andExpr ( or ^ andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(79,15);
			pushFollow(FOLLOW_andExpr_in_logExpr1613);
			andExpr61=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, andExpr61.getTree());
			dbg.location(79,27);
			// /Users/moshi/compilation/src/Tiger.g:79:27: ( or ^ andExpr )*
			try { dbg.enterSubRule(15);

			loop15:
			while (true) {
				int alt15=2;
				try { dbg.enterDecision(15, decisionCanBacktrack[15]);

				int LA15_0 = input.LA(1);
				if ( (LA15_0==66) ) {
					alt15=1;
				}

				} finally {dbg.exitDecision(15);}

				switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:79:34: or ^ andExpr
					{
					dbg.location(79,36);
					pushFollow(FOLLOW_or_in_logExpr1626);
					or62=or();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(or62.getTree(), root_0);dbg.location(79,42);
					pushFollow(FOLLOW_andExpr_in_logExpr1633);
					andExpr63=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, andExpr63.getTree());

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
		dbg.location(79, 51);

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
	// /Users/moshi/compilation/src/Tiger.g:80:1: andExpr : compExpr ( and ^ compExpr )* ;
	public final TigerParser.andExpr_return andExpr() throws RecognitionException {
		TigerParser.andExpr_return retval = new TigerParser.andExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope compExpr64 =null;
		ParserRuleReturnScope and65 =null;
		ParserRuleReturnScope compExpr66 =null;


		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(80, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:80:13: ( compExpr ( and ^ compExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:80:15: compExpr ( and ^ compExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(80,15);
			pushFollow(FOLLOW_compExpr_in_andExpr1647);
			compExpr64=compExpr();
			state._fsp--;

			adaptor.addChild(root_0, compExpr64.getTree());
			dbg.location(80,27);
			// /Users/moshi/compilation/src/Tiger.g:80:27: ( and ^ compExpr )*
			try { dbg.enterSubRule(16);

			loop16:
			while (true) {
				int alt16=2;
				try { dbg.enterDecision(16, decisionCanBacktrack[16]);

				int LA16_0 = input.LA(1);
				if ( (LA16_0==34) ) {
					alt16=1;
				}

				} finally {dbg.exitDecision(16);}

				switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:80:33: and ^ compExpr
					{
					dbg.location(80,36);
					pushFollow(FOLLOW_and_in_andExpr1658);
					and65=and();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(and65.getTree(), root_0);dbg.location(80,41);
					pushFollow(FOLLOW_compExpr_in_andExpr1664);
					compExpr66=compExpr();
					state._fsp--;

					adaptor.addChild(root_0, compExpr66.getTree());

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
		dbg.location(80, 51);

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
	// /Users/moshi/compilation/src/Tiger.g:81:1: compExpr : addMinExpr ( comp ^ addMinExpr )? ;
	public final TigerParser.compExpr_return compExpr() throws RecognitionException {
		TigerParser.compExpr_return retval = new TigerParser.compExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope addMinExpr67 =null;
		ParserRuleReturnScope comp68 =null;
		ParserRuleReturnScope addMinExpr69 =null;


		try { dbg.enterRule(getGrammarFileName(), "compExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(81, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:81:13: ( addMinExpr ( comp ^ addMinExpr )? )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:81:15: addMinExpr ( comp ^ addMinExpr )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(81,15);
			pushFollow(FOLLOW_addMinExpr_in_compExpr1677);
			addMinExpr67=addMinExpr();
			state._fsp--;

			adaptor.addChild(root_0, addMinExpr67.getTree());
			dbg.location(81,27);
			// /Users/moshi/compilation/src/Tiger.g:81:27: ( comp ^ addMinExpr )?
			int alt17=2;
			try { dbg.enterSubRule(17);
			try { dbg.enterDecision(17, decisionCanBacktrack[17]);

			int LA17_0 = input.LA(1);
			if ( ((LA17_0 >= 45 && LA17_0 <= 50)) ) {
				alt17=1;
			}
			} finally {dbg.exitDecision(17);}

			switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:81:32: comp ^ addMinExpr
					{
					dbg.location(81,36);
					pushFollow(FOLLOW_comp_in_compExpr1685);
					comp68=comp();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(comp68.getTree(), root_0);dbg.location(81,39);
					pushFollow(FOLLOW_addMinExpr_in_compExpr1689);
					addMinExpr69=addMinExpr();
					state._fsp--;

					adaptor.addChild(root_0, addMinExpr69.getTree());

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
		dbg.location(81, 51);

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
	// /Users/moshi/compilation/src/Tiger.g:82:1: addMinExpr : multDivExpr ( addMin ^ multDivExpr )* ;
	public final TigerParser.addMinExpr_return addMinExpr() throws RecognitionException {
		TigerParser.addMinExpr_return retval = new TigerParser.addMinExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope multDivExpr70 =null;
		ParserRuleReturnScope addMin71 =null;
		ParserRuleReturnScope multDivExpr72 =null;


		try { dbg.enterRule(getGrammarFileName(), "addMinExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(82, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:82:13: ( multDivExpr ( addMin ^ multDivExpr )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:82:15: multDivExpr ( addMin ^ multDivExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(82,15);
			pushFollow(FOLLOW_multDivExpr_in_addMinExpr1700);
			multDivExpr70=multDivExpr();
			state._fsp--;

			adaptor.addChild(root_0, multDivExpr70.getTree());
			dbg.location(82,27);
			// /Users/moshi/compilation/src/Tiger.g:82:27: ( addMin ^ multDivExpr )*
			try { dbg.enterSubRule(18);

			loop18:
			while (true) {
				int alt18=2;
				try { dbg.enterDecision(18, decisionCanBacktrack[18]);

				int LA18_0 = input.LA(1);
				if ( (LA18_0==38||LA18_0==40) ) {
					alt18=1;
				}

				} finally {dbg.exitDecision(18);}

				switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:82:30: addMin ^ multDivExpr
					{
					dbg.location(82,36);
					pushFollow(FOLLOW_addMin_in_addMinExpr1705);
					addMin71=addMin();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(addMin71.getTree(), root_0);dbg.location(82,38);
					pushFollow(FOLLOW_multDivExpr_in_addMinExpr1708);
					multDivExpr72=multDivExpr();
					state._fsp--;

					adaptor.addChild(root_0, multDivExpr72.getTree());

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
		dbg.location(82, 51);

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
	// /Users/moshi/compilation/src/Tiger.g:83:1: multDivExpr : atom ( multDiv ^ atom )* ;
	public final TigerParser.multDivExpr_return multDivExpr() throws RecognitionException {
		TigerParser.multDivExpr_return retval = new TigerParser.multDivExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope atom73 =null;
		ParserRuleReturnScope multDiv74 =null;
		ParserRuleReturnScope atom75 =null;


		try { dbg.enterRule(getGrammarFileName(), "multDivExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(83, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:83:13: ( atom ( multDiv ^ atom )* )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:83:15: atom ( multDiv ^ atom )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(83,15);
			pushFollow(FOLLOW_atom_in_multDivExpr1718);
			atom73=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom73.getTree());
			dbg.location(83,27);
			// /Users/moshi/compilation/src/Tiger.g:83:27: ( multDiv ^ atom )*
			try { dbg.enterSubRule(19);

			loop19:
			while (true) {
				int alt19=2;
				try { dbg.enterDecision(19, decisionCanBacktrack[19]);

				int LA19_0 = input.LA(1);
				if ( (LA19_0==37||LA19_0==41) ) {
					alt19=1;
				}

				} finally {dbg.exitDecision(19);}

				switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/moshi/compilation/src/Tiger.g:83:29: multDiv ^ atom
					{
					dbg.location(83,36);
					pushFollow(FOLLOW_multDiv_in_multDivExpr1729);
					multDiv74=multDiv();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(multDiv74.getTree(), root_0);dbg.location(83,45);
					pushFollow(FOLLOW_atom_in_multDivExpr1739);
					atom75=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom75.getTree());

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
		dbg.location(83, 51);

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
	// /Users/moshi/compilation/src/Tiger.g:86:2: addMin : ( '+' | '-' );
	public final TigerParser.addMin_return addMin() throws RecognitionException {
		TigerParser.addMin_return retval = new TigerParser.addMin_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set76=null;

		Object set76_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "addMin");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 1);

		try {
			// /Users/moshi/compilation/src/Tiger.g:86:9: ( '+' | '-' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(86,9);
			set76=input.LT(1);
			if ( input.LA(1)==38||input.LA(1)==40 ) {
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
		dbg.location(86, 18);

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
	// /Users/moshi/compilation/src/Tiger.g:87:1: multDiv : ( '*' | '/' );
	public final TigerParser.multDiv_return multDiv() throws RecognitionException {
		TigerParser.multDiv_return retval = new TigerParser.multDiv_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set77=null;

		Object set77_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "multDiv");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(87, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:87:9: ( '*' | '/' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(87,9);
			set77=input.LT(1);
			if ( input.LA(1)==37||input.LA(1)==41 ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set77));
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
		dbg.location(87, 18);

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
	// /Users/moshi/compilation/src/Tiger.g:88:4: comp : ( '<' | '>' | '<=' | '>=' | '=' | '<>' );
	public final TigerParser.comp_return comp() throws RecognitionException {
		TigerParser.comp_return retval = new TigerParser.comp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set78=null;

		Object set78_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "comp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(88, 3);

		try {
			// /Users/moshi/compilation/src/Tiger.g:88:9: ( '<' | '>' | '<=' | '>=' | '=' | '<>' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(88,9);
			set78=input.LT(1);
			if ( (input.LA(1) >= 45 && input.LA(1) <= 50) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set78));
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
		dbg.location(88, 37);

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
	// /Users/moshi/compilation/src/Tiger.g:89:5: and : '&' ;
	public final TigerParser.and_return and() throws RecognitionException {
		TigerParser.and_return retval = new TigerParser.and_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal79=null;

		Object char_literal79_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "and");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 4);

		try {
			// /Users/moshi/compilation/src/Tiger.g:89:9: ( '&' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:89:11: '&'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(89,11);
			char_literal79=(Token)match(input,34,FOLLOW_34_in_and1797); 
			char_literal79_tree = (Object)adaptor.create(char_literal79);
			adaptor.addChild(root_0, char_literal79_tree);

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
	// /Users/moshi/compilation/src/Tiger.g:90:5: or : '|' ;
	public final TigerParser.or_return or() throws RecognitionException {
		TigerParser.or_return retval = new TigerParser.or_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal80=null;

		Object char_literal80_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "or");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(90, 4);

		try {
			// /Users/moshi/compilation/src/Tiger.g:90:9: ( '|' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:90:11: '|'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(90,11);
			char_literal80=(Token)match(input,66,FOLLOW_66_in_or1810); 
			char_literal80_tree = (Object)adaptor.create(char_literal80);
			adaptor.addChild(root_0, char_literal80_tree);

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
		dbg.location(90, 14);

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
	// /Users/moshi/compilation/src/Tiger.g:91:1: assign : ':=' ;
	public final TigerParser.assign_return assign() throws RecognitionException {
		TigerParser.assign_return retval = new TigerParser.assign_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal81=null;

		Object string_literal81_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "assign");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(91, 0);

		try {
			// /Users/moshi/compilation/src/Tiger.g:91:9: ( ':=' )
			dbg.enterAlt(1);

			// /Users/moshi/compilation/src/Tiger.g:91:11: ':='
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(91,11);
			string_literal81=(Token)match(input,43,FOLLOW_43_in_assign1819); 
			string_literal81_tree = (Object)adaptor.create(string_literal81);
			adaptor.addChild(root_0, string_literal81_tree);

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
		dbg.location(91, 15);

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



	public static final BitSet FOLLOW_instructions_in_program252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_instruction_in_instructions263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_declaration350 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_declaration354 = new BitSet(new long[]{0x00000C0000000000L});
	public static final BitSet FOLLOW_42_in_declaration357 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_declaration361 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_declaration365 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_expr_in_declaration367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_declaration425 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_declaration429 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_params_in_declaration431 = new BitSet(new long[]{0x0001040000000000L});
	public static final BitSet FOLLOW_42_in_declaration434 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_declaration438 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_declaration442 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instructions_in_declaration444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_params485 = new BitSet(new long[]{0x0000001000008000L});
	public static final BitSet FOLLOW_param_in_params489 = new BitSet(new long[]{0x0000009000000000L});
	public static final BitSet FOLLOW_39_in_params492 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_param_in_params494 = new BitSet(new long[]{0x0000009000000000L});
	public static final BitSet FOLLOW_36_in_params500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_param568 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_param570 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_param574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_instruction657 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_declaration_in_instruction659 = new BitSet(new long[]{0x0500000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_58_in_instruction662 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instructions_in_instruction664 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_instruction666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_instruction721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_instruction728 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_expr_in_instruction730 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_instruction732 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instructions_in_instruction736 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_53_in_instruction752 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instructions_in_instruction756 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_instruction804 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_expr_in_instruction806 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_instruction808 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instructions_in_instruction810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_instruction871 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_instruction873 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_instruction875 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_expr_in_instruction879 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_instruction881 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_expr_in_instruction885 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_instruction887 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instructions_in_instruction889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_instruction934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_instruction1012 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_expr_in_instruction1014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom1097 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_atom1100 = new BitSet(new long[]{0x1000011840088000L});
	public static final BitSet FOLLOW_expr_in_atom1103 = new BitSet(new long[]{0x0000009000000000L});
	public static final BitSet FOLLOW_39_in_atom1106 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_expr_in_atom1108 = new BitSet(new long[]{0x0000009000000000L});
	public static final BitSet FOLLOW_36_in_atom1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_atom1179 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instruction_in_atom1181 = new BitSet(new long[]{0x0000101000000000L});
	public static final BitSet FOLLOW_44_in_atom1184 = new BitSet(new long[]{0x3A88010840088000L,0x0000000000000002L});
	public static final BitSet FOLLOW_instruction_in_atom1186 = new BitSet(new long[]{0x0000101000000000L});
	public static final BitSet FOLLOW_36_in_atom1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_atom1239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_atom1322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_atom1404 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_INTEGER_in_atom1406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_60_in_atom1484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignExpr_in_expr1573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logExpr_in_assignExpr1583 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_assign_in_assignExpr1592 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_logExpr_in_assignExpr1599 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_andExpr_in_logExpr1613 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_or_in_logExpr1626 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_andExpr_in_logExpr1633 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_compExpr_in_andExpr1647 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_and_in_andExpr1658 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_compExpr_in_andExpr1664 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_addMinExpr_in_compExpr1677 = new BitSet(new long[]{0x0007E00000000002L});
	public static final BitSet FOLLOW_comp_in_compExpr1685 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_addMinExpr_in_compExpr1689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multDivExpr_in_addMinExpr1700 = new BitSet(new long[]{0x0000014000000002L});
	public static final BitSet FOLLOW_addMin_in_addMinExpr1705 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_multDivExpr_in_addMinExpr1708 = new BitSet(new long[]{0x0000014000000002L});
	public static final BitSet FOLLOW_atom_in_multDivExpr1718 = new BitSet(new long[]{0x0000022000000002L});
	public static final BitSet FOLLOW_multDiv_in_multDivExpr1729 = new BitSet(new long[]{0x1000010840088000L});
	public static final BitSet FOLLOW_atom_in_multDivExpr1739 = new BitSet(new long[]{0x0000022000000002L});
	public static final BitSet FOLLOW_34_in_and1797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_or1810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_assign1819 = new BitSet(new long[]{0x0000000000000002L});
}
