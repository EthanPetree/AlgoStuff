package edu.neumont.csc250.sorting.data;

public class Person implements Comparable<Person> {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Person other) {
        if (other == null) return 1;
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person other)) return false;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Person{id=" + id + '}';
    }
}
