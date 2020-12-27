import java.awt.*;
import java.util.Scanner;
import java.util.Vector;

/*
오래된 운동화를 신고, 시원한 공기와 투명한 하늘 아래 따뜻한 햇빛을 받으며 새로 마주하는 이 거리와 손잡고 걷는다.
복잡한 생각 없이 설레는 마음으로 걷다 보면 뛰고 싶고, 같이 달리다 보면 숨이 차다.
헐떡거리며 주저앉는 순간에도, 세상은 한 장의 손수건 같다.
준원이는 천하제일코딩대회가 진행 중인 지금 구름같이 행복한 하루를 보내고 있지만, 애석하게도 여러분은 문제를 풀어야 한다.
준원이가 오늘 에버랜드 대신 x축과 y축이 있는 좌표평면의 원점에서 걷고 있다고 생각해보자.
준원이의 초기 위치는 (0, 0)이고, x축 방향으로 초당 1의 속도로 움직이고 있다.
, 매초 준원이의 x좌표가 1만큼 증가하고 있다.
 그렇지만 준원이는 가끔씩 방향을 바꾼다.
 방향을 바꿀 때에는 왼쪽으로 90도만큼 돌거나 오른쪽으로 90도만큼 돈다.
준원이가 방향을 바꾼 기록이 입력으로 주어졌을 때, 준원이가 T초간 걸어간 이후 도착했을 좌표를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 준원이가 방향을 바꾼 횟수 N과, 준원이가 걸어간 시간 T가 공백을 사이에 두고 주어진다.
이후 N개의 줄에, 준원이가 i번째로 방향을 바꾼 시간 Ti과, 준원이가 왼쪽으로 돌았는지 또는 오른쪽으로 돌았는지 나타내는 문자열 Si가 공백을 사이에 두고 주어진다.
Si는 준원이가 왼쪽으로 돌았으면 left이고, 오른쪽으로 돌았으면 right이다.

출력
준원이가 T초간 걸어간 이후 도착한 좌표가 (x, y)라면, x와 y를 차례로 공백을 사이에 두고 출력한다.

제한
0 ≤ N ≤ 100,000
1 ≤ T ≤ 1,000,000,000
0 ≤ Ti ≤ T
T1, ..., TN은 모두 서로 다르고, 증가 수열이다.
즉, 한 시점에 방향을 여러 번 바꾸지 않으며, 시간 순서대로 입력이 주어진다.
Si = left 또는 right
 */
class MoveVector{
    public int Ti;
    public int lastT;
    public String Si;
    public MoveVector(int Ti, String Si){
        this.Ti = Ti;
        this.Si = Si;
    }
}

class Question20493 {
    Point currentPoint;
    Vector<MoveVector> vector;
    int degree = 90;

    public Question20493(){
        Scanner in = new Scanner(System.in);
        vector = new Vector<MoveVector>();
        currentPoint = new Point(0,0);
        int N = in.nextInt();
        int T = in.nextInt();
        for(int i=0; i < N; i++) {
            vector.add(new MoveVector(in.nextInt(), in.next()));
            try{
                vector.get(i).lastT = vector.get(i).Ti - vector.get(i-1).Ti;
            }catch (Exception e){
                vector.get(i).lastT = vector.get(i).Ti;
            }
        }
        for(MoveVector mv :vector){
            MovePoint(degree, mv.lastT);
            Rotate(mv);
            T -= mv.lastT;
        }
        MovePoint(degree,T);
        System.out.format("%d %d", currentPoint.x, currentPoint.y);
    }

    public void Rotate(MoveVector mv){
        if(mv.Si.equals("right")) degree += 90;
        else if(mv.Si.equals("left")) degree -= 90;
        if(degree >= 360) degree = 0;
        else if(degree < 0) degree = 270;
    }

    public void MovePoint(int degree, int time){
        switch (degree){
                case 90:
                    currentPoint.move((currentPoint.x + time), currentPoint.y);
                    break;
                case 180:
                    currentPoint.move(currentPoint.x, (currentPoint.y - time));
                    break;
                case 270:
                    currentPoint.move((currentPoint.x - time), currentPoint.y);
                    break;
                case 0:
                    currentPoint.move(currentPoint.x, (currentPoint.y + time));
                    break;
            }
    }
}
