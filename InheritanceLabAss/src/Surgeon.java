public class Surgeon extends Doctor {
    private boolean operating;

    public Surgeon(String name, int number, String specialty, boolean operating) {
        super(name, number, specialty);
        this.operating = operating;
    }

    public boolean isOperating() {
        return operating;
    }

    public void setOperating(boolean operating) {
        this.operating = operating;
    }
    
    
    @Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		if(this.operating) {
			System.out.println(super.name+" is operating now.");
		}else {
			System.out.println(super.name+" is not operating now.");
		}
	}

	@Override
    public String toString() {
        return name + "  " + number +"  "+ specialty + "   Operating:" + operating ;
    }
}
