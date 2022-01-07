package interfaces;

import exceptions.InvalidFieldException;
import view.ToolbarComponent.EditingScreen;

public interface IEditingController {
    void editEntity(EditingScreen dialog);

    void validate(EditingScreen dialog) throws InvalidFieldException;
}
