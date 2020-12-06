import java.io.PrintStream;
// Made constants, divided methods into ones which are creating strings, escaping quotes and writing to the stream
public class CsvWriter {
	
	private PrintStream printStream;
	private final static char DELIMITER = ',';
	private final static char ESCAPE_CHARACTER = '\"';
	private final static char NEW_LINE_CHARACTER = '\n';

	//default constructor for console output
	public CsvWriter() {
		this(System.out);
	}

	public CsvWriter(PrintStream printStream) {
		this.printStream = printStream;
	}

	//write to the stream
	public void write(String[][] lines) {
		for (int i = 0; i < lines.length; i++)
			printStream.print(formatLine(lines[i]));
	}

	//formatting line, returning string created using StringBuilder
	private String formatLine(String[] fields) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			if (i != 0) {
				builder.append(DELIMITER);
			}
			builder.append(escape(fields[i]));
		}
		builder.append(NEW_LINE_CHARACTER);
		return builder.toString();
	}

	private String escape(String field) {
		if (field.indexOf(DELIMITER) == -1 && field.indexOf(ESCAPE_CHARACTER) == -1) {
			return field;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(ESCAPE_CHARACTER);
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (c == ESCAPE_CHARACTER) {
				builder.append(ESCAPE_CHARACTER);
				builder.append(ESCAPE_CHARACTER);
			} else {
				builder.append(c);
			}
		}
		builder.append(ESCAPE_CHARACTER);
		return builder.toString();
	}
}