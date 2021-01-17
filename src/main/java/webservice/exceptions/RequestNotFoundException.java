package webservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that indicates that a queried request does not exist.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Request")  // 404
public class RequestNotFoundException extends RuntimeException {
}
