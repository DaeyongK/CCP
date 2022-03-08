import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class DomainScreen extends QPanel {
    protected ArrayList<EstablisherButton> domainButtons;
    protected TransitionButton exit;
    protected ArrayList<Domain> domains;
    protected JLayeredPane pane;
    DomainScreen(String input, Quizit quizit) {
		/*
		button ids:
		exit = -1
		domain buttons = index in allDomains
		 */
        super(input, quizit);
//		System.out.print(popup("yeah"));
        setOpaque(true);
        setLayout(null);

        domains = quizit.getProfile().getDomains();
        domainButtons = new ArrayList<>();
        for (int i = 0; i < domains.size(); i++) {
            domainButtons.add(new EstablisherButton(this, 800, 50, Color.white, domains.get(i).getDomainName(), i));
        }
       
        pane = new JLayeredPane();
        JScrollPane scroll = new JScrollPane(pane);
//        scroll.setSize(500, 500);
        add(scroll);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        if (domainButtons != null) {
            for (int i =0; i<domainButtons.size(); i++) {
//        		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        		pane.setLayout(new GridLayout(domainButtons.size(), 1));
            	EstablisherButton button = domainButtons.get(i);

        		button.setPreferredSize(new Dimension(800, 50));
            	pane.add(button, 1);
            	//pane.setLayout(null);
//        		button.setBounds(20,80*i+20,360,50);
//            	pane.add(button);
            }
        }
        scroll.setBounds(150,150,900,400);
        exit = new TransitionButton(this, 100, 50, TITLE_COLOR, "Exit", 1, -1);
        exit.setBounds(50,50,50,50);
        titleLabel.setBounds(600,50,100,100);
        add(exit);

    }


    public String getName() {
        return title;
    }

    public abstract void buttonClicked(int buttonID);

    private void radioClick() {

    }

    public void paintComponent(Graphics g) {
    }

    public static void main(String[] args) {
        Testit t = new Testit();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DetachDomain test = new DetachDomain("Detach Domain", t);
        frame.setContentPane(test);
        frame.pack();
        frame.setSize(1280, 720);
        frame.setVisible(true);

    }
}

class Testit extends Quizit {
    Testit() {
        ArrayList<Question> thing = new ArrayList<>();
        setProfile(new Profile(null, this));
        addProfile(getProfile());
        getProfile().addDomain(new Domain("yes", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));
        getProfile().addDomain(new Domain("no", thing));


    }
}

class DomainScreenTester extends DomainScreen {

    DomainScreenTester(String input, Quizit quizit) {
        super(input, quizit);
    }


    @Override
    public void buttonClicked(int buttonID) {
        // TODO Auto-generated method stub
        System.out.println(buttonID);
    }

    @Override
    public int getScreenID() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean popup(String text) {
        // TODO Auto-generated method stub
        return false;
    }

}
