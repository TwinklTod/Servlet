package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();
    private final Map<Integer, User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();

        model.put(1, new User("Евгений", "Скорняков", 45000));
        model.put(2, new User("Кэтрин", "Иванова", 100000));
        model.put(3, new User("Глеб", "Викторов", 120000));
        model.put(4, new User("Брюс", "Уэйн", 250000));
    }

    public void add(User user, int id) {
        model.put(id, user);
    }

    public Map<Integer, User> getFromList() {
        return model;
    }

    public boolean removeFromList(int id) {
        User removedUser = model.remove(id);
        return removedUser != null;
    }
    public void update(User user,int id) {
        model.put(id, user);
    }
}



