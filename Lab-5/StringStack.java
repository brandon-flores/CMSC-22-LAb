// Space Monkey Mafia

	public class StringStack {
		private String[] elements;
		private int count;
		public static final int DEFAULT_SIZE = 10;

		// constructors
		public StringStack() {
			this(DEFAULT_SIZE);
		}

		public StringStack(int size) {
			if(size <= 0) {
				throw new IllegalArgumentException("Invalid!");
			} else {
				elements = new String[size];
			}
		}

		public String pop() {
			if(count <= 0) {
				throw new ArrayIndexOutOfBoundsException("Invalid!");
			} else {
				return elements[--count];
			}
		}

		public void push(String item) {
			if(count >= elements.length) {
				throw new ArrayIndexOutOfBoundsException("Invalid!");
			} else {
				elements[count++] = item;
			}
		}

		public int size() {
			return count;
		}

		public String toString() {
			if(size() == 0) {
				return "EMPTY";
			}

			String str = "";
				for(int i = 0; i < count - 1; i++) {
					str += elements[i] + ", ";
				}
				return str += elements[size() - 1];
		}

		public String pop(int n) {
			if (n <= 0) {
				throw new IllegalArgumentException ("Invalid");
			} 
			String result = "";
				for(int i = 0; i < n; i++) {
					result = pop();
				}
			return result;
		}

		
		public static void main(String[] args) {
				StringStack s = new StringStack(5);
				//Emtpy
				s.toString();
				//exception
				s.pop();
				s.push("Chicken Soup");
				s.push("Tomatoes and basil");
				//works
				s.pop();
				s.push("Gible");
				s.push("Snorlax");
				s.push("Ditto");
				//exception
				s.push("Charizard");
				s.size();
				s.toString();
				//works
				s.pop(3);
				//exception
				s.pop(-9);



		}
	}