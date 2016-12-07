package com.mygdx.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Serial {
	private String dev;
	private double value;
	private double value2;

	public Serial(String dev) throws Exception {

        this.dev = dev;

        System.out.println("Monitoring serial stream on " + dev);

    }

	public void connect() throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(dev);
        if (portIdentifier.isCurrentlyOwned())
        {
            System.out.println( "Error: Port is currently in use" );
        }
        else
        {
            int timeout = 2000;
            CommPort commPort = portIdentifier.open("serial",timeout);

            if (commPort instanceof SerialPort)
            {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE );

                BufferedReader reader = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

                String line = reader.readLine();
                value = Double.parseDouble(line.split(" ")[1]);
                value2 = Double.parseDouble(line.split(" ")[2]);
                System.out.println(value);
                System.out.println(value2);
                System.out.println("-------------");
            }
            
            commPort.close();
        }
    }

	public boolean getValue() {
		
		if(value > 0) {
			return true;
		}
		
		return false;
	}
}