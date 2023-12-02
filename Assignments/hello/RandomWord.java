import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class RandomWord {
    public static void main(String[] args) {
        if (args.length == 1) {
            if (args.length == 0) {
                return;
            }

            String fileName = args[0];
            In in = new In(fileName);
            String champion = "";
            int count = 0;

            while (!in.isEmpty()) {
                String word = in.readLine();
                count++;
                if (Math.random() < 1.0 / count) {
                    champion = word;
                }
            }

            System.out.println("champion is " + champion);
        } else {
            String champion = "";
            int count = 0;

            while (!StdIn.isEmpty()) {
                String word = StdIn.readString();
                count++;

                if (Math.random() < 1.0 / count) {
                    champion = word;
                }
            }

            System.out.println("the chamption is " + champion);
        }

    }

}
