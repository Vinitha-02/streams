import java.util.*;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

public class streams {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        // Adding Products
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        System.out.println("converting list to map using the Stream");

        Map<Integer, String> p = productsList.stream()
                .collect(Collectors.toMap(product -> product.id, product -> product.name));
        System.out.println(p);
        System.out.println("converting list to set using the Stream");

        Set<Float> s = productsList.stream().map(product -> product.price)
                .collect(Collectors.toSet());
        System.out.println(s);
        System.out.println("Counting the elements in the list using the stream");
        Long Count = productsList.stream().map(product -> product.name).count();
        System.out.println(Count);
        System.out.println("find the maximum elements in the list using the stream");
        Product maxi = productsList.stream().max((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println(maxi.price);
        System.out.println("find the minimum elements in the list using the stream");
        Product mini = productsList.stream().max((p1, p2) -> p1.price < p2.price ? 1 : -1).get();
        System.out.println(mini.price);
        System.out.println("method reference in the list using the stream");

        List<Integer> productPriceList = productsList.stream()

                .map(Product::getId)
                .collect(Collectors.toList());
        System.out.println(productPriceList);
        System.out.println("Filter the element in the list using the stream");
        List<Float> f = productsList.stream().filter(product -> product.price > 28000).map(Product::getPrice)
                .collect(Collectors.toList());
        System.out.println(f);
        System.out.println("Sorted the price using the stream");
        List<Float> s1 = productsList.stream().map(Product::getPrice)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(s1);
        System.out.println("Distinct the price using the stream");
        productsList.stream().map(Product::getPrice).distinct().collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
