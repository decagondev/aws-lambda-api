package lambdaaws.api;

import java.util.List;

public class Request {
    private String id;
    private String name;
    private String username;
    private Operation operation;
    private List<String> characters;

    // Getters and setters


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

    public lambdaaws.api.Request.Operation getOperation() {
        return operation;
    }

    public void setOperation(lambdaaws.api.Request.Operation operation) {
        this.operation = operation;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public enum Operation {
        CREATE, READ, UPDATE, DELETE
    }
}

