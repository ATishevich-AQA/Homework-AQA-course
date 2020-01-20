package Parsers.model;

public class Country {
    private int id;
    private String name;
    private String code;
    private String description;
    private int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Country:: ID=" + this.id + " Code=" + this.code + " Name=" + this.name + " Description=" +
                this.description;
    }
}
