package Options;

import menu.Action;

public class TransposedMatrixShow implements Action{

    @Override
    public void performAction() {
        System.out.println(MatrixTranspose.getMatrix() == null ? "Transposed Matrix not available"
                                                                : MatrixTranspose.getMatrix().show());    
    }
}
