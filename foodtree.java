package OOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class foodtree {

    abstract static class Item {
        protected String name;

        public Item(String name) {
            this.name = name;
        }

        abstract void display(String prefix, boolean isLast, boolean isBullet);
    }

    static class Category extends Item {
        private List<Item> children;

        public Category(String name) {
            super(name);
            children = new ArrayList<>();
        }

        public void addChild(Item item) {
            children.add(item);
        }

        @Override
        void display(String prefix, boolean isLast, boolean isBullet) {
            if (isBullet)
                System.out.println(prefix + "• " + name);
            else
                System.out.println(prefix + (isLast ? "└── " : "├── ") + name);
            for (int i = 0; i < children.size() - 1; i++) {
                children.get(i).display(prefix + (isLast ? "    " : "│   "), false, isBullet);
            }
            if (!children.isEmpty()) {
                children.get(children.size() - 1).display(prefix + (isLast ? "    " : "│   "), true, isBullet);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Category> selectedCategories = new ArrayList<>();
        selectedCategories.add(createFoodCategory());
        selectedCategories.add(createBeverageCategory());
        selectedCategories.add(createDairyCategory());
        selectedCategories.add(createMeatCategory());
        selectedCategories.add(createFruitCategory());
        selectedCategories.add(createVegetableCategory());
        selectedCategories.add(createCondimentsCategory());

        System.out.println("How would you like to display the hierarchy?");
        System.out.println("1. Bullet points\n2. Tree");

        int displayChoice = scanner.nextInt();

        Category rootCategory = new Category("Root");
        for (Category category : selectedCategories) {
            rootCategory.addChild(category);
        }

        if (displayChoice == 1) {
            System.out.println("Item Display as Bullet Points:");
            rootCategory.display("", true, true);
        } else {
            System.out.println("Item Display as Tree:");
            rootCategory.display("", true, false);
        }
    }

    private static Category createFoodCategory() {
        Category foodCategory = new Category("Food");
        foodCategory.addChild(new Category("Green Bean"));
        foodCategory.addChild(new Category("Pork"));
        foodCategory.addChild(new Category("Banana"));
        foodCategory.addChild(new Category("Cheese"));
        foodCategory.addChild(new Category("Beef"));
        foodCategory.addChild(new Category("Spinach"));
        foodCategory.addChild(new Category("Chicken"));
        foodCategory.addChild(new Category("Lettuce"));
        foodCategory.addChild(new Category("Butter"));
        foodCategory.addChild(new Category("Rice"));
        foodCategory.addChild(new Category("Grapes"));
        foodCategory.addChild(new Category("Cocoa"));
        foodCategory.addChild(new Category("Egg"));
        foodCategory.addChild(new Category("Fish"));
        foodCategory.addChild(new Category("Pineapple"));
        foodCategory.addChild(new Category("Carrots"));
        return foodCategory;
    }

    private static Category createBeverageCategory() {
        Category beverageCategory = new Category("Beverage");
        beverageCategory.addChild(new Category("Orange Juice"));
        beverageCategory.addChild(new Category("Shake"));
        return beverageCategory;
    }

    private static Category createDairyCategory() {
        Category dairyCategory = new Category("Dairy Product");
        dairyCategory.addChild(new Category("Milk"));
        dairyCategory.addChild(new Category("Yoghurt Cream"));
        return dairyCategory;
    }

    private static Category createMeatCategory() {
        Category meatCategory = new Category("Meat");
        meatCategory.addChild(new Category("Poultry"));
        meatCategory.addChild(new Category("Beef"));
        meatCategory.addChild(new Category("Fish"));
        return meatCategory;
    }

    private static Category createFruitCategory() {
        Category fruitCategory = new Category("Fruit");
        fruitCategory.addChild(new Category("Banana"));
        fruitCategory.addChild(new Category("Orange"));
        fruitCategory.addChild(new Category("Pineapple"));
        fruitCategory.addChild(new Category("Grapes"));
        return fruitCategory;
    }

    private static Category createVegetableCategory() {
        Category vegetableCategory = new Category("Vegetable");
        vegetableCategory.addChild(new Category("Green Bean"));
        vegetableCategory.addChild(new Category("Spinach"));
        vegetableCategory.addChild(new Category("Lettuce"));
        vegetableCategory.addChild(new Category("Tomato"));
        vegetableCategory.addChild(new Category("Carrots"));
        return vegetableCategory;
    }

    private static Category createCondimentsCategory() {
        Category condimentsCategory = new Category("Condiments");
        condimentsCategory.addChild(new Category("Soy Sauce"));
        condimentsCategory.addChild(new Category("Fish Sauce"));
        condimentsCategory.addChild(new Category("Shrimp Paste"));
        return condimentsCategory;
    }
}
