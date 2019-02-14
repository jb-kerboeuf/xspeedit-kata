import java.util.ArrayList;
import java.util.List;

public class Packer {
    public String pack(String articlesChain) {
        List<Integer> articlesWeights = new ArrayList<>();
        for (String article : articlesChain.split("")) {
            articlesWeights.add(Integer.parseInt(article));
        }
        String packedChain = "";
        int sum = 0;
        for (int articleWeight : articlesWeights) {
            sum += articleWeight;
            if (sum > 10) {
                packedChain += "/";
                sum = articleWeight;
            }
            packedChain += articleWeight;
        }
        return packedChain;
    }
}
