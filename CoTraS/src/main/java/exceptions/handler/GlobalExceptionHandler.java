package exceptions.handler;


import exceptions.classs.CtsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CtsException.class})
    protected ResponseEntity<?> handleConflict(
            CtsException ex, WebRequest request) {
        ApiError apiError = new ApiError(LocalDateTime.now(),"400","Bad Request", HttpServletRequest.BASIC_AUTH  );
        apiError.setStatus("Failure");
        apiError.setMessage(ex.getMessage());
        String bodyOfResponse = apiError.toString();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
