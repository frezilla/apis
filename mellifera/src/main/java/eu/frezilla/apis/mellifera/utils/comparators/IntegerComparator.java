package eu.frezilla.apis.mellifera.utils.comparators;

import java.util.Comparator;

public final class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == null && o2 == null) return 0;
        else if (o1 != null && o2 == null) return 1;
        else if (o1 == null) return -1;
        else return o1.compareTo(o2);
    }
    
}
