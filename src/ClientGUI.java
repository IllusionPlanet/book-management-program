import com.sun.xml.internal.ws.api.model.ExceptionType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ClientGUI {
    static String bookInfo;
    static ArrayList<Book> books = new ArrayList<Book>();
    public void go(){
        JFrame frame = new JFrame("简易图书管理系统");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.lightGray);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        JButton searchButton = new JButton("查找");
        JButton insertButton = new JButton("插入");
        JButton deleteButton = new JButton("删除");
        panel1.add(searchButton);
        panel1.add(insertButton);
        panel1.add(deleteButton);
        contentPane.add(panel1,BorderLayout.SOUTH);

        JTextField jTextField = new JTextField(50);
        jTextField.setFont(new Font("宋体",Font.BOLD,14));
        panel2.setBackground(Color.gray);
        panel2.add(jTextField);
        contentPane.add(panel2,BorderLayout.NORTH);

        JTextArea jTextArea = new JTextArea(2, 2);
        jTextArea.setForeground(Color.black);
        jTextArea.setFont(new Font("宋体",Font.BOLD,16));
        jTextArea.setBackground(Color.darkGray);
        jTextArea.setEnabled(false);
        contentPane.add(jTextArea,BorderLayout.CENTER);
        jTextArea.append("\n\n欢迎使用简易图书管理系统！\n\n如需查找或删除图书，请在顶部文本框中输入图书名，并点击对应按钮；" +
                "\n\n如需插入新图书，请在顶部文本框中依次输入书名、作者、出版社、刊号、出版日期、页数和摘要，以空格分隔。");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");
                bookInfo = jTextField.getText();
                boolean flag = false;
                for(int i=0; i<=books.size()-1; i++){
                    if(bookInfo.equals(books.get(i).getName())){
                        jTextArea.append("\n\n书名："+books.get(i).getName()+"\n作者："+
                                books.get(i).getAuthor()+"\n出版社："+ books.get(i).getPublisher()+
                                "\n刊号："+books.get(i).getNumber()+"\n出版日期："+ books.get(i).getDate()+
                                "\n页数："+books.get(i).getPageNum()+"\n摘要："+ books.get(i).getSummary());
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    JOptionPane.showMessageDialog(null,"未发现此图书!",
                            "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    bookInfo = jTextField.getText();
                    String[] bookInsertion = bookInfo.split("\\s+");
                    boolean flag = true;
                    for (int i = 0; i <= books.size() - 1; i++) {
                        if (bookInsertion[0].equals(books.get(i).getName())) {
                            JOptionPane.showMessageDialog(null, "已经有此图书!",
                                      "提示", JOptionPane.ERROR_MESSAGE);
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        books.add(new Book(bookInsertion[0], bookInsertion[1], bookInsertion[2],
                                bookInsertion[3], bookInsertion[4], Integer.parseInt(bookInsertion[5]),
                                bookInsertion[6]));
                        JOptionPane.showMessageDialog(null, "插入成功!", "提示",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "插入内容不正确!",
                            "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");
                bookInfo = jTextField.getText();
                boolean flag = false;
                for(int i=0; i<=books.size()-1; i++){
                    if(bookInfo.equals(books.get(i).getName())){
                        books.remove(i);
                        JOptionPane.showMessageDialog(null,"删除成功!", "提示",
                                JOptionPane.INFORMATION_MESSAGE);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    JOptionPane.showMessageDialog(null,"未发现此图书!",
                            "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setSize(1000,618);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        ClientGUI clientGUI = new ClientGUI();
        books.add(0,new Book("桥头","李镜文","圆月出版社","34N41",
                "2023-1-7",323,"亲情文学，讲述一座断桥周围的故事"));
        books.add(0,new Book("黑缨剑","布尔迪","湖畔出版社","29D91",
                "2023-2-2",420,"一个架空历史中有关隐者的故事"));
        books.add(0,new Book("风笛","杨古拉克","中心出版社","21H42",
                "2023-2-18",237,"小说带我们穿梭回中世纪，感受劫难和浪漫"));
        clientGUI.go();
    }
}