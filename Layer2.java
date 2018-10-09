import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Layer2 extends Layer1{
public static int x=10,y=0,width=150,height=30;
public JTextField[] t=null;
public JLabel j[]=new JLabel[40];
public JLabel msg=new JLabel("");
public static String[] unique=new String[20];
public String label="",sql=new String();
public ArrayList<String> ukey=new ArrayList<String>();
public String[] pktable_name=new String[15];
public String[] pkcolumn_name=new String[15];
public String[] fkcolumn_name=new String[15];
public int fkey=0,jc=0,inix=0,iniy=0;
public JButton b=new JButton("test_it");
public ResultSet r2=null;
public ResultSetMetaData m2=null;
public JComboBox[] p=new JComboBox[15];
	Layer2(String dbb,String tbll){
		db=dbb;tbl=tbll;
		connect(db,tbl);
		getUniqueKey();
		setFKeys();
		getLabelName();
		System.out.println(empty(t));
	}
	public void getUniqueKey(){int x=0;String temp=new String("");
	sql=new String("select * from information_schema.TABLE_CONSTRAINTS where table_name='"+tbl+"'");
	try{
		rs=stmt.executeQuery(sql);
		m=rs.getMetaData();
	while(rs.next()){
		for(int i=1;i<=m.getColumnCount();i++){
			
		if(m.getColumnName(i).equals("CONSTRAINT_NAME")){
			temp=rs.getString(i);
		}
		if(m.getColumnName(i).equals("CONSTRAINT_TYPE")){
			if(rs.getString(i).equals("UNIQUE")){
				ukey.add(temp);
				}
			}
		}
		for(int i=0;i<ukey.size();i++){
			for(int j=0;j<fkey;j++){
			if(ukey.get(i).equals(fkcolumn_name[j])){
				ukey.set(i,"");
				}
			}
		}
	}
	}catch(SQLException sd){
		sd.printStackTrace();
		}
	}
	public void getLabelName(){int xx=0;x=10;y=0;
	String[] l=null;ResultSet r=null;ResultSetMetaData rm=null;String[] ss=null;String s=new String("");
	try{
		rs=stmt.executeQuery("select * from "+tbl+"");
		m=rs.getMetaData();
		dm=con.getMetaData();
		t=new JTextField[m.getColumnCount()-fkey];
		
	for(int i=2;i<=m.getColumnCount();i++){
		label=label.concat(m.getColumnName(i)+",");
	}
		label=label.substring(0,label.length()-1);
		l=label.split(",");
	for(int i=0;i<l.length;i++){
			ss=l[i].split("_");
		for(int k=0;k<ss.length;k++){
			s=s.concat(ss[k]+" ");
		}
		j[i]=new JLabel(s);	
		j[i].setBounds(x,y,width,height);
		iframe.add(j[i]);
		y=y+35;
		s="";
		if(y>900){
		y=0;
		x=450;
		iframe.setSize(1200,1200);
		}
		
	}msg.setBounds(x,y+35,width,height);
	iframe.add(msg);y=y+35;
		
			int tf=0;
		rs=stmt.executeQuery("select * from "+tbl+"");
		m=rs.getMetaData();x=0;y=0;
		for(int i=2;i<=m.getColumnCount();i++){
			if(m.getColumnName(i).equals(fkcolumn_name[xx])){
				
				p[jc]=new JComboBox<String>(getUValues(pkcolumn_name[xx],pktable_name[xx]));
				p[jc].setBounds(x+190,y,width+60,height);
				iframe.add(p[jc]);
				xx++;jc++;
			}else{	//System.out.println(tf);
				t[tf]=new JTextField(150);
				t[tf].setBounds(x+190,y,width+60,height);
				iframe.add(t[tf]);
				tf++;
				}
			y=y+35;
			if(y>900){
	                y=0;
        	        x=450;}
		
			}
	inix=x;
	iniy=y;
	}catch(SQLException s21){
		s21.printStackTrace();
		}
		System.out.println(label);
	}
	public void setFKeys(){
	try{
	ResultSet rr=null;ResultSetMetaData mm=null;
	rr=dm.getImportedKeys(con.getCatalog(),dm.getUserName(),tbl);
	mm=rr.getMetaData();int x=0;
	
	while(rr.next()){
		for(int i=1;i<=mm.getColumnCount();i++){
			if(mm.getColumnName(i).equals("PKTABLE_NAME")){
				pktable_name[x]=new String(rr.getString(i));
			}else if(mm.getColumnName(i).equals("PKCOLUMN_NAME")){
				pkcolumn_name[x]=new String(rr.getString(i));
			}else if(mm.getColumnName(i).equals("FKTABLE_NAME")){
			}else if(mm.getColumnName(i).equals("FKCOLUMN_NAME")){
				fkcolumn_name[x]=new String(rr.getString(i));
		        }
		}x++;
	fkey++;		}int xp=0;Integer[] op=new Integer[fkey];
		rs=stmt.executeQuery("select * from "+tbl);
		m=rs.getMetaData();rs.next();
		for(int j=0;j<fkey;j++){
		for(int i=2;i<=m.getColumnCount();i++){
			if(fkcolumn_name[j].equals(m.getColumnName(i))){
				op[xp]=i;
				xp++;
			}
		}}
		xp=0;System.out.println("yoo-----");
		String tm=null;int oi=0;
		for(int i=0;i<fkey;i++){
			for(int j=0;j<fkey;j++){
				if(op[i]<op[j]){
					tm=fkcolumn_name[j];
					fkcolumn_name[j]=fkcolumn_name[i];
					fkcolumn_name[i]=tm;
					oi=op[i];
					op[i]=op[j];
					op[j]=oi;
					tm=pktable_name[j];
					pktable_name[j]=pktable_name[i];
					pktable_name[i]=tm;
	
					tm=pkcolumn_name[j];
					pkcolumn_name[j]=pkcolumn_name[i];
					pkcolumn_name[i]=tm;
					}
				}
			
		}
		for(int i=0;i<fkey;i++){
		System.out.println(fkcolumn_name[i]);
		System.out.println(pkcolumn_name[i]);
		System.out.println(pktable_name[i]);
		}
		for(int i=0;i<fkey;i++){
		System.out.println(pktable_name[i]);
		System.out.println(pkcolumn_name[i]);
		System.out.println(fkcolumn_name[i]);
		
		}
	}catch(SQLException mnn){
		mnn.printStackTrace();
		}
	}
	public String[] getUValues(String pc,String pt){
	String[]n=null;int xc=0;int yc=0;
	try{	
		r2=stmt.executeQuery("select "+pc+" from "+pt);
		m2=r2.getMetaData();
		while(r2.next()){
		yc++;
		}
		n=new String[yc];
		r2=stmt.executeQuery("select "+pc+" from "+pt);
		m2=r2.getMetaData();
		while(r2.next()){
		for(int i=1;i<=m2.getColumnCount();i++){
		if(m2.getColumnName(i).equals(pc)){
		n[xc]=new String(r2.getString(i));
		xc++; 
		}
		}
		}
	}catch(SQLException sdd){
		sdd.printStackTrace();
		}
	return n;
	}


	public String getIVal(String s){
	String ss=new String("");int l=0,mm=0,k=0;
	String h=new String("");
	try{
	rs=stmt.executeQuery("select * from "+tbl);
	m=rs.getMetaData();
	rs.next();
	for(int i=1;i<=m.getColumnCount();i++){
		if(s.equals(m.getColumnName(i))){
			l=i;
			}
		}
	for(int i=0;i<fkey;i++){
		if(m.getColumnName(l).equals(fkcolumn_name[i])){
			h=new String("JComboBox");
			mm=i;
			}
		}int nn=1;
	if(h.equals("JComboBox")){
	//	ss=new String(p[mm].getSelectedItem().toString());
		}else{h=new String("JTextField");
			for(int i=1;i<=l;i++){nn=1;
				for(int j=0;j<fkey;j++){
				if(m.getColumnName(i).equals(fkcolumn_name[j])){
					nn=0;
					}
				}
				if(nn==1){
				k++;
				}	
			}
		}
	
	if(h.equals("JTextField")){
	ss=new String(t[k-2].getText());
		}
	
	}catch(SQLException sdf){
		sdf.printStackTrace();
		}
	//System.out.println(ss);
	return ss;
	}
	public String getKey(ArrayList<String> ky){
	String k=new String();
		for(int i=0;i<ky.size();i++){
			for(int j=0;j<fkcolumn_name.length;j++){
				if(ky.get(i).equals(fkcolumn_name[j])){
				ky.set(i,"");
				}else{
				k=new String(ky.get(i));
				break;
				}
				if(!k.isEmpty()){
					break;
					}
				}
			}
		return k;
		}	

	public void insert(){int x=0;int u=0;int pp=0;
	sql=new String("insert into "+tbl+"(");
	String ssl=null;
	ssl=getKey(ukey);
	//System.out.println(search(ssl,getIVal(ssl)));
	
	if(search(ssl,getIVal(ssl))){
	System.out.println("found");
	msg.setText("found");
	}else{
	System.out.println("not found");
	try{
		rs=stmt.executeQuery("select * from "+tbl);
		m=rs.getMetaData();
	for(int i=2;i<=m.getColumnCount();i++){
			sql=sql.concat(m.getColumnName(i)+",");
		}
		sql=sql.substring(0,sql.length()-1);
		sql=sql.concat(") values(");
	for(int i=2;i<=m.getColumnCount();i++){	
	if(m.getColumnTypeName(i).equals("INT")||m.getColumnTypeName(i).equals("TINYINT")){
		if(m.getColumnName(i).equals(fkcolumn_name[x])){
			sql=sql.concat("(select * from (select "+pkcolumn_name[x]+" from "+pktable_name[x]+" where "+pkcolumn_name[x]+"="+p[x].getSelectedItem().toString()+")as x),");
			x++;	
		}else{
		sql=sql.concat(t[u].getText()+",");	
	
		}
		}else{
			sql=sql.concat("'"+t[u].getText()+"',");
			u++;
		}	
			}
			sql=sql.substring(0,sql.length()-1);
			sql=sql.concat(")");
			System.out.println(sql);
			pp=stmt.executeUpdate(sql);
		if(pp==1){
			msg.setText("successfull");
		}else{
			msg.setText("unsuccessfull");
			}	
		}catch(SQLException s2){
			s2.printStackTrace();
			}	
		}
	}

	public void update(){int xz=0,yz=0;String ssl=null;int pp=0;String ssp=null;
		sql=new String("update IGNORE "+tbl+" set ");
	ssl=getKey(ukey);
	
	if(checkAll(ssl,search(ssl,getIVal(ssl)))){
	try{
		rs=stmt.executeQuery("select * from "+tbl);
		m=rs.getMetaData();
		for(int i=2;i<=m.getColumnCount();i++){
			sql=sql.concat(m.getColumnName(i)+"=");
			if(m.getColumnTypeName(i).equals("INT")||m.getColumnTypeName(i).equals("TINYINT")){
				if(m.getColumnName(i).equals(fkcolumn_name[xz])){
					sql=sql.concat(p[xz].getSelectedItem().toString()+",");
					xz++;
					}else{
					sql=sql.concat(t[yz].getText()+",");yz++;
						}
				}else{
					sql=sql.concat("'"+t[yz].getText()+"',");yz++;
					}
			}
		sql=sql.substring(0,sql.length()-1);
	System.out.println(sql);
	pp=stmt.executeUpdate(sql);
	//System.out.println(pp);
	if(pp==0){
		msg.setText("unsuccessfull");
		}else{
		msg.setText("successfull");
		}
	}catch(SQLException sf){
		sf.printStackTrace();
			}
		}else{
			msg.setText("does not exist");
			}
	}
	public boolean checkAll(String s,boolean bool){
	boolean l=false;
		if(bool==false){
		l=checkG(s);
		}else if(bool==true){
		l=bool;
		}

	return l;		
	}
	public boolean checkG(String s){int x=0;int y=0;boolean bool=false;
		String sq=new String("select * from "+tbl+" where ");
		try{rs=stmt.executeQuery("select * from "+tbl);
			m=rs.getMetaData();
			rs.next();
			for(int i=2;i<=m.getColumnCount();i++){
				if(m.getColumnName(i).equals(s)){
				y++;
				}else{	if(m.getColumnName(i).equals(fkcolumn_name[x])){}else{
					sq=sq.concat(m.getColumnName(i)+"=");}
					if(m.getColumnTypeName(i).equals("INT")||m.getColumnTypeName(i).equals("TINYINT")){
						if(m.getColumnName(i).equals(fkcolumn_name[x])){
						//sq=sq.concat(p[x].getSelectedItem().toString()+",");
						x++;
						}else{
						sq=sq.concat(t[y].getText()+" AND ");y++;
						}
				}else{
					sq=sq.concat("'"+t[y].getText()+"' AND ");y++;
					}
					}
	
			
			}
		sq=sq.substring(0,sq.length()-4);
		System.out.println(sq);
		rs=stmt.executeQuery(sq);
		if(rs.next()){
		bool=true;
		}
		}catch(SQLException kl){
			kl.printStackTrace();
		}
		return bool;
	}
}
