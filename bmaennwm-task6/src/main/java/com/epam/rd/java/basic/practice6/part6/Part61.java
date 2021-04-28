package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.Demo;

import java.util.*;

public class Part61 {

    String content;

    TreeMap<String, Integer> words = new TreeMap<>();
    List<String> order = new ArrayList<>();

    public Part61(String text) {
        this.content = text;
    }

    public void process() {
        Arrays.stream(content.replace(System.lineSeparator(), " ").split(" ")).forEach(word->{
            if(words.containsKey(word)) {
                words.put(word, words.get(word)+1);
            }else {
                words.put(word, 1);
            }
            if(!order.contains(word)) {
                order.add(word);
            }
        });
        Comparator<? super Map.Entry<String, Integer>> comp = ((o1, o2)->{
            if(Integer.compare(o2.getValue(), o1.getValue())!=0) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
            return Integer.compare(order.indexOf(o1.getKey()), order.indexOf(o2.getKey()));
        });
        words.entrySet().stream().sorted(comp).limit(3).sorted((o1, o2)->o2.getKey().compareTo(o1.getKey())).forEach(entry-> Demo.println(entry.getKey()+" ==> "+entry.getValue()));
    }

}
