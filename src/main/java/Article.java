public class Article {
    private final int size;

    Article(int size) {
        this.size = size;
    }

    int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
