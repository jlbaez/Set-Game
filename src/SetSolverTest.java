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
   @Test
   public void assetSetsWith3Dimensions() throws SetSolver.ImproperDimensionException{
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

       ArrayList<SetCard> a = new ArrayList<>();
       a.add(s1);
       a.add(s2);
       a.add(s3);
       a.add(s4);
       a.add(s5);
       a.add(s6);

       ArrayList<ArrayList<SetCard>> validSets = new ArrayList<>();
       ArrayList<SetCard> v1 = new ArrayList<>();
       v1.add(s1);
       v1.add(s2);
       v1.add(s3);

       ArrayList<SetCard> v2 = new ArrayList<>();
       v2.add(s4);
       v2.add(s5);
       v2.add(s6);

       validSets.add(v1);
       validSets.add(v2);

       ArrayList<ArrayList<SetCard>> returnSets = s.getAllPossibleSets(a, dimensions);
       assertEquals("checking set of 3", validSets, returnSets);
   }
}
