import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Packer {
    private static final int MAX_PACK_SIZE = 10;
    private List<Pack> packs = new ArrayList<>();

    public void processArticlesChain(String articlesChain) {
        List<Article> articles = getArticlesFromChain(articlesChain);
        Pack articlesNotYetPacked = new Pack(articles);

        Pack currentPack = new Pack();
        while (articlesNotYetPacked.getNumberOfArticles() > 0) {
            Article biggestArticleToFit = articlesNotYetPacked.getBiggestArticleToFit(MAX_PACK_SIZE - currentPack.getSize());
            if (biggestArticleToFit != null) {
                currentPack.add(biggestArticleToFit);
                articlesNotYetPacked.remove(biggestArticleToFit);
            } else {
                packs.add(currentPack);
                currentPack = new Pack();
            }
        }
        packs.add(currentPack);
    }

    private List<Article> getArticlesFromChain(String articlesChain) {
        List<Article> articles = new ArrayList<>();
        for (String articleSize : articlesChain.split("")) {
            Article article = new Article(Integer.parseInt(articleSize));
            articles.add(article);
        }
        return articles;
    }

    int getNumberOfPacks() {
        return packs.size();
    }

    @Override
    public String toString() {
        return packs.stream().map(Pack::toString).collect(Collectors.joining("/"));
    }
}
