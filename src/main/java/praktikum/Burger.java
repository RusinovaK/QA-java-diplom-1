package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель бургера.
 * Бургер состоит из булочек и ингредиентов (начинка или соус).
 * Ингредиенты можно перемещать и удалять.
 * Можно распечать чек с информацией о бургере.
 */
public class Burger {

    public Bun bun;
    public List<Ingredient> ingredients = new ArrayList<>();

    //добавила конструктор принимающий объект класса Bun для использования стаба в тесте checkSetBuns()
    public Burger(Bun bun){
        this.bun = bun;
    }

    //добавила конструктор без параметров что-бы не сломать логику в классе Praktikum
    public Burger(){}

    //добавила поле и конструктор который принимает Ingredient ingredient для использования стаба в тесте checkAddIngredient()
    public Ingredient ingredient;
    public Burger(Ingredient ingredient){
        this.ingredient = ingredient;
    }

    //добавила конструктор принимающий объект класса Bun и список Ingredients для теста checkGetPrice().
    public Burger(Bun bun, List<Ingredient> ingredients){
        this.bun = bun;
        this.ingredients = ingredients;
    }

    public void setBuns(Bun bun) {
        this.bun = bun;
    }
 
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(int index) {
        ingredients.remove(index);
    }

    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }

    public float getPrice() {
        float price = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", getPrice()));

        return receipt.toString();
    }

}