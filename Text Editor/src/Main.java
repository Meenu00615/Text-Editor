import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Applying java swing for GUI
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

class editor extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Text component
    JTextArea t;

    //Create Frame
    JFrame f;

    //Constructor
    editor() {
        //Create a frame as Text Editor
        f = new JFrame("Text Editor");

        try {
            // Set metal look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

            // Set theme to ocean
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        } catch (Exception e) {
        }

        // Text component
        t = new JTextArea();

        // Increase the font size for the text area
        Font textFont = new Font("Consolas", Font.PLAIN, 30); // You can adjust the font size here

        t.setFont(textFont);

        // Create a menu bar
        JMenuBar mb = new JMenuBar();

        // Increase the font size for menu items
        Font menuFont = new Font("Consolas", Font.PLAIN, 25); // You can adjust the font size here

        // Create a menu for File
        JMenu m1 = new JMenu("File");
        m1.setFont(menuFont);

        // Create menu items
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");

        // Add action listener
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi9.addActionListener(this);

        // Set font for menu items
        mi1.setFont(menuFont);
        mi2.setFont(menuFont);
        mi3.setFont(menuFont);
        mi9.setFont(menuFont);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);

        // Create a menu for Edit
        JMenu m2 = new JMenu("Edit");
        m2.setFont(menuFont);

        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");

        // Add action listener
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);

        // Set font for menu items
        mi4.setFont(menuFont);
        mi5.setFont(menuFont);
        mi6.setFont(menuFont);

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);

        JMenuItem mc = new JMenuItem("close");
        mc.addActionListener(this);
        mc.setFont(menuFont);

        mb.add(m1);
        mb.add(m2);
        mb.add(mc);

        // Set font for the menu bar
        mb.setFont(menuFont);

        // Set preferred size for the menu bar
        mb.setPreferredSize(new Dimension(mb.getWidth(), 80)); // Adjust the height as needed

        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(1200, 1200);
        f.setVisible(true); // Changed to setVisible(true)
    }

    // actionPerformed method required by ActionListener interface
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("cut")) {
            t.cut();
        } else if (s.equals("copy")) {
            t.copy();
        } else if (s.equals("paste")) {
            t.paste();
        } else if (s.equals("Save")) {
            // ... (unchanged Save code)
        } else if (s.equals("Print")) {
            // ... (unchanged Print code)
        } else if (s.equals("Open")) {
            // ... (unchanged Open code)
        } else if (s.equals("New")) {
            t.setText("");
        } else if (s.equals("close")) {
            f.setVisible(false);
        }
    }

    // Main class
    public static void main(String args[]) {
        editor e = new editor();
    }
}
