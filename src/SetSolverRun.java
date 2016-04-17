import java.util.ArrayList;

/**
 * SetGame
 * Created by jose on 4/17/16.
 * Last edited on 4/17/16
 */
public class SetSolverRun {
    public static void main(String[] args)
    {
        ArrayList<SetCard> input = new ArrayList<>();

        input.add(new SetCard(SetCard.Color.red, SetCard.Symbol.diamond, SetCard.Shading.solid, SetCard.Number.one));
        input.add(new SetCard(SetCard.Color.red, SetCard.Symbol.squiggle, SetCard.Shading.solid, SetCard.Number.one));
        input.add(new SetCard(SetCard.Color.red, SetCard.Symbol.oval, SetCard.Shading.solid, SetCard.Number.one));

        input.add(new SetCard(SetCard.Color.purple, SetCard.Symbol.diamond, SetCard.Shading.solid, SetCard.Number.one));
        input.add(new SetCard(SetCard.Color.purple, SetCard.Symbol.diamond, SetCard.Shading.striped, SetCard.Number.one));
        input.add(new SetCard(SetCard.Color.purple, SetCard.Symbol.diamond, SetCard.Shading.outlined, SetCard.Number.one));

        input.add(new SetCard(SetCard.Color.green, SetCard.Symbol.diamond, SetCard.Shading.outlined, SetCard.Number.one));
        input.add(new SetCard(SetCard.Color.green, SetCard.Symbol.diamond, SetCard.Shading.outlined, SetCard.Number.two));
        input.add(new SetCard(SetCard.Color.green, SetCard.Symbol.diamond, SetCard.Shading.outlined, SetCard.Number.three));

        /*
        int i =0;
        while(i != 2) {
            for (SetCard.Color color : SetCard.Color.values()) {
                for (SetCard.Symbol symbol : SetCard.Symbol.values()) {
                    for (SetCard.Shading shading : SetCard.Shading.values()) {
                        for (SetCard.Number number : SetCard.Number.values()) {
                            input.add(new SetCard(color, symbol, shading, number));
                        }
                    }
                }
            }
            i++;
        }
        */

        SetSolver s = new SetSolver();

        ArrayList<ArrayList<SetCard>> allSet = s.getAllPossibleSets(input);

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
