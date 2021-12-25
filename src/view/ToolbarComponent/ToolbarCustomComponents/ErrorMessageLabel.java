package view.ToolbarComponent.ToolbarCustomComponents;

import javax.swing.*;
import java.awt.*;

public class ErrorMessageLabel extends JLabel {
    public ErrorMessageLabel(String text, int width, int height) {
        super(text);
        this.setFont(new Font("serif", Font.PLAIN, 9));
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
    }
}
