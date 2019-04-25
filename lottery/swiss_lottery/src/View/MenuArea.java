package View;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuArea extends MenuBar {

    private Menu menu = new Menu("Menu");
    private Menu design = new Menu("Design");
    protected MenuItem exit = new MenuItem("Exit");
    protected MenuItem odds = new MenuItem("Odds");
    protected MenuItem lottoMode = new MenuItem("Lotto Mode");
    protected MenuItem darkMode = new MenuItem("Dark Mode");
    protected MenuItem reset = new MenuItem("Reset");

    public MenuArea(){
        super();
        this.menu.getItems().addAll(odds, reset, exit);
        this.design.getItems().addAll(lottoMode, darkMode);
        this.getMenus().addAll(menu, design);

    }
}
