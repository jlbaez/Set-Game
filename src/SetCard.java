/**
 * SetGame
 * Created by jose on 4/16/16.
 * Last edited on 4/16/16
 */
class SetCard
{
     enum Color {red, green, purple}
     enum Symbol {squiggle, diamond, oval}
     enum Shading {solid, striped, outlined}
     enum Number {one, two, three}

     Color color;
     Symbol symbol;
     Shading shading;
     Number number;

    SetCard(Color color, Symbol symbol, Shading shading, Number number)
    {
        this.color = color;
        this.symbol = symbol;
        this.shading = shading;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return false;
        if (o == null || getClass() != o.getClass()) return false;

        SetCard setCard = (SetCard) o;

        return shading == setCard.shading && number == setCard.number && symbol == setCard.symbol && color == setCard.color;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (shading != null ? shading.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "SetCard{" +
                "color=" + color +
                ", symbol=" + symbol +
                ", shading=" + shading +
                ", number=" + number +
                '}';
    }
}
