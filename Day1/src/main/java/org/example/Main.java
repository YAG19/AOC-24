package org.example;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("input_day_1.txt");

        if(is == null) throw new FileNotFoundException();

        Scanner sc = new Scanner(is);
        //Part1
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        //Part2
        Map<Integer, Integer> rightSideMap = new HashMap<>();

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split("   ");
            String leftSideNum = input[0];
            String rightSideNum = input[1];
            leftSide.add(Integer.parseInt(leftSideNum));
            rightSide.add(Integer.parseInt(rightSideNum));

            //Part2
            int rightSideNumInt = Integer.parseInt(rightSideNum);
            if(rightSideMap.containsKey(rightSideNumInt)){
                rightSideMap.put(rightSideNumInt, rightSideMap.get(rightSideNumInt) + 1);
            }else{
                rightSideMap.put(rightSideNumInt, 1);
            }
        }
        Collections.sort(leftSide);
        Collections.sort(rightSide);
        int sum = 0;
        long sumPart2 = 0;

        for(int i=0;i < leftSide.size(); i++){
            //Part1
            int diff = leftSide.get(i) - rightSide.get(i);
            if(diff < 0) diff*= -1;
            sum+= diff;

            //Part2
            if(rightSideMap.containsKey(leftSide.get(i))){
                long multi = (long) leftSide.get(i) * rightSideMap.get(leftSide.get(i));
                sumPart2 += multi;
            }
        }
        System.out.println("Part1 " + sum);
        System.out.println("Part1 "+ sumPart2);
    }
}