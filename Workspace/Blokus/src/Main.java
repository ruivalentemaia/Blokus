import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import jp.co.csk.vdm.toolbox.VDM.CGException;
import quotes.blue;
import quotes.empty;
import quotes.green;
import quotes.red;
import quotes.yellow;

//TODO: Played all tiles +15 if last tile was monomino +20
//TODO: END GAME
//TODO: Player quits but the other can continue

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static Game g;
	private static int nPlayers = 0;
	private static HashMap <Object, ArrayList<Integer>> playedTiles;
	private static int tileNumber = -1;
	
	public static void printBoard() throws CGException {
		
		System.out.println("Scoreboard");

		Object[] keys = g.getScore().keySet().toArray();
		
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] instanceof blue)
				System.out.println(keys[i] + ": " + g.getScore().get(keys[i]));
			
			if (keys[i] instanceof yellow)
				System.out.println(keys[i] + ": " + g.getScore().get(keys[i]));
			
			if (keys[i] instanceof red  && nPlayers == 3)
				System.out.println(keys[i] + ": " + g.getScore().get(keys[i]));
			
			if (keys[i] instanceof green && nPlayers == 4)
				System.out.println(keys[i] + ": " + g.getScore().get(keys[i]));
		}
		
	    
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------+");
		for (int y = 0; y < 20 ; y++) {
			System.out.print("|");
			for (int x = 0; x < 20 ; x++) {
				Object o = g.getBoard().get(new Utilities.Pos(x,y)); 
				if ( o instanceof empty) {
					if (x < 10)
						System.out.print( " " + x + "-");
					else
						System.out.print( "" + x + "-");
					
					if (y < 10)
						System.out.print(y + " |");
					else
						System.out.print(y + "|");

				}
				else if ( o instanceof blue)
					System.out.print("  B  |");
				else if ( o instanceof yellow)
					System.out.print("  Y  |");
				else if ( o instanceof red)
					System.out.print("  R  |");
				else if ( o instanceof green)
					System.out.print("  G  |");
			}
			System.out.println();
			if (y+1 != 20)
				System.out.println("|-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----|");//System.out.println("|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
			
		}
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------+");
		System.out.println();
	}
	
	public static void printTile(Tile t) throws CGException {
		System.out.println("+-------------------+");
		;
		for (int y = 0; y < 5; y++) {
			System.out.print("|");
			for (int x = 0; x < 5; x++) {
				if ( t.getShape().contains(new Utilities.Pos(x,y)) ) {
					System.out.print(" * |");
				}
				else
					System.out.print("   |");

			}
			System.out.println();
			if (y+1 != 5)
				System.out.println("|---+---+---+---+---|");
		}
		System.out.println("+-------------------+");
	}
	
	public static int splashScreen() {
		
		System.out.println("    ____   __    ____   __ __ __  __ _____");
		System.out.println("   / __ ) / /   / __ \\ / //_// / / // ___/");
		System.out.println("  / __  |/ /   / / / // ,<  / / / / \\__ \\");
		System.out.println(" / /_/ // /___/ /_/ // /| |/ /_/ / ___/ /");
		System.out.println("/_____//_____/\\____//_/ |_|\\____/ /____/");
		
		int nPlayers = -1;
		
		do {
    		System.out.println("\t2-4 - Choose number of players");
            System.out.println("\t0   - Quit BLOKUS");
            System.out.print("Option :> ");
            String line = "";
            
            line = sc.nextLine();
			if (line.isEmpty() || !line.matches("[0-4]"))
	            continue;
			
			nPlayers = Integer.parseInt(line);
	        
	        if (nPlayers == 0)
	            break;
	        
		} while (nPlayers > 5 || nPlayers < 2 );
		
		return nPlayers;
	}
	
	public static Tile chooseTile () throws CGException {
		
		ArrayList<Integer> pt = playedTiles.get(g.getTurn());
		for (int i = 0; i < g.getTiles().size(); i++) {
			if (!pt.contains(i)) {
				System.out.println("Tile " + i);
				printTile((Tile)g.getTiles().get(i));
			}
		}

		do {
	        System.out.print("Choose Tile :> ");
	        
	        String line = sc.nextLine();
			if (line.isEmpty() || !line.matches("[0-9]*"))
	            continue;
			
			tileNumber = Integer.parseInt(line);
		} while (tileNumber < 0 || tileNumber > g.getTiles().size() || pt.contains(tileNumber));
		
        Tile auxTile = (Tile) g.getTiles().get(tileNumber);
        Tile tile = new Tile(auxTile.getShape(), auxTile.getShape());
		return tile;
	}
	
	public static Integer[] readPosition() {
		
		int x = -1, y = -1;
		do {
			String line = "";
            System.out.print("x-y :> ");		            
            line = sc.nextLine();
            
			if (line.isEmpty() || !line.matches("[0-9]{1,2}-[0-9]{1,2}") )
				return new Integer[]{-1,-1};
			
			String[] pos = line.split("-");
			x = Integer.parseInt(pos[0]);
			y = Integer.parseInt(pos[1]);

		} while ( x > 20 || y > 20  || x < 0 || y < 0);
		
		return new Integer[]{x,y};
	}

	static void placeTile(Tile tile) throws CGException {
		
		int opt = -1;
		do {
			printBoard();
			String line = "";
			do {
				printTile(tile);
				System.out.println("\t0 - Leave");
				System.out.println("\t1 - Choose coordinates");
				System.out.println("\t2 - Rotate");
	            System.out.println("\t3 - Invert");
	            System.out.print("Opcao :> ");		
	            
	            
	            line = sc.nextLine();
	            
				if (line.isEmpty() || !line.matches("[0-9]") )
		            continue;
				
				opt = Integer.parseInt(line);		
	
			} while (opt > 3 || opt < 0 );
			
			if (opt == 0)
				break;
			else if (opt == 1) {
				
				do {
					Integer[] pos = readPosition();
					if (pos[0] == -1)
						break;
					
					Utilities.Pos d = new Utilities.Pos(pos[0], pos[1]);
					if ( (Integer)g.getScore().get(g.getTurn()) == 0 ) {
						
						if (g.validCorner(tile, d)) {
							g.placeFirstTile(tile, g.getTurn(), d);
							playedTiles.get(g.getTurn()).add(tileNumber);
							g.updateScore(tile, g.getTurn());
							break;
						}
						else
							System.out.println("Invalid corner");
					}
					else {
						
						if (g.validPosition(tile, g.getTurn(), d) ) {
							g.placeTile(tile, g.getTurn(), d);
							playedTiles.get(g.getTurn()).add(tileNumber);
							g.updateScore(tile, g.getTurn());
							break;
						}
						else
							System.out.println("Invalid position");
					}
					
				} while (true);
				break;
			}
			else if (opt == 2)
				tile.rotate();
			else if (opt == 3)
				tile.invert();
			
		} while(opt != 0);
	}
	
	private static void initializedPlayedTiles() throws CGException {
		playedTiles = new HashMap <Object, ArrayList<Integer>>();
		
		Object[] keys = g.getScore().keySet().toArray();
		
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] instanceof blue)
				playedTiles.put(keys[i], new ArrayList<Integer>());
			
			if (keys[i] instanceof yellow)
				playedTiles.put(keys[i], new ArrayList<Integer>());
			
			if (keys[i] instanceof red  && nPlayers == 3)
				playedTiles.put(keys[i], new ArrayList<Integer>());
			
			if (keys[i] instanceof green && nPlayers == 4)
				playedTiles.put(keys[i], new ArrayList<Integer>());
		}
	}
	
	public static void main(String[] args) throws CGException {
			
		while (true) {

			nPlayers = splashScreen();

	        if (nPlayers == 0)
	            break;

			g = new Game(nPlayers);
			
			initializedPlayedTiles();
			
			String line = "";
			Tile tile = null;
			while (true) {
				printBoard();
				
				int opt = -1;
				
				System.out.println(g.getTurn().toString() + " turn!");
				
				System.out.println("\t0 - Leave game");
				System.out.println("\t1 - Place a tile");
				System.out.println("\t2 - Skip turn");
                System.out.print("Opcao :> ");
                
                line = sc.nextLine();
    			if (line.isEmpty() || !line.matches("[0-9]"))
    	            continue;

    			opt = Integer.parseInt(line);
    			
    			if (opt == 0)
    				break;
    			else if (opt == 1) {
    				tile = chooseTile();
    				placeTile(tile);
    				tile = null;
    			}
    			else if (opt == 2)
    				g.changeTurn();
			}

		}
		
	}
}
