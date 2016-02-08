import java.util.ArrayList;
import java.util.Scanner;

public class Roller {
    public static void main(String args[]) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        int luckyNumber = 0;
        System.out.println("Start Dash!");
        System.out.println("输入名字或者q来继续");
        while (reader.hasNext()) {
            String m = reader.next();
            if (m.equals("q")) {
                break;
            } else if (m.equals("l")) {
                for (int i = 0; i < name.size(); i++) {
                    System.out.println(name.get(i) + ":" + number.get(i));
                    Thread.currentThread().sleep(100);
                }
            } else {
                System.out.println("输入 " + m + "的数字");
                int n = reader.nextInt();

                if (isOK(name, number, m, n)) {
                    name.add(m);
                    number.add(n);
                }
            }
            System.out.println("输入名字,或者输入l来查看选择列表或者q来继续");
        }
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + ":" + number.get(i));
            Thread.currentThread().sleep(500);
        }
        Thread.currentThread().sleep(2000);

//        System.out.println("选取你的幸运数字！");
//        if (reader.hasNext()){
        int times = (int) (Math.random() * 20 + 50);
//            System.out.println("times:"+times);
        int time = 10;
        for (int i = times; i > 0; i--) {
            times--;
            int temp = (int) (Math.random() * 100);
            System.out.println("" + temp);
            if (i != 1) {
                Thread.currentThread().sleep(time);
            }
            if (times < 10) {
                time += 200;
            }
            if (i <= 1) {
                luckyNumber = temp;
            }

        }

//        }

        String luckyName = "";
        int luckyDog = 300;

        for (int i = 0; i < name.size(); i++) {
            String n = name.get(i);
            int nn = number.get(i);
//            System.out.println(n+":"+m);
            if (Math.abs(nn - luckyNumber) < Math.abs(luckyDog - luckyNumber)) {
                luckyName = n;
                luckyDog = nn;
            }
        }
        System.out.println("幸运女神降临在了" + luckyName + "头上！");

    }

    private static boolean isOK(ArrayList<String> name, ArrayList<Integer> number, String m, int n) {
        for (int i = 0; i < name.size(); i++) {
            String j = name.get(i);
            int k = number.get(i);
            if (j.equals(m)) {
                System.out.println("你已经选择了数字了！");
                return false;

            } else if (k == n) {
                System.out.println("数字已经被选掉，请换一个~");
                return false;

            }
        }
        return true;
    }
}