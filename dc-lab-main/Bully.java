package Ex1;
import java.util.Scanner;

class Process {
    public int id;
    public boolean active;

    public Process(int id) {
        this.id = id;
        this.active = true;
    }
}

public class Bully {
    Scanner sc;
    Process[] processes;
    int length;

    public Bully() {
        sc = new Scanner(System.in);
    }

    public void initialiseRing() {
        System.out.println("Enter No of Processes");
        length = sc.nextInt();
        processes = new Process[length];
        for (int i = 0; i < length; i++) {
            processes[i] = new Process(i);
        }
    }

    public void perfElec() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Process no " + processes[getMax()].id + " failed");
        processes[getMax()].active = false;

        int startproc = 0;
        boolean notdone = true;
        while (notdone) {

            boolean better = false;
            for (int i = startproc + 1; i < length; i++) {
                if (processes[i].active) {
                    System.out.println("Process " + startproc + " sends election message to process " + i);
                    better = true;

                }
            }

            if (better) {

                for (int i = startproc + 1; i < length; i++) {
                    if (processes[i].active) {
                        System.out.println(
                                "Process " + i + " send OK message to process " + startproc);
                    }

                }
                startproc++;

            }

            else {
                int coordinator = processes[getMax()].id;
                System.out.println("initially Process " + coordinator + " becomes Coordinator");
                for (int i = coordinator - 1; i >= 0; i--) {
                    if (processes[i].active) {
                        System.out.println("Process " + coordinator + "passes Coordinator(" + coordinator
                                + ") message to process " + i);
                    }
                }

                System.out.println("End of Election");
                notdone = false;
                break;
            }
        }

    }

    public int getMax() {
        int maxele = -99;
        int maxi = 0;
        for (int i = 0; i < processes.length; i++) {
            if (processes[i].active && processes[i].id > maxele) {
                maxele = processes[i].id;
                maxi = i;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {

        Bully b = new Bully();
        b.initialiseRing();
        b.perfElec();

    }

}