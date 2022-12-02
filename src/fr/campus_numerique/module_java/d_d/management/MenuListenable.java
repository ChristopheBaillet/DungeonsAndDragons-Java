package fr.campus_numerique.module_java.d_d.management;

public interface MenuListenable {
    void addMenuObserver(MenuListener menuObserver);
    void removeMenuObserver(MenuListener menuObserver);
}
