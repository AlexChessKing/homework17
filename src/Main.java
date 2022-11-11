import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();

        while(true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить\n2. Показать\n3. Удалить\n4. Найти");

            String numOperation = scanner.nextLine();

            switch (numOperation) {
                case ("1") : {
                    System.out.println("Какую покупку хотите добавить?");
                    String product = scanner.nextLine();
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
                        String numberOrProduct = scanner.nextLine();
                        if (checkType(numberOrProduct)) {
                            int number = Integer.parseInt(numberOrProduct);
                            if (number > 0 & number <= products.size()) {
                                String str = products.get(number - 1);
                                products.remove(number - 1);
                                System.out.print("Покупка \"" + str + "\" удалена. ");
                            } else {
                                System.out.println("Номер вне диапазона продуктов!");
                            }
                        } else {
                            boolean flag = true;
                            String queryLower = numberOrProduct.toLowerCase(); // Текст запроса, приведенный к нижнему регистру
                            for (String item : products) {
                                String itemLower = item.toLowerCase(); // Название покупки, приведенное к нижнему регистру
                                if (queryLower.equals(itemLower)) {
                                    products.remove(item);
                                    System.out.print("Покупка \"" + item + "\" удалена. ");
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) System.out.print("Покупка \"" + numberOrProduct + "\" не удалена. ");
                        }
                        show(products);
                        System.out.println();
                        break;
                    }
                    System.out.println();
                    break;
                }

                case ("4") : {
                    if (products.isEmpty()) {
                        System.out.println("Список покупок пуст!\n");
                        break;
                    }
                    System.out.println("Введите текст для поиска:");
                    String findProduct = scanner.nextLine();
                    boolean flag = true;
                    String queryLower = findProduct.toLowerCase(); // Текст запроса, приведенный к нижнему регистру
                    for (int i = 0; i < products.size(); i++) {
                        String itemLower = products.get(i).toLowerCase(); // Название покупки, приведенное к нижнему регистру
                        if (itemLower.contains(queryLower)) {
                            if (flag) System.out.println("Найдено:");
                            System.out.println(i + 1 + ". " + products.get(i));
                            flag = false;
                        }
                    }
                    if (flag) System.out.println("По Вашему запросу ничего не найдено!");
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
