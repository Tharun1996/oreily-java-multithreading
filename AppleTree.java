package oreily.tasks.parallel;

import java.util.concurrent.TimeUnit;

public class AppleTree {

    public static AppleTree[] newAppleTreesGarden(int size){
        AppleTree[] appleTrees = new AppleTree[size];
        for(int i=0;i<appleTrees.length;i++){
            appleTrees[i] = new AppleTree("AppleTree#" + i);
        }

        return appleTrees;
    }

    private final String appleTreeLabel;
    private final int numberOfApples;

    public AppleTree(String name){
        appleTreeLabel = name;
        numberOfApples = 3;
    }

    public int pickApple(String workerName){

        try{
            System.out.printf("%s started picking apples from %s. The thread is %s \n",workerName
            ,appleTreeLabel,Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%s picked %d apples from %s \n",workerName,numberOfApples, appleTreeLabel);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return numberOfApples;
    }
}
