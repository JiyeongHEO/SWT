package com.example.swt.widgets;


import java.text.DecimalFormat;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Text;


public class cal {
	static Display display;
	static Shell shell;
	static Text txtresult;
	static Button btnnum[];
	static Button btnSum, btnMinus, btnMulti, btnDiv,btnEqual, btnClear,btnDot;
	static String input="";
	static double result=0;
	static String calc;
	static double tmp;
	
	
	 public static void main(String[] args) {
	        
		 display = new Display();
		 shell = new Shell(display,SWT.CLOSE | SWT.TITLE);
		 shell.setBounds(0,0,300,400);

		 shell.setText("Calculator");
		 shell.setLayout(new FillLayout());
		 
			 
		 createview(shell);
		 actionbutton();
		
	    

		 shell.open();
	 
		 // run the event loop as long as the window is open
		 while (!shell.isDisposed()) {
		     // read the next OS event queue and transfer it to a SWT event
		     if (!display.readAndDispatch())
		      {
		     // if there are currently no other OS event to process
		     // sleep until the next OS event is available
		         display.sleep();
		      }
		 }

		 // disposes all associated windows and their components
		 display.dispose(); 
	 
	 }
	 
	 
	 
	 private static void createview(Shell shell) {

		 GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		 Composite composite = new Composite(shell, SWT.BORDER);

		 composite.setLayout(new GridLayout(4, false));
		 				 
		 txtresult = new Text(composite, SWT.BORDER|SWT.RIGHT);
	     gridData = new GridData(gridData.FILL_BOTH);
	     gridData.horizontalSpan=4;
	     txtresult.setLayoutData(gridData);
	     txtresult.setFont(new Font(display,"Arial",12,SWT.None));
	    		
	               
	        btnnum =new Button[10]; 
	        GridData gData = new GridData(GridData.FILL_BOTH);
	        GridData gDataH = new GridData(GridData.FILL_BOTH);
	        gDataH.horizontalSpan=2;
	        GridData gDataV = new GridData(GridData.FILL_BOTH);
	        gDataV.verticalSpan=2;
	        
	        
	            
	        btnClear        = new Button(composite, SWT.PUSH);
	        btnClear        .setLayoutData(gDataH);
	        btnClear        .setText("Clear");
	        
	        btnDiv          = new Button(composite, SWT.PUSH);
	        btnDiv          .setLayoutData(gData);
	        btnDiv          .setText("/");
	        
	        
	        btnMulti        = new Button(composite, SWT.PUSH);
	        btnMulti        .setLayoutData(gData);
	        btnMulti        .setText("x");
	        
	        
	        btnnum[7] = new Button(composite, SWT.PUSH);
	        btnnum[7].setLayoutData(gData);
	        btnnum[7]    .setText("7");
	        
	        
	        btnnum[8] = new Button(composite, SWT.PUSH);
	        btnnum[8].setLayoutData(gData);
	        btnnum[8]    .setText("8");
		

	        btnnum[9] = new Button(composite, SWT.PUSH);
	        btnnum[9].setLayoutData(gData);
	        btnnum[9]    .setText("9");

	        btnMinus        = new Button(composite, SWT.PUSH);
	        btnMinus        .setLayoutData(gData);
	        btnMinus        .setText("-");
	        
	        btnnum[4] = new Button(composite, SWT.PUSH);
	        btnnum[4].setLayoutData(gData);
	        btnnum[4]    .setText("4");
	        btnnum[5] = new Button(composite, SWT.PUSH);
	        btnnum[5].setLayoutData(gData);
	        btnnum[5]    .setText("5");
	        btnnum[6] = new Button(composite, SWT.PUSH);
	        btnnum[6].setLayoutData(gData);
	        btnnum[6]    .setText("6");
		 
	        btnSum          = new Button(composite, SWT.PUSH);
	        btnSum          .setLayoutData(gData);
	        btnSum          .setText("+");
	        
	        btnnum[1] = new Button(composite, SWT.PUSH);
	        btnnum[1].setLayoutData(gData);
	        btnnum[1]    .setText("1");
	        btnnum[2] = new Button(composite, SWT.PUSH);
	        btnnum[2].setLayoutData(gData);
	        btnnum[2]    .setText("2");
	        btnnum[3] = new Button(composite, SWT.PUSH);
	        btnnum[3].setLayoutData(gData);
	        btnnum[3]    .setText("3");
	        
	        
	        btnEqual        = new Button(composite, SWT.PUSH);
	        btnEqual        .setLayoutData(gDataV);
	        btnEqual        .setText("=");

	        btnnum[0] = new Button(composite, SWT.PUSH);
	        btnnum[0].setLayoutData(gDataH);
	        btnnum[0]    .setText("0");
		 
	        btnDot          = new Button(composite, SWT.PUSH);
	        btnDot          .setLayoutData(gData);
	        btnDot          .setText(".");          
	        
	 }
	 
	 

	 
	 
	 

	 
	 private static void actionbutton() {
		
		 DecimalFormat df= new DecimalFormat("#.###");
		 
			for(int i=0; i<btnnum.length; i++) {
				final int num=i;
				btnnum[i].addListener(SWT.Selection, new Listener() {
					
					@Override
					public void handleEvent(Event event) {
						// TODO Auto-generated method stub
						input+= num;
						tmp = Double.parseDouble(input);						
						txtresult.setText(df.format(tmp));
					}
				});
			}
			
			btnDot.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
					input += ".";
					tmp = Double.parseDouble(input);
					
					txtresult.setText(df.format(tmp));
				}
			});
			
			
			
			btnClear.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
					input="";
					tmp=0;
					result=0;
					txtresult.setText("0");
				}
			});
			
		
		
			
			btnSum.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
					result+= Double.parseDouble(input);
					input="";
					calc="+";
					
					txtresult.setText(input);
				}
			});
			
			
			btnDiv.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
					result+= Double.parseDouble(input);
					input="";
					calc="/";
					txtresult.setText(input);
				}
			});


			btnMinus.addListener(SWT.Selection, new Listener() {
	
				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
					result+= Double.parseDouble(input);
					input="";
					calc="-";
					txtresult.setText(input);
				}
			});

			
			btnMulti.addListener(SWT.Selection, new Listener() {
					@Override
					public void handleEvent(Event event) {
						// TODO Auto-generated method stub
						result+=Double.parseDouble(input);
						input="";
						calc="*";
						txtresult.setText(input);
					}
				});


	
	

			btnEqual.addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
					if(calc=="+") {
						result+=Double.parseDouble(input);
						input="0";
						}
					else if(calc=="/") {
						result= (result/Double.parseDouble(input));
						input="0";
					}
					
					
					else if(calc=="-") {
						result-=Double.parseDouble(input);
						input="0";
					}
					
					else if(calc=="*") {
						result= result*Double.parseDouble(input);
						input="0";
					}
					
					txtresult.setText(df.format(result));
				}
			});
	 }
	 
	 

		 		
		

}
