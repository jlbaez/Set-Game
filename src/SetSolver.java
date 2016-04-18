import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jose on 4/17/16.
 * Last edited on 4/17/16
 */
public class SetSolver
{
    private ArrayList<ArrayList<SetCard>> allSets;
    private HashMap<String, String[]> dimensions;

    class ImproperDimensionValueException extends Exception
    {
        ImproperDimensionValueException(String message)
        {
            super(message);
        }
    }

    ArrayList<ArrayList<SetCard>> getAllPossibleSets(ArrayList<SetCard> cards, HashMap<String, String[]> dimensions)
    {
        this.dimensions = dimensions;
        return getAllPossibleSets(cards);
    }

    private ArrayList<ArrayList<SetCard>> getAllPossibleSets(ArrayList<SetCard> cards)
    {
        //System.out.println(cards);
        allSets = new ArrayList<>();
        for(SetCard card : cards)
        {
            ArrayList<SetCard> set = new ArrayList<>();
            set.add(card);
            getAllPossibleSets(set, cards);
        }

        return allSets;
    }

    private void getAllPossibleSets(ArrayList<SetCard> inputSets, ArrayList<SetCard> cards){
        for(SetCard card : cards)
        {
            if(!inputSets.contains(card))
            {
                if (shouldBeAddedToSet(inputSets, card))
                {
                    ArrayList<SetCard> list = new ArrayList<>(inputSets);
                    list.add(card);

                    if(list.size() == 3)
                    {
                        /*
                        System.out.println();
                        for(ArrayList<SetCard> set : allSets)
                        {
                            for(SetCard card2 : set)
                            {
                                System.out.println(card2 + " ");
                            }
                            System.out.println();
                        }

                        System.out.println("set " + list);
                        System.out.println("alreadinsert " + alreadyInAllSets(list));
                        */
                        if(!alreadyInAllSets(list))
                        {
                            allSets.add(list);
                        }

                        return;
                    }

                    getAllPossibleSets(list, cards);
                }
            }
        }
    }

    private boolean alreadyInAllSets(ArrayList<SetCard> set)
    {
        for(ArrayList<SetCard> foundSet : allSets)
        {
            //System.out.println(foundSet.containsAll(set));
            return foundSet.containsAll(set);
        }

        return false;
    }

    private boolean shouldBeAddedToSet(ArrayList<SetCard> cards, SetCard newCard)
    {
        HashMap<String, Boolean> properties = new HashMap<>();

        for(Map.Entry<String, String> e : newCard.dimensionValue.entrySet())
            properties.put(e.getValue(), false);

        SetCard previousCard = null;

        if(cards.size() > 1)
        {
            for (SetCard card : cards)
            {
                if (previousCard == null)
                    previousCard = card;
                else
                {
                    for(Map.Entry<String, String> e : newCard.dimensionValue.entrySet())
                    {
                        properties.put(e.getKey(), card.dimensionValue.get(e.getKey()).equals(e.getValue()));
                    }
                }
            }

            for(Map.Entry<String, String> e : newCard.dimensionValue.entrySet())
            {
                if(properties.get(e.getKey()) && (!cards.get(0).equals(e.getValue()) || !cards.get(1).equals(e.getValue()))
                        && !properties.get(e.getKey()) && (cards.get(0).equals(e.getValue()) || cards.get(1).equals(e.getKey())))
                    return false;
            }
        }

        return true;
    }
}
