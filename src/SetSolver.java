import java.util.*;

/**
 * Created by jose on 4/17/16.
 * Last edited on 4/18/16
 */
class SetSolver
{
    // returned output
    // All the sets found within given cards
    private ArrayList<ArrayList<SetCard>> allSets;
    private final int sizeOfSet;

    class ImproperDimensionException extends Exception
    {
        ImproperDimensionException(String message)
        {
            super(message);
        }
    }

    SetSolver(int sizeOfSet)
    {
        this.sizeOfSet = sizeOfSet;
    }

    ArrayList<ArrayList<SetCard>> getAllPossibleSets(ArrayList<SetCard> cards, HashMap<String, String[]> dimensions) throws ImproperDimensionException
    {
        for(Map.Entry<String, String[]> e : dimensions.entrySet())
        {
            for(SetCard card : cards)
            {
                //makes sure all cards are from the same deck meaning have the same dimensions and possible valud
                if(!card.dimensionValue.containsKey(e.getKey()))
                {
                    throw new ImproperDimensionException(card + " is missing dimension: " + e.getKey());
                }
                else
                {
                    if(!Arrays.asList(e.getValue()).contains(card.dimensionValue.get(e.getKey())))
                        throw new ImproperDimensionException(card.dimensionValue.get(e.getKey()) + " is not a property value in " + e.getKey());
                }
            }
        }

        return getAllPossibleSets(cards);
    }

    //Starts looking for possible valid sets by starting set with every give card
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

    //inputset being the possible set being built following set rule
    //cards is every card given in output
    private void getAllPossibleSets(ArrayList<SetCard> possibleSet, ArrayList<SetCard> cards){
        for(SetCard card : cards)
        {
            if(!possibleSet.contains(card))
            {
                if (shouldBeAddedToSet(possibleSet, card))
                {
                    ArrayList<SetCard> list = new ArrayList<>(possibleSet);
                    list.add(card);

                    if(list.size() == sizeOfSet)
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

    //prevents duplicate valid sets from being added to output
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

            if(i==sizeOfSet)
                return true;
        }

        return false;
    }

    //checks if newcard is a valid addition to current set(cards)
    private boolean shouldBeAddedToSet(ArrayList<SetCard> possibleSet, SetCard newCard)
    {
        //properties stores whether all cards in set is all different or all same
        HashMap<String, Boolean> properties = new HashMap<>();

        for(Map.Entry<String, String> e : newCard.dimensionValue.entrySet())
            properties.put(e.getKey(), false);

        SetCard previousCard = null;

        if(possibleSet.size() > 1)
        {
            for (SetCard card : possibleSet)
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

            //sees if newcard follow the current dimension difference in set
            for(Map.Entry<String, String> e : newCard.dimensionValue.entrySet())
            {
                for(SetCard s : possibleSet)
                {
                    boolean b = s.dimensionValue.get(e.getKey()).equals(e.getValue());
                    if(properties.get(e.getKey()) && !b)
                        return false;
                    if(!properties.get(e.getKey()) && b)
                        return false;
                }
            }
        }

        return true;
    }
}
