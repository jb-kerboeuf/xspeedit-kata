import java.util.ArrayList;
import java.util.List;

public class Pack {
    private List<Article> articles;
    private int size = 0;

    Pack() {
        this(new ArrayList<>());
    }

    Pack(List<Article> articles) {
        this.articles = articles;
        for (Article article : articles) {
            size += article.getSize();
        }
    }

    void add(Article article) {
        articles.add(article);
        size += article.getSize();
    }

    void remove(Article article) {
        articles.remove(article);
        size -= article.getSize();
    }

    int getNumberOfArticles() {
        return articles.size();
    }

    int getSize() {
        return size;
    }

    private Article getArticleOfSize(int size) {
        for (Article article : articles) {
            if (article.getSize() == size) {
                return article;
            }
        }
        return null;
    }

    Article getBiggestArticleToFit(int max) {
        for (int size = max; size > 0; size--) {
            Article article = getArticleOfSize(size);
            if (article != null) {
                return article;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        for (Article article : articles) {
            str += article.toString();
        }
        return str;
    }
}
