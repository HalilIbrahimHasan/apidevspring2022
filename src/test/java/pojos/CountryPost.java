package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryPost {

    private String name;

    public CountryPost() {
    }

    public CountryPost(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryPost{" +
                "name='" + name + '\'' +
                '}';
    }
}
