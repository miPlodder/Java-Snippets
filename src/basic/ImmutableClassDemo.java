package basic;

import java.util.HashMap;
import java.util.Map;

/**
 * In java, immutable class means that once an object is created, we cannot change it's object
 * For eg, Integer, String etc
 * <p>
 * 1 -> Make class `final`
 * 2 -> Make data variables `final`
 * 3 -> Make data variables `private`
 * 4 -> Initialize these data variables in the constructors by creating a deep copy of the object (like hashmap in below example)
 * 5 -> Create getters for these data variables and return a deep copy of the object (like hashmap in below example)
 */
public /*1*/ final class ImmutableClassDemo {

    /*2*/ private /*3*/ final long id;
    /*2*/private /*3*/ final String description;

    private final Map<String, String> map;

    /*4*/
    public ImmutableClassDemo(long id, String description, Map<String, String> map) {
        this.id = id;
        this.description = description;

        this.map = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    /*5*/
    public long getId() {
        return this.id;
    }

    /*5*/
    public String getDescription() {
        return this.description;
    }

    /*5*/
    public Map<String, String> getMap() {
        Map<String, String> temp = new HashMap<>();
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            temp.put(entry.getKey(), entry.getValue());
        }
        return temp;
    }

}
