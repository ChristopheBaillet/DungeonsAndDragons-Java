package fr.campus_numerique.module_java.d_d.exception;

public class CharacterOutsideOfBoardException extends Exception {
    @Override
    public String toString() {
        return "Character is outside of the board";
    }
}
