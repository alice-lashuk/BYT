import java.io.IOException;
import java.io.Writer;


// Deleted all client classes, moved methods to person class, made them non-static
public class Person {
	public String last;

	public String first;

	public String middle;

	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}

	public void printPerson(Writer out) throws IOException {
		out.write(first);
		out.write(" ");
		if (middle != null) {
			out.write(middle);
			out.write(" ");
		}
		out.write(last);
	}

	public String formatPerson(Person person) {
		String result = person.last + ", " + person.first;
		if (person.middle != null)
			result += " " + person.middle;
		return result;
	}

	public void display(Writer out, Person person) throws IOException {
		out.write(person.last);
		out.write(", ");
		out.write(person.first);
		if (person.middle != null) {
			out.write(" ");
			out.write(person.middle);
		}
	}

	public String toString(Person person) {
		return person.last + ", " + person.first
				+ ((person.middle == null) ? "" : " " + person.middle);
	}
}