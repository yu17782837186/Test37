package cn.com.inet;

public class TalkTeacher {
    public static void main(String[] args) {
//        new Thread(new TalkReceive(6666,"学生")).start();
//        new Thread(new TalkSend(7777,"localhost",5555)).start();
        new Thread(new TalkReceive(6666,"学生")).start();
        new Thread(new TalkSend(7777,"localhost",5555)).start();
    }
}
