// Space Monkey Mafia

public class StringQueue {
	private String[] elements;
	private int count;
	private int max;

	public StringQueue(){
		elements = new String[10];
		max = 10;
		count = 0;
	}

	public int size(){
		return count;
	}

	public void queue(String s){
		if(count >= max) {
			resize();
		}
		elements[max - count - 1] = s;
		count++;
	}

	public void resize(){
		String[] temp = new String [max + 10];
		max += 10;
		for(int i = count - 1, j = max - 1; i >= 0; i--, j--){
			temp[j] = elements[i];
		}
		elements = temp;
	}
	public String dequeue(){
		if(count <= 0) {
			throw new ArrayIndexOutOfBoundsException("Error!");
		} else {
			count--;
			--max;
			return elements[max];
		}
	}
	public String dequeue(int x){
		if(count <= 0) {
			throw new ArrayIndexOutOfBoundsException("Error!");
		} else {
			if(x == 0){
				dequeue();
			}
			else{
				for(int i = x + 1; i < count; i++){
					elements[max - i] = elements[max - (i + 1)];
				}
				count--;
			}
			return elements[max - 1];
		}
	}
	
	public String peek(){
		if(count <= 0) {
			throw new ArrayIndexOutOfBoundsException("Empty!");
		} else {
			return elements[max - 1];
		}
	}
	public void singit(int pos, String x){
		
		if(count >= max) {
			resize();
		}
		if(pos == count + 1){
			queue(x);
		}
		else{
			int i, ctr;
			for(i = count + 1, ctr = 0; ctr <= count - pos; ctr++, i--){
				elements[max - i] = elements[max - (i - 1)]; 
			}
			elements[max - pos] = x;
			count++;
		}
	}
	public String toString(){
		int i;
		if(size() <= 0) {
			return "EMPTY";
		}
		String str = "";
		for(i = 0; i < count - 1 ; i++) {
			str += elements[max - i - 1] + ", ";
		}
		return str += elements[max - i - 1];

	}
	public static void main(String args[]){
		StringQueue s = new StringQueue();
		s.queue("igit");
		s.queue("tae");
		s.queue("tae1");
		s.queue("tae2");		
		s.queue("tae3");
		s.queue("tae4");
		s.queue("tae5");
		s.dequeue(2);
		s.dequeue(2);
		s.dequeue(2);
		s.singit(2,"tobol");
		System.out.println(s);
		s.dequeue();
		System.out.println(s);
		//System.out.println(s.dequeue());
		//System.out.println(s.peek());
	}

}
