package webservice.service;

import org.springframework.web.bind.annotation.*;
import webservice.exceptions.InvalidRequestException;
import webservice.exceptions.RequestNotFoundException;
import webservice.processing.RequestQueue;
import webservice.components.Tree;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CompareController {

    private RequestQueue rq = new RequestQueue();

    @RequestMapping(method = RequestMethod.POST, value = "/createRequest")
    public Map<String, String> register(@RequestBody List<Tree> requestData) {
        CompareRequest compareRequest;
        try {
            compareRequest = new CompareRequest(requestData.get(0), requestData.get(1));
        } catch (Exception e) {
            throw new InvalidRequestException();
        }
        this.rq.add(compareRequest);
        return compareRequest.getInitialJson();
    }

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
