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
		//elements[pos - 1] = x;
		else{
			int i, ctr;
			/*int i, ctr;
			for(i = count, ctr = 0; ctr < max - pos - 1 && i >= 0; ctr++, i--){
				elements[max - i] = elements[max - (i - 1)]; 
			}
			elements[pos - 1] = x;*/
			String temp, temp1;
			temp = elements[max - pos - 1];
			elements[max - pos - 1] = x;
			for(i = pos; i <= count; i ++){
				temp1 = elements[max - i];

				
			}
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
		//s.singit(2,"tobol");
		System.out.println(s);
		System.out.println(s.dequeue());
		System.out.println(s.peek());
	}

}