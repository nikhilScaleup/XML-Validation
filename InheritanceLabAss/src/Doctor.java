public class Doctor extends HospitalEmployee {
    protected String specialty;

    public Doctor(String name, int number, String specialty) {
        super(name, number);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    

    @Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		System.out.println(super.name +" is a(n) "+ this.specialty +" doctor.");
	}

	@Override
    public String toString() {
        return name + "  " + number +"  "  + specialty;
    }
}