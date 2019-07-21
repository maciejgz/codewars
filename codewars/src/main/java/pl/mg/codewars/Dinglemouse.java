package pl.mg.codewars;

import java.util.*;

/**
 * The Hunger Games - Zoo Disaster! KATA
 * Story
 * A freak power outage at the zoo has caused all of the electric cage doors to malfunction and swing open...
 * <p>
 * All the animals are out and some of them are eating each other!
 * <p>
 * It's a Zoo Disaster!
 * Here is a list of zoo animals, and what they can eat
 * <p>
 * antelope eats grass
 * big-fish eats little-fish
 * bug eats leaves
 * bear eats big-fish
 * bear eats bug
 * bear eats chicken
 * bear eats cow
 * bear eats leaves
 * bear eats sheep
 * chicken eats bug
 * cow eats grass
 * fox eats chicken
 * fox eats sheep
 * giraffe eats leaves
 * lion eats antelope
 * lion eats cow
 * panda eats leaves
 * sheep eats grass
 * Kata Task
 * <p>
 * <p>
 * INPUT
 * A comma-separated string representing all the things at the zoo
 * <p>
 * TASK
 * Figure out who eats who until no more eating is possible.
 * <p>
 * OUTPUT
 * A list of strings (refer to the example below) where:
 * <p>
 * The first element is the initial zoo (same as INPUT)
 * The last element is a comma-separated string of what the zoo looks like when all the eating has finished
 * All other elements (2nd to last-1) are of the form X eats Y describing what happened
 * Notes
 * Animals can only eat things beside them
 * <p>
 * Animals always eat to their LEFT before eating to their RIGHT
 * <p>
 * Always the LEFTMOST animal capable of eating will eat before any others
 * <p>
 * Any other things you may find at the zoo (which are not listed above) do not eat anything and are not edible
 * <p>
 * Example
 * Input
 * <p>
 * "fox,bug,chicken,grass,sheep"
 * <p>
 * Working
 * <p>
 * 1	fox can't eat bug
 * "fox,bug,chicken,grass,sheep"
 * 2	bug can't eat anything
 * "fox,bug,chicken,grass,sheep"
 * 3	chicken eats bug
 * "fox,chicken,grass,sheep"
 * 4	fox eats chicken
 * "fox,grass,sheep"
 * 5	fox can't eat grass
 * "fox,grass,sheep"
 * 6	grass can't eat anything
 * "fox,grass,sheep"
 * 7	sheep eats grass
 * "fox,sheep"
 * 8	fox eats sheep
 * "fox"
 * Output
 * <p>
 * ["fox,bug,chicken,grass,sheep", "chicken eats bug", "fox eats chicken", "sheep eats grass", "fox eats sheep", "fox"]
 */
public class Dinglemouse {
    private static final Map<String, List<String>> eaters = new HashMap<>();

    static {
        eaters.put("antelope", new ArrayList<String>(Arrays.asList("grass")));
        eaters.put("big-fish", new ArrayList<String>(Arrays.asList("little-fish")));
        eaters.put("bug", new ArrayList<String>(Arrays.asList("leaves")));
        eaters.put("bear", new ArrayList<String>(Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep")));
        eaters.put("chicken", new ArrayList<String>(Arrays.asList("bug")));
        eaters.put("cow", new ArrayList<String>(Arrays.asList("grass")));
        eaters.put("fox", new ArrayList<String>(Arrays.asList("chicken", "sheep")));
        eaters.put("giraffe", new ArrayList<String>(Arrays.asList("leaves")));
        eaters.put("lion", new ArrayList<String>(Arrays.asList("antelope", "cow")));
        eaters.put("panda", new ArrayList<String>(Arrays.asList("leaves")));
        eaters.put("sheep", new ArrayList<String>(Arrays.asList("grass")));
    }

    public static void main(String[] args) {
        String[] strings = whoEatsWho("little-fish,big-fish,panda");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static String[] whoEatsWho(final String zoo) {
        List<String> zooInput = new ArrayList<>(Arrays.asList(zoo.split(",")));
        List<String> result = new ArrayList<>();
        result.add(zoo);
        Dinglemouse dinglemouse = new Dinglemouse();
        dinglemouse.calculateZoo(zooInput, result);
        result.add(String.join(",", zooInput));
        return result.toArray(new String[0]);
    }

    private void calculateZoo(List<String> zooInput, List<String> result) {
        if (zooInput.size() < 2) {
            return;
        }
        for (int i = 0; i < zooInput.size(); i++) {
            if (i == 0) {
                if (eaters.containsKey(zooInput.get(i)) && eaters.get(zooInput.get(i)).contains(zooInput.get(i + 1))) {
                    result.add(zooInput.get(i) + " eats " + zooInput.get(i + 1));
                    zooInput.remove(i + 1);
                    calculateZoo(zooInput, result);
                    break;
                }
            } else if (i == (zooInput.size() - 1)) {
                if (eaters.containsKey(zooInput.get(i)) && eaters.get(zooInput.get(i)).contains(zooInput.get(i - 1))) {
                    result.add(zooInput.get(i) + " eats " + zooInput.get(i - 1));
                    zooInput.remove(i - 1);
                    calculateZoo(zooInput, result);
                    break;
                }
            } else {
                if (eaters.containsKey(zooInput.get(i)) && eaters.get(zooInput.get(i)).contains(zooInput.get(i - 1))) {
                    result.add(zooInput.get(i) + " eats " + zooInput.get(i - 1));
                    zooInput.remove(i - 1);
                    calculateZoo(zooInput, result);
                    break;
                } else if (eaters.containsKey(zooInput.get(i)) && eaters.get(zooInput.get(i)).contains(zooInput.get(i + 1))) {
                    result.add(zooInput.get(i) + " eats " + zooInput.get(i + 1));
                    zooInput.remove(i + 1);
                    calculateZoo(zooInput, result);
                    break;
                }
            }
        }
    }
}
