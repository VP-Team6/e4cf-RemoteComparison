package webservice.service;

import webservice.components.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CompareRequest {

    private String uuid;

    public enum Status {
        DONE,
        RUNNING,
        QUEUED,
        ERROR
    }

    private Status status;
    private Tree tree1;
    private Tree tree2;


    public CompareRequest(Tree tree1, Tree tree2) {
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.uuid = UUID.randomUUID().toString();
        this.status = Status.QUEUED;
    }

    public Map<String, String> getInitialJson() {
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", getUuid());
        map.put("eta", "0");
        return map;
    }

    public Map<String, String> getStatusJson() {
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", getUuid());
        map.put("status", getStatus().name());
        if (getStatus() == Status.DONE) {
            map.put("time", "0"); // TODO runtime for computation
            map.put("result", tree1.value1); //TODO actual tree comparison
        }
        return map;
    }

    public void setStatus(Status newStatus) {
        this.status = newStatus;
    }

    public Status getStatus() {
        return this.status;
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
