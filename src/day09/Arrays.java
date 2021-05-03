package day09;

public class Arrays {

    public static long[] copyOfRange(long[] source, int start, int end) {
        long[] result = new long[end - start];
        for (int i = start; i < end; i++)
            result[i - start] = source[i];

        return result;
    }

    public static void sort(long[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(long[] arr, int start, int end) {
        long pivot = arr[end];
        int i = start;
        int j = end;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                long temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }
        if (start < j) quickSort(arr, start, j);
        if (i < end) quickSort(arr, i, end);
    }
}
