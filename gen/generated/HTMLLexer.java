// Generated from C:/Users/hp/Desktop/final compiler generate/in/in2/src/generated/gen\HTMLLexer.g4 by ANTLR 4.9.1
package gen.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HTMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PAGE_DEFINITION=1, CONTROLLER_DEFINITION=2, SEA_WS=3, COMMENT=4, EXTENDS=5, 
		COMMA=6, SEMICOLON=7, PAGE_OPEN=8, PAGE_CLOSE=9, PARENTHESE_OPEN=10, PARENTHESE_CLOSE=11, 
		IN=12, OUT=13, COLON=14, HEADER_OPEN=15, HEADER_CLOSE=16, HEADER=17, HEADER_TYPE=18, 
		STRING_VALUE=19, INPUT_TYPES=20, OUTPUT_TYPES=21, LINK=22, ATTRIBUTE=23, 
		PAGE_ID=24, NUMERIC_VALUE1=25, PAGE_WHITESPACE=26, CONTROLLER_OPEN=27, 
		CONTROLS=28, CONTROLLER_WHITESPACE=29, CONTROLLER_ID=30, CODE_WHITESPACE=31, 
		C_COMMA=32, C_SEMICOLON=33, CODE_OPEN=34, CODE_CLOSE=35, CONTROLLER_CLOSE=36, 
		C_PARENTHESE_OPEN=37, C_PARENTHESE_CLOSE=38, IF=39, ELSE_IF=40, ELSE=41, 
		WHILE=42, SWITCH=43, FOR=44, FUNCTION=45, C_COMMENT=46, PRINT=47, VAR=48, 
		LIST=49, POST=50, SESSION=51, EQUALS=52, OPERAND=53, BOOLEAN_VALUE=54, 
		LIST_ADD=55, LIST_LENGTH=56, LIST_REMOVE=57, LIST_GET=58, DOT=59, VARIABLE_NAME=60, 
		NUMERIC_VALUE=61, C_COLON=62, C_STRING_VALUE=63, CONDITIONAL_OPERATORS_CONCAT=64, 
		CONDITIONAL_OPERATORS_TWO_OPERAND=65;
	public static final int
		page=1, controller=2, code=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "page", "controller", "code"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PAGE_DEFINITION", "CONTROLLER_DEFINITION", "SEA_WS", "COMMENT", "EXTENDS", 
			"COMMA", "SEMICOLON", "PAGE_OPEN", "PAGE_CLOSE", "PARENTHESE_OPEN", "PARENTHESE_CLOSE", 
			"IN", "OUT", "COLON", "HEADER_OPEN", "HEADER_CLOSE", "HEADER", "HEADER_TYPE", 
			"STRING_VALUE", "INPUT_TYPES", "OUTPUT_TYPES", "LINK", "ATTRIBUTE", "PAGE_ID", 
			"NUMERIC_VALUE1", "PAGE_WHITESPACE", "CONTROLLER_OPEN", "CONTROLS", "CONTROLLER_WHITESPACE", 
			"CONTROLLER_ID", "CODE_WHITESPACE", "C_COMMA", "C_SEMICOLON", "CODE_OPEN", 
			"CODE_CLOSE", "CONTROLLER_CLOSE", "C_PARENTHESE_OPEN", "C_PARENTHESE_CLOSE", 
			"IF", "ELSE_IF", "ELSE", "WHILE", "SWITCH", "FOR", "FUNCTION", "C_COMMENT", 
			"PRINT", "VAR", "LIST", "POST", "SESSION", "EQUALS", "OPERAND", "BOOLEAN_VALUE", 
			"LIST_ADD", "LIST_LENGTH", "LIST_REMOVE", "LIST_GET", "DOT", "VARIABLE_NAME", 
			"NUMERIC_VALUE", "C_COLON", "C_STRING_VALUE", "CONDITIONAL_OPERATORS_CONCAT", 
			"CONDITIONAL_OPERATORS_TWO_OPERAND", "VARIABLE_NameChar", "VARIABLE_NameStartChar", 
			"DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'page'", "'controller'", null, null, "'extends'", null, null, 
			null, null, null, null, "'in'", "'out'", null, null, null, "'header'", 
			null, null, null, null, "'Link'", null, null, null, null, null, "'controls'", 
			null, null, null, null, null, null, null, null, null, null, "'if'", "'else if'", 
			"'else'", "'while'", "'switch'", "'for'", "'function'", null, "'print'", 
			"'var'", "'list'", "'post'", "'session'", "'='", null, null, "'add'", 
			"'length'", "'remove'", "'get'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PAGE_DEFINITION", "CONTROLLER_DEFINITION", "SEA_WS", "COMMENT", 
			"EXTENDS", "COMMA", "SEMICOLON", "PAGE_OPEN", "PAGE_CLOSE", "PARENTHESE_OPEN", 
			"PARENTHESE_CLOSE", "IN", "OUT", "COLON", "HEADER_OPEN", "HEADER_CLOSE", 
			"HEADER", "HEADER_TYPE", "STRING_VALUE", "INPUT_TYPES", "OUTPUT_TYPES", 
			"LINK", "ATTRIBUTE", "PAGE_ID", "NUMERIC_VALUE1", "PAGE_WHITESPACE", 
			"CONTROLLER_OPEN", "CONTROLS", "CONTROLLER_WHITESPACE", "CONTROLLER_ID", 
			"CODE_WHITESPACE", "C_COMMA", "C_SEMICOLON", "CODE_OPEN", "CODE_CLOSE", 
			"CONTROLLER_CLOSE", "C_PARENTHESE_OPEN", "C_PARENTHESE_CLOSE", "IF", 
			"ELSE_IF", "ELSE", "WHILE", "SWITCH", "FOR", "FUNCTION", "C_COMMENT", 
			"PRINT", "VAR", "LIST", "POST", "SESSION", "EQUALS", "OPERAND", "BOOLEAN_VALUE", 
			"LIST_ADD", "LIST_LENGTH", "LIST_REMOVE", "LIST_GET", "DOT", "VARIABLE_NAME", 
			"NUMERIC_VALUE", "C_COLON", "C_STRING_VALUE", "CONDITIONAL_OPERATORS_CONCAT", 
			"CONDITIONAL_OPERATORS_TWO_OPERAND"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public HTMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HTMLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u0298\b\1\b\1\b"+
		"\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t"+
		"\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37"+
		"\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)"+
		"\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63"+
		"\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;"+
		"\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\5\4\u00a5\n\4\3\4\6\4\u00a8\n\4\r\4\16\4\u00a9\3\5\3\5\3\5\3"+
		"\5\7\5\u00b0\n\5\f\5\16\5\u00b3\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u00f9\n\23\3\24\3\24\7\24\u00fd\n\24\f\24\16\24\u0100\13\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u014e\n\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u0164\n\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0190\n\30\3\31\3\31\7\31\u0194\n\31\f\31\16\31\u0197"+
		"\13\31\3\32\5\32\u019a\n\32\3\32\6\32\u019d\n\32\r\32\16\32\u019e\3\32"+
		"\3\32\6\32\u01a3\n\32\r\32\16\32\u01a4\5\32\u01a7\n\32\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\7\37\u01c0\n\37\f\37\16\37\u01c3\13\37"+
		"\3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3"+
		",\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\7"+
		"/\u0208\n/\f/\16/\u020b\13/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\5\67\u0242\n\67\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3:"+
		"\3:\3:\3;\3;\3;\3;\3<\3<\3=\3=\7=\u025e\n=\f=\16=\u0261\13=\3>\5>\u0264"+
		"\n>\3>\6>\u0267\n>\r>\16>\u0268\3>\3>\6>\u026d\n>\r>\16>\u026e\5>\u0271"+
		"\n>\3?\3?\3@\3@\7@\u0277\n@\f@\16@\u027a\13@\3@\3@\3A\3A\3A\3A\5A\u0282"+
		"\nA\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u028d\nB\3C\3C\3C\5C\u0292\nC\3D\5D"+
		"\u0295\nD\3E\3E\6\u00b1\u00fe\u0209\u0278\2F\6\3\b\4\n\5\f\6\16\7\20\b"+
		"\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23(\24*\25,\26.\27"+
		"\60\30\62\31\64\32\66\338\34:\35<\36>\37@ B!D\"F#H$J%L&N\'P(R)T*V+X,Z"+
		"-\\.^/`\60b\61d\62f\63h\64j\65l\66n\67p8r9t:v;x<z=|>~?\u0080@\u0082A\u0084"+
		"B\u0086C\u0088\2\u008a\2\u008c\2\6\2\3\4\5\t\4\2\13\13\"\"\5\2\13\f\17"+
		"\17\"\"\6\2\'\',-//\61\61\4\2>>@@\6\2aa\u00b9\u00b9\u0302\u0371\u2041"+
		"\u2042\n\2C\\aac|\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2"+
		"\uffff\3\2\62;\2\u02bc\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2"+
		"\3\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2\2\2\3\30"+
		"\3\2\2\2\3\32\3\2\2\2\3\34\3\2\2\2\3\36\3\2\2\2\3 \3\2\2\2\3\"\3\2\2\2"+
		"\3$\3\2\2\2\3&\3\2\2\2\3(\3\2\2\2\3*\3\2\2\2\3,\3\2\2\2\3.\3\2\2\2\3\60"+
		"\3\2\2\2\3\62\3\2\2\2\3\64\3\2\2\2\3\66\3\2\2\2\38\3\2\2\2\4:\3\2\2\2"+
		"\4<\3\2\2\2\4>\3\2\2\2\4@\3\2\2\2\5B\3\2\2\2\5D\3\2\2\2\5F\3\2\2\2\5H"+
		"\3\2\2\2\5J\3\2\2\2\5L\3\2\2\2\5N\3\2\2\2\5P\3\2\2\2\5R\3\2\2\2\5T\3\2"+
		"\2\2\5V\3\2\2\2\5X\3\2\2\2\5Z\3\2\2\2\5\\\3\2\2\2\5^\3\2\2\2\5`\3\2\2"+
		"\2\5b\3\2\2\2\5d\3\2\2\2\5f\3\2\2\2\5h\3\2\2\2\5j\3\2\2\2\5l\3\2\2\2\5"+
		"n\3\2\2\2\5p\3\2\2\2\5r\3\2\2\2\5t\3\2\2\2\5v\3\2\2\2\5x\3\2\2\2\5z\3"+
		"\2\2\2\5|\3\2\2\2\5~\3\2\2\2\5\u0080\3\2\2\2\5\u0082\3\2\2\2\5\u0084\3"+
		"\2\2\2\5\u0086\3\2\2\2\6\u008e\3\2\2\2\b\u0095\3\2\2\2\n\u00a7\3\2\2\2"+
		"\f\u00ab\3\2\2\2\16\u00b7\3\2\2\2\20\u00bf\3\2\2\2\22\u00c1\3\2\2\2\24"+
		"\u00c3\3\2\2\2\26\u00c5\3\2\2\2\30\u00c9\3\2\2\2\32\u00cb\3\2\2\2\34\u00cd"+
		"\3\2\2\2\36\u00d0\3\2\2\2 \u00d4\3\2\2\2\"\u00d6\3\2\2\2$\u00d8\3\2\2"+
		"\2&\u00da\3\2\2\2(\u00f8\3\2\2\2*\u00fa\3\2\2\2,\u014d\3\2\2\2.\u0163"+
		"\3\2\2\2\60\u0165\3\2\2\2\62\u018f\3\2\2\2\64\u0191\3\2\2\2\66\u0199\3"+
		"\2\2\28\u01a8\3\2\2\2:\u01ac\3\2\2\2<\u01b0\3\2\2\2>\u01b9\3\2\2\2@\u01bd"+
		"\3\2\2\2B\u01c4\3\2\2\2D\u01c8\3\2\2\2F\u01ca\3\2\2\2H\u01cc\3\2\2\2J"+
		"\u01ce\3\2\2\2L\u01d0\3\2\2\2N\u01d5\3\2\2\2P\u01d7\3\2\2\2R\u01d9\3\2"+
		"\2\2T\u01dc\3\2\2\2V\u01e4\3\2\2\2X\u01e9\3\2\2\2Z\u01ef\3\2\2\2\\\u01f6"+
		"\3\2\2\2^\u01fa\3\2\2\2`\u0203\3\2\2\2b\u020f\3\2\2\2d\u0215\3\2\2\2f"+
		"\u0219\3\2\2\2h\u021e\3\2\2\2j\u0223\3\2\2\2l\u022b\3\2\2\2n\u022d\3\2"+
		"\2\2p\u0241\3\2\2\2r\u0243\3\2\2\2t\u0247\3\2\2\2v\u024e\3\2\2\2x\u0255"+
		"\3\2\2\2z\u0259\3\2\2\2|\u025b\3\2\2\2~\u0263\3\2\2\2\u0080\u0272\3\2"+
		"\2\2\u0082\u0274\3\2\2\2\u0084\u0281\3\2\2\2\u0086\u028c\3\2\2\2\u0088"+
		"\u0291\3\2\2\2\u008a\u0294\3\2\2\2\u008c\u0296\3\2\2\2\u008e\u008f\7r"+
		"\2\2\u008f\u0090\7c\2\2\u0090\u0091\7i\2\2\u0091\u0092\7g\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0094\b\2\2\2\u0094\7\3\2\2\2\u0095\u0096\7e\2\2\u0096"+
		"\u0097\7q\2\2\u0097\u0098\7p\2\2\u0098\u0099\7v\2\2\u0099\u009a\7t\2\2"+
		"\u009a\u009b\7q\2\2\u009b\u009c\7n\2\2\u009c\u009d\7n\2\2\u009d\u009e"+
		"\7g\2\2\u009e\u009f\7t\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\3\3\2\u00a1"+
		"\t\3\2\2\2\u00a2\u00a8\t\2\2\2\u00a3\u00a5\7\17\2\2\u00a4\u00a3\3\2\2"+
		"\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\7\f\2\2\u00a7\u00a2"+
		"\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\13\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00ad\7,\2"+
		"\2\u00ad\u00b1\3\2\2\2\u00ae\u00b0\13\2\2\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b6\7\61\2\2\u00b6"+
		"\r\3\2\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7z\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7g\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f\2\2\u00bd\u00be\7u\2\2"+
		"\u00be\17\3\2\2\2\u00bf\u00c0\7.\2\2\u00c0\21\3\2\2\2\u00c1\u00c2\7=\2"+
		"\2\u00c2\23\3\2\2\2\u00c3\u00c4\7}\2\2\u00c4\25\3\2\2\2\u00c5\u00c6\7"+
		"\177\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\n\4\2\u00c8\27\3\2\2\2\u00c9"+
		"\u00ca\7*\2\2\u00ca\31\3\2\2\2\u00cb\u00cc\7+\2\2\u00cc\33\3\2\2\2\u00cd"+
		"\u00ce\7k\2\2\u00ce\u00cf\7p\2\2\u00cf\35\3\2\2\2\u00d0\u00d1\7q\2\2\u00d1"+
		"\u00d2\7w\2\2\u00d2\u00d3\7v\2\2\u00d3\37\3\2\2\2\u00d4\u00d5\7<\2\2\u00d5"+
		"!\3\2\2\2\u00d6\u00d7\7]\2\2\u00d7#\3\2\2\2\u00d8\u00d9\7_\2\2\u00d9%"+
		"\3\2\2\2\u00da\u00db\7j\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7c\2\2\u00dd"+
		"\u00de\7f\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7t\2\2\u00e0\'\3\2\2\2\u00e1"+
		"\u00e2\7r\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7i\2\2\u00e4\u00e5\7g\2\2"+
		"\u00e5\u00e6\7V\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9"+
		"\7n\2\2\u00e9\u00f9\7g\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7c\2\2\u00ec"+
		"\u00ed\7p\2\2\u00ed\u00ee\7i\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7c\2\2"+
		"\u00f0\u00f1\7i\2\2\u00f1\u00f9\7g\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4"+
		"\7w\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7j\2\2\u00f6\u00f7\7q\2\2\u00f7"+
		"\u00f9\7t\2\2\u00f8\u00e1\3\2\2\2\u00f8\u00ea\3\2\2\2\u00f8\u00f2\3\2"+
		"\2\2\u00f9)\3\2\2\2\u00fa\u00fe\7$\2\2\u00fb\u00fd\13\2\2\2\u00fc\u00fb"+
		"\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff"+
		"\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\7$\2\2\u0102+\3\2\2\2\u0103"+
		"\u0104\7T\2\2\u0104\u0105\7c\2\2\u0105\u0106\7f\2\2\u0106\u0107\7k\2\2"+
		"\u0107\u0108\7q\2\2\u0108\u0109\7D\2\2\u0109\u010a\7w\2\2\u010a\u010b"+
		"\7v\2\2\u010b\u010c\7v\2\2\u010c\u010d\7q\2\2\u010d\u014e\7p\2\2\u010e"+
		"\u010f\7E\2\2\u010f\u0110\7j\2\2\u0110\u0111\7g\2\2\u0111\u0112\7e\2\2"+
		"\u0112\u0113\7m\2\2\u0113\u0114\7D\2\2\u0114\u0115\7q\2\2\u0115\u014e"+
		"\7z\2\2\u0116\u0117\7U\2\2\u0117\u0118\7w\2\2\u0118\u0119\7d\2\2\u0119"+
		"\u011a\7o\2\2\u011a\u011b\7k\2\2\u011b\u011c\7v\2\2\u011c\u011d\7D\2\2"+
		"\u011d\u011e\7w\2\2\u011e\u011f\7v\2\2\u011f\u0120\7v\2\2\u0120\u0121"+
		"\7q\2\2\u0121\u014e\7p\2\2\u0122\u0123\7V\2\2\u0123\u0124\7g\2\2\u0124"+
		"\u0125\7z\2\2\u0125\u0126\7v\2\2\u0126\u0127\7H\2\2\u0127\u0128\7k\2\2"+
		"\u0128\u0129\7g\2\2\u0129\u012a\7n\2\2\u012a\u014e\7f\2\2\u012b\u012c"+
		"\7R\2\2\u012c\u012d\7c\2\2\u012d\u012e\7u\2\2\u012e\u012f\7u\2\2\u012f"+
		"\u0130\7y\2\2\u0130\u0131\7q\2\2\u0131\u0132\7t\2\2\u0132\u0133\7f\2\2"+
		"\u0133\u0134\7H\2\2\u0134\u0135\7k\2\2\u0135\u0136\7g\2\2\u0136\u0137"+
		"\7n\2\2\u0137\u014e\7f\2\2\u0138\u0139\7G\2\2\u0139\u013a\7o\2\2\u013a"+
		"\u013b\7c\2\2\u013b\u013c\7k\2\2\u013c\u013d\7n\2\2\u013d\u013e\7H\2\2"+
		"\u013e\u013f\7k\2\2\u013f\u0140\7g\2\2\u0140\u0141\7n\2\2\u0141\u014e"+
		"\7f\2\2\u0142\u0143\7P\2\2\u0143\u0144\7w\2\2\u0144\u0145\7o\2\2\u0145"+
		"\u0146\7d\2\2\u0146\u0147\7g\2\2\u0147\u0148\7t\2\2\u0148\u0149\7H\2\2"+
		"\u0149\u014a\7k\2\2\u014a\u014b\7g\2\2\u014b\u014c\7n\2\2\u014c\u014e"+
		"\7f\2\2\u014d\u0103\3\2\2\2\u014d\u010e\3\2\2\2\u014d\u0116\3\2\2\2\u014d"+
		"\u0122\3\2\2\2\u014d\u012b\3\2\2\2\u014d\u0138\3\2\2\2\u014d\u0142\3\2"+
		"\2\2\u014e-\3\2\2\2\u014f\u0150\7R\2\2\u0150\u0151\7c\2\2\u0151\u0152"+
		"\7t\2\2\u0152\u0153\7c\2\2\u0153\u0154\7i\2\2\u0154\u0155\7t\2\2\u0155"+
		"\u0156\7c\2\2\u0156\u0157\7r\2\2\u0157\u0164\7j\2\2\u0158\u0159\7K\2\2"+
		"\u0159\u015a\7o\2\2\u015a\u015b\7c\2\2\u015b\u015c\7i\2\2\u015c\u0164"+
		"\7g\2\2\u015d\u015e\7J\2\2\u015e\u015f\7g\2\2\u015f\u0160\7c\2\2\u0160"+
		"\u0161\7f\2\2\u0161\u0162\7g\2\2\u0162\u0164\7t\2\2\u0163\u014f\3\2\2"+
		"\2\u0163\u0158\3\2\2\2\u0163\u015d\3\2\2\2\u0164/\3\2\2\2\u0165\u0166"+
		"\7N\2\2\u0166\u0167\7k\2\2\u0167\u0168\7p\2\2\u0168\u0169\7m\2\2\u0169"+
		"\61\3\2\2\2\u016a\u016b\7v\2\2\u016b\u016c\7k\2\2\u016c\u016d\7v\2\2\u016d"+
		"\u016e\7n\2\2\u016e\u0190\7g\2\2\u016f\u0170\7x\2\2\u0170\u0171\7c\2\2"+
		"\u0171\u0172\7n\2\2\u0172\u0173\7w\2\2\u0173\u0190\7g\2\2\u0174\u0175"+
		"\7y\2\2\u0175\u0176\7k\2\2\u0176\u0177\7f\2\2\u0177\u0178\7v\2\2\u0178"+
		"\u0190\7j\2\2\u0179\u017a\7j\2\2\u017a\u017b\7g\2\2\u017b\u017c\7k\2\2"+
		"\u017c\u017d\7i\2\2\u017d\u017e\7j\2\2\u017e\u0190\7v\2\2\u017f\u0180"+
		"\7u\2\2\u0180\u0181\7q\2\2\u0181\u0182\7w\2\2\u0182\u0183\7t\2\2\u0183"+
		"\u0184\7e\2\2\u0184\u0190\7g\2\2\u0185\u0186\7i\2\2\u0186\u0187\7t\2\2"+
		"\u0187\u0188\7q\2\2\u0188\u0189\7w\2\2\u0189\u018a\7r\2\2\u018a\u018b"+
		"\7X\2\2\u018b\u018c\7c\2\2\u018c\u018d\7n\2\2\u018d\u018e\7w\2\2\u018e"+
		"\u0190\7g\2\2\u018f\u016a\3\2\2\2\u018f\u016f\3\2\2\2\u018f\u0174\3\2"+
		"\2\2\u018f\u0179\3\2\2\2\u018f\u017f\3\2\2\2\u018f\u0185\3\2\2\2\u0190"+
		"\63\3\2\2\2\u0191\u0195\5\u008aD\2\u0192\u0194\5\u0088C\2\u0193\u0192"+
		"\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196"+
		"\65\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u019a\7/\2\2\u0199\u0198\3\2\2\2"+
		"\u0199\u019a\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u019d\5\u008cE\2\u019c"+
		"\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2"+
		"\2\2\u019f\u01a6\3\2\2\2\u01a0\u01a2\7\60\2\2\u01a1\u01a3\5\u008cE\2\u01a2"+
		"\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2"+
		"\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a0\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\67\3\2\2\2\u01a8\u01a9\t\3\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\b\33\5"+
		"\2\u01ab9\3\2\2\2\u01ac\u01ad\7}\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\b"+
		"\34\6\2\u01af;\3\2\2\2\u01b0\u01b1\7e\2\2\u01b1\u01b2\7q\2\2\u01b2\u01b3"+
		"\7p\2\2\u01b3\u01b4\7v\2\2\u01b4\u01b5\7t\2\2\u01b5\u01b6\7q\2\2\u01b6"+
		"\u01b7\7n\2\2\u01b7\u01b8\7u\2\2\u01b8=\3\2\2\2\u01b9\u01ba\t\3\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bb\u01bc\b\36\5\2\u01bc?\3\2\2\2\u01bd\u01c1\5\u008a"+
		"D\2\u01be\u01c0\5\u0088C\2\u01bf\u01be\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1"+
		"\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2A\3\2\2\2\u01c3\u01c1\3\2\2\2"+
		"\u01c4\u01c5\t\3\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\b \5\2\u01c7C\3\2"+
		"\2\2\u01c8\u01c9\7.\2\2\u01c9E\3\2\2\2\u01ca\u01cb\7=\2\2\u01cbG\3\2\2"+
		"\2\u01cc\u01cd\7]\2\2\u01cdI\3\2\2\2\u01ce\u01cf\7_\2\2\u01cfK\3\2\2\2"+
		"\u01d0\u01d1\7\177\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\b%\4\2\u01d3\u01d4"+
		"\b%\4\2\u01d4M\3\2\2\2\u01d5\u01d6\7*\2\2\u01d6O\3\2\2\2\u01d7\u01d8\7"+
		"+\2\2\u01d8Q\3\2\2\2\u01d9\u01da\7k\2\2\u01da\u01db\7h\2\2\u01dbS\3\2"+
		"\2\2\u01dc\u01dd\7g\2\2\u01dd\u01de\7n\2\2\u01de\u01df\7u\2\2\u01df\u01e0"+
		"\7g\2\2\u01e0\u01e1\7\"\2\2\u01e1\u01e2\7k\2\2\u01e2\u01e3\7h\2\2\u01e3"+
		"U\3\2\2\2\u01e4\u01e5\7g\2\2\u01e5\u01e6\7n\2\2\u01e6\u01e7\7u\2\2\u01e7"+
		"\u01e8\7g\2\2\u01e8W\3\2\2\2\u01e9\u01ea\7y\2\2\u01ea\u01eb\7j\2\2\u01eb"+
		"\u01ec\7k\2\2\u01ec\u01ed\7n\2\2\u01ed\u01ee\7g\2\2\u01eeY\3\2\2\2\u01ef"+
		"\u01f0\7u\2\2\u01f0\u01f1\7y\2\2\u01f1\u01f2\7k\2\2\u01f2\u01f3\7v\2\2"+
		"\u01f3\u01f4\7e\2\2\u01f4\u01f5\7j\2\2\u01f5[\3\2\2\2\u01f6\u01f7\7h\2"+
		"\2\u01f7\u01f8\7q\2\2\u01f8\u01f9\7t\2\2\u01f9]\3\2\2\2\u01fa\u01fb\7"+
		"h\2\2\u01fb\u01fc\7w\2\2\u01fc\u01fd\7p\2\2\u01fd\u01fe\7e\2\2\u01fe\u01ff"+
		"\7v\2\2\u01ff\u0200\7k\2\2\u0200\u0201\7q\2\2\u0201\u0202\7p\2\2\u0202"+
		"_\3\2\2\2\u0203\u0204\7\61\2\2\u0204\u0205\7,\2\2\u0205\u0209\3\2\2\2"+
		"\u0206\u0208\13\2\2\2\u0207\u0206\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u0209\u0207\3\2\2\2\u020a\u020c\3\2\2\2\u020b\u0209\3\2\2\2\u020c"+
		"\u020d\7,\2\2\u020d\u020e\7\61\2\2\u020ea\3\2\2\2\u020f\u0210\7r\2\2\u0210"+
		"\u0211\7t\2\2\u0211\u0212\7k\2\2\u0212\u0213\7p\2\2\u0213\u0214\7v\2\2"+
		"\u0214c\3\2\2\2\u0215\u0216\7x\2\2\u0216\u0217\7c\2\2\u0217\u0218\7t\2"+
		"\2\u0218e\3\2\2\2\u0219\u021a\7n\2\2\u021a\u021b\7k\2\2\u021b\u021c\7"+
		"u\2\2\u021c\u021d\7v\2\2\u021dg\3\2\2\2\u021e\u021f\7r\2\2\u021f\u0220"+
		"\7q\2\2\u0220\u0221\7u\2\2\u0221\u0222\7v\2\2\u0222i\3\2\2\2\u0223\u0224"+
		"\7u\2\2\u0224\u0225\7g\2\2\u0225\u0226\7u\2\2\u0226\u0227\7u\2\2\u0227"+
		"\u0228\7k\2\2\u0228\u0229\7q\2\2\u0229\u022a\7p\2\2\u022ak\3\2\2\2\u022b"+
		"\u022c\7?\2\2\u022cm\3\2\2\2\u022d\u022e\t\4\2\2\u022eo\3\2\2\2\u022f"+
		"\u0230\7v\2\2\u0230\u0231\7t\2\2\u0231\u0232\7w\2\2\u0232\u0242\7g\2\2"+
		"\u0233\u0234\7V\2\2\u0234\u0235\7T\2\2\u0235\u0236\7W\2\2\u0236\u0242"+
		"\7G\2\2\u0237\u0238\7h\2\2\u0238\u0239\7c\2\2\u0239\u023a\7n\2\2\u023a"+
		"\u023b\7u\2\2\u023b\u0242\7g\2\2\u023c\u023d\7H\2\2\u023d\u023e\7C\2\2"+
		"\u023e\u023f\7N\2\2\u023f\u0240\7U\2\2\u0240\u0242\7G\2\2\u0241\u022f"+
		"\3\2\2\2\u0241\u0233\3\2\2\2\u0241\u0237\3\2\2\2\u0241\u023c\3\2\2\2\u0242"+
		"q\3\2\2\2\u0243\u0244\7c\2\2\u0244\u0245\7f\2\2\u0245\u0246\7f\2\2\u0246"+
		"s\3\2\2\2\u0247\u0248\7n\2\2\u0248\u0249\7g\2\2\u0249\u024a\7p\2\2\u024a"+
		"\u024b\7i\2\2\u024b\u024c\7v\2\2\u024c\u024d\7j\2\2\u024du\3\2\2\2\u024e"+
		"\u024f\7t\2\2\u024f\u0250\7g\2\2\u0250\u0251\7o\2\2\u0251\u0252\7q\2\2"+
		"\u0252\u0253\7x\2\2\u0253\u0254\7g\2\2\u0254w\3\2\2\2\u0255\u0256\7i\2"+
		"\2\u0256\u0257\7g\2\2\u0257\u0258\7v\2\2\u0258y\3\2\2\2\u0259\u025a\7"+
		"\60\2\2\u025a{\3\2\2\2\u025b\u025f\5\u008aD\2\u025c\u025e\5\u0088C\2\u025d"+
		"\u025c\3\2\2\2\u025e\u0261\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u0260\3\2"+
		"\2\2\u0260}\3\2\2\2\u0261\u025f\3\2\2\2\u0262\u0264\7/\2\2\u0263\u0262"+
		"\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0267\5\u008cE"+
		"\2\u0266\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269"+
		"\3\2\2\2\u0269\u0270\3\2\2\2\u026a\u026c\7\60\2\2\u026b\u026d\5\u008c"+
		"E\2\u026c\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026c\3\2\2\2\u026e"+
		"\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u026a\3\2\2\2\u0270\u0271\3\2"+
		"\2\2\u0271\177\3\2\2\2\u0272\u0273\7<\2\2\u0273\u0081\3\2\2\2\u0274\u0278"+
		"\7$\2\2\u0275\u0277\13\2\2\2\u0276\u0275\3\2\2\2\u0277\u027a\3\2\2\2\u0278"+
		"\u0279\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027b\3\2\2\2\u027a\u0278\3\2"+
		"\2\2\u027b\u027c\7$\2\2\u027c\u0083\3\2\2\2\u027d\u027e\7~\2\2\u027e\u0282"+
		"\7~\2\2\u027f\u0280\7(\2\2\u0280\u0282\7(\2\2\u0281\u027d\3\2\2\2\u0281"+
		"\u027f\3\2\2\2\u0282\u0085\3\2\2\2\u0283\u028d\t\5\2\2\u0284\u0285\7?"+
		"\2\2\u0285\u028d\7?\2\2\u0286\u0287\7@\2\2\u0287\u028d\7?\2\2\u0288\u0289"+
		"\7>\2\2\u0289\u028d\7?\2\2\u028a\u028b\7#\2\2\u028b\u028d\7?\2\2\u028c"+
		"\u0283\3\2\2\2\u028c\u0284\3\2\2\2\u028c\u0286\3\2\2\2\u028c\u0288\3\2"+
		"\2\2\u028c\u028a\3\2\2\2\u028d\u0087\3\2\2\2\u028e\u0292\5\u008aD\2\u028f"+
		"\u0292\5\u008cE\2\u0290\u0292\t\6\2\2\u0291\u028e\3\2\2\2\u0291\u028f"+
		"\3\2\2\2\u0291\u0290\3\2\2\2\u0292\u0089\3\2\2\2\u0293\u0295\t\7\2\2\u0294"+
		"\u0293\3\2\2\2\u0295\u008b\3\2\2\2\u0296\u0297\t\b\2\2\u0297\u008d\3\2"+
		"\2\2!\2\3\4\5\u00a4\u00a7\u00a9\u00b1\u00f8\u00fe\u014d\u0163\u018f\u0195"+
		"\u0199\u019e\u01a4\u01a6\u01c1\u0209\u0241\u025f\u0263\u0268\u026e\u0270"+
		"\u0278\u0281\u028c\u0291\u0294\7\7\3\2\7\4\2\6\2\2\2\3\2\7\5\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}