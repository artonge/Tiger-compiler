import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

public class ReportGenerator {

	private static int testCounter = 0;

	public static void main(String[] args) {
		try {
			String dir = System.getProperty("user.dir");
			String resultFilePath = dir+File.separator+File.separator+"Report.tex";
			System.out.println(resultFilePath);
			File resultFile = new File(resultFilePath);
			if(!resultFile.exists())
				resultFile.createNewFile();
			ArrayList<String> firstLines = new ArrayList<String>();
			firstLines.add("\\documentclass{article}");
			firstLines.add("");
			firstLines.add("\\usepackage[utf8]{inputenc}");
			firstLines.add("\\usepackage[french]{babel}");
			firstLines.add("\\usepackage[left=2cm,right=2cm,top=2cm,bottom=2cm]{geometry}");
			firstLines.add("\\usepackage{graphicx}");
			firstLines.add("\\usepackage{caption}");
			firstLines.add("\\usepackage{float}");
			firstLines.add("\\usepackage{moreverb}");
			firstLines.add("\\usepackage[export]{adjustbox}");
			firstLines.add("\\usepackage{listings}");
			firstLines.add("\\usepackage[dvipsnames]{xcolor}");
			firstLines.add("\\begin{document}");
			firstLines.add("{\\thispagestyle{empty}}");
			firstLines.add("\\begin{center}");
			firstLines.add("\\vspace*{\\fill}");
			firstLines.add("{\\Huge{Rapport de tests}}");
			firstLines.add("\\vspace*{\\fill}");
			firstLines.add("\\end{center}");
			firstLines.add("\\newpage");
			firstLines.add("\\pagenumbering{roman}");
			firstLines.add("\\tableofcontents");
			firstLines.add("\\newpage");
			firstLines.add("\\pagenumbering{arabic}");
			String lastLine = "\\end{document}";
			BufferedWriter bw = new BufferedWriter(new FileWriter(resultFilePath));
			for(String s : firstLines) {
				bw.write(s+"\n");
			}
			bw.write(lstConfig());
			File dataFolder = new File(dir+File.separator+"test"+File.separator+"build"+File.separator+"data"); // old : dir+File.separator+File.separator+"data"
			File[] files = dataFolder.listFiles();
			int l = files.length;
			for(int i=0; i<l; i++) {
				File currentFile = files[i];
				BufferedReader br = new BufferedReader(new FileReader(currentFile));
				String[] nameSplit = currentFile.getName().split("_");
				String subSection = nameSplit[1];
				if(subSection.equals("KO")) {
					bw.write("\\section{"+nameSplit[0]+"}\n");
				}
				bw.write("\\subsection{"+subSection+"}\n");
				String line = "";
				boolean go = false;
				while((line = br.readLine()) != null) {
					if(line.startsWith("###") || go) {
						if(go) {
							br.reset();
						}
						if(((line = br.readLine()) != null) && !(line.startsWith("###"))) {
							line = line.replaceAll("^(/\\*)+", "");
							line = line.replaceAll("(\\*/)+$", "");
							line = line.replace("<", "$ < $");
							line = line.replace(">", "$ > $");
							line = line.replace("&", "$ \\& $");
							line = line.replace("|", "$ | $");
							line = line.replace("_", "\\_");
							line = line.trim();
							bw.write("\\subsubsection{"+line+"}\n");
							bw.write("\\begin{lstlisting}");
						}
						String core = "";
						while(((line = br.readLine()) != null) && !(line.startsWith("###"))) {
							core += line+"\n";
							bw.write(line+"\n");
						}
						bw.write("\\end{lstlisting}\n");
						bw.write("\\newpage\n");
						TigerLexer lexer = new TigerLexer(new ANTLRStringStream(core));
						TigerParser parser = new TigerParser(new CommonTokenStream(lexer));
						CommonTree tree = (CommonTree) parser.program().getTree();
						DOTTreeGenerator DOTGenerator = new DOTTreeGenerator();
						StringTemplate st = DOTGenerator.toDOT(tree);
						GraphViz graph = new GraphViz();
						graph.add(st.toString());
						String suf = "ast";
						new File(dir+File.separator+suf).mkdir();
						suf += File.separator+"ast_"+testCounter+".pdf";
						File out = new File(dir+File.separator+suf);
						graph.writeGraphToFile(graph.getGraph(graph.getDotSource(), "pdf", "dot"), out);
						if(out.length() > 0) {
							bw.write("\\begin{figure}[H]\n");
							bw.write("\\centering\n");
							bw.write("\\includegraphics[max width=\\textwidth]{"+dir+File.separator+suf+"}\n");
							bw.write("\\end{figure}\n");
							bw.write("\\newpage\n");
						} else {
							bw.write("{\\color{red}\\textbf{Pas d'AST, problème de syntaxe.}}\n");
							bw.write("\\newpage\n");
						}
						br.mark(0);
						testCounter++;
						go = true;
					}
				}
				br.close();
			}
			bw.write(lastLine);
			bw.close();
			System.out.println("Report built.");
		} catch(IOException e) {
			e.printStackTrace();
		} catch(RecognitionException e) {
			e.printStackTrace();
		}
	}

	private static String lstConfig() {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("\\lstdefinelanguage{Tiger} {");
		lines.add("morekeywords={var,function,let,in,end,if,then,else,while,do,for,to,break,return,nil},");
		lines.add("sensitive=false,");
		lines.add("morecomment=[s]{/*}{*/},");
		lines.add("morestring=[b]");
		lines.add("}");
		lines.add("");
		lines.add("\\lstset {");
		lines.add("language={Tiger},");
		lines.add("basicstyle=\\ttfamily,");
		lines.add("captionpos=b,");
		lines.add("extendedchars=true,");
		lines.add("tabsize=2,");
		lines.add("columns=fixed,");
		lines.add("keepspaces=true,");
		lines.add("showstringspaces=true,");
		lines.add("breaklines=true,");
		lines.add("frame=trbl");
		lines.add("frameround=tttt,");
		lines.add("framesep=4pt,");
		lines.add("numbers=left,");
		lines.add("numberstyle=\\tiny\\ttfamily,");
		lines.add("commentstyle=\\color{ForestGreen},");
		lines.add("keywordstyle=\\color{RedViolet},");
		lines.add("stringstyle=\\color{blue}");
		lines.add("}");
		String line = "";
		for(String s : lines)
			line += s+"\n";
		return line;
	}
}
