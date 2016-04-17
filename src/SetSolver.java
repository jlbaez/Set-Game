import java.util.Arrays;
import java.util.ArrayList;

/**
 * SetGame
 * Created by jose on 4/16/16.
 * Last edited on 4/16/16
 */
class SetSolver
{
    private ArrayList<ArrayList<SetCard>> allSets;

    ArrayList<ArrayList<SetCard>> getAllPossibleSets(ArrayList<SetCard> cards)
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

                    if(list.size() == 3 && !alreadyInSet(list, allSets))
                    {
                        allSets.add(list);
                        return;
                    }
                    getAllPossibleSets(list, cards);
                }
            }
        }
    }

    private boolean alreadyInSet(ArrayList<SetCard> set, ArrayList<ArrayList<SetCard>> allSets)
    {
        for(ArrayList<SetCard> foundSet : allSets)
        {
            int foundCard = 0;
            for(SetCard card : set)
            {
                if(foundSet.contains(card))
                    foundCard++;
            }

            if(foundCard == 3)
                return true;
        }

        return false;
    }

    private boolean shouldBeAddedToSet(ArrayList<SetCard> cards, SetCard newCard)
    {
        boolean[] properties = new boolean[4];

        Arrays.fill(properties, true);

        SetCard previousCard = null;

        if(cards.size() > 1)
        {
            for (SetCard card : cards)
            {
                if (previousCard == null)
                    previousCard = card;
                else
                {
                    if (card.color != previousCard.color)
                        properties[0] = false;
                    if (card.symbol != previousCard.symbol)
                        properties[1] = false;
                    if (card.shading != previousCard.shading)
                        properties[2] = false;
                    if (card.number != previousCard.number)
                        properties[3] = false;
                }
            }

            boolean colorValid = false;
            boolean symbolValid = false;
            boolean shadingValid = false;
            boolean numberValid = false;

            if((properties[0] && cards.get(0).color == newCard.color&& cards.get(1).color == newCard.color)
                    || (!properties[0] && cards.get(0).color != newCard.color&& cards.get(1).color != newCard.color))
                colorValid = true;
            if((properties[1] && cards.get(0).symbol == newCard.symbol && cards.get(1).symbol == newCard.symbol)
                    || (!properties[1] && cards.get(0).symbol != newCard.symbol && cards.get(1).symbol != newCard.symbol))
                symbolValid = true;
            if((properties[2] && cards.get(0).shading == newCard.shading && cards.get(1).shading == newCard.shading)
                    || (!properties[2] && cards.get(0).shading != newCard.shading && cards.get(1).shading != newCard.shading))
                shadingValid = true;
            if((properties[3]  && cards.get(0).number == newCard.number&& cards.get(1).number == newCard.number)
                    || (!properties[3] && cards.get(0).number != newCard.number && cards.get(1).number != newCard.number))
                numberValid = true;

            if(colorValid && symbolValid && shadingValid && numberValid)
                return true;
        }
        else
        {
            return true;
        }

        return false;
    }
}
