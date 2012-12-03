import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Pair> figure = new ArrayList<Pair>();
		
		//figura 21
		figure.add(new Pair(1,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,1));
		figure.add(new Pair(2,1));
		figure.add(new Pair(3,1));
		
		
		/*
		//figura 1
		figure.add(new Pair(0,0));
		
		//figura 2
		figure.add(new Pair(0,0));
		figure.add(new Pair(1,0));
		
		//figura 3
		figure.add(new Pair(0,0));
		figure.add(new Pair(1,0));
		figure.add(new Pair(1,1));
		
		//figura 4
		figure.add(new Pair(0,0));
		figure.add(new Pair(1,0));
		figure.add(new Pair(2,0));
		
		//figura 5
		figure.add(new Pair(0,0));
		figure.add(new Pair(1,0));
		figure.add(new Pair(1,1));
		figure.add(new Pair(0,1));
		
		//figura 6
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,1));
		figure.add(new Pair(1,0));
		figure.add(new Pair(2,1));
		
		//figura 7
		figure.add(new Pair(0,0));
		figure.add(new Pair(1,0));
		figure.add(new Pair(2,0));
		figure.add(new Pair(3,0));
		
		//figura 8
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,1));
		figure.add(new Pair(2,1));
		figure.add(new Pair(2,0));
		
		//figura 9
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,0));
		figure.add(new Pair(1,1));
		figure.add(new Pair(2,0));
		
		//figura 10
		figure.add(new Pair(0,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,1));
		figure.add(new Pair(2,1));
		figure.add(new Pair(3,1));
		
		//figura 11
		figure.add(new Pair(0,2));
		figure.add(new Pair(1,0));
		figure.add(new Pair(1,1));
		figure.add(new Pair(1,2));
		figure.add(new Pair(2,2));
		
		//figura 12
		figure.add(new Pair(0,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(0,2));
		figure.add(new Pair(1,2));
		figure.add(new Pair(2,2));
		
		//figura 13
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,0));
		figure.add(new Pair(1,1));
		figure.add(new Pair(2,0));
		figure.add(new Pair(3,0))
		
		//figura 14
		figure.add(new Pair(0,1));
		figure.add(new Pair(0,2));
		figure.add(new Pair(1,1));
		figure.add(new Pair(2,1));
		figure.add(new Pair(2,0));
		
		//figura 15
		figure.add(new Pair(0,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(0,2));
		figure.add(new Pair(0,3));
		figure.add(new Pair(0,4));
		
		//figura 16
		figure.add(new Pair(0,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(0,2));
		figure.add(new Pair(1,0));
		figure.add(new Pair(1,1));
		
		//figura 17
		figure.add(new Pair(1,0));
		figure.add(new Pair(2,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(0,2));
		figure.add(new Pair(1,1));
		
		//figura 18
		figure.add(new Pair(0,0));
		figure.add(new Pair(1,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(0,2));
		figure.add(new Pair(1,2));
		
		//figura 19
		figure.add(new Pair(1,0));
		figure.add(new Pair(2,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,1));
		figure.add(new Pair(1,2));
		
		//figura 20
		figure.add(new Pair(1,0));
		figure.add(new Pair(2,1));
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,1));
		figure.add(new Pair(1,2));
		
		//figura 21
		figure.add(new Pair(1,0));
		figure.add(new Pair(0,1));
		figure.add(new Pair(1,1));
		figure.add(new Pair(2,1));
		figure.add(new Pair(3,1));
		
		*/
		//variaveis de transformacao
		int maxX = 0, maxY = 0, newMaxY = 0, newMaxX = 0;
		
		for (int i = 0; i< 5; i++) {
			
			System.out.println("----------------------------------------");
			for (int y = 0; y < 6; y++) {
	
				for (int x = 0; x < 6; x++) {
					Pair p = new Pair(x, y);
					if (figure.contains(p)) {
						System.out.print(" * |");
						if (p.x > maxX)
							maxX = p.x;
						
						if (p.y > maxY)
							maxY = p.y;
					}
					else
						System.out.print("   |");
	
				}
				System.out.println();
				System.out.println("----------------------------------------");
			}

			System.out.println("MIRROR");

			ArrayList<Pair> figureM = new ArrayList<Pair>();
			for (Pair p : figure) {
				figureM.add( new Pair(p.x, maxY-p.y ));
			}

			
			System.out.println("----------------------------------------");
			for (int y = 0; y < 10; y++) {
	
				for (int x = 0; x < 10; x++) {
					if (figureM.contains(new Pair(x, y)))
						System.out.print(" * |");
					else
						System.out.print("   |");
	
				}
				System.out.println();
				System.out.println("----------------------------------------");
			}

			System.out.println("ROTATION " + (i+1));
			ArrayList<Pair> newFigure = new ArrayList<Pair>();
			int shift = 0;
			for (Pair p : figure) {
				
				int newY = 1-(p.x -(maxX-2));
				
				newFigure.add( new Pair(p.y, newY));
				
				if (newY < shift)
					shift = newY;
				
				if (p.y > newMaxX)
					newMaxX = p.y;
				
				if (newY > newMaxY)
					newMaxY = newY;

			}
			
			if (shift < 0) {
				//System.out.println("----------------------------------------");
				ArrayList<Pair> newFigureAux = new ArrayList<Pair>();	
				for (Pair p : newFigure) {
					int newy = p.y-shift;
				
					newFigureAux.add( new Pair(p.x, newy));
					
				
					if (p.x > newMaxX)
						newMaxX = p.x;//newMaxX = p.y+1;
					
					if (newy > newMaxY)
						newMaxY = newy;
				}
				newFigure = newFigureAux;
			}
			
			figure = newFigure;
			maxY=newMaxY;
			maxX = newMaxX;
			newMaxX = 0;
			newMaxY = 0;
			shift = 0;
		}
		
	}

}