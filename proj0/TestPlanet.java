public class TestPlanet {
    public static void main(String[] args) {
        checkPlanet();
    }
    public static void checkPlanet(){
        Planet p1=new Planet(0,0,0,0,10,"p1");
        Planet p2=new Planet(3,4,0,0,10,"p2");
        System.out.println(p1.calcForceExertedBy(p2));
        System.out.println(p1.calcForceExertedByX(p2));
        System.out.println(p1.calcForceExertedByY(p2));
    }
}
