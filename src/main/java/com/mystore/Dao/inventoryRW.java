package com.mystore.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.mystore.Objects.Product;

public class inventoryRW {
    public static void writeInventory (List<Product> productList) {
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Dao\\inventory.txt";
        List<Product> productServiceList = productList;

        try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            for (Product Product : productServiceList) {
                out.println(Product + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readInventory() {
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Dao\\inventory.txt";
        List<Product> objectsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String producString = parts[0].toString();
                int codeNumber = Integer.parseInt(parts[1].trim());
                int inventory = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());

                Product Product = new Product(producString, codeNumber, inventory, price);
                objectsList.add(Product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectsList;
    }
    public static void deleteInventory() {
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Dao\\inventory.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(""); // Overwrite the file with an empty string
            writer.close();
            System.out.println("Contents deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
