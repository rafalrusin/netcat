package netcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamTransferer implements Runnable {
	private InputStream input;
	private OutputStream output;

	public StreamTransferer(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		try {
			PrintWriter writer = new PrintWriter(output);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				writer.println(line);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
