package webservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import webservice.exceptions.InvalidRequestException;
import webservice.exceptions.RequestNotFoundException;
import webservice.processing.RequestQueue;
import webservice.components.Tree;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * REST Controller for all API endpoints
 */
@RestController
public class CompareController {

    private RequestQueue rq = new RequestQueue();

    /**
     * Processes new compare requests and adds them the the queue
     *
     * @param requestData Payload of the POST request
     * @return Json that contains the UUID of the new task and an estimated eta
     */
    @RequestMapping(method = RequestMethod.POST, value = "/createRequest")
    public Map<String, String> register(@RequestBody String requestData) {
        CompareRequest compareRequest;
        try {
            System.out.println();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(requestData);
            compareRequest = new CompareRequest(new Tree(root.get(0)), new Tree(root.get(1)));
        } catch (Exception e) {
            throw new InvalidRequestException();
        }
        this.rq.add(compareRequest);
        return compareRequest.getInitialJson();
    }

    /**
     * Retrieves the status of a task
     *
     * @param uuid UUID that was return when the task was created
     * @return Status of the task (QUEUED, RUNNING, DONE, ERROR) and the result (only if the task is DONE)
     */
    @RequestMapping(method = RequestMethod.GET, value = "/status", produces = APPLICATION_JSON_VALUE)
    public Map<String, String> status(@RequestParam(value = "uuid") String uuid) {
        CompareRequest result = this.rq.getByUUID(uuid);
        if (result != null) {
            return result.getStatusJson();
        } else {
            throw new RequestNotFoundException();
        }
    }
}
