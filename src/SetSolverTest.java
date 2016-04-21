import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;
/**
 * Created by jose on 4/18/16.
 * Last edited on 4/18/16
 */
public class SetSolverTest
{
    private HashMap<String, String[]> dimensions1;
    private HashMap<String, String[]> dimensions2;
    private HashMap<String, String[]> dimensions3;
    private HashMap<String, String[]> dimensions4;
    private ArrayList<SetCard> inputOfTest1;
    private ArrayList<SetCard> inputOfTest2;
    private ArrayList<SetCard> inputOfTest3;
    private ArrayList<SetCard> inputOfTest4;
    private ArrayList<ArrayList<SetCard>> expectResults1;
    private ArrayList<ArrayList<SetCard>> expectResults2;
    private ArrayList<ArrayList<SetCard>> expectResults3;
    private SetSolver s1;
    private SetSolver s2;
    private SetSolver s3;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setupTestTask1() {
        s1 = new SetSolver(3);
        dimensions1 = new HashMap<>();
        expectResults1 = new ArrayList<>();
        SetCard c1 = new SetCard();
        SetCard c2 = new SetCard();
        SetCard c3 = new SetCard();
        SetCard c4 = new SetCard();
        SetCard c5 = new SetCard();
        SetCard c6 = new SetCard();
        SetCard c7 = new SetCard();
        SetCard c8 = new SetCard();
        SetCard c9 = new SetCard();

        dimensions1.put("color", new String[]{"red", "green", "purple"});
        dimensions1.put("symbol", new String[]{"squiggle", "diamond", "oval"});
        dimensions1.put("shading", new String[]{"solid", "striped", "outlined"});
        dimensions1.put("number", new String[]{"one", "two", "three"});

        c1.addDimension(new String[]{"color", "red"});
        c1.addDimension(new String[]{"symbol", "diamond"});
        c1.addDimension(new String[]{"shading", "solid"});
        c1.addDimension(new String[]{"number", "one"});

        c2.addDimension(new String[]{"color", "red"});
        c2.addDimension(new String[]{"symbol", "squiggle"});
        c2.addDimension(new String[]{"shading", "solid"});
        c2.addDimension(new String[]{"number", "one"});

        c3.addDimension(new String[]{"color", "red"});
        c3.addDimension(new String[]{"symbol", "oval"});
        c3.addDimension(new String[]{"shading", "solid"});
        c3.addDimension(new String[]{"number", "one"});

        c4.addDimension(new String[]{"color", "purple"});
        c4.addDimension(new String[]{"symbol", "diamond"});
        c4.addDimension(new String[]{"shading", "solid"});
        c4.addDimension(new String[]{"number", "one"});

        c5.addDimension(new String[]{"color", "purple"});
        c5.addDimension(new String[]{"symbol", "diamond"});
        c5.addDimension(new String[]{"shading", "striped"});
        c5.addDimension(new String[]{"number", "one"});

        c6.addDimension(new String[]{"color", "purple"});
        c6.addDimension(new String[]{"symbol", "diamond"});
        c6.addDimension(new String[]{"shading", "outlined"});
        c6.addDimension(new String[]{"number", "one"});

        c7.addDimension(new String[]{"color", "green"});
        c7.addDimension(new String[]{"symbol", "diamond"});
        c7.addDimension(new String[]{"shading", "outlined"});
        c7.addDimension(new String[]{"number", "one"});

        c8.addDimension(new String[]{"color", "green"});
        c8.addDimension(new String[]{"symbol", "diamond"});
        c8.addDimension(new String[]{"shading", "outlined"});
        c8.addDimension(new String[]{"number", "two"});

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

        l4.add(c1);
        l4.add(c5);
        l4.add(c7);

        inputOfTest1 = new ArrayList<>();
        inputOfTest1.add(c1);
        inputOfTest1.add(c2);
        inputOfTest1.add(c3);
        inputOfTest1.add(c4);
        inputOfTest1.add(c5);
        inputOfTest1.add(c6);
        inputOfTest1.add(c7);
        inputOfTest1.add(c8);
        inputOfTest1.add(c9);

        expectResults1.add(l1);
        expectResults1.add(l2);
        expectResults1.add(l3);
        expectResults1.add(l4);
    }

    @Before
    public void setupTestTask2() {
        dimensions2 = new HashMap<>();
        expectResults2 = new ArrayList<>();
        SetCard c1;
        SetCard c2;
        SetCard c3;
        SetCard c4;
        SetCard c5;
        SetCard c6;
        SetCard c7;
        SetCard c8;
        SetCard c9;
        SetCard c10;
        SetCard c11;
        SetCard c12;

        dimensions2.put("color", new String[]{"red", "green", "purple"});
        dimensions2.put("symbol", new String[]{"squiggle", "diamond", "oval"});
        dimensions2.put("shading", new String[]{"solid", "striped", "outlined"});
        dimensions2.put("number", new String[]{"one", "two", "three"});
        dimensions2.put("direction", new String[]{"up", "down", "side"});
        dimensions2.put("size", new String[]{"big", "medium", "small"});

        c1 = new SetCard();
        c1.addDimension(new String[]{"color", "red"});
        c1.addDimension(new String[]{"symbol", "diamond"});
        c1.addDimension(new String[]{"shading", "solid"});
        c1.addDimension(new String[]{"number", "one"});
        c1.addDimension(new String[]{"direction", "up"});
        c1.addDimension(new String[]{"size", "big"});

        c2 = new SetCard();
        c2.addDimension(new String[]{"color", "red"});
        c2.addDimension(new String[]{"symbol", "squiggle"});
        c2.addDimension(new String[]{"shading", "solid"});
        c2.addDimension(new String[]{"number", "one"});
        c2.addDimension(new String[]{"direction", "down"});
        c2.addDimension(new String[]{"size", "big"});

        c3 = new SetCard();
        c3.addDimension(new String[]{"color", "red"});
        c3.addDimension(new String[]{"symbol", "oval"});
        c3.addDimension(new String[]{"shading", "solid"});
        c3.addDimension(new String[]{"number", "one"});
        c3.addDimension(new String[]{"direction", "side"});
        c3.addDimension(new String[]{"size", "big"});

        c4 = new SetCard();
        c4.addDimension(new String[]{"color", "purple"});
        c4.addDimension(new String[]{"symbol", "diamond"});
        c4.addDimension(new String[]{"shading", "solid"});
        c4.addDimension(new String[]{"number", "one"});
        c4.addDimension(new String[]{"direction", "up"});
        c4.addDimension(new String[]{"size", "big"});

        c5 = new SetCard();
        c5.addDimension(new String[]{"color", "purple"});
        c5.addDimension(new String[]{"symbol", "diamond"});
        c5.addDimension(new String[]{"shading", "striped"});
        c5.addDimension(new String[]{"number", "one"});
        c5.addDimension(new String[]{"direction", "up"});
        c5.addDimension(new String[]{"size", "medium"});

        c6 = new SetCard();
        c6.addDimension(new String[]{"color", "purple"});
        c6.addDimension(new String[]{"symbol", "diamond"});
        c6.addDimension(new String[]{"shading", "outlined"});
        c6.addDimension(new String[]{"number", "one"});
        c6.addDimension(new String[]{"direction", "up"});
        c6.addDimension(new String[]{"size", "small"});

        c7 = new SetCard();
        c7.addDimension(new String[]{"color", "green"});
        c7.addDimension(new String[]{"symbol", "diamond"});
        c7.addDimension(new String[]{"shading", "outlined"});
        c7.addDimension(new String[]{"number", "one"});
        c7.addDimension(new String[]{"direction", "up"});
        c7.addDimension(new String[]{"size", "small"});

        c8 = new SetCard();
        c8.addDimension(new String[]{"color", "green"});
        c8.addDimension(new String[]{"symbol", "diamond"});
        c8.addDimension(new String[]{"shading", "outlined"});
        c8.addDimension(new String[]{"number", "two"});
        c8.addDimension(new String[]{"direction", "up"});
        c8.addDimension(new String[]{"size", "small"});

        c9 = new SetCard();
        c9.addDimension(new String[]{"color", "green"});
        c9.addDimension(new String[]{"symbol", "diamond"});
        c9.addDimension(new String[]{"shading", "outlined"});
        c9.addDimension(new String[]{"number", "three"});
        c9.addDimension(new String[]{"direction", "up"});
        c9.addDimension(new String[]{"size", "small"});

        c10 = new SetCard();
        c10.addDimension(new String[]{"color", "red"});
        c10.addDimension(new String[]{"symbol", "diamond"});
        c10.addDimension(new String[]{"shading", "solid"});
        c10.addDimension(new String[]{"number", "one"});
        c10.addDimension(new String[]{"direction", "up"});
        c10.addDimension(new String[]{"size", "big"});

        c11 = new SetCard();
        c11.addDimension(new String[]{"color", "green"});
        c11.addDimension(new String[]{"symbol", "diamond"});
        c11.addDimension(new String[]{"shading", "solid"});
        c11.addDimension(new String[]{"number", "one"});
        c11.addDimension(new String[]{"direction", "up"});
        c11.addDimension(new String[]{"size", "medium"});

        c12 = new SetCard();
        c12.addDimension(new String[]{"color", "purple"});
        c12.addDimension(new String[]{"symbol", "diamond"});
        c12.addDimension(new String[]{"shading", "solid"});
        c12.addDimension(new String[]{"number", "one"});
        c12.addDimension(new String[]{"direction", "up"});
        c12.addDimension(new String[]{"size", "small"});

        ArrayList<SetCard> l1 = new ArrayList<>();
        ArrayList<SetCard> l2 = new ArrayList<>();
        ArrayList<SetCard> l3 = new ArrayList<>();
        ArrayList<SetCard> l4 = new ArrayList<>();
        ArrayList<SetCard> l5 = new ArrayList<>();

        l1.add(c1);
        l1.add(c2);
        l1.add(c3);

        l2.add(c4);
        l2.add(c5);
        l2.add(c6);

        l3.add(c7);
        l3.add(c8);
        l3.add(c9);

        l4.add(c1);
        l4.add(c5);
        l4.add(c7);

        l5.add(c10);
        l5.add(c11);
        l5.add(c12);

        inputOfTest2 = new ArrayList<>();
        inputOfTest2.add(c1);
        inputOfTest2.add(c2);
        inputOfTest2.add(c3);
        inputOfTest2.add(c4);
        inputOfTest2.add(c5);
        inputOfTest2.add(c6);
        inputOfTest2.add(c7);
        inputOfTest2.add(c8);
        inputOfTest2.add(c9);
        inputOfTest2.add(c10);
        inputOfTest2.add(c11);
        inputOfTest2.add(c12);

        expectResults2.add(l1);
        expectResults2.add(l4);
        expectResults2.add(l5);
        expectResults2.add(l2);
        expectResults2.add(l3);
    }

    @Before
    public void setupTestTask3() {
        s2 = new SetSolver(4);
        dimensions3 = new HashMap<>();
        expectResults3 = new ArrayList<>();
        SetCard c1;
        SetCard c2;
        SetCard c3;
        SetCard c4;
        SetCard c5;
        SetCard c6;
        SetCard c7;
        SetCard c8;
        SetCard c9;
        SetCard c10;
        SetCard c11;
        SetCard c12;
        SetCard c13;
        SetCard c14;
        SetCard c15;

        dimensions3.put("color", new String[]{"red", "green", "purple", "blue"});
        dimensions3.put("symbol", new String[]{"squiggle", "diamond", "oval", "triangle"});
        dimensions3.put("shading", new String[]{"solid", "striped", "outlined", "blank"});
        dimensions3.put("number", new String[]{"one", "two", "three", "four"});
        dimensions3.put("direction", new String[]{"up", "down", "side", "other-side"});
        dimensions3.put("size", new String[]{"big", "medium", "small", "tiny"});

        c1 = new SetCard();
        c1.addDimension(new String[]{"color", "red"});
        c1.addDimension(new String[]{"symbol", "diamond"});
        c1.addDimension(new String[]{"shading", "solid"});
        c1.addDimension(new String[]{"number", "one"});
        c1.addDimension(new String[]{"direction", "up"});
        c1.addDimension(new String[]{"size", "big"});

        c2 = new SetCard();
        c2.addDimension(new String[]{"color", "red"});
        c2.addDimension(new String[]{"symbol", "squiggle"});
        c2.addDimension(new String[]{"shading", "solid"});
        c2.addDimension(new String[]{"number", "one"});
        c2.addDimension(new String[]{"direction", "down"});
        c2.addDimension(new String[]{"size", "big"});

        c3 = new SetCard();
        c3.addDimension(new String[]{"color", "red"});
        c3.addDimension(new String[]{"symbol", "oval"});
        c3.addDimension(new String[]{"shading", "solid"});
        c3.addDimension(new String[]{"number", "one"});
        c3.addDimension(new String[]{"direction", "side"});
        c3.addDimension(new String[]{"size", "big"});

        c4 = new SetCard();
        c4.addDimension(new String[]{"color", "purple"});
        c4.addDimension(new String[]{"symbol", "diamond"});
        c4.addDimension(new String[]{"shading", "solid"});
        c4.addDimension(new String[]{"number", "one"});
        c4.addDimension(new String[]{"direction", "up"});
        c4.addDimension(new String[]{"size", "big"});

        c5 = new SetCard();
        c5.addDimension(new String[]{"color", "purple"});
        c5.addDimension(new String[]{"symbol", "diamond"});
        c5.addDimension(new String[]{"shading", "striped"});
        c5.addDimension(new String[]{"number", "one"});
        c5.addDimension(new String[]{"direction", "up"});
        c5.addDimension(new String[]{"size", "medium"});

        c6 = new SetCard();
        c6.addDimension(new String[]{"color", "purple"});
        c6.addDimension(new String[]{"symbol", "diamond"});
        c6.addDimension(new String[]{"shading", "outlined"});
        c6.addDimension(new String[]{"number", "one"});
        c6.addDimension(new String[]{"direction", "up"});
        c6.addDimension(new String[]{"size", "small"});

        c7 = new SetCard();
        c7.addDimension(new String[]{"color", "green"});
        c7.addDimension(new String[]{"symbol", "diamond"});
        c7.addDimension(new String[]{"shading", "outlined"});
        c7.addDimension(new String[]{"number", "one"});
        c7.addDimension(new String[]{"direction", "up"});
        c7.addDimension(new String[]{"size", "small"});

        c8 = new SetCard();
        c8.addDimension(new String[]{"color", "green"});
        c8.addDimension(new String[]{"symbol", "diamond"});
        c8.addDimension(new String[]{"shading", "outlined"});
        c8.addDimension(new String[]{"number", "two"});
        c8.addDimension(new String[]{"direction", "up"});
        c8.addDimension(new String[]{"size", "small"});

        c9 = new SetCard();
        c9.addDimension(new String[]{"color", "green"});
        c9.addDimension(new String[]{"symbol", "diamond"});
        c9.addDimension(new String[]{"shading", "outlined"});
        c9.addDimension(new String[]{"number", "three"});
        c9.addDimension(new String[]{"direction", "up"});
        c9.addDimension(new String[]{"size", "small"});

        c10 = new SetCard();
        c10.addDimension(new String[]{"color", "red"});
        c10.addDimension(new String[]{"symbol", "diamond"});
        c10.addDimension(new String[]{"shading", "solid"});
        c10.addDimension(new String[]{"number", "one"});
        c10.addDimension(new String[]{"direction", "up"});
        c10.addDimension(new String[]{"size", "big"});

        c11 = new SetCard();
        c11.addDimension(new String[]{"color", "green"});
        c11.addDimension(new String[]{"symbol", "diamond"});
        c11.addDimension(new String[]{"shading", "solid"});
        c11.addDimension(new String[]{"number", "one"});
        c11.addDimension(new String[]{"direction", "up"});
        c11.addDimension(new String[]{"size", "medium"});

        c12 = new SetCard();
        c12.addDimension(new String[]{"color", "purple"});
        c12.addDimension(new String[]{"symbol", "diamond"});
        c12.addDimension(new String[]{"shading", "solid"});
        c12.addDimension(new String[]{"number", "one"});
        c12.addDimension(new String[]{"direction", "up"});
        c12.addDimension(new String[]{"size", "small"});

        c13 = new SetCard();
        c13.addDimension(new String[]{"color", "red"});
        c13.addDimension(new String[]{"symbol", "triangle"});
        c13.addDimension(new String[]{"shading", "blank"});
        c13.addDimension(new String[]{"number", "four"});
        c13.addDimension(new String[]{"direction", "other-side"});
        c13.addDimension(new String[]{"size", "big"});

        c14 = new SetCard();
        c14.addDimension(new String[]{"color", "purple"});
        c14.addDimension(new String[]{"symbol", "diamond"});
        c14.addDimension(new String[]{"shading", "blank"});
        c14.addDimension(new String[]{"number", "one"});
        c14.addDimension(new String[]{"direction", "up"});
        c14.addDimension(new String[]{"size", "tiny"});

        c15 = new SetCard();
        c15.addDimension(new String[]{"color", "blue"});
        c15.addDimension(new String[]{"symbol", "triangle"});
        c15.addDimension(new String[]{"shading", "blank"});
        c15.addDimension(new String[]{"number", "four"});
        c15.addDimension(new String[]{"direction", "other-side"});
        c15.addDimension(new String[]{"size", "tiny"});

        ArrayList<SetCard> l1 = new ArrayList<>();

        l1.add(c4);
        l1.add(c5);
        l1.add(c6);
        l1.add(c14);

        inputOfTest3 = new ArrayList<>();
        inputOfTest3.add(c1);
        inputOfTest3.add(c2);
        inputOfTest3.add(c3);
        inputOfTest3.add(c4);
        inputOfTest3.add(c5);
        inputOfTest3.add(c6);
        inputOfTest3.add(c7);
        inputOfTest3.add(c8);
        inputOfTest3.add(c9);
        inputOfTest3.add(c10);
        inputOfTest3.add(c11);
        inputOfTest3.add(c12);
        inputOfTest3.add(c13);
        inputOfTest3.add(c14);
        inputOfTest3.add(c15);

        expectResults3.add(l1);
    }

    @Before
    public void setupTestTask4() {
        s3 = new SetSolver(1);
        dimensions4 = new HashMap<>();
        dimensions4.put("color", new String[]{"red", "green", "purple", "blue"});
        dimensions4.put("symbol", new String[]{"squiggle", "diamond", "oval", "triangle"});
        dimensions4.put("shading", new String[]{"solid", "striped", "outlined", "blank"});
        dimensions4.put("number", new String[]{"one", "two", "three", "four"});
        dimensions4.put("direction", new String[]{"up", "down", "side"});

        SetCard c1 = new SetCard();

        c1.addDimension(new String[]{"color", "red"});
        c1.addDimension(new String[]{"symbol", "diamond"});
        c1.addDimension(new String[]{"shading", "solid"});
        c1.addDimension(new String[]{"number", "one"});

        inputOfTest4 = new ArrayList<>();
        inputOfTest4.add(c1);
    }
    @Test
    public void assetCorrectSetsTask1() throws SetSolver.ImproperDimensionException
    {
        ArrayList<ArrayList<SetCard>> r = s1.getAllPossibleSets(inputOfTest1, dimensions1);
        assertTrue(r.size() == expectResults1.size() && new HashSet(r).equals(new HashSet(expectResults1)));
    }

    @Test
    public void assetCorrectSetsTask2() throws SetSolver.ImproperDimensionException
    {
        ArrayList<ArrayList<SetCard>> r = s1.getAllPossibleSets(inputOfTest2, dimensions2);
        assertTrue(r.size() == expectResults2.size() && new HashSet(r).equals(new HashSet(expectResults2)));
    }

    @Test
    public void assetCorrectSetsTask3() throws SetSolver.ImproperDimensionException
    {
        ArrayList<ArrayList<SetCard>> r = s2.getAllPossibleSets(inputOfTest3, dimensions3);
        assertTrue(r.size() == expectResults3.size() && new HashSet(r).equals(new HashSet(expectResults3)));
    }

    @Test
    public void assetThrowsError() throws Throwable
    {
        exception.expect(SetSolver.ImproperDimensionException.class);
        System.out.println(s3.getAllPossibleSets(inputOfTest4, dimensions4));
    }
}
