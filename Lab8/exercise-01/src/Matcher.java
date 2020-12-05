public class Matcher {
	public Matcher() {
	}
	// bad smell: two similar loops ; solution: merged in one loop
	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		for (int i = 0; i < actual.length; i++) {
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		}

		// Check for length differences
		if (actual.length != expected.length)
			return false;

		return true;
	}
}