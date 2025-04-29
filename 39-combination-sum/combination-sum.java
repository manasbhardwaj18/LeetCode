import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        findCombinations(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void findCombinations(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}