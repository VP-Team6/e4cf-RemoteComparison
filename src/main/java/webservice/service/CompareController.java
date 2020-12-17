package webservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.POST, value = "/createRequest", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody List<Tree> requestData) {
        CompareRequest compareRequest = null;
        try {
            compareRequest = new CompareRequest(requestData.get(0), requestData.get(1));
        } catch (Exception e) {
            throw new InvalidRequestException();
        }

        // TODO
        RequestQueue rq = new RequestQueue();
        rq.add(compareRequest);
        //return status(compareRequest.getUuid());
        return new ResponseEntity<String>(compareRequest.getUuid(), HttpStatus.OK);
    }

    @GetMapping(value = "/status", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> status(@RequestParam(value = "uuid") String uuid) {
        RequestQueue rq = new RequestQueue();
        for (CompareRequest request : rq.getQueue()) {
            if (request.getUuid().equals(uuid)) {
                // TODO
                return new ResponseEntity<String>("TODO", HttpStatus.OK);
                //return new CompareRequestStatus();
            }
        }
        // TODO
        throw new RequestNotFoundException();
    }
}
