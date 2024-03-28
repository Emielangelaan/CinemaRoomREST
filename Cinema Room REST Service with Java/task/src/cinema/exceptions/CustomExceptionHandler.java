package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class CustomExceptionHandler{

    @ExceptionHandler(UnavailableSeatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ExceptionError handleUnavailableSeat(UnavailableSeatException e) {
        return new ExceptionError(e.getMessage());
    }

    @ExceptionHandler(OutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ExceptionError handleOutOfBounds(OutOfBoundsException e) {
        return new ExceptionError(e.getMessage());
    }

    @ExceptionHandler(WrongTokenException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ExceptionError handleWrongToken(WrongTokenException e) {
        return new ExceptionError(e.getMessage());
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    private ExceptionError handleWrongPassword(WrongPasswordException e) {
        return new ExceptionError(e.getMessage());
    }
}