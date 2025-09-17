// Last updated: 9/17/2025, 2:25:13 PM
class FoodRatings {
    static class Food implements Comparable<Food> {
        String name;
        int rating;
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating);
            }
            return this.name.compareTo(other.name);
        }
    }

    Map<String, String> foodToCuisine;
    Map<String, Integer> foodToRating;
    Map<String, TreeSet<Food>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>());
            cuisineMap.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);
        cuisineMap.get(cuisine).remove(new Food(food, oldRating));
        cuisineMap.get(cuisine).add(new Food(food, newRating));
        foodToRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}