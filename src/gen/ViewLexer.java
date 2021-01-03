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
		KEYWORD=18, RETURN=19, COMMAND=20, COMPARISON=21, OPERATOR=22, CONSTANTS=23, 
		VALUE=24, NAME=25, WHITESPACE=26, ANY=27;
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
			"KEYWORD", "RETURN", "COMMAND", "COMPARISON", "OPERATOR", "CONSTANTS", 
			"VALUE", "NAME", "WHITESPACE", "ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CG'", "'SET'", "'REMOVE'", "'CREATE'", "'WITH VIEWS'", "'-['", 
			"']-'", "'NODES('", "')'", "'('", "':'", "'='", "'WHERE'", "'AND'", "'OR'", 
			"'IN'", "'.'", null, "'RETURN'", null, null, null, null, null, null, 
			"' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "KEYWORD", "RETURN", "COMMAND", "COMPARISON", 
			"OPERATOR", "CONSTANTS", "VALUE", "NAME", "WHITESPACE", "ANY"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u013d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u008b\n\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00aa"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u00b1\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00fc"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u010b\n\30\3\31\3\31\3\31\7\31\u0110\n\31\f\31\16\31\u0113\13\31"+
		"\3\31\3\31\3\31\7\31\u0118\n\31\f\31\16\31\u011b\13\31\3\31\3\31\3\31"+
		"\6\31\u0120\n\31\r\31\16\31\u0121\3\31\7\31\u0125\n\31\f\31\16\31\u0128"+
		"\13\31\3\31\5\31\u012b\n\31\3\32\6\32\u012e\n\32\r\32\16\32\u012f\3\32"+
		"\7\32\u0133\n\32\f\32\16\32\u0136\13\32\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"\3\2\b\4\2>>@@\3\2\62\62\3\2\63;\3\2\62;\6\2\"\"C\\aac|\5\2C\\aac|\2\u0157"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5<\3"+
		"\2\2\2\7@\3\2\2\2\tG\3\2\2\2\13N\3\2\2\2\rY\3\2\2\2\17\\\3\2\2\2\21_\3"+
		"\2\2\2\23f\3\2\2\2\25h\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33n\3\2\2\2\35"+
		"t\3\2\2\2\37x\3\2\2\2!{\3\2\2\2#~\3\2\2\2%\u008a\3\2\2\2\'\u008c\3\2\2"+
		"\2)\u00a9\3\2\2\2+\u00b0\3\2\2\2-\u00fb\3\2\2\2/\u010a\3\2\2\2\61\u012a"+
		"\3\2\2\2\63\u012d\3\2\2\2\65\u0137\3\2\2\2\67\u013b\3\2\2\29:\7E\2\2:"+
		";\7I\2\2;\4\3\2\2\2<=\7U\2\2=>\7G\2\2>?\7V\2\2?\6\3\2\2\2@A\7T\2\2AB\7"+
		"G\2\2BC\7O\2\2CD\7Q\2\2DE\7X\2\2EF\7G\2\2F\b\3\2\2\2GH\7E\2\2HI\7T\2\2"+
		"IJ\7G\2\2JK\7C\2\2KL\7V\2\2LM\7G\2\2M\n\3\2\2\2NO\7Y\2\2OP\7K\2\2PQ\7"+
		"V\2\2QR\7J\2\2RS\7\"\2\2ST\7X\2\2TU\7K\2\2UV\7G\2\2VW\7Y\2\2WX\7U\2\2"+
		"X\f\3\2\2\2YZ\7/\2\2Z[\7]\2\2[\16\3\2\2\2\\]\7_\2\2]^\7/\2\2^\20\3\2\2"+
		"\2_`\7P\2\2`a\7Q\2\2ab\7F\2\2bc\7G\2\2cd\7U\2\2de\7*\2\2e\22\3\2\2\2f"+
		"g\7+\2\2g\24\3\2\2\2hi\7*\2\2i\26\3\2\2\2jk\7<\2\2k\30\3\2\2\2lm\7?\2"+
		"\2m\32\3\2\2\2no\7Y\2\2op\7J\2\2pq\7G\2\2qr\7T\2\2rs\7G\2\2s\34\3\2\2"+
		"\2tu\7C\2\2uv\7P\2\2vw\7F\2\2w\36\3\2\2\2xy\7Q\2\2yz\7T\2\2z \3\2\2\2"+
		"{|\7K\2\2|}\7P\2\2}\"\3\2\2\2~\177\7\60\2\2\177$\3\2\2\2\u0080\u0081\7"+
		"O\2\2\u0081\u0082\7C\2\2\u0082\u0083\7V\2\2\u0083\u0084\7E\2\2\u0084\u008b"+
		"\7J\2\2\u0085\u0086\7O\2\2\u0086\u0087\7G\2\2\u0087\u0088\7T\2\2\u0088"+
		"\u0089\7I\2\2\u0089\u008b\7G\2\2\u008a\u0080\3\2\2\2\u008a\u0085\3\2\2"+
		"\2\u008b&\3\2\2\2\u008c\u008d\7T\2\2\u008d\u008e\7G\2\2\u008e\u008f\7"+
		"V\2\2\u008f\u0090\7W\2\2\u0090\u0091\7T\2\2\u0091\u0092\7P\2\2\u0092("+
		"\3\2\2\2\u0093\u0094\7E\2\2\u0094\u0095\7T\2\2\u0095\u0096\7G\2\2\u0096"+
		"\u0097\7C\2\2\u0097\u0098\7V\2\2\u0098\u0099\7G\2\2\u0099\u009a\7\"\2"+
		"\2\u009a\u009b\7X\2\2\u009b\u009c\7K\2\2\u009c\u009d\7G\2\2\u009d\u009e"+
		"\7Y\2\2\u009e\u009f\7\"\2\2\u009f\u00a0\7C\2\2\u00a0\u00aa\7U\2\2\u00a1"+
		"\u00a2\7W\2\2\u00a2\u00a3\7U\2\2\u00a3\u00a4\7G\2\2\u00a4\u00a5\7\"\2"+
		"\2\u00a5\u00a6\7X\2\2\u00a6\u00a7\7K\2\2\u00a7\u00a8\7G\2\2\u00a8\u00aa"+
		"\7Y\2\2\u00a9\u0093\3\2\2\2\u00a9\u00a1\3\2\2\2\u00aa*\3\2\2\2\u00ab\u00b1"+
		"\t\2\2\2\u00ac\u00ad\7@\2\2\u00ad\u00b1\7?\2\2\u00ae\u00af\7>\2\2\u00af"+
		"\u00b1\7?\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b1,\3\2\2\2\u00b2\u00b3\7E\2\2\u00b3\u00b4\7C\2\2\u00b4\u00b5"+
		"\7U\2\2\u00b5\u00fc\7G\2\2\u00b6\u00b7\7E\2\2\u00b7\u00b8\7Q\2\2\u00b8"+
		"\u00b9\7P\2\2\u00b9\u00ba\7V\2\2\u00ba\u00bb\7C\2\2\u00bb\u00bc\7K\2\2"+
		"\u00bc\u00bd\7P\2\2\u00bd\u00fc\7U\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0"+
		"\7N\2\2\u00c0\u00c1\7U\2\2\u00c1\u00fc\7G\2\2\u00c2\u00c3\7G\2\2\u00c3"+
		"\u00c4\7P\2\2\u00c4\u00fc\7F\2\2\u00c5\u00c6\7G\2\2\u00c6\u00c7\7P\2\2"+
		"\u00c7\u00c8\7F\2\2\u00c8\u00c9\7U\2\2\u00c9\u00ca\7\"\2\2\u00ca\u00cb"+
		"\7Y\2\2\u00cb\u00cc\7K\2\2\u00cc\u00cd\7V\2\2\u00cd\u00fc\7J\2\2\u00ce"+
		"\u00cf\7K\2\2\u00cf\u00fc\7P\2\2\u00d0\u00d1\7K\2\2\u00d1\u00d2\7U\2\2"+
		"\u00d2\u00d3\7\"\2\2\u00d3\u00d4\7P\2\2\u00d4\u00d5\7Q\2\2\u00d5\u00d6"+
		"\7V\2\2\u00d6\u00d7\7\"\2\2\u00d7\u00d8\7P\2\2\u00d8\u00d9\7W\2\2\u00d9"+
		"\u00da\7N\2\2\u00da\u00fc\7N\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7U\2\2"+
		"\u00dd\u00de\7\"\2\2\u00de\u00df\7P\2\2\u00df\u00e0\7W\2\2\u00e0\u00e1"+
		"\7N\2\2\u00e1\u00fc\7N\2\2\u00e2\u00e3\7P\2\2\u00e3\u00e4\7Q\2\2\u00e4"+
		"\u00fc\7V\2\2\u00e5\u00e6\7U\2\2\u00e6\u00e7\7V\2\2\u00e7\u00e8\7C\2\2"+
		"\u00e8\u00e9\7T\2\2\u00e9\u00ea\7V\2\2\u00ea\u00eb\7U\2\2\u00eb\u00ec"+
		"\7\"\2\2\u00ec\u00ed\7Y\2\2\u00ed\u00ee\7K\2\2\u00ee\u00ef\7V\2\2\u00ef"+
		"\u00fc\7J\2\2\u00f0\u00f1\7V\2\2\u00f1\u00f2\7J\2\2\u00f2\u00f3\7G\2\2"+
		"\u00f3\u00fc\7P\2\2\u00f4\u00f5\7Y\2\2\u00f5\u00f6\7J\2\2\u00f6\u00f7"+
		"\7G\2\2\u00f7\u00fc\7P\2\2\u00f8\u00f9\7Z\2\2\u00f9\u00fa\7Q\2\2\u00fa"+
		"\u00fc\7T\2\2\u00fb\u00b2\3\2\2\2\u00fb\u00b6\3\2\2\2\u00fb\u00be\3\2"+
		"\2\2\u00fb\u00c2\3\2\2\2\u00fb\u00c5\3\2\2\2\u00fb\u00ce\3\2\2\2\u00fb"+
		"\u00d0\3\2\2\2\u00fb\u00db\3\2\2\2\u00fb\u00e2\3\2\2\2\u00fb\u00e5\3\2"+
		"\2\2\u00fb\u00f0\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fb\u00f8\3\2\2\2\u00fc"+
		".\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7w\2\2\u0100"+
		"\u010b\7g\2\2\u0101\u0102\7h\2\2\u0102\u0103\7c\2\2\u0103\u0104\7n\2\2"+
		"\u0104\u0105\7u\2\2\u0105\u010b\7g\2\2\u0106\u0107\7p\2\2\u0107\u0108"+
		"\7w\2\2\u0108\u0109\7n\2\2\u0109\u010b\7n\2\2\u010a\u00fd\3\2\2\2\u010a"+
		"\u0101\3\2\2\2\u010a\u0106\3\2\2\2\u010b\60\3\2\2\2\u010c\u012b\t\3\2"+
		"\2\u010d\u0111\t\4\2\2\u010e\u0110\t\5\2\2\u010f\u010e\3\2\2\2\u0110\u0113"+
		"\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u012b\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0115\t\3\2\2\u0115\u0119\7\60\2\2\u0116\u0118\t"+
		"\5\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u012b\t\4"+
		"\2\2\u011d\u011f\7$\2\2\u011e\u0120\t\6\2\2\u011f\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0126\3\2"+
		"\2\2\u0123\u0125\t\5\2\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0129\u012b\7$\2\2\u012a\u010c\3\2\2\2\u012a\u010d\3\2\2\2\u012a"+
		"\u0114\3\2\2\2\u012a\u011d\3\2\2\2\u012b\62\3\2\2\2\u012c\u012e\t\7\2"+
		"\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u0134\3\2\2\2\u0131\u0133\t\5\2\2\u0132\u0131\3\2\2\2\u0133"+
		"\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\64\3\2\2"+
		"\2\u0136\u0134\3\2\2\2\u0137\u0138\7\"\2\2\u0138\u0139\3\2\2\2\u0139\u013a"+
		"\b\33\2\2\u013a\66\3\2\2\2\u013b\u013c\13\2\2\2\u013c8\3\2\2\2\17\2\u008a"+
		"\u00a9\u00b0\u00fb\u010a\u0111\u0119\u0121\u0126\u012a\u012f\u0134\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}