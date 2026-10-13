package adapter;


public class UsbToCarAdapter extends CigaretteLighterReceptacle implements Usb{

	public int getPower(){
		return getEnergy();
	}

}
