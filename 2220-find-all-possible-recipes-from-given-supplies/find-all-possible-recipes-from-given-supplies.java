class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); 
        Map<String, Integer> indegree = new HashMap<>();   
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());

            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>(available);

        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (!graph.containsKey(item)) continue;

            for (String recipe : graph.get(item)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    result.add(recipe);
                    queue.add(recipe);
                }
            }
        }

        return result;
    }
}