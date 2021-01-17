package webservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that indicates that a createRequest contained invalid or missing data
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")  // 404
public class InvalidRequestException extends RuntimeException {
}
