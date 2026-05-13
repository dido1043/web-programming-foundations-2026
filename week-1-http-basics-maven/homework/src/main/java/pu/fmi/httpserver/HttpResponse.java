package pu.fmi.httpserver;

public class HttpResponse<T> {

    private HttpStatus httpStatus;
    private T result;

    public HttpResponse(HttpStatus httpStatus, T result){
        this.httpStatus = httpStatus;
        this.result = result;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
