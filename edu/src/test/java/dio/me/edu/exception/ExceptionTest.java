package dio.me.edu.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.rmi.UnexpectedException;
import java.util.NoSuchElementException;

@ExtendWith(SpringExtension.class)
public class ExceptionTest {
    @Mock
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void handleIllegalArgumentExceptionTest() {
        Assertions.assertNotNull(globalExceptionHandler.handle(new IllegalArgumentException()));
    }

    @Test
    void handleNoSuchElementExceptionTest() {
        Assertions.assertNotNull(globalExceptionHandler.handle(new NoSuchElementException()));
    }

    @Test
    void handleUnexpectedExceptionTest() {
        Assertions.assertNotNull(globalExceptionHandler.handle(new Throwable()));
    }
}