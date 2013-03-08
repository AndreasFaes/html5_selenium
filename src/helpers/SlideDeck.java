package helpers;

/**
 * Abstraction of the site as a slide deck. Just so that
 * I wouldn't always have to type the full path.
 * 
 * Warning: test becomes slow because the site is quite 
 * 'heavy' to load the first time. At the BTD, I had it on
 * my local drive which sped things up. It's not optimized 
 * for the web, nor was that the intention. :)
 * 
 * @author afaes
 *
 */
public class SlideDeck {
	public static String slide(int slide){
		return "http://www.testgames.be/html5/index.html?theme=night#/" + slide;
	}
}
