package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product first = new Book(1, "Абука", 137, "А.Попов");
    Product second = new Book(2, "Волшебство", 19, "А.Попов");
    Product third = new Book(3, "Ночь", 1789, "С.Сидоров");
    Product fourth = new Smartphone(4, "Айфон", 473, "Эпл");
    Product fifth = new Smartphone(5, "Гелакси", 5, "Самсунг");


    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    void shouldRemoveById() {
        setUp();
        Product[] expected = new Product[]{first, second, fourth, fifth};
        repository.removeById(3);
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldExceptionRemoveNotExistedId() {
        setUp();
        assertThrows(NotFoundException.class, () -> repository.removeById(6));
    }

}