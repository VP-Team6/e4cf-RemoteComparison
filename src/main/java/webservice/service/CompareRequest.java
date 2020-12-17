package webservice.service;

import webservice.components.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CompareRequest {

    private String uuid;


    private Tree tree1;
    private Tree tree2;

    public CompareRequest(Tree tree1, Tree tree2) {
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.uuid = UUID.randomUUID().toString();
    }

    public Map<String, String> getJson(){
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", getUuid());
        map.put("eta", "0");
        return map;
    }

    public String getUuid() {
        return uuid;
    }

    public Tree getTree1() {
        return tree1;
    }

    public Tree getTree2() {
        return tree2;
    }
}
