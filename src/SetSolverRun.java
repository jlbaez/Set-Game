import java.util.*;

/**
 * SetGame
 * Created by jose on 4/17/16.
 * Last edited on 4/18/16
 */
public class SetSolverRun {
    public static void main(String[] args)
    {
        ArrayList<SetCard> input = new ArrayList<>();
        SetSolver s = new SetSolver();
        HashMap<String, String[]> dimensions = new HashMap<>();

        dimensions.put("color", new String[]{"red", "green", "purple", "blue"});
        dimensions.put("symbol", new String[]{"squiggle", "diamond", "oval", "triangle"});
        dimensions.put("shading", new String[]{"solid", "striped", "outlined", "blank"});
        dimensions.put("number", new String[]{"one", "two", "three", "four"});
        dimensions.put("direction", new String[]{"north", "south", "east", "west"});

        SetCard s1 = new SetCard();
        s1.addDimension(new String[]{"color", "red"});
        s1.addDimension(new String[]{"symbol", "diamond"});
        s1.addDimension(new String[]{"shading", "solid"});
        s1.addDimension(new String[]{"number", "one"});
        s1.addDimension(new String[]{"direction", "north"});

        SetCard s2 = new SetCard();
        s2.addDimension(new String[]{"color", "red"});
        s2.addDimension(new String[]{"symbol", "squiggle"});
        s2.addDimension(new String[]{"shading", "solid"});
        s2.addDimension(new String[]{"number", "one"});
        s2.addDimension(new String[]{"direction", "south"});

        SetCard s3 = new SetCard();
        s3.addDimension(new String[]{"color", "red"});
        s3.addDimension(new String[]{"symbol", "oval"});
        s3.addDimension(new String[]{"shading", "solid"});
        s3.addDimension(new String[]{"number", "one"});
        s3.addDimension(new String[]{"direction", "east"});

        SetCard s4 = new SetCard();
        s4.addDimension(new String[]{"color", "purple"});
        s4.addDimension(new String[]{"symbol", "diamond"});
        s4.addDimension(new String[]{"shading", "solid"});
        s4.addDimension(new String[]{"number", "one"});
        s4.addDimension(new String[]{"direction", "north"});

        SetCard s5 = new SetCard();
        s5.addDimension(new String[]{"color", "purple"});
        s5.addDimension(new String[]{"symbol", "diamond"});
        s5.addDimension(new String[]{"shading", "striped"});
        s5.addDimension(new String[]{"number", "one"});
        s5.addDimension(new String[]{"direction", "north"});

        SetCard s6 = new SetCard();
        s6.addDimension(new String[]{"color", "purple"});
        s6.addDimension(new String[]{"symbol", "diamond"});
        s6.addDimension(new String[]{"shading", "outlined"});
        s6.addDimension(new String[]{"number", "one"});
        s6.addDimension(new String[]{"direction", "north"});


        SetCard s7 = new SetCard();
        s7.addDimension(new String[]{"color", "green"});
        s7.addDimension(new String[]{"symbol", "diamond"});
        s7.addDimension(new String[]{"shading", "outlined"});
        s7.addDimension(new String[]{"number", "one"});
        s7.addDimension(new String[]{"direction", "north"});

        SetCard s8 = new SetCard();
        s8.addDimension(new String[]{"color", "green"});
        s8.addDimension(new String[]{"symbol", "diamond"});
        s8.addDimension(new String[]{"shading", "outlined"});
        s8.addDimension(new String[]{"number", "two"});
        s8.addDimension(new String[]{"direction", "north"});

        SetCard s9 = new SetCard();
        s9.addDimension(new String[]{"color", "green"});
        s9.addDimension(new String[]{"symbol", "diamond"});
        s9.addDimension(new String[]{"shading", "outlined"});
        s9.addDimension(new String[]{"number", "four"});
        s9.addDimension(new String[]{"direction", "north"});


        input.add(s1);
        input.add(s2);
        input.add(s3);
        input.add(s4);
        input.add(s5);
        input.add(s6);
        input.add(s7);
        input.add(s8);
        input.add(s9);

        try
        {
            ArrayList<ArrayList<SetCard>> allSet = s.getAllPossibleSets(input, dimensions);

            for(ArrayList<SetCard> set : allSet)
            {
                set.forEach(System.out::println);
                System.out.println();
            }
        }
        catch(SetSolver.ImproperDimensionException e)
        {
            e.printStackTrace();
        }
    }
}
