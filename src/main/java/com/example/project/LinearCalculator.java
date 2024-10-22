package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below


    private int x1;
    private int x2;
    private int y1;
    private int y2;
    
        public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
    int pH = coord1.indexOf("(");
    int pH2 = coord1.indexOf(",");
    x1= Integer.parseInt(coord1.substring(pH+1,pH2)); // puts all digits in between ( and , as x1
    pH=pH2;
    pH2= coord1.indexOf(")");
    y1= Integer.parseInt(coord1.substring(pH+1,pH2));// puts all digits in between , and ) as y1
    
    pH = coord2.indexOf("(");
    pH2 = coord2.indexOf(",");
    x2= Integer.parseInt(coord2.substring(pH+1,pH2));
    pH=pH2;
    pH2= coord2.indexOf(")");
    y2= Integer.parseInt(coord2.substring(pH+1,pH2));
        }
    
    
    
        public int getX1(){return x1;}
        public int getY1(){return y1;}
        public int getX2(){return x2;}
        public int getY2(){return y2;}
        public void setX1(int newX1){x1=newX1;}
        public void setY1(int newY1){y1=newY1;}
        public void setX2(int newX2){x2=newX2;}
        public void setY2(int newY2){y2=newY2;}
    
    
        public double distance(){
            double dis=Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); // distance formula = square root of (y1-y2)^2 plus (x1-x2)^2
            return roundedToHundredth(dis);
        }

        public double yInt(){
    if(x1==x2){
        return -999.99; // we are only doing linear equations so if the two x values are the same then that means the line is vertical ie. undefined slope and no y intercept
    }
            double yint =  (double)y1-(slope()*x1); // y=mx+b == y-mx=b == y(1or2)-(slope)x(1or2)=b(y int)
    
            return roundedToHundredth(yint);
        }
    
        public double slope(){
            if(x1==x2){
                return -999.99;// we are only doing linear equations so if the two x values are the same then that means the line is vertical ie. undefined slope and no y intercept
            }
           double slope= ((double)(y1-y2)/(x1-x2)); // slope = y/x
            return roundedToHundredth(slope); // roundedToHundredth(slope)
        }
    
        public String equation(){
            if(x1==x2){
                return "undefined";
            }
            if(yInt()==0.0){
                return "y="+slope()+"x";
            }
            if(slope()==0.0){
                return "y="+yInt();
            }
            if(yInt()<0){
                return "y="+slope()+"x"+yInt();
            }
            return "y="+slope()+"x+"+yInt(); // y=mx+b
        }
    
        public double roundedToHundredth(double x){
            x *=100; // ex: 123.32424*100 = 12332.424 : 754.345165*100 = 75434.5165
            if(x<0){
                x-=0.5; // for negatives
            }
    if (x>=0){
            x +=0.5; //ex: 12332.424 +0.5 = 12332.924 : 75434.5165+0.5 = 75435.0165
    }
            int xx = (int) x; //ex: 12332 : 75435
            x = (double)xx/100; //ex: 12332=12332.0/100= 123.32 : 75435=75435.0/100= 754.35
            return x;
        }
    

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")"; 
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " +yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n"+ findSymmetry();
        str += "\n"+ Midpoint();
 
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if((x1/x2)==-1 && (y1/y2)==-1){ // symmetrical with the origin are opposite in signs
            return "Symmetric about the origin";
        }
        if (x1/x2 ==-1){
            return "Symmetric about the y-axis"; //if the x coords are equal in distance, they are symmetrical when you fold y-axis
        }
        else{
            if(y1/y2==-1){
                return "Symmetric about the x-axis";
            }
            else{
                return "No symmetry";
            }
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        // midpoint is the average between two points
        // formula = (((x1+x2)/2),((y1+y2)/2))
        double xPo= (double) (x1+x2)/2;
        double yPo= (double)(y1+y2)/2;
        return "The midpoint of this line is: ("+xPo+","+yPo+")"; 
    }

}



