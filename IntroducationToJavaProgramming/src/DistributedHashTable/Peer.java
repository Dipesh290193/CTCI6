package src.DistributedHashTable;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Peer {
    int id;
    Peer predecessor;
    Peer successor;
    Map<String, List<InetAddress>> content = new HashMap<>();

    public Peer(int id){
        this.id = id;
    }

    public void insert(String key, InetAddress inetAddress){
        if(content.get(key) == null){
            content.put(key, new ArrayList<>());
        }
        content.get(key).add(inetAddress);
    }

    public List<InetAddress> retrive(String key){
        return content.get(key);
    }
}
