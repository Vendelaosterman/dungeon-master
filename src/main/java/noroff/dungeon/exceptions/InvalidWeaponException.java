package noroff.dungeon.exceptions;

// Custom exception class for handling invalid weapon related situations

public class InvalidWeaponException extends RuntimeException {

    public InvalidWeaponException(String message) {
        super(message);
    }

}
