package Ex1;
import java.util.*;
class Process {
    public int id;
    public boolean active;

    public Process(int id) {
        this.id = id;
        this.active = true;
    }
}

public class Ring {  

    int length;
    Process[] process;
    Scanner sc;
    public Ring() {
        sc = new Scanner(System.in);
    }
    List<Integer> list=new ArrayList<Integer>(); 
    
    public void beginRing() {
        
        System.out.println("No of processes 5");
        length = 5;
        process = new Process[length];
        int i = 0;
        while (i < process.length) {
            process[i] = new Process(i);
            i++;
        }
    }

    public void Election() {
        System.out.println("Process no "
                + process[getMax()].id
                + " fails");
        process[getMax()].active = false;
        System.out.println("Election Initiated by 2");
        int initializedProcess = 2;

        int old = initializedProcess;
        list.add(process[old].id);
        int newer = old + 1;

        while (true) {
            if (process[newer].active) {
                System.out.println(
                        "Process " + process[old].id
                                + " pass Election(" + process[old].id
                                + ") to" + process[newer].id);
                list.add(process[newer].id);
                
                old = newer;
            }

            newer = (newer + 1) % length;
            if (newer == initializedProcess) {
                break;
            }
        }

        System.out.println("Process "
                + process[getmax()].id
                + " becomes coordinator");
        int coord = process[getmax()].id;

        old = coord;
        newer = (old + 1) % length;

        while (true) {

            if (process[newer].active) {
                System.out.println(
                        "Process " + process[old].id
                                + " pass Coordinator(" + coord
                                + ") message to process "
                                + process[newer].id);
                old = newer;
            }
            newer = (newer + 1) % length;
            if (newer == coord) {
                System.out.println("End Of Election ");
                break;
            }
        }
    }

    public int getMax() {
        int Ind = 0;
        int maxId = -9999;
        int i = 0;
        while (i < process.length) {
            if (process[i].active && process[i].id > maxId) {
                maxId = process[i].id;
                Ind = i;
            }
            i++;
        }
        return Ind;
    }
    public int getmax() {
        System.out.println(list);
        int maxId = -9999;
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) > maxId) {
                maxId = list.get(i);
            }
            i++;
        }
        return maxId;
    }

    public static void main(String arg[]) {
        Ring object = new Ring();
        object.beginRing();
        object.Election();
    }
}