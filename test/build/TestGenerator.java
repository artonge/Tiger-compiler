import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestGenerator {

	private static int testCounter = 0;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String dir = System.getProperty("user.dir")+File.separator+"test"+File.separator+"build";
		File targetFolder = new File(new File(dir).getParent()+File.separator+"tests");
		if(!(targetFolder.exists())) {
			targetFolder.mkdirs();
		}
		File dataFolder = new File(dir+File.separator+"data");
		File[] files = dataFolder.listFiles();
		int l = files.length;
		for(int i=0; i<l; i++) {
			File currentFile = files[i];
			BufferedReader br = new BufferedReader(new FileReader(currentFile));
			String[] nameSplit = currentFile.getName().split("_");
			String newPath = targetFolder.getPath()+File.separator+nameSplit[0]+File.separator+nameSplit[1];
			if(!new File(nameSplit[0]).exists()) {
				new File(newPath).mkdirs();
			} else {
				new File(newPath).mkdir();
			}
			String line = "";
			int fileCreationIndex = 0;
			boolean go = false;
			while((line = br.readLine()) != null) {
				if(line.startsWith("###") || go) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(targetFolder.getPath()+File.separator+nameSplit[0]+File.separator+nameSplit[1]+File.separator+nameSplit[0]+"_"+nameSplit[1]+"_"+fileCreationIndex+".tiger"));
					if(go) {
						br.reset();
					}
					while(((line = br.readLine()) != null) && !(line.startsWith("###"))) {
						bw.write(line+"\n");
					}
					br.mark(0);
					bw.close();
					fileCreationIndex++;
					testCounter++;
					go = true;
				}
			}
			br.close();
		}
		System.out.println(testCounter+" test files have been generated.");
	}
}
