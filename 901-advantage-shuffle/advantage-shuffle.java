class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Integer[] ord = new Integer[B.length];
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) ord[i] = i;
        Arrays.sort(ord, (a,b) -> Integer.compare(B[b], B[a]));
        Arrays.sort(A);
        int i = 0, j = B.length - 1;
        for (int ix : ord)
            ans[ix] = A[j] > B[ix] ? A[j--] : A[i++];
        return ans;
    }
}