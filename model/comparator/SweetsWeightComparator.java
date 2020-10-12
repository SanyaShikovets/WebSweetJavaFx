package model.comparator;

import model.sweets.Sweet;
import java.util.Comparator;

/**
 * Performances comparator class of sweet by weight
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */

public class SweetsWeightComparator implements Comparator<Sweet> {
    @Override
    public int compare(Sweet s1, Sweet s2) {
        return Double.compare(s1.getWeight(), s2.getWeight());
    }
}
