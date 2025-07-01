import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInputField;

    public ToDoApp() {
        // Create main frame
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Task input field
        taskInputField = new JTextField(20);
        inputPanel.add(taskInputField);

        // Add button
        JButton addButton = new JButton("Add");
        inputPanel.add(addButton);

        // Delete button
        JButton deleteButton = new JButton("Delete");
        inputPanel.add(deleteButton);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInputField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskInputField.setText(""); // clear input field
                }
            }
        });

        // Delete button action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                }
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}

