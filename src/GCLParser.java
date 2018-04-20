// Generated from /Users/andreasharmuth/Google Drive/private/General_Engineering/Semester_4/CSM/pls_work/GCL.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GCLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		SEP=25, DIG=26, BAD=27, VAR=28, IF=29, FI=30, DO=31, OD=32, WS=33;
	public static final int
		RULE_start = 0, RULE_exprC = 1, RULE_exprGC = 2, RULE_a = 3, RULE_b = 4;
	public static final String[] ruleNames = {
		"start", "exprC", "exprGC", "a", "b"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':='", "'skip'", "'->'", "'[]'", "'-'", "'/'", "'*'", "'+'", "'^'", 
		"'('", "')'", "'true'", "'false'", "'&'", "'|'", "'&&'", "'||'", "'!'", 
		"'='", "'!='", "'>'", "'>='", "'<'", "'<='", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "SEP", "DIG", "BAD", "VAR", "IF", "FI", "DO", "OD", "WS"
	};
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
	public String getGrammarFileName() { return "GCL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GCLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ExprCContext exprC() {
			return getRuleContext(ExprCContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GCLParser.EOF, 0); }
		public ExprGCContext exprGC() {
			return getRuleContext(ExprGCContext.class,0);
		}
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			setState(22);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				exprC(0);
				setState(11);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				exprGC(0);
				setState(14);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(16);
				a(0);
				setState(17);
				match(EOF);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(19);
				b(0);
				setState(20);
				match(EOF);
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

	public static class ExprCContext extends ParserRuleContext {
		public ExprCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprC; }
	 
		public ExprCContext() { }
		public void copyFrom(ExprCContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CIfContext extends ExprCContext {
		public TerminalNode IF() { return getToken(GCLParser.IF, 0); }
		public ExprGCContext exprGC() {
			return getRuleContext(ExprGCContext.class,0);
		}
		public TerminalNode FI() { return getToken(GCLParser.FI, 0); }
		public CIfContext(ExprCContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterCIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitCIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitCIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CAssignContext extends ExprCContext {
		public TerminalNode VAR() { return getToken(GCLParser.VAR, 0); }
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public CAssignContext(ExprCContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterCAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitCAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitCAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CSepContext extends ExprCContext {
		public List<ExprCContext> exprC() {
			return getRuleContexts(ExprCContext.class);
		}
		public ExprCContext exprC(int i) {
			return getRuleContext(ExprCContext.class,i);
		}
		public TerminalNode SEP() { return getToken(GCLParser.SEP, 0); }
		public CSepContext(ExprCContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterCSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitCSep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitCSep(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CSkipContext extends ExprCContext {
		public CSkipContext(ExprCContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterCSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitCSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitCSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CDoContext extends ExprCContext {
		public TerminalNode DO() { return getToken(GCLParser.DO, 0); }
		public ExprGCContext exprGC() {
			return getRuleContext(ExprGCContext.class,0);
		}
		public TerminalNode OD() { return getToken(GCLParser.OD, 0); }
		public CDoContext(ExprCContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterCDo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitCDo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitCDo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprCContext exprC() throws RecognitionException {
		return exprC(0);
	}

	private ExprCContext exprC(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprCContext _localctx = new ExprCContext(_ctx, _parentState);
		ExprCContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_exprC, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				_localctx = new CAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(25);
				match(VAR);
				setState(26);
				match(T__0);
				setState(27);
				a(0);
				}
				break;
			case T__1:
				{
				_localctx = new CSkipContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__1);
				}
				break;
			case IF:
				{
				_localctx = new CIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(IF);
				setState(30);
				exprGC(0);
				setState(31);
				match(FI);
				}
				break;
			case DO:
				{
				_localctx = new CDoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(DO);
				setState(34);
				exprGC(0);
				setState(35);
				match(OD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CSepContext(new ExprCContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exprC);
					setState(39);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(40);
					match(SEP);
					setState(41);
					exprC(1);
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class ExprGCContext extends ParserRuleContext {
		public ExprGCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprGC; }
	 
		public ExprGCContext() { }
		public void copyFrom(ExprGCContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GCOnCondtionContext extends ExprGCContext {
		public BContext lhs;
		public ExprCContext rhs;
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public ExprCContext exprC() {
			return getRuleContext(ExprCContext.class,0);
		}
		public GCOnCondtionContext(ExprGCContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterGCOnCondtion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitGCOnCondtion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitGCOnCondtion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GCOnConditionContext extends ExprGCContext {
		public ExprGCContext lhs;
		public ExprGCContext rhs;
		public List<ExprGCContext> exprGC() {
			return getRuleContexts(ExprGCContext.class);
		}
		public ExprGCContext exprGC(int i) {
			return getRuleContext(ExprGCContext.class,i);
		}
		public GCOnConditionContext(ExprGCContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterGCOnCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitGCOnCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitGCOnCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprGCContext exprGC() throws RecognitionException {
		return exprGC(0);
	}

	private ExprGCContext exprGC(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprGCContext _localctx = new ExprGCContext(_ctx, _parentState);
		ExprGCContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_exprGC, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new GCOnCondtionContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(48);
			((GCOnCondtionContext)_localctx).lhs = b(0);
			setState(49);
			match(T__2);
			setState(50);
			((GCOnCondtionContext)_localctx).rhs = exprC(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GCOnConditionContext(new ExprGCContext(_parentctx, _parentState));
					((GCOnConditionContext)_localctx).lhs = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exprGC);
					setState(52);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(53);
					match(T__3);
					setState(54);
					((GCOnConditionContext)_localctx).rhs = exprGC(2);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class AContext extends ParserRuleContext {
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
	 
		public AContext() { }
		public void copyFrom(AContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AritVarContext extends AContext {
		public TerminalNode VAR() { return getToken(GCLParser.VAR, 0); }
		public AritVarContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterAritVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitAritVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitAritVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AritDoubleContext extends AContext {
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public AritDoubleContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterAritDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitAritDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitAritDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AritParenthesesContext extends AContext {
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public AritParenthesesContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterAritParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitAritParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitAritParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AritPowerContext extends AContext {
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public AritPowerContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterAritPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitAritPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitAritPower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AritDigContext extends AContext {
		public TerminalNode DIG() { return getToken(GCLParser.DIG, 0); }
		public AritDigContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterAritDig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitAritDig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitAritDig(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AritNegContext extends AContext {
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public AritNegContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterAritNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitAritNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitAritNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AritDivContext extends AContext {
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public AritDivContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterAritDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitAritDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitAritDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AContext a() throws RecognitionException {
		return a(0);
	}

	private AContext a(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AContext _localctx = new AContext(_ctx, _parentState);
		AContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_a, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIG:
				{
				_localctx = new AritDigContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(61);
				match(DIG);
				}
				break;
			case T__4:
				{
				_localctx = new AritNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(T__4);
				setState(63);
				a(8);
				}
				break;
			case VAR:
				{
				_localctx = new AritVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				match(VAR);
				}
				break;
			case T__9:
				{
				_localctx = new AritParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(T__9);
				setState(66);
				a(0);
				setState(67);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new AritDivContext(new AContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(71);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(72);
						match(T__5);
						setState(73);
						a(7);
						}
						break;
					case 2:
						{
						_localctx = new AritDoubleContext(new AContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(74);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(75);
						match(T__6);
						setState(76);
						a(6);
						}
						break;
					case 3:
						{
						_localctx = new AritDoubleContext(new AContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(77);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(78);
						match(T__7);
						setState(79);
						a(5);
						}
						break;
					case 4:
						{
						_localctx = new AritDoubleContext(new AContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(80);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(81);
						match(T__4);
						setState(82);
						a(4);
						}
						break;
					case 5:
						{
						_localctx = new AritPowerContext(new AContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(83);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(84);
						match(T__8);
						setState(85);
						a(2);
						}
						break;
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class BContext extends ParserRuleContext {
		public BContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b; }
	 
		public BContext() { }
		public void copyFrom(BContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolDoubleContext extends BContext {
		public List<BContext> b() {
			return getRuleContexts(BContext.class);
		}
		public BContext b(int i) {
			return getRuleContext(BContext.class,i);
		}
		public BoolDoubleContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterBoolDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitBoolDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitBoolDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolCompareContext extends BContext {
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public BoolCompareContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterBoolCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitBoolCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitBoolCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends BContext {
		public TrueContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolNotContext extends BContext {
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public BoolNotContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterBoolNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitBoolNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitBoolNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends BContext {
		public FalseContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolBracketContext extends BContext {
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public BoolBracketContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).enterBoolBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLListener ) ((GCLListener)listener).exitBoolBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLVisitor ) return ((GCLVisitor<? extends T>)visitor).visitBoolBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BContext b() throws RecognitionException {
		return b(0);
	}

	private BContext b(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BContext _localctx = new BContext(_ctx, _parentState);
		BContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_b, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(92);
				match(T__11);
				}
				break;
			case 2:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(T__12);
				}
				break;
			case 3:
				{
				_localctx = new BoolNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(T__17);
				setState(95);
				b(8);
				}
				break;
			case 4:
				{
				_localctx = new BoolCompareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				a(0);
				setState(97);
				match(T__18);
				setState(98);
				a(0);
				}
				break;
			case 5:
				{
				_localctx = new BoolCompareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				a(0);
				setState(101);
				match(T__19);
				setState(102);
				a(0);
				}
				break;
			case 6:
				{
				_localctx = new BoolCompareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				a(0);
				setState(105);
				match(T__20);
				setState(106);
				a(0);
				}
				break;
			case 7:
				{
				_localctx = new BoolCompareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				a(0);
				setState(109);
				match(T__21);
				setState(110);
				a(0);
				}
				break;
			case 8:
				{
				_localctx = new BoolCompareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				a(0);
				setState(113);
				match(T__22);
				setState(114);
				a(0);
				}
				break;
			case 9:
				{
				_localctx = new BoolCompareContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				a(0);
				setState(117);
				match(T__23);
				setState(118);
				a(0);
				}
				break;
			case 10:
				{
				_localctx = new BoolBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(T__9);
				setState(121);
				b(0);
				setState(122);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BoolDoubleContext(new BContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(126);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(127);
						match(T__13);
						setState(128);
						b(13);
						}
						break;
					case 2:
						{
						_localctx = new BoolDoubleContext(new BContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(129);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(130);
						match(T__14);
						setState(131);
						b(12);
						}
						break;
					case 3:
						{
						_localctx = new BoolDoubleContext(new BContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(132);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(133);
						match(T__15);
						setState(134);
						b(11);
						}
						break;
					case 4:
						{
						_localctx = new BoolDoubleContext(new BContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(135);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(136);
						match(T__16);
						setState(137);
						b(10);
						}
						break;
					}
					} 
				}
				setState(142);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return exprC_sempred((ExprCContext)_localctx, predIndex);
		case 2:
			return exprGC_sempred((ExprGCContext)_localctx, predIndex);
		case 3:
			return a_sempred((AContext)_localctx, predIndex);
		case 4:
			return b_sempred((BContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprC_sempred(ExprCContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exprGC_sempred(ExprGCContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean a_sempred(AContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean b_sempred(BContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0092\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\31\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3(\n\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5H\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5Y\n\5\f\5\16\5\\\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13\6\3\6\2\6\4\6\b\n\7\2\4\6\b"+
		"\n\2\2\2\u00a9\2\30\3\2\2\2\4\'\3\2\2\2\6\61\3\2\2\2\bG\3\2\2\2\n~\3\2"+
		"\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\31\3\2\2\2\17\20\5\6\4\2\20\21\7\2\2"+
		"\3\21\31\3\2\2\2\22\23\5\b\5\2\23\24\7\2\2\3\24\31\3\2\2\2\25\26\5\n\6"+
		"\2\26\27\7\2\2\3\27\31\3\2\2\2\30\f\3\2\2\2\30\17\3\2\2\2\30\22\3\2\2"+
		"\2\30\25\3\2\2\2\31\3\3\2\2\2\32\33\b\3\1\2\33\34\7\36\2\2\34\35\7\3\2"+
		"\2\35(\5\b\5\2\36(\7\4\2\2\37 \7\37\2\2 !\5\6\4\2!\"\7 \2\2\"(\3\2\2\2"+
		"#$\7!\2\2$%\5\6\4\2%&\7\"\2\2&(\3\2\2\2\'\32\3\2\2\2\'\36\3\2\2\2\'\37"+
		"\3\2\2\2\'#\3\2\2\2(.\3\2\2\2)*\f\3\2\2*+\7\33\2\2+-\5\4\3\3,)\3\2\2\2"+
		"-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60.\3\2\2\2\61\62\b\4\1\2"+
		"\62\63\5\n\6\2\63\64\7\5\2\2\64\65\5\4\3\2\65;\3\2\2\2\66\67\f\3\2\2\67"+
		"8\7\6\2\28:\5\6\4\49\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\7\3\2\2"+
		"\2=;\3\2\2\2>?\b\5\1\2?H\7\34\2\2@A\7\7\2\2AH\5\b\5\nBH\7\36\2\2CD\7\f"+
		"\2\2DE\5\b\5\2EF\7\r\2\2FH\3\2\2\2G>\3\2\2\2G@\3\2\2\2GB\3\2\2\2GC\3\2"+
		"\2\2HZ\3\2\2\2IJ\f\b\2\2JK\7\b\2\2KY\5\b\5\tLM\f\7\2\2MN\7\t\2\2NY\5\b"+
		"\5\bOP\f\6\2\2PQ\7\n\2\2QY\5\b\5\7RS\f\5\2\2ST\7\7\2\2TY\5\b\5\6UV\f\4"+
		"\2\2VW\7\13\2\2WY\5\b\5\4XI\3\2\2\2XL\3\2\2\2XO\3\2\2\2XR\3\2\2\2XU\3"+
		"\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\t\3\2\2\2\\Z\3\2\2\2]^\b\6\1\2"+
		"^\177\7\16\2\2_\177\7\17\2\2`a\7\24\2\2a\177\5\n\6\nbc\5\b\5\2cd\7\25"+
		"\2\2de\5\b\5\2e\177\3\2\2\2fg\5\b\5\2gh\7\26\2\2hi\5\b\5\2i\177\3\2\2"+
		"\2jk\5\b\5\2kl\7\27\2\2lm\5\b\5\2m\177\3\2\2\2no\5\b\5\2op\7\30\2\2pq"+
		"\5\b\5\2q\177\3\2\2\2rs\5\b\5\2st\7\31\2\2tu\5\b\5\2u\177\3\2\2\2vw\5"+
		"\b\5\2wx\7\32\2\2xy\5\b\5\2y\177\3\2\2\2z{\7\f\2\2{|\5\n\6\2|}\7\r\2\2"+
		"}\177\3\2\2\2~]\3\2\2\2~_\3\2\2\2~`\3\2\2\2~b\3\2\2\2~f\3\2\2\2~j\3\2"+
		"\2\2~n\3\2\2\2~r\3\2\2\2~v\3\2\2\2~z\3\2\2\2\177\u008e\3\2\2\2\u0080\u0081"+
		"\f\16\2\2\u0081\u0082\7\20\2\2\u0082\u008d\5\n\6\17\u0083\u0084\f\r\2"+
		"\2\u0084\u0085\7\21\2\2\u0085\u008d\5\n\6\16\u0086\u0087\f\f\2\2\u0087"+
		"\u0088\7\22\2\2\u0088\u008d\5\n\6\r\u0089\u008a\f\13\2\2\u008a\u008b\7"+
		"\23\2\2\u008b\u008d\5\n\6\f\u008c\u0080\3\2\2\2\u008c\u0083\3\2\2\2\u008c"+
		"\u0086\3\2\2\2\u008c\u0089\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\13\3\2\2\2\u0090\u008e\3\2\2\2\f\30\'."+
		";GXZ~\u008c\u008e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}