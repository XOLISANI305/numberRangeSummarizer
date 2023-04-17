// NAME : XOLISANI
// SURNAME : JAMJAM

package com.numberRangeSummarizer;
import numberRangeSummarizer.NumberRangeSummarizer;
import java.util.*;

class NumberSummarizerImpl implements NumberRangeSummarizer
{
    public static void main(String[] args)
    {
        var numb = new NumberSummarizerImpl();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Collection<Integer> collectionInput = numb.collect(input);
        String range = numb.summarizeCollection(collectionInput);

        System.out.println("------------------------------------------");
        System.out.println("My new numbers are as folow ->");
        System.out.println(range);
        System.out.println("------------------------------------------");


    }
    //collect the input
    public Collection<Integer> collect(String input) {
        var myStringArray = input.split(",");//Separate the numbers with ","
        int len = myStringArray.length;
        int[] myArray = new int[len];

        {int i = 0;
            while (i < len) {
                myArray[i] = Integer.parseInt(myStringArray[i]);
                i++;
            }
        }Arrays.sort(myArray);
        ArrayList<Integer> my_list = new ArrayList<>();

        for (int i = 0; i <len; i++) {
            my_list.add(myArray[i]);

        }
        return my_list;

    }
    public String summarizeCollection(Collection<Integer> input) {
        var subStr = new StringBuilder();
        ArrayList<Integer> inputList = new ArrayList<>(input);
        int length = inputList.size();
        int count = 0;

        int i = 0;
        while (i < length) {
            if (i == length - 1)
            {
                if (inputList.get(length - 2) == inputList.get(length - 1)) {
                } else {
                    subStr.append(inputList.get(i)).append(",");
                }
                break;
            }

            int start = inputList.get(i);
            int next = inputList.get(i + 1);
            if (next != start + 1) {
                subStr.append(start).append(", ");
            } else {
                count++;
                int lowestBound = start;
                for (int x = i + 1; ; x++)
                {
                    start = inputList.get(x);
                    next = inputList.get(x + 1);

                    if (next == start + 1)
                        count++;
                    else
                    {
                        i = x;
                        if (count != 0) {
                            subStr.append(lowestBound).append(" - ").append(inputList.get(i)).append(", ");
                        }
                        break;
                    }
                }
                count = 0;
            }
            i++;
        }

        var ranges = subStr.toString();
        return ranges.substring(0, ranges.length() - 1);
    }
}