package lambdaaws.api;

import java.util.List;

public class Response {
    private String id;
    private String name;
    private String username;
    private List<String> characters;
    private String message;

    // Constructors, getters, and setters


    public Response(String id, String name, String username, List<String> characters, String message) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.characters = characters;
        this.message = message;
    }

    public Response(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

