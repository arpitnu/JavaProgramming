package interviews.codeeval.moderate.challenge5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * @author arpitm
 * 
 *         Write a program which reads a file and prints to stdout the specified
 *         number of the longest lines that are sorted based on their length in
 *         descending order.
 * 
 *         INPUT SAMPLE: Your program should accept a path to a file as its
 *         first argument. The file contains multiple lines. The first line
 *         indicates the number of lines you should output, the other lines are
 *         of different length and are presented randomly. You may assume that
 *         the input file is formatted correctly and the number in the first
 *         line is a valid positive integer.
 * 
 *         For example: 
 *         2 
 *         Hello World 
 *         CodeEval 
 *         Quick Fox 
 *         A 
 *         San Francisco
 * 
 * 
 *         OUTPUT SAMPLE:
 *         Print out the longest lines limited by specified number and sorted by
 *         their length in descending order.
 * 
 *         For example:
 *         San Francisco
 *
 */
public class LongestLines {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int nLinesToPrint = -1;
		ArrayList<LineData> lines = new ArrayList<LineData>();

		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			if (nLinesToPrint == -1) {
				nLinesToPrint = Integer.parseInt(line);
			} else {
				int addIndex = -1;
				int thisLineLen = line.length();

				for (int i = 0; i < lines.size(); i++) {
					if (thisLineLen > lines.get(i).length) {
						addIndex = i;
						break;
					}
				}

				if (addIndex != -1) {
					lines.add(addIndex, new LineData(line, thisLineLen));
				} else {
					lines.add(new LineData(line, thisLineLen));
				}
			}
		}

		// Now print lines
		for (int i = 0; i < nLinesToPrint; i++) {
			System.out.println(lines.get(i).line);
		}

		buffer.close();
	}

	static class LineData {
		String line;
		int length;

		public LineData(String lineStr, int len) {
			this.line = lineStr;
			this.length = len;
		}
	}

}
