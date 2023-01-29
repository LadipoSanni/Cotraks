package exceptions.handler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiError {
    private LocalDateTime timeStamp;
    private String status;
    private String message;
    private String path;

    @Builder
    public ApiError(LocalDateTime timeStamp, String status, String message, String request) {
        LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.path = request;
    }
}

