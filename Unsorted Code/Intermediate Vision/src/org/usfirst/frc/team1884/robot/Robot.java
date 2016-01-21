package org.usfirst.frc.team1884.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * This is a demo program showing the use of the NIVision class to do vision processing. 
 * The image is acquired from the USB Webcam, then a circle is overlayed on it. 
 * The NIVision class supplies dozens of methods for different types of processing. 
 * The resulting image can then be sent to the FRC PC Dashboard with setImage()
 * 
 * It also features @author Kaito testing grip files
 */
public class Robot extends SampleRobot {
    int session;
    Image frame;
    
    NetworkTable table;
    
    DigitalInput toggle1;
    
    Relay ledRing;

    Joystick joystick;
    
    public Robot(){
    	table = NetworkTable.getTable("GRIP/myContoursReport");	
    }
    
    public void robotInit() {
    	
    	
    	double[] defaultValue = new double[0];
    	while (true){
    		double[] areas = table.getNumberArray("area", defaultValue);
    		System.out.print("areas: ");
    		for (double area: areas){
    			System.out.print(area + " ");
    			
    		}
    		System.out.println("");
    		Timer.delay(1);
    		
    	}

       // frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        // session = NIVision.IMAQdxOpenCamera("cam0",
       //         NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        // NIVision.IMAQdxConfigureGrab(session);
        
        // ledRing = new Relay(0);
        
        // joystick = new Joystick(0);
        
        //toggle1 = new DigitalInput(0);
    }

    public void operatorControl() {
    	
//    	LEDToggle ledToggle = LEDToggle.off;
    	boolean toggle = false;
    	boolean currButton = false;
    	boolean lastButton = false;
    	
        NIVision.IMAQdxStartAcquisition(session);

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

        while (isOperatorControl() && isEnabled()) {

            NIVision.IMAQdxGrab(session, frame, 1);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
            CameraServer.getInstance().setImage(frame);

            /** robot code here! **/
            
            lastButton = currButton;
            currButton = joystick.getRawButton(1);
            
            if (!lastButton && currButton){
            	toggle = !toggle;
            }
            
//            if(toggle1.get()) {
//            	ledRing.set(edu.wpi.first.wpilibj.Relay.Value.kForward);
//        	} else {
//        		ledRing.set(edu.wpi.first.wpilibj.Relay.Value.kOff);
//        	}
            
            if(toggle) {
            	ledRing.set(edu.wpi.first.wpilibj.Relay.Value.kForward);
            } else {
            	ledRing.set(edu.wpi.first.wpilibj.Relay.Value.kOff);
            }
            
            Timer.delay(0.005);		// wait for a motor update time
        }
        NIVision.IMAQdxStopAcquisition(session);
    }

    public void test() {
    }
    
//    private enum LEDToggle {
//    	on, off;
//    	LEDToggle toggle() {
//    		if(this == LEDToggle.on) {
//    			return LEDToggle.off;
//    		} else {
//    			return LEDToggle.on;
//    		}
//    	}
//    }
}
