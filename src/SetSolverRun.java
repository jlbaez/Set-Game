import java.util.*;

/**
 * SetGame
 * Created by jose on 4/17/16.
 * Last edited on 4/17/16
 */
public class SetSolverRun {
    public static void main(String[] args)
    {
        ArrayList<SetCard> input = new ArrayList<>();

        HashMap<String, String[]> dimensions = new HashMap<>();

        dimensions.put("color", new String[]{"red", "green", "purple"});
        dimensions.put("symbol", new String[]{"squiggle", "diamond", "oval"});
        dimensions.put("shading", new String[]{"solid", "striped", "outlined"});
        dimensions.put("number", new String[]{"one", "two", "three"});

        int i = 0;
        for(Map.Entry<String, String[]> e : dimensions.entrySet())
        {
            for(String value : e.getValue())
            {
                i++;
            }
        }
        System.out.println(i);
        SetCard s1 = new SetCard();
        s1.addDimension(new String[]{"color", "red"});
        s1.addDimension(new String[]{"symbol", "diamond"});
        s1.addDimension(new String[]{"shading", "solid"});
        s1.addDimension(new String[]{"number", "one"});

        SetCard s2 = new SetCard();
        s2.addDimension(new String[]{"color", "red"});
        s2.addDimension(new String[]{"symbol", "squiggle"});
        s2.addDimension(new String[]{"shading", "solid"});
        s2.addDimension(new String[]{"number", "one"});
        
        SetCard s3 = new SetCard();
        s3.addDimension(new String[]{"color", "red"});
        s3.addDimension(new String[]{"symbol", "oval"});
        s3.addDimension(new String[]{"shading", "solid"});
        s3.addDimension(new String[]{"number", "one"});

        SetCard s4 = new SetCard();
        s4.addDimension(new String[]{"color", "purple"});
        s4.addDimension(new String[]{"symbol", "diamond"});
        s4.addDimension(new String[]{"shading", "solid"});
        s4.addDimension(new String[]{"number", "one"});

        SetCard s5 = new SetCard();
        s5.addDimension(new String[]{"color", "purple"});
        s5.addDimension(new String[]{"symbol", "diamond"});
        s5.addDimension(new String[]{"shading", "striped"});
        s5.addDimension(new String[]{"number", "one"});

        SetCard s6 = new SetCard();
        s6.addDimension(new String[]{"color", "purple"});
        s6.addDimension(new String[]{"symbol", "diamond"});
        s6.addDimension(new String[]{"shading", "outlined"});
        s6.addDimension(new String[]{"number", "one"});

        SetCard s7 = new SetCard();
        s7.addDimension(new String[]{"color", "green"});
        s7.addDimension(new String[]{"symbol", "diamond"});
        s7.addDimension(new String[]{"shading", "outlined"});
        s7.addDimension(new String[]{"number", "one"});

        SetCard s8 = new SetCard();
        s8.addDimension(new String[]{"color", "green"});
        s8.addDimension(new String[]{"symbol", "diamond"});
        s8.addDimension(new String[]{"shading", "outlined"});
        s8.addDimension(new String[]{"number", "two"});

        SetCard s9 = new SetCard();
        s9.addDimension(new String[]{"color", "green"});
        s9.addDimension(new String[]{"symbol", "diamond"});
        s9.addDimension(new String[]{"shading", "outlined"});
        s9.addDimension(new String[]{"number", "three"});

        input.add(s1);
        input.add(s2);
        input.add(s3);
        input.add(s4);
        input.add(s5);
        input.add(s6);
        input.add(s7);
        input.add(s8);
        input.add(s9);
        SetSolver s = new SetSolver();

        ArrayList<ArrayList<SetCard>> allSet = s.getAllPossibleSets(input, dimensions);

        System.out.println("size " + allSet.size());
        System.out.println();
        for(ArrayList<SetCard> set : allSet)
        {
            for(SetCard card : set)
            {
                System.out.println(card + " ");
            }
            System.out.println();
        }
    }
}
