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
            int i=0;

            for(SetCard s : foundSet)
            {
                if(set.contains(s))
                    i++;
            }

            if(i==3)
                return true;
        }

        return false;
    }

    public boolean shouldBeAddedToSet(ArrayList<SetCard> cards, SetCard newCard)
    {
        HashMap<String, Boolean> properties = new HashMap<>();

        for(Map.Entry<String, String> e : newCard.dimensionValue.entrySet())
            properties.put(e.getKey(), false);

        SetCard previousCard = null;

        if(cards.size() > 1)
        {
            for (SetCard card : cards)
            {
                if (previousCard == null)
                    previousCard = card;
                else
                {
                    for(Map.Entry<String, String> e : previousCard.dimensionValue.entrySet())
                    {
                        properties.put(e.getKey(), card.dimensionValue.get(e.getKey()).equals(e.getValue()));
                    }
                }
            }

            for(Map.Entry<String, String> e : newCard.dimensionValue.entrySet())
            {
                boolean b1 = cards.get(0).dimensionValue.get(e.getKey()).equals(e.getValue());
                boolean b2 = cards.get(1).dimensionValue.get(e.getKey()).equals(e.getValue());

                if(properties.get(e.getKey()) && (!b1 || !b2))
                    return false;
                if(!properties.get(e.getKey()) && (b1 || b2))
                    return false;
            }
        }

        return true;
    }
}
