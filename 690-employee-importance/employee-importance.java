class Solution {
    
    public int dfs (int id, Map<Integer, Employee> map) {
        
        int answer = map.get (id).importance;
        
        for (int newId : map.get (id).subordinates) {
            answer += dfs (newId, map);
        }
        
        return answer;
    }
    
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> map = new HashMap<> ();
        
        for (Employee employee : employees) {
            map.put (employee.id, employee);
        }
        
        return dfs (id, map);
    }
}