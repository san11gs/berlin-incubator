package incubator.spring_flex.domain;

import java.io.Serializable;

/**
 * Topping entity.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public class Topping implements Serializable {

    private Long id;

    private String name;

    /*
     * getter & setter
     */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
