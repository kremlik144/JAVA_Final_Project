public class Laptop 
{
    private String producer;
    private int ramPc;
    private int hardDiskCapacity;
    private String ocPc;
    private String color;

    public Laptop(String producer, int ramPc, int hardDiskCapacity, String ocPc, String color) {
        this.producer = producer;
        this.ramPc = ramPc;
        this.hardDiskCapacity = hardDiskCapacity;
        this.ocPc = ocPc;
        this.color = color;
    }

    public String fullInfo() {
        return "Producer - " + producer + ", RAM - " + ramPc + " gb, Hard Disk Capacity - " + hardDiskCapacity
                + " gb, OC - " + ocPc + ", Color - " + color;
    }

    public String getProducer() {
        return producer;
    }

    public int getRamPc() {
        return ramPc;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public String getOcPc() {
        return ocPc;
    }

    public String getColor() {
        return color;
    }

    public boolean equalsStr(String value1, String value2)
    {
        if(value1.equals(value2)) return true;  
        else return false;
    }

    public boolean equalsInt(int value1, String value2)
    {
        int value = Integer.parseInt(value2);
        if(value1 == value) return true;  
        else return false;
    }

    @Override
    public String toString() {
        return "[producer=" + producer + ", ramPc=" + ramPc + ", hardDiskCapacity=" + hardDiskCapacity
                + ", ocPc=" + ocPc + ", color=" + color + "]";
    }
   
}
