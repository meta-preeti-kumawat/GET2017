package Options;

import menu.Action;

public class OriginalMatrixShow implements Action{

    @Override
    public void performAction() {
        System.out.println( MatrixCreation.getMatrix() == null ? "No Matrix available yet"
                                                                : MatrixCreation.getMatrix().show());    
    }
}
