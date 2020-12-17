package webservice.processing;

import webservice.service.CompareRequest;

import java.util.LinkedList;
import java.util.Queue;


public class RequestQueue {
    Queue<CompareRequest> requestQueue = new LinkedList<CompareRequest>();


    public void add(CompareRequest r) {
        this.requestQueue.add(r);
    }

    public CompareRequest getByUUID(String uuid){
        for (CompareRequest request : getQueue()) {
            if (request.getUuid().equals(uuid)) {
                return request;
            }
        }
        return null;
    }

    public Queue<CompareRequest> getQueue() {
        return this.requestQueue;
    }
}

