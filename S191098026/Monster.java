package S191098026;

public class Monster implements Linable 
{

    private final int r;
    private final int g;
    private final int b;
    private final int rank;
    private Position position;

    Monster(int r, int g, int b, int rank) 
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rank = rank;
    }

    @Override
    public String toString() {
        String srank = Integer.toString(rank);
        if (srank.length() == 1) srank += "  ";
        else if (srank.length() == 2) srank += " ";
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + srank + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getValue() {
        return rank;
    }

    public void swapPosition(Monster another) 
    {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

}