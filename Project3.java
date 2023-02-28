import java.io.*;
import java.util.*;

abstract class Shape extends Object{

        protected String Name;

        public String getName() {
        return this.Name; }

        abstract double getArea();
}

class Rectangle extends Shape{

        protected double Base, Height;

        Rectangle(){

                this.Name = "NoName";
                this.Base = 0;
                this.Height = 0;

        }

	Rectangle( String InitialName, double InitialBase, double InitialHeight ){

                this.Name = InitialName;
                this.Base = InitialBase;
                this.Height = InitialHeight;

        }

	@Override
        public double getArea(){
                return this.Base * this.Height;
        }
}

class Triangle extends Shape{

        private double Base, Height;

        Triangle(){

                this.Name = "NoName";
                this.Base = 0;
                this.Height = 0;

        }

        Triangle( String InitialName, double InitialBase, double InitialHeight ){

                this.Name = InitialName;
                this.Base = InitialBase;
                this.Height = InitialHeight;
        }

        @Override
        public double getArea(){
                return (this.Base * this.Height) * 0.5;
        }
}

class Circle extends Shape{

        private double Radius;

        Circle(){

                this.Name = "NoName";
                this.Radius = 0;
        }

	Circle( String InitialName, double InitialRadius ){

                this.Name = InitialName;
                this.Radius = InitialRadius;
        }

        @Override
        public double getArea(){
                return Math.PI * this.Radius * this.Radius;
        }
}

class Square extends Rectangle{

        Square(){

                this.Name = "NoName";
                this.Base = 0;
                this.Height = 0;

        }

        Square( String InitialName, double InitialBase ){

                this.Name = InitialName;
                this.Base = InitialBase;
                this.Height = InitialBase;
        }
}

public class Project3{

	public static double getCumulativeArea(ArrayList<Shape> shapeList) {

		double totalSum = 0;

		for (int i = 0; i < shapeList.size(); ++i) {

			totalSum += shapeList.get(i).getArea();

		}
		return totalSum;
	}

	public static String getLargestShape(ArrayList<Shape> shapeList) {

		double largest = 0;
		String nameLargest = "";

		for (int i = 0; i < shapeList.size(); ++i) {

			if ( shapeList.get(i).getArea() > largest ) {

				largest = shapeList.get(i).getArea();
				nameLargest = shapeList.get(i).getName();

			}

                }

		if ( nameLargest.equals("") == true ) {

			String noShapes = "There are no shapes";
			return noShapes;

		}


		return nameLargest;

	}



	public static void main(String[] args) {

	StringTokenizer st;
	String name1;
	double param1;
	double param2;

	ArrayList<Shape> shapeList = new ArrayList<Shape>();

	if ( args.length != 1 ) {

		System.out.println("Usage: java Project3 <filename>");
		System.exit(0);

	}

	DataInputStream in = null;
	try {
		FileInputStream fstream = new FileInputStream( args[0] );
		in = new DataInputStream( fstream );
		BufferedReader br = new BufferedReader( new InputStreamReader(in));
		String strLine;


		while (( strLine = br.readLine()) != null ) {

		st = new StringTokenizer( strLine, ", " );
		String firstTok = st.nextToken();

			while ( st.hasMoreTokens() ) {

				if ( firstTok.equals("Rectangle") == true ) {

					try {

					name1 = st.nextToken();
					param1 = Double.parseDouble( st.nextToken() );
					param2 = Double.parseDouble( st.nextToken() );

					}

					catch (NoSuchElementException nsee) {

						break;

					}


					if ( param1 < 0 ) {
						break;
					}

					if ( param2 < 0 ) {
						break;
					}

					Rectangle rec;
					rec = new Rectangle( name1, param1, param2 );

					shapeList.add(rec);

				}

				if ( firstTok.equals("Triangle") == true ) {

					try {

					name1 = st.nextToken();
					param1 = Double.parseDouble( st.nextToken() );
					param2 = Double.parseDouble( st.nextToken() );

					}

					catch (NoSuchElementException nsee) {

						break;

					}

					if ( param1 < 0 ) {
						break;
					}

					if ( param2 < 0 ) {
						break;
					}

					Triangle tri;
					tri = new Triangle( name1, param1, param2 );

					shapeList.add(tri);

				}

				if ( firstTok.equals("Circle") == true ) {

					try {

					name1 = st.nextToken();
					param1 = Double.parseDouble( st.nextToken() );

					}

					catch (NoSuchElementException nsee) {

						break;

					}

					if ( param1 < 0 ) {
						break;
					}

					Circle circ;
					circ = new Circle( name1, param1 );

					shapeList.add(circ);

				}

				if ( firstTok.equals("Square") == true ) {

					try {

					name1 = st.nextToken();
					param1 = Double.parseDouble( st.nextToken() );

					}

					catch (NoSuchElementException nsee) {

						break;

					}

					if ( param1 < 0 ) {
						break;
					}

					Square sqr;
					sqr = new Square( name1, param1);

					shapeList.add(sqr);

				}

				else {
					break;
				}

			}
		}
	}

	catch (SecurityException se) {
		System.out.println("The file " + args[0] + " was found, but you do not have permission to read it");
		}

	catch (FileNotFoundException fnf) {
		System.out.println("The file " + args[0] + " was not found");
		}

	catch (Exception e) {
		System.out.println("Exception Reading file " + args[0] );
		System.out.println( e.toString() );
		}

	System.out.print("Cumulative Area: ");
	System.out.println(String.format("%.2f", getCumulativeArea( shapeList )));
	System.out.println("Largest Shape: " + getLargestShape( shapeList ));


	}
}
