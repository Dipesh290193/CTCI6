package src.DistributedHashTable;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws UnknownHostException {
        CircularDHT circularDHT = new CircularDHT(4,6);
        List<Integer> ids = circularDHT.ids;
        System.out.println(ids.toString());

        Scanner input = new Scanner(System.in);
        boolean run=true;
        System.out.println("Welcome");
        System.out.println("1.Get All Peer Id");
        System.out.println("2.insert Content");
        System.out.println("3.Get Content");
        System.out.println("4.Add Peer");
        System.out.println("5.Remove Peer");

        while (run) {
            System.out.println("Insert Command:");
            int command = input.nextInt();
            switch(command)
            {
                case 1:
                    System.out.println(ids.toString());
                    break;
                case 2:
                    System.out.println("Insert Key");
                    String key = input.next();
                    System.out.println("Insert Inet Address Name");
                    String value = input.next();
                    InetAddress inetAddress = InetAddress.getByName(value);
                    circularDHT.insertContent(key, inetAddress);
                    System.out.println("Successfully inserted");
                    break;
                case 3:
                    System.out.println("Insert Key:");
                    String ContentKey = input.next();
                    List<InetAddress> content = circularDHT.getContent("Google");
                    //Todo: Implement Download content
                    System.out.println(content.toString());
                    break;
                case 4:
                    System.out.println("Insert Peer Id between 0 to "+circularDHT.n+" :");
                    int peer = input.nextInt();
                    boolean result = circularDHT.addPeer(peer);
                    if(result){
                        System.out.println("Successfully Added");
                    }
                    else{
                        System.out.println("Failed");
                    }
                    break;
                case 5:
                    System.out.println("Remove Peer Id between 0 to "+circularDHT.n+" :");
                    int removePeer = input.nextInt();
                    boolean resultRemove = circularDHT.removePeer(removePeer);
                    if(resultRemove){
                        System.out.println("Successfully");
                    }
                    else{
                        System.out.println("Failed");
                    }
                    break;
                default:
                    System.out.println("Invalid Input exiting");
                    run = false;
                    break;
            }

        }
        input.close();
    }
}
