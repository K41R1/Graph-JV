package main;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Vertex<T> {

    private T item;

    private LinkedList<T> neighbors;

    /**
     * @param item
     */
    public Vertex(T item) {
        this.item = item;
        this.neighbors = new LinkedList<T>();
    }

    public T getItem() {
        return item;
    }

    /**
     * @return LinkedList
     */
    public LinkedList<T> getNeighbors() {
        return neighbors;
    }

    /**
     * @param v
     * @return void
     */
    public void addNeighbor(T v) {
        if(!this.isNeighbor(v)) {
            this.neighbors.push(v);
        }
    }

    /**
     * @param v
     * @return boolean
     */
    public boolean isNeighbor(T v) {
        return this.neighbors.contains(v);
    }

    /**
     * @param v
     */
    public Vertex<T> removeNeighbor(T v) {
        if (this.isNeighbor(v)) {
            this.neighbors.remove(v);
        }
        return this;
    }

    /**
     * @return boolean
     */
    public boolean hasNeighbors() {
        return !this.neighbors.isEmpty();
    }

    /**
     *
     * @param n
     * @return boolean
     */
    public boolean hasNeighbor(T n) {
        AtomicBoolean exist = new AtomicBoolean(false);
        this.neighbors.stream().forEach(w -> {
            if (w.equals(n)) exist.set(true);
        });
        return exist.get();
    }

    /**
     * Show all neighbors
     */
    public void showNeighbors() {
        System.out.print("[");
        this.neighbors.stream().forEach(e -> {
            System.out.print(", " + e);
        });
        System.out.println("]");
    }
}
