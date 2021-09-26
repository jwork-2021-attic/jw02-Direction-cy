package S191098026;

public class Snake 
{

    private static Snake theSnake;
    private Sorter sorter;

    private Snake() {}

    public static Snake getTheSnake() 
    {
        if (theSnake == null) 
        {
            theSnake = new Snake();
        }
        return theSnake;
    }

    public void setSorter(Sorter sorter) 
    {
        this.sorter = sorter;
    }

    public String lineUp(Line line) 
    {
        String log = new String();
        if (sorter == null) 
            return null;

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();
        String[] sortSteps = this.parsePlan(sorter.getPlan());
        for (String step : sortSteps) {
            this.execute(line,step);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }
        return log;

    }

    public String matrixUp(Matrix matrix) 
    {
        String log = new String();
        if (sorter == null) 
            return null;

        Linable[] linables = matrix.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) 
            ranks[i] = linables[i].getValue();

        sorter.load(ranks);
        sorter.sort();
        String[] sortSteps = this.parsePlan(sorter.getPlan());
        for (String step : sortSteps) {
            this.execute(matrix,step);
            System.out.println(matrix.toString());
            log += matrix.toString();
            log += "\n[frame]\n";
        }
        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(Line line, String step) {
        String[] couple = step.split("<->");
        if (couple.length == 2)
        {
            Monster m1 = (Monster) line.get(Integer.parseInt(couple[0]));
            Monster m2 = (Monster) line.get(Integer.parseInt(couple[1]));
            m1.swapPosition(m2);
        }
        else
        {
            int left = Integer.parseInt(couple[0]), right = Integer.parseInt(couple[1]);
            Linable[] linables = new Linable[right + 1];
            for (int i = left; i <= right; ++i)
                linables[i] = line.get(i);
            for (int i = 2; i < couple.length; ++i)
                line.put(linables[Integer.parseInt(couple[i])], left + i - 2);
        }
    }

    private void execute(Matrix matrix, String step) {
        String[] couple = step.split("<->");
        int left = Integer.parseInt(couple[0]), right = Integer.parseInt(couple[1]);
        if (couple.length == 2)
        {
            Monster m1 = (Monster) matrix.get(left / matrix.length, left % matrix.length);
            Monster m2 = (Monster) matrix.get(right / matrix.length, right % matrix.length);
            m1.swapPosition(m2);
        }
        else
        {
            
            Linable[] linables = new Linable[right + 1];
            for (int i = left; i <= right; ++i)
                linables[i] = matrix.get(i / matrix.length, i % matrix.length);
            for (int i = 2; i < couple.length; ++i)
                matrix.put(linables[Integer.parseInt(couple[i])], (left + i - 2) / matrix.length,(left + i - 2) % matrix.length);
        }
    }

}
