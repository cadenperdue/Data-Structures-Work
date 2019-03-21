import java.util.Comparator;

public class StringCompare {
	public class StringCompareLength implements Comparator<String> {
		public int compare(String lhs, String rhs) {
			return lhs.length() - rhs.length();
		}
	}
}
