package kea.dat22v2.mdd.eksamen3sem.app.api;


import kea.dat22v2.mdd.eksamen3sem.app.exception.AttendeeNotFoundException;
import kea.dat22v2.mdd.eksamen3sem.app.exception.EventAtCapacityException;
import kea.dat22v2.mdd.eksamen3sem.app.exception.EventNotFoundException;
import kea.dat22v2.mdd.eksamen3sem.app.exception.NotYetImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotYetImplementedException.class)
    public ResponseEntity<Object> handleNotImplementedException(NotYetImplementedException ex) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Object> handleEventNotFoundException(EventNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
    }
    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity<Object> handleAttendeeNotFoundException(AttendeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
    }
    @ExceptionHandler(EventAtCapacityException.class)
    public ResponseEntity<Object> handleEventAtCapacityException(EventAtCapacityException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", ex.getMessage()));
    }




}