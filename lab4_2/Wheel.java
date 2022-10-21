package lab4_2;

public class Wheel {
    private boolean is_broken = false;

    public boolean is_pierced() {
        return is_broken;
    }

    public void pierce() {
        is_broken = true;
        System.out.println("shhhhhhhhhhh, wheel was pierced");
    }

    public void fix() {
        System.out.println("Wheel was fixed");
        is_broken = false;
    }

}
