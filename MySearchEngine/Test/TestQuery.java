import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestQuery {
	public static void main(String[] args) {
		String RawPath = "RAW";
		String urlPath = "url.txt";
		String GraphPath = "WebGraph.txt";
		
		PreProcess pp = new PreProcess(RawPath, urlPath, GraphPath);
		
		HashMap<String, Integer> nodeMapping = pp.getNodeMapping();
		String[] nodeNames = pp.getNodeNames();
		
		double[] pageRank= pp.getPageRank();
		
		HashMap<String, Integer> termMapping= pp.getTermMapping();
		HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> posting = pp.getPostingList();
		
		double[] l2NormVd = pp.getl2NormVd();
		
		QueryProcessor qp = new QueryProcessor(nodeMapping, termMapping, posting, nodeNames, l2NormVd, pageRank);
		qp.topKDocs("japanese cloth", 10);
	}
}
