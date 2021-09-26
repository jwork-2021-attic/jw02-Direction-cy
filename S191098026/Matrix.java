package S191098026;

public class Matrix
{
    private Line[] lines;
    public int length;
    public int width;

    public Matrix(int length, int width) 
    {
        this.length = length;
        this.width = width;
        lines = new Line[length];
        for (int i = 0; i < length; ++i)
            lines[i] = new Line(width);
    }

    public void put(Linable linable, int i, int j) 
    {
        lines[i].put(linable, j);
    }

    public Linable get(int i, int j) 
    {
        if ((i < 0) || (i > length)) return null;
        else return lines[i].get(j);
    }


    @Override
    public String toString() 
    {
        String matrixString = "";
        for (Line line : lines) 
            matrixString = matrixString + line.toString() + "\n";
        return matrixString;
    }

    public Linable[] toArray() 
    {
        Linable[] linables = new Linable[length * width];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < width; j++)
                linables[i * width + j] = lines[i].get(j);
        return linables;
    }

}
