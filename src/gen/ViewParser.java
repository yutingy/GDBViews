// Generated from C:/Users/Ting/Documents/GDBViews/src\View.g4 by ANTLR 4.8
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ViewParser extends Parser {
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
	public static final int
		RULE_root = 0, RULE_query = 1, RULE_changegraph = 2, RULE_viewuse = 3, 
		RULE_usedviews = 4, RULE_viewatom = 5, RULE_returnstmt = 6, RULE_retval = 7, 
		RULE_expr = 8, RULE_variable = 9, RULE_type = 10, RULE_nodeName = 11, 
		RULE_relation = 12, RULE_relationValue = 13, RULE_path = 14, RULE_conditions = 15, 
		RULE_boolexpr = 16, RULE_attribute = 17, RULE_val = 18, RULE_test = 19, 
		RULE_setattr = 20, RULE_insertion = 21, RULE_insertrelation = 22, RULE_insertionVar = 23, 
		RULE_insertAttributes = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "query", "changegraph", "viewuse", "usedviews", "viewatom", "returnstmt", 
			"retval", "expr", "variable", "type", "nodeName", "relation", "relationValue", 
			"path", "conditions", "boolexpr", "attribute", "val", "test", "setattr", 
			"insertion", "insertrelation", "insertionVar", "insertAttributes"
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

	@Override
	public String getGrammarFileName() { return "View.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ViewParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode COMMAND() { return getToken(ViewParser.COMMAND, 0); }
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public ViewuseContext viewuse() {
			return getRuleContext(ViewuseContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ChangegraphContext changegraph() {
			return getRuleContext(ChangegraphContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(COMMAND);
				setState(51);
				match(NAME);
				setState(52);
				viewuse();
				setState(53);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(T__0);
				setState(56);
				query();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				changegraph();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				viewuse();
				setState(59);
				query();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public TerminalNode KEYWORD() { return getToken(ViewParser.KEYWORD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public ReturnstmtContext returnstmt() {
			return getRuleContext(ReturnstmtContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(KEYWORD);
				setState(64);
				expr();
				setState(65);
				conditions();
				setState(66);
				returnstmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(KEYWORD);
				setState(69);
				path();
				setState(70);
				conditions();
				setState(71);
				returnstmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChangegraphContext extends ParserRuleContext {
		public TerminalNode KEYWORD() { return getToken(ViewParser.KEYWORD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public SetattrContext setattr() {
			return getRuleContext(SetattrContext.class,0);
		}
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public InsertionContext insertion() {
			return getRuleContext(InsertionContext.class,0);
		}
		public ChangegraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changegraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterChangegraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitChangegraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitChangegraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangegraphContext changegraph() throws RecognitionException {
		ChangegraphContext _localctx = new ChangegraphContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_changegraph);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(KEYWORD);
				setState(76);
				expr();
				setState(77);
				conditions();
				setState(78);
				match(T__1);
				setState(79);
				setattr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(KEYWORD);
				setState(82);
				expr();
				setState(83);
				conditions();
				setState(84);
				match(T__2);
				setState(85);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(KEYWORD);
				setState(88);
				expr();
				setState(89);
				conditions();
				setState(90);
				match(T__3);
				setState(91);
				attribute();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				match(KEYWORD);
				setState(94);
				expr();
				setState(95);
				conditions();
				setState(96);
				match(T__4);
				setState(97);
				insertion(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				match(T__4);
				setState(100);
				insertion(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewuseContext extends ParserRuleContext {
		public UsedviewsContext usedviews() {
			return getRuleContext(UsedviewsContext.class,0);
		}
		public ViewuseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewuse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterViewuse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitViewuse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitViewuse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewuseContext viewuse() throws RecognitionException {
		ViewuseContext _localctx = new ViewuseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_viewuse);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(T__5);
				setState(104);
				usedviews();
				}
				break;
			case KEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsedviewsContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(ViewParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ViewParser.NAME, i);
		}
		public UsedviewsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usedviews; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterUsedviews(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitUsedviews(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitUsedviews(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsedviewsContext usedviews() throws RecognitionException {
		UsedviewsContext _localctx = new UsedviewsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_usedviews);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(108);
				match(NAME);
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewatomContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public List<ViewatomContext> viewatom() {
			return getRuleContexts(ViewatomContext.class);
		}
		public ViewatomContext viewatom(int i) {
			return getRuleContext(ViewatomContext.class,i);
		}
		public ViewatomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewatom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterViewatom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitViewatom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitViewatom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewatomContext viewatom() throws RecognitionException {
		return viewatom(0);
	}

	private ViewatomContext viewatom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ViewatomContext _localctx = new ViewatomContext(_ctx, _parentState);
		ViewatomContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_viewatom, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(115);
				variable();
				}
				break;
			case 2:
				{
				setState(116);
				variable();
				setState(117);
				match(T__6);
				setState(118);
				relation();
				setState(119);
				match(T__7);
				setState(120);
				viewatom(2);
				}
				break;
			case 3:
				{
				setState(122);
				variable();
				setState(123);
				match(T__6);
				setState(124);
				relation();
				setState(125);
				match(T__7);
				setState(126);
				variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(142);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ViewatomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_viewatom);
						setState(130);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(131);
						match(T__6);
						setState(132);
						relation();
						setState(133);
						match(T__7);
						setState(134);
						viewatom(5);
						}
						break;
					case 2:
						{
						_localctx = new ViewatomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_viewatom);
						setState(136);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(137);
						match(T__6);
						setState(138);
						relation();
						setState(139);
						match(T__7);
						setState(140);
						variable();
						}
						break;
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ReturnstmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ViewParser.RETURN, 0); }
		public RetvalContext retval() {
			return getRuleContext(RetvalContext.class,0);
		}
		public ReturnstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterReturnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitReturnstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitReturnstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnstmtContext returnstmt() throws RecognitionException {
		ReturnstmtContext _localctx = new ReturnstmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(RETURN);
			setState(148);
			retval();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetvalContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public RetvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterRetval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitRetval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitRetval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetvalContext retval() throws RecognitionException {
		RetvalContext _localctx = new RetvalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_retval);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(T__8);
				setState(151);
				match(NAME);
				setState(152);
				match(T__9);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				attribute();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ViewatomContext viewatom() {
			return getRuleContext(ViewatomContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			viewatom(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public NodeNameContext nodeName() {
			return getRuleContext(NodeNameContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(T__10);
				setState(159);
				nodeName();
				setState(160);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(T__10);
				setState(163);
				nodeName();
				setState(164);
				match(T__11);
				setState(165);
				type();
				setState(166);
				match(T__9);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public NodeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterNodeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitNodeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitNodeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeNameContext nodeName() throws RecognitionException {
		NodeNameContext _localctx = new NodeNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nodeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationValueContext relationValue() {
			return getRuleContext(RelationValueContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(174);
				relationValue();
				}
			}

			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(177);
				match(T__11);
				setState(178);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationValueContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public RelationValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterRelationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitRelationValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitRelationValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationValueContext relationValue() throws RecognitionException {
		RelationValueContext _localctx = new RelationValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_relationValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(NAME);
			setState(184);
			match(T__12);
			setState(185);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionsContext extends ParserRuleContext {
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public ConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitConditions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitConditions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionsContext conditions() throws RecognitionException {
		ConditionsContext _localctx = new ConditionsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditions);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(T__13);
				setState(188);
				boolexpr(0);
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolexprContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode COMPARISON() { return getToken(ViewParser.COMPARISON, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TerminalNode VALUE() { return getToken(ViewParser.VALUE, 0); }
		public TerminalNode OPERATOR() { return getToken(ViewParser.OPERATOR, 0); }
		public List<TerminalNode> NAME() { return getTokens(ViewParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ViewParser.NAME, i);
		}
		public List<BoolexprContext> boolexpr() {
			return getRuleContexts(BoolexprContext.class);
		}
		public BoolexprContext boolexpr(int i) {
			return getRuleContext(BoolexprContext.class,i);
		}
		public BoolexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterBoolexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitBoolexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitBoolexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolexprContext boolexpr() throws RecognitionException {
		return boolexpr(0);
	}

	private BoolexprContext boolexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolexprContext _localctx = new BoolexprContext(_ctx, _parentState);
		BoolexprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_boolexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(193);
				attribute();
				setState(194);
				match(COMPARISON);
				setState(195);
				attribute();
				}
				break;
			case 2:
				{
				setState(197);
				attribute();
				setState(198);
				match(COMPARISON);
				setState(199);
				val();
				}
				break;
			case 3:
				{
				setState(201);
				attribute();
				setState(202);
				match(T__12);
				setState(203);
				attribute();
				}
				break;
			case 4:
				{
				setState(205);
				attribute();
				setState(206);
				match(T__12);
				setState(207);
				val();
				}
				break;
			case 5:
				{
				setState(209);
				match(VALUE);
				setState(210);
				match(OPERATOR);
				setState(211);
				attribute();
				}
				break;
			case 6:
				{
				setState(212);
				match(NAME);
				setState(213);
				match(T__16);
				setState(214);
				match(NAME);
				}
				break;
			case 7:
				{
				setState(215);
				match(T__10);
				setState(216);
				boolexpr(0);
				setState(217);
				match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(227);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(221);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(222);
						match(T__14);
						setState(223);
						boolexpr(6);
						}
						break;
					case 2:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(224);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(225);
						match(T__15);
						setState(226);
						boolexpr(5);
						}
						break;
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(ViewParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ViewParser.NAME, i);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(NAME);
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(233);
				match(T__17);
				setState(234);
				match(NAME);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(ViewParser.VALUE, 0); }
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public TerminalNode CONSTANTS() { return getToken(ViewParser.CONSTANTS, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTS) | (1L << VALUE) | (1L << NAME))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode COMPARISON() { return getToken(ViewParser.COMPARISON, 0); }
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			attribute();
			setState(240);
			match(COMPARISON);
			setState(241);
			attribute();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetattrContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public SetattrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setattr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterSetattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitSetattr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitSetattr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetattrContext setattr() throws RecognitionException {
		SetattrContext _localctx = new SetattrContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_setattr);
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				attribute();
				setState(244);
				match(T__12);
				setState(245);
				attribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				attribute();
				setState(248);
				match(T__12);
				setState(249);
				val();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertionContext extends ParserRuleContext {
		public InsertionVarContext insertionVar() {
			return getRuleContext(InsertionVarContext.class,0);
		}
		public List<InsertionContext> insertion() {
			return getRuleContexts(InsertionContext.class);
		}
		public InsertionContext insertion(int i) {
			return getRuleContext(InsertionContext.class,i);
		}
		public InsertrelationContext insertrelation() {
			return getRuleContext(InsertrelationContext.class,0);
		}
		public InsertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterInsertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitInsertion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitInsertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertionContext insertion() throws RecognitionException {
		return insertion(0);
	}

	private InsertionContext insertion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InsertionContext _localctx = new InsertionContext(_ctx, _parentState);
		InsertionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_insertion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(254);
			insertionVar();
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InsertionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_insertion);
					setState(256);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(257);
					match(T__6);
					setState(258);
					insertrelation();
					setState(259);
					match(T__7);
					setState(260);
					insertion(2);
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InsertrelationContext extends ParserRuleContext {
		public RelationValueContext relationValue() {
			return getRuleContext(RelationValueContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InsertrelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertrelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterInsertrelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitInsertrelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitInsertrelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertrelationContext insertrelation() throws RecognitionException {
		InsertrelationContext _localctx = new InsertrelationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_insertrelation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(267);
				relationValue();
				}
			}

			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(270);
				match(T__11);
				setState(271);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertionVarContext extends ParserRuleContext {
		public NodeNameContext nodeName() {
			return getRuleContext(NodeNameContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InsertAttributesContext insertAttributes() {
			return getRuleContext(InsertAttributesContext.class,0);
		}
		public InsertionVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertionVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterInsertionVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitInsertionVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitInsertionVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertionVarContext insertionVar() throws RecognitionException {
		InsertionVarContext _localctx = new InsertionVarContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_insertionVar);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(T__10);
				setState(275);
				nodeName();
				setState(276);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(T__10);
				setState(279);
				nodeName();
				setState(280);
				match(T__11);
				setState(281);
				type();
				setState(282);
				match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(T__10);
				setState(285);
				nodeName();
				setState(286);
				match(T__11);
				setState(287);
				type();
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(288);
					match(T__18);
					setState(289);
					insertAttributes();
					setState(290);
					match(T__19);
					}
				}

				setState(294);
				match(T__9);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertAttributesContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public List<InsertAttributesContext> insertAttributes() {
			return getRuleContexts(InsertAttributesContext.class);
		}
		public InsertAttributesContext insertAttributes(int i) {
			return getRuleContext(InsertAttributesContext.class,i);
		}
		public InsertAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertAttributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterInsertAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitInsertAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitInsertAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertAttributesContext insertAttributes() throws RecognitionException {
		InsertAttributesContext _localctx = new InsertAttributesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_insertAttributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(NAME);
			setState(299);
			match(T__11);
			setState(300);
			val();
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(301);
					match(T__20);
					setState(302);
					insertAttributes();
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return viewatom_sempred((ViewatomContext)_localctx, predIndex);
		case 16:
			return boolexpr_sempred((BoolexprContext)_localctx, predIndex);
		case 21:
			return insertion_sempred((InsertionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean viewatom_sempred(ViewatomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean boolexpr_sempred(BoolexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean insertion_sempred(InsertionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2@\n\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3L\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4h\n\4\3\5\3\5\3\5\5\5m\n\5\3\6\7\6p\n\6\f\6\16\6s\13\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0083\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0091\n\7\f\7\16\7\u0094"+
		"\13\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\u009d\n\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ab\n\13\3\f\3\f\3\r\3\r\3"+
		"\16\5\16\u00b2\n\16\3\16\3\16\5\16\u00b6\n\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\5\21\u00c1\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00de\n\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\7\22\u00e6\n\22\f\22\16\22\u00e9\13\22\3\23\3\23\3\23\5\23\u00ee"+
		"\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u00fe\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27"+
		"\u0109\n\27\f\27\16\27\u010c\13\27\3\30\5\30\u010f\n\30\3\30\3\30\5\30"+
		"\u0113\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0127\n\31\3\31\3\31\5\31\u012b\n"+
		"\31\3\32\3\32\3\32\3\32\3\32\7\32\u0132\n\32\f\32\16\32\u0135\13\32\3"+
		"\32\2\5\f\",\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\2\3\3\2\35\37\2\u0141\2?\3\2\2\2\4K\3\2\2\2\6g\3\2\2\2\bl\3\2\2\2\nq"+
		"\3\2\2\2\f\u0082\3\2\2\2\16\u0095\3\2\2\2\20\u009c\3\2\2\2\22\u009e\3"+
		"\2\2\2\24\u00aa\3\2\2\2\26\u00ac\3\2\2\2\30\u00ae\3\2\2\2\32\u00b1\3\2"+
		"\2\2\34\u00b7\3\2\2\2\36\u00b9\3\2\2\2 \u00c0\3\2\2\2\"\u00dd\3\2\2\2"+
		"$\u00ea\3\2\2\2&\u00ef\3\2\2\2(\u00f1\3\2\2\2*\u00fd\3\2\2\2,\u00ff\3"+
		"\2\2\2.\u010e\3\2\2\2\60\u012a\3\2\2\2\62\u012c\3\2\2\2\64\65\7\32\2\2"+
		"\65\66\7\37\2\2\66\67\5\b\5\2\678\5\4\3\28@\3\2\2\29:\7\3\2\2:@\5\4\3"+
		"\2;@\5\6\4\2<=\5\b\5\2=>\5\4\3\2>@\3\2\2\2?\64\3\2\2\2?9\3\2\2\2?;\3\2"+
		"\2\2?<\3\2\2\2@\3\3\2\2\2AB\7\30\2\2BC\5\22\n\2CD\5 \21\2DE\5\16\b\2E"+
		"L\3\2\2\2FG\7\30\2\2GH\5\36\20\2HI\5 \21\2IJ\5\16\b\2JL\3\2\2\2KA\3\2"+
		"\2\2KF\3\2\2\2L\5\3\2\2\2MN\7\30\2\2NO\5\22\n\2OP\5 \21\2PQ\7\4\2\2QR"+
		"\5*\26\2Rh\3\2\2\2ST\7\30\2\2TU\5\22\n\2UV\5 \21\2VW\7\5\2\2WX\7\37\2"+
		"\2Xh\3\2\2\2YZ\7\30\2\2Z[\5\22\n\2[\\\5 \21\2\\]\7\6\2\2]^\5$\23\2^h\3"+
		"\2\2\2_`\7\30\2\2`a\5\22\n\2ab\5 \21\2bc\7\7\2\2cd\5,\27\2dh\3\2\2\2e"+
		"f\7\7\2\2fh\5,\27\2gM\3\2\2\2gS\3\2\2\2gY\3\2\2\2g_\3\2\2\2ge\3\2\2\2"+
		"h\7\3\2\2\2ij\7\b\2\2jm\5\n\6\2km\3\2\2\2li\3\2\2\2lk\3\2\2\2m\t\3\2\2"+
		"\2np\7\37\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\13\3\2\2\2sq\3"+
		"\2\2\2tu\b\7\1\2u\u0083\5\24\13\2vw\5\24\13\2wx\7\t\2\2xy\5\32\16\2yz"+
		"\7\n\2\2z{\5\f\7\4{\u0083\3\2\2\2|}\5\24\13\2}~\7\t\2\2~\177\5\32\16\2"+
		"\177\u0080\7\n\2\2\u0080\u0081\5\24\13\2\u0081\u0083\3\2\2\2\u0082t\3"+
		"\2\2\2\u0082v\3\2\2\2\u0082|\3\2\2\2\u0083\u0092\3\2\2\2\u0084\u0085\f"+
		"\6\2\2\u0085\u0086\7\t\2\2\u0086\u0087\5\32\16\2\u0087\u0088\7\n\2\2\u0088"+
		"\u0089\5\f\7\7\u0089\u0091\3\2\2\2\u008a\u008b\f\5\2\2\u008b\u008c\7\t"+
		"\2\2\u008c\u008d\5\32\16\2\u008d\u008e\7\n\2\2\u008e\u008f\5\24\13\2\u008f"+
		"\u0091\3\2\2\2\u0090\u0084\3\2\2\2\u0090\u008a\3\2\2\2\u0091\u0094\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\r\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0095\u0096\7\31\2\2\u0096\u0097\5\20\t\2\u0097\17\3\2\2\2\u0098"+
		"\u0099\7\13\2\2\u0099\u009a\7\37\2\2\u009a\u009d\7\f\2\2\u009b\u009d\5"+
		"$\23\2\u009c\u0098\3\2\2\2\u009c\u009b\3\2\2\2\u009d\21\3\2\2\2\u009e"+
		"\u009f\5\f\7\2\u009f\23\3\2\2\2\u00a0\u00a1\7\r\2\2\u00a1\u00a2\5\30\r"+
		"\2\u00a2\u00a3\7\f\2\2\u00a3\u00ab\3\2\2\2\u00a4\u00a5\7\r\2\2\u00a5\u00a6"+
		"\5\30\r\2\u00a6\u00a7\7\16\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\7\f\2"+
		"\2\u00a9\u00ab\3\2\2\2\u00aa\u00a0\3\2\2\2\u00aa\u00a4\3\2\2\2\u00ab\25"+
		"\3\2\2\2\u00ac\u00ad\7\37\2\2\u00ad\27\3\2\2\2\u00ae\u00af\7\37\2\2\u00af"+
		"\31\3\2\2\2\u00b0\u00b2\5\34\17\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b4\7\16\2\2\u00b4\u00b6\5\26\f\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\33\3\2\2\2\u00b7\u00b8\7\37\2"+
		"\2\u00b8\35\3\2\2\2\u00b9\u00ba\7\37\2\2\u00ba\u00bb\7\17\2\2\u00bb\u00bc"+
		"\5\22\n\2\u00bc\37\3\2\2\2\u00bd\u00be\7\20\2\2\u00be\u00c1\5\"\22\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1!\3\2\2\2"+
		"\u00c2\u00c3\b\22\1\2\u00c3\u00c4\5$\23\2\u00c4\u00c5\7\33\2\2\u00c5\u00c6"+
		"\5$\23\2\u00c6\u00de\3\2\2\2\u00c7\u00c8\5$\23\2\u00c8\u00c9\7\33\2\2"+
		"\u00c9\u00ca\5&\24\2\u00ca\u00de\3\2\2\2\u00cb\u00cc\5$\23\2\u00cc\u00cd"+
		"\7\17\2\2\u00cd\u00ce\5$\23\2\u00ce\u00de\3\2\2\2\u00cf\u00d0\5$\23\2"+
		"\u00d0\u00d1\7\17\2\2\u00d1\u00d2\5&\24\2\u00d2\u00de\3\2\2\2\u00d3\u00d4"+
		"\7\36\2\2\u00d4\u00d5\7\34\2\2\u00d5\u00de\5$\23\2\u00d6\u00d7\7\37\2"+
		"\2\u00d7\u00d8\7\23\2\2\u00d8\u00de\7\37\2\2\u00d9\u00da\7\r\2\2\u00da"+
		"\u00db\5\"\22\2\u00db\u00dc\7\f\2\2\u00dc\u00de\3\2\2\2\u00dd\u00c2\3"+
		"\2\2\2\u00dd\u00c7\3\2\2\2\u00dd\u00cb\3\2\2\2\u00dd\u00cf\3\2\2\2\u00dd"+
		"\u00d3\3\2\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\u00e7\3\2"+
		"\2\2\u00df\u00e0\f\7\2\2\u00e0\u00e1\7\21\2\2\u00e1\u00e6\5\"\22\b\u00e2"+
		"\u00e3\f\6\2\2\u00e3\u00e4\7\22\2\2\u00e4\u00e6\5\"\22\7\u00e5\u00df\3"+
		"\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8#\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\7\37\2\2"+
		"\u00eb\u00ec\7\24\2\2\u00ec\u00ee\7\37\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee%\3\2\2\2\u00ef\u00f0\t\2\2\2\u00f0\'\3\2\2\2\u00f1\u00f2"+
		"\5$\23\2\u00f2\u00f3\7\33\2\2\u00f3\u00f4\5$\23\2\u00f4)\3\2\2\2\u00f5"+
		"\u00f6\5$\23\2\u00f6\u00f7\7\17\2\2\u00f7\u00f8\5$\23\2\u00f8\u00fe\3"+
		"\2\2\2\u00f9\u00fa\5$\23\2\u00fa\u00fb\7\17\2\2\u00fb\u00fc\5&\24\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00f5\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe+\3\2\2\2"+
		"\u00ff\u0100\b\27\1\2\u0100\u0101\5\60\31\2\u0101\u010a\3\2\2\2\u0102"+
		"\u0103\f\3\2\2\u0103\u0104\7\t\2\2\u0104\u0105\5.\30\2\u0105\u0106\7\n"+
		"\2\2\u0106\u0107\5,\27\4\u0107\u0109\3\2\2\2\u0108\u0102\3\2\2\2\u0109"+
		"\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b-\3\2\2\2"+
		"\u010c\u010a\3\2\2\2\u010d\u010f\5\34\17\2\u010e\u010d\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u0111\7\16\2\2\u0111\u0113\5\26\f\2"+
		"\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113/\3\2\2\2\u0114\u0115\7"+
		"\r\2\2\u0115\u0116\5\30\r\2\u0116\u0117\7\f\2\2\u0117\u012b\3\2\2\2\u0118"+
		"\u0119\7\r\2\2\u0119\u011a\5\30\r\2\u011a\u011b\7\16\2\2\u011b\u011c\5"+
		"\26\f\2\u011c\u011d\7\f\2\2\u011d\u012b\3\2\2\2\u011e\u011f\7\r\2\2\u011f"+
		"\u0120\5\30\r\2\u0120\u0121\7\16\2\2\u0121\u0126\5\26\f\2\u0122\u0123"+
		"\7\25\2\2\u0123\u0124\5\62\32\2\u0124\u0125\7\26\2\2\u0125\u0127\3\2\2"+
		"\2\u0126\u0122\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129"+
		"\7\f\2\2\u0129\u012b\3\2\2\2\u012a\u0114\3\2\2\2\u012a\u0118\3\2\2\2\u012a"+
		"\u011e\3\2\2\2\u012b\61\3\2\2\2\u012c\u012d\7\37\2\2\u012d\u012e\7\16"+
		"\2\2\u012e\u0133\5&\24\2\u012f\u0130\7\27\2\2\u0130\u0132\5\62\32\2\u0131"+
		"\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\63\3\2\2\2\u0135\u0133\3\2\2\2\32?Kglq\u0082\u0090\u0092\u009c"+
		"\u00aa\u00b1\u00b5\u00c0\u00dd\u00e5\u00e7\u00ed\u00fd\u010a\u010e\u0112"+
		"\u0126\u012a\u0133";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}