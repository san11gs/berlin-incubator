package incubator.spring_flex.dto;

import java.io.Serializable;

public class Ingredient implements Serializable {

    private String key;

    private String name;

    /*
     * getter & setter
     */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
