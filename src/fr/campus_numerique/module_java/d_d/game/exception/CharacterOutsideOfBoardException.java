package fr.campus_numerique.module_java.d_d.game.exception;

public class CharacterOutsideOfBoardException extends Throwable {
    @Override
    public String toString() {
        return "Character is outside of the board";
    }
}
