import java.util.ArrayList;
import java.util.HashMap;

public class PreProcess {
	private Graph G;
	int N;
	double[] pageRank;
	private HashMap<String, Integer> termMapping;
	private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> posting;
	private double[] l2NormVd;
	
	PreProcess(String RawPath, String urlPath, String GraphPath){
		G = new Graph("url.txt", "WebGraph.txt");
		PageRank pr = new PageRank(G, 0.001, 0.85);
		pageRank = pr.getPageRank();
		PositionalIndex pi = new PositionalIndex(RawPath, G);
		termMapping = pi.getTermMapping();
		l2NormVd = pi.getl2NormVd();
		posting = pi.getPostingList();
	}
	
	public double[] getPageRank(){
		return pageRank;
	}
	public HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> getPostingList(){
		return posting;
	}
	public double[]getl2NormVd(){
		return l2NormVd;
	}
	public HashMap<String, Integer> getMapping() {
		return G.getMapping();
	}
	public String[] getNodeNames() {
		return G.getNodeNames();
	}
	public HashMap<String, Integer> getTermMapping() {
		return termMapping;
	}
	public HashMap<String, Integer> getNodeMapping() {
		return G.getMapping();
	}
}
