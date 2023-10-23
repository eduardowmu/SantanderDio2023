package dio.me.edu.exception;

import dio.me.edu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException businessException) {
        logger.error(businessException.getMessage());
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(NoSuchElementException businessException) {
        logger.error(businessException.getMessage());
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable unexpectedException) {
        logger.error(unexpectedException.getMessage());
        return new ResponseEntity<>("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}