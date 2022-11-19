package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class ItemAscByNameTest {
    @Test
    public void whenAscSort() {
        Item item1 = new Item("abc");
        Item item2 = new Item("boom");
        Item item3 = new Item("test1");
        Item item4 = new Item("test2");
        List<Item> items = Arrays.asList(item3, item2, item4, item1);
        List<Item> expected = Arrays.asList(item1, item2, item3, item4);
        Collections.sort(items, new ItemAscByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }
}