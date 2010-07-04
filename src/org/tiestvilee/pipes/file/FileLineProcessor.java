package org.tiestvilee.pipes.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.tiestvilee.pipes.adapters.ProducingProcessorAdapter;

public class FileLineProcessor extends ProducingProcessorAdapter<String> {

	public void process(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = reader.readLine()) != null) {
				next().process(line);
			}
		} catch (IOException e) {
			throw new RuntimeException("Error processing file", e);
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("Error closing file", e);
			}
			next().afterLastInput();
		}
	}

	public void start(Object seed) {
		process((String) seed);
	}
}
