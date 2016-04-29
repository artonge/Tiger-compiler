// $ANTLR 3.5.1 /Users/moshi/compilation/src/Tiger.g 2016-04-29 12:25:19

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TigerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public TigerLexer() {} 
	public TigerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public TigerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/moshi/compilation/src/Tiger.g"; }

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:2:7: ( '&' )
			// /Users/moshi/compilation/src/Tiger.g:2:9: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:3:7: ( '(' )
			// /Users/moshi/compilation/src/Tiger.g:3:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:4:7: ( ')' )
			// /Users/moshi/compilation/src/Tiger.g:4:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:5:7: ( '*' )
			// /Users/moshi/compilation/src/Tiger.g:5:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:6:7: ( '+' )
			// /Users/moshi/compilation/src/Tiger.g:6:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:7:7: ( ',' )
			// /Users/moshi/compilation/src/Tiger.g:7:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:8:7: ( '-' )
			// /Users/moshi/compilation/src/Tiger.g:8:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:9:7: ( '/' )
			// /Users/moshi/compilation/src/Tiger.g:9:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:10:7: ( ':' )
			// /Users/moshi/compilation/src/Tiger.g:10:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:11:7: ( ':=' )
			// /Users/moshi/compilation/src/Tiger.g:11:9: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:12:7: ( ';' )
			// /Users/moshi/compilation/src/Tiger.g:12:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:13:7: ( '<' )
			// /Users/moshi/compilation/src/Tiger.g:13:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:14:7: ( '<=' )
			// /Users/moshi/compilation/src/Tiger.g:14:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:15:7: ( '<>' )
			// /Users/moshi/compilation/src/Tiger.g:15:9: '<>'
			{
			match("<>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:16:7: ( '=' )
			// /Users/moshi/compilation/src/Tiger.g:16:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:17:7: ( '>' )
			// /Users/moshi/compilation/src/Tiger.g:17:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:18:7: ( '>=' )
			// /Users/moshi/compilation/src/Tiger.g:18:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:19:7: ( 'break' )
			// /Users/moshi/compilation/src/Tiger.g:19:9: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:20:7: ( 'do' )
			// /Users/moshi/compilation/src/Tiger.g:20:9: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:21:7: ( 'else' )
			// /Users/moshi/compilation/src/Tiger.g:21:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:22:7: ( 'end' )
			// /Users/moshi/compilation/src/Tiger.g:22:9: 'end'
			{
			match("end"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:23:7: ( 'for' )
			// /Users/moshi/compilation/src/Tiger.g:23:9: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:24:7: ( 'function' )
			// /Users/moshi/compilation/src/Tiger.g:24:9: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:25:7: ( 'if' )
			// /Users/moshi/compilation/src/Tiger.g:25:9: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:26:7: ( 'in' )
			// /Users/moshi/compilation/src/Tiger.g:26:9: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:27:7: ( 'let' )
			// /Users/moshi/compilation/src/Tiger.g:27:9: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:28:7: ( 'nil' )
			// /Users/moshi/compilation/src/Tiger.g:28:9: 'nil'
			{
			match("nil"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:29:7: ( 'then' )
			// /Users/moshi/compilation/src/Tiger.g:29:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:30:7: ( 'to' )
			// /Users/moshi/compilation/src/Tiger.g:30:9: 'to'
			{
			match("to"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:31:7: ( 'var' )
			// /Users/moshi/compilation/src/Tiger.g:31:9: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:32:7: ( 'while' )
			// /Users/moshi/compilation/src/Tiger.g:32:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:33:7: ( '|' )
			// /Users/moshi/compilation/src/Tiger.g:33:9: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:16:12: ( ( ' ' | '\\n' | '\\t' | '\\r' | '\\u000C' )+ )
			// /Users/moshi/compilation/src/Tiger.g:16:14: ( ' ' | '\\n' | '\\t' | '\\r' | '\\u000C' )+
			{
			// /Users/moshi/compilation/src/Tiger.g:16:14: ( ' ' | '\\n' | '\\t' | '\\r' | '\\u000C' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/moshi/compilation/src/Tiger.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:17:12: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// /Users/moshi/compilation/src/Tiger.g:17:14: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// /Users/moshi/compilation/src/Tiger.g:17:19: ( options {greedy=false; } : . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='*') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='/') ) {
						alt2=2;
					}
					else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/moshi/compilation/src/Tiger.g:17:47: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// /Users/moshi/compilation/src/Tiger.g:21:12: ( 'A' .. 'Z' | 'a' .. 'z' )
			// /Users/moshi/compilation/src/Tiger.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:22:12: ( LETTER ( LETTER | INTEGER | '_' )* )
			// /Users/moshi/compilation/src/Tiger.g:22:14: LETTER ( LETTER | INTEGER | '_' )*
			{
			mLETTER(); 

			// /Users/moshi/compilation/src/Tiger.g:22:21: ( LETTER | INTEGER | '_' )*
			loop3:
			while (true) {
				int alt3=4;
				switch ( input.LA(1) ) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					{
					alt3=1;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					{
					alt3=2;
					}
					break;
				case '_':
					{
					alt3=3;
					}
					break;
				}
				switch (alt3) {
				case 1 :
					// /Users/moshi/compilation/src/Tiger.g:22:22: LETTER
					{
					mLETTER(); 

					}
					break;
				case 2 :
					// /Users/moshi/compilation/src/Tiger.g:22:29: INTEGER
					{
					mINTEGER(); 

					}
					break;
				case 3 :
					// /Users/moshi/compilation/src/Tiger.g:22:37: '_'
					{
					match('_'); 
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:24:12: ( '\"' ( LETTER )* '\"' )
			// /Users/moshi/compilation/src/Tiger.g:24:15: '\"' ( LETTER )* '\"'
			{
			match('\"'); 
			// /Users/moshi/compilation/src/Tiger.g:24:19: ( LETTER )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/moshi/compilation/src/Tiger.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/moshi/compilation/src/Tiger.g:25:12: ( ( '0' .. '9' )+ )
			// /Users/moshi/compilation/src/Tiger.g:25:14: ( '0' .. '9' )+
			{
			// /Users/moshi/compilation/src/Tiger.g:25:14: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/moshi/compilation/src/Tiger.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/moshi/compilation/src/Tiger.g:1:8: ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | WHITESPACE | COMMENT | ID | STRING | INTEGER )
		int alt6=37;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// /Users/moshi/compilation/src/Tiger.g:1:10: T__33
				{
				mT__33(); 

				}
				break;
			case 2 :
				// /Users/moshi/compilation/src/Tiger.g:1:16: T__34
				{
				mT__34(); 

				}
				break;
			case 3 :
				// /Users/moshi/compilation/src/Tiger.g:1:22: T__35
				{
				mT__35(); 

				}
				break;
			case 4 :
				// /Users/moshi/compilation/src/Tiger.g:1:28: T__36
				{
				mT__36(); 

				}
				break;
			case 5 :
				// /Users/moshi/compilation/src/Tiger.g:1:34: T__37
				{
				mT__37(); 

				}
				break;
			case 6 :
				// /Users/moshi/compilation/src/Tiger.g:1:40: T__38
				{
				mT__38(); 

				}
				break;
			case 7 :
				// /Users/moshi/compilation/src/Tiger.g:1:46: T__39
				{
				mT__39(); 

				}
				break;
			case 8 :
				// /Users/moshi/compilation/src/Tiger.g:1:52: T__40
				{
				mT__40(); 

				}
				break;
			case 9 :
				// /Users/moshi/compilation/src/Tiger.g:1:58: T__41
				{
				mT__41(); 

				}
				break;
			case 10 :
				// /Users/moshi/compilation/src/Tiger.g:1:64: T__42
				{
				mT__42(); 

				}
				break;
			case 11 :
				// /Users/moshi/compilation/src/Tiger.g:1:70: T__43
				{
				mT__43(); 

				}
				break;
			case 12 :
				// /Users/moshi/compilation/src/Tiger.g:1:76: T__44
				{
				mT__44(); 

				}
				break;
			case 13 :
				// /Users/moshi/compilation/src/Tiger.g:1:82: T__45
				{
				mT__45(); 

				}
				break;
			case 14 :
				// /Users/moshi/compilation/src/Tiger.g:1:88: T__46
				{
				mT__46(); 

				}
				break;
			case 15 :
				// /Users/moshi/compilation/src/Tiger.g:1:94: T__47
				{
				mT__47(); 

				}
				break;
			case 16 :
				// /Users/moshi/compilation/src/Tiger.g:1:100: T__48
				{
				mT__48(); 

				}
				break;
			case 17 :
				// /Users/moshi/compilation/src/Tiger.g:1:106: T__49
				{
				mT__49(); 

				}
				break;
			case 18 :
				// /Users/moshi/compilation/src/Tiger.g:1:112: T__50
				{
				mT__50(); 

				}
				break;
			case 19 :
				// /Users/moshi/compilation/src/Tiger.g:1:118: T__51
				{
				mT__51(); 

				}
				break;
			case 20 :
				// /Users/moshi/compilation/src/Tiger.g:1:124: T__52
				{
				mT__52(); 

				}
				break;
			case 21 :
				// /Users/moshi/compilation/src/Tiger.g:1:130: T__53
				{
				mT__53(); 

				}
				break;
			case 22 :
				// /Users/moshi/compilation/src/Tiger.g:1:136: T__54
				{
				mT__54(); 

				}
				break;
			case 23 :
				// /Users/moshi/compilation/src/Tiger.g:1:142: T__55
				{
				mT__55(); 

				}
				break;
			case 24 :
				// /Users/moshi/compilation/src/Tiger.g:1:148: T__56
				{
				mT__56(); 

				}
				break;
			case 25 :
				// /Users/moshi/compilation/src/Tiger.g:1:154: T__57
				{
				mT__57(); 

				}
				break;
			case 26 :
				// /Users/moshi/compilation/src/Tiger.g:1:160: T__58
				{
				mT__58(); 

				}
				break;
			case 27 :
				// /Users/moshi/compilation/src/Tiger.g:1:166: T__59
				{
				mT__59(); 

				}
				break;
			case 28 :
				// /Users/moshi/compilation/src/Tiger.g:1:172: T__60
				{
				mT__60(); 

				}
				break;
			case 29 :
				// /Users/moshi/compilation/src/Tiger.g:1:178: T__61
				{
				mT__61(); 

				}
				break;
			case 30 :
				// /Users/moshi/compilation/src/Tiger.g:1:184: T__62
				{
				mT__62(); 

				}
				break;
			case 31 :
				// /Users/moshi/compilation/src/Tiger.g:1:190: T__63
				{
				mT__63(); 

				}
				break;
			case 32 :
				// /Users/moshi/compilation/src/Tiger.g:1:196: T__64
				{
				mT__64(); 

				}
				break;
			case 33 :
				// /Users/moshi/compilation/src/Tiger.g:1:202: WHITESPACE
				{
				mWHITESPACE(); 

				}
				break;
			case 34 :
				// /Users/moshi/compilation/src/Tiger.g:1:213: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 35 :
				// /Users/moshi/compilation/src/Tiger.g:1:221: ID
				{
				mID(); 

				}
				break;
			case 36 :
				// /Users/moshi/compilation/src/Tiger.g:1:224: STRING
				{
				mSTRING(); 

				}
				break;
			case 37 :
				// /Users/moshi/compilation/src/Tiger.g:1:231: INTEGER
				{
				mINTEGER(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\10\uffff\1\36\1\40\1\uffff\1\43\1\uffff\1\45\12\32\16\uffff\1\32\1\65"+
		"\4\32\1\72\1\73\3\32\1\77\3\32\1\uffff\1\32\1\104\1\105\1\32\2\uffff\1"+
		"\107\1\110\1\32\1\uffff\1\112\2\32\1\115\2\uffff\1\32\2\uffff\1\117\1"+
		"\uffff\1\32\1\121\1\uffff\1\32\1\uffff\1\123\1\uffff\1\32\1\uffff\1\32"+
		"\1\126\1\uffff";
	static final String DFA6_eofS =
		"\127\uffff";
	static final String DFA6_minS =
		"\1\11\7\uffff\1\52\1\75\1\uffff\1\75\1\uffff\1\75\1\162\1\157\1\154\1"+
		"\157\1\146\1\145\1\151\1\150\1\141\1\150\16\uffff\1\145\1\60\1\163\1\144"+
		"\1\162\1\156\2\60\1\164\1\154\1\145\1\60\1\162\1\151\1\141\1\uffff\1\145"+
		"\2\60\1\143\2\uffff\2\60\1\156\1\uffff\1\60\1\154\1\153\1\60\2\uffff\1"+
		"\164\2\uffff\1\60\1\uffff\1\145\1\60\1\uffff\1\151\1\uffff\1\60\1\uffff"+
		"\1\157\1\uffff\1\156\1\60\1\uffff";
	static final String DFA6_maxS =
		"\1\174\7\uffff\1\52\1\75\1\uffff\1\76\1\uffff\1\75\1\162\1\157\1\156\1"+
		"\165\1\156\1\145\1\151\1\157\1\141\1\150\16\uffff\1\145\1\172\1\163\1"+
		"\144\1\162\1\156\2\172\1\164\1\154\1\145\1\172\1\162\1\151\1\141\1\uffff"+
		"\1\145\2\172\1\143\2\uffff\2\172\1\156\1\uffff\1\172\1\154\1\153\1\172"+
		"\2\uffff\1\164\2\uffff\1\172\1\uffff\1\145\1\172\1\uffff\1\151\1\uffff"+
		"\1\172\1\uffff\1\157\1\uffff\1\156\1\172\1\uffff";
	static final String DFA6_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\13\1\uffff\1\17\13\uffff"+
		"\1\40\1\41\1\43\1\44\1\45\1\42\1\10\1\12\1\11\1\15\1\16\1\14\1\21\1\20"+
		"\17\uffff\1\23\4\uffff\1\30\1\31\3\uffff\1\35\4\uffff\1\25\1\26\1\uffff"+
		"\1\32\1\33\1\uffff\1\36\2\uffff\1\24\1\uffff\1\34\1\uffff\1\22\1\uffff"+
		"\1\37\2\uffff\1\27";
	static final String DFA6_specialS =
		"\127\uffff}>";
	static final String[] DFA6_transitionS = {
			"\2\31\1\uffff\2\31\22\uffff\1\31\1\uffff\1\33\3\uffff\1\1\1\uffff\1\2"+
			"\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\12\34\1\11\1\12\1\13\1\14\1\15\2\uffff"+
			"\32\32\6\uffff\1\32\1\16\1\32\1\17\1\20\1\21\2\32\1\22\2\32\1\23\1\32"+
			"\1\24\5\32\1\25\1\32\1\26\1\27\3\32\1\uffff\1\30",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\35",
			"\1\37",
			"",
			"\1\41\1\42",
			"",
			"\1\44",
			"\1\46",
			"\1\47",
			"\1\50\1\uffff\1\51",
			"\1\52\5\uffff\1\53",
			"\1\54\7\uffff\1\55",
			"\1\56",
			"\1\57",
			"\1\60\6\uffff\1\61",
			"\1\62",
			"\1\63",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\64",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\74",
			"\1\75",
			"\1\76",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\100",
			"\1\101",
			"\1\102",
			"",
			"\1\103",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\106",
			"",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\111",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\113",
			"\1\114",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"",
			"\1\116",
			"",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\120",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\122",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\124",
			"",
			"\1\125",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | WHITESPACE | COMMENT | ID | STRING | INTEGER );";
		}
	}

}
