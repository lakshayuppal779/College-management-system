import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class project1 {
    public static void main(String[] args) {
        try{
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project","root","aashi");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student_details");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getString(7)+"  "+rs.getInt(8));
            con.close();
        }
        catch(Exception es)
        {
            System.out.println(es);
        }
        try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(project1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(project1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(project1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(project1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        JWindow w=new JWindow();
//        w.setSize(500,300);
//        w.setLocationRelativeTo(null);
        w.setVisible(true);

        int x=1;
        for (int i = 2; i<=450; i+=4, x+=1) {
            w.setLocation(820 - ((i + x) / 2), 400 - (i / 2));
            w.setSize(i, i);

            try {
                Thread.sleep(8);
            } catch (Exception e) {
            }
        }

        JPanel jp=new JPanel();
        w.add(jp);
        jp.setBackground(Color.white);
        jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String imagepath="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\pietproject.png";
        JLabel lp=new JLabel(new ImageIcon(imagepath));
        lp.setHorizontalAlignment(SwingConstants.CENTER);
        jp.add(lp);


        JProgressBar pb=new JProgressBar(0,100);
        w.add(pb,BorderLayout.PAGE_END);
        pb.setBackground(Color.white);
        pb.setForeground(Color.red);
        pb.setStringPainted(true);
        w.revalidate();

        int i=0;
        while(i<=100)
        {
            if (i==100)
            {
                pb.setString("completed");
                w.dispose();
            }
            pb.setValue(i);
            try {
                Thread.sleep(30);
            }
            catch(Exception e){
                System.out.println("caught an exception");
            }
            i=i+1;
        }
        //jframe

        JFrame frame = new JFrame();
        frame.setTitle("System Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,320);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setBackground(Color.orange);
        c.setLayout(null);

        //jlabel
        String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\user.png";
        JLabel label=new JLabel(new ImageIcon(imagepath1));
        label.setText("Username");
        label.setBounds(5, 50, 200, 50);
        c.add(label);

        String imagepath2="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\pass.png";
        JLabel label3=new JLabel(new ImageIcon(imagepath2));
        label3.setText("Password");
        label3.setBounds(5, 110, 200, 50);
        c.add(label3);

        Font font = new Font("Arial", Font.PLAIN, 20);
        label.setFont(font);
        label3.setFont(font);

        //jtextfield
        JTextField t1 = new JTextField();
        t1.setBounds(210, 60, 250, 33);
        c.add(t1);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        t1.setFont(font2);
        t1.setForeground(Color.BLACK);
        t1.setBackground(Color.white);

        //jpasswordfield
        JPasswordField pass = new JPasswordField();
        pass.setBounds(210, 120, 250, 33);
        c.add(pass);
        pass.setFont(font2);
        pass.setEchoChar('*');

        //jbutton
        JButton btn=new JButton("Clear");
        btn.setBounds(310,180,70,30);
        Font font1 = new Font("Arial", Font.BOLD, 15);
        btn.setFont(font1);
        c.add(btn);
        JButton btn1=new JButton("login");
        btn1.setBounds(390,180,70,30);
        btn1.setFont(font1);
        c.add(btn1);
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.white);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        btn.setCursor(cur);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText(null);
                pass.setText(null);
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str="piet";
                String str1="1234";
                String u=t1.getText();
                String p=pass.getText();

                if (t1.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(c,"user name field is empty!", "Warning", JOptionPane.WARNING_MESSAGE);

                }
                else if (pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(c,"password field is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else if (u.equals(str) && p.equals(str1)) {
                    frame.dispose();
                    JFrame frame1 = new JFrame("College Management System");
                    frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame1.setSize(1000,725);
                    frame1.setLocationRelativeTo(frame);
                    Container c1 = frame1.getContentPane();
                    c1.setLayout(null);

                    //jmenubar

                    JMenuBar mb=new JMenuBar();
                    mb.setBackground(Color.GREEN);

                    JMenu a1=new JMenu("About Us");
                    JMenu a2=new JMenu("Vision & Mission");
                    JMenu a3=new JMenu("Departments");
                    JMenu a4=new JMenu("Life@PIET");
                    JMenu a5=new JMenu("Fee Structure");
                    JMenu a6=new JMenu("Admissions");
                    JMenu a7=new JMenu("Contact Us");
                    JMenu a8=new JMenu("Library");
                    JMenu a9=new JMenu("Scholarship Schemes");
                    JMenu a10=new JMenu("Exams");
                    JMenu a11=new JMenu("Events");
                    JMenu a12=new JMenu("Alumni");


                    a1.setForeground(Color.blue);
                    a2.setForeground(Color.red);
                    a3.setForeground(Color.blue);
                    a4.setForeground(Color.red);
                    a5.setForeground(Color.blue);
                    a6.setForeground(Color.red);
                    a7.setForeground(Color.blue);
                    a8.setForeground(Color.red);
                    a10.setForeground(Color.blue);
                    a11.setForeground(Color.red);
                    a12.setForeground(Color.blue);

                    Font font4 = new Font("Arial", Font.PLAIN, 15);
                    a1.setFont(font4);
                    a2.setFont(font4);
                    a3.setFont(font4);
                    a4.setFont(font4);
                    a5.setFont(font4);
                    a6.setFont(font4);
                    a7.setFont(font4);
                    a8.setFont(font4);
                    a10.setFont(font4);
                    a11.setFont(font4);
                    a12.setFont(font4);

                    JMenuItem i1=new JMenuItem("IT");
                    JMenuItem i2=new JMenuItem("B.TECH");
                    JMenuItem i3=new JMenuItem("MBA");
                    JMenuItem i4=new JMenuItem("BCA");
                    JMenuItem i5=new JMenuItem("BBA");
                    JMenuItem i6=new JMenuItem("B.COM");
                    JMenuItem i7=new JMenuItem("B.FAD");
                    JMenuItem i8=new JMenuItem("B.PHARMA");
                    JMenuItem i9=new JMenuItem("CSc");
                    JMenuItem i10=new JMenuItem("MECHANICAL");
                    JMenuItem i11=new JMenuItem("CIVIL");
                    JMenuItem i12=new JMenuItem("WHY PIET");
                    JMenuItem i13=new JMenuItem("Courses Offered");
                    JMenuItem i14=new JMenuItem("Payment procedure");
                    JMenuItem i15=new JMenuItem("PIET SCHOLARSHIP SCHEME");
                    JMenuItem i16=new JMenuItem("PMSSS SCHOLARSHIP SCHEME");
                    JMenuItem i17=new JMenuItem("AICTE PRAGATI & SAKSHAM SCHEME");
                    JMenuItem i18=new JMenuItem("SC/ST/OBC SCHOLARSHIP SCHEME");
                    JMenuItem i19=new JMenuItem("SC/ST/OBC SCHOLARSHIP SCHEME");
                    JMenuItem i20=new JMenuItem("Orientation Program");
                    JMenuItem i21=new JMenuItem("Induction Program");
                    JMenuItem i22=new JMenuItem("PIET Carbuncle");
                    JMenuItem i23=new JMenuItem("PIET Maestros");
                    JMenuItem i24=new JMenuItem("PIET Convocation");


                    a3.add(i1);
                    a3.addSeparator();
                    a3.add(i2);
                    a3.addSeparator();
                    a3.add(i3);
                    a3.addSeparator();
                    a3.add(i4);
                    a3.addSeparator();
                    a3.add(i5);
                    a3.addSeparator();
                    a3.add(i6);
                    a3.addSeparator();
                    a3.add(i7);
                    a3.addSeparator();
                    a3.add(i8);
                    a3.addSeparator();
                    a3.add(i9);
                    a3.addSeparator();
                    a6.add(i12);
                    a6.addSeparator();
                    a6.add(i13);
                    a6.addSeparator();
                    a6.add(i14);
                    a6.addSeparator();
                    a6.add(a9);
                    a9.add(i15);
                    a9.addSeparator();
                    a9.add(i16);
                    a9.addSeparator();
                    a9.add(i17);
                    a9.addSeparator();
                    a9.add(i18);
                    a4.add(i20);
                    a4.addSeparator();
                    a4.add(i21);
                    a4.addSeparator();
                    a4.add(i22);
                    a4.addSeparator();
                    a4.add(i23);
                    a4.addSeparator();
                    a4.add(i24);

                    mb.add(a1);
                    mb.add(a2);
                    mb.add(a3);
                    mb.add(a4);
                    mb.add(a5);
                    mb.add(a6);
                    mb.add(a7);
                    mb.add(a8);
                    mb.add(a10);
                    mb.add(a11);
                    mb.add(a12);

                    frame1.setJMenuBar(mb);

                    a1.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JFrame frame6=new JFrame();
                            frame6.setTitle("About Us");
                            frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame6.setSize(500,500);
                            frame6.setLocationRelativeTo(frame1);

                            JEditorPane pane=new JEditorPane();
                            pane.setFont(font4);
                            pane.setBackground(Color.pink);
                            pane.setContentType("text/plain");
                            pane.setText("PIET is amongst the top engineering colleges in Haryana and leading the way with course-curriculum in Engineering, Management & Technology designed for Enterprise 4.0. The workplace of the future will be all about different skill sets as well as automated collaborators. PIET’s Education 4.0, with its emphasis on Analytics, AI, Robotics and other new age  learning frameworks ensures you are ready to face the world of tomorrow, successfully.\n" +
                                    "\n" +
                                    "PIET is a multi-disciplinary institute affiliated to Kurukshetra University, Kurukshetra and approved by AICTE. For over a decade PIET has maintained its #1 position amongst the best engineering colleges in Haryana and is also coveted as a leading MBA college in Haryana. Committed to developing new age leaders with a holistic approach and futuristic orientation, its graduates are regularly placed in top MNCs, blue-chip companies & start-ups. We inspire excellence using innovative teaching methods as well as the human skill-sets necessary to succeed in the disruptive & transformative world of the future.");
                            frame6.add(pane,BorderLayout.CENTER);
                            frame6.setVisible(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    });
                    a2.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JFrame frame7=new JFrame();
                            frame7.setTitle("Vision & Mission");
                            frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame7.setSize(500,500);
                            frame7.setLocationRelativeTo(frame1);

                            JEditorPane pane1=new JEditorPane();
                            pane1.setFont(font4);
                            pane1.setBackground(Color.pink);
                            pane1.setContentType("text/plain");
                            pane1.setText("VISION"+"\n"+"\n"+"To be globally known and recognized as an educational institute of engineering, technology, management and research having a transformative impact on society."
                                    +"\n"+"\n"+"MISSION"+"\n"+"\n"+"M1"+"\n"+"\n"+"To impart knowledge, skills and creativity to all the students."+"\n"+"\n"+"M2"+"\n"+"\n"+"To provide a conducive environment for quality teaching, learning, and research."+"\n"+"\n"+"M3"+"\n"+"\n"+"To create awareness on sustainable technologies and innovative solutions to societal problems including entrepreneurship."+"\n"+"\n"+"M4"+"\n"+"\n"+"To strengthen institutional and industrial collaborations nationally and internationally.");
                            frame7.add(pane1,BorderLayout.CENTER);
                            frame7.setVisible(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    });

                    a7.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JFrame frame5=new JFrame("Contact Us");
                            frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame5.setSize(500,500);
                            frame5.setLocationRelativeTo(frame1);

                            JPanel j5=new JPanel();
                            j5.setSize(500,500);
                            j5.setBackground(Color.white);
                            j5.setLayout(null);
                            frame5.add(j5);

                            Font font5 = new Font("Arial", Font.PLAIN, 20);

                            JLabel z1=new JLabel("Write to us:");
                            z1.setBounds(10,10,300,30);
                            z1.setFont(font2);
                            j5.add(z1);

                            JLabel z2=new JLabel("Your Name:");
                            z2.setBounds(10,50,300,30);
                            z2.setFont(font5);
                            j5.add(z2);
                            JTextField y1 = new JTextField();
                            y1.setBounds(10,80,470,30);
                            y1.setFont(font2);
                            j5.add(y1);

                            JLabel z3=new JLabel("Your Email:");
                            z3.setBounds(10,110,200,30);
                            z3.setFont(font5);
                            j5.add(z3);
                            JTextField y2 = new JTextField();
                            y2.setBounds(10,140,470,30);
                            y2.setFont(font2);
                            j5.add(y2);

                            JLabel z4=new JLabel("Contact No:");
                            z4.setBounds(10,170,200,30);
                            z4.setFont(font5);
                            j5.add(z4);
                            JTextField y3 = new JTextField();
                            y3.setBounds(10,200,470,30);
                            y3.setFont(font2);
                            j5.add(y3);

                            JLabel z5=new JLabel("Send Message:");
                            z5.setBounds(10,240,200,30);
                            z5.setFont(font5);
                            j5.add(z5);
                            JTextArea y4 = new JTextArea();
                            y4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            y4.setBounds(10,270,470,110);
                            y4.setFont(font2);
                            j5.add(y4);

                            JButton z6=new JButton("SUBMIT");
                            z6.setBounds(200,410,100,30);
                            j5.add(z6);
                            frame5.setVisible(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    });
                    i12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame7=new JFrame();
                            frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame7.setSize(900,600);
                            frame7.setLocationRelativeTo(frame1);

                            JEditorPane pane1=new JEditorPane();
                            pane1.setFont(font4);
                            pane1.setBackground(Color.pink);
                            pane1.setContentType("text/plain");
                            pane1.setText("LEAD WORKSHOP (LEARN, ENGAGE, ASSIMILATE AND DEVELOP WORKSHOP)\n" +
                                    "In these days and time where the World is gradually is moving towards a “ BOUNDARY LESS WORLD” Today Mankind is at a juncture where New Age Technological Advancements are driving the Human Race into uncharted territories, the Academia and the Intelligentsia at PIET have decided to spread awareness about the path breaking and the Transformative Concept of  “ENTERPRISE 4.0”. The Team at PIET in conjunction with the Nation’s leading Technocrats, Educators and Industry Experts have decided to conduct a series of Knowledge Dissemination Sessions titled the “LEAD” (Learn, Engage, Assimilate and Develop) Workshops.\n" +
                                    "\n" +
                                    "These Sessions are being organized not only for the Student Community but also the Academia and the Society at large. The objective of reaching out to the mentioned community is that the message about the Transformative change is propagated by the “PROPELLOR HEADS” of the Nation to one and all. At PIET we believe, this process of spreading knowledge and creating awareness about the Tectonic shift in the world of Technology and Management the role of one and all involved in the Academic, Technical, Corporate and Intellectual Space is of paramount importance. These sessions encompass the following aspects\n" +
                                    "\n" +
                                    "Artificial Intelligence\n" +
                                    "Internet of Things\n" +
                                    "Block Chain\n" +
                                    "Virtual Reality/Mixed Reality/Augmented Reality\n" +
                                    "Robotics\n" +
                                    "The First “LEAD” Workshop was held at the PIET Campus on the 28th and 29th June 2019 and was widely attended by the Student as well as Academic Fraternity from across the Indian Sub-Continent To know more about the next “LEAD” WORKSHOP and the Itinerary of the Workshop in your City keep following this space.\n" +
                                    "\n" +
                                    "BLENDED LEARNING\n" +
                                    "Is an interesting approach that combines online educational material and opportunities for interaction online with traditional place-based classroom methods. While it is imperative that students still attend classes in a  “brick-and-mortar” set up with a teacher donning the role of a facilitator present. The face-to-face classroom practices are combined with computer-mediated activities with regards both Content as well as Delivery.\n" +
                                    "\n" +
                                    "As the name suggests it is model of Learning where a Traditional Process is amalgamated with New Age Learning Models and the advantage of this Model of Learning is that provides the students to learn in a Practical as well as Theoretical Manner. There are various Models of Blended Learning that the student at PIET are exposed to; to name a few :\n" +
                                    "\n" +
                                    "The “Face to Face” driver – where the teacher drives the instruction and augments with digital tool.\n" +
                                    "The “Rotation” based model where the students are made to go through a schedule of Independent Online Study as well as an Interactive Classroom cycle.\n" +
                                    "The “Flex”based model is used to promote Higher Order Thinking; in this model some part of the curriculum is delivered via the Digital model and the Teachers provide Face-to-Face Consultation and Support.\n" +
                                    "The “Lab”based model is a vital part of the Learning Model as this where the Students usually learn as a mix of Theory and Practical based sessions.\n" +
                                    "Finally the “Self Blend” model this is a Learning process where the students have the opportunity to augment their Learning through Online Course Work. To mention some of the Tools that are being incorporated at PIET so that the entire process of “ BLENDED LEARNING” fulfills the desired objective of creating Students who are “Thought Leaders” and drive “ Change” as a function of their differentiated Learning and Thinking process. To enlist:\n" +
                                    "\n" +
                                    "Instructor – Delivered Content\n" +
                                    "E-Learning\n" +
                                    "Webinars\n" +
                                    "Live/Online Sessions with Facilitators\n" +
                                    "Use of Face book/Chat Rooms/Blogs/You Tube to augment Learning\n" +
                                    "FLIPPED LEARNING\n" +
                                    "This is one of the most interesting and exciting ways of Learning. The Students at PIET have made the most of this innovative model of Learning. As the name suggests it is an Inversion of the Traditional process of “Class Room Based” Learning.\n" +
                                    "\n" +
                                    "To explain the Concept of Flipped Learning in brief\n" +
                                    "\n" +
                                    "A Flipped classroom is an instructional strategy that reverses the traditional learning environment by delivering the instructional content, outside of the classroom.\n" +
                                    "\n" +
                                    "The process shifts activities including those that may have traditionally been considered homework, into the classroom. In a flipped classroom, students are made to collaborate and partner in Learning by means of watching Online Content, Video’s and Discussing Cases as well as Problem Statements.\n" +
                                    "\n" +
                                    "The Topical research is carried out a place outside the Class Room Environment while the mentor/facilitator guides the students about the Content in the Class Room.\n" +
                                    "\n" +
                                    "This mode of Learning by purpose shifts instruction to a learner-centered model in which time in the classroom is used to explore topics in greater depth, while the students are provided with the Textual content beforehand so that they can come to the Classroom in a prepared mode for Conceptual Discussions.\n" +
                                    "\n" +
                                    "As is the case with a flipped classroom, ‘content delivery’ may take a variety of forms so at PIET, often video lessons prepared by the teacher / guest faculty / experts are used to deliver content along with online collaborative discussions, digital research, and text readings may be used.\n" +
                                    "\n" +
                                    "Given the saying “Experiencing is Believing” we at PIET invite Students as well as Educators to come and see for themselves the New Age Learning Models and Tools being used to impart World Class Pedagogic Delivery to the Students as well as the community of Researchers.\n" +
                                    "\n" +
                                    "Learning Management System through M-TUTOR\n" +
                                    "Interactive e-educational resources prepare the students for the forthcoming lectures and make them understand the classroom lectures in a better way. There is a dire need to introduce a platform that brings a transformation in learning beyond classrooms by thought based audio-visual stimulation.  PIET understands the growing needs of the students of this digital era to survive in this competitive world. Hence, PIET has partnered with MTUTOR, which is India’s first digital tutorials package for higher education developed as per University curriculum.\n" +
                                    "\n" +
                                    "The tool is loaded with the rich graphic-aided content to make learning fun and easy, and is a value addition to the conventional classroom teaching. This increases the retention power of students and makes students skillful and employable. Features like assessments and tests, live chat, ask-a-doubt and question bank, make it even more powerful and impactful for upgrading students’ performance.\n" +
                                    "\n" +
                                    "Lecture Capture System (LCS) through Impartus\n" +
                                    "PIET is the first engineering institution in Haryana which joined hands with Impartus and introduced the lecture capture system at large scale in the teaching learning process. The lecture capture system by Impartus at PIET is a cutting edge end-to-end solution to automatically record the complete classroom experience. The platform also enables students and professor for collaborative learning by sharing content. This facility is used by all the teachers.\n" +
                                    "\n" +
                                    "Cultural Diversity\n" +
                                    "Indian diversity has a great pull to galvanize people from all the corners of the world and make them feel at home. PIET is a bouquet that includes unique and great flowers of various cultures on its vibrant Campus. In the budding stage, PIET was only serving the academic and professional requirements of the country. But garnering confidence with the passage of time, PIET has made its importance felt in the international arena by extending great hands-on academic insight. PIET nurtures the dreams and aspirations of the global students with great concern today. PIET attracts students from Nepal, Bhutan, Vietnam, Cambodia, Bangladesh, which brings a nice mix of students on Campus, and enables them at PIET to experience various cultures and practices. Drawn from various countries, students have found PIET a home away from home. The amiable and amicable PIET always assists the international students on the Campus in completing the formalities with Foreign Registration Office (FRO), affiliating University etc. The presence of International students in PIET is a kaleidoscope of cultures.\n" +
                                    "\n" +
                                    "Placements @ PIET\n" +
                                    "PIET has a full-fledged integrated placement cell, which invite the leading brands of the corporate world to campus every year. Our campus placement process is designed to meet the needs of recruiters alongside providing students with the best opportunities to jumpstart their career.\n" +
                                    "\n" +
                                    "Despite the uncertain global macroeconomic scenario, PIET continue to remain one of the most preferred destinations for campus hiring by top brand recruiters across diverse sectors. Though the job market this year is not as buoyant as the last year, yet PIET have been able to attract major corporate houses.\n" +
                                    "\n" +
                                    "A quick responding placement team, best infrastructure facilities, with spacious auditoriums for placement presentations, multiple conference rooms for group discussions & excellent test & computer lab facilities is the backbone. In addition to the large talent pool of students to choose from our college we also ensures speedy & successful talent- hunt experience to the recruiting company from complete north India.\n" +
                                    "\n" +
                                    "Placement cell looks after employment avenues in the emerging Industry at national & international levels. Students from other Vocational Institutes and Arts Colleges also try their luck and get selected through joint campus drive. Reputed companies like Amazon, TCS, Wipro, Capgemini, Cognizant, Syntel, Accenture, IBM, HCL, Sasken, CSC,  etc., have conducted campus interviews and recruited students through the Consortium.");
                            frame7.add(pane1,BorderLayout.CENTER);
                            JScrollPane sp=new JScrollPane(pane1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            frame7.add(sp);
                            frame7.setVisible(true);
                        }
                    });
                    i13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame7=new JFrame();
                            frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame7.setSize(900,600);
                            frame7.setLocationRelativeTo(frame1);

                            JEditorPane pane1=new JEditorPane();
                            pane1.setFont(font4);
                            pane1.setBackground(Color.pink);
                            pane1.setContentType("text/plain");
                            pane1.setText("Bachelor of Technology – 4 Years\n\n" +
                                    "Name of the Course\t\n" +
                                    "Computer Science & Engineering\t\n" +
                                    "Computer Science & Engineering in Cyber Security\t\n" +
                                    "Computer Science & Engineering in Artificial Intelligence and Data Science\t\n" +
                                    "Computer Science & Engineering in Artificial Intelligence and Machine Learning\t\n" +
                                    "Electronics & Communication Engineering\t\n" +
                                    "Mechanical Engineering\t\n" +
                                    "Textile Engineering\t\n" +
                                    "Information Technology\t\n" +
                                    "Civil Engineering\t\n\n\n" +
                                    "Bachelor of Technology (LEET) 2nd Year – 3 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "Computer Science & Engineering\t\t\n" +
                                    "Electronics & Communication Engineering\t\t\n" +
                                    "Mechanical Engineering\t\t\n" +
                                    "Textile Engineering\t\t\n" +
                                    "Information Technology\t\t\n" +
                                    "Civil Engineering\t\t\n\n\n" +
                                    "Bachelor in Pharmacy – 4 Years\n\n" +
                                    "Name of the Course\t\t\n\n" +
                                    "Pharmacy\t\t\n\n" +
                                    "Diploma in Mechanical Engineering- 3 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "Mechanical Engineering\t\t\n\n\n" +
                                    "Diploma in Mechanical Engineering (LEET)- 2 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "Mechanical Engineering\t\t\n\n\n" +
                                    "Diploma in Pharmacy- 2 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "Pharmacy\t\t\n\n\n" +
                                    "Bachelor of Business Administration - 3 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "BBA\t\t\n\n\n" +
                                    "Bachelor of Computer Applications - 3 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "BCA\t\t\n" +
                                    "\n" +
                                    "\n" +
                                    "Master of Business Administration - 2 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "MBA\t\t\n\n\n" +
                                    "Master of Computer Applications - 2 Years\n\n" +
                                    "Name of the Course\t\t\n" +
                                    "Master of Computer Applications\t\t\n" +
                                    "\n");
                            frame7.add(pane1,BorderLayout.CENTER);
                            JScrollPane sp=new JScrollPane(pane1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            frame7.add(sp);
                            frame7.setVisible(true);
                        }
                    });
                    i14.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame7=new JFrame();
                            frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame7.setSize(900,600);
                            frame7.setLocationRelativeTo(frame1);

                            JEditorPane pane1=new JEditorPane();
                            pane1.setFont(font4);
                            pane1.setContentType("text/plain");
                            pane1.setText("Payment Procedure\n" +
                                    "\n" +
                                    "Payment can be made as-\n" +
                                    "1. Demand Draft (DD) in favour of “Panipat Institute of Engineering and Technology” payable at Panipat/Samalkha.\n" +
                                    "\n" +
                                    "2. Cash can be deposited on below mentioned details:\n" +
                                    "\n" +
                                    "Account Holder Name: Panipat Institute of Engineering and Technology\n" +
                                    "\n" +
                                    "Bank Name: HDFC Bank Ltd\n" +
                                    "\n" +
                                    "Account Number: 50100088300896\n" +
                                    "\n" +
                                    "IFSC Code: HDFC0001325\n" +
                                    "\n" +
                                    "3. Online payment facility is available for the students admitted in PIET through HDFC fee portal. The link is available on website home page.");
                            frame7.add(pane1,BorderLayout.CENTER);
                            JScrollPane sp=new JScrollPane(pane1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            frame7.add(sp);
                            frame7.setVisible(true);
                        }
                    });
                    a5.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JFrame frame8=new JFrame("Fee structure");
                            frame8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame8.setSize(1200,900);
                            frame8.setLocationRelativeTo(null);

                            JPanel jl5=new JPanel();
                            jl5.setSize(1200,900);
                            jl5.setBackground(Color.white);
                            frame8.add(jl5);

                            String imagepath3="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\fee structure.png";
                            JLabel lpx=new JLabel(new ImageIcon(imagepath3));
                            lpx.setHorizontalAlignment(SwingConstants.CENTER);
                            jl5.add(lpx);

                            frame8.setVisible(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    });

                    a8.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            JFrame frame = new JFrame();
                            frame.setTitle("Library Login");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setSize(550,320);
                            frame.setLocationRelativeTo(null);
                            Container c = frame.getContentPane();
                            c.setBackground(Color.orange);
                            c.setLayout(null);

                            //jlabel
                            String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\user.png";
                            JLabel label=new JLabel(new ImageIcon(imagepath1));
                            label.setText("Username");
                            label.setBounds(5, 50, 200, 50);
                            c.add(label);

                            String imagepath2="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\pass.png";
                            JLabel label3=new JLabel(new ImageIcon(imagepath2));
                            label3.setText("Password");
                            label3.setBounds(5, 110, 200, 50);
                            c.add(label3);

                            Font font = new Font("Arial", Font.PLAIN, 20);
                            label.setFont(font);
                            label3.setFont(font);

                            //jtextfield
                            JTextField t1 = new JTextField();
                            t1.setBounds(210, 60, 250, 33);
                            c.add(t1);
                            Font font2 = new Font("Arial", Font.BOLD, 20);
                            t1.setFont(font2);
                            t1.setForeground(Color.BLACK);
                            t1.setBackground(Color.white);

                            //jpasswordfield
                            JPasswordField pass = new JPasswordField();
                            pass.setBounds(210, 120, 250, 33);
                            c.add(pass);
                            pass.setFont(font2);
                            pass.setEchoChar('*');

                            //jbutton
                            JButton btn=new JButton("Clear");
                            btn.setBounds(310,180,70,30);
                            Font font1 = new Font("Arial", Font.BOLD, 15);
                            btn.setFont(font1);
                            c.add(btn);
                            JButton btn1=new JButton("login");
                            btn1.setBounds(390,180,70,30);
                            btn1.setFont(font1);
                            c.add(btn1);
                            btn.setForeground(Color.BLACK);
                            btn.setBackground(Color.white);
                            Cursor cur=new Cursor(Cursor.HAND_CURSOR);
                            btn.setCursor(cur);

                            btn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    t1.setText(null);
                                    pass.setText(null);
                                }
                            });

                            btn1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String str = "admin";
                                    String str1 = "1234";
                                    String u = t1.getText();
                                    String p = pass.getText();

                                    if (t1.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(c, "user name field is empty!", "Warning", JOptionPane.WARNING_MESSAGE);

                                    } else if (pass.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(c, "password field is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                                    } else if (u.equals(str) && p.equals(str1)) {
                                        frame.dispose();
                                        JFrame frame1 = new JFrame("library Management System");
                                        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        frame1.setSize(1366, 760);
                                        frame1.setLocationRelativeTo(frame);
                                        Container c1 = frame1.getContentPane();
                                        c1.setLayout(null);

                                        JPanel jp1=new JPanel();
                                        jp1.setSize(1366,760);
                                        c1.add(jp1);
                                        String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\library123.jpg";
                                        JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                                        lp1.setHorizontalAlignment(SwingConstants.CENTER);
                                        jp1.add(lp1);


                                        String imagepath2="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\new student.png";
                                        JButton b1=new JButton(new ImageIcon(imagepath2));
                                        b1.setHorizontalAlignment(SwingConstants.LEFT);
                                        b1.setText("New student");
                                        b1.setBounds(70,50,180,50);
                                        b1.setFont(font1);
                                        lp1.add(b1);

                                        String imagepath3="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\new book.png";
                                        JButton b2=new JButton(new ImageIcon(imagepath3));
                                        b2.setHorizontalAlignment(SwingConstants.LEFT);
                                        b2.setText("New Book");
                                        b2.setBounds(350,50,180,50);
                                        b2.setFont(font1);
                                        lp1.add(b2);

                                        String imagepath4="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\issue.png";
                                        JButton b3=new JButton(new ImageIcon(imagepath4));
                                        b3.setHorizontalAlignment(SwingConstants.LEFT);
                                        b3.setText("Issue Book");
                                        b3.setBounds(600,50,180,50);
                                        b3.setFont(font1);
                                        lp1.add(b3);

                                        String imagepath5="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\return.png";
                                        JButton b4=new JButton(new ImageIcon(imagepath5));
                                        b4.setHorizontalAlignment(SwingConstants.LEFT);
                                        b4.setText("Return Book");
                                        b4.setBounds(850,50,180,50);
                                        b4.setFont(font1);
                                        lp1.add(b4);

                                        String imagepath6="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\exit.png";
                                        JButton b5=new JButton(new ImageIcon(imagepath6));
                                        b5.setHorizontalAlignment(SwingConstants.LEFT);
                                        b5.setText("Close");
                                        b5.setBounds(1100,50,180,50);
                                        b5.setFont(font1);
                                        lp1.add(b5);

                                        Font font5 = new Font("Arial", Font.PLAIN, 20);

                                        b1.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                JFrame frame2 = new JFrame("New Student");
                                                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                frame2.setSize(710, 480);
                                                frame2.setLocationRelativeTo(frame1);
                                                Container c1 = frame2.getContentPane();
                                                c1.setLayout(null);

                                                JPanel jp1=new JPanel();
                                                jp1.setSize(700,470);
                                                c1.add(jp1);
                                                String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\123456.png";
                                                JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                                                lp1.setHorizontalAlignment(SwingConstants.CENTER);
                                                jp1.add(lp1);

                                                JLabel j1=new JLabel("Roll no");
                                                j1.setBounds(200,60,100,25);
                                                j1.setFont(font2);
                                                lp1.add(j1);
                                                JLabel j2=new JLabel("Name");
                                                j2.setBounds(200,120,100,25);
                                                j2.setFont(font2);
                                                lp1.add(j2);
                                                JLabel j3=new JLabel("Phone");
                                                j3.setBounds(200,180,100,25);
                                                j3.setFont(font2);
                                                lp1.add(j3);
                                                JLabel j4=new JLabel("Course");
                                                j4.setBounds(200,240,100,25);
                                                j4.setFont(font2);
                                                lp1.add(j4);
                                                JLabel j5=new JLabel("Branch");
                                                j5.setBounds(200,300,100,25);
                                                j5.setFont(font2);
                                                lp1.add(j5);

                                                JTextField f1 = new JTextField();
                                                f1.setBounds(300,60,200,25);
                                                f1.setFont(font5);
                                                lp1.add(f1);
                                                JTextField f2 = new JTextField();
                                                f2.setBounds(300,120,200,25);
                                                f2.setFont(font5);
                                                lp1.add(f2);
                                                JTextField f3 = new JTextField();
                                                f3.setBounds(300,180,200,25);
                                                f3.setFont(font5);
                                                lp1.add(f3);
                                                String [] values={"BTECH","B.PHARMA","MBA","BCA","MCA","BBA","BCOM"};
                                                JComboBox jb=new JComboBox(values);
                                                jb.setBounds(300,240,200,25);
                                                jb.setFont(font5);
                                                lp1.add(jb);
                                                String [] values1={"IT","Csc","Electronics","Textile","Mechanical","Civil"};
                                                JComboBox jb1=new JComboBox(values1);
                                                jb1.setBounds(300,300,200,25);
                                                jb1.setFont(font5);
                                                lp1.add(jb1);


                                                String imagepath7="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\save.png";
                                                JButton b11=new JButton(new ImageIcon(imagepath7));
                                                b11.setHorizontalAlignment(SwingConstants.LEFT);
                                                b11.setText("Save");
                                                b11.setBounds(300,370,90,30);
                                                b11.setFont(font1);
                                                lp1.add(b11);

                                                b11.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JOptionPane.showMessageDialog(c1,"Successfully Saved", "Message", JOptionPane.INFORMATION_MESSAGE);

                                                    }
                                                });

                                                String imagepath8="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\close.png";
                                                JButton b22=new JButton(new ImageIcon(imagepath8));
                                                b22.setHorizontalAlignment(SwingConstants.LEFT);
                                                b22.setText("Close");
                                                b22.setBounds(410,370,90,30);
                                                b22.setFont(font1);
                                                lp1.add(b22);

                                                b22.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        frame2.dispose();
                                                    }
                                                });
                                                frame2.setVisible(true);
                                            }
                                        });
                                        b2.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                JFrame frame3 = new JFrame("New Book");
                                                frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                frame3.setSize(710, 480);
                                                frame3.setLocationRelativeTo(frame1);
                                                Container c1 = frame3.getContentPane();
                                                c1.setLayout(null);

                                                JPanel jp1=new JPanel();
                                                jp1.setSize(700,470);
                                                c1.add(jp1);
                                                String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\123456.png";
                                                JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                                                lp1.setHorizontalAlignment(SwingConstants.CENTER);
                                                jp1.add(lp1);

                                                JLabel j1=new JLabel("Book Id");
                                                j1.setBounds(200,60,100,25);
                                                j1.setFont(font2);
                                                lp1.add(j1);
                                                JLabel j2=new JLabel("Name");
                                                j2.setBounds(200,120,100,25);
                                                j2.setFont(font2);
                                                lp1.add(j2);
                                                JLabel j3=new JLabel("Publisher");
                                                j3.setBounds(200,180,100,25);
                                                j3.setFont(font2);
                                                lp1.add(j3);
                                                JLabel j4=new JLabel("Price");
                                                j4.setBounds(200,240,100,25);
                                                j4.setFont(font2);
                                                lp1.add(j4);
                                                JLabel j5=new JLabel("Date");
                                                j5.setBounds(200,300,100,25);
                                                j5.setFont(font2);
                                                lp1.add(j5);

                                                JTextField f1 = new JTextField();
                                                f1.setBounds(300,60,200,25);
                                                f1.setFont(font5);
                                                lp1.add(f1);
                                                JTextField f2 = new JTextField();
                                                f2.setBounds(300,120,200,25);
                                                f2.setFont(font5);
                                                lp1.add(f2);
                                                JTextField f3 = new JTextField();
                                                f3.setBounds(300,180,200,25);
                                                f3.setFont(font5);
                                                lp1.add(f3);
                                                JTextField f4 = new JTextField();
                                                f4.setBounds(300,240,200,25);
                                                f4.setFont(font5);
                                                lp1.add(f4);

                                                Integer [] date={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                                                String [] month={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                                                Integer [] year={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                                                JComboBox jb1=new JComboBox(date);
                                                jb1.setBounds(300,300,50,25);
                                                jb1.setFont(font5);
                                                lp1.add(jb1);
                                                JComboBox jb2=new JComboBox(month);
                                                jb2.setBounds(350,300,70,25);
                                                jb2.setFont(font5);
                                                lp1.add(jb2);
                                                JComboBox jb3=new JComboBox(year);
                                                jb3.setBounds(420,300,80,25);
                                                jb3.setFont(font5);
                                                lp1.add(jb3);

                                                String imagepath7="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\save.png";
                                                JButton b11=new JButton(new ImageIcon(imagepath7));
                                                b11.setHorizontalAlignment(SwingConstants.LEFT);
                                                b11.setText("Save");
                                                b11.setBounds(300,370,90,30);
                                                b11.setFont(font1);
                                                lp1.add(b11);

                                                b11.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JOptionPane.showMessageDialog(c1,"Successfully Saved", "Message", JOptionPane.INFORMATION_MESSAGE);

                                                    }
                                                });

                                                String imagepath8="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\close.png";
                                                JButton b22=new JButton(new ImageIcon(imagepath8));
                                                b22.setHorizontalAlignment(SwingConstants.LEFT);
                                                b22.setText("Close");
                                                b22.setBounds(410,370,90,30);
                                                b22.setFont(font1);
                                                lp1.add(b22);

                                                b22.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        frame3.dispose();
                                                    }
                                                });


                                                frame3.setVisible(true);
                                            }
                                        });
                                        b3.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                JFrame frame4 = new JFrame("Issue Book");
                                                frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                frame4.setSize(710, 480);
                                                frame4.setLocationRelativeTo(frame1);
                                                Container c1 = frame4.getContentPane();
                                                c1.setLayout(null);

                                                JPanel jp1=new JPanel();
                                                jp1.setSize(700,470);
                                                c1.add(jp1);
                                                String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\123456.png";
                                                JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                                                lp1.setHorizontalAlignment(SwingConstants.CENTER);
                                                jp1.add(lp1);

                                                JLabel j1=new JLabel("Book Id");
                                                j1.setBounds(200,60,100,25);
                                                j1.setFont(font2);
                                                lp1.add(j1);
                                                JLabel j2=new JLabel("Student Id");
                                                j2.setBounds(200,120,100,25);
                                                j2.setFont(font2);
                                                lp1.add(j2);
                                                JLabel j3=new JLabel("Issue date");
                                                j3.setBounds(200,180,100,25);
                                                j3.setFont(font2);
                                                lp1.add(j3);
                                                JLabel j4=new JLabel("Due date");
                                                j4.setBounds(200,240,100,25);
                                                j4.setFont(font2);
                                                lp1.add(j4);

                                                JTextField f1 = new JTextField();
                                                f1.setBounds(330,60,200,25);
                                                f1.setFont(font5);
                                                lp1.add(f1);
                                                JTextField f2 = new JTextField();
                                                f2.setBounds(330,120,200,25);
                                                f2.setFont(font5);
                                                lp1.add(f2);
                                                Integer [] date={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                                                String [] month={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                                                Integer [] year={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                                                JComboBox jb1=new JComboBox(date);
                                                jb1.setBounds(330,180,50,25);
                                                jb1.setFont(font5);
                                                lp1.add(jb1);
                                                JComboBox jb2=new JComboBox(month);
                                                jb2.setBounds(380,180,70,25);
                                                jb2.setFont(font5);
                                                lp1.add(jb2);
                                                JComboBox jb3=new JComboBox(year);
                                                jb3.setBounds(450,180,80,25);
                                                jb3.setFont(font5);
                                                lp1.add(jb3);
                                                Integer [] date1={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                                                String [] month1={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                                                Integer [] year1={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                                                JComboBox jb11=new JComboBox(date1);
                                                jb11.setBounds(330,240,50,25);
                                                jb11.setFont(font5);
                                                lp1.add(jb11);
                                                JComboBox jb22=new JComboBox(month1);
                                                jb22.setBounds(380,240,70,25);
                                                jb22.setFont(font5);
                                                lp1.add(jb22);
                                                JComboBox jb33=new JComboBox(year1);
                                                jb33.setBounds(450,240,80,25);
                                                jb33.setFont(font5);
                                                lp1.add(jb33);


                                                String imagepath7="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\issue book.png";
                                                JButton b11=new JButton(new ImageIcon(imagepath7));
                                                b11.setHorizontalAlignment(SwingConstants.LEFT);
                                                b11.setText("Issue");
                                                b11.setBounds(330,310,90,30);
                                                b11.setFont(font1);
                                                lp1.add(b11);

                                                b11.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JOptionPane.showMessageDialog(c1,"Successfully Updated", "Message", JOptionPane.INFORMATION_MESSAGE);

                                                    }
                                                });

                                                String imagepath8="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\close.png";
                                                JButton b22=new JButton(new ImageIcon(imagepath8));
                                                b22.setHorizontalAlignment(SwingConstants.LEFT);
                                                b22.setText("Close");
                                                b22.setBounds(440,310,90,30);
                                                b22.setFont(font1);
                                                lp1.add(b22);

                                                b22.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        frame4.dispose();
                                                    }
                                                });

                                                frame4.setVisible(true);
                                            }
                                        });
                                        b4.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                JFrame frame5 = new JFrame("Return Book");
                                                frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                frame5.setSize(710, 480);
                                                frame5.setLocationRelativeTo(frame1);
                                                Container c1 = frame5.getContentPane();
                                                c1.setLayout(null);

                                                JPanel jp1=new JPanel();
                                                jp1.setSize(700,470);
                                                c1.add(jp1);
                                                String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\123456.png";
                                                JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                                                lp1.setHorizontalAlignment(SwingConstants.CENTER);
                                                jp1.add(lp1);

                                                JLabel j1=new JLabel("Book Id");
                                                j1.setBounds(200,60,100,25);
                                                j1.setFont(font2);
                                                lp1.add(j1);
                                                JLabel j2=new JLabel("Student Id");
                                                j2.setBounds(200,120,100,25);
                                                j2.setFont(font2);
                                                lp1.add(j2);
                                                JLabel j3=new JLabel("Issue date");
                                                j3.setBounds(200,180,100,25);
                                                j3.setFont(font2);
                                                lp1.add(j3);
                                                JLabel j4=new JLabel("Due date");
                                                j4.setBounds(200,240,100,25);
                                                j4.setFont(font2);
                                                lp1.add(j4);

                                                JTextField f1 = new JTextField();
                                                f1.setBounds(330,60,200,25);
                                                f1.setFont(font5);
                                                lp1.add(f1);
                                                JTextField f2 = new JTextField();
                                                f2.setBounds(330,120,200,25);
                                                f2.setFont(font5);
                                                lp1.add(f2);

                                                Integer [] date={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                                                String [] month={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                                                Integer [] year={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                                                JComboBox jb1=new JComboBox(date);
                                                jb1.setBounds(330,180,50,25);
                                                jb1.setFont(font5);
                                                lp1.add(jb1);
                                                JComboBox jb2=new JComboBox(month);
                                                jb2.setBounds(380,180,70,25);
                                                jb2.setFont(font5);
                                                lp1.add(jb2);
                                                JComboBox jb3=new JComboBox(year);
                                                jb3.setBounds(450,180,80,25);
                                                jb3.setFont(font5);
                                                lp1.add(jb3);
                                                Integer [] date1={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                                                String [] month1={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                                                Integer [] year1={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                                                JComboBox jb11=new JComboBox(date1);
                                                jb11.setBounds(330,240,50,25);
                                                jb11.setFont(font5);
                                                lp1.add(jb11);
                                                JComboBox jb22=new JComboBox(month1);
                                                jb22.setBounds(380,240,70,25);
                                                jb22.setFont(font5);
                                                lp1.add(jb22);
                                                JComboBox jb33=new JComboBox(year1);
                                                jb33.setBounds(450,240,80,25);
                                                jb33.setFont(font5);
                                                lp1.add(jb33);


                                                String imagepath7="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\return book.png";
                                                JButton b11=new JButton(new ImageIcon(imagepath7));
                                                b11.setHorizontalAlignment(SwingConstants.LEFT);
                                                b11.setText("Return");
                                                b11.setBounds(330,310,90,30);
                                                b11.setFont(font1);
                                                lp1.add(b11);

                                                b11.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JOptionPane.showMessageDialog(c1,"Successfully Return", "Message", JOptionPane.INFORMATION_MESSAGE);

                                                    }
                                                });

                                                String imagepath8="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\close.png";
                                                JButton b22=new JButton(new ImageIcon(imagepath8));
                                                b22.setHorizontalAlignment(SwingConstants.LEFT);
                                                b22.setText("Close");
                                                b22.setBounds(440,310,90,30);
                                                b22.setFont(font1);
                                                lp1.add(b22);

                                                b22.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        frame5.dispose();
                                                    }
                                                });
                                                frame5.setVisible(true);
                                            }
                                        });
                                        b5.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                               frame1.dispose();
                                            }
                                        });
                                        frame1.setVisible(true);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(c,"User name or Password is incorrect", "error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });

                            frame.setVisible(true);
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    a10.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JFrame frame7=new JFrame();
                            frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame7.setSize(770,750);
                            frame7.setLocationRelativeTo(frame1);
                            Container c2 = frame7.getContentPane();
                            c2.setLayout(null);
                            JPanel jp1=new JPanel();
                            jp1.setSize(750,700);
                            c2.add(jp1);
                            String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\library1.png";
                            JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                            lp1.setHorizontalAlignment(SwingConstants.CENTER);
                            jp1.add(lp1);
                            JLabel lp2=new JLabel("Whoops!");
                            lp2.setBounds(350,50,100,30);
                            lp2.setFont(font2);
                            JLabel lp3=new JLabel("no exam schedule found!");
                            lp3.setBounds(305,80,300,30);
                            lp3.setFont(font4);
                            lp1.add(lp2);
                            lp1.add(lp3);
                            frame7.setVisible(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    a11.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JFrame frame7=new JFrame();
                            frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame7.setSize(770,750);
                            frame7.setLocationRelativeTo(frame1);
                            Container c2 = frame7.getContentPane();
                            c2.setLayout(null);
                            JPanel jp1=new JPanel();
                            jp1.setSize(750,700);
                            c2.add(jp1);
                            String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\library1.png";
                            JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                            lp1.setHorizontalAlignment(SwingConstants.CENTER);
                            jp1.add(lp1);
                            JLabel lp2=new JLabel("Whoops!");
                            lp2.setBounds(350,50,100,30);
                            lp2.setFont(font2);
                            JLabel lp3=new JLabel("no events/holidays found!");
                            lp3.setBounds(310,80,300,30);
                            lp3.setFont(font4);
                            lp1.add(lp2);
                            lp1.add(lp3);
                            frame7.setVisible(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    JPanel jp1=new JPanel();
                    jp1.setSize(1000,700);
                    c1.add(jp1);
                    String imagepath1="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\pietproject2.jpg";
                    JLabel lp1=new JLabel(new ImageIcon(imagepath1));
                    lp1.setHorizontalAlignment(SwingConstants.CENTER);
                    jp1.add(lp1);

                    JButton b1=new JButton("Student");
                    b1.setBounds(300,50,100,40);
                    b1.setBackground(Color.blue);
                    b1.setForeground(Color.white);
                    Font font2=new Font("Arial",Font.BOLD,20);
                    b1.setFont(font2);
                    lp1.add(b1);

                    JButton b2=new JButton("Teacher");
                    b2.setBounds(530,50,100,40);
                    b2.setBackground(Color.orange);
                    b2.setForeground(Color.black);
                    b2.setFont(font2);
                    lp1.add(b2);

                    JButton b3=new JButton("Management");
                    b3.setBounds(730,50,150,40);
                    b3.setBackground(Color.red);
                    b3.setForeground(Color.white);
                    b3.setFont(font2);
                    lp1.add(b3);

                    String imagepath="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\exit1.png";
                    JButton b4=new JButton(new ImageIcon(imagepath));
                    b4.setText("Logout");
                    b4.setBounds(1,630,1180,40);
                    Font font3=new Font("Arial",Font.BOLD,25);
                    b4.setFont(font3);
                    lp1.add(b4);

                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame1.dispose();
                            JFrame frame2 = new JFrame("Student management system");
                            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame2.setSize(1000,700);
                            frame2.setLocationRelativeTo(frame1);
                            Container c2 = frame2.getContentPane();
                            c2.setLayout(null);
                            
                            JPanel p1=new JPanel();
                            p1.setBounds(1,1,1000,40);
                            p1.setBackground(Color.white);
                            p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            JLabel k1=new JLabel("STUDENT INFORMATION",JLabel.CENTER);
                            k1.setForeground(Color.blue);
                            k1.setFont(font3);
                            p1.add(k1);
                            c2.add(p1);

                            JPanel m1=new JPanel();
                            m1.setBounds(1,630,1000,40);
                            m1.setBackground(Color.white);
                            m1.setForeground(Color.BLACK);

                            String imagepath6="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\home.png";
                            JButton x1=new JButton(new ImageIcon(imagepath6));
                            x1.setText("HOME");
                            x1.setBackground(Color.blue);
                            x1.setForeground(Color.white);
                            x1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            x1.setFont(font3);
                            m1.add(x1);
                            c2.add(m1);

                            x1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame2.dispose();
                                    frame1.setVisible(true);
                                }
                            });

                            JPanel s1=new JPanel();
                            s1.setBounds(1,41,1000,260);
                            s1.setBackground(Color.blue);
                            s1.setLayout(null);
                            c2.add(s1);

                            JLabel j1=new JLabel("Name");
                            j1.setBounds(10,60,100,30);
                            j1.setForeground(Color.white);
                            j1.setFont(font2);
                            s1.add(j1);
                            JLabel j2=new JLabel("Roll no");
                            j2.setBounds(10,120,100,30);
                            j2.setForeground(Color.white);
                            j2.setFont(font2);
                            s1.add(j2);
                            JLabel j3=new JLabel("Branch");
                            j3.setBounds(10,180,100,30);
                            j3.setForeground(Color.white);
                            j3.setFont(font2);
                            s1.add(j3);

                            JTextField f1 = new JTextField();
                            f1.setBounds(100,60,150,30);
                            f1.setFont(font2);
                            s1.add(f1);
                            JTextField f2 = new JTextField();
                            f2.setBounds(100,120,150,30);
                            f2.setFont(font2);
                            s1.add(f2);
                            JTextField f3 = new JTextField();
                            f3.setBounds(100,180,150,30);
                            f3.setFont(font2);
                            s1.add(f3);

                            JLabel j4=new JLabel("Age");
                            j4.setBounds(300,60,100,30);
                            j4.setForeground(Color.white);
                            j4.setFont(font2);
                            s1.add(j4);
                            JLabel j5=new JLabel("Gender");
                            j5.setBounds(300,120,100,30);
                            j5.setForeground(Color.white);
                            j5.setFont(font2);
                            s1.add(j5);
                            JLabel j6=new JLabel("Phone");
                            j6.setBounds(300,180,100,30);
                            j6.setForeground(Color.white);
                            j6.setFont(font2);
                            s1.add(j6);

                            JTextField f4 = new JTextField();
                            f4.setBounds(400,60,150,30);
                            f4.setFont(font2);
                            s1.add(f4);
                            String [] values={"Male", "Female", "Others"};
                            JComboBox jb=new JComboBox(values);
                            jb.setBounds(400,120,150,30);
                            jb.setFont(font2);
                            s1.add(jb);
                            JTextField f6 = new JTextField();
                            f6.setBounds(400,180,150,30);
                            f6.setFont(font2);
                            s1.add(f6);

                            JLabel j7=new JLabel("Address");
                            j7.setBounds(600,60,100,30);
                            j7.setForeground(Color.white);
                            j7.setFont(font2);
                            s1.add(j7);
                            JLabel j8=new JLabel("DOB");
                            j8.setBounds(610,120,100,30);
                            j8.setForeground(Color.white);
                            j8.setFont(font2);
                            s1.add(j8);

                            JTextField f7 = new JTextField();
                            f7.setBounds(700,60,220,30);
                            f7.setFont(font2);
                            s1.add(f7);

                            Integer [] date={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                            String [] month={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                            Integer [] year={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                            JComboBox jb1=new JComboBox(date);
                            jb1.setBounds(700,120,60,30);
                            jb1.setFont(font2);
                            s1.add(jb1);
                            JComboBox jb2=new JComboBox(month);
                            jb2.setBounds(760,120,80,30);
                            jb2.setFont(font2);
                            s1.add(jb2);
                            JComboBox jb3=new JComboBox(year);
                            jb3.setBounds(840,120,80,30);
                            jb3.setFont(font2);
                            s1.add(jb3);

                            FlowLayout f=new FlowLayout();
                            f.setHgap(20);

                            JPanel s2=new JPanel();
                            s2.setLayout(f);
                            s2.setBounds(1,301,1000,50);
                            s2.setBackground(Color.white);
                            c2.add(s2);

                            JButton b11 = new JButton("ADD");
                            b11.setBackground(Color.blue);
                            b11.setForeground(Color.white);
                            JButton b22 = new JButton("UPDATE");
                            b22.setBackground(Color.blue);
                            b22.setForeground(Color.white);
                            JButton b33 = new JButton("DELETE");
                            b33.setBackground(Color.blue);
                            b33.setForeground(Color.white);
                            JButton b44 = new JButton("CLEAR");
                            b44.setBackground(Color.blue);
                            b44.setForeground(Color.white);

                            b11.setFont(font2);
                            b22.setFont(font2);
                            b33.setFont(font2);
                            b44.setFont(font2);

                            s2.add(b11);
                            s2.add(b22);
                            s2.add(b33);
                            s2.add(b44);

                            JPanel p11=new JPanel();
                            p11.setBounds(1,351,1000,30);
                            p11.setBackground(Color.white);
                            p11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            JLabel k11=new JLabel("STUDENT LIST",JLabel.CENTER);
                            k11.setForeground(Color.blue);
                            k11.setFont(font2);
                            p11.add(k11);
                            c2.add(p11);

                            JPanel p22=new JPanel();
                            p22.setLayout(new GridLayout(1,8));
                            p22.setBounds(1,381,1000,249);
                            p22.setBackground(Color.white);
                            c2.add(p22);

                            String[][] data = {
                                    {"rahul", "1", "btech","19","Male","9991600632","delhi","1-jan-2003"},
                                    {"manisha", "2", "bsc","19","Female","9991400612","haryana","3-feb-2004"},
                                    {"jagrit","3","bba","22","Male","8053118345","Sonipat","2-july-2002"},
                                    {"chirag","4","bca","20","Male","9032412543","Kurukshetra","8-aug-2003"},
                                    {"amit","5","btech","20","Male","8053467892","Karnal","9-mar-2004"}
                            };
                            String [] columns = {
                                    "Name","Rollno","Branch","Age","Gender","Phone","Address","DOB"
                            };

                            DefaultTableModel model = new DefaultTableModel(data,columns);
                            JTable tb = new JTable(model);
                            tb.setBackground(Color.white);
                            tb.setForeground(Color.black);
                            tb.setFont(font1);
                            p22.add(new JScrollPane(tb));

                            b11.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {


                                    if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty()
                                            ||f4.getText().isEmpty() || f6.getText().isEmpty() || f7.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(c2, "Please enter all the fields", "message", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        String Name = f1.getText();
                                        String Rollno = f2.getText();
                                        String Branch = f3.getText();
                                        String Age = f4.getText();
                                        String Gender = (String) jb.getSelectedItem();
                                        String Phone = f6.getText();
                                        String Address = f7.getText();
                                        String DOB= jb1.getSelectedItem() +"-"+jb2.getSelectedItem()+"-"+jb3.getSelectedItem();

                                        Object[] newrow = {Name,Rollno,Branch,Age,Gender,Phone,Address,DOB};
                                        model.addRow(newrow);

                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        f4.setText(null);
                                        jb.setSelectedItem(null);
                                        f6.setText(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);
                                    }
                                }
                            });
                            tb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Integer rowindex = tb.getSelectedRow();

                                    String Name = (String) model.getValueAt(rowindex, 0);
                                    String Rollno = (String) model.getValueAt(rowindex, 1);
                                    String Branch = (String) model.getValueAt(rowindex, 2);
                                    String Age = (String) model.getValueAt(rowindex, 3);
                                    String Gender = (String) model.getValueAt(rowindex, 4);
                                    String Phone = (String) model.getValueAt(rowindex, 5);
                                    String Address = (String) model.getValueAt(rowindex, 6);
                                    String DOB= (String) model.getValueAt(rowindex, 7);

                                    f1.setText(Name);
                                    f2.setText(Rollno);
                                    f3.setText(Branch);
                                    f4.setText(Age);
                                    jb.setSelectedItem(Gender);
                                    f6.setText(Phone);
                                    f7.setText(Address);
                                    jb1.setSelectedItem(date);
                                    jb2.setSelectedItem(month);
                                    jb3.setSelectedItem(year);
                                }
                            });
                            b22.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty() ||
                                            f4.getText().isEmpty() || f6.getText().isEmpty() || f7.getText().isEmpty()
                                    )
                                    {
                                        JOptionPane.showMessageDialog(c2, "please enter all the fields", "message", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        String Name = f1.getText();
                                        String Rollno = f2.getText();
                                        String Branch = f3.getText();
                                        String Age = f4.getText();
                                        String Gender = (String) jb.getSelectedItem();
                                        String Phone = f6.getText();
                                        String Address = f7.getText();
                                        String DOB= jb1.getSelectedItem() +"-"+jb2.getSelectedItem()+"-"+jb3.getSelectedItem();

                                        Integer row = tb.getSelectedRow();
                                        model.setValueAt(Name, row, 0);
                                        model.setValueAt(Rollno, row, 1);
                                        model.setValueAt(Branch, row, 2);
                                        model.setValueAt(Age, row, 3);
                                        model.setValueAt(Gender, row, 4);
                                        model.setValueAt(Phone, row, 5);
                                        model.setValueAt(Address, row, 6);
                                        model.setValueAt(DOB, row, 7);

                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        f4.setText(null);
                                        jb.setSelectedItem(null);
                                        f6.setText(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);
                                    }
                                }
                            });
                            b33.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (tb.getSelectedRow() == -1) {
                                        JOptionPane.showMessageDialog(c2, "Please select the row", "error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    else
                                    {
                                        int s=JOptionPane.showConfirmDialog(c2, "Do u Really want to Remove a row?", "confirm", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                                        if(s==JOptionPane.YES_OPTION) {
                                            model.removeRow(tb.getSelectedRow());
                                        }
                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        f4.setText(null);
                                        jb.setSelectedItem(null);
                                        f6.setText(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);
                                    }
                                }
                            });

                            b44.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    f1.setText(null);
                                    f2.setText(null);
                                    f3.setText(null);
                                    f4.setText(null);
                                    jb.setSelectedItem(null);
                                    f6.setText(null);
                                    f7.setText(null);
                                    jb1.setSelectedItem(null);
                                    jb2.setSelectedItem(null);
                                    jb3.setSelectedItem(null);
                                }
                            });
                            frame2.setVisible(true);
                        }
                    });

                    b2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame1.dispose();
                            JFrame frame3 = new JFrame("Teacher management system");
                            frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame3.setSize(1000,700);
                            frame3.setLocationRelativeTo(frame1);
                            Container c3 = frame3.getContentPane();
                            c3.setLayout(null);

                            JPanel p2=new JPanel();
                            p2.setBounds(1,1,1000,40);
                            p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            p2.setBackground(Color.black);
                            JLabel k2=new JLabel("TEACHER INFORMATION",JLabel.CENTER);
                            k2.setForeground(Color.orange);
                            k2.setFont(font3);
                            p2.add(k2);
                            c3.add(p2);

                            JPanel m2=new JPanel();
                            m2.setBounds(1,630,1000,40);
                            m2.setBackground(Color.white);
                            m2.setForeground(Color.BLACK);
                            String imagepath6="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\home.png";
                            JButton x2=new JButton(new ImageIcon(imagepath6));
                            x2.setText("HOME");
                            x2.setBackground(Color.black);
                            x2.setForeground(Color.orange);
                            x2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            x2.setFont(font3);
                            m2.add(x2);
                            c3.add(m2);

                            x2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame3.dispose();
                                    frame1.setVisible(true);
                                }
                            });

                            JPanel s1=new JPanel();
                            s1.setBounds(1,41,1000,260);
                            s1.setBackground(Color.orange);
                            s1.setLayout(null);
                            c3.add(s1);

                            JLabel j1=new JLabel("Faculty Name");
                            j1.setBounds(10,60,150,30);
                            j1.setFont(font2);
                            s1.add(j1);
                            JLabel j2=new JLabel("Experience");
                            j2.setBounds(10,120,150,30);
                            j2.setFont(font2);
                            s1.add(j2);
                            JLabel j3=new JLabel("Designation");
                            j3.setBounds(10,180,150,30);
                            j3.setFont(font2);
                            s1.add(j3);

                            JTextField f1 = new JTextField();
                            f1.setBounds(150,60,150,30);
                            f1.setFont(font2);
                            s1.add(f1);
                            JTextField f2 = new JTextField();
                            f2.setBounds(150,120,150,30);
                            f2.setFont(font2);
                            s1.add(f2);
                            JTextField f3 = new JTextField();
                            f3.setBounds(150,180,150,30);
                            f3.setFont(font2);
                            s1.add(f3);

                            JLabel j4=new JLabel("Area of interest");
                            j4.setBounds(350,60,150,30);
                            j4.setFont(font2);
                            s1.add(j4);
                            JLabel j5=new JLabel("Qualification");
                            j5.setBounds(350,120,150,30);
                            j5.setFont(font2);
                            s1.add(j5);
                            JLabel j6=new JLabel("Date of joining");
                            j6.setBounds(350,180,150,30);
                            j6.setFont(font2);
                            s1.add(j6);

                            JTextField f4 = new JTextField();
                            f4.setBounds(530,60,150,30);
                            f4.setFont(font2);
                            s1.add(f4);

                            String [] values={"BSc", "B.A", "B.Ed","M.A","MSc","M.Ed","B.tech","M.tech","Ph.D"};
                            JComboBox jb=new JComboBox(values);
                            jb.setBounds(530,120,150,30);
                            jb.setFont(font2);
                            s1.add(jb);

                            String [] values1={"Male","Female","Others"};
                            JComboBox jb4=new JComboBox(values1);
                            jb4.setBounds(810,120,150,30);
                            jb4.setFont(font2);
                            s1.add(jb4);

                            JLabel j7=new JLabel("Phone");
                            j7.setBounds(720,60,70,30);
                            j7.setFont(font2);
                            s1.add(j7);
                            JLabel j8=new JLabel("Gender");
                            j8.setBounds(720,120,80,30);
                            j8.setFont(font2);
                            s1.add(j8);

                            JTextField f7 = new JTextField();
                            f7.setBounds(810,60,150,30);
                            f7.setFont(font2);
                            s1.add(f7);

                            Integer [] date={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                            String [] month={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                            Integer [] year={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                            JComboBox jb1=new JComboBox(date);
                            jb1.setBounds(530,180,60,30);
                            jb1.setFont(font2);
                            s1.add(jb1);
                            JComboBox jb2=new JComboBox(month);
                            jb2.setBounds(590,180,80,30);
                            jb2.setFont(font2);
                            s1.add(jb2);
                            JComboBox jb3=new JComboBox(year);
                            jb3.setBounds(670,180,80,30);
                            jb3.setFont(font2);
                            s1.add(jb3);

                            FlowLayout f=new FlowLayout();
                            f.setHgap(20);

                            JPanel s2=new JPanel();
                            s2.setLayout(f);
                            s2.setBounds(1,301,1000,50);
                            s2.setBackground(Color.white);
                            c3.add(s2);

                            JButton b11 = new JButton("ADD");
                            b11.setBackground(Color.black);
                            b11.setForeground(Color.orange);
                            JButton b22 = new JButton("UPDATE");
                            b22.setBackground(Color.black);
                            b22.setForeground(Color.orange);
                            JButton b33 = new JButton("DELETE");
                            b33.setBackground(Color.black);
                            b33.setForeground(Color.orange);
                            JButton b44 = new JButton("CLEAR");
                            b44.setBackground(Color.black);
                            b44.setForeground(Color.orange);

                            b11.setFont(font2);
                            b22.setFont(font2);
                            b33.setFont(font2);
                            b44.setFont(font2);

                            s2.add(b11);
                            s2.add(b22);
                            s2.add(b33);
                            s2.add(b44);

                            JPanel p11=new JPanel();
                            p11.setBounds(1,351,1000,30);
                            p11.setBackground(Color.black);

                            p11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            JLabel k11=new JLabel("TEACHER LIST",JLabel.CENTER);
                            k11.setForeground(Color.orange);
                            k11.setFont(font2);
                            p11.add(k11);
                            c3.add(p11);


                            JPanel p22=new JPanel();
                            p22.setLayout(new GridLayout(1,8));
                            p22.setBounds(1,381,1000,249);
                            p22.setBackground(Color.white);
                            c3.add(p22);

                            String[][] data = {
                                    {"Sunil","5 years","Assistant prof.","java","M.tech","2-jan-1984","8905671234","Male"},
                                    {"Manisha","2 years","Professor","C++","B.Ed","13-feb-1986","8012365217","Female"},
                                    {"Deepak","3 years","Professor","C","Ph.D","24-mar-1990","9786012365","Male"},
                                    {"Riya","8 years","Assistant prof.","Communication","M.Ed","22-dec-1989","8032156743","Male"},
                                    {"Nitisha","6 years","Professor","Networking","Ph.D","18-jul-1979","7895434521","Female"}
                            };
                            String [] columns = {
                                    "Faculty Name","Experience","Designation","Area of interest","Qualififcation","Date of joining","Phone","Gender"
                            };

                            DefaultTableModel model = new DefaultTableModel(data,columns);
                            JTable tb = new JTable(model);
                            tb.setBackground(Color.orange);
                            tb.setForeground(Color.black);
                            tb.setFont(font1);
                            p22.add(new JScrollPane(tb));


                            b11.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty()
                                            ||f4.getText().isEmpty() || f7.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(c3, "Please enter all the fields!", "message", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        String FacultyName = f1.getText();
                                        String Experience = f2.getText();
                                        String Designation = f3.getText();
                                        String Areaofinterest = f4.getText();
                                        String Qualification = (String) jb.getSelectedItem();
                                        String Dateofjoining = jb1.getSelectedItem() +"-"+jb2.getSelectedItem()+"-"+jb3.getSelectedItem();
                                        String Phone= f7.getText();;
                                        String Gender = (String) jb4.getSelectedItem();

                                        Object[] newrow = {FacultyName,Experience,Designation,Areaofinterest,Qualification,Dateofjoining,Phone,Gender};
                                        model.addRow(newrow);

                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        f4.setText(null);
                                        jb.setSelectedItem(null);
                                        jb4.setSelectedItem(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);

                                    }
                                }
                            });
                            tb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Integer rowindex = tb.getSelectedRow();

                                    String FacultyName = (String) model.getValueAt(rowindex, 0);
                                    String Experience = (String) model.getValueAt(rowindex, 1);
                                    String Designation = (String) model.getValueAt(rowindex, 2);
                                    String Areaofinterest = (String) model.getValueAt(rowindex, 3);
                                    String Qualification = (String) model.getValueAt(rowindex, 4);
                                    String Dateofjoining = (String) model.getValueAt(rowindex, 5);
                                    String Phone = (String) model.getValueAt(rowindex, 6);
                                    String Gender= (String) model.getValueAt(rowindex, 7);

                                    f1.setText(FacultyName);
                                    f2.setText(Experience);
                                    f3.setText(Designation);
                                    f4.setText(Areaofinterest);
                                    jb.setSelectedItem(Qualification);
                                    jb4.setSelectedItem(Gender);
                                    f7.setText(Phone);
                                    jb1.setSelectedItem(date);
                                    jb2.setSelectedItem(month);
                                    jb3.setSelectedItem(year);
                                }
                            });
                            b22.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty() ||
                                            f4.getText().isEmpty() || f7.getText().isEmpty()
                                    )
                                    {
                                        JOptionPane.showMessageDialog(c3, "Please enter all the fields!", "message", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        String FacultyName = f1.getText();
                                        String Experience = f2.getText();
                                        String Designation = f3.getText();
                                        String Areaofinterest = f4.getText();
                                        String Qualification = (String) jb.getSelectedItem();
                                        String Dateofjoining = jb1.getSelectedItem() +"-"+jb2.getSelectedItem()+"-"+jb3.getSelectedItem();
                                        String Phone= f7.getText();;
                                        String Gender = (String) jb4.getSelectedItem();


                                        Integer row = tb.getSelectedRow();
                                        model.setValueAt(FacultyName, row, 0);
                                        model.setValueAt(Experience, row, 1);
                                        model.setValueAt(Designation, row, 2);
                                        model.setValueAt(Areaofinterest, row, 3);
                                        model.setValueAt(Qualification, row, 4);
                                        model.setValueAt(Dateofjoining, row, 5);
                                        model.setValueAt(Phone, row, 6);
                                        model.setValueAt(Gender, row, 7);

                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        f4.setText(null);
                                        jb.setSelectedItem(null);
                                        jb4.setSelectedItem(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);
                                    }
                                }
                            });
                            b33.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (tb.getSelectedRow() == -1) {
                                        JOptionPane.showMessageDialog(c3, "Please select a row!", "error", JOptionPane.ERROR_MESSAGE);
                                    }

                                    else
                                    {
                                        int s=JOptionPane.showConfirmDialog(c3, "Do u Really want to Remove a row?", "confirm", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                                        if(s==JOptionPane.YES_OPTION) {
                                            model.removeRow(tb.getSelectedRow());
                                        }

                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        f4.setText(null);
                                        jb.setSelectedItem(null);
                                        jb4.setSelectedItem(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);

                                    }
                                }
                            });

                            b44.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f1.setText(null);
                                    f2.setText(null);
                                    f3.setText(null);
                                    f4.setText(null);
                                    jb.setSelectedItem(null);
                                    jb4.setSelectedItem(null);
                                    f7.setText(null);
                                    jb1.setSelectedItem(null);
                                    jb2.setSelectedItem(null);
                                    jb3.setSelectedItem(null);
                                }
                            });
                            frame3.setVisible(true);
                        }
                    });

                    b3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame1.dispose();
                            JFrame frame4 = new JFrame("Management system");
                            frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame4.setSize(1000,700);
                            frame4.setLocationRelativeTo(frame1);
                            Container c4 = frame4.getContentPane();
                            c4.setLayout(null);

                            JPanel p3=new JPanel();
                            p3.setBounds(1,1,1000,40);
                            p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            p3.setBackground(Color.red);
                            JLabel k3=new JLabel("MANAGEMENT INFORMATION",JLabel.CENTER);
                            k3.setForeground(Color.white);
                            k3.setFont(font3);
                            p3.add(k3);
                            c4.add(p3);

                            JPanel m3=new JPanel();
                            m3.setBounds(1,630,1000,40);
                            m3.setBackground(Color.white);
                            m3.setForeground(Color.BLACK);
                            String imagepath6="C:\\Users\\lakshay\\IdeaProjects\\first program\\src\\home.png";
                            JButton x3=new JButton(new ImageIcon(imagepath6));
                            x3.setText("HOME");
                            x3.setBackground(Color.red);
                            x3.setForeground(Color.white);
                            x3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            x3.setFont(font3);
                            m3.add(x3);
                            c4.add(m3);

                            x3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame4.dispose();
                                    frame1.setVisible(true);
                                }
                            });

                            JPanel s1=new JPanel();
                            s1.setBounds(1,41,1000,260);
                            s1.setBackground(Color.white);
                            s1.setLayout(null);
                            c4.add(s1);

                            JLabel j1=new JLabel("Member Name");
                            j1.setBounds(10,60,150,30);
                            j1.setForeground(Color.red);
                            j1.setFont(font2);
                            s1.add(j1);
                            JLabel j2=new JLabel("Designation");
                            j2.setBounds(10,120,150,30);
                            j2.setForeground(Color.red);
                            j2.setFont(font2);
                            s1.add(j2);
                            JLabel j3=new JLabel("Age");
                            j3.setBounds(10,180,150,30);
                            j3.setForeground(Color.red);
                            j3.setFont(font2);
                            s1.add(j3);

                            JTextField f1 = new JTextField();
                            f1.setBounds(160,60,150,30);
                            f1.setFont(font2);
                            s1.add(f1);
                            JTextField f2 = new JTextField();
                            f2.setBounds(160,120,150,30);
                            f2.setFont(font2);
                            s1.add(f2);
                            JTextField f3 = new JTextField();
                            f3.setBounds(160,180,150,30);
                            f3.setFont(font2);
                            s1.add(f3);

//                            JLabel j4=new JLabel("Age");
//                            j4.setBounds(350,60,100,30);
//                            j4.setForeground(Color.red);
//                            j4.setFont(font2);
//                            s1.add(j4);
                            JLabel j5=new JLabel("Gender");
                            j5.setBounds(350,60,100,30);
                            j5.setForeground(Color.red);
                            j5.setFont(font2);
                            s1.add(j5);
                            JLabel j6=new JLabel("Phone");
                            j6.setBounds(350,120,100,30);
                            j6.setForeground(Color.red);
                            j6.setFont(font2);
                            s1.add(j6);

//                            JTextField f4 = new JTextField();
//                            f4.setBounds(450,60,150,30);
//                            f4.setFont(font2);
//                            s1.add(f4);
                            String [] values={"Male", "Female", "Others"};
                            JComboBox jb=new JComboBox(values);
                            jb.setBounds(450,60,150,30);
                            jb.setFont(font2);
                            s1.add(jb);
                            JTextField f6 = new JTextField();
                            f6.setBounds(450,120,150,30);
                            f6.setFont(font2);
                            s1.add(f6);

                            JLabel j7=new JLabel("Address");
                            j7.setBounds(650,60,100,30);
                            j7.setForeground(Color.red);
                            j7.setFont(font2);
                            s1.add(j7);
                            JLabel j8=new JLabel("DOB");
                            j8.setBounds(650,120,100,30);
                            j8.setForeground(Color.red);
                            j8.setFont(font2);
                            s1.add(j8);

                            JTextField f7 = new JTextField();
                            f7.setBounds(750,60,180,30);
                            f7.setFont(font2);
                            s1.add(f7);

                            Integer [] date={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
                            String [] month={"jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
                            Integer [] year={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010};
                            JComboBox jb1=new JComboBox(date);
                            jb1.setBounds(750,120,60,30);
                            jb1.setFont(font2);
                            s1.add(jb1);
                            JComboBox jb2=new JComboBox(month);
                            jb2.setBounds(810,120,80,30);
                            jb2.setFont(font2);
                            s1.add(jb2);
                            JComboBox jb3=new JComboBox(year);
                            jb3.setBounds(890,120,80,30);
                            jb3.setFont(font2);
                            s1.add(jb3);

                            FlowLayout f=new FlowLayout();
                            f.setHgap(20);

                            JPanel s2=new JPanel();
                            s2.setLayout(f);
                            s2.setBounds(1,301,1000,50);
                            s2.setBackground(Color.white);
                            c4.add(s2);

                            JButton b11 = new JButton("ADD");
                            b11.setBackground(Color.red);
                            b11.setForeground(Color.white);
                            JButton b22 = new JButton("UPDATE");
                            b22.setBackground(Color.red);
                            b22.setForeground(Color.white);
                            JButton b33 = new JButton("DELETE");
                            b33.setBackground(Color.red);
                            b33.setForeground(Color.white);
                            JButton b44 = new JButton("CLEAR");
                            b44.setBackground(Color.red);
                            b44.setForeground(Color.white);

                            b11.setFont(font2);
                            b22.setFont(font2);
                            b33.setFont(font2);
                            b44.setFont(font2);

                            s2.add(b11);
                            s2.add(b22);
                            s2.add(b33);
                            s2.add(b44);

                            JPanel p11=new JPanel();
                            p11.setBounds(1,351,1000,30);
                            p11.setBackground(Color.red);
                            p11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            JLabel k11=new JLabel("MANAGEMENT LIST",JLabel.CENTER);
                            k11.setForeground(Color.white);
                            k11.setFont(font2);
                            p11.add(k11);
                            c4.add(p11);

                            JPanel p22=new JPanel();
                            p22.setLayout(new GridLayout(1,8));
                            p22.setBounds(1,381,1000,249);
                            p22.setBackground(Color.white);
                            c4.add(p22);

                            String[][] data = {
                                    {"Rakesh tayal", "Member(Trustee)","46","Male","9991600632","Panipat","1-jan-1980"},
                                    {"Shubham tayal", "Member(Trustee)","45","Male","9991400612","Panipat","3-feb-1978"},
                                    {"Hari om tayal","Chairman","55","Male","8790623543","Panipat","5-aug-1967"}
                            };
                            String [] columns = {
                                    "Name","Designation","Age","Gender","Phone","Address","DOB"
                            };

                            DefaultTableModel model = new DefaultTableModel(data,columns);
                            JTable tb = new JTable(model);
                            tb.setForeground(Color.red);
                            tb.setFont(font1);
                            p22.add(new JScrollPane(tb));


                            b11.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty()
                                             || f6.getText().isEmpty() || f7.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(c4, "Please enter all the fields!", "message", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        String Name = f1.getText();
                                        String designation = f2.getText();
                                        String Age = f3.getText();
                                        String Gender = (String) jb.getSelectedItem();
                                        String Phone = f6.getText();
                                        String Address = f7.getText();
                                        String DOB= jb1.getSelectedItem() +"-"+jb2.getSelectedItem()+"-"+jb3.getSelectedItem();

                                        Object[] newrow = {Name,designation,Age,Gender,Phone,Address,DOB};
                                        model.addRow(newrow);

                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        jb.setSelectedItem(null);
                                        f6.setText(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);

                                    }
                                }
                            });
                            tb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Integer rowindex = tb.getSelectedRow();

                                    String Name = (String) model.getValueAt(rowindex, 0);
                                    String designation = (String) model.getValueAt(rowindex, 1);
                                    String Age = (String) model.getValueAt(rowindex, 2);
                                    String Gender = (String) model.getValueAt(rowindex, 3);
                                    String Phone = (String) model.getValueAt(rowindex, 4);
                                    String Address = (String) model.getValueAt(rowindex, 5);
                                    String DOB= (String) model.getValueAt(rowindex, 6);

                                    f1.setText(Name);
                                    f2.setText(designation);
                                    f3.setText(Age);
                                    jb.setSelectedItem(Gender);
                                    f6.setText(Phone);
                                    f7.setText(Address);
                                    jb1.setSelectedItem(date);
                                    jb2.setSelectedItem(month);
                                    jb3.setSelectedItem(year);
                                }
                            });
                            b22.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty() ||
                                     f6.getText().isEmpty() || f7.getText().isEmpty()
                                    )
                                    {
                                        JOptionPane.showMessageDialog(c4, "Please enter all the fields!", "message", JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        String Name = f1.getText();
                                        String Rollno = f2.getText();
                                        String Branch = f3.getText();
                                        String Gender = (String) jb.getSelectedItem();
                                        String Phone = f6.getText();
                                        String Address = f7.getText();
                                        String DOB= jb1.getSelectedItem() +"-"+jb2.getSelectedItem()+"-"+jb3.getSelectedItem();

                                        Integer row = tb.getSelectedRow();
                                        model.setValueAt(Name, row, 0);
                                        model.setValueAt(Rollno, row, 1);
                                        model.setValueAt(Branch, row, 2);
                                        model.setValueAt(Gender, row, 3);
                                        model.setValueAt(Phone, row, 4);
                                        model.setValueAt(Address, row, 5);
                                        model.setValueAt(DOB, row, 6);

                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        jb.setSelectedItem(null);
                                        f6.setText(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);
                                    }
                                }
                            });
                            b33.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (tb.getSelectedRow() == -1) {
                                        JOptionPane.showMessageDialog(c4, "Please select a row!", "error", JOptionPane.ERROR_MESSAGE);
                                    }

                                    else
                                    {
                                        int s=JOptionPane.showConfirmDialog(c4, "Do u Really want to Remove a row?", "confirm", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                                        if(s==JOptionPane.YES_OPTION) {
                                            model.removeRow(tb.getSelectedRow());
                                        }
                                        f1.setText(null);
                                        f2.setText(null);
                                        f3.setText(null);
                                        jb.setSelectedItem(null);
                                        f6.setText(null);
                                        f7.setText(null);
                                        jb1.setSelectedItem(null);
                                        jb2.setSelectedItem(null);
                                        jb3.setSelectedItem(null);
                                    }
                                }
                            });
                            b44.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    f1.setText(null);
                                    f2.setText(null);
                                    f3.setText(null);
                                    jb.setSelectedItem(null);
                                    f6.setText(null);
                                    f7.setText(null);
                                    jb1.setSelectedItem(null);
                                    jb2.setSelectedItem(null);
                                    jb3.setSelectedItem(null);
                                }
                            });

                            frame4.setVisible(true);
                        }
                    });
                    b4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame1.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(c,"User name or Password is incorrect,try again!", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
