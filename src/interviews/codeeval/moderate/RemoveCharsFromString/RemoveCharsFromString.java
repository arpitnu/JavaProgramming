/**
 * 
 */
package interviews.codeeval.moderate.RemoveCharsFromString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * @author arpitm
 * 
 *         Program removes specific characters from a string.
 * 
 *         INPUT SAMPLE: 
 *         
 *         The first argument is a path to a file. The file
 *         contains the source strings and the characters that need to be
 *         scrubbed. Each source string and characters you need to scrub are
 *         delimited by comma.
 * 
 *         For example: 
 *         
 *         how are you, abc 
 *         
 *         hello world, def
 * 
 *         OUTPUT SAMPLE: 
 *         
 *         Print to stdout the scrubbed strings, one per line.
 *         Ensure that there are no trailing empty spaces on each line you
 *         print.
 * 
 *         For example: 
 *         
 *         how re you 
 *         
 *         hllo worl
 * 
 */
public class RemoveCharsFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
		String sentence = null;

		while ((sentence = fileBuffer.readLine()) != null) {
			String[] parts = sentence.split(", ");
			char[] sourceArray = parts[0].toCharArray();
			char[] scrubCharArray = parts[1].toCharArray();
			HashSet<Character> scrubSet = new HashSet<Character>();

			for (char c : scrubCharArray) {
				scrubSet.add(c);
			}

			StringBuilder sb = new StringBuilder();

			for (char c : sourceArray) {
				if (!scrubSet.contains(c)) {
					sb.append(c);
				}
			}

			// Print to console
			System.out.println(sb.toString().trim());
		}
		
		fileBuffer.close();
	}
}
