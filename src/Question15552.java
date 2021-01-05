import java.io.*;
import java.util.StringTokenizer;

class Question15552 {
    public Question15552(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for(int j = 0; j < charToInt(br.readLine()); j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String writeData = String.format("%d\n",charToInt(st)+charToInt(st));
                bw.write(writeData);
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int charToInt(String originData){
        return Integer.parseInt(originData);
    }

    public int charToInt(StringTokenizer st){
        return charToInt(st.nextToken());
    }

}
