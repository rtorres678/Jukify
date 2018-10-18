package jukify.jukify;

import java.io.Serializable;

public class Event implements Serializable {

    private String name;
    private String host;
    private String id;

    public Event(String name, String host, String id) {
        this.name = name;
        this.host = host;
        this.id = id;
    }

    public Event(String name)
    {
        this.name = name;
        this.host = "host";
        this.id = "1234";
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
