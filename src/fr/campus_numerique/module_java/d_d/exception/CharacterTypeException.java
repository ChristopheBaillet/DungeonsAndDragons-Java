package fr.campus_numerique.module_java.d_d.exception;

public class CharacterTypeException extends Exception {
    @Override
    public String toString() {
        return "ce type de personnage n'est pas permis";
    }
}
