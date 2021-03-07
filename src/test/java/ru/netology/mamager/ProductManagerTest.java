package ru.netology.mamager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Абука", 137, "А.Попов");
    Product second = new Book(2, "Волшебство", 19, "А.Попов");
    Product third = new Book(3, "Ночь", 1789, "С.Сидоров");
    Product fourth = new Smartphone(4, "Айфон", 473, "Эпл");
    Product fifth = new Smartphone(5, "Гелакси", 5, "Самсунг");


    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void searchByName() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Ночь");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameBook() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Ночь");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesAuthor() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("С.Сидоров");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesManufacture() {
        setUp();

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Эпл");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameSmartphone() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Гелакси");
        assertArrayEquals(expected, actual);
    }

    //    поиск всех книг одного автора
    @Test
    void searchAllByAuthor() {
        setUp();

        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.searchBy("А.Попов");
        assertArrayEquals(expected, actual);
    }
    //    Запрос, на который нет ответа
    @Test
    void searchAll() {
        setUp();

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("А.Поповы");
        assertArrayEquals(expected, actual);
    }


}