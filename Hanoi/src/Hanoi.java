/**
 * Created by zw on 2/9/16.
 * The goal of the puzzle is to move all of the disks from their original (first) peg to the destination (third) peg. We can use the “extra” peg as a temporary place to put disks, but we must obey the following three rules:
 * We can move only one disk at a time.
 * We cannot place a larger disk on top of a smaller disk.
 * All disks must be on some peg except for the disk in transit between pegs.
 */
public class Hanoi {
    private int diskNumber;


    public static void main(String[] args) {
        Hanoi han = new Hanoi(5);
        han.solve();
    }

    public void setDiskNumber(int diskNumber) {
        this.diskNumber = diskNumber;
    }

    public Hanoi(int diskNum) {
        this.diskNumber = diskNum;
    }

    public void solve() {
        move(this.diskNumber, "A", "B", "C");
    }

    private void move(int numberOfDisk, String original, String desination, String extra) {
        /**
         * Move the topmost N–1 disks from the original peg to the extra peg.
         * Move the largest disk from the original peg to the destination peg.
         * Move the N–1 disks from the extra peg to the destination peg.
         * */
        if (numberOfDisk == 1) {
            moveOneDisk(original, desination);
        } else {
            move(numberOfDisk-1, original, extra, desination);
            moveOneDisk(original, desination);
            move(numberOfDisk-1, extra, desination, original);
        }
    }

    private void moveOneDisk(String start, String end) {
        System.out.println("Move one disk from " + start + " " + end);
    }
}
