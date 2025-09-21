// Last updated: 9/21/2025, 1:08:00 PM
class MovieRentingSystem {
    private final Map<Integer, TreeSet<Movie>> rented, available;
    private final Map<String, Movie> movies;
    private final TreeSet<Movie> report;
    private final int n;

    public MovieRentingSystem(final int n, final int[][] entries) {
        this.rented = new HashMap<>();
        this.available = new HashMap<>();
        this.movies = new HashMap<>();
        this.report = new TreeSet<>();
        this.n = n;

        for(final int[] entry : entries) {
            final Movie movie = new Movie(entry[0], entry[1], entry[2]);
            final TreeSet<Movie> ts = this.available.getOrDefault(entry[1], new TreeSet<>());

            this.available.put(entry[1], ts);
            ts.add(movie);

            this.movies.put(String.format("%d-%d", entry[0], entry[1]), movie);
        }
    }
    
    public List<Integer> search(final int movie) {
        final List<Integer> result = new ArrayList<>();

        if(!this.available.containsKey(movie))
            return result;

        final int size = Math.min(5, this.available.get(movie).size());
        int i = 0;

        for(final Movie m : this.available.get(movie)) {
            if(size == i)
                return result;
            result.add(m.getShop());
            ++i;
        }

        return result;
    }
    
    public void rent(final int shop, final int movie) {
        final String key = String.format("%d-%d", shop, movie);
        final Movie m = this.movies.get(key);

        this.available.get(movie).remove(m);
        this.rented.putIfAbsent(movie, new TreeSet<>());
        this.rented.get(movie).add(m);

        this.report.add(m);
    }
    
    public void drop(final int shop, final int movie) {
        final String key = String.format("%d-%d", shop, movie);
        final Movie m = this.movies.get(key);

        this.rented.get(movie).remove(m);
        this.available.get(movie).add(m);

        if(this.report.contains(m))
            this.report.remove(m);
    }
    
    public List<List<Integer>> report() {
        final List<List<Integer>> result = new ArrayList<>();
        final int size = Math.min(5, this.report.size());
        int i = 0;

        for(final Movie movie : this.report) {
            if(size == i)
                return result;

            result.add(List.of(movie.getShop(), movie.getMovie()));
            i++;
        }

        return result;
    }

    private final class Movie implements Comparable<Movie> {
        private final int shop, movie, price;

        public Movie(final int shop, final int movie, final int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        public int getShop() {
            return this.shop;
        }

        public int getMovie() {
            return this.movie;
        }

        public int getPrice() {
            return this.price;
        }

        @Override
        public int compareTo(final Movie m) {
            return this.getPrice() == m.getPrice() ? (this.getShop() == m.getShop() ? this.getMovie() - m.getMovie() : this.getShop() - m.getShop()) : this.getPrice() - m.getPrice();
        }

        @Override
        public String toString() {
            return String.format("{shop=%d, movie=%d, price=%d}", this.shop, this.movie, this.price);
        }
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */