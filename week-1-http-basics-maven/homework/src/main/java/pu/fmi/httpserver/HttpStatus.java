package pu.fmi.httpserver;

public enum HttpStatus {
    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    NOT_FOUND(404, "Not found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed");

    private int code;
    private String phrase;

    HttpStatus(int code, String phrase){
        this.code = code;
        this.phrase = phrase;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
