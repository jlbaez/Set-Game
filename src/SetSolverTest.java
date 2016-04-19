import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
/**
 * Created by jose on 4/18/16.
 * Last edited on 4/18/16
 */
public class SetSolverTest
{
   private HashMap<String, String[]> dimensions1;
   private ArrayList<SetCard> inputOfTest1;
   private ArrayList<ArrayList<SetCard>> expectResults1;
   private SetSolver s1;

   @Before
   public void setup() {
       s1 = new SetSolver(3);
       dimensions1 = new HashMap<>();
       expectResults1 = new ArrayList<>();
       SetCard c1;
       SetCard c2;
       SetCard c3;
       SetCard c4;
       SetCard c5;
       SetCard c6;
       SetCard c7;
       SetCard c8;
       SetCard c9;

       dimensions1.put("color", new String[]{"red", "green", "purple"});
       dimensions1.put("symbol", new String[]{"squiggle", "diamond", "oval"});
       dimensions1.put("shading", new String[]{"solid", "striped", "outlined"});
       dimensions1.put("number", new String[]{"one", "two", "three"});

       c1 = new SetCard();
       c1.addDimension(new String[]{"color", "red"});
       c1.addDimension(new String[]{"symbol", "diamond"});
       c1.addDimension(new String[]{"shading", "solid"});
       c1.addDimension(new String[]{"number", "one"});

       c2 = new SetCard();
       c2.addDimension(new String[]{"color", "red"});
       c2.addDimension(new String[]{"symbol", "squiggle"});
       c2.addDimension(new String[]{"shading", "solid"});
       c2.addDimension(new String[]{"number", "one"});

       c3 = new SetCard();
       c3.addDimension(new String[]{"color", "red"});
       c3.addDimension(new String[]{"symbol", "oval"});
       c3.addDimension(new String[]{"shading", "solid"});
       c3.addDimension(new String[]{"number", "one"});

       c4 = new SetCard();
       c4.addDimension(new String[]{"color", "purple"});
       c4.addDimension(new String[]{"symbol", "diamond"});
       c4.addDimension(new String[]{"shading", "solid"});
       c4.addDimension(new String[]{"number", "one"});

       c5 = new SetCard();
       c5.addDimension(new String[]{"color", "purple"});
       c5.addDimension(new String[]{"symbol", "diamond"});
       c5.addDimension(new String[]{"shading", "striped"});
       c5.addDimension(new String[]{"number", "one"});

       c6 = new SetCard();
       c6.addDimension(new String[]{"color", "purple"});
       c6.addDimension(new String[]{"symbol", "diamond"});
       c6.addDimension(new String[]{"shading", "outlined"});
       c6.addDimension(new String[]{"number", "one"});

       c7 = new SetCard();
       c7.addDimension(new String[]{"color", "green"});
       c7.addDimension(new String[]{"symbol", "diamond"});
       c7.addDimension(new String[]{"shading", "outlined"});
       c7.addDimension(new String[]{"number", "one"});

       c8 = new SetCard();
       c8.addDimension(new String[]{"color", "green"});
       c8.addDimension(new String[]{"symbol", "diamond"});
       c8.addDimension(new String[]{"shading", "outlined"});
       c8.addDimension(new String[]{"number", "two"});

       c9 = new SetCard();
       c9.addDimension(new String[]{"color", "green"});
       c9.addDimension(new String[]{"symbol", "diamond"});
       c9.addDimension(new String[]{"shading", "outlined"});
       c9.addDimension(new String[]{"number", "three"});

       ArrayList<SetCard> l1 = new ArrayList<>();
       ArrayList<SetCard> l2 = new ArrayList<>();
       ArrayList<SetCard> l3 = new ArrayList<>();
       ArrayList<SetCard> l4 = new ArrayList<>();

       l1.add(c1);
       l1.add(c2);
       l1.add(c3);

       l2.add(c4);
       l2.add(c5);
       l2.add(c6);

       l3.add(c7);
       l3.add(c8);
       l3.add(c9);

       l4.add(c2);
       l4.add(c6);
       l4.add(c7);

       inputOfTest1 = new ArrayList<>();
       inputOfTest1.add(c1);
       inputOfTest1.add(c2);
       inputOfTest1.add(c3);
       inputOfTest1.add(c4);
       inputOfTest1.add(c5);
       inputOfTest1.add(c6);
       inputOfTest1.add(c8);
       inputOfTest1.add(c9);

       expectResults1.add(l1);
       expectResults1.add(l2);
       expectResults1.add(l3);
       expectResults1.add(l4);
   }

   @Test
   public void assetSetsWith3Dimensions() throws SetSolver.ImproperDimensionException
   {
       assertEquals("checking set of 3", expectResults1, s1.getAllPossibleSets(inputOfTest1, dimensions1));
   }

    @Test
    public void assetSetsWith4Dimensions() throws SetSolver.ImproperDimensionException{
        SetSolver s = new SetSolver(3);
        HashMap<String, String[]> dimensions = new HashMap<>();

        dimensions.put("color", new String[]{"red", "green", "purple"});
        dimensions.put("symbol", new String[]{"squiggle", "diamond", "oval"});
        dimensions.put("shading", new String[]{"solid", "striped", "outlined"});
        dimensions.put("number", new String[]{"one", "two", "three"});

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

        ArrayList<SetCard> a = new ArrayList<>();
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        a.add(s5);
        a.add(s6);
        a.add(s7);
        a.add(s8);
        a.add(s9);

        ArrayList<ArrayList<SetCard>> validSets = new ArrayList<>();
        ArrayList<SetCard> v1 = new ArrayList<>();
        v1.add(s1);
        v1.add(s2);
        v1.add(s3);

        ArrayList<SetCard> v2 = new ArrayList<>();
        v2.add(s4);
        v2.add(s5);
        v2.add(s6);

        ArrayList<SetCard> v3 = new ArrayList<>();
        v3.add(s7);
        v3.add(s8);
        v3.add(s9);

        ArrayList<SetCard> v4 = new ArrayList<>();
        v4.add(s1);
        v4.add(s5);
        v4.add(s7);

        validSets.add(v1);
        validSets.add(v4);
        validSets.add(v2);
        validSets.add(v3);

        ArrayList<ArrayList<SetCard>> returnSets = s.getAllPossibleSets(a, dimensions);
        assertEquals("checking set of 3", validSets, returnSets);
    }
}
