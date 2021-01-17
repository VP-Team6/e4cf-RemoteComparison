package webservice.service;

import webservice.components.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Representation of a comparison request
 */
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

    /**
     * Creates a new request from two tree objects
     *
     * @param tree1 First tree
     * @param tree2 Second tree
     */
    public CompareRequest(Tree tree1, Tree tree2) {
        System.out.println(tree1.value1);
        System.out.println(tree2.value1);
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.uuid = UUID.randomUUID().toString();
        this.status = Status.QUEUED;
    }

    /**
     * Creates a representation of a task that contains basic information that is available before a task
     * got added to the queue. (UUID and ETA)
     *
     * @return Map with two elements, UUID and ETA
     */
    public Map<String, String> getInitialJson() {
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", getUuid());
        map.put("eta", "0");
        return map;
    }

    /**
     * Creates a complete representation of a task.
     * This contains the result, if the task is completed.
     *
     * @return status of the task
     */
    public Map<String, String> getStatusJson() {
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", getUuid());
        map.put("status", getStatus().name());
        if (getStatus() == Status.DONE) {
            map.put("time", "0"); // TODO runtime for computation
            map.put("result", tree1.toString()); //TODO actual tree comparison
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
