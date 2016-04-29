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
	private static int errorCounter = 0;

	public static void main(String[] args) throws IOException, RecognitionException {
		try {
			String dir = System.getProperty("user.dir");
			String resultFilePath = dir+File.separator+"Report.tex";
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
			File dataFolder = new File(dir+File.separator+"data");
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
							line = line.replace("/*", "");
							line = line.replace("*/", "");
							line = line.replace("<", "");
							line = line.replace(">", "");
							line = line.replace("&", "$ \\& $");
							line = line.replace("|", "$ | $");
							line = line.replace("_", "\\_");
							line = line.trim();
							bw.write("\\subsubsection{"+line+"}\n");
							bw.write("\\begin{verbatimtab}");
						}
						String core = "";
						while(((line = br.readLine()) != null) && !(line.startsWith("###"))) {
							line = line.replace("\\t", "\\indent");
							bw.write(line+"\n");
							core += line+"\n";
						}
						bw.write("\\end{verbatimtab}\n");
						TigerLexer lexer = new TigerLexer(new ANTLRStringStream(core));
						TigerParser parser = new TigerParser(new CommonTokenStream(lexer));	
						CommonTree tree = (CommonTree) parser.program().getTree();
						DOTTreeGenerator DOTGenerator = new DOTTreeGenerator();
						StringTemplate st = DOTGenerator.toDOT(tree);
						GraphViz graph = new GraphViz();
						graph.add(st.toString());
						String suf = "ast";
						new File(suf).mkdir();
						suf += File.separator+"ast_"+testCounter+".pdf";
						File out = new File(dir+File.separator+suf);
						graph.writeGraphToFile(graph.getGraph(graph.getDotSource(), "pdf", "dot"), out);
						if(out.length() > 0) {
							bw.write("\\begin{figure}[H]");
							bw.write("\\centering");
							bw.write("\\includegraphics[max width=\\textwidth]{"+suf+"}");
							bw.write("\\end{figure}");
						} else {
							errorCounter++;
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
			System.out.println("Report built with "+errorCounter+" error(s).");

		} catch(IOException e) {
			e.printStackTrace();
		} catch(RecognitionException e) {
			e.printStackTrace();
		}
	}
}