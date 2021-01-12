// Generated from C:/Users/Ting/Documents/GDBViews/src\View.g4 by ANTLR 4.8
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ViewLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, KEYWORD=22, RETURN=23, COMMAND=24, 
		COMPARISON=25, OPERATOR=26, CONSTANTS=27, VALUE=28, NAME=29, WHITESPACE=30, 
		ANY=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "KEYWORD", "RETURN", "COMMAND", "COMPARISON", 
			"OPERATOR", "CONSTANTS", "VALUE", "NAME", "WHITESPACE", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CG'", "'SET'", "'DELETE'", "'REMOVE'", "'CREATE'", "'WITH VIEWS'", 
			"'-['", "']-'", "'NODES('", "')'", "'('", "':'", "'='", "'WHERE'", "'AND'", 
			"'OR'", "'IN'", "'.'", "'{'", "'}'", "','", null, "'RETURN'", "'CREATE VIEW AS'", 
			null, null, null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "KEYWORD", 
			"RETURN", "COMMAND", "COMPARISON", "OPERATOR", "CONSTANTS", "VALUE", 
			"NAME", "WHITESPACE", "ANY"
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


	public ViewLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "View.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u0149\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00a0"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u00bd\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0108\n\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0117\n\34\3\35\3\35\3\35"+
		"\7\35\u011c\n\35\f\35\16\35\u011f\13\35\3\35\3\35\3\35\7\35\u0124\n\35"+
		"\f\35\16\35\u0127\13\35\3\35\3\35\3\35\6\35\u012c\n\35\r\35\16\35\u012d"+
		"\3\35\7\35\u0131\n\35\f\35\16\35\u0134\13\35\3\35\5\35\u0137\n\35\3\36"+
		"\6\36\u013a\n\36\r\36\16\36\u013b\3\36\7\36\u013f\n\36\f\36\16\36\u0142"+
		"\13\36\3\37\3\37\3\37\3\37\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\b\4\2>>@@\3\2\62\62\3\2\63"+
		";\3\2\62;\6\2\"\"C\\aac|\5\2C\\aac|\2\u0162\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\3A\3\2\2\2\5D\3\2\2\2\7H\3\2\2\2\tO\3\2\2\2\13V\3\2\2\2\r]\3\2\2\2"+
		"\17h\3\2\2\2\21k\3\2\2\2\23n\3\2\2\2\25u\3\2\2\2\27w\3\2\2\2\31y\3\2\2"+
		"\2\33{\3\2\2\2\35}\3\2\2\2\37\u0083\3\2\2\2!\u0087\3\2\2\2#\u008a\3\2"+
		"\2\2%\u008d\3\2\2\2\'\u008f\3\2\2\2)\u0091\3\2\2\2+\u0093\3\2\2\2-\u009f"+
		"\3\2\2\2/\u00a1\3\2\2\2\61\u00a8\3\2\2\2\63\u00bc\3\2\2\2\65\u0107\3\2"+
		"\2\2\67\u0116\3\2\2\29\u0136\3\2\2\2;\u0139\3\2\2\2=\u0143\3\2\2\2?\u0147"+
		"\3\2\2\2AB\7E\2\2BC\7I\2\2C\4\3\2\2\2DE\7U\2\2EF\7G\2\2FG\7V\2\2G\6\3"+
		"\2\2\2HI\7F\2\2IJ\7G\2\2JK\7N\2\2KL\7G\2\2LM\7V\2\2MN\7G\2\2N\b\3\2\2"+
		"\2OP\7T\2\2PQ\7G\2\2QR\7O\2\2RS\7Q\2\2ST\7X\2\2TU\7G\2\2U\n\3\2\2\2VW"+
		"\7E\2\2WX\7T\2\2XY\7G\2\2YZ\7C\2\2Z[\7V\2\2[\\\7G\2\2\\\f\3\2\2\2]^\7"+
		"Y\2\2^_\7K\2\2_`\7V\2\2`a\7J\2\2ab\7\"\2\2bc\7X\2\2cd\7K\2\2de\7G\2\2"+
		"ef\7Y\2\2fg\7U\2\2g\16\3\2\2\2hi\7/\2\2ij\7]\2\2j\20\3\2\2\2kl\7_\2\2"+
		"lm\7/\2\2m\22\3\2\2\2no\7P\2\2op\7Q\2\2pq\7F\2\2qr\7G\2\2rs\7U\2\2st\7"+
		"*\2\2t\24\3\2\2\2uv\7+\2\2v\26\3\2\2\2wx\7*\2\2x\30\3\2\2\2yz\7<\2\2z"+
		"\32\3\2\2\2{|\7?\2\2|\34\3\2\2\2}~\7Y\2\2~\177\7J\2\2\177\u0080\7G\2\2"+
		"\u0080\u0081\7T\2\2\u0081\u0082\7G\2\2\u0082\36\3\2\2\2\u0083\u0084\7"+
		"C\2\2\u0084\u0085\7P\2\2\u0085\u0086\7F\2\2\u0086 \3\2\2\2\u0087\u0088"+
		"\7Q\2\2\u0088\u0089\7T\2\2\u0089\"\3\2\2\2\u008a\u008b\7K\2\2\u008b\u008c"+
		"\7P\2\2\u008c$\3\2\2\2\u008d\u008e\7\60\2\2\u008e&\3\2\2\2\u008f\u0090"+
		"\7}\2\2\u0090(\3\2\2\2\u0091\u0092\7\177\2\2\u0092*\3\2\2\2\u0093\u0094"+
		"\7.\2\2\u0094,\3\2\2\2\u0095\u0096\7O\2\2\u0096\u0097\7C\2\2\u0097\u0098"+
		"\7V\2\2\u0098\u0099\7E\2\2\u0099\u00a0\7J\2\2\u009a\u009b\7O\2\2\u009b"+
		"\u009c\7G\2\2\u009c\u009d\7T\2\2\u009d\u009e\7I\2\2\u009e\u00a0\7G\2\2"+
		"\u009f\u0095\3\2\2\2\u009f\u009a\3\2\2\2\u00a0.\3\2\2\2\u00a1\u00a2\7"+
		"T\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7V\2\2\u00a4\u00a5\7W\2\2\u00a5\u00a6"+
		"\7T\2\2\u00a6\u00a7\7P\2\2\u00a7\60\3\2\2\2\u00a8\u00a9\7E\2\2\u00a9\u00aa"+
		"\7T\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac\7C\2\2\u00ac\u00ad\7V\2\2\u00ad"+
		"\u00ae\7G\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\7X\2\2\u00b0\u00b1\7K\2"+
		"\2\u00b1\u00b2\7G\2\2\u00b2\u00b3\7Y\2\2\u00b3\u00b4\7\"\2\2\u00b4\u00b5"+
		"\7C\2\2\u00b5\u00b6\7U\2\2\u00b6\62\3\2\2\2\u00b7\u00bd\t\2\2\2\u00b8"+
		"\u00b9\7@\2\2\u00b9\u00bd\7?\2\2\u00ba\u00bb\7>\2\2\u00bb\u00bd\7?\2\2"+
		"\u00bc\u00b7\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\64"+
		"\3\2\2\2\u00be\u00bf\7E\2\2\u00bf\u00c0\7C\2\2\u00c0\u00c1\7U\2\2\u00c1"+
		"\u0108\7G\2\2\u00c2\u00c3\7E\2\2\u00c3\u00c4\7Q\2\2\u00c4\u00c5\7P\2\2"+
		"\u00c5\u00c6\7V\2\2\u00c6\u00c7\7C\2\2\u00c7\u00c8\7K\2\2\u00c8\u00c9"+
		"\7P\2\2\u00c9\u0108\7U\2\2\u00ca\u00cb\7G\2\2\u00cb\u00cc\7N\2\2\u00cc"+
		"\u00cd\7U\2\2\u00cd\u0108\7G\2\2\u00ce\u00cf\7G\2\2\u00cf\u00d0\7P\2\2"+
		"\u00d0\u0108\7F\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7P\2\2\u00d3\u00d4"+
		"\7F\2\2\u00d4\u00d5\7U\2\2\u00d5\u00d6\7\"\2\2\u00d6\u00d7\7Y\2\2\u00d7"+
		"\u00d8\7K\2\2\u00d8\u00d9\7V\2\2\u00d9\u0108\7J\2\2\u00da\u00db\7K\2\2"+
		"\u00db\u0108\7P\2\2\u00dc\u00dd\7K\2\2\u00dd\u00de\7U\2\2\u00de\u00df"+
		"\7\"\2\2\u00df\u00e0\7P\2\2\u00e0\u00e1\7Q\2\2\u00e1\u00e2\7V\2\2\u00e2"+
		"\u00e3\7\"\2\2\u00e3\u00e4\7P\2\2\u00e4\u00e5\7W\2\2\u00e5\u00e6\7N\2"+
		"\2\u00e6\u0108\7N\2\2\u00e7\u00e8\7K\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea"+
		"\7\"\2\2\u00ea\u00eb\7P\2\2\u00eb\u00ec\7W\2\2\u00ec\u00ed\7N\2\2\u00ed"+
		"\u0108\7N\2\2\u00ee\u00ef\7P\2\2\u00ef\u00f0\7Q\2\2\u00f0\u0108\7V\2\2"+
		"\u00f1\u00f2\7U\2\2\u00f2\u00f3\7V\2\2\u00f3\u00f4\7C\2\2\u00f4\u00f5"+
		"\7T\2\2\u00f5\u00f6\7V\2\2\u00f6\u00f7\7U\2\2\u00f7\u00f8\7\"\2\2\u00f8"+
		"\u00f9\7Y\2\2\u00f9\u00fa\7K\2\2\u00fa\u00fb\7V\2\2\u00fb\u0108\7J\2\2"+
		"\u00fc\u00fd\7V\2\2\u00fd\u00fe\7J\2\2\u00fe\u00ff\7G\2\2\u00ff\u0108"+
		"\7P\2\2\u0100\u0101\7Y\2\2\u0101\u0102\7J\2\2\u0102\u0103\7G\2\2\u0103"+
		"\u0108\7P\2\2\u0104\u0105\7Z\2\2\u0105\u0106\7Q\2\2\u0106\u0108\7T\2\2"+
		"\u0107\u00be\3\2\2\2\u0107\u00c2\3\2\2\2\u0107\u00ca\3\2\2\2\u0107\u00ce"+
		"\3\2\2\2\u0107\u00d1\3\2\2\2\u0107\u00da\3\2\2\2\u0107\u00dc\3\2\2\2\u0107"+
		"\u00e7\3\2\2\2\u0107\u00ee\3\2\2\2\u0107\u00f1\3\2\2\2\u0107\u00fc\3\2"+
		"\2\2\u0107\u0100\3\2\2\2\u0107\u0104\3\2\2\2\u0108\66\3\2\2\2\u0109\u010a"+
		"\7v\2\2\u010a\u010b\7t\2\2\u010b\u010c\7w\2\2\u010c\u0117\7g\2\2\u010d"+
		"\u010e\7h\2\2\u010e\u010f\7c\2\2\u010f\u0110\7n\2\2\u0110\u0111\7u\2\2"+
		"\u0111\u0117\7g\2\2\u0112\u0113\7p\2\2\u0113\u0114\7w\2\2\u0114\u0115"+
		"\7n\2\2\u0115\u0117\7n\2\2\u0116\u0109\3\2\2\2\u0116\u010d\3\2\2\2\u0116"+
		"\u0112\3\2\2\2\u01178\3\2\2\2\u0118\u0137\t\3\2\2\u0119\u011d\t\4\2\2"+
		"\u011a\u011c\t\5\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0137\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0121\t\3\2\2\u0121\u0125\7\60\2\2\u0122\u0124\t\5\2\2\u0123\u0122\3"+
		"\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0137\t\4\2\2\u0129\u012b\7$"+
		"\2\2\u012a\u012c\t\6\2\2\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0132\3\2\2\2\u012f\u0131\t\5"+
		"\2\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0137\7$"+
		"\2\2\u0136\u0118\3\2\2\2\u0136\u0119\3\2\2\2\u0136\u0120\3\2\2\2\u0136"+
		"\u0129\3\2\2\2\u0137:\3\2\2\2\u0138\u013a\t\7\2\2\u0139\u0138\3\2\2\2"+
		"\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u0140"+
		"\3\2\2\2\u013d\u013f\t\5\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141<\3\2\2\2\u0142\u0140\3\2\2\2"+
		"\u0143\u0144\7\"\2\2\u0144\u0145\3\2\2\2\u0145\u0146\b\37\2\2\u0146>\3"+
		"\2\2\2\u0147\u0148\13\2\2\2\u0148@\3\2\2\2\16\2\u009f\u00bc\u0107\u0116"+
		"\u011d\u0125\u012d\u0132\u0136\u013b\u0140\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}