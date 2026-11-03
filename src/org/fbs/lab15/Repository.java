package org.fbs.lab15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) { items.add(item); }
    public List<T> getAll() { return items; }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(items);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            items = (List<T>) ois.readObject();
        }
    }
}