/* IndicatorParser.java */
/* Generated By:JavaCC: Do not edit this line. IndicatorParser.java */
package parser;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import math.*;
import modelo.IndicatorRepository;

public class IndicatorParser implements IndicatorParserConstants {
        public static Operable parseIndicator(String formula){
                Operable value = null;
                IndicatorParser.ReInit(new ByteArrayInputStream(formula.getBytes(StandardCharsets.UTF_8)));
                try{
                        value = IndicatorParser.Start();
                } catch(Exception e){
                        System.out.println(e);
                }
                return value;
        }

/** Main production. */
  static final public Operable Start() throws ParseException {Operable exp;
    exp = Expression();
{if ("" != null) return exp;}
    throw new Error("Missing return statement in function");
  }

  static final public Operable Expression() throws ParseException {Operable op1, op2;
    if (jj_2_1(100)) {
      op1 = Term();
      jj_consume_token(5);
      op2 = Expression();
{if ("" != null) return new Addition(op1, op2);}
    } else if (jj_2_2(100)) {
      op1 = Term();
      jj_consume_token(6);
      op2 = Expression();
{if ("" != null) return new Subtraction(op1, op2);}
    } else if (jj_2_3(100)) {
      op1 = Term();
{if ("" != null) return op1;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Operable Term() throws ParseException {Operable op1, op2;
    if (jj_2_4(100)) {
      op1 = Factor();
      jj_consume_token(7);
      op2 = Term();
{if ("" != null) return new Multiplication(op1, op2);}
    } else if (jj_2_5(100)) {
      op1 = Factor();
      jj_consume_token(8);
      op2 = Term();
{if ("" != null) return new Division(op1, op2);}
    } else if (jj_2_6(100)) {
      op1 = Factor();
{if ("" != null) return op1;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Operable Factor() throws ParseException {Operable op1;
    if (jj_2_7(100)) {
      jj_consume_token(9);
      op1 = Expression();
      jj_consume_token(10);
{if ("" != null) return op1;}
    } else if (jj_2_8(100)) {
      op1 = Constant();
{if ("" != null) return op1;}
    } else if (jj_2_9(100)) {
      op1 = Identifier();
{if ("" != null) return op1;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

/** An Identifier. */
  static final public Operable Identifier() throws ParseException {Operable op;
    if (jj_2_10(100)) {
      op = Indicator();
    } else if (jj_2_11(100)) {
      op = Calculation();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return op;}
    throw new Error("Missing return statement in function");
  }

  static final public Operable Indicator() throws ParseException {Token t;
    t = jj_consume_token(INDICATOR);
{if ("" != null) return IndicatorRepository.getIndicator(t.image);}
    throw new Error("Missing return statement in function");
  }

  static final public Operable Calculation() throws ParseException {Token t;
    t = jj_consume_token(CALCULATION);
{if ("" != null) return new OperableCalculation(t.image);}
    throw new Error("Missing return statement in function");
  }

/** A Constant. */
  static final public Constant Constant() throws ParseException {Token t;
    t = jj_consume_token(CONSTANT);
{if ("" != null) return new Constant(Double.parseDouble(t.image));}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_2_10(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  static private boolean jj_2_11(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  static private boolean jj_3_10()
 {
    if (jj_3R_6()) return true;
    return false;
  }

  static private boolean jj_3R_5()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3_11()) return true;
    }
    return false;
  }

  static private boolean jj_3R_6()
 {
    if (jj_scan_token(INDICATOR)) return true;
    return false;
  }

  static private boolean jj_3_9()
 {
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_3_8()
 {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3_7()
 {
    if (jj_scan_token(9)) return true;
    if (jj_3R_2()) return true;
    if (jj_scan_token(10)) return true;
    return false;
  }

  static private boolean jj_3R_3()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3_8()) {
    jj_scanpos = xsp;
    if (jj_3_9()) return true;
    }
    }
    return false;
  }

  static private boolean jj_3_6()
 {
    if (jj_3R_3()) return true;
    return false;
  }

  static private boolean jj_3_5()
 {
    if (jj_3R_3()) return true;
    if (jj_scan_token(8)) return true;
    if (jj_3R_1()) return true;
    return false;
  }

  static private boolean jj_3_4()
 {
    if (jj_3R_3()) return true;
    if (jj_scan_token(7)) return true;
    if (jj_3R_1()) return true;
    return false;
  }

  static private boolean jj_3R_1()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_3_6()) return true;
    }
    }
    return false;
  }

  static private boolean jj_3_11()
 {
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3_3()
 {
    if (jj_3R_1()) return true;
    return false;
  }

  static private boolean jj_3_2()
 {
    if (jj_3R_1()) return true;
    if (jj_scan_token(6)) return true;
    if (jj_3R_2()) return true;
    return false;
  }

  static private boolean jj_3_1()
 {
    if (jj_3R_1()) return true;
    if (jj_scan_token(5)) return true;
    if (jj_3R_2()) return true;
    return false;
  }

  static private boolean jj_3R_2()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_1()) {
    jj_scanpos = xsp;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3_3()) return true;
    }
    }
    return false;
  }

  static private boolean jj_3R_4()
 {
    if (jj_scan_token(CONSTANT)) return true;
    return false;
  }

  static private boolean jj_3R_7()
 {
    if (jj_scan_token(CALCULATION)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public IndicatorParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[11];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public IndicatorParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public IndicatorParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new IndicatorParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public IndicatorParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new IndicatorParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public IndicatorParser(IndicatorParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(IndicatorParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[11];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 11; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 11; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
