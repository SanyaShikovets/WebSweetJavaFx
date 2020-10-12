package model.sweets;

/**
 * class which describes sweet
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */

public class Sweet {

    /**
     * name of sweet
     */
    private String name;

    /**
     * weight of sweet
     */
    private double weight;

    /**
     * Constructor, creates sweet with name and weight
     *
     * @param name            name of sweet
     * @param weight           weight of sweet
     * @throws IllegalArgumentException if weight is bellow 0
     */

    public Sweet(String name, double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.weight = weight;
    }

    /**
     * getter of name
     *
     * @return name of sweet
     */
    public String getName() {
        return name;
    }

    /**
     * getter of weight
     *
     * @return weight of sweet
     */
    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return "Name sweet: " + name + " Weight: " + weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Sweet sweets = (Sweet) obj;

        return weight == sweets.weight
                && name.equals(sweets.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result += 31 * weight;
        return result;
    }
}
