public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP,double yP,double xV,double yV, double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx=p.xxPos-xxPos;
        double dy=p.yyPos-yyPos;
        return Math.sqrt(dx*dx+dy*dy);
    }
    public double calcForceExertedBy(Planet p){
        final double G=6.67e-11;
        double r=calcDistance(p);
        return (mass*p.mass/(r*r))*G;
    }
    public double calcForceExertedByX(Planet p){
        double dx=p.xxPos-xxPos;
        double r=calcDistance(p);
        double f=calcForceExertedBy(p);
        return f*dx/r;
    }
    public double calcForceExertedByY(Planet p){
        double dy=p.yyPos-yyPos;
        double r=calcDistance(p);
        double f=calcForceExertedBy(p);
        return f*dy/r;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netForceX=0;
        for(Planet p:allPlanets){
            if(!this.equals(p)){
                netForceX+=calcForceExertedByX(p);
            }
        }
        return netForceX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netForceY=0;
        for(Planet p:allPlanets){
            if(!this.equals(p)){
                netForceY+=calcForceExertedByY(p);
            }
        }
        return netForceY;
    }
    public void update(double dt,double fX,double fY){
        double aX=fX/mass;
        double aY=fY/mass;
        xxVel+=aX*dt;
        yyVel+=aY*dt;
        xxPos+=xxVel*dt;
        yyPos+=yyVel*dt;
    }
}
