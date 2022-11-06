import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();

        while(true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить\n2. Показать\n3. Удалить");

            String numOperation = scanner.next();

            switch (numOperation) {
                case ("1") : {
                    System.out.println("Какую покупку хотите добавить?");
                    String product = scanner.next();
                    products.add(product);
                    System.out.println("Добавлено \"" + product + "\". Итого в списке покупок: " + products.size() + "\n");
                    break;
                }

                case ("2") : {
                    show(products);
                    System.out.println();
                    break;
                }

                case ("3") : {
                    show(products);
                    if (!products.isEmpty()) {
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        String numberOrProduct = scanner.next();
                        if (checkType(numberOrProduct)) {
                            String str = products.get(Integer.parseInt(numberOrProduct) - 1);
                            products.remove(Integer.parseInt(numberOrProduct) - 1);
                            System.out.print("Покупка " + str + " удалена. ");
                        } else {
                            products.remove(numberOrProduct);
                            System.out.print("Покупка " + numberOrProduct + " удалена. ");
                        }
                        show(products);
                        System.out.println();
                        break;
                    }
                    System.out.println();
                    break;
                }

                default:
                    System.out.println("Номер вне диапазона операций. Введите правильный номер!");
            }
        }
    }

    public static void show (List<String> products) {
        if(!products.isEmpty()) {
            System.out.println("Список покупок:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println(i + 1 + ". " + products.get(i));
            }
        } else {
            System.out.println("Список покупок пуст!");
        }
    }

    private static boolean checkType (String numberOrProduct) {
        try {
            Integer.parseInt(numberOrProduct);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
