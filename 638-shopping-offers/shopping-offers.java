class Solution {
    int res;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        res = Integer.MAX_VALUE;
        backtrack(price, special, needs, 0, 0);

        return res;
    }

    private void backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int min, int pos) {
        int totalPrice = 0;
        for (int i = 0; i < needs.size(); i++) {
            totalPrice += needs.get(i) * price.get(i);
        }
        res = Math.min(res, min + totalPrice);

        for (int i = pos; i < special.size(); i++) {
            boolean valid = true;
            List<Integer> offer = special.get(i);

            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < offer.get(j)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                List<Integer> dummy = new ArrayList<>(needs);
                for (int j = 0; j < dummy.size(); j++) {
                    dummy.set(j, dummy.get(j) - offer.get(j));
                }
                backtrack(price, special, dummy, min + offer.get(offer.size()-1), i);
            }
        }
    }
}