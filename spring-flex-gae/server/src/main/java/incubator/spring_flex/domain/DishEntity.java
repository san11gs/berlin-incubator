package incubator.spring_flex.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

@Table(name = "dish")
@Entity
@MappedSuperclass
public abstract class DishEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    private String name;

    private double price;

    /**
     * Unidirectional ont-to-many association to {@link IngredientEntity}.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "fid_ingredient")
    private Collection<IngredientEntity> ingredients;
    
    /*
     * Getter & Setter 
     */
    
    public Key getKey() {
        
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Collection<IngredientEntity> getIngredients() {
        if(this.ingredients == null){
            this.ingredients = new ArrayList<IngredientEntity>();         
        }
        return this.ingredients;
    }

    public void setIngredients(Collection<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

}
