import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
class Layer1 {
public ResultSet rs=null;
public ResultSetMetaData m=null;
public static String db=null,tbl=null;
public Statement stmt=null;
public DatabaseMetaData dm=null;
public Connection con=null;
public JFrame frame=new JFrame();
public JDesktopPane desktop=new JDesktopPane();
public JInternalFrame iframe=new JInternalFrame("form",true,true,true);

	public void connect(String db,String tbl){
        	try{
        	Class.forName("com.mysql.jdbc.Driver");
        	String url="jdbc:mysql://localhost/"+db+"";
        	String user="root";
        	String pass="password";
        	con =DriverManager.getConnection(url,user,pass);
        	stmt=con.createStatement();
        	rs=stmt.executeQuery("select * from "+tbl+"");
		dm=con.getMetaData();

        }catch(SQLException s){
        	s.printStackTrace();
        }catch(ClassNotFoundException c){
       		c.printStackTrace();
        }frame.setSize(1100,1200);
		iframe.setLayout(null);
                iframe.setSize(900,900);
                iframe.setBounds(0,0,700,700);
                //desktop.add(iframe);
                //frame.setContentPane(desktop);
	//	iframe.setVisible(true);

        }
	public void gui(){
		
               	frame.setLayout(null);
		frame.setBounds(0,0,1100,900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public boolean search(String key,String val){
	String sql="select * from "+tbl+" where "+key+"=";
	Boolean bool=false;
	try{rs=stmt.executeQuery("select * from "+tbl);
		m=rs.getMetaData();
		for(int i=2;i<=m.getColumnCount();i++){
			if(m.getColumnName(i).equals(key)){
				if(m.getColumnTypeName(i).equals("INT")||m.getColumnTypeName(i).equals("TINYINT")){
				sql=sql.concat(val);
				}else{
				sql=sql.concat("'"+val+"'");	
				}
			}

		}
		System.out.println(sql);
		rs=stmt.executeQuery(sql);
		if(rs.next()){
		bool=true;

			}
		}catch(SQLException s1){
			s1.printStackTrace();
			}
		return bool;
	}
	public boolean empty(JTextField[] t){
		boolean bool=false;
		for(int i=0;i<t.length-1;i++){
			if(t[i].getText().isEmpty()){
			bool=true;break;
			}
		}
	return bool;
	}
	public void reset(JTextField[] t){
		for(int i=0;i<t.length-1;i++){
		t[i].setText("");
		}
	}

}


