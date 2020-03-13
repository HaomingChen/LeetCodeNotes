package data_structure.SegmentTree;

public interface Merge<E> {

    //merge child of this root
    E merge(E a, E b);

}
