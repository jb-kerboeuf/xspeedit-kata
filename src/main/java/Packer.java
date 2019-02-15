import java.util.ArrayList;
import java.util.List;

public class Packer {
    private static final int MAX_PACK_WEIGHT = 10;

    @Deprecated
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

    public String optimizedPacking(String articlesChain) {
        List<Integer> articlesWeights = getArticlesWeightsFromChain(articlesChain);
        List<Integer> articlesNotYetPacked = new ArrayList<>(articlesWeights);

        String packedChain = "";
        int packWeight = 0;

        while (articlesNotYetPacked.size() > 0) {
            int idealWeightToAdd = MAX_PACK_WEIGHT - packWeight;
            if (articlesNotYetPacked.contains(idealWeightToAdd)) {
                packedChain += idealWeightToAdd + "/";
                packWeight = 0;
                articlesNotYetPacked.remove(Integer.valueOf(idealWeightToAdd));
                continue;
            }
            int articleWeight = articlesNotYetPacked.get(0);
            if (packWeight + articleWeight <= MAX_PACK_WEIGHT) {
                packedChain += articleWeight;
                packWeight += articleWeight;
                articlesNotYetPacked.remove(Integer.valueOf(articleWeight));
                continue;
            }
            packedChain += "/";
            packWeight = 0;
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
