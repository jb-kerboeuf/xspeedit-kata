import java.util.ArrayList;
import java.util.List;

public class Packer {

    private static final int MAX_PACK_WEIGHT = 10;

    public String standardPacking(String articlesChain) {
        List<Integer> articlesWeights = getArticlesWeightsFromChain(articlesChain);

        String packedChain = "";
        int packWeight = 0;
        for (int articleWeight : articlesWeights) {
            if (packWeight + articleWeight > MAX_PACK_WEIGHT) {
                packedChain += "/";
                packWeight = 0;
            }
            packWeight += articleWeight;
            packedChain += articleWeight;
        }
        return packedChain;
    }

    private List<Integer> getArticlesWeightsFromChain(String articlesChain) {
        List<Integer> articlesWeights = new ArrayList<>();
        for (String article : articlesChain.split("")) {
            articlesWeights.add(Integer.parseInt(article));
        }
        return articlesWeights;
    }
}
