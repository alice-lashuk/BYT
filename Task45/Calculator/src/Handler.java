public interface Handler {
    void setNextHandler(Handler handler);
    void solve(Request req);
}
