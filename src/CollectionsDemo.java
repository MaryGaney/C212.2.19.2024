import java.util.*;

public class CollectionsDemo {
    /**
     * print a linked list
     * @param list
     */
    public static void printLinkedList(LinkedList<String> list){
        for (String l : list){
            System.out.print(l + " ");
        }
        System.out.println();
    }

    public static void reverseLinkedList(LinkedList<String> list){

        //iterate over half of the list
        for (int i = 0, j = list.size()-1; i < list.size() / 2; i++, j--) {
            //swap ith and jth elements of the list
            //ith element goes to temp
            String temp = list.get(i);
            //copy jth element to the ith element
            list.set(i,list.get(j));
            //copy the temp to the jth element
            list.set(j,temp);

        }
    }

    //separate by space
    //create map, every first letter gets a new map, if it already exists add the word to the map
    //if it doesn't then create a new map key,value pair with that value

    /**
     * converts an array of string to a map
     * keys are the first letters of the strings
     * values are the set of all the strings that start with that key
     * @param args
     */
    public static void array2Map(String[] values){

        //declare the map(k,v)
        HashMap<String, HashSet<String>> map = new HashMap<>();

        //iterate over the values array
        for(int i=0; i < values.length; i++){
            //create the key
            String key = values[i].substring(0,1);

            //check if key exists or doesn't exist in the map
            if(!map.containsKey(key)){
                //create new set
                HashSet<String> set = new HashSet<>();
                //add the current word to the set
                set.add(values[i]);
                //add the key and set to the map
                map.put(key,set);

            }else{//if the key already exists
                //get the set associated with this key
                HashSet<String> set = map.get(key);
                HashSet<String> set2 = map.getOrDefault(key,new HashSet<>());
                //add the current word to the set
                set.add(values[i]);
                //add the key and set back to the map
                map.put(key,set);
            }
        }

        //keyset returns all the keys in the map but in a set
        //values returns all the values in a generic hashset as a collection
        //entrySet returns the pairs of keys and values

        //print the key value pairs in the map
        //get all the keys in the map
        Set<String> keys = map.keySet();
        //iterate over this set of keys
        //for each key
        for(String k:keys){
            System.out.print(k + " : ");
            //get the set associated with this key
            HashSet<String> set = map.get(k);
            //for each word in the set
            for(String s : set){
                //print the word
                System.out.print(s + " ");
            }
            System.out.println();
        }

        //alternative method for iteration over a map
        Set<Map.Entry<String, HashSet<String>>> entries = map.entrySet();
        for (Map.Entry <String, HashSet<String>> entry: entries){
            entry.getKey();
            entry.getValue();
        }

    }

    public static void drivewayParking(){
        //create and initialize the stack
        Stack<String> driveway = new Stack<>();
        driveway.add("A");
        driveway.add("B");
        driveway.add("C");
        driveway.add("D");

        //create the road stack
        Stack<String> road = new Stack<>();

        //get the first car from the driveway
        String car = driveway.pop();
        System.out.println(car + " removed from the driveway");

        //while this is not the car we are looking for
        while(!car.equals("B")){
            //push this car to the road
            road.push(car);
            System.out.println(car + " added to the road");
            //get the next car in the series
            car = driveway.pop();
            System.out.println(car + " removed from the driveway");
        }

        //move all the cars from the road back to the driveway
        while(!road.isEmpty()){
            car = road.pop();
            driveway.push(car);
            System.out.println(car + " moved from the road to the driveway");
        }
    }

    public static void main(String[] args) {
        /*
        //create and initialize a list of 4 elements
        LinkedList<String> list = new LinkedList<>(List.of("A","B","C","D"));

        printLinkedList(list);
        reverseLinkedList(list);
        printLinkedList(list);

        String s = "mary had a little lamb";
        array2Map(s.split(" "));
        */

        drivewayParking();
    }
}
