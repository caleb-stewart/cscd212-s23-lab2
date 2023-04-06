package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {

    public int compare(Television t1, Television t2) {
        if(t1 == null || t2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");
        int comp1 = t1.getModel().compareTo(t2.getModel());
        int comp2 = t1.getScreenSize() - t2.getScreenSize();
        if(comp1 == 0) {
            return comp2;
        }
        else return comp1;
        }

    }

