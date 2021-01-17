package webservice.processing;

import webservice.service.CompareRequest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue to manage and schedule all incoming compare requests.
 * This dummy implementation marks all tasks as completed without actually comparing them.
 * <p>
 * NOTE: Currently not fully functional! Only to showcase the application.
 */
public class RequestQueue {
    Queue<CompareRequest> requestQueue = new LinkedList<CompareRequest>();

    /**
     * Adds a rew request to the queue.
     *
     * @param r CompareRequest that will be added.
     */
    public void add(CompareRequest r) {
        r.setStatus(CompareRequest.Status.DONE);
        this.requestQueue.add(r);
    }

    /**
     * Searches for a task by its UUID.
     *
     * @param uuid UUID of the requested task
     * @return CompareRequest object of the task, or null if none can be found
     */
    public CompareRequest getByUUID(String uuid) {
        for (CompareRequest request : this.requestQueue) {
            if (request.getUuid().equals(uuid)) {
                return request;
            }
        }
        return null;
    }
}

