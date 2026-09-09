class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        findSubsets(nums, 0, subsets, sets);
        return sets;
    }

    private void findSubsets(int[] arr, int i, List<Integer> subsets, List<List<Integer>> sets) {
        if (i >= arr.length) {
            sets.add(new ArrayList<>(subsets));
            return;
        }
        subsets.add(arr[i]);
        findSubsets(arr, i + 1, subsets, sets);
        subsets.removeLast();
        findSubsets(arr, i + 1, subsets, sets);
    }
}
