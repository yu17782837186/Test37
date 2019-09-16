package cn.com.inet;

public class TalkStudents {
    public static void main(String[] args) {
//        new Thread(new TalkSend(8888,"localhost",6666)).start();
//        new Thread(new TalkReceive(5555,"老师")).start();
        new Thread(new TalkSend(8888,"localhost",6666)).start();
        new Thread(new TalkReceive(5555,"老师")).start();
    }
}
