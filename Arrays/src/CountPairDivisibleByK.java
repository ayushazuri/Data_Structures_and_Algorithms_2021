//https://www.geeksforgeeks.org/count-pairs-in-array-whose-sum-is-divisible-by-k/

public class CountPairDivisibleByK {
    public static int countKdivPairs(int A[], int n, int K) {
        int freq[] = new int[K];
        for (int i = 0; i < n; i++)
            ++freq[A[i] % K];

        int sum = freq[0] * (freq[0] - 1) / 2; //For Zero take combination of half of them. (only half will be considered because they pair with
                                                // themselves

        for (int i = 1; i <= K / 2 && i != (K - i); i++)
            sum += freq[i] * freq[K - i];

        if (K % 2 == 0)                     //Same for k/2 elements, they pair with themselves
            sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);

        return sum;
    }
    public static void main(String[] args)
    {
        int A[] = { 2, 2, 1, 7, 5, 3 };
        int n = 6;
        int K = 4;
        System.out.print(countKdivPairs(A, n, K));
    }
}
