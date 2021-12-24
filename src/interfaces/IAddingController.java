package interfaces;

import exceptions.InvalidFieldException;
import view.ToolbarComponent.AddingScreen;

public interface IAddingController {
    void addNewEntity(AddingScreen dialog);
    void validate(AddingScreen dialog) throws InvalidFieldException;
}
