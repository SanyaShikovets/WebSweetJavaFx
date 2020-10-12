package model.present;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import model.comparator.SweetsNameComparator;
import model.comparator.SweetsWeightComparator;
import model.sweets.Sweet;

/**
 * class which describes present
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */

public class Present {

    /**
     * list of stored sweet
     */
    private List<Sweet> present;

    /**
     * Constructor that create present
     */
    public Present(){
        present = new ArrayList<>();
    }

    /**
     * add medicine to medicines list
     *
     * @param sweets sweet to add to list
     */
    public void addSweet(Sweet sweets) {
        present.add(sweets);
    }

    /**
     * getter of present
     *
     * @return sweet list
     */
    public List<Sweet> getPresent() {
        return present;
    }

    /**
     * count the total weight of present
     *
     * @return totalPrice
     */
    public double countTotalWeight() {
        double totalWeight = 0;
        for (Sweet sw : present) {
            totalWeight += sw.getWeight();
        }
        return totalWeight;
    }

    /**
     * sort sweet by name
     *
     * @return sorted present list
     */
    public TreeSet<Sweet> sortSweetByName() {
        Comparator<Sweet> scomp = new SweetsNameComparator();
        TreeSet<Sweet> sSort = new TreeSet<>(scomp);
        for(Sweet s: present){
            sSort.add(s);
        }
        return sSort;
    }

    /**
     * sort sweet by weight
     *
     * @return sorted present list
     */
    public TreeSet<Sweet> sortSweetByWeight() {
        Comparator<Sweet> scomp = new SweetsWeightComparator();
        TreeSet<Sweet> sSort = new TreeSet<>(scomp);
        for(Sweet s: present){
            sSort.add(s);
        }
        return sSort;
    }

    /**
     * select items between weights
     *
     * @param minWeight some list
     * @param maxWeight some list
     * @return selected present list
     */
    public List<Sweet> selectSweetByWeightRange(double minWeight, double maxWeight) {
        return present.stream()
                .filter(sweet -> sweet.getWeight() >= minWeight && sweet.getWeight() <= maxWeight)
                .collect(Collectors.toList());
    }

    /**
     * select items equal to weight
     *
     * @param weight some list
     * @return selected present list
     */
    public List<Sweet> selectSweetByWeight(double weight) {
        return selectSweetByWeightRange(weight, weight);
    }

    /**
     * select items by name
     *
     * @param name name of medicine
     * @return selected present list
     */
    public List<Sweet> selectSweetByName(String name) {
        return present.stream()
                .filter(sweet -> sweet.getName().equals(name))
                .collect(Collectors.toList());
    }

}
