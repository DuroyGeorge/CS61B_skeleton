public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }
    public static void main(String[]args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] planets=readPlanets(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"./images/starfield.jpg");
        for(Planet i:planets){
            i.draw();
        }
        StdDraw.show();
    }
}
