package MUtility;

import java.util.Arrays;
import java.util.stream.Stream;

public class Driver {
    public static void sortByMachineID(Node[] nodeList) {
        // implement selection or bubble sort on Node's ID values
        for(int i=1; i<nodeList.length; i++) {
            for(int j=0; j<nodeList.length-1; j++) {
                if(nodeList[j].machineID > nodeList[j+1].machineID) {
                    int temp = nodeList[j+1].machineID;
                    nodeList[j+1].machineID = nodeList[j].machineID;
                    nodeList[j].machineID = temp;
                }
            }
        }
    }

    public static void sortByMachineName(Node[] nodeList) {
        // implement selection or bubble sort on Node's ID values
        for(int i=0; i < nodeList.length-1; i++) {
            for (int j = i+1; j < nodeList.length; j++) {
                if(nodeList[i].machineName.compareTo(nodeList[j].machineName) > 0) {
                    Node temp = nodeList[i];
                    nodeList[i] = nodeList[j];
                    nodeList[j] = temp;
                }
            }
        }
    }

    public static boolean searchByMachineName(Node[] nodeList, String searchName) {
        for(int i=0; i < nodeList.length-1; i++) {
            if(nodeList[i].machineName.equals(searchName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchByMachineID(Node[] nodeList, int searchID, int first, int last) {
        int mid = (first + last) / 2;
        while(first <= last) {
            if(nodeList[mid].machineID < searchID) {
                first = mid + 1;
            }
            else if(nodeList[mid].machineID == searchID) {
                return true;
            }
            else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return false;
        // implement binary search on Node's name
    }

    public static void main(String args[]) {
        Node[] myNodes = new Node[6]; // declare 6 nodes
        String searchName = "RagingWaters";
        int searchID = 88;
        int length = myNodes.length;

        for (int i=0; i<6; i++)
            myNodes[i] = new Node(); // initialize nodes

        myNodes[0].setNode("RagingWaters", 243);
        myNodes[1].setNode("ChangingMars", 123);
        myNodes[2].setNode("BlazingSun", 85);
        myNodes[3].setNode("FoolishJohnny", 367);
        myNodes[4].setNode("ShinyMadmen", 456);
        myNodes[5].setNode("FirecrackerBluejay", 25);

        //sortByMachineID(myNodes);
        //sortByMachineName(myNodes);
        //System.out.println(searchByMachineName(myNodes, searchName));
        //System.out.println(searchByMachineID(myNodes,searchID, 0, length));
        //Node.printNode(myNodes);

    }
}

class Node {
    String machineName;
    int machineID;

    void setNode(String mName, int mID) {
        machineName = mName;
        machineID = mID;
    }

    String getNodeName(int mID) {
        if(mID == machineID) return machineName;
        else return "Not Found";
    }

    public static void printNode(Node[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println("Node Name is : " + n[i].machineName);
            System.out.println("Node ID is : " + n[i].machineID);
        }
    }
}
