import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
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

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private void setUpTest(int n)
    {
        int size=3;

        if(n == 3)
            size = 4;

        s1 = new SetSolver(size);
        dimensions1 = new HashMap<>();
        expectResults1 = new ArrayList<>();
        inputOfTest1 = new ArrayList<>();
        ArrayList<SetCard> l1 = new ArrayList<>();
        ArrayList<SetCard> l2 = new ArrayList<>();
        ArrayList<SetCard> l3 = new ArrayList<>();
        ArrayList<SetCard> l4 = new ArrayList<>();
        ArrayList<SetCard> l5 = new ArrayList<>();
        SetCard c1 = new SetCard();
        SetCard c2 = new SetCard();
        SetCard c3 = new SetCard();
        SetCard c4 = new SetCard();
        SetCard c5 = new SetCard();
        SetCard c6 = new SetCard();
        SetCard c7 = new SetCard();
        SetCard c8 = new SetCard();
        SetCard c9 = new SetCard();
        SetCard c10 = new SetCard();
        SetCard c11 = new SetCard();
        SetCard c12 = new SetCard();
        SetCard c13 = new SetCard();
        SetCard c14 = new SetCard();
        SetCard c15 = new SetCard();

        if(n < 3)
        {
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

            if(n == 2)
            {
                dimensions1.put("direction", new String[]{"up", "down", "side"});
                dimensions1.put("size", new String[]{"big", "medium", "small"});

                c1.addDimension(new String[]{"direction", "up"});
                c1.addDimension(new String[]{"size", "big"});

                c2.addDimension(new String[]{"direction", "down"});
                c2.addDimension(new String[]{"size", "big"});

                c3.addDimension(new String[]{"direction", "side"});
                c3.addDimension(new String[]{"size", "big"});

                c4.addDimension(new String[]{"direction", "up"});
                c4.addDimension(new String[]{"size", "big"});

                c5.addDimension(new String[]{"direction", "up"});
                c5.addDimension(new String[]{"size", "medium"});

                c6.addDimension(new String[]{"direction", "up"});
                c6.addDimension(new String[]{"size", "small"});

                c7.addDimension(new String[]{"direction", "up"});
                c7.addDimension(new String[]{"size", "small"});

                c8.addDimension(new String[]{"direction", "up"});
                c8.addDimension(new String[]{"size", "small"});

                c9.addDimension(new String[]{"direction", "up"});
                c9.addDimension(new String[]{"size", "small"});

                c10.addDimension(new String[]{"color", "red"});
                c10.addDimension(new String[]{"symbol", "diamond"});
                c10.addDimension(new String[]{"shading", "solid"});
                c10.addDimension(new String[]{"number", "one"});
                c10.addDimension(new String[]{"direction", "up"});
                c10.addDimension(new String[]{"size", "big"});

                c11.addDimension(new String[]{"color", "green"});
                c11.addDimension(new String[]{"symbol", "diamond"});
                c11.addDimension(new String[]{"shading", "solid"});
                c11.addDimension(new String[]{"number", "one"});
                c11.addDimension(new String[]{"direction", "up"});
                c11.addDimension(new String[]{"size", "medium"});

                c12.addDimension(new String[]{"color", "purple"});
                c12.addDimension(new String[]{"symbol", "diamond"});
                c12.addDimension(new String[]{"shading", "solid"});
                c12.addDimension(new String[]{"number", "one"});
                c12.addDimension(new String[]{"direction", "up"});
                c12.addDimension(new String[]{"size", "small"});
            }

            if(n == 1)
            {
                l1.add(c1);
                l1.add(c2);
                l1.add(c3);

                l2.add(c1);
                l2.add(c5);
                l2.add(c7);

                l3.add(c4);
                l3.add(c5);
                l3.add(c6);

                l4.add(c7);
                l4.add(c8);
                l4.add(c9);
            }
            else
            {
                l1.add(c1);
                l1.add(c2);
                l1.add(c3);

                l2.add(c1);
                l2.add(c5);
                l2.add(c7);

                l3.add(c10);
                l3.add(c11);
                l3.add(c12);

                l4.add(c4);
                l4.add(c5);
                l4.add(c6);

                l5.add(c7);
                l5.add(c8);
                l5.add(c9);
            }

            inputOfTest1.add(c1);
            inputOfTest1.add(c2);
            inputOfTest1.add(c3);
            inputOfTest1.add(c4);
            inputOfTest1.add(c5);
            inputOfTest1.add(c6);
            inputOfTest1.add(c7);
            inputOfTest1.add(c8);
            inputOfTest1.add(c9);

            if(n == 1)
            {
                expectResults1.add(l1);
                expectResults1.add(l2);
                expectResults1.add(l3);
                expectResults1.add(l4);
            }
            else
            {
                inputOfTest1.add(c10);
                inputOfTest1.add(c11);
                inputOfTest1.add(c12);

                expectResults1.add(l1);
                expectResults1.add(l2);
                expectResults1.add(l3);
                expectResults1.add(l4);
                expectResults1.add(l5);
            }
        }
        else if(n == 3)
        {
            dimensions1.put("color", new String[]{"red", "green", "purple", "blue"});
            dimensions1.put("symbol", new String[]{"squiggle", "diamond", "oval", "triangle"});
            dimensions1.put("shading", new String[]{"solid", "striped", "outlined", "blank"});
            dimensions1.put("number", new String[]{"one", "two", "three", "four"});
            dimensions1.put("direction", new String[]{"up", "down", "side", "other-side"});
            dimensions1.put("size", new String[]{"big", "medium", "small", "tiny"});

            c1.addDimension(new String[]{"color", "red"});
            c1.addDimension(new String[]{"symbol", "diamond"});
            c1.addDimension(new String[]{"shading", "solid"});
            c1.addDimension(new String[]{"number", "one"});
            c1.addDimension(new String[]{"direction", "up"});
            c1.addDimension(new String[]{"size", "big"});

            c2.addDimension(new String[]{"color", "red"});
            c2.addDimension(new String[]{"symbol", "squiggle"});
            c2.addDimension(new String[]{"shading", "solid"});
            c2.addDimension(new String[]{"number", "one"});
            c2.addDimension(new String[]{"direction", "down"});
            c2.addDimension(new String[]{"size", "big"});

            c3.addDimension(new String[]{"color", "red"});
            c3.addDimension(new String[]{"symbol", "oval"});
            c3.addDimension(new String[]{"shading", "solid"});
            c3.addDimension(new String[]{"number", "one"});
            c3.addDimension(new String[]{"direction", "side"});
            c3.addDimension(new String[]{"size", "big"});

            c4.addDimension(new String[]{"color", "purple"});
            c4.addDimension(new String[]{"symbol", "diamond"});
            c4.addDimension(new String[]{"shading", "solid"});
            c4.addDimension(new String[]{"number", "one"});
            c4.addDimension(new String[]{"direction", "up"});
            c4.addDimension(new String[]{"size", "big"});

            c5.addDimension(new String[]{"color", "purple"});
            c5.addDimension(new String[]{"symbol", "diamond"});
            c5.addDimension(new String[]{"shading", "striped"});
            c5.addDimension(new String[]{"number", "one"});
            c5.addDimension(new String[]{"direction", "up"});
            c5.addDimension(new String[]{"size", "medium"});

            c6.addDimension(new String[]{"color", "purple"});
            c6.addDimension(new String[]{"symbol", "diamond"});
            c6.addDimension(new String[]{"shading", "outlined"});
            c6.addDimension(new String[]{"number", "one"});
            c6.addDimension(new String[]{"direction", "up"});
            c6.addDimension(new String[]{"size", "small"});

            c7.addDimension(new String[]{"color", "green"});
            c7.addDimension(new String[]{"symbol", "diamond"});
            c7.addDimension(new String[]{"shading", "outlined"});
            c7.addDimension(new String[]{"number", "one"});
            c7.addDimension(new String[]{"direction", "up"});
            c7.addDimension(new String[]{"size", "small"});

            c8.addDimension(new String[]{"color", "green"});
            c8.addDimension(new String[]{"symbol", "diamond"});
            c8.addDimension(new String[]{"shading", "outlined"});
            c8.addDimension(new String[]{"number", "two"});
            c8.addDimension(new String[]{"direction", "up"});
            c8.addDimension(new String[]{"size", "small"});

            c9.addDimension(new String[]{"color", "green"});
            c9.addDimension(new String[]{"symbol", "diamond"});
            c9.addDimension(new String[]{"shading", "outlined"});
            c9.addDimension(new String[]{"number", "three"});
            c9.addDimension(new String[]{"direction", "up"});
            c9.addDimension(new String[]{"size", "small"});

            c10.addDimension(new String[]{"color", "red"});
            c10.addDimension(new String[]{"symbol", "diamond"});
            c10.addDimension(new String[]{"shading", "solid"});
            c10.addDimension(new String[]{"number", "one"});
            c10.addDimension(new String[]{"direction", "up"});
            c10.addDimension(new String[]{"size", "big"});

            c11.addDimension(new String[]{"color", "green"});
            c11.addDimension(new String[]{"symbol", "diamond"});
            c11.addDimension(new String[]{"shading", "solid"});
            c11.addDimension(new String[]{"number", "one"});
            c11.addDimension(new String[]{"direction", "up"});
            c11.addDimension(new String[]{"size", "medium"});

            c12.addDimension(new String[]{"color", "purple"});
            c12.addDimension(new String[]{"symbol", "diamond"});
            c12.addDimension(new String[]{"shading", "solid"});
            c12.addDimension(new String[]{"number", "one"});
            c12.addDimension(new String[]{"direction", "up"});
            c12.addDimension(new String[]{"size", "small"});

            c13.addDimension(new String[]{"color", "red"});
            c13.addDimension(new String[]{"symbol", "triangle"});
            c13.addDimension(new String[]{"shading", "blank"});
            c13.addDimension(new String[]{"number", "four"});
            c13.addDimension(new String[]{"direction", "other-side"});
            c13.addDimension(new String[]{"size", "big"});

            c14.addDimension(new String[]{"color", "purple"});
            c14.addDimension(new String[]{"symbol", "diamond"});
            c14.addDimension(new String[]{"shading", "blank"});
            c14.addDimension(new String[]{"number", "one"});
            c14.addDimension(new String[]{"direction", "up"});
            c14.addDimension(new String[]{"size", "tiny"});

            c15.addDimension(new String[]{"color", "blue"});
            c15.addDimension(new String[]{"symbol", "triangle"});
            c15.addDimension(new String[]{"shading", "blank"});
            c15.addDimension(new String[]{"number", "four"});
            c15.addDimension(new String[]{"direction", "other-side"});
            c15.addDimension(new String[]{"size", "tiny"});

            inputOfTest1.add(c1);
            inputOfTest1.add(c2);
            inputOfTest1.add(c3);
            inputOfTest1.add(c4);
            inputOfTest1.add(c5);
            inputOfTest1.add(c6);
            inputOfTest1.add(c7);
            inputOfTest1.add(c8);
            inputOfTest1.add(c9);
            inputOfTest1.add(c10);
            inputOfTest1.add(c11);
            inputOfTest1.add(c12);
            inputOfTest1.add(c13);
            inputOfTest1.add(c14);
            inputOfTest1.add(c15);

            l1.add(c4);
            l1.add(c5);
            l1.add(c6);
            l1.add(c14);

            expectResults1.add(l1);
        }
        else
        {
            dimensions1.put("color", new String[]{"red", "green", "purple", "blue"});
            dimensions1.put("symbol", new String[]{"squiggle", "diamond", "oval", "triangle"});
            dimensions1.put("shading", new String[]{"solid", "striped", "outlined", "blank"});
            dimensions1.put("number", new String[]{"one", "two", "three", "four"});
            dimensions1.put("direction", new String[]{"up", "down", "side"});

            c1.addDimension(new String[]{"color", "red"});
            c1.addDimension(new String[]{"symbol", "diamond"});
            c1.addDimension(new String[]{"shading", "solid"});
            c1.addDimension(new String[]{"number", "one"});

            inputOfTest1.add(c1);
        }
    }

    @Test
    public void assetCorrectSetsTask1() throws SetSolver.ImproperDimensionException
    {
        setUpTest(1);
        assertThat(s1.getAllPossibleSets(inputOfTest1, dimensions1), is(expectResults1));
    }

    @Test
    public void assetCorrectSetsTask2() throws SetSolver.ImproperDimensionException
    {
        setUpTest(2);
        assertThat(s1.getAllPossibleSets(inputOfTest1, dimensions1), is(expectResults1));
    }

    @Test
    public void assetCorrectSetsTask3() throws SetSolver.ImproperDimensionException
    {
        setUpTest(3);
        assertThat(s1.getAllPossibleSets(inputOfTest1, dimensions1), is(expectResults1));
    }

    @Test
    public void assetThrowsError() throws Throwable
    {
        setUpTest(4);
        exception.expect(SetSolver.ImproperDimensionException.class);
        s1.getAllPossibleSets(inputOfTest1, dimensions1);
    }
}
