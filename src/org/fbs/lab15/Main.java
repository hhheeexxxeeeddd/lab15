package org.fbs.lab15;

import org.fbs.lab15.serial.DigitalProduct;
import org.fbs.lab15.serial.Order;
import org.fbs.lab15.serial.PhysicalProduct;

import java.util.Scanner;

public class Main {
    static void main() {
        Repository<Order> orderRepo = new Repository<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Создать заказ\n2. Показать заказы\n3. Изменить статус\n4. Сохранить в файл\n5. Загрузить из файла\n0. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            try {
                if (choice == 0) break;
                switch (choice) {
                    case 1:
                        Order order = new Order(orderRepo.getAll().size() + 1);
                        order.addProduct(new PhysicalProduct("Ноутбук", 1200.0, 2.0));
                        order.addProduct(new DigitalProduct("Игры", 50.0));
                        orderRepo.add(order);
                        System.out.println("Заказ успешно создан.");
                        break;
                    case 2:
                        orderRepo.getAll().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Введите ID заказа: ");
                        int id = scanner.nextInt();
                        System.out.print("Введите новый статус (Отменен / Выполнен): ");
                        String newStatus = scanner.next();

                        Order target = orderRepo.getAll().stream()
                                .filter(o -> o.getId() == id)
                                .findFirst()
                                .orElse(null);
                        if (target != null) {
                            target.setStatus(newStatus);
                            System.out.println("Статус изменен.");
                        } else {
                            System.out.println("Заказ не найден.");
                        }
                        break;
                    case 4:
                        orderRepo.saveToFile("orders.dat");
                        System.out.println("Данные сохранены.");
                        break;
                    case 5:
                        orderRepo.loadFromFile("orders.dat");
                        System.out.println("Данные загружены.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
