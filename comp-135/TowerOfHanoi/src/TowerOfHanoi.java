public class TowerOfHanoi {

    public static void towerCalc(int diskCount, char currentRod, char nextRod, char extraRod) {
        if (diskCount > 1) {            // lower number = smaller disk
            towerCalc(diskCount - 1, currentRod, extraRod, nextRod);        // calls itself while decreasing disk count
            System.out.println("Move disk " + diskCount + " from rod " + currentRod + " to rod " + nextRod);
            towerCalc(diskCount - 1, extraRod, nextRod, currentRod);        // updates after disk has been moved
        }
        else {
            System.out.println("Move disk 1 from rod " + currentRod + " to rod " + nextRod);    // for moving disk one (smallest one)
        }
    }

    public static void main(String[] args) {
        int diskCount = 3;      // total number of disks, used to display which disk is being moved
        towerCalc(diskCount, 'A', 'C', 'B');        // name of rods, in order of A, C, B because of order moved. (ex: disk one has to go to rod c on the first move, which is the next rod)
    }
}
