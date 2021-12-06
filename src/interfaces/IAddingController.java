package interfaces;

import view.ToolbarComponent.AddingScreen;
import view.TablesComponent.Tables;

public interface IAddingController {
    public void addNewEntity(AddingScreen dialog);
    public void addObserver(Tables table);
}
