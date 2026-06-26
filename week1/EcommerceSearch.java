class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    static Product linearSearch(Product[] arr, int targetId) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productId == targetId)
                return arr[i];
        }
        return null;
    }

    static Product binarySearch(Product[] arr, int targetId) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].productId == targetId)
                return arr[mid];
            else if (arr[mid].productId < targetId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(105, "Wireless Headphones", "Electronics"),
            new Product(203, "Running Shoes",       "Footwear"),
            new Product(47,  "Yoga Mat",            "Sports"),
            new Product(312, "Laptop Stand",        "Accessories"),
            new Product(88,  "Coffee Maker",        "Appliances")
        };

        Product[] sortedProducts = {
            new Product(47,  "Yoga Mat",            "Sports"),
            new Product(88,  "Coffee Maker",        "Appliances"),
            new Product(105, "Wireless Headphones", "Electronics"),
            new Product(203, "Running Shoes",       "Footwear"),
            new Product(312, "Laptop Stand",        "Accessories")
        };

        int target = 203;

        System.out.println("Searching for productId = " + target);
        System.out.println();

        Product r1 = linearSearch(products, target);
        if (r1 != null)
            System.out.println("Linear Search Found: " + r1.productId + " | " + r1.productName + " | " + r1.category);
        else
            System.out.println("Linear Search: Not Found");

        Product r2 = binarySearch(sortedProducts, target);
        if (r2 != null)
            System.out.println("Binary Search Found: " + r2.productId + " | " + r2.productName + " | " + r2.category);
        else
            System.out.println("Binary Search: Not Found");

        System.out.println();
        System.out.println("--- Time Complexity Analysis ---");
        System.out.println("Linear Search: Best O(1)  | Average O(n)     | Worst O(n)");
        System.out.println("Binary Search: Best O(1)  | Average O(log n) | Worst O(log n)");
        System.out.println();
        System.out.println("Binary Search is better for e-commerce platforms.");
        System.out.println("Large product catalogues need fast search -> O(log n) scales well.");
        System.out.println("Linear Search is only good for very small or unsorted data.");
    }
}