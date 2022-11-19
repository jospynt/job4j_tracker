package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenDescSort() {
        Item item1 = new Item("abc");
        Item item2 = new Item("boom");
        Item item3 = new Item("test1");
        Item item4 = new Item("test2");
        List<Item> items = Arrays.asList(item3, item2, item4, item1);
        List<Item> expected = Arrays.asList(item4, item3, item2, item1);
        Collections.sort(items, new ItemDescByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }
}