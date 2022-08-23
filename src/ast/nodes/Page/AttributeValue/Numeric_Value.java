package ast.nodes.Page.AttributeValue;

public class Numeric_Value extends Literal_Value<Float> {

    @Override
    public String toHtml() {
        float fValue = value;
        if (fValue == (int) fValue)
            return String.format("%d", (int) fValue);
        else
            return String.format("%s", fValue);
    }

    @Override
    public String codeGenerate() {
        float fValue = value;
        if (fValue == (int) fValue)
            return String.format("%d", (int) fValue);
        else
            return String.format("%s", fValue);
    }
}
