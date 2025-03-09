package Cine;

public class Movie {
    private String name;
    private String language;
    private String type;  // 35mm o 3D
    private int duration;
    
    public Movie(String name, String language, String type, int duration) {
        this.name = name;
        this.language = language;
        this.type = type;
        this.duration = duration;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public String getType() {
        return type;
    }
    
    public int getDuration() {
        return duration;
    }
}
