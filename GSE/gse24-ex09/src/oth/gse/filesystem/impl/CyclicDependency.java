package oth.gse.filesystem.impl;

public class CyclicDependency extends Exception {
    public CyclicDependency(String message) {
        super(message);
    }
    // check CyclicDependency with two pointers
    public static void cyclicDependencyCheck(Resource child, Folder newParent) throws CyclicDependency{
        if (!(child instanceof Folder)){
            return;
        }
        while (newParent != null) {
            if (newParent==child) {
                throw new CyclicDependency("Cyclic dependency detected");
            }
            newParent = newParent.getFolder();
        }
    }
}
