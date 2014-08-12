package eecs40.iPacMan;

// Simple tunnel class 
public class Tunnel {
	
	int t1, t2; 
	boolean left; 
	
	public Tunnel(int t1, int t2, boolean left) { 
		this.t1 = t1; 
		this.t2 = t2;
		this.left = left; 
	}
	
	public boolean onSpecialTile(int a1, int a2) { 
		return (a1 == t1 && a2 == t2); 
	}
	
	public boolean LeftTunnel() { 
		return left; 
	}

}
