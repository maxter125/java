import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class Layer3 extends Layer2 implements ActionListener{
JButton b[]=new JButton[4];
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("update")){
			if(empty(t)){
				msg.setText("enter");
			}else{
				update();}
		}else if(e.getActionCommand().equals("insert")){
			if(empty(t)){
				msg.setText("enter");
			}else{
				insert();}
		}else if(e.getActionCommand().equals("reset")){
				reset(t);
		}else if(e.getActionCommand().equals("search")){
		}	
	}
	Layer3(String s,String ss){
		super(s,ss);
		System.out.println("yoo");
		display();iframe.setVisible(true);

		}
	public void display(){
		b[0]=new JButton("search");
		b[1]=new JButton("update");
		b[2]=new JButton("reset");
		b[3]=new JButton("insert");
		iniy=iniy+25;
		for(int i=0;i<4;i++){
		b[i].addActionListener(this);
		b[i].setBounds(inix+30,iniy+50,width,height);
		iniy=iniy+35;
		iframe.add(b[i]);
		}	
	}
	public JInternalFrame getJIF(){
	return iframe;
	}

}
