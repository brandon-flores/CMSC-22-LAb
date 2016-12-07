package Rule30;

import java.util.Scanner;

/**
 * Created by brandon on 11/19/2016.
 */
public class FloresRule30 {

    public static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();

        System.out.println("Enter size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();


        Rule30Generator[] worker = new Rule30Generator[THREAD_COUNT];
        boolean[] data = new boolean[size];

        for (int i = 0; i < size; i++) {
            data[i] = false;
        }

        data[size / 2] = true;

        for(int i = 0; i < size; i++){
            boolean flag = true;
            for (int j = 0; j < THREAD_COUNT; j++) {
                worker[j] = new Rule30Generator(data);
            }

            for (int j = 0; j < THREAD_COUNT; j++) {
                worker[j].start();
            }

            for (int j = 0; j < THREAD_COUNT; j++) {
                while (worker[j].isAlive()) {
                    try {
                        worker[j].join();
                    } catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
                if(flag) {
                    System.out.println(string(data));
                    flag = false;
                }
                data = worker[j].getTemp();
            }
        }

        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
    }

    private static String string(boolean[] bool){
        String temp = "";
        for (boolean aBool : bool) {
            temp += aBool ? 1 : 0;
        }
        return temp;
    }

    /*
    * Input 50:
    * Time of completion of the non threaded Rule 30 : 6314 milliseconds
    * Time of completion of the threaded Rule 30 : 4470 milliseconds
    * Input 100:
    * Time of completion of the non threaded Rule 30 : 2269 milliseconds
    * Time of completion of the threaded Rule 30 : 2557 milliseconds
    * Input 500:
    * Time of completion of the non threaded Rule 30 : 2823 milliseconds
    * Time of completion of the threaded Rule 30 : 4156 milliseconds
    * Input 1000:
    * Time of completion of the non threaded Rule 30 : 5533 milliseconds
    * Time of completion of the threaded Rule 30 : 4986 milliseconds
    * Input 2000:
    * Time of completion of the non threaded Rule 30 : 12435 milliseconds
    * Time of completion of the threaded Rule 30 : 8668 milliseconds
    * Input 5000:
    * Time of completion of the non threaded Rule 30 : 67751 milliseconds
    * Time of completion of the threaded Rule 30 : 58322 milliseconds
    * */
}
