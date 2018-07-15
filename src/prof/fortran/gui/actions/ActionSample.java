package prof.fortran.gui.actions;

// Набор базовых пакетов Java
import java.awt.*;
import java.awt.event.ActionEvent;

// Пакеты расширений Java
import javax.swing.*;

/**
 * ActionSample.java
 * Демонстрация применения паттерна проектирования Command для действий Swing
 */
public class ActionSample extends JFrame {

    // Действия Swing
    private Action sampleAction;
    private Action exitAction;

    /**
     * Конструктор ActionSample
     */
    private ActionSample() {
        super("Using Actions");

        // создайте подкласса AbstractAction для sampleAction
        sampleAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // отображение сообщения, указывающего на вызов sampleAction
                JOptionPane.showMessageDialog(ActionSample.this, "The sampleAction was invoked");
                // разрешение действия exitAction и активация соответствующих компонентов пользовательского интерфейса
                exitAction.setEnabled(true);
            }
        };

        // задание имени действия
        // этот текст будет у действия sampleAction в JMenuBar, а также как надпись на JButton
        sampleAction.putValue(Action.NAME, "Sample Action");

        // установка значка для действия (картинка question_mark.png должна лежать в CLASSPATH)
        sampleAction.putValue(Action.SMALL_ICON, new ImageIcon(
                getClass().getResource("/images/question_mark.png")));

        // задание текста экранной подсказки
        // всплывающая подсказка при наведении курсора мыши на действие sampleAction в JMenuBar, JToolBar и на JButton
        sampleAction.putValue(Action.SHORT_DESCRIPTION, "A Sample Action");

        // задание "горячей" клавиши для действия (должна быть заглавной буквой)
        // чтобы сработало надо нажать Alt+s
        sampleAction.putValue(Action.MNEMONIC_KEY, (int) 'S');

        // создание подкласса AbstractAction для действия exitAction
        exitAction = new AbstractAction() {
            /**
             * Отображение сообщения, указывающего на вызов exitAction
             */
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(ActionSample.this, "The exitAction was invoked");
                System.exit(0);
            }
        };

        // установка имени действия
        // этот текст будет у действия exitAction в JMenuBar, а также как надпись на JButton
        exitAction.putValue(Action.NAME, "Exit");

        // задание значка для действия (картинка exit.png должна лежать в CLASSPATH)
        exitAction.putValue(Action.SMALL_ICON, new ImageIcon(
                getClass().getResource("/images/exit.png")));

        // задание текста экранной подсказки
        // всплывающая подсказка при наведении курсора мыши на действие exitAction в JMenuBar, JToolBar и на JButton
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit Application");

        // задание "горячей" клавиши для действия (должна быть заглавной буквой)
        // чтобы сработало надо нажать Alt+x
        exitAction.putValue(Action.MNEMONIC_KEY, (int) 'X');

        // запрет действия exitAction и дезактивация соответствующих компонентов GUI
        exitAction.setEnabled(false);

        // создание меню File
        JMenu fileMenu = new JMenu("File");

        // добавление sampleAction и exitAction в меню File для
        // создания элементов меню JMenuItem для каждого действия
        fileMenu.add(sampleAction);
        fileMenu.add(exitAction);

        // задание "горячей" клавиши для меню File (должна быть заглавной буквой)
        // чтобы сработало надо нажать Alt+f
        fileMenu.setMnemonic('F');

        // создание объекта JMenuBar и добавление в него меню File
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);

        // регистрация JMenuBar в JFrame (в нашем классе ActionSample)
        setJMenuBar(menuBar);

        // создание панели JToolBar
        JToolBar toolBar = new JToolBar();

        // добавление sampleAction и exitAction в панель JToolBar
        // для создания кнопок JButton для каждого из действий
        toolBar.add(sampleAction);
        toolBar.add(exitAction);

        // создание объекта JButton и задание в качестве действия sampleAction
        JButton sampleButton = new JButton();
        sampleButton.setAction(sampleAction);

        // создание объекта JButton и задание в качестве действия exitAction
        JButton exitButton = new JButton(exitAction);

        // размещение кнопок JButton на панели JPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sampleButton);
        buttonPanel.add(exitButton);

        // добавление панелей toolBar и buttonPanel в панель JFrame (в наш класс ActionSample)
        Container container = getContentPane();
        container.add(toolBar, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * Выполнение приложения
     */
    public static void main(String args[]) {
        ActionSample sample = new ActionSample();
        sample.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sample.pack(); // подогнать размеры окна под размеры компонентов в нем
        sample.setVisible(true);
    }

}