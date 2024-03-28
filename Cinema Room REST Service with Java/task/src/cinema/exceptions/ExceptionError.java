package cinema.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionError {
    @JsonProperty("error")
    private String error;

    public String getError() {
        return error;
    }
    public ExceptionError() {}

    public void setError(String error) {
        this.error = error;
    }
    public ExceptionError(String error) {
        this.error = error;
    }
}