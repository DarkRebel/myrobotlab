package org.myrobotlab.service;

import org.myrobotlab.framework.Service;
import org.myrobotlab.logging.Level;
import org.myrobotlab.logging.LoggerFactory;
import org.myrobotlab.logging.Logging;
import org.myrobotlab.logging.LoggingFactory;
import org.myrobotlab.netty.WebSocketServer;
import org.slf4j.Logger;


public class Netty extends Service {

	private static final long serialVersionUID = 1L;

	public final static Logger log = LoggerFactory.getLogger(Netty.class);
	
	WebSocketServer server = new WebSocketServer(3030);
	
	public Netty(String n) {
		super(n);	
	}
	
	public void startService()
	{
		try {
			server.run();
		} catch(Exception e){
			Logging.logException(e);
		}
	}
	
	@Override
	public String getDescription() {
		return "used as a general template";
	}

	public static void main(String[] args) {
		LoggingFactory.getInstance().configure();
		//LoggingFactory.getInstance().setLevel(Level.WARN);

		Netty netty = new Netty("netty");
		netty.startService();			
		
		//Runtime.createAndStart("gui", "GUIService");
		/*
		 * GUIService gui = new GUIService("gui"); gui.startService();
		 * 
		 */
	}


}
