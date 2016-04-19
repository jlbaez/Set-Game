import java.util.HashMap;
import java.util.Map;

/**
 * Created by jose on 4/17/16.
 * Last edited on 4/18/16
 */
class SetCard
{
    HashMap<String, String> dimensionValue;

    SetCard()
    {
        dimensionValue = new HashMap<>();
    }

    void addDimension(String[] dimension)
    {
       if(dimension.length == 2)
           this.dimensionValue.put(dimension[0], dimension[1]);
    }

    public int numberOfSameProperties(SetCard s)
    {
        int numberOfSame = 0;
        for(Map.Entry<String, String> dimension : dimensionValue.entrySet())
        {
            if(s.dimensionValue.get(dimension.getKey()).equals(dimension.getValue()))
                numberOfSame++;
        }

        return numberOfSame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetCard setCard = (SetCard) o;

        for (Map.Entry<String, String> dimension : dimensionValue.entrySet())
        {
            if(!setCard.dimensionValue.containsKey(dimension.getKey()))
                return false;

            if(!setCard.dimensionValue.get(dimension.getKey()).equals(dimension.getValue()))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return dimensionValue != null ? dimensionValue.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        String returnValue = "SetCard{";
        for (Map.Entry<String, String> dimension : dimensionValue.entrySet())
        {
            returnValue += dimension.getKey() + "=" + dimension.getValue() + ",";
        }

        returnValue = returnValue.substring(0, returnValue.length() -1) + "}";

        return returnValue;
    }
}
