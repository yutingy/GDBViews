// Generated from C:/Users/yutin/IdeaProjects/GraphDBViews/src\View.g4 by ANTLR 4.8
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, KEYWORD=15, RETURN=16, 
		COMMAND=17, COMPARISON=18, OPERATOR=19, CONSTANTS=20, VALUE=21, NAME=22, 
		WHITESPACE=23, ANY=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "KEYWORD", "RETURN", "COMMAND", 
			"COMPARISON", "OPERATOR", "CONSTANTS", "VALUE", "NAME", "WHITESPACE", 
			"ANY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CG'", "'WITH VIEWS'", "'('", "':'", "')'", "'-['", "']-'", "'NODES('", 
			"'='", "'WHERE'", "'AND'", "'OR'", "'IN'", "'.'", null, "'RETURN'", null, 
			null, null, null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "KEYWORD", "RETURN", "COMMAND", "COMPARISON", "OPERATOR", 
			"CONSTANTS", "VALUE", "NAME", "WHITESPACE", "ANY"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u0125\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20s\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u0092\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u0099\n"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\5\24\u00e4\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00f3\n\25\3\26\3\26\3\26\7\26\u00f8"+
		"\n\26\f\26\16\26\u00fb\13\26\3\26\3\26\3\26\7\26\u0100\n\26\f\26\16\26"+
		"\u0103\13\26\3\26\3\26\3\26\6\26\u0108\n\26\r\26\16\26\u0109\3\26\7\26"+
		"\u010d\n\26\f\26\16\26\u0110\13\26\3\26\5\26\u0113\n\26\3\27\6\27\u0116"+
		"\n\27\r\27\16\27\u0117\3\27\7\27\u011b\n\27\f\27\16\27\u011e\13\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\3\2\b\4\2>>@@\3\2\62\62\3\2\63;\3\2\62;\6\2\"\"C\\aac|\5\2C\\a"+
		"ac|\2\u013f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\66\3\2\2\2\7A\3\2\2\2\tC\3\2\2"+
		"\2\13E\3\2\2\2\rG\3\2\2\2\17J\3\2\2\2\21M\3\2\2\2\23T\3\2\2\2\25V\3\2"+
		"\2\2\27\\\3\2\2\2\31`\3\2\2\2\33c\3\2\2\2\35f\3\2\2\2\37r\3\2\2\2!t\3"+
		"\2\2\2#\u0091\3\2\2\2%\u0098\3\2\2\2\'\u00e3\3\2\2\2)\u00f2\3\2\2\2+\u0112"+
		"\3\2\2\2-\u0115\3\2\2\2/\u011f\3\2\2\2\61\u0123\3\2\2\2\63\64\7E\2\2\64"+
		"\65\7I\2\2\65\4\3\2\2\2\66\67\7Y\2\2\678\7K\2\289\7V\2\29:\7J\2\2:;\7"+
		"\"\2\2;<\7X\2\2<=\7K\2\2=>\7G\2\2>?\7Y\2\2?@\7U\2\2@\6\3\2\2\2AB\7*\2"+
		"\2B\b\3\2\2\2CD\7<\2\2D\n\3\2\2\2EF\7+\2\2F\f\3\2\2\2GH\7/\2\2HI\7]\2"+
		"\2I\16\3\2\2\2JK\7_\2\2KL\7/\2\2L\20\3\2\2\2MN\7P\2\2NO\7Q\2\2OP\7F\2"+
		"\2PQ\7G\2\2QR\7U\2\2RS\7*\2\2S\22\3\2\2\2TU\7?\2\2U\24\3\2\2\2VW\7Y\2"+
		"\2WX\7J\2\2XY\7G\2\2YZ\7T\2\2Z[\7G\2\2[\26\3\2\2\2\\]\7C\2\2]^\7P\2\2"+
		"^_\7F\2\2_\30\3\2\2\2`a\7Q\2\2ab\7T\2\2b\32\3\2\2\2cd\7K\2\2de\7P\2\2"+
		"e\34\3\2\2\2fg\7\60\2\2g\36\3\2\2\2hi\7O\2\2ij\7C\2\2jk\7V\2\2kl\7E\2"+
		"\2ls\7J\2\2mn\7O\2\2no\7G\2\2op\7T\2\2pq\7I\2\2qs\7G\2\2rh\3\2\2\2rm\3"+
		"\2\2\2s \3\2\2\2tu\7T\2\2uv\7G\2\2vw\7V\2\2wx\7W\2\2xy\7T\2\2yz\7P\2\2"+
		"z\"\3\2\2\2{|\7E\2\2|}\7T\2\2}~\7G\2\2~\177\7C\2\2\177\u0080\7V\2\2\u0080"+
		"\u0081\7G\2\2\u0081\u0082\7\"\2\2\u0082\u0083\7X\2\2\u0083\u0084\7K\2"+
		"\2\u0084\u0085\7G\2\2\u0085\u0086\7Y\2\2\u0086\u0087\7\"\2\2\u0087\u0088"+
		"\7C\2\2\u0088\u0092\7U\2\2\u0089\u008a\7W\2\2\u008a\u008b\7U\2\2\u008b"+
		"\u008c\7G\2\2\u008c\u008d\7\"\2\2\u008d\u008e\7X\2\2\u008e\u008f\7K\2"+
		"\2\u008f\u0090\7G\2\2\u0090\u0092\7Y\2\2\u0091{\3\2\2\2\u0091\u0089\3"+
		"\2\2\2\u0092$\3\2\2\2\u0093\u0099\t\2\2\2\u0094\u0095\7@\2\2\u0095\u0099"+
		"\7?\2\2\u0096\u0097\7>\2\2\u0097\u0099\7?\2\2\u0098\u0093\3\2\2\2\u0098"+
		"\u0094\3\2\2\2\u0098\u0096\3\2\2\2\u0099&\3\2\2\2\u009a\u009b\7E\2\2\u009b"+
		"\u009c\7C\2\2\u009c\u009d\7U\2\2\u009d\u00e4\7G\2\2\u009e\u009f\7E\2\2"+
		"\u009f\u00a0\7Q\2\2\u00a0\u00a1\7P\2\2\u00a1\u00a2\7V\2\2\u00a2\u00a3"+
		"\7C\2\2\u00a3\u00a4\7K\2\2\u00a4\u00a5\7P\2\2\u00a5\u00e4\7U\2\2\u00a6"+
		"\u00a7\7G\2\2\u00a7\u00a8\7N\2\2\u00a8\u00a9\7U\2\2\u00a9\u00e4\7G\2\2"+
		"\u00aa\u00ab\7G\2\2\u00ab\u00ac\7P\2\2\u00ac\u00e4\7F\2\2\u00ad\u00ae"+
		"\7G\2\2\u00ae\u00af\7P\2\2\u00af\u00b0\7F\2\2\u00b0\u00b1\7U\2\2\u00b1"+
		"\u00b2\7\"\2\2\u00b2\u00b3\7Y\2\2\u00b3\u00b4\7K\2\2\u00b4\u00b5\7V\2"+
		"\2\u00b5\u00e4\7J\2\2\u00b6\u00b7\7K\2\2\u00b7\u00e4\7P\2\2\u00b8\u00b9"+
		"\7K\2\2\u00b9\u00ba\7U\2\2\u00ba\u00bb\7\"\2\2\u00bb\u00bc\7P\2\2\u00bc"+
		"\u00bd\7Q\2\2\u00bd\u00be\7V\2\2\u00be\u00bf\7\"\2\2\u00bf\u00c0\7P\2"+
		"\2\u00c0\u00c1\7W\2\2\u00c1\u00c2\7N\2\2\u00c2\u00e4\7N\2\2\u00c3\u00c4"+
		"\7K\2\2\u00c4\u00c5\7U\2\2\u00c5\u00c6\7\"\2\2\u00c6\u00c7\7P\2\2\u00c7"+
		"\u00c8\7W\2\2\u00c8\u00c9\7N\2\2\u00c9\u00e4\7N\2\2\u00ca\u00cb\7P\2\2"+
		"\u00cb\u00cc\7Q\2\2\u00cc\u00e4\7V\2\2\u00cd\u00ce\7U\2\2\u00ce\u00cf"+
		"\7V\2\2\u00cf\u00d0\7C\2\2\u00d0\u00d1\7T\2\2\u00d1\u00d2\7V\2\2\u00d2"+
		"\u00d3\7U\2\2\u00d3\u00d4\7\"\2\2\u00d4\u00d5\7Y\2\2\u00d5\u00d6\7K\2"+
		"\2\u00d6\u00d7\7V\2\2\u00d7\u00e4\7J\2\2\u00d8\u00d9\7V\2\2\u00d9\u00da"+
		"\7J\2\2\u00da\u00db\7G\2\2\u00db\u00e4\7P\2\2\u00dc\u00dd\7Y\2\2\u00dd"+
		"\u00de\7J\2\2\u00de\u00df\7G\2\2\u00df\u00e4\7P\2\2\u00e0\u00e1\7Z\2\2"+
		"\u00e1\u00e2\7Q\2\2\u00e2\u00e4\7T\2\2\u00e3\u009a\3\2\2\2\u00e3\u009e"+
		"\3\2\2\2\u00e3\u00a6\3\2\2\2\u00e3\u00aa\3\2\2\2\u00e3\u00ad\3\2\2\2\u00e3"+
		"\u00b6\3\2\2\2\u00e3\u00b8\3\2\2\2\u00e3\u00c3\3\2\2\2\u00e3\u00ca\3\2"+
		"\2\2\u00e3\u00cd\3\2\2\2\u00e3\u00d8\3\2\2\2\u00e3\u00dc\3\2\2\2\u00e3"+
		"\u00e0\3\2\2\2\u00e4(\3\2\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7t\2\2\u00e7"+
		"\u00e8\7w\2\2\u00e8\u00f3\7g\2\2\u00e9\u00ea\7h\2\2\u00ea\u00eb\7c\2\2"+
		"\u00eb\u00ec\7n\2\2\u00ec\u00ed\7u\2\2\u00ed\u00f3\7g\2\2\u00ee\u00ef"+
		"\7p\2\2\u00ef\u00f0\7w\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f3\7n\2\2\u00f2"+
		"\u00e5\3\2\2\2\u00f2\u00e9\3\2\2\2\u00f2\u00ee\3\2\2\2\u00f3*\3\2\2\2"+
		"\u00f4\u0113\t\3\2\2\u00f5\u00f9\t\4\2\2\u00f6\u00f8\t\5\2\2\u00f7\u00f6"+
		"\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u0113\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\t\3\2\2\u00fd\u0101\7\60"+
		"\2\2\u00fe\u0100\t\5\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0104\u0113\t\4\2\2\u0105\u0107\7$\2\2\u0106\u0108\t\6\2\2\u0107"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010e\3\2\2\2\u010b\u010d\t\5\2\2\u010c\u010b\3\2\2\2\u010d"+
		"\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2"+
		"\2\2\u0110\u010e\3\2\2\2\u0111\u0113\7$\2\2\u0112\u00f4\3\2\2\2\u0112"+
		"\u00f5\3\2\2\2\u0112\u00fc\3\2\2\2\u0112\u0105\3\2\2\2\u0113,\3\2\2\2"+
		"\u0114\u0116\t\7\2\2\u0115\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011c\3\2\2\2\u0119\u011b\t\5\2\2\u011a"+
		"\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2"+
		"\2\2\u011d.\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\7\"\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u0122\b\30\2\2\u0122\60\3\2\2\2\u0123\u0124\13\2\2\2\u0124"+
		"\62\3\2\2\2\17\2r\u0091\u0098\u00e3\u00f2\u00f9\u0101\u0109\u010e\u0112"+
		"\u0117\u011c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}