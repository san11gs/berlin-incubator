package incubator.spring_faces.model;

import java.io.Serializable;

/**
 * Bean wrapper class for the phone number used by the search.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public class PhoneSearch implements Serializable {

    private String number;

    public void reset() {
        this.number = "";
    }

    /*
     * getter & setter
     */

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
