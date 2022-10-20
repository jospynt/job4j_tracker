package ru.job4j.tracker;

public final class SingleTracker {

    private static SingleTracker tracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (tracker == null) {
            tracker = new SingleTracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
