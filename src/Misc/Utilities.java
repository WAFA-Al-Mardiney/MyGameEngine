package Misc;

import java.util.Random;

public final class Utilities
{
    public static int GetRandomNumberWithWeightingArray(int[] array)
    {
        int x = new Random().nextInt(array[array.length - 1] - 1);
        for (int i = 0; i < array.length; i++)
            if (x <= array[i])
            {
                x = i;
                break;
            }
        return x;
    }
}
