package handler;

public abstract class InProgressState implements GameState {

    @Override
    public boolean isGameOver() {
        return false;
    }
}
