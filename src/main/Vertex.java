package main;

import java.util.LinkedList;

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

    /*public static <type> main.Vertex createFrom(Object e) {
        return new main.Vertex<type>((type) e);
    }*/

    public void showNeighbors() {
        System.out.print("[");
        for (T i: this.neighbors){
            System.out.print(", " + i);
        }
        System.out.println("]");
    }
}
