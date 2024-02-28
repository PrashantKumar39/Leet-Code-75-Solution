class Solution {

    private int[] levelSums;
    private int height;

    Solution() {
        this.levelSums = new int[100];
        this.height = 1;
    }

    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);

        var maxSumLevel = 1;
        for(int level = 2; level <= height; ++level) {
            if(levelSums[maxSumLevel] < levelSums[level])
            maxSumLevel = level;
        }

        return maxSumLevel;
            }

            private void dfs(TreeNode root, int level) {
                if (root == null)
                return;

                height = Integer.max(height, level);
                ensureCapacity();

                levelSums[level] += root.val;

                dfs(root.left, level + 1);
                dfs(root.right, level + 1);
            }

            private void ensureCapacity() {
                if(height == levelSums.length)
                   levelSums = Arrays.copyOf(levelSums, height << 1);      
            
    }
}