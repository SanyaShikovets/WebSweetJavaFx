package model.comparator;

import model.sweets.Sweet;
import java.util.Comparator;

/**
 * Performances comparator class of sweet by name
 *
 * @author Sasha Shikovets
 * @version 1.0.0
 */

public class SweetsNameComparator implements Comparator<Sweet> {
    @Override
    public int compare(Sweet s1, Sweet s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
