import java.io.*;

class Question1003 {

    private int[] zeroOne = new int[2];

    public Question1003(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int T = Integer.parseInt(br.readLine());
            for (int a = 0; a < T; a++) {
                int number = Integer.parseInt(br.readLine());
                fibonacci(number);
                String out = String.format("%d %d\n", zeroOne[0], zeroOne[1]);
                bw.write(out);
                zeroOne = new int[]{0, 0};
            }
            br.close();
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private int fibonacci(int n){
        if (n == 0) {
            zeroOne[0]++;
            return 0;
        } else if (n == 1) {
            zeroOne[1]++;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}


