package app.constants;

public class GameConstants {
    private static Integer cols = null;
    private static Integer rows = null;

    public static int getBoardSizeRows() {
        if (cols != null) {
            return cols;
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_INITIALIZED_BATTLEGROUND_ROWS_AND_COLS_MESSAGE);

    }

    public static int getBoardSizeCols() {
        if (rows != null) {
            return rows;
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_INITIALIZED_BATTLEGROUND_ROWS_AND_COLS_MESSAGE);
    }

    public static void setBoardSizeRows(Integer boardSizeRows) {
        if (cols == null) {
            cols = boardSizeRows;
        }
    }

    public static void setBoardSizeCols(Integer boardSizeCols) {
        if (rows == null) {
            rows = boardSizeCols;
        }

    }
}
