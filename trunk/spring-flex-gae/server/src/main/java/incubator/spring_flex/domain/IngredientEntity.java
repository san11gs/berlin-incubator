package incubator.spring_flex.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

/**
 * Topping entity.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Table(name = "ingredient")
@Entity
public class IngredientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    private String name;

    public IngredientEntity(){ }
    
    public IngredientEntity(String name){
        this.name = name;
    }
    
    /*
     * getter & setter
     */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

}
