package src.DistributedHashTable;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularDHT {
    Peer root;
    int numberOfPeers ;
    int n;
    List<Integer> ids;


    public CircularDHT(int n, int numberOfPeers){
        this.numberOfPeers = numberOfPeers;
        this.n = (int)Math.pow(2,n) -1;
        createPeersIds();
    }

    private void createPeersIds(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<this.n+1; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        ids = new ArrayList<>(this.numberOfPeers);
        for (int i=0; i<this.numberOfPeers; i++) {
            ids.add(i,list.get(i));
        }
        Collections.sort(ids);
        createPeers(ids);
    }

    private void createPeers(List<Integer> list){
        this.root = new Peer(list.get(0));
        Peer predecessor = root;
        for(int i = 1; i < list.size()-1; i++){
            Peer peer = new Peer(list.get(i));
            predecessor.successor = peer;
            peer.predecessor = predecessor;
            //predecessor = peer;
            Peer nextPeer = new Peer(list.get(++i));
            peer.successor = nextPeer;
            nextPeer.predecessor = peer;
            predecessor = nextPeer;
        }
        Peer lastPeer = new Peer(list.get(list.size()-1));
        predecessor.successor = lastPeer;
        lastPeer.predecessor = predecessor;
        lastPeer.successor = this.root;
        this.root.predecessor = lastPeer;
    }

    public void insertContent(String key, InetAddress ipAddress){
        int keyId = hashCode(key);
        Peer closet = findClosetsPeer(keyId);
        closet.insert(key, ipAddress);
    }

    public List<InetAddress> getContent(String key){
        int keyId = hashCode(key);
        Peer closet = findClosetsPeer(keyId);
        List<InetAddress> inetAddresses = new ArrayList<>();
        List<InetAddress> closetContent =   closet.content.get(key);
        if(closetContent != null)
            inetAddresses.addAll(closetContent);
        List<InetAddress> successorContent =   closet.successor.content.get(key);
        if(successorContent != null)
        inetAddresses.addAll(successorContent);
        List<InetAddress> predecessorContent =   closet.successor.content.get(key);
        if(predecessorContent != null)
            inetAddresses.addAll(predecessorContent);
        return inetAddresses;
    }

    public boolean addPeer(int peerId){
        if(peerId < 1 || peerId > n){
            return false;
        }
        Peer peer = new Peer(peerId);
        Peer closets = findClosetsPeer(peerId);
        if(peer.id != closets.id){
            peer.successor = closets;
            peer.predecessor = closets.predecessor;
            closets.predecessor.successor = peer;
            closets.predecessor = peer;
            ids.add(peerId);
            Collections.sort(ids);
            if(closets.id == this.root.id)
                this.root = peer;
            return true;
        }
        return false;
    }

    public boolean removePeer(int peerId){
        if(peerId < 1 || peerId > n){
            return false;
        }
        Peer peer = findPeer(peerId);
        if(peer != null){
            peer.successor.predecessor = peer.predecessor;
            peer.predecessor.successor = peer.successor;
            peer=null;
            ids.remove(ids.indexOf(peerId));
            return true;
        }
        return false;
    }

    private Peer findPeer(int key){
        if(key == this.root.id)
            return this.root;
        Peer next = this.root.successor;
        while(this.root != next && next != null){
            if(next.id == key){
                return next;
            }
            next = next.successor;
        }
        return null;
    }

    private Peer findClosetsPeer(int key){
        if(this.root.id >= key)
            return this.root;
        Peer next = this.root.successor;
        while(this.root != next &&next != null){
            if(next.id >= key){
                return next;
            }
            next = next.successor;
        }
        return this.root.predecessor;
    }

    private int hashCode(String key){
        int hash = 23;
        for(char c : key.toCharArray()){
            hash = hash*31 + c;
        }
        return hash % n;
    }

}
