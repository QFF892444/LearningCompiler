import java.util.HashMap;

/**
 * Created by abc84 on 2016/5/12.
 */
/*
词法分析
 */
public class ListLexer extends Lexer {

    public ListLexer(String s) {
        super(s);
    }

    @Override
    public Token nextToken() {
        while (currentChar != EOF) {
            //System.out.println(currentChar);
            switch (currentChar) {
                case ' ':case '\n':case '\t':case '\r':ignore();continue;
                case '[':comsume();return new Token(LBRACKT, "[");
                case ']':comsume();return new Token(RBRACKT, "]");
                case ',':comsume();return new Token(COMMA, ",");
                case '=':comsume();return new Token(Equal, "=");
                default:
                    if (isLetter()) {//字母的话继续一直到成为一个名字
                        return Name();
                    }
                    else throw new Error("invalid char:" + currentChar);
            }
        }
        return new Token(EOF_TYPE, "<EOF>");
    }
    public void match(char x) {
        if (x == currentChar){
            comsume();
            return;
        }
        throw new Error("expecting " + x + " found " +currentChar);
    }
    private Token Name() {//"[a-z|A-Z]+"
        StringBuffer buffer = new StringBuffer();
        while (isLetter()) {//直到不为字母
            buffer.append(currentChar);
            comsume();//跳到下一个
        }
        return new Token(NAME, buffer.toString());
    }





    @Override
    public String getTokenName(int i) {
        return typeToName.get(i);
    }



    public static void main(String[] args) {
        ListLexer lexer = new ListLexer("[a,b] = [c,d]");
        Token t = lexer.nextToken();
        while (t.type != EOF_TYPE) {
            System.out.println(t);
            t = lexer.nextToken();
        }
        System.out.println(t);
    }
}
