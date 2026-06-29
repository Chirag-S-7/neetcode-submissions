class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val orig = image[sr][sc]
        if (orig == color) return image
        val m = image.size
        val n = image[0].size

        fun dfs(r: Int, c: Int) {
            if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != orig) return
            image[r][c] = color
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        dfs(sr, sc)
        return image
    }
}
