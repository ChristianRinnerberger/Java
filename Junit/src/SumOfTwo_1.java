import java.util.HashSet;

public class SumOfTwo_1 {

    int[] a;
    int[] b;

    HashSet<Integer> hashSet;

    public SumOfTwo_1() {
        a = new int[4];
        b = new int[4];
        hashSet = new HashSet<>();
    }

    public int[] getA()
    {
        return a;
    }

    public void setA(int[] a)
    {
        this.a = a;
    }

    public int[] getB()
    {
        return b;
    }

    public void setB(int[] b)
    {
        this.b = b;
    }


    public boolean sumOfTwo(int[] a, int[] b, int targetValue)
    {

        for (int x = 0; x < a.length; x++)
        {
            setA(this.a);
            for (int y = 0; y < b.length; y++)
            {
                setB(this.b);
                hashSet.add(b[y]);
            }
            if (hashSet.contains(targetValue - a[x]))
            {
                return true;
            }
        }
        return false;
    }
}
