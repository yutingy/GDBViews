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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, KEYWORD=48, RETURN=49, COMMAND=50, COMPARISON=51, 
		OPERATOR=52, CONSTANTS=53, VALUE=54, NAME=55, WHITESPACE=56, ANY=57;
	public static final int
		RULE_root = 0, RULE_scope = 1, RULE_query = 2, RULE_changegraph = 3, RULE_pipeline = 4, 
		RULE_replacements = 5, RULE_iteration = 6, RULE_validVal = 7, RULE_iterationCase = 8, 
		RULE_size = 9, RULE_range = 10, RULE_pipeconditions = 11, RULE_pipeexpr = 12, 
		RULE_function = 13, RULE_viewuse = 14, RULE_usedviews = 15, RULE_viewatom = 16, 
		RULE_returnstmt = 17, RULE_retval = 18, RULE_expr = 19, RULE_variable = 20, 
		RULE_type = 21, RULE_nodeName = 22, RULE_relation = 23, RULE_relationValue = 24, 
		RULE_path = 25, RULE_conditions = 26, RULE_boolexpr = 27, RULE_attribute = 28, 
		RULE_val = 29, RULE_indexing = 30, RULE_setattr = 31, RULE_arithmetic = 32, 
		RULE_insertion = 33, RULE_insertrelation = 34, RULE_insertionVar = 35, 
		RULE_insertAttributes = 36, RULE_as = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "scope", "query", "changegraph", "pipeline", "replacements", 
			"iteration", "validVal", "iterationCase", "size", "range", "pipeconditions", 
			"pipeexpr", "function", "viewuse", "usedviews", "viewatom", "returnstmt", 
			"retval", "expr", "variable", "type", "nodeName", "relation", "relationValue", 
			"path", "conditions", "boolexpr", "attribute", "val", "indexing", "setattr", 
			"arithmetic", "insertion", "insertrelation", "insertionVar", "insertAttributes", 
			"as"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CG'", "'LOCAL'", "'GLOBAL'", "'SET'", "'DELETE'", "'REMOVE'", 
			"'CREATE'", "'WITH'", "','", "'['", "'IN'", "'('", "')'", "'|'", "']'", 
			"'NULL'", "'CASE WHEN'", "'THEN'", "'ELSE'", "'END'", "'SIZE'", "'size'", 
			"'RANGE'", "'range'", "'WHERE'", "'='", "'COLLECT('", "'UNWIND'", "'COUNT('", 
			"'COUNT(*)'", "'MAX('", "'WITH VIEWS'", "'-['", "']-'", "'NODES('", "':'", 
			"'AND'", "'OR'", "'.'", "'*'", "'+'", "'-'", "'/'", "'{'", "'}'", "'AS'", 
			"'as'", null, "'RETURN'", "'CREATE VIEW AS'", null, null, null, null, 
			null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"KEYWORD", "RETURN", "COMMAND", "COMPARISON", "OPERATOR", "CONSTANTS", 
			"VALUE", "NAME", "WHITESPACE", "ANY"
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
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
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
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(COMMAND);
				setState(77);
				match(NAME);
				setState(78);
				viewuse();
				setState(79);
				scope();
				setState(80);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(T__0);
				setState(83);
				query();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				changegraph();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				viewuse();
				setState(86);
				scope();
				setState(87);
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

	public static class ScopeContext extends ParserRuleContext {
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_scope);
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__2);
				}
				break;
			case KEYWORD:
				enterOuterAlt(_localctx, 3);
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
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
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
		enterRule(_localctx, 4, RULE_query);
		int _la;
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(KEYWORD);
				setState(97);
				expr();
				setState(98);
				conditions();
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(99);
					pipeline();
					}
				}

				setState(102);
				returnstmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(KEYWORD);
				setState(105);
				path();
				setState(106);
				conditions();
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(107);
					pipeline();
					}
				}

				setState(110);
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
		enterRule(_localctx, 6, RULE_changegraph);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(KEYWORD);
				setState(115);
				expr();
				setState(116);
				conditions();
				setState(117);
				match(T__3);
				setState(118);
				setattr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(KEYWORD);
				setState(121);
				expr();
				setState(122);
				conditions();
				setState(123);
				match(T__4);
				setState(124);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				match(KEYWORD);
				setState(127);
				expr();
				setState(128);
				conditions();
				setState(129);
				match(T__5);
				setState(130);
				attribute(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(KEYWORD);
				setState(133);
				expr();
				setState(134);
				conditions();
				setState(135);
				match(T__6);
				setState(136);
				insertion(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				match(T__6);
				setState(139);
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

	public static class PipelineContext extends ParserRuleContext {
		public ReplacementsContext replacements() {
			return getRuleContext(ReplacementsContext.class,0);
		}
		public PipeconditionsContext pipeconditions() {
			return getRuleContext(PipeconditionsContext.class,0);
		}
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
		}
		public PipelineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterPipeline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitPipeline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitPipeline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineContext pipeline() throws RecognitionException {
		PipelineContext _localctx = new PipelineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pipeline);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(T__7);
				setState(143);
				replacements();
				setState(144);
				pipeconditions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(T__7);
				setState(147);
				replacements();
				setState(148);
				pipeconditions();
				setState(149);
				pipeline();
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

	public static class ReplacementsContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(ViewParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ViewParser.NAME, i);
		}
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public ReplacementsContext replacements() {
			return getRuleContext(ReplacementsContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public IterationContext iteration() {
			return getRuleContext(IterationContext.class,0);
		}
		public ReplacementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_replacements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterReplacements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitReplacements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitReplacements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReplacementsContext replacements() throws RecognitionException {
		ReplacementsContext _localctx = new ReplacementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_replacements);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(NAME);
				setState(154);
				as();
				setState(155);
				match(NAME);
				{
				setState(156);
				match(T__8);
				setState(157);
				replacements();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				function();
				setState(160);
				as();
				setState(161);
				match(NAME);
				{
				setState(162);
				match(T__8);
				setState(163);
				replacements();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(NAME);
				{
				setState(166);
				match(T__8);
				setState(167);
				replacements();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(NAME);
				setState(169);
				as();
				setState(170);
				match(NAME);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				function();
				setState(173);
				as();
				setState(174);
				match(NAME);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				match(NAME);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				iteration();
				setState(178);
				as();
				setState(179);
				match(NAME);
				{
				setState(180);
				match(T__8);
				setState(181);
				replacements();
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(183);
				iteration();
				setState(184);
				as();
				setState(185);
				match(NAME);
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

	public static class IterationContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public List<ValidValContext> validVal() {
			return getRuleContexts(ValidValContext.class);
		}
		public ValidValContext validVal(int i) {
			return getRuleContext(ValidValContext.class,i);
		}
		public IterationCaseContext iterationCase() {
			return getRuleContext(IterationCaseContext.class,0);
		}
		public IterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterIteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitIteration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitIteration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationContext iteration() throws RecognitionException {
		IterationContext _localctx = new IterationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_iteration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__9);
			setState(190);
			match(NAME);
			setState(191);
			match(T__10);
			setState(192);
			range();
			setState(193);
			match(T__11);
			setState(194);
			validVal(0);
			setState(195);
			match(T__8);
			setState(196);
			validVal(0);
			setState(197);
			match(T__12);
			setState(198);
			match(T__13);
			setState(199);
			iterationCase();
			setState(200);
			match(T__14);
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

	public static class ValidValContext extends ParserRuleContext {
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public TerminalNode VALUE() { return getToken(ViewParser.VALUE, 0); }
		public IndexingContext indexing() {
			return getRuleContext(IndexingContext.class,0);
		}
		public List<ValidValContext> validVal() {
			return getRuleContexts(ValidValContext.class);
		}
		public ValidValContext validVal(int i) {
			return getRuleContext(ValidValContext.class,i);
		}
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public ValidValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterValidVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitValidVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitValidVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidValContext validVal() throws RecognitionException {
		return validVal(0);
	}

	private ValidValContext validVal(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValidValContext _localctx = new ValidValContext(_ctx, _parentState);
		ValidValContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_validVal, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
			case T__21:
				{
				setState(203);
				size();
				setState(204);
				match(T__11);
				setState(205);
				match(NAME);
				setState(206);
				match(T__12);
				}
				break;
			case VALUE:
				{
				setState(208);
				match(VALUE);
				}
				break;
			case T__15:
				{
				setState(209);
				match(T__15);
				}
				break;
			case NAME:
				{
				setState(210);
				indexing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ValidValContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_validVal);
					setState(213);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(214);
					arithmetic();
					setState(215);
					validVal(5);
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class IterationCaseContext extends ParserRuleContext {
		public PipeexprContext pipeexpr() {
			return getRuleContext(PipeexprContext.class,0);
		}
		public List<ValidValContext> validVal() {
			return getRuleContexts(ValidValContext.class);
		}
		public ValidValContext validVal(int i) {
			return getRuleContext(ValidValContext.class,i);
		}
		public IterationCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterIterationCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitIterationCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitIterationCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationCaseContext iterationCase() throws RecognitionException {
		IterationCaseContext _localctx = new IterationCaseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_iterationCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__16);
			setState(223);
			pipeexpr();
			setState(224);
			match(T__17);
			setState(225);
			validVal(0);
			setState(226);
			match(T__18);
			setState(227);
			validVal(0);
			setState(228);
			match(T__19);
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

	public static class SizeContext extends ParserRuleContext {
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_size);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__21) ) {
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

	public static class RangeContext extends ParserRuleContext {
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !(_la==T__22 || _la==T__23) ) {
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

	public static class PipeconditionsContext extends ParserRuleContext {
		public PipeexprContext pipeexpr() {
			return getRuleContext(PipeexprContext.class,0);
		}
		public PipeconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeconditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterPipeconditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitPipeconditions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitPipeconditions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeconditionsContext pipeconditions() throws RecognitionException {
		PipeconditionsContext _localctx = new PipeconditionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pipeconditions);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(T__24);
				setState(235);
				pipeexpr();
				}
				break;
			case T__7:
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

	public static class PipeexprContext extends ParserRuleContext {
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
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public PipeexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterPipeexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitPipeexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitPipeexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeexprContext pipeexpr() throws RecognitionException {
		PipeexprContext _localctx = new PipeexprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pipeexpr);
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				attribute(0);
				setState(240);
				match(COMPARISON);
				setState(241);
				attribute(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				attribute(0);
				setState(244);
				match(COMPARISON);
				setState(245);
				val();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				attribute(0);
				setState(248);
				match(T__25);
				setState(249);
				attribute(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(251);
				attribute(0);
				setState(252);
				match(T__25);
				setState(253);
				val();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(255);
				function();
				setState(256);
				match(COMPARISON);
				setState(257);
				attribute(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				function();
				setState(260);
				match(COMPARISON);
				setState(261);
				val();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(263);
				function();
				setState(264);
				match(T__25);
				setState(265);
				attribute(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(267);
				function();
				setState(268);
				match(T__25);
				setState(269);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ViewParser.NAME, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		try {
			setState(285);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(T__26);
				setState(274);
				match(NAME);
				setState(275);
				match(T__12);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(T__27);
				setState(277);
				match(NAME);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				match(T__28);
				setState(279);
				match(NAME);
				setState(280);
				match(T__12);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 5);
				{
				setState(282);
				match(T__30);
				setState(283);
				match(NAME);
				setState(284);
				match(T__12);
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
		enterRule(_localctx, 28, RULE_viewuse);
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(T__31);
				setState(288);
				usedviews();
				}
				break;
			case T__1:
			case T__2:
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
		enterRule(_localctx, 30, RULE_usedviews);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(292);
				match(NAME);
				}
				}
				setState(297);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_viewatom, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(299);
				variable();
				}
				break;
			case 2:
				{
				setState(300);
				variable();
				setState(301);
				match(T__32);
				setState(302);
				relation();
				setState(303);
				match(T__33);
				setState(304);
				viewatom(2);
				}
				break;
			case 3:
				{
				setState(306);
				variable();
				setState(307);
				match(T__32);
				setState(308);
				relation();
				setState(309);
				match(T__33);
				setState(310);
				variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(326);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ViewatomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_viewatom);
						setState(314);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(315);
						match(T__32);
						setState(316);
						relation();
						setState(317);
						match(T__33);
						setState(318);
						viewatom(5);
						}
						break;
					case 2:
						{
						_localctx = new ViewatomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_viewatom);
						setState(320);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(321);
						match(T__32);
						setState(322);
						relation();
						setState(323);
						match(T__33);
						setState(324);
						variable();
						}
						break;
					}
					} 
				}
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public List<RetvalContext> retval() {
			return getRuleContexts(RetvalContext.class);
		}
		public RetvalContext retval(int i) {
			return getRuleContext(RetvalContext.class,i);
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
		enterRule(_localctx, 34, RULE_returnstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(RETURN);
			setState(332);
			retval();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(333);
				match(T__8);
				setState(334);
				retval();
				}
				}
				setState(339);
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
		enterRule(_localctx, 36, RULE_retval);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				match(T__34);
				setState(341);
				match(NAME);
				setState(342);
				match(T__12);
				}
				break;
			case CONSTANTS:
			case VALUE:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				attribute(0);
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
		enterRule(_localctx, 38, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
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
		enterRule(_localctx, 40, RULE_variable);
		try {
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(T__11);
				setState(349);
				nodeName();
				setState(350);
				match(T__12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(T__11);
				setState(353);
				nodeName();
				setState(354);
				match(T__35);
				setState(355);
				type();
				setState(356);
				match(T__12);
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
		enterRule(_localctx, 42, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
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
		enterRule(_localctx, 44, RULE_nodeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
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
		enterRule(_localctx, 46, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(364);
				relationValue();
				}
			}

			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(367);
				match(T__35);
				setState(368);
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
		enterRule(_localctx, 48, RULE_relationValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
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
		enterRule(_localctx, 50, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(NAME);
			setState(374);
			match(T__25);
			setState(375);
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
		enterRule(_localctx, 52, RULE_conditions);
		try {
			setState(380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(T__24);
				setState(378);
				boolexpr(0);
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_boolexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(383);
				attribute(0);
				setState(384);
				match(COMPARISON);
				setState(385);
				attribute(0);
				}
				break;
			case 2:
				{
				setState(387);
				attribute(0);
				setState(388);
				match(COMPARISON);
				setState(389);
				val();
				}
				break;
			case 3:
				{
				setState(391);
				attribute(0);
				setState(392);
				match(T__25);
				setState(393);
				attribute(0);
				}
				break;
			case 4:
				{
				setState(395);
				attribute(0);
				setState(396);
				match(T__25);
				setState(397);
				val();
				}
				break;
			case 5:
				{
				setState(399);
				match(VALUE);
				setState(400);
				match(OPERATOR);
				setState(401);
				attribute(0);
				}
				break;
			case 6:
				{
				setState(402);
				match(NAME);
				setState(403);
				match(T__10);
				setState(404);
				match(NAME);
				}
				break;
			case 7:
				{
				setState(405);
				match(T__11);
				setState(406);
				boolexpr(0);
				setState(407);
				match(T__12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(419);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(417);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(411);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(412);
						match(T__36);
						setState(413);
						boolexpr(6);
						}
						break;
					case 2:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(414);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(415);
						match(T__37);
						setState(416);
						boolexpr(5);
						}
						break;
					}
					} 
				}
				setState(421);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public IndexingContext indexing() {
			return getRuleContext(IndexingContext.class,0);
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
		return attribute(0);
	}

	private AttributeContext attribute(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AttributeContext _localctx = new AttributeContext(_ctx, _parentState);
		AttributeContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_attribute, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(423);
				match(NAME);
				setState(426);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(424);
					match(T__38);
					setState(425);
					match(NAME);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(428);
				val();
				setState(429);
				arithmetic();
				setState(430);
				attribute(3);
				}
				break;
			case 3:
				{
				setState(432);
				indexing();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AttributeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_attribute);
					setState(435);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(436);
					arithmetic();
					setState(437);
					val();
					}
					} 
				}
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 58, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
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

	public static class IndexingContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(ViewParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ViewParser.NAME, i);
		}
		public TerminalNode VALUE() { return getToken(ViewParser.VALUE, 0); }
		public IndexingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterIndexing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitIndexing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitIndexing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexingContext indexing() throws RecognitionException {
		IndexingContext _localctx = new IndexingContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_indexing);
		try {
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				match(NAME);
				setState(447);
				match(T__9);
				setState(448);
				match(VALUE);
				setState(449);
				match(T__14);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				match(NAME);
				setState(451);
				match(T__9);
				setState(452);
				match(NAME);
				setState(453);
				match(T__14);
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
		enterRule(_localctx, 62, RULE_setattr);
		try {
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				attribute(0);
				setState(457);
				match(T__25);
				setState(458);
				attribute(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				attribute(0);
				setState(461);
				match(T__25);
				setState(462);
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

	public static class ArithmeticContext extends ParserRuleContext {
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitArithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arithmetic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_insertion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(469);
			insertionVar();
			}
			_ctx.stop = _input.LT(-1);
			setState(479);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InsertionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_insertion);
					setState(471);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(472);
					match(T__32);
					setState(473);
					insertrelation();
					setState(474);
					match(T__33);
					setState(475);
					insertion(2);
					}
					} 
				}
				setState(481);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		enterRule(_localctx, 68, RULE_insertrelation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(482);
				relationValue();
				}
			}

			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(485);
				match(T__35);
				setState(486);
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
		enterRule(_localctx, 70, RULE_insertionVar);
		int _la;
		try {
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				match(T__11);
				setState(490);
				nodeName();
				setState(491);
				match(T__12);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				match(T__11);
				setState(494);
				nodeName();
				setState(495);
				match(T__35);
				setState(496);
				type();
				setState(497);
				match(T__12);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(499);
				match(T__11);
				setState(500);
				nodeName();
				setState(501);
				match(T__35);
				setState(502);
				type();
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__43) {
					{
					setState(503);
					match(T__43);
					setState(504);
					insertAttributes();
					setState(505);
					match(T__44);
					}
				}

				setState(509);
				match(T__12);
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
		enterRule(_localctx, 72, RULE_insertAttributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(NAME);
			setState(514);
			match(T__35);
			setState(515);
			val();
			setState(520);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(516);
					match(T__8);
					setState(517);
					insertAttributes();
					}
					} 
				}
				setState(522);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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

	public static class AsContext extends ParserRuleContext {
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).enterAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ViewListener ) ((ViewListener)listener).exitAs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ViewVisitor ) return ((ViewVisitor<? extends T>)visitor).visitAs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_as);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			_la = _input.LA(1);
			if ( !(_la==T__45 || _la==T__46) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return validVal_sempred((ValidValContext)_localctx, predIndex);
		case 16:
			return viewatom_sempred((ViewatomContext)_localctx, predIndex);
		case 27:
			return boolexpr_sempred((BoolexprContext)_localctx, predIndex);
		case 28:
			return attribute_sempred((AttributeContext)_localctx, predIndex);
		case 33:
			return insertion_sempred((InsertionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean validVal_sempred(ValidValContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean viewatom_sempred(ViewatomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean boolexpr_sempred(BoolexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean attribute_sempred(AttributeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean insertion_sempred(InsertionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0210\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\\\n\2\3\3\3\3\3\3\5\3a\n\3\3\4\3\4\3\4"+
		"\3\4\5\4g\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\4\3\4\5\4s\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008f\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6\u009a\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\u00be\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d6\n\t\3\t\3"+
		"\t\3\t\3\t\7\t\u00dc\n\t\f\t\16\t\u00df\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\5\r\u00f0\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0112\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u0120\n\17\3\20\3\20\3\20\5\20\u0125\n\20\3\21\7\21\u0128\n"+
		"\21\f\21\16\21\u012b\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u013b\n\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0149\n\22\f\22\16\22\u014c\13\22"+
		"\3\23\3\23\3\23\3\23\7\23\u0152\n\23\f\23\16\23\u0155\13\23\3\24\3\24"+
		"\3\24\3\24\5\24\u015b\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u0169\n\26\3\27\3\27\3\30\3\30\3\31\5\31\u0170\n"+
		"\31\3\31\3\31\5\31\u0174\n\31\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\5\34\u017f\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u019c\n\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u01a4"+
		"\n\35\f\35\16\35\u01a7\13\35\3\36\3\36\3\36\3\36\5\36\u01ad\n\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u01b4\n\36\3\36\3\36\3\36\3\36\7\36\u01ba\n"+
		"\36\f\36\16\36\u01bd\13\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u01c9"+
		"\n \3!\3!\3!\3!\3!\3!\3!\3!\5!\u01d3\n!\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\7#\u01e0\n#\f#\16#\u01e3\13#\3$\5$\u01e6\n$\3$\3$\5$\u01ea\n$\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01fe\n%\3%\3%"+
		"\5%\u0202\n%\3&\3&\3&\3&\3&\7&\u0209\n&\f&\16&\u020c\13&\3\'\3\'\3\'\2"+
		"\7\20\"8:D(\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJL\2\7\3\2\27\30\3\2\31\32\3\2\679\3\2*-\3\2\60\61\2\u022e\2"+
		"[\3\2\2\2\4`\3\2\2\2\6r\3\2\2\2\b\u008e\3\2\2\2\n\u0099\3\2\2\2\f\u00bd"+
		"\3\2\2\2\16\u00bf\3\2\2\2\20\u00d5\3\2\2\2\22\u00e0\3\2\2\2\24\u00e8\3"+
		"\2\2\2\26\u00ea\3\2\2\2\30\u00ef\3\2\2\2\32\u0111\3\2\2\2\34\u011f\3\2"+
		"\2\2\36\u0124\3\2\2\2 \u0129\3\2\2\2\"\u013a\3\2\2\2$\u014d\3\2\2\2&\u015a"+
		"\3\2\2\2(\u015c\3\2\2\2*\u0168\3\2\2\2,\u016a\3\2\2\2.\u016c\3\2\2\2\60"+
		"\u016f\3\2\2\2\62\u0175\3\2\2\2\64\u0177\3\2\2\2\66\u017e\3\2\2\28\u019b"+
		"\3\2\2\2:\u01b3\3\2\2\2<\u01be\3\2\2\2>\u01c8\3\2\2\2@\u01d2\3\2\2\2B"+
		"\u01d4\3\2\2\2D\u01d6\3\2\2\2F\u01e5\3\2\2\2H\u0201\3\2\2\2J\u0203\3\2"+
		"\2\2L\u020d\3\2\2\2NO\7\64\2\2OP\79\2\2PQ\5\36\20\2QR\5\4\3\2RS\5\6\4"+
		"\2S\\\3\2\2\2TU\7\3\2\2U\\\5\6\4\2V\\\5\b\5\2WX\5\36\20\2XY\5\4\3\2YZ"+
		"\5\6\4\2Z\\\3\2\2\2[N\3\2\2\2[T\3\2\2\2[V\3\2\2\2[W\3\2\2\2\\\3\3\2\2"+
		"\2]a\7\4\2\2^a\7\5\2\2_a\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\5\3\2"+
		"\2\2bc\7\62\2\2cd\5(\25\2df\5\66\34\2eg\5\n\6\2fe\3\2\2\2fg\3\2\2\2gh"+
		"\3\2\2\2hi\5$\23\2is\3\2\2\2jk\7\62\2\2kl\5\64\33\2ln\5\66\34\2mo\5\n"+
		"\6\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\5$\23\2qs\3\2\2\2rb\3\2\2\2rj\3\2"+
		"\2\2s\7\3\2\2\2tu\7\62\2\2uv\5(\25\2vw\5\66\34\2wx\7\6\2\2xy\5@!\2y\u008f"+
		"\3\2\2\2z{\7\62\2\2{|\5(\25\2|}\5\66\34\2}~\7\7\2\2~\177\79\2\2\177\u008f"+
		"\3\2\2\2\u0080\u0081\7\62\2\2\u0081\u0082\5(\25\2\u0082\u0083\5\66\34"+
		"\2\u0083\u0084\7\b\2\2\u0084\u0085\5:\36\2\u0085\u008f\3\2\2\2\u0086\u0087"+
		"\7\62\2\2\u0087\u0088\5(\25\2\u0088\u0089\5\66\34\2\u0089\u008a\7\t\2"+
		"\2\u008a\u008b\5D#\2\u008b\u008f\3\2\2\2\u008c\u008d\7\t\2\2\u008d\u008f"+
		"\5D#\2\u008et\3\2\2\2\u008ez\3\2\2\2\u008e\u0080\3\2\2\2\u008e\u0086\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008f\t\3\2\2\2\u0090\u0091\7\n\2\2\u0091\u0092"+
		"\5\f\7\2\u0092\u0093\5\30\r\2\u0093\u009a\3\2\2\2\u0094\u0095\7\n\2\2"+
		"\u0095\u0096\5\f\7\2\u0096\u0097\5\30\r\2\u0097\u0098\5\n\6\2\u0098\u009a"+
		"\3\2\2\2\u0099\u0090\3\2\2\2\u0099\u0094\3\2\2\2\u009a\13\3\2\2\2\u009b"+
		"\u009c\79\2\2\u009c\u009d\5L\'\2\u009d\u009e\79\2\2\u009e\u009f\7\13\2"+
		"\2\u009f\u00a0\5\f\7\2\u00a0\u00be\3\2\2\2\u00a1\u00a2\5\34\17\2\u00a2"+
		"\u00a3\5L\'\2\u00a3\u00a4\79\2\2\u00a4\u00a5\7\13\2\2\u00a5\u00a6\5\f"+
		"\7\2\u00a6\u00be\3\2\2\2\u00a7\u00a8\79\2\2\u00a8\u00a9\7\13\2\2\u00a9"+
		"\u00be\5\f\7\2\u00aa\u00ab\79\2\2\u00ab\u00ac\5L\'\2\u00ac\u00ad\79\2"+
		"\2\u00ad\u00be\3\2\2\2\u00ae\u00af\5\34\17\2\u00af\u00b0\5L\'\2\u00b0"+
		"\u00b1\79\2\2\u00b1\u00be\3\2\2\2\u00b2\u00be\79\2\2\u00b3\u00b4\5\16"+
		"\b\2\u00b4\u00b5\5L\'\2\u00b5\u00b6\79\2\2\u00b6\u00b7\7\13\2\2\u00b7"+
		"\u00b8\5\f\7\2\u00b8\u00be\3\2\2\2\u00b9\u00ba\5\16\b\2\u00ba\u00bb\5"+
		"L\'\2\u00bb\u00bc\79\2\2\u00bc\u00be\3\2\2\2\u00bd\u009b\3\2\2\2\u00bd"+
		"\u00a1\3\2\2\2\u00bd\u00a7\3\2\2\2\u00bd\u00aa\3\2\2\2\u00bd\u00ae\3\2"+
		"\2\2\u00bd\u00b2\3\2\2\2\u00bd\u00b3\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be"+
		"\r\3\2\2\2\u00bf\u00c0\7\f\2\2\u00c0\u00c1\79\2\2\u00c1\u00c2\7\r\2\2"+
		"\u00c2\u00c3\5\26\f\2\u00c3\u00c4\7\16\2\2\u00c4\u00c5\5\20\t\2\u00c5"+
		"\u00c6\7\13\2\2\u00c6\u00c7\5\20\t\2\u00c7\u00c8\7\17\2\2\u00c8\u00c9"+
		"\7\20\2\2\u00c9\u00ca\5\22\n\2\u00ca\u00cb\7\21\2\2\u00cb\17\3\2\2\2\u00cc"+
		"\u00cd\b\t\1\2\u00cd\u00ce\5\24\13\2\u00ce\u00cf\7\16\2\2\u00cf\u00d0"+
		"\79\2\2\u00d0\u00d1\7\17\2\2\u00d1\u00d6\3\2\2\2\u00d2\u00d6\78\2\2\u00d3"+
		"\u00d6\7\22\2\2\u00d4\u00d6\5> \2\u00d5\u00cc\3\2\2\2\u00d5\u00d2\3\2"+
		"\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00dd\3\2\2\2\u00d7"+
		"\u00d8\f\6\2\2\u00d8\u00d9\5B\"\2\u00d9\u00da\5\20\t\7\u00da\u00dc\3\2"+
		"\2\2\u00db\u00d7\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\21\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7\23\2"+
		"\2\u00e1\u00e2\5\32\16\2\u00e2\u00e3\7\24\2\2\u00e3\u00e4\5\20\t\2\u00e4"+
		"\u00e5\7\25\2\2\u00e5\u00e6\5\20\t\2\u00e6\u00e7\7\26\2\2\u00e7\23\3\2"+
		"\2\2\u00e8\u00e9\t\2\2\2\u00e9\25\3\2\2\2\u00ea\u00eb\t\3\2\2\u00eb\27"+
		"\3\2\2\2\u00ec\u00ed\7\33\2\2\u00ed\u00f0\5\32\16\2\u00ee\u00f0\3\2\2"+
		"\2\u00ef\u00ec\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\31\3\2\2\2\u00f1\u00f2"+
		"\5:\36\2\u00f2\u00f3\7\65\2\2\u00f3\u00f4\5:\36\2\u00f4\u0112\3\2\2\2"+
		"\u00f5\u00f6\5:\36\2\u00f6\u00f7\7\65\2\2\u00f7\u00f8\5<\37\2\u00f8\u0112"+
		"\3\2\2\2\u00f9\u00fa\5:\36\2\u00fa\u00fb\7\34\2\2\u00fb\u00fc\5:\36\2"+
		"\u00fc\u0112\3\2\2\2\u00fd\u00fe\5:\36\2\u00fe\u00ff\7\34\2\2\u00ff\u0100"+
		"\5<\37\2\u0100\u0112\3\2\2\2\u0101\u0102\5\34\17\2\u0102\u0103\7\65\2"+
		"\2\u0103\u0104\5:\36\2\u0104\u0112\3\2\2\2\u0105\u0106\5\34\17\2\u0106"+
		"\u0107\7\65\2\2\u0107\u0108\5<\37\2\u0108\u0112\3\2\2\2\u0109\u010a\5"+
		"\34\17\2\u010a\u010b\7\34\2\2\u010b\u010c\5:\36\2\u010c\u0112\3\2\2\2"+
		"\u010d\u010e\5\34\17\2\u010e\u010f\7\34\2\2\u010f\u0110\5<\37\2\u0110"+
		"\u0112\3\2\2\2\u0111\u00f1\3\2\2\2\u0111\u00f5\3\2\2\2\u0111\u00f9\3\2"+
		"\2\2\u0111\u00fd\3\2\2\2\u0111\u0101\3\2\2\2\u0111\u0105\3\2\2\2\u0111"+
		"\u0109\3\2\2\2\u0111\u010d\3\2\2\2\u0112\33\3\2\2\2\u0113\u0114\7\35\2"+
		"\2\u0114\u0115\79\2\2\u0115\u0120\7\17\2\2\u0116\u0117\7\36\2\2\u0117"+
		"\u0120\79\2\2\u0118\u0119\7\37\2\2\u0119\u011a\79\2\2\u011a\u0120\7\17"+
		"\2\2\u011b\u0120\7 \2\2\u011c\u011d\7!\2\2\u011d\u011e\79\2\2\u011e\u0120"+
		"\7\17\2\2\u011f\u0113\3\2\2\2\u011f\u0116\3\2\2\2\u011f\u0118\3\2\2\2"+
		"\u011f\u011b\3\2\2\2\u011f\u011c\3\2\2\2\u0120\35\3\2\2\2\u0121\u0122"+
		"\7\"\2\2\u0122\u0125\5 \21\2\u0123\u0125\3\2\2\2\u0124\u0121\3\2\2\2\u0124"+
		"\u0123\3\2\2\2\u0125\37\3\2\2\2\u0126\u0128\79\2\2\u0127\u0126\3\2\2\2"+
		"\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a!\3"+
		"\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\b\22\1\2\u012d\u013b\5*\26\2\u012e"+
		"\u012f\5*\26\2\u012f\u0130\7#\2\2\u0130\u0131\5\60\31\2\u0131\u0132\7"+
		"$\2\2\u0132\u0133\5\"\22\4\u0133\u013b\3\2\2\2\u0134\u0135\5*\26\2\u0135"+
		"\u0136\7#\2\2\u0136\u0137\5\60\31\2\u0137\u0138\7$\2\2\u0138\u0139\5*"+
		"\26\2\u0139\u013b\3\2\2\2\u013a\u012c\3\2\2\2\u013a\u012e\3\2\2\2\u013a"+
		"\u0134\3\2\2\2\u013b\u014a\3\2\2\2\u013c\u013d\f\6\2\2\u013d\u013e\7#"+
		"\2\2\u013e\u013f\5\60\31\2\u013f\u0140\7$\2\2\u0140\u0141\5\"\22\7\u0141"+
		"\u0149\3\2\2\2\u0142\u0143\f\5\2\2\u0143\u0144\7#\2\2\u0144\u0145\5\60"+
		"\31\2\u0145\u0146\7$\2\2\u0146\u0147\5*\26\2\u0147\u0149\3\2\2\2\u0148"+
		"\u013c\3\2\2\2\u0148\u0142\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2"+
		"\2\2\u014a\u014b\3\2\2\2\u014b#\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e"+
		"\7\63\2\2\u014e\u0153\5&\24\2\u014f\u0150\7\13\2\2\u0150\u0152\5&\24\2"+
		"\u0151\u014f\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154"+
		"\3\2\2\2\u0154%\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7%\2\2\u0157\u0158"+
		"\79\2\2\u0158\u015b\7\17\2\2\u0159\u015b\5:\36\2\u015a\u0156\3\2\2\2\u015a"+
		"\u0159\3\2\2\2\u015b\'\3\2\2\2\u015c\u015d\5\"\22\2\u015d)\3\2\2\2\u015e"+
		"\u015f\7\16\2\2\u015f\u0160\5.\30\2\u0160\u0161\7\17\2\2\u0161\u0169\3"+
		"\2\2\2\u0162\u0163\7\16\2\2\u0163\u0164\5.\30\2\u0164\u0165\7&\2\2\u0165"+
		"\u0166\5,\27\2\u0166\u0167\7\17\2\2\u0167\u0169\3\2\2\2\u0168\u015e\3"+
		"\2\2\2\u0168\u0162\3\2\2\2\u0169+\3\2\2\2\u016a\u016b\79\2\2\u016b-\3"+
		"\2\2\2\u016c\u016d\79\2\2\u016d/\3\2\2\2\u016e\u0170\5\62\32\2\u016f\u016e"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u0172\7&\2\2\u0172"+
		"\u0174\5,\27\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\61\3\2\2"+
		"\2\u0175\u0176\79\2\2\u0176\63\3\2\2\2\u0177\u0178\79\2\2\u0178\u0179"+
		"\7\34\2\2\u0179\u017a\5(\25\2\u017a\65\3\2\2\2\u017b\u017c\7\33\2\2\u017c"+
		"\u017f\58\35\2\u017d\u017f\3\2\2\2\u017e\u017b\3\2\2\2\u017e\u017d\3\2"+
		"\2\2\u017f\67\3\2\2\2\u0180\u0181\b\35\1\2\u0181\u0182\5:\36\2\u0182\u0183"+
		"\7\65\2\2\u0183\u0184\5:\36\2\u0184\u019c\3\2\2\2\u0185\u0186\5:\36\2"+
		"\u0186\u0187\7\65\2\2\u0187\u0188\5<\37\2\u0188\u019c\3\2\2\2\u0189\u018a"+
		"\5:\36\2\u018a\u018b\7\34\2\2\u018b\u018c\5:\36\2\u018c\u019c\3\2\2\2"+
		"\u018d\u018e\5:\36\2\u018e\u018f\7\34\2\2\u018f\u0190\5<\37\2\u0190\u019c"+
		"\3\2\2\2\u0191\u0192\78\2\2\u0192\u0193\7\66\2\2\u0193\u019c\5:\36\2\u0194"+
		"\u0195\79\2\2\u0195\u0196\7\r\2\2\u0196\u019c\79\2\2\u0197\u0198\7\16"+
		"\2\2\u0198\u0199\58\35\2\u0199\u019a\7\17\2\2\u019a\u019c\3\2\2\2\u019b"+
		"\u0180\3\2\2\2\u019b\u0185\3\2\2\2\u019b\u0189\3\2\2\2\u019b\u018d\3\2"+
		"\2\2\u019b\u0191\3\2\2\2\u019b\u0194\3\2\2\2\u019b\u0197\3\2\2\2\u019c"+
		"\u01a5\3\2\2\2\u019d\u019e\f\7\2\2\u019e\u019f\7\'\2\2\u019f\u01a4\58"+
		"\35\b\u01a0\u01a1\f\6\2\2\u01a1\u01a2\7(\2\2\u01a2\u01a4\58\35\7\u01a3"+
		"\u019d\3\2\2\2\u01a3\u01a0\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2"+
		"\2\2\u01a5\u01a6\3\2\2\2\u01a69\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01a9"+
		"\b\36\1\2\u01a9\u01ac\79\2\2\u01aa\u01ab\7)\2\2\u01ab\u01ad\79\2\2\u01ac"+
		"\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01b4\3\2\2\2\u01ae\u01af\5<"+
		"\37\2\u01af\u01b0\5B\"\2\u01b0\u01b1\5:\36\5\u01b1\u01b4\3\2\2\2\u01b2"+
		"\u01b4\5> \2\u01b3\u01a8\3\2\2\2\u01b3\u01ae\3\2\2\2\u01b3\u01b2\3\2\2"+
		"\2\u01b4\u01bb\3\2\2\2\u01b5\u01b6\f\4\2\2\u01b6\u01b7\5B\"\2\u01b7\u01b8"+
		"\5<\37\2\u01b8\u01ba\3\2\2\2\u01b9\u01b5\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc;\3\2\2\2\u01bd\u01bb\3\2\2\2"+
		"\u01be\u01bf\t\4\2\2\u01bf=\3\2\2\2\u01c0\u01c1\79\2\2\u01c1\u01c2\7\f"+
		"\2\2\u01c2\u01c3\78\2\2\u01c3\u01c9\7\21\2\2\u01c4\u01c5\79\2\2\u01c5"+
		"\u01c6\7\f\2\2\u01c6\u01c7\79\2\2\u01c7\u01c9\7\21\2\2\u01c8\u01c0\3\2"+
		"\2\2\u01c8\u01c4\3\2\2\2\u01c9?\3\2\2\2\u01ca\u01cb\5:\36\2\u01cb\u01cc"+
		"\7\34\2\2\u01cc\u01cd\5:\36\2\u01cd\u01d3\3\2\2\2\u01ce\u01cf\5:\36\2"+
		"\u01cf\u01d0\7\34\2\2\u01d0\u01d1\5<\37\2\u01d1\u01d3\3\2\2\2\u01d2\u01ca"+
		"\3\2\2\2\u01d2\u01ce\3\2\2\2\u01d3A\3\2\2\2\u01d4\u01d5\t\5\2\2\u01d5"+
		"C\3\2\2\2\u01d6\u01d7\b#\1\2\u01d7\u01d8\5H%\2\u01d8\u01e1\3\2\2\2\u01d9"+
		"\u01da\f\3\2\2\u01da\u01db\7#\2\2\u01db\u01dc\5F$\2\u01dc\u01dd\7$\2\2"+
		"\u01dd\u01de\5D#\4\u01de\u01e0\3\2\2\2\u01df\u01d9\3\2\2\2\u01e0\u01e3"+
		"\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2E\3\2\2\2\u01e3"+
		"\u01e1\3\2\2\2\u01e4\u01e6\5\62\32\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3"+
		"\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e8\7&\2\2\u01e8\u01ea\5,\27\2\u01e9"+
		"\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01eaG\3\2\2\2\u01eb\u01ec\7\16\2\2"+
		"\u01ec\u01ed\5.\30\2\u01ed\u01ee\7\17\2\2\u01ee\u0202\3\2\2\2\u01ef\u01f0"+
		"\7\16\2\2\u01f0\u01f1\5.\30\2\u01f1\u01f2\7&\2\2\u01f2\u01f3\5,\27\2\u01f3"+
		"\u01f4\7\17\2\2\u01f4\u0202\3\2\2\2\u01f5\u01f6\7\16\2\2\u01f6\u01f7\5"+
		".\30\2\u01f7\u01f8\7&\2\2\u01f8\u01fd\5,\27\2\u01f9\u01fa\7.\2\2\u01fa"+
		"\u01fb\5J&\2\u01fb\u01fc\7/\2\2\u01fc\u01fe\3\2\2\2\u01fd\u01f9\3\2\2"+
		"\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\7\17\2\2\u0200"+
		"\u0202\3\2\2\2\u0201\u01eb\3\2\2\2\u0201\u01ef\3\2\2\2\u0201\u01f5\3\2"+
		"\2\2\u0202I\3\2\2\2\u0203\u0204\79\2\2\u0204\u0205\7&\2\2\u0205\u020a"+
		"\5<\37\2\u0206\u0207\7\13\2\2\u0207\u0209\5J&\2\u0208\u0206\3\2\2\2\u0209"+
		"\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020bK\3\2\2\2"+
		"\u020c\u020a\3\2\2\2\u020d\u020e\t\6\2\2\u020eM\3\2\2\2([`fnr\u008e\u0099"+
		"\u00bd\u00d5\u00dd\u00ef\u0111\u011f\u0124\u0129\u013a\u0148\u014a\u0153"+
		"\u015a\u0168\u016f\u0173\u017e\u019b\u01a3\u01a5\u01ac\u01b3\u01bb\u01c8"+
		"\u01d2\u01e1\u01e5\u01e9\u01fd\u0201\u020a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}