package com.shopping;

import com.shopping.model.Order;
import com.shopping.model.Product;
import com.shopping.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        OrderRepository orderRepository = context.getBean(OrderRepository.class);
        Scanner sc = new Scanner(System.in);
       //  System.out.println("Input username : ");
        while (true) {
            System.out.println("Input 1 to Create new account!" +
                    "\nInput 2 to Edit information!" +
                    "\nInput 3 to Delete information!" +
                    "\nInput 4 to Login!" +
                    "\nInput 5 to View all product!" +
                    "\nInput 6 to Search product by name!" +
                    "\nInput 7 to Search product by price!" +
                    "\nInput 8 to Create order information!" +
                    "\nInput 9 to View order!" +
                    "\nInput 10 to Exit!");
            String i = sc.next();
            String name;
            String pw;
            String email;
            switch (i) {
                case "1":
                    System.out.println("Input username : ");
                    name = sc.next();
                    User user = new User();
                    user.setName(name);
                    System.out.println("Input password : ");
                    pw = sc.next();
                    user.setPw(pw);
                    System.out.println("Input email : ");
                    email = sc.next();
                    user.setEmail(email);
                    if (userRepository.existsByEmail(email)) {
                        System.out.println("Email exited!!!");
                    } else {
                        try {
                            userRepository.save(user);
                            System.out.println("Create account success!!!");
                        } catch (Exception ex) {
                            System.out.println("Error...!!!: "+ ex.getMessage());
                        }

                    }
                    break;
                case "2":
                    System.out.println("Input your email : ");
                    email = sc.next();
                    User user1 = userRepository.findByEmail(email);
                    if (user1 != null) {
                        System.out.println("Enter the username you want to edit : ");
                        name = sc.next();
                        user1.setName(name);
                        userRepository.save(user1);
                        System.out.println("Edit account success!!!");
                    }else {
                        System.out.println("Email does not exist!!!");
                    }
                    break;
                case "3":
                    System.out.println("Input your email : ");
                    email = sc.next();
                    if (userRepository.deleteByEmail(email) == 1) {
                        System.out.println("Delete account success!!!");
                    }else {
                        System.out.println("Email does not exist!!!");
                    }
                    break;
                case "4":
                    System.out.println("Input username : ");
                    name = sc.next();
                    System.out.println("Input password : ");
                    pw = sc.next();
                    User user2 = userRepository.login(name, pw);
                    if (user2 != null ) {
                        System.out.println("Login success!!!");
                    }else {
                        System.out.println("Username or password does not exist!!!");
                    }
                    break;
                case "5":
                    productRepository.findAll().forEach(System.out::println);
                    break;
                case "6":
                    System.out.println("Input product name : ");
                    name = sc.next();
                    List<Product> products = productRepository.findByName(name);
                    products.forEach(System.out::println);
                    break;
                case "7":
                    System.out.println("Input min price : ");
                    int min = sc.nextInt();
                    System.out.println("Input max price : ");
                    int max = sc.nextInt();
                    List<Product> products1 = productRepository.findByPrice(min, max);
                    if (products1.size() > 0) {
                        products1.forEach(System.out::println);
                    }else {
                        System.out.println("Product does not exist!!!");
                    }
                    break;
                case "8":
                    Order order = new Order();
                    System.out.println("Input user id : ");
                    int userId = sc.nextInt();
                    order.setUserId(userId);
                    System.out.println("Input product id : ");
                    int productId = sc.nextInt();
                    order.setProductId(productId);
                    System.out.println("Input quantity : ");
                    int quantity = sc.nextInt();
                    order.setQuantity(quantity);
                    orderRepository.save(order);
                    break;
                case "9":
                    System.out.println("Input order id : ");
                    int id = sc.nextInt();
                    Order order1 = orderRepository.queryBy(id);
                    System.out.println(order1);
                    break;
                case "10":
                    return;
                default:
                    System.out.println("Wrong input!!!");
                    continue;
            }
        }
    }


}
