package cn.web.security.cpputil;
import java.io.File;
import  cn.web.security.grammar.Grammar;
import  cn.web.security.grammar.IConst;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import  cn.web.security.cpputil.NodeCPP14Listener.CppFile;

public class App {

	public static void main(String[] args) throws Exception{
		String fileName = "code/helloworld.cpp";           
		String grammarName = "CPP14";                     
		String startRuleName = "translationunit";          
		File file = new File(fileName);
		ParseTreeListener listener = new NodeCPP14Listener();         
		/*
		CPP14Lexer lexer = new CPP14Lexer(CharStreams.fromFileName(fileName));
		CommonTokenStream token = new CommonTokenStream(lexer);
		CPP14Parser parser = new CPP14Parser(token);
		ParseTree tree = parser.translationunit();
		System.out.println("tree:"+tree.toStringTree(parser));
		*/
		walk(grammarName, file.getAbsolutePath(), startRuleName, listener);
		
	}
	
	
	
	public static CppFile jiexi(String fileName,int classmentcount,int funcsize,int varid,int conid,int assid,int callid) {
		
		String grammarName = "CPP14";                     
		String startRuleName = "translationunit";
		File file = new File(fileName);
		ParseTreeListener listener = new NodeCPP14Listener();
		
		
		NodeCPP14Listener.classmentcount=classmentcount; //用来给类编号
		NodeCPP14Listener.funcsize=funcsize;       //用来给函数编号
		NodeCPP14Listener.id = conid;
		NodeCPP14Listener.varsize = varid;
		NodeCPP14Listener.assid = assid;
		NodeCPP14Listener.funccid =callid;
		
		
		walk(grammarName, file.getAbsolutePath(), startRuleName, listener);
		
		
		
		return NodeCPP14Listener.cpp;
		
		
	}
	
	public static final String PREFIX = IConst.PKG_PREFIX + IConst.DOT;
	public static void generate(String grammarName){
		String grammarPath = App.class.getResource("/").getPath() + grammarName + ".g4";
		String packageName = PREFIX + grammarName.toLowerCase();
		Grammar.gen(grammarPath, packageName);
	}
	
	public static void generate(String grammarPath,String grammarName){
		String packageName = PREFIX + grammarName.toLowerCase();
		Grammar.gen(grammarPath, packageName);
	}
	
	public static void walk(String grammarName,String fileName,String startRuleName,ParseTreeListener listener){
		try {
			//String lexerClassName = getLexerClassName(grammarName);
			String lexerClassName = "cn.web.security.cpputil.CPP14Lexer";
			//String parserClassName = getParserClassName(grammarName);
			String parserClassName = "cn.web.security.cpputil.CPP14Parser";
			ParseTree tree = Grammar.parse(lexerClassName, parserClassName, fileName, startRuleName);
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(listener, tree);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static String getLexerClassName(String grammarName) {
		return PREFIX + grammarName.toLowerCase() + IConst.DOT + grammarName + "Lexer";
	}
	
	public static String getParserClassName(String grammarName) {
		return PREFIX + grammarName.toLowerCase() + IConst.DOT + grammarName + "Parser";
	}
}
