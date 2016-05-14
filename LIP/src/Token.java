/**
 * Created by abc84 on 2016/5/12.
 */
public class Token {
    int type;
    private String text;
    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }
    public String rep() {//representation
        return text;
    }
    @Override
    public String toString() {
        return "<" + text + " " +Lexer.typeToName.get(type) + ">";
    }
}
