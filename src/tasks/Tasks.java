package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import junit.framework.TestCase;

public class Tasks  extends TestCase{

	public void test_leet() {

		checkRecord("23A84Q", "K2Q25J");

	}

	public int checkRecord(String A, String B) {
		char[] Alec = new char[A.length()];
		char[] Bob = new char[B.length()];
		int a = 0;

		for (int i = 0; i < A.length(); i++) {
			Alec[i] = A.charAt(i);
		}

		for (int i = 0; i < B.length(); i++) {
			Bob[i] = B.charAt(i);
		}

		for (int i = 0; i < A.length(); i++) {
			if (Alec[i] != Bob[i]) {
				if (Alec[i] == "A".charAt(0)) {
					a++;
				} else if ((Alec[i] == "K".charAt(0)) && (Bob[i] != "A".charAt(0))) {
					a++;
				} else if ((Alec[i] == "Q".charAt(0)) && (Bob[i] != "A".charAt(0)) && (Bob[i] != "K".charAt(0))) {
					a++;
				} else if ((Alec[i] == "J".charAt(0)) && (Bob[i] != "A".charAt(0)) && (Bob[i] != "K".charAt(0))
						&& (Bob[i] != "Q".charAt(0))) {
					a++;
				} else if ((Alec[i] == "T".charAt(0)) && (Bob[i] != "A".charAt(0)) && (Bob[i] != "K".charAt(0))
						&& (Bob[i] != "Q".charAt(0)) && (Bob[i] != "J".charAt(0))) {
					a++;
				} else if ((Alec[i] == 9) && (Bob[i] != "A".charAt(0)) && (Bob[i] != "K".charAt(0))
						&& (Bob[i] != "Q".charAt(0)) && (Bob[i] != "J".charAt(0)) && (Bob[i] != "T".charAt(0))) {
					a++;
				} else

				if (Alec[i] > Bob[i]) {
					a++;
				} else {
				}

			}
		}
		return a;
	}

	public void test_old() {
		String s = "https://magellan-api.p7s1.io/epg-broadcast/prosieben.de/graphql?&variables=%7B%22date%22%3A%222021-03-15T00%3A00%3A00.000Z%22%2C%22domain%22%3A%22prosieben.de%22%2C%22type%22%3A%22";
		HttpURLConnection connection = null;

		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();

		try {
			URL url = new URL(s);
			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int status = connection.getResponseCode();

			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();

			} else {

				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();

			}
			System.out.println(responseContent.toString());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			connection.disconnect();
		}

	}

	public void test2() {

		String[] name = { "aim", "rajesh", "raju", "aim" };

		Set<String> myset = new HashSet<String>();
		Collections.addAll(myset, name);

		System.out.println(myset);

		List<String> al = new ArrayList<String>();

		String[] products = { "Apple", "Computer", "Apple", "Apple", "Bag" };
		for (int i = 0; i < products.length; i++) {
			for (int j = 1; j < products.length; j++) {
				if (!products[i].equalsIgnoreCase(products[j])) {

					if (!al.contains(products[i])) {
						al.add(products[i]);
					} else {
						al.remove(products[i]);
					}
				}
			}
		}
		System.out.println(al);

//		
//
//		DocumentStore documentStore = new DocumentStore(2);
//		documentStore.addDocument("item");
//		System.out.println(documentStore);
	}

	void test23() {

		List<Student> students = new ArrayList<Student>();

		students.add(new Student("Mike", 80));
		students.add(new Student("James", 57));
		students.add(new Student("Alan", 21));

		studentsThatPass(students.stream(), 50).forEach(System.out::println);

	}

	public class Student {
		private String name;
		private int score;

		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public int getScore() {
			return score;
		}

		public String getName() {
			return name;
		}
	}

	public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
		students.filter(c -> c.getScore() > passingScore).collect(Collectors.toList());

		List<String> res = new ArrayList<>();

		res.add("sup1");
		res.add("sup2");

		return res;
	}

	public class DocumentStore {
		private List<String> documents = new ArrayList<String>();
		private int capacity;

		public DocumentStore(int capacity) {
			this.capacity = capacity;
		}

		public int getCapacity() {
			return capacity;
		}

		public List<String> getDocuments() {
			return documents;
		}

		public void addDocument(String document) {
			if (this.documents.size() > capacity)
				throw new IllegalStateException();

			this.documents.add(document);
		}

		public String toString() {
			return String.format("Document store: {%d}/{%d}", documents.size(), capacity);
		}

//    public static void main(String[] args) {
//        DocumentStore documentStore = new DocumentStore(2);
//        documentStore.addDocument("item");
//        System.out.println(documentStore);
//    }
	}

}
