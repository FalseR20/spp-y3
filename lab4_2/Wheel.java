package lab4_2;

public class Wheel {
    private boolean is_broken = false;

    public boolean is_pierced() {
        return is_broken;
    }

    public void pierce() {
        is_broken = true;
        System.out.println("shhhhhhhhhhh");
    }

    public void fix() {
        is_broken = false;
    }

}
