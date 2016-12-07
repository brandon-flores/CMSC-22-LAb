package Rule30;

/**
 * Created by brandon on 11/19/2016.
 */
public class Rule30Generator extends Thread {

    private boolean[] data, temp;

    Rule30Generator(boolean[] data){
        this.data = data;
        temp = new boolean[data.length];
    }

    public void run(){
       for(int i = 0; i < data.length; i++){
           boolean m = i - 1 >= 0 && data[i - 1];
           boolean n = data[i];
           boolean o = i + 1 < data.length && data[i + 1];
           temp[i] = !((m && n) || (m && o) || (!m && !n && !o));
       }
    }

    boolean[] getTemp(){
        return temp;
    }
}
