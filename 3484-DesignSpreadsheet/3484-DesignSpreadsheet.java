// Last updated: 9/19/2025, 11:48:04 AM
import java.util.*;

class Spreadsheet {
    private int rows;
    private Map<String, Integer> cells;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        return get(parts[0]) + get(parts[1]);
    }

    private int get(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return cells.getOrDefault(s, 0);
        }
    }
}