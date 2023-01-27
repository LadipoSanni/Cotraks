package exceptions.classs;

import lombok.Getter;

public class CtsException extends RuntimeException{



        @Getter
        private int statusCode;
        public CtsException(String message) {
            super(message);
        }

        public CtsException(String message, int statusCode) {
            super(message);
            this.statusCode = statusCode;
        }
    }


