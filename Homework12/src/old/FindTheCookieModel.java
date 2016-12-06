import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JToggleButton;

/**
 * This class represents a button in a {@code CookieSweeperGrid}.
 */
@SuppressWarnings("serial") public class CookieButton extends JToggleButton {
    public final boolean found; // Whether this button hides a Cookie or not (true if not).
    private boolean clicked; // Whether this button has been clicked or not.
    public final boolean close; // Whether this button is near a cookie or not.
    public int buttonId;
    

    /**
     * Constructs a new {@code CookieButton} with a position.
     * 
     * @param id
     *            The identity number of this button, which can be used to deterCookie its position on a grid of buttons.
     */
    public CookieButton(MouseEvent event) {
        super();
        found = false ;
        clicked = false;
        this.close = false;
        this.buttonId++;
    }

    public boolean hasBeenClicked() {
        return clicked;
    }

}
