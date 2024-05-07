package at.ac.fhcampuswien.fhmdb.controllers;

@FunctionalInterface
public interface ClickEventHandler<T> {
    void onClick(T t);
}
