class FoodRatings {

    private Map<String, Integer> food_rating = new HashMap<>();
    private Map<String, String> food_cuisine = new HashMap<>();
    private Map<String,TreeSet<Pair<Integer,String>>> cuisine_ratings_food = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            food_rating.put(foods[i], ratings[i]);
            food_cuisine.put(foods[i], cuisines[i]);

            cuisine_ratings_food.computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                int compareByRating = Integer.compare(a.getKey(), b.getKey());

                if (compareByRating == 0) {
                    return a.getValue().compareTo(b.getValue());
                }
                return compareByRating;
            }))
                    .add(new Pair(-ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisineName = food_cuisine.get(food);
        TreeSet<Pair<Integer, String>> cuisineSet = cuisine_ratings_food.get(cuisineName);
        Pair<Integer, String> oldElement = new Pair<>(-food_rating.get(food), food);
        cuisineSet.remove(oldElement);
        food_rating.put(food, newRating);
        cuisineSet.add(new Pair<>(-newRating, food));

    }

    public String highestRated(String cuisine) {

        Pair<Integer, String> highestRated = cuisine_ratings_food.get(cuisine).first();
        return highestRated.getValue();

    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */