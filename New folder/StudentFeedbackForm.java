import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentFeedbackForm extends JFrame implements ActionListener {
    // Input fields
    JTextField nameField, idField, emailField, deptField, subjectField, facultyField;
    JComboBox<Integer> teachingRating, punctualityRating, clarityRating, interactionRating;
    JTextArea commentsArea;
    JButton submitBtn;

    public StudentFeedbackForm() {
        setTitle("Student Feedback Form");
        setSize(500, 700);
        setLayout(new GridLayout(0, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Student Info
        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Student ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Department:"));
        deptField = new JTextField();
        add(deptField);

        // Faculty Info
        add(new JLabel("Subject:"));
        subjectField = new JTextField();
        add(subjectField);

        add(new JLabel("Faculty Name:"));
        facultyField = new JTextField();
        add(facultyField);

        // Ratings
        Integer[] ratings = {1, 2, 3, 4, 5};

        add(new JLabel("Teaching Quality (1-5):"));
        teachingRating = new JComboBox<>(ratings);
        add(teachingRating);

        add(new JLabel("Punctuality (1-5):"));
        punctualityRating = new JComboBox<>(ratings);
        add(punctualityRating);

        add(new JLabel("Clarity in Explanation (1-5):"));
        clarityRating = new JComboBox<>(ratings);
        add(clarityRating);

        add(new JLabel("Student Interaction (1-5):"));
        interactionRating = new JComboBox<>(ratings);
        add(interactionRating);

        // Comments
        add(new JLabel("Additional Comments:"));
        commentsArea = new JTextArea(3, 20);
        add(new JScrollPane(commentsArea));

        // Submit Button
        submitBtn = new JButton("Submit Feedback");
        submitBtn.addActionListener(this);
        add(submitBtn);

        // Padding
        add(new JLabel("")); // Empty cell
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Collect form data
        String name = nameField.getText();
        String studentId = idField.getText();
        String email = emailField.getText();
        String dept = deptField.getText();
        String subject = subjectField.getText();
        String faculty = facultyField.getText();
        int teaching = (int) teachingRating.getSelectedItem();
        int punctuality = (int) punctualityRating.getSelectedItem();
        int clarity = (int) clarityRating.getSelectedItem();
        int interaction = (int) interactionRating.getSelectedItem();
        String comments = commentsArea.getText();

        // Display confirmation dialog
        String summary = "Feedback Submitted!\n\n" +
                "Student: " + name + " (" + studentId + ")\n" +
                "Email: " + email + "\n" +
                "Department: " + dept + "\n" +
                "Subject: " + subject + "\n" +
                "Faculty: " + faculty + "\n\n" +
                "Ratings:\n" +
                "- Teaching: " + teaching + "\n" +
                "- Punctuality: " + punctuality + "\n" +
                "- Clarity: " + clarity + "\n" +
                "- Interaction: " + interaction + "\n\n" +
                "Comments:\n" + comments;

        JOptionPane.showMessageDialog(this, summary, "Feedback Received", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new StudentFeedbackForm();
    }
}
