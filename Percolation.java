public class Percolation {
    static boolean[][] visited;
    public static boolean doesItPercolate(boolean[][] system, int row, int col) {
        int len = system.length;
        if (row < 0 || row > len)
            return false;
        if (col > len || col < 0)
            return false;
        if (row == len - 1)
            return true;
        boolean left = col - 1 >= 0 ? system[row][col - 1] : false;
        boolean right = col + 1 < len ? system[row][col + 1] : false;
        boolean down = row + 1 < len ? system[row + 1][col] : false;
        if (left || right || down) {
            if (down && !visited[row + 1][col]) {
                visited[row + 1][col] = true;
                return doesItPercolate(system, row + 1, col);
            }
            if (left && !visited[row][col - 1]) {
                visited[row][col - 1] = true;
                return doesItPercolate(system, row, col - 1);
            }
            if (right && !visited[row][col + 1]) {
                visited[row][col + 1] = true;
                return doesItPercolate(system, row, col + 1);
            }
        }
        return false;
    }

    public static boolean determineSystemPercolation(boolean[][] sites) {
        boolean doesSystemPercolate = false;
        for (int i = 0; i < sites.length; i++) {
            if (sites[0][i] == true) {
                doesSystemPercolate = doesItPercolate(sites, 0, i);
                if (doesSystemPercolate)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Recursive algorithm to determine whether or not a N * N system vertically percolates
        // by Cole Carter
        boolean[][] openSites = new boolean[4][4];
        visited = new boolean[4][4];
        openSites[0][0] = true;
        openSites[1][0] = true;
        openSites[2][0] = true;
        openSites[2][1] = true;
        openSites[3][1] = true;
        System.out.print(determineSystemPercolation(openSites));
    }

}
