package oreily.tasks.parallel;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

public class pickFruitsWithInvokeAll {

    public static void main(String[] args) {
    //Create six trees.
        AppleTree[] appleTrees = AppleTree.newAppleTreesGarden(6);
        //Create workers to pick apples from diff trees.
        Callable<Void> appPick1 = createApplePickers(appleTrees,0,2,"Alex");
        Callable<Void> appPick2 = createApplePickers(appleTrees,2,4,"Bob");
        Callable<Void> appPick3 = createApplePickers(appleTrees,4,6,"Carol");

        //invoke all method needs a collection.So create a list for existing apple pickers.
        ForkJoinPool.commonPool().invokeAll(Arrays.asList(appPick1,appPick2,appPick3));
        System.out.println();
        System.out.println("All fruits collected!");
    }

    public static Callable<Void> createApplePickers(AppleTree[] trees, int fromTree,
                                                    int toTree, String workername){
        return () -> {
            for(int i =fromTree; i<toTree;i++){
                trees[i].pickApple(workername);
            }
            return null;
        };
    }
}
