package Futronic.config;

public class Request {
    private String request;

    public Request(String chatname) {
        this.request = chatname;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String chatname) {
        this.request = request;
    }
}
