package S191098026;

public class MergeSorter implements Sorter {

    private int[] a;
    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
        mergesort(0, a.length - 1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

    private void mergesort(int left, int right)
    {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergesort(left, mid);
        mergesort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right)
    {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1,index = 0;
        plan += "" + left +"<->" + right;
        while (i <= mid && j <= right)
        {
            if(a[i] <= a[j])
            {
                plan += "<->" + i;
                temp[index++] = a[i++];
            }
            else
            {
                plan += "<->" + j;
                temp[index++] = a[j++];
            }
        }
        while (i <= mid)
        {
            plan += "<->" + i;
            temp[index++] = a[i++];
        }
        while (j <= right)
        {
            plan += "<->" + j;
            temp[index++] = a[j++];
        }
        plan += "\n";
        for (int k = left; k <= right; ++k)
            a[k] = temp[k - left];
    }

}