// Last updated: 9/19/2025, 11:48:46 AM
class Spreadsheet {


    private Map<String, Integer> spreadsheet = new HashMap<>();
    
    public Spreadsheet(int rows) {}
    
    public void setCell(String cell, int value) {
        spreadsheet.put(cell, value);
    }
    
    public void resetCell(String cell) {
        spreadsheet.put(cell, 0);
    }
    
    public int getValue(String formula) {
        int sum = 0;
        for (String s : formula.substring(1).split("\\+")) {
            sum += mapToValue(s);
        }
        return sum;
    }

    private int mapToValue(String s) {
        return Character.isLetter(s.charAt(0)) ? spreadsheet.getOrDefault(s, 0) : Integer.parseInt(s);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */