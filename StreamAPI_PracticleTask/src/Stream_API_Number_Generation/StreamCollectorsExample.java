package Stream_API_Number_Generation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StreamCollectorsExample {
	
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        
     // Group by product and sum cost
        Map<String, Double> totalCostByProduct =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getProduct,
                                Collectors.summingDouble(Order::getCost)
                        ));

        // Sort descending and take top 3
        List<Map.Entry<String, Double>> topProducts =
                totalCostByProduct.entrySet()
                        .stream()
                        .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                        .limit(3)
                        .collect(Collectors.toList());

//        Print result
        System.out.println("Top 3 most expensive products:");
        for (Map.Entry<String, Double> entry : topProducts) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
    }
}