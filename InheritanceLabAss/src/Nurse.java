public class Nurse extends HospitalEmployee {
    private int numOfPatients;

    public Nurse(String name, int number, int numOfPatients) {
        super(name, number);
        this.numOfPatients = numOfPatients;
    }

    public int getNumOfPatients() {
        return numOfPatients;
    }

    public void setNumOfPatients(int numOfPatients) {
        this.numOfPatients = numOfPatients;
    }
    

    @Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		System.out.println(super.name +" is a nurse with "+ this.numOfPatients+" patients.");
	}

	@Override
    public String toString() {
        return  name + "  " + number +"  has " + numOfPatients +" patients.";
    }
}


