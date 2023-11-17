package com.mystore.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mystore.Objects.Product;

public class InventoryRW {
    public static void writeInventory (List<Product> productList) {
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Dao\\inventory.csv";
        List<Product> productServiceList = productList;

        try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            for (Product Product : productServiceList) {
                out.println(Product + ";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readInventory() {
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Dao\\inventory.csv";
        List<Product> objectsList = new ArrayList<>();

        try {
            File file = new File(path);
            try (Scanner fileScanner = new Scanner(file)) {
                //Saltar el encabezado del CSV
                fileScanner.nextLine();
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(";");
                    int codeNumber = Integer.parseInt(parts[0].trim());
                    String producString = parts[1].toString();
                    int inventory = Integer.parseInt(parts[2].trim());
                    String description = parts[3].toString();
                    // category 4
                    // tag 5
                    double price = Double.parseDouble(parts[6].trim());
                    String imageUrl = parts[7].toString();

                    Product Product = new Product(producString, codeNumber, inventory, description, price, imageUrl);
                    objectsList.add(Product);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectsList;
    }
    public static void deleteInventory() {
        String path = "C:\\Users\\cadp9\\Documents\\GitHub\\store\\src\\main\\java\\com\\mystore\\Dao\\inventory.csv";

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
