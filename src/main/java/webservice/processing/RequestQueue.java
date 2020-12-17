package webservice.processing;

import webservice.service.CompareRequest;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    Queue<CompareRequest> requestQueue = new LinkedList<CompareRequest>();

    public Queue<CompareRequest> getQueue() {
        return this.requestQueue;
    }

    public void add(CompareRequest r){
        this.requestQueue.add(r);
    }
}

