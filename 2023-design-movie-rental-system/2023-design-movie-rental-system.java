class MovieRentingSystem {

    class PriceShop implements Comparable<PriceShop> {
        int price, shop;
        PriceShop(int price, int shop) { this.price = price; this.shop = shop; }
        public int compareTo(PriceShop o) {
            if (this.price != o.price) return this.price - o.price;
            return this.shop - o.shop;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof PriceShop)) return false;
            PriceShop p = (PriceShop) o;
            return price == p.price && shop == p.shop;
        }
        @Override
        public int hashCode() { return Objects.hash(price, shop); }
    }

    class RentedMovie implements Comparable<RentedMovie> {
        int price, shop, movie;
        RentedMovie(int price, int shop, int movie) {
            this.price = price; this.shop = shop; this.movie = movie;
        }
        public int compareTo(RentedMovie o) {
            if (this.price != o.price) return this.price - o.price;
            if (this.shop != o.shop) return this.shop - o.shop;
            return this.movie - o.movie;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof RentedMovie)) return false;
            RentedMovie r = (RentedMovie) o;
            return price == r.price && shop == r.shop && movie == r.movie;
        }
        @Override
        public int hashCode() { return Objects.hash(price, shop, movie); }
    }

    Map<Integer, TreeSet<PriceShop>> available;      // movie -> {price, shop}
    Map<Integer, Map<Integer, Integer>> movieToShopPrice; // movie -> (shop -> price)
    TreeSet<RentedMovie> rented;                     // sorted rented movies

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        movieToShopPrice = new HashMap<>();
        rented = new TreeSet<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];

            available.computeIfAbsent(movie, k -> new TreeSet<>()).add(new PriceShop(price, shop));
            movieToShopPrice.computeIfAbsent(movie, k -> new HashMap<>()).put(shop, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (available.containsKey(movie)) {
            int count = 0;
            for (PriceShop ps : available.get(movie)) {
                res.add(ps.shop);
                count++;
                if (count >= 5) 
                    break;
            }
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = movieToShopPrice.get(movie).get(shop);
        available.get(movie).remove(new PriceShop(price, shop));
        rented.add(new RentedMovie(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = movieToShopPrice.get(movie).get(shop);
        available.get(movie).add(new PriceShop(price, shop));
        rented.remove(new RentedMovie(price, shop, movie));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (RentedMovie rm : rented) {
            res.add(Arrays.asList(rm.shop, rm.movie));
            count++;
            if (count >= 5) 
                break;
        }
        return res;
    }
}