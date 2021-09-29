import java.util.ArrayList;
import java.util.Random;
import java.lang.Math.*;

enum ShapeColor
{
	Blue,
	Yellow,
	Red,
	Green,
	White
	
};
 // Interface -> Shape 
interface Shape
{
	public double area();
	
} 
// Abstract Class -> TwoD 
abstract class TwoD implements Shape
{

		protected ShapeColor sc;
		protected int a;
		protected int b;
		protected int c;
		protected int d;
		
	 // Constructor (s) 
	public TwoD()
	{
		sc = ShapeColor.Blue;
		a = 1;
		b = 1;
		c = 1;
		d = 1;
		
	}
	public TwoD (ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
		
	}
	public TwoD (ShapeColor sc, int a , int b)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
						
	}
	public TwoD (ShapeColor sc, int a , int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
				
	}
	public TwoD (ShapeColor sc, int a , int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
				
	}
	// Copy Constructor
	public TwoD ( TwoD td)
	{
		this(td.sc,td.a,td.b,td.c,td.d );
		
	}
	// Accessor Methods 
	public int getA()
	{
		return a;
			
	}
	public int getB()
	{
		return b;
		
	}
	public int getC()
	{
		return c;
		
	}
	public int getD()
	{
		return d;
		
	}
	public ShapeColor getShapeColor()
	{
		return sc;
		
		
	}
	public void set (ShapeColor sc, int a, int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		
	}
	@Override
	public String toString()
	{
		return String.format("");
							 
		
	} 
}
// Sub-Class of TwoD 
class Circle extends TwoD
{
	public Circle()
	{
		sc = ShapeColor.Blue;
		
	}
	public Circle(ShapeColor sc, int radius)
	{
		super(sc,radius);
		
	} 
		// Copy Constructor 
	public Circle (Circle c)
	{
		this(c.sc,c.a);
	}
	
	private double computeArea ()
	{
		return Math.PI * a * a;
	}
	@Override
	public double area ()
	{
		return this.computeArea();
	}
	public int getRadius()
	{
		return a;
		
	}
	public void set(ShapeColor sc, int radius)
	{
		this.sc = sc;
		this.a = a;
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%sCircle (2D (%s, %d))",
						super.toString (), sc, a);
		
	}
	
}
 // Sub Class of TwoD  
class Triangle extends TwoD 
{		
	public Triangle() 
	{	
		sc = ShapeColor.Blue;
		a = 1;
		b = 1;
		c = 1;
		
	}
	public Triangle (ShapeColor sc, int a, int b, int c)
	{
		super (sc, a , b, c);
	}
	public Triangle ( Triangle t)
	{
		this(t.sc,t.a,t.b,t.c);
		
	}
	
	private double computeArea ()
	{
		double s = (a + b + c)/2.0;
		return Math.sqrt(s *(s - a) *(s - b) *(s - c));
	}
	@Override
	public double area()
	{
		
		return this.computeArea();
			
	}
	public int getA()
	{
		return a;
	}
	public int getB()
	{
		return b;
		
	}
	public int getC()
	{
		return c;
	}
	public void set(ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	@Override
	public String toString()
	{
		return String.format("%sTriangle (2D (%s, %d,%d,%d))",
								super.toString (), sc, a,b,c);
	}
		
}

class Rectangle extends TwoD
{	
	public Rectangle()
	{
		sc = ShapeColor.Blue;
		a = 1;
		b = 1;
		
	}
	public Rectangle (ShapeColor sc, int length, int width)
	{
		super(sc,length, width);
		
	}
	public Rectangle ( Rectangle r)
	{
		this(r.sc, r.a, r.b);
		
	}
	
	private double computeArea ()
	{
		return a * b;
	}
	@Override
	public double area()
	{
		return this.computeArea();
		
	}
	public int getLength()
	{
		return a;
		
	}
	public int getWidth()
	{
		return b;
		
	}
	public void set ( ShapeColor sc, int length, int width)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		
	}
	@Override
	public String toString()
	{
		return String.format("%sRectangle (2D (%s, %d,%d))",
							super.toString (), sc, a,b);
		
	}
	
}
class Trapezoid extends TwoD
{
	private int h;
	public Trapezoid ()
	{
		sc = ShapeColor.Blue;
		a = 1;
		b = 1;
		c = 1;
		d = 1;
		h = 1;
		
	}
	public Trapezoid ( ShapeColor sc, int a, int b, int c, int d, int h )
	{
		super(sc,a,b,c,d);
		this.h = h;
		
	}
	public int getA()
	{
		return a;
		
	}
	public int getB()
	{
		return b;
		
	}
	public int getC()
	{
		return c;
		
	}
	public int getD()
	{
		return d;
		
	}
	public int getHeight()
	{
		return h;
		
	}
	public void setHeight(int h)
	{
		this.h = h;
	}
	
	private double computeArea ()
	{
		return ((a+b)*h)/2 ; 
	}
	@Override
	public double area()
	{	
		return this.computeArea();	
	}
	public void set(ShapeColor sc, int a, int b, int c,int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		
	}
	@Override
	public String toString()
	{
		return String.format("%sTrapezoid (2D (%s, %d,%d,%d,%d),%d)",
							 super.toString (), sc, a,b,c,d,h);
		
	} 
		 
} 
// Interface ---> Resizable for 3D 
interface Resizable
{
	public void resize();
	 
}
  //*********ThreeD**************// 
abstract class ThreeD implements Shape , Resizable
{
	protected ShapeColor sc;
	protected double a;
	
	public ThreeD()
	{
		sc = ShapeColor.Blue;
		a = 1.0;
		
	}
	public ThreeD (ShapeColor sc, double a )
	{
		this.sc = sc;
		this.a = a;
		
	}
	public double getA()
	{
		return a;
		
	}
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
			
	}
	 // Reduce by 10% from Original double value (a) 
	public void resize()
	{
		a = a * 0.9;
		
	}
	 //Volume Method 
	protected double volume() 
	{
		return 0.0;
	}
	
	@Override
	public String toString()
	{
		return String.format("");
	}
}
// Class Sphere 
class Sphere extends ThreeD
{
	public Sphere()
	{
		sc = ShapeColor.Blue;
		a = 1.0;
		
	}
	public Sphere( ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
		
	}
	public Sphere (Sphere s)
	{
		this(s.sc,s.a);
		
	}

	private double computeArea ()
	{
		return 4*Math.PI*a*a;
	}
	@Override
	public double area()
	{
		return this.computeArea();
	}
	
	private double computeVolume ()
	{
		return 4/3 * Math.PI * a*a*a;
	}
	@Override
	protected double volume()
	{
		return this.computeVolume();
		
	}
	public double getA()
	{
		return a;
		
	}
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	public String toString()
	{
		return String.format("%sSphere( 3D (%s,%.3f))",super.toString(),sc,a);
		
	}

}
 // Class --> Cube 
class Cube extends ThreeD
{
	public Cube ()
	{
		sc = ShapeColor.Blue;
		a = 1.0;
		
	}
	public Cube (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a ;
	
	}
	public Cube ( Cube c)
	{
		this(c.sc, c.a);
			
	}
	
	private double computeArea ()
	{
		return 6*(a*a); 
	}
	@Override
	public double area()
	{
		return this.computeArea();
		
	}
	
	private double computeVolume ()
	{
		return a*a*a;
	}
	@Override
	protected double volume()
	{
		return this.computeVolume();
		
	}
	public double getA()
	{
		return a;
	}
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
			
	}
	public String toString()
	{
		return String.format("%sCube( 3D (%s,%.3f))",super.toString(),sc,a);
	}

}
//Class Tetrahedron
class Tetrahedron extends ThreeD
{
	public Tetrahedron()
	{
		sc = ShapeColor.Blue;
		a = 1.0;
		
	}
	public Tetrahedron(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
		
	}
	public Tetrahedron(Tetrahedron t)
	{
		this(t.sc, t.a);
		
	}

	private double computeArea ()
	{
		return Math.sqrt(3)*(a*a);
	}
	@Override
	public double area()
	{
		return this.computeArea();
		
	}
	
	private double computeVolume ()
	{
		return (a*a*a)/(6*Math.sqrt(2));
	}
	@Override
	protected double volume()
	{
		return this.computeVolume();
		
	}
	public double getA()
	{
		return a;
			
	}
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
		
	}
	@Override
	public String toString()
	{
		return String.format("%sTetrahedron( 3D (%s,%.3f))",super.toString(),sc,a);
		
	} 
}
class A2
{
	private static int getInt()
	{		
		int k = (int) (Math.random () * 5) + 1;
		return k;
		
	}
	private static double getDouble()
	{
		double i = (int) (Math.random () * 5.0) + 1.5;
		return i;
	}
	private static ShapeColor getColor()
	{
		Random random = new Random();
	
		ShapeColor getColor = ShapeColor.values()[random.nextInt(ShapeColor.values().length)];
		return getColor;
		
	}
	private static boolean isTriangle( int a, int b, int c)
	{
	if((a+b)>c && (a+c)>b && (b+c)>a) 
        return true;
	else
		return false;
	
	}
	private static TwoD getTwoD()
	{
		int i = (int)((Math.random()* 4)+ 0.5);	
		int x, y, z;
		
		Circle c = new Circle (getColor(),getInt());
		Rectangle rc = new Rectangle (getColor(),getInt(), getInt());
		
		Trapezoid tr = new Trapezoid(getColor(), getInt(), getInt(), 
									 getInt(), getInt(), getInt());
									 					 
		while (true)
		{ 
			x = getInt();
			y = getInt();
			z = getInt();
			
			boolean b = isTriangle (x,y,z);    // Check isTriangle or not ! 
			if(b)
			{
				break;
			}
		}
		Triangle t = new Triangle (getColor(),x, y, z);
		
		switch(i)
		{
			case 1: return c;
			case 2: return rc;
			case 3: return t;
			case 4: return tr;
			default: return c;
		}
			
	}	
	private static ThreeD getThreeD()              
	{
		int i1 = (int)((Math.random()* 4)+ 0.5);	
		double d; 
		
		Sphere s = new Sphere (getColor(), getDouble());
		Cube cb = new Cube (getColor(), getDouble());
		Tetrahedron tt = new Tetrahedron (getColor(), getDouble());
		
		switch (i1)
		{
			case 1: return s;
			case 2: return cb;
			case 3: return tt;
			default : return cb;
		}							
	}				
	//display from alist
	private static void displayList (ArrayList <Shape> alist)
	{
		int count = 1;
		for (Shape s : alist)
		{
			if (count > 4)
				break;
			System.out.printf("Shape %d: ",count++);
			
			
			if (s instanceof Circle ||s instanceof Rectangle ||
				s instanceof Triangle ||s instanceof Trapezoid)
			{
				System.out.println(s);
				System.out.printf ("Area = %.3f%n", s.area ());
				
				if (s instanceof Circle )
			{
				System.out.printf("I am a %s shape%n", "Circle");
			} 
			else if ( s instanceof Triangle )
			{
				System.out.printf("I am a %s shape%n", "Triangle");
				
			}
			else if ( s instanceof Rectangle)
			{
				System.out.printf("I am a %s shape%n", "Rectangle");
			}

			else if ( s instanceof Trapezoid)
			{
				System.out.printf("I am a %s shape%n", "Trapezoid");	
			}
			
			System.out.println ("--------------------------------");
			
			}
			else                 // For 3D Objects 
			{
				System.out.println(s);                            // Print 3D Elements 
				System.out.printf ("Surface area = %.3f%n", s.area ()); // Print Area()
			if (s instanceof Sphere )
			{	
				Sphere ss = (Sphere)(s);
				System.out.printf("Volume = %.3f%n", ss.volume());
				ss.resize();
				System.out.printf("Size reduced by 10%% : %s%n",ss.toString());
				System.out.printf("Updated surface area = %.3f%n",ss.area());
				System.out.printf("Updated volume =  %.3f%n",ss.volume());
				System.out.printf("I am a %s shape%n","Sphere"); 
				
			} 
			else if (s instanceof Cube )
			{	
				Cube cc = (Cube)(s);
				System.out.printf("Volume = %.3f%n", cc.volume());
				cc.resize();
				System.out.printf("Size reduced by 10%% : %s%n",cc.toString());
				System.out.printf("Updated surface area = %.3f%n",cc.area());
				System.out.printf("Updated volume =  %.3f%n",cc.volume());
				System.out.printf("I am a %s shape%n","Cube"); 
				
			} 
			else 
			{
				Tetrahedron tt = (Tetrahedron)(s);
				System.out.printf("Volume = %.3f%n", tt.volume());
				tt.resize();
				System.out.printf("Size reduced by 10%%: %s%n",tt.toString());
				System.out.printf("Updated surface area = %.3f%n",tt.area());
				System.out.printf("Updated volume =  %.3f%n",tt.volume());
				System.out.printf("I am a %s shape%n","Tetrahedron"); 
			}
			
			System.out.println ("--------------------------------");
				
			}
		}
	}					
	public static void main ( String [] args)
	{	
		ArrayList <Shape> alist = new ArrayList <Shape> ();
	
		int k = 1;
		int i = 1;
		while ( k>0)
		{
			k = (int)(Math.random()*2+1);
			
			switch (k)
			{
				case 1: alist.add (getTwoD());
				case 2: alist.add (getThreeD());
				default: break;
			}
			if (i > 4)
				k = 0;
			i++;
		}
			
		displayList(alist);	
	}				
}





	
		


















