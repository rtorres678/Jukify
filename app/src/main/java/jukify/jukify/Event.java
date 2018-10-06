package jukify.jukify;

public class Event {

    private String name;
    private String host;
    private String id;

    public Event(String name, String host, String id) {
        this.name = name;
        this.host = host;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
