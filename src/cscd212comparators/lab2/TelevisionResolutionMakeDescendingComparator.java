package cscd212comparators.lab2;

import cscd212classes.lab2.Television;
import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television>{

    public int compare(Television t1, Television t2) {
        int comp1 = t1.getResolution() - t2.getResolution();
        if(comp1 == 0)
            return t1.getMake().compareTo(t2.getMake());
        else
            return comp1;

    }
}
