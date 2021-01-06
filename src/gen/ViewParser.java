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
		T__17=18, KEYWORD=19, RETURN=20, COMMAND=21, COMPARISON=22, OPERATOR=23, 
		CONSTANTS=24, VALUE=25, NAME=26, WHITESPACE=27, ANY=28;
	public static final int
		RULE_root = 0, RULE_query = 1, RULE_changegraph = 2, RULE_viewuse = 3, 
		RULE_usedviews = 4, RULE_viewatom = 5, RULE_returnstmt = 6, RULE_retval = 7, 
		RULE_expr = 8, RULE_variable = 9, RULE_type = 10, RULE_nodeName = 11, 
		RULE_relation = 12, RULE_relationValue = 13, RULE_path = 14, RULE_conditions = 15, 
		RULE_boolexpr = 16, RULE_attribute = 17, RULE_val = 18, RULE_test = 19, 
		RULE_setattr = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "query", "changegraph", "viewuse", "usedviews", "viewatom", "returnstmt", 
			"retval", "expr", "variable", "type", "nodeName", "relation", "relationValue", 
			"path", "conditions", "boolexpr", "attribute", "val", "test", "setattr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CG'", "'SET'", "'DELETE'", "'REMOVE'", "'CREATE'", "'WITH VIEWS'", 
			"'-['", "']-'", "'NODES('", "')'", "'('", "':'", "'='", "'WHERE'", "'AND'", 
			"'OR'", "'IN'", "'.'", null, "'RETURN'", "'CREATE VIEW AS'", null, null, 
			null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "KEYWORD", "RETURN", "COMMAND", 
			"COMPARISON", "OPERATOR", "CONSTANTS", "VALUE", "NAME", "WHITESPACE", 
			"ANY"
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
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(COMMAND);
				setState(43);
				match(NAME);
				setState(44);
				viewuse();
				setState(45);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(T__0);
				setState(48);
				query();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				changegraph();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				viewuse();
				setState(51);
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
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(KEYWORD);
				setState(56);
				expr();
				setState(57);
				conditions();
				setState(58);
				returnstmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(KEYWORD);
				setState(61);
				path();
				setState(62);
				conditions();
				setState(63);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public ViewatomContext viewatom() {
			return getRuleContext(ViewatomContext.class,0);
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
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(KEYWORD);
				setState(68);
				expr();
				setState(69);
				conditions();
				setState(70);
				match(T__1);
				setState(71);
				setattr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(KEYWORD);
				setState(74);
				expr();
				setState(75);
				conditions();
				setState(76);
				match(T__2);
				setState(77);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(KEYWORD);
				setState(80);
				expr();
				setState(81);
				conditions();
				setState(82);
				match(T__3);
				setState(83);
				attribute();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				match(KEYWORD);
				setState(86);
				expr();
				setState(87);
				conditions();
				setState(88);
				match(T__4);
				setState(89);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				match(T__4);
				setState(92);
				viewatom(0);
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
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(T__5);
				setState(96);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(100);
				match(NAME);
				}
				}
				setState(105);
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(107);
				variable();
				}
				break;
			case 2:
				{
				setState(108);
				variable();
				setState(109);
				match(T__6);
				setState(110);
				relation();
				setState(111);
				match(T__7);
				setState(112);
				viewatom(2);
				}
				break;
			case 3:
				{
				setState(114);
				variable();
				setState(115);
				match(T__6);
				setState(116);
				relation();
				setState(117);
				match(T__7);
				setState(118);
				variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ViewatomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_viewatom);
						setState(122);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(123);
						match(T__6);
						setState(124);
						relation();
						setState(125);
						match(T__7);
						setState(126);
						viewatom(5);
						}
						break;
					case 2:
						{
						_localctx = new ViewatomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_viewatom);
						setState(128);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(129);
						match(T__6);
						setState(130);
						relation();
						setState(131);
						match(T__7);
						setState(132);
						variable();
						}
						break;
					}
					} 
				}
				setState(138);
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
			setState(139);
			match(RETURN);
			setState(140);
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
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(T__8);
				setState(143);
				match(NAME);
				setState(144);
				match(T__9);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				viewatom(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				variable();
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
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(T__10);
				setState(153);
				nodeName();
				setState(154);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(T__10);
				setState(157);
				nodeName();
				setState(158);
				match(T__11);
				setState(159);
				type();
				setState(160);
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
			setState(164);
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
			setState(166);
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
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(168);
				relationValue();
				}
			}

			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(171);
				match(T__11);
				setState(172);
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
			setState(175);
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
			setState(177);
			match(NAME);
			setState(178);
			match(T__12);
			setState(179);
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
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__13);
				setState(182);
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
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(187);
				attribute();
				setState(188);
				match(COMPARISON);
				setState(189);
				attribute();
				}
				break;
			case 2:
				{
				setState(191);
				attribute();
				setState(192);
				match(COMPARISON);
				setState(193);
				val();
				}
				break;
			case 3:
				{
				setState(195);
				attribute();
				setState(196);
				match(T__12);
				setState(197);
				attribute();
				}
				break;
			case 4:
				{
				setState(199);
				attribute();
				setState(200);
				match(T__12);
				setState(201);
				val();
				}
				break;
			case 5:
				{
				setState(203);
				match(VALUE);
				setState(204);
				match(OPERATOR);
				setState(205);
				attribute();
				}
				break;
			case 6:
				{
				setState(206);
				match(NAME);
				setState(207);
				match(T__16);
				setState(208);
				match(NAME);
				}
				break;
			case 7:
				{
				setState(209);
				match(T__10);
				setState(210);
				boolexpr(0);
				setState(211);
				match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(215);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(216);
						match(T__14);
						setState(217);
						boolexpr(6);
						}
						break;
					case 2:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(218);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(219);
						match(T__15);
						setState(220);
						boolexpr(5);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
			setState(226);
			match(NAME);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(227);
				match(T__17);
				setState(228);
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
			setState(231);
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
			setState(233);
			attribute();
			setState(234);
			match(COMPARISON);
			setState(235);
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
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				attribute();
				setState(238);
				match(T__12);
				setState(239);
				attribute();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				attribute();
				setState(242);
				match(T__12);
				setState(243);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return viewatom_sempred((ViewatomContext)_localctx, predIndex);
		case 16:
			return boolexpr_sempred((BoolexprContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00fa\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\28\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3D\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4`\n\4\3\5\3\5\3\5\5\5e\n\5\3\6"+
		"\7\6h\n\6\f\6\16\6k\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7{\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7"+
		"\7\u0089\n\7\f\7\16\7\u008c\13\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\u0095"+
		"\n\t\3\n\3\n\5\n\u0099\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00a5\n\13\3\f\3\f\3\r\3\r\3\16\5\16\u00ac\n\16\3\16\3\16\5"+
		"\16\u00b0\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u00bb"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u00d8\n\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00e0\n\22\f\22\16"+
		"\22\u00e3\13\22\3\23\3\23\3\23\5\23\u00e8\n\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00f8\n\26\3\26\2\4"+
		"\f\"\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\3\3\2\32\34\2"+
		"\u0102\2\67\3\2\2\2\4C\3\2\2\2\6_\3\2\2\2\bd\3\2\2\2\ni\3\2\2\2\fz\3\2"+
		"\2\2\16\u008d\3\2\2\2\20\u0094\3\2\2\2\22\u0098\3\2\2\2\24\u00a4\3\2\2"+
		"\2\26\u00a6\3\2\2\2\30\u00a8\3\2\2\2\32\u00ab\3\2\2\2\34\u00b1\3\2\2\2"+
		"\36\u00b3\3\2\2\2 \u00ba\3\2\2\2\"\u00d7\3\2\2\2$\u00e4\3\2\2\2&\u00e9"+
		"\3\2\2\2(\u00eb\3\2\2\2*\u00f7\3\2\2\2,-\7\27\2\2-.\7\34\2\2./\5\b\5\2"+
		"/\60\5\4\3\2\608\3\2\2\2\61\62\7\3\2\2\628\5\4\3\2\638\5\6\4\2\64\65\5"+
		"\b\5\2\65\66\5\4\3\2\668\3\2\2\2\67,\3\2\2\2\67\61\3\2\2\2\67\63\3\2\2"+
		"\2\67\64\3\2\2\28\3\3\2\2\29:\7\25\2\2:;\5\22\n\2;<\5 \21\2<=\5\16\b\2"+
		"=D\3\2\2\2>?\7\25\2\2?@\5\36\20\2@A\5 \21\2AB\5\16\b\2BD\3\2\2\2C9\3\2"+
		"\2\2C>\3\2\2\2D\5\3\2\2\2EF\7\25\2\2FG\5\22\n\2GH\5 \21\2HI\7\4\2\2IJ"+
		"\5*\26\2J`\3\2\2\2KL\7\25\2\2LM\5\22\n\2MN\5 \21\2NO\7\5\2\2OP\7\34\2"+
		"\2P`\3\2\2\2QR\7\25\2\2RS\5\22\n\2ST\5 \21\2TU\7\6\2\2UV\5$\23\2V`\3\2"+
		"\2\2WX\7\25\2\2XY\5\22\n\2YZ\5 \21\2Z[\7\7\2\2[\\\5\22\n\2\\`\3\2\2\2"+
		"]^\7\7\2\2^`\5\f\7\2_E\3\2\2\2_K\3\2\2\2_Q\3\2\2\2_W\3\2\2\2_]\3\2\2\2"+
		"`\7\3\2\2\2ab\7\b\2\2be\5\n\6\2ce\3\2\2\2da\3\2\2\2dc\3\2\2\2e\t\3\2\2"+
		"\2fh\7\34\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\13\3\2\2\2ki\3"+
		"\2\2\2lm\b\7\1\2m{\5\24\13\2no\5\24\13\2op\7\t\2\2pq\5\32\16\2qr\7\n\2"+
		"\2rs\5\f\7\4s{\3\2\2\2tu\5\24\13\2uv\7\t\2\2vw\5\32\16\2wx\7\n\2\2xy\5"+
		"\24\13\2y{\3\2\2\2zl\3\2\2\2zn\3\2\2\2zt\3\2\2\2{\u008a\3\2\2\2|}\f\6"+
		"\2\2}~\7\t\2\2~\177\5\32\16\2\177\u0080\7\n\2\2\u0080\u0081\5\f\7\7\u0081"+
		"\u0089\3\2\2\2\u0082\u0083\f\5\2\2\u0083\u0084\7\t\2\2\u0084\u0085\5\32"+
		"\16\2\u0085\u0086\7\n\2\2\u0086\u0087\5\24\13\2\u0087\u0089\3\2\2\2\u0088"+
		"|\3\2\2\2\u0088\u0082\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2"+
		"\u008a\u008b\3\2\2\2\u008b\r\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7"+
		"\26\2\2\u008e\u008f\5\20\t\2\u008f\17\3\2\2\2\u0090\u0091\7\13\2\2\u0091"+
		"\u0092\7\34\2\2\u0092\u0095\7\f\2\2\u0093\u0095\5$\23\2\u0094\u0090\3"+
		"\2\2\2\u0094\u0093\3\2\2\2\u0095\21\3\2\2\2\u0096\u0099\5\f\7\2\u0097"+
		"\u0099\5\24\13\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\23\3\2"+
		"\2\2\u009a\u009b\7\r\2\2\u009b\u009c\5\30\r\2\u009c\u009d\7\f\2\2\u009d"+
		"\u00a5\3\2\2\2\u009e\u009f\7\r\2\2\u009f\u00a0\5\30\r\2\u00a0\u00a1\7"+
		"\16\2\2\u00a1\u00a2\5\26\f\2\u00a2\u00a3\7\f\2\2\u00a3\u00a5\3\2\2\2\u00a4"+
		"\u009a\3\2\2\2\u00a4\u009e\3\2\2\2\u00a5\25\3\2\2\2\u00a6\u00a7\7\34\2"+
		"\2\u00a7\27\3\2\2\2\u00a8\u00a9\7\34\2\2\u00a9\31\3\2\2\2\u00aa\u00ac"+
		"\5\34\17\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\3\2\2\2"+
		"\u00ad\u00ae\7\16\2\2\u00ae\u00b0\5\26\f\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\33\3\2\2\2\u00b1\u00b2\7\34\2\2\u00b2\35\3\2\2\2\u00b3"+
		"\u00b4\7\34\2\2\u00b4\u00b5\7\17\2\2\u00b5\u00b6\5\22\n\2\u00b6\37\3\2"+
		"\2\2\u00b7\u00b8\7\20\2\2\u00b8\u00bb\5\"\22\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u00b7\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb!\3\2\2\2\u00bc\u00bd\b\22\1\2"+
		"\u00bd\u00be\5$\23\2\u00be\u00bf\7\30\2\2\u00bf\u00c0\5$\23\2\u00c0\u00d8"+
		"\3\2\2\2\u00c1\u00c2\5$\23\2\u00c2\u00c3\7\30\2\2\u00c3\u00c4\5&\24\2"+
		"\u00c4\u00d8\3\2\2\2\u00c5\u00c6\5$\23\2\u00c6\u00c7\7\17\2\2\u00c7\u00c8"+
		"\5$\23\2\u00c8\u00d8\3\2\2\2\u00c9\u00ca\5$\23\2\u00ca\u00cb\7\17\2\2"+
		"\u00cb\u00cc\5&\24\2\u00cc\u00d8\3\2\2\2\u00cd\u00ce\7\33\2\2\u00ce\u00cf"+
		"\7\31\2\2\u00cf\u00d8\5$\23\2\u00d0\u00d1\7\34\2\2\u00d1\u00d2\7\23\2"+
		"\2\u00d2\u00d8\7\34\2\2\u00d3\u00d4\7\r\2\2\u00d4\u00d5\5\"\22\2\u00d5"+
		"\u00d6\7\f\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00bc\3\2\2\2\u00d7\u00c1\3\2"+
		"\2\2\u00d7\u00c5\3\2\2\2\u00d7\u00c9\3\2\2\2\u00d7\u00cd\3\2\2\2\u00d7"+
		"\u00d0\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d8\u00e1\3\2\2\2\u00d9\u00da\f\7"+
		"\2\2\u00da\u00db\7\21\2\2\u00db\u00e0\5\"\22\b\u00dc\u00dd\f\6\2\2\u00dd"+
		"\u00de\7\22\2\2\u00de\u00e0\5\"\22\7\u00df\u00d9\3\2\2\2\u00df\u00dc\3"+
		"\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"#\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\7\34\2\2\u00e5\u00e6\7\24\2"+
		"\2\u00e6\u00e8\7\34\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"%\3\2\2\2\u00e9\u00ea\t\2\2\2\u00ea\'\3\2\2\2\u00eb\u00ec\5$\23\2\u00ec"+
		"\u00ed\7\30\2\2\u00ed\u00ee\5$\23\2\u00ee)\3\2\2\2\u00ef\u00f0\5$\23\2"+
		"\u00f0\u00f1\7\17\2\2\u00f1\u00f2\5$\23\2\u00f2\u00f8\3\2\2\2\u00f3\u00f4"+
		"\5$\23\2\u00f4\u00f5\7\17\2\2\u00f5\u00f6\5&\24\2\u00f6\u00f8\3\2\2\2"+
		"\u00f7\u00ef\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f8+\3\2\2\2\25\67C_diz\u0088"+
		"\u008a\u0094\u0098\u00a4\u00ab\u00af\u00ba\u00d7\u00df\u00e1\u00e7\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}